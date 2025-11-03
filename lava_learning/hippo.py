"""
make_submission.py

Erstellt die Abgabe-PDF und die Quellcode-ZIP für Übung 4.

Output:
 - Uebung4_Loesungen.pdf  (enthält alle Lösungen + Quellcode)
 - Uebung4_Source.zip     (enthält alle Quellcodedateien / Projekt, die PDF ist **nicht** in der ZIP)

Usage:
  python make_submission.py /path/to/project_root

Dependencies:
  pip install pillow reportlab PyPDF2
  Optional: LibreOffice (soffice) for converting Office files to PDF.

"""
from __future__ import annotations
import sys
import os
import shutil
import tempfile
import subprocess
from pathlib import Path
from typing import List

try:
  from reportlab.lib.pagesizes import A4
  from reportlab.pdfgen import canvas
  from reportlab.lib.units import mm
except Exception:
  raise SystemExit('Missing reportlab. Install with: pip install reportlab')

try:
  from PIL import Image
except Exception:
  raise SystemExit('Missing Pillow. Install with: pip install pillow')

try:
  from PyPDF2 import PdfReader, PdfWriter
except Exception:
  raise SystemExit('Missing PyPDF2. Install with: pip install PyPDF2')

IMAGE_EXTS = {'.jpg', '.jpeg', '.png', '.tiff', '.tif', '.bmp', '.gif'}
PDF_EXTS = {'.pdf'}
CODE_EXTS = {'.py', '.c', '.cpp', '.h', '.hpp', '.java', '.js', '.ts', '.go', '.rs', '.swift', '.kt', '.kts', '.scala', '.sh', '.bash', '.ps1', '.html', '.css', '.json', '.xml', '.md', '.txt'}
OFFICE_EXTS = {'.doc', '.docx', '.odt', '.ppt', '.pptx', '.xls', '.xlsx', '.rtf', '.html', '.htm'}

SOFFICE_CMD = shutil.which('soffice') or shutil.which('libreoffice')


def render_code_to_pdf(src: Path, c: canvas.Canvas, page_size=A4, margin_mm=15) -> None:
  """Schreibe den Quellcode aus src in den übergebenen ReportLab-Canvas.
  Dabei werden mehrere Seiten erzeugt falls nötig."""
  width, height = page_size
  left = margin_mm * mm
  right = width - margin_mm * mm
  top = height - margin_mm * mm
  bottom = margin_mm * mm
  line_height = 9  # pt
  font_name = 'Courier'
  font_size = 9
  c.setFont(font_name, font_size)

  text = src.read_text(encoding='utf-8', errors='replace').splitlines()
  # Header
  c.setFont('Helvetica-Bold', 11)
  c.drawString(left, top, f'File: {src.relative_to(Path.cwd())}')
  c.setFont(font_name, font_size)
  y = top - 16

  for lineno, line in enumerate(text, start=1):
    # einfache Zeilenlänge-Begrenzung — Umbruch wenn nötig
    max_chars = int((right - left) / (font_size * 0.6))
    parts = [line[i:i+max_chars] for i in range(0, len(line), max_chars)] or ['']
    for part in parts:
      if y < bottom + line_height:
        c.showPage()
        c.setFont('Helvetica-Bold', 11)
        c.drawString(left, top, f'File: {src.relative_to(Path.cwd())} (fortgesetzt)')
        c.setFont(font_name, font_size)
        y = top - 16
      c.drawString(left, y, f'{lineno:4d}: {part}')
      y -= line_height
  c.showPage()


def image_to_pdf_pages(img_path: Path, out_pdf_path: Path, page_size=A4, margin_mm=12) -> None:
  """Konvertiert ein Bild in ein PDF mit einer Seite (angepasst an A4)."""
  img = Image.open(img_path)
  img_width, img_height = img.size
  # Fit into A4 with margins, keep aspect ratio
  page_w_pt, page_h_pt = page_size
  margin = margin_mm * mm
  max_w = page_w_pt - 2 * margin
  max_h = page_h_pt - 2 * margin
  scale = min(max_w / img_width, max_h / img_height, 1.0)
  new_w = int(img_width * scale)
  new_h = int(img_height * scale)
  img = img.resize((new_w, new_h), Image.LANCZOS)
  # Save temporarily
  img.convert('RGB').save(out_pdf_path, 'PDF', resolution=100.0)


def merge_pdfs(pdf_paths: List[Path], out_path: Path) -> None:
  writer = PdfWriter()
  for p in pdf_paths:
    try:
      r = PdfReader(str(p))
      for page in r.pages:
        writer.add_page(page)
    except Exception as e:
      print(f'Warning: could not read PDF {p}: {e}')
  with open(out_path, 'wb') as f:
    writer.write(f)


def convert_office_to_pdf(src: Path, dst_dir: Path) -> Path | None:
  if not SOFFICE_CMD:
    return None
  try:
    subprocess.run([
      SOFFICE_CMD,
      '--headless',
      '--convert-to', 'pdf',
      '--outdir', str(dst_dir),
      str(src)
    ], check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    out_pdf = dst_dir / (src.stem + '.pdf')
    return out_pdf if out_pdf.exists() else None
  except Exception:
    return None


def create_combined_pdf(root: Path, out_pdf: Path) -> None:
  tmpdir = Path(tempfile.mkdtemp(prefix='ue4_pdf_'))
  try:
    parts: List[Path] = []
    # Walk in deterministic order
    for dirpath, dirnames, filenames in os.walk(root):
      dirnames.sort()
      filenames.sort()
      dirpath = Path(dirpath)
      # Add a title page for the folder
      title_pdf = tmpdir / f'title_{len(parts)}.pdf'
      c = canvas.Canvas(str(title_pdf), pagesize=A4)
      c.setFont('Helvetica-Bold', 20)
      c.drawCentredString(A4[0] / 2, A4[1] - 80, f'Folder: {dirpath.relative_to(root)}')
      c.showPage()
      c.save()
      parts.append(title_pdf)

      for fname in filenames:
        p = dirpath / fname
        ext = p.suffix.lower()
        if ext in CODE_EXTS:
          # render code into its own temporary PDF
          code_pdf = tmpdir / (p.stem + '_' + str(len(parts)) + '.pdf')
          c = canvas.Canvas(str(code_pdf), pagesize=A4)
          render_code_to_pdf(p, c)
          parts.append(code_pdf)
        elif ext in IMAGE_EXTS:
          img_pdf = tmpdir / (p.stem + '_' + str(len(parts)) + '.pdf')
          image_to_pdf_pages(p, img_pdf)
          parts.append(img_pdf)
        elif ext in PDF_EXTS:
          parts.append(p)
        elif ext in OFFICE_EXTS:
          conv = convert_office_to_pdf(p, tmpdir)
          if conv:
            parts.append(conv)
          else:
            # create a small placeholder page mentioning the missing conversion
            ph = tmpdir / (p.stem + '_note.pdf')
            c = canvas.Canvas(str(ph), pagesize=A4)
            c.setFont('Helvetica', 12)
            c.drawString(40, A4[1] - 80, f'File: {p.relative_to(root)}')
            c.drawString(40, A4[1] - 100, 'Note: office conversion not available (soffice missing).')
            c.showPage(); c.save()
            parts.append(ph)
        else:
          # unknown filetype: include filename as note
          ph = tmpdir / (p.stem + '_note.pdf')
          c = canvas.Canvas(str(ph), pagesize=A4)
          c.setFont('Helvetica', 12)
          c.drawString(40, A4[1] - 80, f'File: {p.relative_to(root)}')
          c.drawString(40, A4[1] - 100, 'Note: file type not embedded into PDF.')
          c.showPage(); c.save()
          parts.append(ph)

    # Merge all parts
    merge_pdfs(parts, out_pdf)
    print(f'Created PDF: {out_pdf}')
  finally:
    shutil.rmtree(tmpdir, ignore_errors=True)


def make_zip(root: Path, zip_path: Path, exclude: List[Path] | None = None) -> None:
  exclude = exclude or []
  exclude_set = {p.resolve() for p in exclude}
  base_name = zip_path.with_suffix('').as_posix()
  # Build a temporary folder copying everything except excluded paths
  tmpd = Path(tempfile.mkdtemp(prefix='ue4_zip_'))
  try:
    for dirpath, dirnames, filenames in os.walk(root):
      rel_dir = Path(dirpath).relative_to(root)
      target_dir = tmpd / rel_dir
      target_dir.mkdir(parents=True, exist_ok=True)
      for fname in filenames:
        src = Path(dirpath) / fname
        if src.resolve() in exclude_set:
          continue
        # copy file preserving structure
        shutil.copy2(src, target_dir / fname)
    shutil.make_archive(base_name, 'zip', root_dir=tmpd)
    # shutil.make_archive appends .zip
    real_zip = Path(base_name + '.zip')
    shutil.move(real_zip, zip_path)
    print(f'Created ZIP: {zip_path}')
  finally:
    shutil.rmtree(tmpd, ignore_errors=True)


def main(argv: List[str]) -> int:
  if len(argv) < 2:
    print('Usage: python make_submission.py /path/to/project_root')
    return 1
  root = Path(argv[1]).resolve()
  if not root.exists() or not root.is_dir():
    print('Error: project root does not exist or is not a directory')
    return 1

  out_pdf = root / 'Uebung4_Loesungen.pdf'
  out_zip = root / 'Uebung4_Source.zip'

  # Create combined PDF
  create_combined_pdf(root, out_pdf)

  # Create ZIP excluding the PDF
  make_zip(root, out_zip, exclude=[out_pdf])

  print('\nFertig. Bitte prüfen Sie, ob Uebung4_Loesungen.pdf neben Uebung4_Source.zip liegt und')
  print('die PDF nicht innerhalb der ZIP ist.')
  return 0

if __name__ == '__main__':
  raise SystemExit(main(sys.argv))


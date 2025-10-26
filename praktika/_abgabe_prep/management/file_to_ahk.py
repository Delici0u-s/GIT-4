# file_to_ahk.py
import sys
from pathlib import Path


def is_escaped(line, i):
    """Return True if the character at position i is escaped by an odd number of backslashes."""
    count = 0
    j = i - 1
    while j >= 0 and line[j] == "\\":
        count += 1
        j -= 1
    return count % 2 == 1


def process_line(line):
    """
    Replace actual tab characters with four spaces only when not inside a string literal.
    String literals are detected by double quotes (") with proper handling of escaped quotes.
    """
    result = ""
    in_string = False
    i = 0
    while i < len(line):
        c = line[i]
        if c == '"' and not is_escaped(line, i):
            in_string = not in_string
            result += c
        elif c == "\t":
            if not in_string:
                result += "    "  # Replace actual tab with 4 spaces
            else:
                result += c  # Leave tab alone inside a string literal
        else:
            result += c
        i += 1
    return result


def txt_to_ahk(input_file, output_file):
    try:
        input_path = Path(input_file)
        output_path = Path(output_file)

        # Ensure parent directories exist
        if output_path.parent and not output_path.parent.exists():
            output_path.parent.mkdir(parents=True, exist_ok=True)

        with input_path.open("r", encoding="utf-8") as f:
            lines = f.readlines()

        with output_path.open("w", encoding="utf-8") as f:
            # Add header comments and initial delay
            f.write("; Auto-generated AutoHotkey script\n")
            f.write(
                "; Wait 5 seconds before starting to allow you to focus the remote window\n"
            )
            f.write("Sleep, 5000\n")
            f.write("SetKeyDelay, 0  ; Set typing speed\n")
            f.write("\n")

            # Process each line from the input file
            for line in lines:
                line = line.removesuffix("\n")
                # Process the line to fix tabbing outside string literals
                line = process_line(line)
                # Escape characters that AHK might misinterpret
                line = line.replace("%", "`%")
                line = line.replace("{", "`{").replace("}", "`}")

                if line:
                    f.write(f"Send {{Text}}{line}\n")
                f.write("Send {Enter}\n")
                f.write("Sleep, 10\n")

            # End the script after sending all lines
            f.write("\nExitApp\n")

        print(f"Converted {input_file} to AutoHotkey script: {output_file}")
    except Exception as e:
        print(f"Error: {e}")


if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python file_to_ahk.py input.txt output.ahk")
    else:
        txt_to_ahk(sys.argv[1], sys.argv[2])

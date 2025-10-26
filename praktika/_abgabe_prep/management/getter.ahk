; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 10  ; Set typing speed

Send {Text}#include <stdio.h>
Send {Enter}
Sleep, 10
Send {Text}#include <stdlib.h>
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}int main(int argc, char *argv[]) `{
Send {Enter}
Sleep, 10
Send {Text}    FILE *fp;
Send {Enter}
Sleep, 10
Send {Text}    char buffer[1024];
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    if (argc < 2) `{
Send {Enter}
Sleep, 10
Send {Text}        fprintf(stderr, "Usage: `%s <output_file>\n", argv[0]);
Send {Enter}
Sleep, 10
Send {Text}        return 1;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    fp = fopen(argv[1], "w");
Send {Enter}
Sleep, 10
Send {Text}    if (fp == NULL) `{
Send {Enter}
Sleep, 10
Send {Text}        perror("Error opening file");
Send {Enter}
Sleep, 10
Send {Text}        return 1;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    printf("Enter text (Ctrl+D to end on Linux/macOS, Ctrl+Z then Enter on Windows):\n");
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    while (fgets(buffer, sizeof(buffer), stdin) != NULL) `{
Send {Enter}
Sleep, 10
Send {Text}        fputs(buffer, fp);
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    fclose(fp);
Send {Enter}
Sleep, 10
Send {Text}    printf("Input written to `%s\n", argv[1]);
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    return 0;
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10

ExitApp

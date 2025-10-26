#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    FILE *fp;
    char buffer[1024];

    if (argc < 2) {
        fprintf(stderr, "Usage: %s <output_file>\n", argv[0]);
        return 1;
    }

    fp = fopen(argv[1], "w");
    if (fp == NULL) {
        perror("Error opening file");
        return 1;
    }

    printf("Enter text (Ctrl+D to end on Linux/macOS, Ctrl+Z then Enter on Windows):\n");

    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        fputs(buffer, fp);
    }

    fclose(fp);
    printf("Input written to %s\n", argv[1]);

    return 0;
}


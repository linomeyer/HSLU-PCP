#include <stdio.h>

static void printNumbersGoto(int n) {
    int num = 0;
    jump:
        if (num <= n) {
            printf("%d ", num++);
            goto jump;
        }
}

static void printNumbersFor(int n) {
    for (int i = 0; i <= n; i++) printf("%d ", i);
}

static void printNumbersRecursiveFunction(int n) {
    if (n < 0) return;
    printNumbersRecursiveFunction(n - 1);
    printf("%d ", n);
}

static void printReverseNumbersRecursiveFunction(int n) {
    if (n < 0) return;
    printf("%d ", n);
    printReverseNumbersRecursiveFunction(n - 1);
}

int main(void) {
    printNumbersGoto(7);
    printf("= printNumbersGoto(7)\n");
    printNumbersFor(7);
    printf("= printNumbersFor(7)\n");
    printNumbersRecursiveFunction(7);
    printf("= printNumbersRecursiveFunction(7)\n");
    printReverseNumbersRecursiveFunction(7);
    printf("= printReverseNumbersRecursiveFunction(7)\n");
}


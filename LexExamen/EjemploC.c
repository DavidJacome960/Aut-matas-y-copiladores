#include <stdio.h>
#include <stdlib.h>

#define MAX 10

// Función para sumar dos números
int suma(int a, int b) {
    return a + b;
}

// Función para imprimir un arreglo
void imprimirArreglo(int arr[], int n) {
    int i;
    for (i = 0; i < n; i++) {
        printf("Elemento %d: %d\n", i, arr[i]);
    }
}

// Función principal
int main() {
    int i;
    int numeros[MAX];
    int resultado;
    float promedio = 0.0;
    char mensaje[] = "Hola mundo desde C";

    printf("%s\n", mensaje);

    // Llenar arreglo
    for (i = 0; i < MAX; i++) {
        numeros[i] = i * 2;
    }

    // Imprimir arreglo
    imprimirArreglo(numeros, MAX);

    // Sumar valores
    resultado = suma(numeros[0], numeros[1]);
    printf("Resultado de suma: %d\n", resultado);

    // Calcular promedio
    for (i = 0; i < MAX; i++) {
        promedio += numeros[i];
    }
    promedio = promedio / MAX;
    printf("Promedio: %.2f\n", promedio);

    // Condicionales
    if (resultado > 0) {
        printf("El resultado es positivo\n");
    } else if (resultado == 0) {
        printf("El resultado es cero\n");
    } else {
        printf("El resultado es negativo\n");
    }

    // While
    i = 0;
    while (i < 5) {
        printf("Iteración while: %d\n", i);
        i++;
    }

    // Operadores
    int a = 10;
    int b = 5;
    int c;

    c = a + b;
    c = a - b;
    c = a * b;
    c = a / b;

    if (a >= b && b != 0) {
        printf("Operadores funcionando\n");
    }

    // Caracter
    char letra = 'A';
    printf("Letra: %c\n", letra);

    // Binario, octal y hexadecimal
    int bin = 0b1010;
    int oct = 012;
    int hex = 0x1A;

    printf("Bin: %d, Oct: %d, Hex: %d\n", bin, oct, hex);

    return 0;
}
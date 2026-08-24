import java.util.Scanner;

public class VectorNumeros {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] vector = new int[15];

        // Mensaje inicial sencillo
        System.out.println("Hola, bienvenido al programa de vectores.");
        System.out.println("Por favor, ingresa 15 números entre 10 y 100.\n");

        // 1. Llenar el vector con validación
        for (int i = 0; i < vector.length; i++) {
            int numero;
            do {
                System.out.print("Ingresa el número " + (i + 1) + ": ");
                numero = entrada.nextInt();

                if (numero < 10 || numero > 100) {
                    System.out.println("El número está fuera del rango (10 - 100). Intenta de nuevo.");
                }
            } while (numero < 10 || numero > 100);

            vector[i] = numero;
        }

        // Mostrar los valores ingresados
        System.out.println("\nValores del vector:");
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Posición " + i + ": " + vector[i]);
        }

        // 2 y 3. Buscar un número, encontrar Mayor, Menor y Sumar
        System.out.print("\nSolicitud: Ingresa un número para buscar en el vector: ");
        int numeroBuscar = entrada.nextInt();

        boolean encontrado = false;
        int posicionEncontrada = -1;
        int mayor = vector[0];
        int menor = vector[0];
        int sumaTotal = 0;

        for (int i = 0; i < vector.length; i++) {
            // Suma total
            sumaTotal += vector[i];

            // Mayor y Menor
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
            if (vector[i] < menor) {
                menor = vector[i];
            }

            // Búsqueda del número
            if (!encontrado && vector[i] == numeroBuscar) {
                encontrado = true;
                posicionEncontrada = i;
            }
        }

        // Resultados de la búsqueda
        if (encontrado) {
            System.out.println("El número " + numeroBuscar + " se encuentra en la posición: " + posicionEncontrada);
        } else {
            System.out.println("El número " + numeroBuscar + " no está en el vector.");
        }

        // Resultados de Mayor y Menor
        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);

        // 4. Identificar Múltiplos de X
        System.out.print("\nSolicitud: Ingresa un número X para buscar sus múltiplos: ");
        int x = entrada.nextInt();

        boolean hayMultiplos = false;
        System.out.print("Múltiplos de " + x + " en el vector: ");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % x == 0) {
                System.out.print(vector[i] + " ");
                hayMultiplos = true;
            }
        }

        if (!hayMultiplos) {
            System.out.println("No hay múltiplos de " + x + " en el vector.");
        } else {
            System.out.println();
        }

        // 5. Mostrar la Suma Total
        System.out.println("\nLa suma de todos los valores es: " + sumaTotal);

        // 6. Nuevo Vector con números por encima del Promedio
        double promedio = (double) sumaTotal / vector.length;
        System.out.println("El promedio es: " + promedio);

        // Primero contamos cuántos números son mayores que el promedio
        int contadorSobrePromedio = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > promedio) {
                contadorSobrePromedio++;
            }
        }

        // Si hay números mayores, creamos el segundo vector con ese tamaño exacto
        if (contadorSobrePromedio == 0) {
            System.out.println("No hay números mayores que el promedio.");
        } else {
            int[] vectorSobrePromedio = new int[contadorSobrePromedio];
            int indiceNuevo = 0;

            // Llenamos el nuevo vector
            for (int i = 0; i < vector.length; i++) {
                if (vector[i] > promedio) {
                    vectorSobrePromedio[indiceNuevo] = vector[i];
                    indiceNuevo++;
                }
            }

            // Mostramos los resultados del nuevo vector
            System.out.println("Cantidad de números por encima del promedio: " + contadorSobrePromedio);
            System.out.print("Valores del nuevo vector: ");
            for (int i = 0; i < vectorSobrePromedio.length; i++) {
                System.out.print(vectorSobrePromedio[i] + " ");
            }
            System.out.println();
        }

        System.out.println("\n¡Gracias por usar el programa!");
        entrada.close();
    }
}
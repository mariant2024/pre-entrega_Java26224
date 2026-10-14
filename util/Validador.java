package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.StockInsuficienteException;

public class Validador {

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }

    public static void validarPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede ser nula o vacía.");
        }
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {

        System.out.println(mensaje);
        String valor = sc.nextLine();
        return valor;
    }

}

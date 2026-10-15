package ui;

import java.util.Scanner;

import exception.ProductoNoEncontradoException;
import exception.StockInsuficienteException;
import model.Producto;
import service.ProductoService;
import util.Validador;

public class Main {
    
    public static void main(String[] args) {

        ProductoService productoService = new ProductoService();
        Scanner scanner = new Scanner(System.in);
        MenuProducto menuProducto = new MenuProducto(scanner, productoService);
        cargarDatosDePrueba(productoService);

        int opcion;
        do {

            menuProducto.mostrarMenu();
            opcion = Validador.leerEntero(scanner, "Seleccione una opción: ");
            scanner.nextLine(); // Limpiar el buffer

            try {
                 switch (opcion) {
                case 1:
                    menuProducto.agregarProducto();
                    break;
                case 2:
                    menuProducto.listarProductos();
                    break;
                case 3:
                    menuProducto.buscarProducto();
                    break;
                case 4:
                    menuProducto.actualizarProducto();
                    break;
                case 5:
                    menuProducto.eliminarProducto();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Elija una opción entre 1 y 5.");
            }

            } 
            
            catch ( ProductoNoEncontradoException | StockInsuficienteException  e) {
                System.out.println("Error: " + e.getMessage());
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue; // Volver al inicio del bucle
            }
           


        } while(opcion!=6);

        scanner.close();
    }
    

    private static void cargarDatosDePrueba(ProductoService productoService) {
        productoService.guardar(new Producto("Pepsi", 10.0, 5, "Bebidas"));
        productoService.guardar(new Producto("Yerba Mate 1 kg", 20.0, 3, "Bebidas"));
        productoService.guardar(new Producto("Galletitas Dulces", 15.0, 8, "Almacen"));
        System.out.println("Se cargaron 3 productos de prueba.");
    }
}

package ui;

import java.util.List;
import java.util.Scanner;

import model.Producto;
import service.ProductoService;
import util.Validador;

public class MenuProducto {

    private final Scanner scanner;
    private final ProductoService productoService;

    public MenuProducto(Scanner scanner, ProductoService productoService) {
        this.scanner = scanner;
        this.productoService = productoService;
    }


    public void mostrarMenu() {

            System.out.println("=== Menú de Productos ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("4. Actualizar Producto");
            System.out.println("5. Eliminar Producto");
            System.out.println("6. Salir");
            System.out.println("================================");
            
    }

    public void agregarProducto() {
        System.out.println("======Nuevo Producto======");
        String nombre = Validador.leerTexto(scanner, "Nombre: ");

        System.out.println("Ingrese el precio del producto:");
        double precio = Validador.leerDouble(scanner, "Precio: ");

        System.out.println("Ingrese el stock del producto:");
        int stock = Validador.leerEntero(scanner, "Stock: ");

        System.out.println("Ingrese la categoría del producto:");
        String categoria = Validador.leerTexto(scanner, "Categoría: ");

        Producto producto = new Producto(nombre, precio, stock, categoria);

        Producto guardado = productoService.guardar(producto);

        System.out.println("Producto agregado con el id: " + guardado.getId());

    }

    public void listarProductos() {
        
        List<Producto > lista = productoService.listar();

        if(lista.isEmpty()){
            System.out.println("No hay productos cargados.");
            return;
        }

        System.out.println("=== Lista de Productos ===");
        for (Producto producto : lista) {
            System.out.println(producto);
        }
    }

    public void buscarProducto() {
        int id = Validador.leerEntero(scanner, "Ingrese el ID del producto a buscar: ");

        Producto producto = productoService.buscarPorId(id);
        System.out.println("Producto encontrado: " + producto);
    }


    public void actualizarProducto() {

        int id = Validador.leerEntero(scanner, "Ingrese el ID del producto a actualizar: ");

        Producto actual = productoService.buscarPorId(id);
        System.out.println("Producto actual: " + actual);

        System.out.println(" Ingrese los nuevos datos del producto:");
        String nombre = Validador.leerTexto(scanner, "Nuevo nombre: ");
        double precio = Validador.leerDouble(scanner, "Nuevo precio: ");
        int stock = Validador.leerEntero(scanner, "Nuevo stock: ");
        String categoria = Validador.leerTexto(scanner, "Nueva categoría: ");

        Producto productoActualizado = new Producto(nombre, precio, stock, categoria);
        Producto actualizado = productoService.actualizar(id, productoActualizado);

        System.out.println("Producto actualizado: " + actualizado);
    }

    public void eliminarProducto() {
        int id = Validador.leerEntero(scanner, "Ingrese el ID del producto a eliminar: ");

        productoService.eliminar(id);
        System.out.println("Producto con ID " + id + " eliminado correctamente.");
    }
}

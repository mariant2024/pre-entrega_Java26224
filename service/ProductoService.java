package service;

import java.util.ArrayList;
import java.util.List;

import exception.ProductoNoEncontradoException;
import model.Producto;
import util.Validador;

public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    private static int contadorId = 1;

    public Producto guardar(Producto producto) {

        Validador.validarNombre(producto.getNombre());
        Validador.validarPrecio(producto.getPrecio());
        Validador.validarStock(producto.getStock());
        Validador.validarCategoria(producto.getCategoria());

        producto.setId(contadorId++);

        productos.add(producto);

        return producto;

    }


    public List<Producto> listar() {
        return productos;
    }

    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado.");
    }

    public Producto actualizar(int id, Producto productoActualizado) {
        Producto productoExistente = buscarPorId(id);

        Validador.validarNombre(productoActualizado.getNombre());
        Validador.validarPrecio(productoActualizado.getPrecio());
        Validador.validarStock(productoActualizado.getStock());
        Validador.validarCategoria(productoActualizado.getCategoria());

        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setStock(productoActualizado.getStock());
        productoExistente.setCategoria(productoActualizado.getCategoria());

        return productoExistente;
    }

    public void eliminar(int id) {
        Producto producto = buscarPorId(id);
        productos.remove(producto);
    }

}

package ecommerce_cli_m4;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Producto> productos = new ArrayList<>();

    public Catalogo() {
        productos.add(new Producto(1, "Bidón 20L", "Bidones", 3000));
        productos.add(new Producto(2, "Pack Botellas 500ml", "Botellas", 3000));
        productos.add(new Producto(3, "Dispensador Básico", "Dispensadores", 6500));
    }

    public void listarProductos() {
        System.out.println("=== LISTA DE PRODUCTOS ===");
        for (Producto p : productos) {
            System.out.println(p.getDescripcion());
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void crearProducto(int id, String nombre, String categoria, int precio) {
        try {
            Producto nuevo = new Producto(id, nombre, categoria, precio);
            productos.add(nuevo);
            System.out.println("✅ Producto creado: " + nuevo.getDescripcion());
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ No se pudo crear el producto: " + e.getMessage());
        }
    }

    public void editarProducto(int id, String nuevoNombre, String nuevaCategoria, int nuevoPrecio) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            try {
                p.setNombre(nuevoNombre);
                p.setCategoria(nuevaCategoria);
                p.setPrecio(nuevoPrecio);
                System.out.println("✏️ Producto actualizado: " + p.getDescripcion());
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ Error al editar: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Producto no encontrado.");
        }
    }

    public void eliminarProducto(int id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            System.out.println("🗑️ Producto eliminado.");
        } else {
            System.out.println("⚠️ Producto no encontrado.");
        }
    }
}

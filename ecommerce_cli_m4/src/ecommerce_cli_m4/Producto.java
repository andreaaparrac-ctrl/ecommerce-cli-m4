package ecommerce_cli_m4;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int precio;

    public Producto(int id, String nombre, String categoria, int precio) {
        if (id <= 0 || nombre.trim().isEmpty() || categoria.trim().isEmpty() || precio <= 0)
            throw new IllegalArgumentException("Datos inválidos: todos deben ser mayores a 0 y no vacíos.");
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public int getPrecio() { return precio; }

    public void setNombre(String nombre) {
        if (nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        if (categoria.trim().isEmpty()) throw new IllegalArgumentException("La categoría no puede estar vacía.");
        this.categoria = categoria;
    }

    public void setPrecio(int precio) {
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        this.precio = precio;
    }

    public String getDescripcion() {
        return id + " - " + nombre + " (" + categoria + ") - $" + precio;
    }
}
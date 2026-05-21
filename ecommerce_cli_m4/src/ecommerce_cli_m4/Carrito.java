package ecommerce_cli_m4;

import java.util.HashMap;
import java.util.Map;

public class Carrito {
    private Map<Producto, Integer> items = new HashMap<>();

    public void añadirProducto(Producto p, int cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) throw new CantidadInvalidaException("La cantidad debe ser mayor a 0");
        items.put(p, items.getOrDefault(p, 0) + cantidad);
        System.out.println("✅ Agregado: " + p.getDescripcion() + " x" + cantidad);
    }

    public void quitarProducto(int id) {
        items.entrySet().removeIf(entry -> entry.getKey().getId() == id);
        System.out.println("🗑️ Producto eliminado del carrito.");
    }

    public void mostrarCarrito() {
        if (items.isEmpty()) {
            System.out.println("⚠️ El carrito está vacío.");
            return;
        }
        System.out.println("=== CARRITO ===");
        int total = 0;
        for (Map.Entry<Producto, Integer> entry : items.entrySet()) {
            int subtotal = entry.getKey().getPrecio() * entry.getValue();
            System.out.println(entry.getKey().getDescripcion() + " x" + entry.getValue() + " → $" + subtotal);
            total += subtotal;
        }
        System.out.println("TOTAL base: $" + total);
    }

    public int calcularTotalBase() {
        return items.entrySet().stream()
            .mapToInt(e -> e.getKey().getPrecio() * e.getValue())
            .sum();
    }
    
    public int calcularTotalFinal() {
        int totalBase = calcularTotalBase();
        int descuento = Descuento.aplicarDescuentos(this);
        return totalBase - descuento;
    }

    public boolean estaVacio() { return items.isEmpty(); }
    public Map<Producto, Integer> getItems() { return items; }
    public void vaciar() { items.clear(); }
}
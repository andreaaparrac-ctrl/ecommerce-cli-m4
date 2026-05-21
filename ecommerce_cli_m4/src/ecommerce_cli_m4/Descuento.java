package ecommerce_cli_m4;

public class Descuento {
    public static int aplicarDescuentos(Carrito carrito) {
        int totalBase = carrito.calcularTotalBase();

        int descuentoPorMonto = 0;
        int descuentoPorCategoria = 0;

        // total >= 10000 → 5%
        if (totalBase >= 10000) {
            descuentoPorMonto = (int)(totalBase * 0.05);
        }

        // productos de categoría "Bidones" → 3%
        boolean tieneBidones = carrito.getItems().keySet().stream()
            .anyMatch(p -> p.getCategoria().equalsIgnoreCase("Bidones"));
        if (tieneBidones) {
            descuentoPorCategoria = (int)(totalBase * 0.03);
        }

        // Aplicar solo el descuento más alto
        return Math.max(descuentoPorMonto, descuentoPorCategoria);
    }
}
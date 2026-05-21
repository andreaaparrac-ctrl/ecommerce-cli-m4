package ecommerce_cli_m4;

public class Orden {
    private int totalBase;
    private int descuentos;
    private int totalFinal;

    public Orden(int totalBase, int descuentos, int totalFinal) {
        this.totalBase = totalBase;
        this.descuentos = descuentos;
        this.totalFinal = totalFinal;
    }

    public void mostrarResumen() {
        System.out.println("=== ORDEN CONFIRMADA ===");
        System.out.println("Total base: $" + totalBase);
        System.out.println("Descuentos aplicados: $" + descuentos);
        System.out.println("TOTAL final: $" + totalFinal);
    }
}
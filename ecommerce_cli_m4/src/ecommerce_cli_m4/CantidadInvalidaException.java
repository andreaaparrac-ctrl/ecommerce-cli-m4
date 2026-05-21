package ecommerce_cli_m4;

public class CantidadInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;
    public CantidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

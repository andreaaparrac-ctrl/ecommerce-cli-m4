package ecommerce_cli_m4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoTest {

    @Test
    void añadirProducto_conCantidadInvalida_lanzaExcepcion() {
        Catalogo catalogo = new Catalogo();
        Carrito carrito = new Carrito();
        Producto bidon20L = catalogo.buscarProductoPorId(1); // precio oficial: 3000

        assertThrows(CantidadInvalidaException.class, () -> {
            carrito.añadirProducto(bidon20L, 0);
        });
    }

    @Test
    void calcularTotalBase_devuelveSumaCorrecta() throws CantidadInvalidaException {
        Catalogo catalogo = new Catalogo();
        Carrito carrito = new Carrito();
        Producto bidon20L = catalogo.buscarProductoPorId(1); // 3000
        Producto dispensador = catalogo.buscarProductoPorId(3); // 6500

        carrito.añadirProducto(bidon20L, 2); // 6000
        carrito.añadirProducto(dispensador, 1); // 6500

        assertEquals(12500, carrito.calcularTotalBase());
    }

    @Test
    void calcularTotalFinal_aplicaDescuentoPorMonto() throws CantidadInvalidaException {
        Catalogo catalogo = new Catalogo();
        Carrito carrito = new Carrito();
        Producto bidon20L = catalogo.buscarProductoPorId(1); // 3000
        Producto dispensador = catalogo.buscarProductoPorId(3); // 6500

        carrito.añadirProducto(bidon20L, 2); // 6000
        carrito.añadirProducto(dispensador, 1); // 6500 → total base = 12500

        // Regla: total >= 10000 → 5% descuento = 625
        // Total final esperado = 11875
        assertEquals(11875, carrito.calcularTotalFinal());
    }

    @Test
    void calcularTotalFinal_aplicaDescuentoPorCategoria() throws CantidadInvalidaException {
        Catalogo catalogo = new Catalogo();
        Carrito carrito = new Carrito();
        Producto bidon20L = catalogo.buscarProductoPorId(1); // 3000

        carrito.añadirProducto(bidon20L, 1); // total base = 3000

        // Regla: categoría "Bidones" → 3% descuento = 90
        // Total final esperado = 2910
        assertEquals(2910, carrito.calcularTotalFinal());
    }

    @Test
    void calcularTotalFinal_aplicaSoloMayorDescuento() throws CantidadInvalidaException {
        Catalogo catalogo = new Catalogo();
        Carrito carrito = new Carrito();
        Producto bidon20L = catalogo.buscarProductoPorId(1); // 3000
        Producto dispensador = catalogo.buscarProductoPorId(3); // 6500

        carrito.añadirProducto(bidon20L, 2); // 6000
        carrito.añadirProducto(dispensador, 1); // 6500 → total base = 12500

        // Aquí aplican dos reglas:
        // - Por monto (5% = 625)
        // - Por categoría Bidones (3% = 375)
        // Se debe aplicar solo el mayor → 625
        assertEquals(11875, carrito.calcularTotalFinal());
    }
}
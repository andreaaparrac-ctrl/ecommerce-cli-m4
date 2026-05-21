package ecommerce_cli_m4;

import java.util.Scanner;

public class Consola {
    private Scanner scanner = new Scanner(System.in);
    private Catalogo catalogo = new Catalogo();
    private Carrito carrito = new Carrito();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1) ADMIN");
            System.out.println("2) USUARIO");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    mostrarMenuAdmin();
                    break;
                case 2:
                    mostrarMenuUsuario();
                    break;
                case 0:
                    System.out.println("👋 Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenuAdmin() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ ADMIN ===");
            System.out.println("1) Listar productos");
            System.out.println("2) Buscar producto");
            System.out.println("3) Crear producto");
            System.out.println("4) Editar producto");
            System.out.println("5) Eliminar producto");
            System.out.println("0) Volver");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    catalogo.listarProductos();
                    break;
                case 2:
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine();
                    Producto encontrado = catalogo.buscarProducto(nombre);
                    if (encontrado != null) {
                        System.out.println("🔎 Encontrado: " + encontrado.getDescripcion());
                    } else {
                        System.out.println("⚠️ Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("ID: ");
                    int id = leerEntero();
                    System.out.print("Nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Precio: ");
                    int precio = leerEntero();
                    catalogo.crearProducto(id, nuevoNombre, categoria, precio);
                    break;
                case 4:
                    System.out.print("ID del producto a editar: ");
                    int idEditar = leerEntero();
                    System.out.print("Nuevo nombre: ");
                    String nombreEditar = scanner.nextLine();
                    System.out.print("Nueva categoría: ");
                    String categoriaEditar = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    int precioEditar = leerEntero();
                    catalogo.editarProducto(idEditar, nombreEditar, categoriaEditar, precioEditar);
                    break;
                case 5:
                    System.out.print("ID del producto a eliminar: ");
                    int idEliminar = leerEntero();
                    catalogo.eliminarProducto(idEliminar);
                    break;
                case 0:
                    System.out.println("↩️ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenuUsuario() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ USUARIO ===");
            System.out.println("1) Listar productos");
            System.out.println("2) Buscar producto");
            System.out.println("3) Agregar al carrito");
            System.out.println("4) Quitar del carrito");
            System.out.println("5) Ver carrito");
            System.out.println("7) Confirmar compra");
            System.out.println("0) Volver");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    catalogo.listarProductos();
                    break;
                case 2:
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine();
                    Producto encontrado = catalogo.buscarProducto(nombre);
                    if (encontrado != null) {
                        System.out.println("🔎 Encontrado: " + encontrado.getDescripcion());
                    } else {
                        System.out.println("⚠️ Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("ID del producto: ");
                    int idAgregar = leerEntero();
                    Producto prodAgregar = catalogo.buscarProductoPorId(idAgregar);
                    if (prodAgregar != null) {
                        System.out.print("Cantidad: ");
                        int cantidad = leerEntero();
                        try {
                            carrito.añadirProducto(prodAgregar, cantidad);
                        } catch (CantidadInvalidaException e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("⚠️ Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID del producto a quitar: ");
                    int idQuitar = leerEntero();
                    carrito.quitarProducto(idQuitar);
                    break;
                case 5:
                    carrito.mostrarCarrito();
                    break;
                case 7:
                    if (carrito.estaVacio()) {
                        System.out.println("⚠️ No se puede confirmar compra con carrito vacío.");
                    } else {
                        int totalBase = carrito.calcularTotalBase();
                        int descuento = Descuento.aplicarDescuentos(carrito);
                        int totalFinal = totalBase - descuento;

                        Orden orden = new Orden(totalBase, descuento, totalFinal);
                        orden.mostrarResumen();

                        carrito.vaciar();
                        System.out.println("✅ Compra confirmada. Carrito vaciado.");
                    }
                    break;
                case 0:
                    System.out.println("↩️ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

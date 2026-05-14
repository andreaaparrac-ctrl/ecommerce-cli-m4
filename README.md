# Ecommerce CLI M4

Proyecto de e-commerce en consola (CLI) para gestión de productos y compras.

## Roles
- **Admin**: CRUD de productos (listar, buscar, crear, editar, eliminar).
- **Usuario**: manejo de carrito, aplicación de descuentos y confirmación de compra.

## Validaciones
- ID único y mayor a 0.
- Nombre y categoría no vacíos.
- Precio y cantidad mayores a 0.
- No se puede confirmar compra con carrito vacío.

## Descuentos
- 5% si el total base >= $10.000.
- 3% si hay productos de categoría "Bidones".
- Si se cumplen varias reglas, se aplica **solo el mayor descuento**.

## Diagrama de flujo
[Diagrama de flujo](diagrama_flujo.png)

## Repositorio GitHub

https://github.com/andreaaparrac-ctrl/ecommerce-cli-m4

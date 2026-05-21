## Proyecto ecommerce_cli_m4

## Descripción

Aplicación Java CLI que simula un sistema de compras de productos de agua y accesorios.
Incluye:

Gestión de productos mediante un catálogo (Catalogo.java).
Operaciones de carrito de compras (Carrito.java).
Validaciones de datos y excepciones personalizadas.
Aplicación de reglas de descuento (por monto y por categoría).
Pruebas unitarias con JUnit 5 para validar la lógica.

## Diagrama de flujo

[Diagrama de flujo](diagrama_flujo.png)

## Estructura del proyecto

ecommerce_cli_m4/
│---src/ecommerce_cli_m4/ 
     │--- Producto.java 
     │--- Catalogo.java 
     │--- Carrito.java 
     │--- Descuento.java 
     │--- CantidadInvalidaException.java  
     │--- Main.java 
     │--- Consola.java
     │--- Orden.java
     │--- TiendaService.java
     │--- Main
│---test/ecommerce_cli_m4/ 
     │--- CarritoTest.java

## Repositorio público

https://github.com/andreaaparrac-ctrl/ecommerce-cli-m4

▶️ Instrucciones de ejecución

Clonar el repositorio:

bash
git clone https://github.com/andreaaparrac-ctrl/ecommerce-cli-m4.git
cd ecommerce-cli-m4
Compilar:

bash
javac -d bin src/ecommerce_cli_m4/*.java
Ejecutar:

bash
java -cp bin ecommerce_cli_m4.Main


## Menú principal

=== MENÚ PRINCIPAL ===
1) ADMIN
2) USUARIO
0) Salir
Seleccione una opción: 2

=== MENÚ USUARIO ===
1) Listar productos
2) Buscar producto
3) Agregar al carrito
4) Quitar del carrito
5) Ver carrito
7) Confirmar compra
0) Volver
Seleccione una opción: 

## Ejemplo breve de compra

Paso 1: Listar productos
=== LISTA DE PRODUCTOS ===
1 - Bidón 20L (Bidones) - $3000
2 - Pack Botellas 500ml (Botellas) - $3000
3 - Dispensador Básico (Dispensadores) - $6500

Paso 2: Agregar productos
Agregado: 1 - Bidón 20L (Bidones) - $3000 x2
Agregado: 3 - Dispensador Básico (Dispensadores) - $6500 x1

Paso 3: Ver carrito
=== CARRITO DE COMPRAS ===
3 - Dispensador Básico (Dispensadores) - $6500 x1 → $6500
1 - Bidón 20L (Bidones) - $3000 x2 → $6000
TOTAL base: $12500

Paso 4: Confirmación de compra
=== ORDEN CONFIRMADA ===
Total base: $12500
Descuentos aplicados: $625
TOTAL final: $11875
✅ Compra confirmada. Carrito vaciado.


## Pruebas unitarias

Ejecutar en Eclipse:
Clic derecho sobre CarritoTest.java → Run As → JUnit Test.


Pruebas cubren:

Cantidad inválida → excepción.
Total base correcto.
Descuento por monto ≥ 10000.
Descuento por categoría “Bidones”.
Aplicar solo el mayor descuento.

## Conclusión

Este proyecto demuestra:

Uso de POO en Java.
Validaciones y excepciones personalizadas.
Implementación de reglas de negocio con descuentos.
Pruebas unitarias para garantizar la correcta funcionalidad.
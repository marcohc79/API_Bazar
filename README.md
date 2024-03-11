# API_Bazar

## Objetivo

El objetivo de este proyecto integrador final es validar los conocimientos prácticos y técnicos referidos al desarrollo de APIs en el lenguaje de programación Java mediante Spring Boot aprendidos en el curso "[Desarrollo de APIs en Java con Spring Boot](https://todocodeacademy.com/course/desarrollo-de-apis-con-spring-boot/)" en [TodoCode Academy](https://todocodeacademy.com/).

## Modelado

A partir del relevamiento realizado por un analista funcional, se identificó la necesidad de las siguientes clases:

- **Producto**
- **Venta**
- **Cliente**

Cada venta posee una lista de productos y uno y solo un cliente asociado. Además, cada clase debe tener los siguientes atributos:

### Producto

- `Long codigo_producto`
- `String nombre`
- `String marca`
- `Double costo`
- `Double cantidad_disponible`

### Venta

- `Long codigo_venta`
- `LocalDate fecha_venta`
- `Double total`
- `List<Producto> listaProductos`
- `Cliente unCliente`

### Cliente

- `Long id_cliente`
- `String nombre`
- `String apellido`
- `String dni`

## Requerimientos

A partir del modelado, la dueña del bazar especificó los siguientes requerimientos:

### 1. CRUD completo de productos

- Métodos HTTP: GET, POST, DELETE, PUT
- Endpoints:
  - Creación: `localhost:8080/productos/crear`
  - Lista completa de productos: `localhost:8080/productos`
  - Traer un producto en particular: `localhost:8080/productos/{codigo_producto}`
  - Eliminación: `localhost:8080/productos/eliminar/{codigo_producto}`
  - Edición: `localhost:8080/productos/editar/{codigo_producto}`

### 2. CRUD completo de clientes

- Métodos HTTP: GET, POST, DELETE, PUT
- Endpoints:
  - Creación: `localhost:8080/clientes/crear`
  - Lista completa de clientes: `localhost:8080/clientes`
  - Traer un cliente en particular: `localhost:8080/clientes/{id_cliente}`
  - Eliminación: `localhost:8080/clientes/eliminar/{id_cliente}`
  - Edición: `localhost:8080/clientes/editar/{id_cliente}`

### 3. CRUD completo de ventas

- Métodos HTTP: GET, POST, DELETE, PUT
- Endpoints:
  - Creación: `localhost:8080/ventas/crear`
  - Lista completa de ventas realizadas: `localhost:8080/ventas`
  - Traer una venta en particular: `localhost:8080/ventas/{codigo_venta}`
  - Eliminación: `localhost:8080/clientes/eliminar/{codigo_venta}`
  - Edición: `localhost:8080/clientes/editar/{codigo_venta}`

### 4. Productos con cantidad disponible menor a 5

- Método HTTP: GET
- Endpoint: `localhost:8080/productos/falta_stock`

### 5. Lista de productos de una determinada venta

- Método HTTP: GET
- Endpoint: `localhost:8080/ventas/productos/{codigo_venta}`

### 6. Sumatoria del monto y cantidad total de ventas de un día

- Método HTTP: GET
- Endpoint: `localhost:8080/ventas/{fecha_venta}`

### 7. Venta con el monto más alto

- Método HTTP: GET
- Endpoint: `localhost:8080/ventas/mayor_venta`

**Nota:** Tener en cuenta el patrón DTO para este escenario.

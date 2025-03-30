CREATE TABLE `clientes` (
  `id_cliente` int PRIMARY KEY,
  `nombre` varchar(50),
  `telefono` varchar(50),
  `direccion` varchar(50),
  `correo` varchar(50)
);

CREATE TABLE `empleados` (
  `id_empleado` int PRIMARY KEY,
  `nombre` varchar(50),
  `cargo` enum(administrador,vendedor),
  `salario` float(8,2)
);

CREATE TABLE `proveedores` (
  `id_proveedor` int PRIMARY KEY,
  `nombre` varchar(50),
  `contacto` varchar(50)
);

CREATE TABLE `inventario_productos` (
  `id_producto` int PRIMARY KEY,
  `categoria_producto` enum(herramienta,electricos),
  `nombre_producto` varchar(50),
  `precio_proveedor` float(8,2),
  `precio_venta` float(8,2),
  `cantidad_stock` int,
  `id_proveedor` int
);

CREATE TABLE `ordenes_compra` (
  `id_orden_compra` int PRIMARY KEY,
  `id_cliente` int,
  `id_empleado` int,
  `id_producto` int,
  `estado_orden` enum(pendiente,pagada,enviada),
  `fecha_compra` timestamp
);

CREATE TABLE `registro_ventas` (
  `id_venta` int PRIMARY KEY,
  `id_orden_compra` int,
  `total` float,
  `fecha_registro` timestamp
);

ALTER TABLE `inventario_productos` ADD FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`);

ALTER TABLE `ordenes_compra` ADD FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

ALTER TABLE `ordenes_compra` ADD FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`);

ALTER TABLE `ordenes_compra` ADD FOREIGN KEY (`id_producto`) REFERENCES `inventario_productos` (`id_producto`);

ALTER TABLE `registro_ventas` ADD FOREIGN KEY (`id_orden_compra`) REFERENCES `ordenes_compra` (`id_orden_compra`);

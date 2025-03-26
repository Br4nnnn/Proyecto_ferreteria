CREATE TABLE [clientes] (
  [id_cliente] INT PRIMARY KEY,
  [nombre] VARCHAR(100),
  [telefono] VARCHAR(20),
  [direccion] TEXT,
  [correo] VARCHAR(100) UNIQUE
)
GO

CREATE TABLE [empleados] (
  [id_empleado] INT PRIMARY KEY,
  [nombre] VARCHAR(100),
  [cargo] VARCHAR(50),
  [salario] DECIMAL(10,2)
)
GO

CREATE TABLE [proveedores] (
  [id_proveedor] INT PRIMARY KEY,
  [nombre] VARCHAR(100),
  [contacto] VARCHAR(100)
)
GO

CREATE TABLE [productos] (
  [id_producto] INT PRIMARY KEY,
  [nombre] VARCHAR(100),
  [categoria] VARCHAR(50),
  [precio] DECIMAL(10,2),
  [cantidad_disponible] INT,
  [id_proveedor] INT
)
GO

CREATE TABLE [ordenes_compra] (
  [id_orden] INT PRIMARY KEY,
  [id_cliente] INT,
  [id_empleado] INT,
  [total] DECIMAL(10,2),
  [estado] ENUM(pendiente,pagada,enviada),
  [fecha] TIMESTAMP
)
GO

CREATE TABLE [detalle_orden] (
  [id_detalle] INT PRIMARY KEY,
  [id_orden] INT,
  [id_producto] INT,
  [cantidad] INT,
  [precio_unitario] DECIMAL(10,2)
)
GO

CREATE TABLE [ventas] (
  [id_venta] INT PRIMARY KEY,
  [id_cliente] INT,
  [id_empleado] INT,
  [total] DECIMAL(10,2),
  [fecha] TIMESTAMP
)
GO

CREATE TABLE [detalle_venta] (
  [id_detalle] INT PRIMARY KEY,
  [id_venta] INT,
  [id_producto] INT,
  [cantidad] INT,
  [precio_unitario] DECIMAL(10,2)
)
GO

ALTER TABLE [productos] ADD FOREIGN KEY ([id_proveedor]) REFERENCES [proveedores] ([id_proveedor])
GO

ALTER TABLE [ordenes_compra] ADD FOREIGN KEY ([id_cliente]) REFERENCES [clientes] ([id_cliente])
GO

ALTER TABLE [ordenes_compra] ADD FOREIGN KEY ([id_empleado]) REFERENCES [empleados] ([id_empleado])
GO

ALTER TABLE [detalle_orden] ADD FOREIGN KEY ([id_orden]) REFERENCES [ordenes_compra] ([id_orden])
GO

ALTER TABLE [detalle_orden] ADD FOREIGN KEY ([id_producto]) REFERENCES [productos] ([id_producto])
GO

ALTER TABLE [ventas] ADD FOREIGN KEY ([id_cliente]) REFERENCES [clientes] ([id_cliente])
GO

ALTER TABLE [ventas] ADD FOREIGN KEY ([id_empleado]) REFERENCES [empleados] ([id_empleado])
GO

ALTER TABLE [detalle_venta] ADD FOREIGN KEY ([id_venta]) REFERENCES [ventas] ([id_venta])
GO

ALTER TABLE [detalle_venta] ADD FOREIGN KEY ([id_producto]) REFERENCES [productos] ([id_producto])
GO

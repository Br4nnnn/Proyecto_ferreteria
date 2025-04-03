package Inventario_productos;

public class Inventario_productos
{
    int id_producto;
    String categoria_producto;
    String nombre_producto;
    String precio_proveedor;
    String precio_venta;
    String cantidad_stock;

    public Inventario_productos(int id_producto, String categoria_producto, String nombre_producto, String precio_proveedor, String precio_venta,String cantidad_stock)
    {
        this.id_producto = id_producto;
        this.categoria_producto = categoria_producto;
        this.nombre_producto = nombre_producto;
        this.precio_proveedor = precio_proveedor;
        this.precio_venta = precio_venta;
        this.cantidad_stock=cantidad_stock;
    }

    public int getid_producto()
    {
        return id_producto;
    }

    public void setid_producto(int id_producto)
    {
        this.id_producto = id_producto;
    }

    public String getcategoria_producto()
    {
        return categoria_producto;
    }

    public void setcategoria_producto(String categoria_producto)
    {
        this.categoria_producto = categoria_producto;
    }

    public String getnombre_producto()
    {
        return nombre_producto;
    }

    public void setTelefono(String nombre_producto)
    {
        this.nombre_producto = nombre_producto;
    }

    public String getprecio_proveedor()
    {
        return precio_proveedor;
    }

    public void setprecio_proveedor(String precio_proveedor)
    {
        this.precio_proveedor = precio_proveedor;
    }

    public String getprecio_venta()
    {
        return precio_venta;
    }

    public void setprecio_venta(String precio_venta) {this.precio_venta = precio_venta;}

    public String getcantidad_stock()
    {
        return cantidad_stock;
    }

    public void setcantidad_stock(String cantidad_stock) {this.cantidad_stock = cantidad_stock;}


}
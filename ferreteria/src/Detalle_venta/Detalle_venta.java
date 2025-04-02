package Detalle_venta;

/**
 * Representa un detalle de una venta, incluyendo información sobre el producto, cantidad y precio unitario.
 */
public class Detalle_venta {
    private int idDetalle;
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    /**
     * Constructor para crear un objeto Detalle_venta.
     *
     * @param idDetalle Identificador único del detalle de venta.
     * @param idVenta Identificador de la venta asociada.
     * @param idProducto Identificador del producto vendido.
     * @param cantidad Cantidad del producto vendido.
     * @param precioUnitario Precio unitario del producto.
     */
    public Detalle_venta(int idDetalle, int idVenta, int idProducto, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene el identificador del detalle de venta.
     *
     * @return Identificador del detalle de venta.
     */
    public int getIdDetalle() { return idDetalle; }

    /**
     * Establece el identificador del detalle de venta.
     *
     * @param idDetalle Nuevo identificador del detalle de venta.
     */
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    /**
     * Obtiene el identificador de la venta asociada.
     *
     * @return Identificador de la venta.
     */
    public int getIdVenta() { return idVenta; }

    /**
     * Establece el identificador de la venta asociada.
     *
     * @param idVenta Nuevo identificador de la venta.
     */
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    /**
     * Obtiene el identificador del producto vendido.
     *
     * @return Identificador del producto.
     */
    public int getIdProducto() { return idProducto; }

    /**
     * Establece el identificador del producto vendido.
     *
     * @param idProducto Nuevo identificador del producto.
     */
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    /**
     * Obtiene la cantidad de productos vendidos.
     *
     * @return Cantidad de productos vendidos.
     */
    public int getCantidad() { return cantidad; }

    /**
     * Establece la cantidad de productos vendidos.
     *
     * @param cantidad Nueva cantidad de productos vendidos.
     */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /**
     * Obtiene el precio unitario del producto.
     *
     * @return Precio unitario del producto.
     */
    public double getPrecioUnitario() { return precioUnitario; }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precioUnitario Nuevo precio unitario del producto.
     */
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
}

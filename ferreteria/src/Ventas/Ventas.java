package Ventas;

import java.sql.Timestamp;

/**
 * Clase que representa una venta en el sistema.
 */
public class Ventas {
    private int idVenta;      // Identificador único de la venta
    private int idCliente;    // Identificador del cliente que realizó la compra
    private int idEmpleado;   // Identificador del empleado que registró la venta
    private double total;     // Total de la venta
    private Timestamp fecha;  // Fecha y hora en que se realizó la venta

    /**
     * Constructor de la clase Ventas.
     *
     * @param idVenta    Identificador único de la venta.
     * @param idCliente  Identificador del cliente que realizó la compra.
     * @param idEmpleado Identificador del empleado que registró la venta.
     * @param total      Total de la venta.
     * @param fecha      Fecha y hora en que se realizó la venta.
     */
    public Ventas(int idVenta, int idCliente, int idEmpleado, double total, Timestamp fecha) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.total = total;
        this.fecha = fecha;
    }

    /**
     * Obtiene el identificador de la venta.
     *
     * @return El identificador de la venta.
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el identificador de la venta.
     *
     * @param idVenta El nuevo identificador de la venta.
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return El identificador del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param idCliente El nuevo identificador del cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el identificador del empleado.
     *
     * @return El identificador del empleado.
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Establece el identificador del empleado.
     *
     * @param idEmpleado El nuevo identificador del empleado.
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Obtiene el total de la venta.
     *
     * @return El total de la venta.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la venta.
     *
     * @param total El nuevo total de la venta.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene la fecha y hora de la venta.
     *
     * @return La fecha y hora de la venta.
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha y hora de la venta.
     *
     * @param fecha La nueva fecha y hora de la venta.
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * Representación en cadena de la clase Ventas.
     *
     * @return Una cadena con la información de la venta.
     */
    @Override
    public String toString() {
        return "Ventas{" +
                "idVenta=" + idVenta +
                ", idCliente=" + idCliente +
                ", idEmpleado=" + idEmpleado +
                ", total=" + total +
                ", fecha='" + fecha + "'" +
                '}';
    }
}
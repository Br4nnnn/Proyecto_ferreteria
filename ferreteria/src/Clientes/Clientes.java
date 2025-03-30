/**
 * Clase que representa a un cliente con atributos básicos como ID, nombre,
 * teléfono, dirección y correo electrónico.
 */
package Clientes;

/**
 * Clase Clientes que almacena la información de un cliente.
 */
public class Clientes {

    /** Identificador único del cliente */
    private int id_cliente;

    /** Nombre del cliente */
    private String nombre;

    /** Teléfono del cliente */
    private String telefono;

    /** Dirección del cliente */
    private String direccion;

    /** Correo electrónico del cliente */
    private String correo;

    /**
     * Constructor de la clase Clientes.
     * @param id_cliente Identificador del cliente.
     * @param nombre Nombre del cliente.
     * @param telefono Teléfono del cliente.
     * @param direccion Dirección del cliente.
     * @param correo Correo electrónico del cliente.
     */
    public Clientes(int id_cliente, String nombre, String telefono, String direccion, String correo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    /**
     * Obtiene el identificador del cliente.
     * @return ID del cliente.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el identificador del cliente.
     * @param id_cliente Nuevo ID del cliente.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono del cliente.
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     * @param telefono Nuevo teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del cliente.
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     * @param direccion Nueva dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * @return Correo electrónico del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     * @param correo Nuevo correo del cliente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

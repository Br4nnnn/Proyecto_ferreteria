/**
 * Contiene información básica como ID, nombre y contacto.
 */
package Proveedores;

public class Proveedores {
    private int id_proveedor;
    private String nombre;
    private String contacto;

    /**
     * Constructor para inicializar un objeto proveedores con sus atributos.
     *
     * @param id_proveedor Identificador único contacto del proveedor.
     * @param nombre       Nombre del proveedor.
     * @param contacto     del proveedor..
     */
    public Proveedores(int id_proveedor, String nombre, String contacto) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    /**
     * Obtiene el ID del proveedor.
     *
     * @return ID del proveedor.
     */
    public int getid_proveedor() {
        return id_proveedor;
    }

    /**
     * Establece el ID del proveedor.
     *
     * @param id_proveedor Nuevo ID del proveedor.
     */
    public void setid_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return Nombre del proveedor.
     */
    public String getnombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre Nuevo nombre del proveedor.
     */
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Obtiene el contacto del proveedor.
     *
     * @return contacto del proveedor.
     */
    public String getcontacto() {
        return contacto;
    }

    /**
     * Establece contacto del proveedor.
     *
     * @param contacto del proveedor.
     */
    public void setcontacto(String contacto) {
        this.contacto = contacto;
    }
}
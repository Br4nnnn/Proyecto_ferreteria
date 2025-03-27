/**
 * Clase que representa un empleado en el sistema de gestión de empleados.
 * Contiene información básica como ID, nombre, cargo y salario.
 *
 * @author Alejandro Vera
 */
package Empleados;

public class Empleados {
    private int ID;
    private String Nombre;
    private String Cargo;
    private double Salario;

    /**
     * Constructor para inicializar un objeto Empleados con sus atributos.
     *
     * @param id      Identificador único del empleado.
     * @param nombre  Nombre del empleado.
     * @param cargo   Cargo o posición del empleado dentro de la empresa.
     * @param salario Salario del empleado.
     */
    public Empleados(int id, String nombre, String cargo, double salario) {
        this.ID = id;
        this.Nombre = nombre;
        this.Cargo = cargo;
        this.Salario = salario;
    }

    /**
     * Obtiene el ID del empleado.
     *
     * @return ID del empleado.
     */
    public int getID() { return ID; }

    /**
     * Establece el ID del empleado.
     *
     * @param ID Nuevo ID del empleado.
     */
    public void setID(int ID) { this.ID = ID; }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return Nombre del empleado.
     */
    public String getNombre() { return Nombre; }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) { this.Nombre = nombre; }

    /**
     * Obtiene el cargo del empleado.
     *
     * @return Cargo del empleado.
     */
    public String getCargo() { return Cargo; }

    /**
     * Establece el cargo del empleado.
     *
     * @param cargo Nuevo cargo del empleado.
     */
    public void setCargo(String cargo) { this.Cargo = cargo; }

    /**
     * Obtiene el salario del empleado.
     *
     * @return Salario del empleado.
     */
    public double getSalario() { return Salario; }

    /**
     * Establece el salario del empleado.
     *
     * @param salario Nuevo salario del empleado.
     */
    public void setSalario(double salario) { this.Salario = salario; }
}

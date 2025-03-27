package Empleados;

public class Empleados {
    private int ID;
    private String Nombre;
    private String Cargo;
    private double Salario;  // Cambiado de String a double

    public Empleados(int id, String nombre, String cargo, double salario) {
        this.ID = id;
        this.Nombre = nombre;
        this.Cargo = cargo;
        this.Salario = salario;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getNombre() { return Nombre; }
    public void setNombre(String nombre) { this.Nombre = nombre; }

    public String getCargo() { return Cargo; }
    public void setCargo(String cargo) { this.Cargo = cargo; }

    public double getSalario() { return Salario; }  // Devuelve un double
    public void setSalario(double salario) { this.Salario = salario; }  // Acepta un double
}

package modelo;

public abstract class Empleado {
    private String cedula;
    private String nombre;
    private int edad;
    private String telefono;
    private String correo;

    public Empleado(String cedula, String nombre, int edad, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    public abstract double calcularPago();
    public void mostrarInformacion(){
        System.out.println("Cedula: "+ getCedula());
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Edad: "+ getEdad());
        System.out.println("Telefono: "+ getTelefono());
        System.out.println("Correo: "+ getCorreo());
    }
}

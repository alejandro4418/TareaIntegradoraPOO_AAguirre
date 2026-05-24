package modelo;

public class Administrativo extends Empleado{
    private String departamento;
    private int horasTrabajadas;
    private double valorHora;

    public Administrativo(String cedula, String nombre, int edad, String telefono, String correo, String departamento, int horasTrabajadas, double valorHora) {
        super(cedula, nombre, edad, telefono, correo);
        this.departamento = departamento;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public String getDepartamento() { return departamento; }
    public int getHorasTrabajadas() { return horasTrabajadas; }
    public double getValorHora() { return valorHora; }

    @Override
    public double calcularPago() {
        return getHorasTrabajadas() * getValorHora();
    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Departamento: "+getDepartamento());
        System.out.println("Horas trabajadas: "+getHorasTrabajadas());
        System.out.println("Valor por hora: $"+getValorHora());
        System.out.println("Pago: $"+calcularPago());
    }
}

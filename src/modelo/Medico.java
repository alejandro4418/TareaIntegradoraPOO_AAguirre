package modelo;

public class Medico extends Empleado{
    private String especialidad;
    private int numeroPacientesAtendidos;
    private double valorConsulta;

    public Medico(String cedula, String nombre, int edad, String telefono, String correo, String especialidad, int numeroPacientesAtendidos, double valorConsulta) {
        super(cedula, nombre, edad, telefono, correo);
        this.especialidad = especialidad;
        this.numeroPacientesAtendidos = numeroPacientesAtendidos;
        this.valorConsulta = valorConsulta;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setNumeroPacientesAtendidos(int numeroPacientesAtendidos) {
        this.numeroPacientesAtendidos = numeroPacientesAtendidos;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String getEspecialidad() { return especialidad; }
    public int getNumeroPacientesAtendidos() { return numeroPacientesAtendidos; }
    public double getValorConsulta() { return valorConsulta; }

    @Override
    public double calcularPago(){
        return getNumeroPacientesAtendidos() * getValorConsulta();
    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Especialidad: "+ getEspecialidad());
        System.out.println("Pacientes atendidos: "+ getNumeroPacientesAtendidos());
        System.out.println("Valor consulta: $"+getValorConsulta());
        System.out.println("Pago: $"+calcularPago());
    }

}

package util;

public class Validador {
    public static boolean esEnteroPositivo(int numero){
        return numero > 0;
    }
    public static boolean esDoblePositivo(double numero){
        return numero > 0;
    }
    public static boolean correoValido(String correo){
        return correo != null && correo.contains("@");
    }
    public static boolean telefonoValido(String telefono){
        return telefono != null && telefono.matches("\\d+");
    }

    public static boolean edadValida(int edad){
        return edad > 0 && edad < 150;
    }
}

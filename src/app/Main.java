package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static EmpleadoServicio servicio = new EmpleadoServicio();
    private static Scanner sc = new Scanner(System.in);
    void main(){
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion){
                case 1 -> registrarMedico();
                case 2 -> registrarAdministrativo();
                case 3 -> mostrarEmpleados();
                case 4 -> buscarPorCedula();
                case 5 -> reemplazarInformacion();
                case 6 -> eliminarRegistro();
                case 7 -> calcularPagos();
                case 8 -> mostrarEstadisticas();
                case 9 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 9);
    }

    private static void mostrarMenu() {
        System.out.println("===== CLÍNICA SALUD TOTAL =====");
        System.out.println("1. Registrar médico");
        System.out.println("2. Registrar administrativo");
        System.out.println("3. Mostrar empleados");
        System.out.println("4. Buscar por cédula");
        System.out.println("5. Reemplazar información");
        System.out.println("6. Eliminar registro");
        System.out.println("7. Calcular pagos");
        System.out.println("8. Mostrar estadísticas");
        System.out.println("9. Salir");
        System.out.println();
    }

    private static int leerOpcion(){
        while (true){
            try {
                System.out.println("Opcion: ");
                int opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= 9) return opcion;
                System.out.println("Error: opción inválida (1-9)");
            } catch (NumberFormatException e){
                System.out.println("Error: ingrese un número válido");
            }
        }
    }

    private static String leerStringNoVacio(String mensaje){
        while (true){
            try {
                System.out.println(mensaje);
                int valor = Integer.parseInt(sc.nextLine());
                if (Validador.esEnteroPositivo(valor)) return valor;
                System.out.println("Error: debe ser mayor a cero");
            } catch (NumberFormatException e){
                System.out.println("Error: debe ser un número entero");
            }
        }
    }


}

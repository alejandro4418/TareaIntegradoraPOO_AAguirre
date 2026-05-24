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
            System.out.print(mensaje);
            String valor = sc.nextLine().trim();
            if (!valor.isEmpty()){
                return valor;
            }
            System.out.println("Error: este campo no puede estar vacío");
        }
    }

    // Leer entero positivo
    private static int leerEnteroPositivo(String mensaje){
        while (true){
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(sc.nextLine());
                if (Validador.esEnteroPositivo(valor)) return valor;
                System.out.println("Error: debe ser mayor a cero");
            } catch (NumberFormatException e){
                System.out.println("Error: debe ser un número entero válido");
            }
        }
    }

    // Leer double positivo
    private static double leerDoublePositivo(String mensaje){
        while (true){
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(sc.nextLine());
                if (Validador.esDoblePositivo(valor)) return valor;
                System.out.println("Error: debe ser mayor a cero");
            } catch (NumberFormatException e){
                System.out.println("Error: debe ser un número válido");
            }
        }
    }

    // Leer edad con validación específica
    private static int leerEdad(){
        while (true){
            try {
                System.out.print("Edad: ");
                int edad = Integer.parseInt(sc.nextLine());
                if (Validador.edadValida(edad)) return edad;
                System.out.println("Error: edad debe estar entre 1 y 149 años");
            } catch (NumberFormatException e){
                System.out.println("Error: debe ser un número entero válido");
            }
        }
    }

    // Leer teléfono (solo números)
    private static String leerTelefono(){
        while (true){
            System.out.print("Teléfono: ");
            String telefono = sc.nextLine().trim();
            if (Validador.telefonoValido(telefono)) return telefono;
            System.out.println("Error: el teléfono solo debe contener números");
        }
    }

    // Leer correo (debe contener @ y .)
    private static String leerCorreo(){
        while (true){
            System.out.print("Correo: ");
            String correo = sc.nextLine().trim();
            if (Validador.correoValido(correo)) return correo;
            System.out.println("Error: correo inválido, debe contener '@' y '.'");
        }
    }

    // Leer cédula única
    private static String leerCedulaUnica(){
        while (true){
            System.out.print("Cédula: ");
            String cedula = sc.nextLine().trim();
            if (cedula.isEmpty()){
                System.out.println("Error: cédula no puede estar vacía");
                continue;
            }
            if (!servicio.existeCedula(cedula)) return cedula;
            System.out.println("Error: ya existe un empleado con esa cédula");
        }
    }

    private static String leerCedulaExistente(String mensaje){
        while (true){
            System.out.print(mensaje);
            String cedula = sc.nextLine().trim();
            if (cedula.isEmpty()){
                System.out.println("Error: cédula no puede estar vacía");
                continue;
            }
            if (servicio.existeCedula(cedula)) return cedula;
            System.out.println("Error: no existe un empleado con esa cédula");
        }
    }

    // RF01: Registrar médico
    private static void registrarMedico(){
        System.out.println("\n--- REGISTRAR MÉDICO ---");
        String cedula = leerCedulaUnica();
        String nombre = leerStringNoVacio("Nombre: ");
        int edad = leerEdad();
        String telefono = leerTelefono();
        String correo = leerCorreo();
        String especialidad = leerStringNoVacio("Especialidad: ");
        int pacientes = leerEnteroPositivo("Número de pacientes atendidos: ");
        double valorConsulta = leerDoublePositivo("Valor por consulta: $");

        Medico medico = new Medico(cedula, nombre, edad, telefono, correo, especialidad, pacientes, valorConsulta);
        servicio.registrar(medico);
        System.out.println("✅ Médico registrado exitosamente\n");
    }

    // RF02: Registrar administrativo
    private static void registrarAdministrativo(){
        System.out.println("\n--- REGISTRAR ADMINISTRATIVO ---");
        String cedula = leerCedulaUnica();
        String nombre = leerStringNoVacio("Nombre: ");
        int edad = leerEdad();
        String telefono = leerTelefono();
        String correo = leerCorreo();
        String departamento = leerStringNoVacio("Departamento: ");
        int horas = leerEnteroPositivo("Horas trabajadas: ");
        double valorHora = leerDoublePositivo("Valor por hora: $");

        Administrativo admin = new Administrativo(cedula, nombre, edad, telefono, correo, departamento, horas, valorHora);
        servicio.registrar(admin);
        System.out.println("✅ Administrativo registrado exitosamente\n");
    }

    // RF03: Mostrar todos los empleados
    private static void mostrarEmpleados(){
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        ArrayList<Empleado> empleados = servicio.listarTodos();
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados\n");
            return;
        }
        for (Empleado e : empleados){
            System.out.println("─────────────────────────");
            e.mostrarInformacion();
        }
        System.out.println("─────────────────────────\n");
    }

    // RF04: Buscar por cédula
    private static void buscarPorCedula(){
        System.out.println("\n--- BUSCAR EMPLEADO ---");
        String cedula = leerCedulaExistente("Cédula a buscar: ");
        Empleado e = servicio.buscarPorCedula(cedula);
        System.out.println("─────────────────────────");
        e.mostrarInformacion();
        System.out.println("─────────────────────────\n");
    }


}

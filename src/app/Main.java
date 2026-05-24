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
                System.out.print("Opcion: ");
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

    // Opciones del crud en main:
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
        System.out.println("Médico registrado exitosamente\n");
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
        System.out.println("Administrativo registrado exitosamente\n");
    }

    // RF03: Mostrar todos los empleados
    private static void mostrarEmpleados(){
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        ArrayList<Empleado> empleados = servicio.listarTodos();
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados.\n");
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
        if (servicio.listarTodos().isEmpty()){
            System.out.println("No hay empleados registrados.\n");
            return;
        }
        String cedula = leerCedulaExistente("Cédula a buscar: ");
        Empleado e = servicio.buscarPorCedula(cedula);
        System.out.println("─────────────────────────");
        e.mostrarInformacion();
        System.out.println("─────────────────────────\n");
    }

    // RF05: Reemplazar información
    private static void reemplazarInformacion(){
        System.out.println("\n--- REEMPLAZAR EMPLEADO ---");
        if (servicio.listarTodos().isEmpty()){
            System.out.println("No hay empleados registrados.\n");
            return;
        }
        String cedula = leerCedulaExistente("Cédula del empleado a reemplazar: ");
        Empleado existente = servicio.buscarPorCedula(cedula);

        System.out.println("\nDatos actuales:");
        System.out.println("─────────────────────────");
        existente.mostrarInformacion();
        System.out.println("─────────────────────────");

        System.out.println("\nIngrese los nuevos datos:");

        String nombre = leerStringNoVacio("Nuevo nombre: ");
        int edad = leerEdad();
        String telefono = leerTelefono();
        String correo = leerCorreo();

        Empleado nuevo;

        if (existente instanceof Medico){
            Medico m = (Medico) existente;
            String especialidad = leerStringNoVacio("Nueva especialidad: ");
            int pacientes = leerEnteroPositivo("Nuevo número de pacientes: ");
            double valorConsulta = leerDoublePositivo("Nuevo valor por consulta: $");
            nuevo = new Medico(cedula, nombre, edad, telefono, correo, especialidad, pacientes, valorConsulta);
        } else {
            Administrativo a = (Administrativo) existente;
            String departamento = leerStringNoVacio("Nuevo departamento: ");
            int horas = leerEnteroPositivo("Nuevas horas trabajadas: ");
            double valorHora = leerDoublePositivo("Nuevo valor por hora: $");
            nuevo = new Administrativo(cedula, nombre, edad, telefono, correo, departamento, horas, valorHora);
        }

        if (servicio.reemplazar(cedula, nuevo)){
            System.out.println("Información reemplazada exitosamente\n");
        } else {
            System.out.println("Error al reemplazar\n");
        }
    }

    // RF06: Eliminar registro
    private static void eliminarRegistro(){
        System.out.println("\n--- ELIMINAR EMPLEADO ---");
        if (servicio.listarTodos().isEmpty()){
            System.out.println("No hay empleados registrados.\n");
            return;
        }
        String cedula = leerCedulaExistente("Cédula del empleado a eliminar: ");
        Empleado e = servicio.buscarPorCedula(cedula);
        System.out.println("─────────────────────────");
        e.mostrarInformacion();
        System.out.println("─────────────────────────");

        if (servicio.eliminarPorCedula(cedula)){
            System.out.println("Empleado eliminado exitosamente\n");
        } else {
            System.out.println("Error al eliminar\n");
        }
    }

    // RF07: Calcular pagos (mostrar todos los pagos)
    private static void calcularPagos(){
        System.out.println("\n--- CÁLCULO DE PAGOS ---");
        ArrayList<Empleado> empleados = servicio.listarTodos();
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados.\n");
            return;
        }
        double totalGeneral = 0;
        for (Empleado e : empleados){
            System.out.println("─────────────────────────");
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Cédula: " + e.getCedula());
            double pago = e.calcularPago();
            System.out.println("Pago: $" + pago);
            totalGeneral += pago;
        }
        System.out.println("─────────────────────────");
        System.out.println("TOTAL GENERAL A PAGAR: $" + totalGeneral);
        System.out.println();
    }

    // RF08: Mostrar estadísticas
    private static void mostrarEstadisticas(){
        System.out.println("\n--- ESTADÍSTICAS ---");
        ArrayList<Empleado> empleados = servicio.listarTodos();

        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados.\n");
            return;
        }

        int totalMedicos = 0;
        int totalAdministrativos = 0;
        double totalPagoMedicos = 0;
        double totalPagoAdministrativos = 0;
        Empleado mayorIngreso = null;
        double mayorPago = -1;

        for (Empleado e : empleados){
            double pago = e.calcularPago();

            if (e instanceof Medico){
                totalMedicos++;
                totalPagoMedicos += pago;
            } else {
                totalAdministrativos++;
                totalPagoAdministrativos += pago;
            }

            if (pago > mayorPago){
                mayorPago = pago;
                mayorIngreso = e;
            }
        }

        System.out.println("Total médicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdministrativos);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total médicos: $" + totalPagoMedicos);
        System.out.println("Pago total administrativos: $" + totalPagoAdministrativos);

        if (mayorIngreso != null){
            System.out.println("Empleado con mayor ingreso: " + mayorIngreso.getNombre() + " - $" + mayorPago);
        }
        System.out.println();
    }
}

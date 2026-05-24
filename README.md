# Sistema de Gestión de Personal - Clínica Salud Total - Tarea Integradora

## Requerimientos funcionales cumplidos

| Funcionalidad | Estado |
|---------------|--------|
| Registrar médicos | ✅ |
| Registrar administrativos | ✅ |
| Mostrar registros | ✅ |
| Buscar por cédula | ✅ |
| Reemplazar información | ✅ |
| Eliminar registros | ✅ |
| Calcular pagos | ✅ |
| Mostrar estadísticas | ✅ |
| Salir | ✅ |

## Modelo POO implementado

### Clase padre abstracta: `Empleado`
**Atributos privados:** cédula, nombre, edad, teléfono, correo  
**Métodos:** `mostrarInformacion()`, `calcularPago()` (abstracto)

### Subclase `Medico`
**Atributos:** especialidad, numeroPacientesAtendidos, valorConsulta  
**Cálculo de pago:** `pago = pacientesAtendidos × valorConsulta`

### Subclase `Administrativo`
**Atributos:** departamento, horasTrabajadas, valorHora  
**Cálculo de pago:** `pago = horasTrabajadas × valorHora`

## CRUD implementado

| Operación | Método en `EmpleadoServicio` |
|-----------|------------------------------|
| CREATE | `registrar(Empleado e)` |
| READ | `listarTodos()` / `buscarPorCedula(String cedula)` |
| UPDATE | `reemplazar(String cedula, Empleado nuevo)` |
| DELETE | `eliminarPorCedula(String cedula)` |

## Búsqueda por cédula
- Si existe: muestra información completa
- Si no existe: mensaje "no existe un empleado con esa cédula"

## Validaciones implementadas

| Entrada | Validación |
|---------|-------------|
| Menú | números 1-9 (try-catch) |
| Edad | 1 - 149 años |
| Cédula | no duplicada, no vacía |
| Nombre | no vacío |
| Correo | contiene @ |
| Teléfono | solo números |
| Pacientes atendidos | > 0 |
| Valor consulta | > 0 |
| Horas trabajadas | > 0 |
| Valor hora | > 0 |
| Especialidad | no vacía |
| Departamento | no vacío |

## Manejo de excepciones (try-catch)
- Menú principal (`NumberFormatException`)
- Conversiones numéricas (`Integer.parseInt()`, `Double.parseDouble()`)
- Datos numéricos en general

## Conversiones aplicadas
- `Integer.parseInt()` para convertir String → int
- `Double.parseDouble()` para convertir String → double
- Casting explícito `(int)` para double → int (pérdida de decimales)

## Polimorfismo
- `ArrayList<Empleado>` almacena objetos `Medico` y `Administrativo`
- `calcularPago()` se comporta diferente según el tipo de empleado

## Estadísticas mostradas
- Total médicos
- Total administrativos
- Total empleados
- Pago total médicos
- Pago total administrativos
- Empleado con mayor ingreso

src/
    modelo/
        Empleado.java
        Medico.java
        Administrativo.java
    servicio/
        EmpleadoServicio.java
    util/
        Validador.java
    app/
        Main.java

Autor
Alejandro Aguirre

Fecha
24/05/2026

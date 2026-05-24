package servicio;

import modelo.Empleado;
import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void registrar(Empleado e){
        empleados.add(e);
    }

    public Empleado buscarPorCedula(String cedula){
        for (Empleado e : empleados){
            if (e.getCedula().equals(cedula)){
                return e;
            }
        }
        return null;
    }

    public boolean eliminarPorCedula(String cedula){
        Empleado e = buscarPorCedula(cedula);
        if (e != null){
            empleados.remove(e);
            return true;
        }
        return false;
    }

    public boolean reemplazar(String cedula, Empleado nuevo){
        int index = -1;
        for (int i=0; i< empleados.size(); i++){
            if (empleados.get(i).getCedula().equals(cedula)){
                index = 1;
                break;
            }
        }
        if (index != -1){
            empleados.set(index, nuevo);
            return true;
        }
        return false;
    }

    public ArrayList<Empleado> listarTodos(){
        return empleados;
    }

    public boolean existeCedula(String cedula){
        return buscarPorCedula(cedula) != null;
    }
}

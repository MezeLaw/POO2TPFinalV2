package personas;

import institucion.Clinica;
import institucion.Prestacion;

import java.util.ArrayList;

public class Administrativo extends Persona{


    public Administrativo(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    public Administrativo(){
        super(0, null, null);
    }


//TODO definir e implementar funcionalidad

    public void agregarPrestacion(){
        //Esto agrega la prestacion creada a la clinica->prestaciones
    }

    public ArrayList<Prestacion> obtenerPrestacionesActivasDeLaClinica(){
        return null;
    }
}

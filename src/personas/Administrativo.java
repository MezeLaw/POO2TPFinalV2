package personas;

import institucion.Clinica;
import institucion.Prestacion;

import java.util.ArrayList;

public class Administrativo extends Persona{

    private Clinica clinica = Clinica.getInstance();

    public Administrativo(){}

    //TODO definir e implementar funcionalidad

    public void agregarPrestacion(){
        //Esto agrega la prestacion creada a la clinica->prestaciones
    }

    public ArrayList<Prestacion> obtenerPrestacionesActivasDeLaClinica(){
        return null;
    }
}

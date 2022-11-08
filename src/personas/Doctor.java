package personas;

import institucion.Especialidad;
import institucion.Prestacion;
import institucion.Turno;

import java.util.ArrayList;

public class Doctor extends Persona {


    private Especialidad especialidad;

    public Doctor() {
        super(0, null, null);
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    //TODO definir e implementar funcionalidad
    public void registrarAsistencia(Turno turno) {

    }

    public void atenderAlPaciente(Prestacion prestacion, ArrayList<String> prescripciones) {
        //Aca si es un Estudio solo llena la fechaDeRealizacion y cambia el boolean asistio

        //Si es una prestacionTradicional y prescripciones.size()>0 las agrego a 'prescripciones' o bien le prescribo que vuelva por control (arbitratiamente)
    }


}

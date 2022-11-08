package personas;

import institucion.Prestacion;
import institucion.Turno;

import java.util.ArrayList;

public class Doctor extends Persona {

    //En este MVP los doctores no tienen una especialidad definida
    public Doctor() {
    }


    //TODO definir e implementar funcionalidad
    public void registrarAsistencia(Turno turno) {

    }

    public void atenderAlPaciente(Prestacion prestacion, ArrayList<String> prescripciones) {
        //Aca si es un Estudio solo llena la fechaDeRealizacion y cambia el boolean asistio

        //Si es una prestacionTradicional y prescripciones.size()>0 las agrego a 'prescripciones' o bien le prescribo que vuelva por control (arbitratiamente)
    }


}

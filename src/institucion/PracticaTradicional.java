package institucion;

import java.util.ArrayList;

public class PracticaTradicional extends  Prestacion {

    private ArrayList<String> prescripciones;

    public PracticaTradicional(){}

    public ArrayList<String> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(ArrayList<String> prescripciones) {
        this.prescripciones = prescripciones;
    }
}

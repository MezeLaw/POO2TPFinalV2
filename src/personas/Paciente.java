package personas;

import institucion.Turno;

import java.util.ArrayList;

public class Paciente extends Persona{

    private String id;
    private ArrayList<Turno> turnosAsociados;
    private String cobertura;

    public Paciente(){}

    public ArrayList<Turno> getTurnosAsociados() {
        return turnosAsociados;
    }

    public void setTurnosAsociados(ArrayList<Turno> turnosAsociados) {
        this.turnosAsociados = turnosAsociados;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //TODO definir e implementar funcionalidad

}

package institucion;

import personas.Doctor;

//Especialidad para nosotros es el areaMedica
public class Especialidad {
    private Doctor coordinador;
    private String nombre;
    private boolean activa;

    public Especialidad(){}

    public Doctor getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Doctor coordinador) {
        this.coordinador = coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}

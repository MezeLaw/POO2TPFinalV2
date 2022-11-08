package institucion;

import personas.Doctor;

public abstract class Prestacion {

    private String nombre;
    private Doctor doctor;
    private boolean activa;
    private boolean esEstudio;
    private Especialidad especialidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isEsEstudio() {
        return esEstudio;
    }

    public void setEsEstudio(boolean esEstudio) {
        this.esEstudio = esEstudio;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}

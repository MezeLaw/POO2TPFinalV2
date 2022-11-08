package institucion;

import personas.Paciente;

import java.time.LocalDateTime;

public class Turno {

    private String id;
    private boolean asistio;
    private Prestacion prestacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String ubicacion; //TODO Laboratorio o consultorio
    private Paciente paciente;

    private boolean esSobreturno;

    private boolean disponible;

    public Turno(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public Prestacion getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(Prestacion prestacion) {
        this.prestacion = prestacion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isEsSobreturno() {
        return esSobreturno;
    }

    public void setEsSobreturno(boolean esSobreturno) {
        this.esSobreturno = esSobreturno;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

package institucion;

import java.time.LocalDateTime;

public class Estudio extends Prestacion {

    private String nombre;
    private LocalDateTime fechaYHoraDeRealizacion;
    private boolean asistio; //Cuando se asiste, se llena la fechaYhoraDeRealizacion y se cambia el valor de asistio atrue

    public Estudio(){}

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaYHoraDeRealizacion() {
        return fechaYHoraDeRealizacion;
    }

    public void setFechaYHoraDeRealizacion(LocalDateTime fechaYHoraDeRealizacion) {
        this.fechaYHoraDeRealizacion = fechaYHoraDeRealizacion;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }
}

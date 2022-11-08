package institucion;

import personas.Administrativo;
import personas.Director;
import personas.Doctor;
import personas.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Clinica {

    public static Clinica instance;
    private ArrayList<Administrativo> empleadosAdministrativos;
    private Director director;
    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes; //Son pacientes. Si un administrativo, doctor o director quiere atenderse debe registrarse como paciente,
    private ArrayList<Turno> turnos; //Aca se cargaranlos turnos y sobreturnos, disponibles o no. Ambas cosas se manejan por flag.
    private ArrayList<Prestacion> prestaciones; //Adentro tiene la ESPECIALIDAD es decir una prestacion corresponde a una especialidad

    private ArrayList<Especialidad> especialidades;

    public Clinica() {

        this.setEmpleadosAdministrativos(new ArrayList<>());
        this.getEmpleadosAdministrativos().add(new Administrativo(12987123, "Ricky", "Maravilla"));

        Director direc = new Director();
        direc.setNombre("Ricardo");
        direc.setApellido("Fort");
        direc.setDni(37123957);

        /**
         *  Especialidades
         */

        this.especialidades = new ArrayList<>();

        Especialidad psicologia = new Especialidad();
        psicologia.setActiva(true);
        psicologia.setNombre("PSICOLOGIA");


        Especialidad ginecologia = new Especialidad();
        ginecologia.setNombre("GINECOLOGIA");
        ginecologia.setActiva(true);

        Especialidad medicinaClinica = new Especialidad();
        medicinaClinica.setNombre("MEDICINACLINICA");
        medicinaClinica.setActiva(true);


        this.especialidades.add(psicologia);
        this.especialidades.add(ginecologia);
        this.especialidades.add(medicinaClinica);

        /**
         * Doctores
         */
        Doctor mengetche = new Doctor();
        mengetche.setNombre("Jose");
        mengetche.setApellido("Mengetche");
        mengetche.setEspecialidad(ginecologia);

        Doctor bilardo = new Doctor();
        bilardo.setNombre("Dr");
        bilardo.setApellido("Bilardo");
        bilardo.setEspecialidad(medicinaClinica);

        Doctor mercedes = new Doctor();
        mercedes.setNombre("Mercedes");
        mercedes.setApellido("Passucci");
        mercedes.setEspecialidad(psicologia);

        /**
         * Prestaciones (3)
         */

        PracticaTradicional terapia = new PracticaTradicional();
        terapia.setActiva(true);
        terapia.setEsEstudio(false);
        terapia.setDoctor(mercedes);
        terapia.setNombre("TERAPIA");
        terapia.setEspecialidad(psicologia);

        Estudio ecografia = new Estudio();
        ecografia.setDoctor(bilardo);
        ecografia.setEsEstudio(true);
        ecografia.setActiva(true);
        ecografia.setNombre("ECOGRAFIA");
        ecografia.setEspecialidad(ginecologia);

        PracticaTradicional consulta = new PracticaTradicional();
        consulta.setActiva(true);
        consulta.setEsEstudio(false);
        consulta.setDoctor(mengetche);
        consulta.setNombre("CONSULTA");
        consulta.setEspecialidad(medicinaClinica);

        this.doctores = new ArrayList<>();

        doctores.add(mercedes);
        doctores.add(mengetche);
        doctores.add(bilardo);

        this.pacientes = new ArrayList<>();

        this.prestaciones = new ArrayList<>();
        this.prestaciones.add(consulta);
        this.prestaciones.add(terapia);
        this.prestaciones.add(ecografia);

        /**
         * Turnos por decision arbitraria solo habra 4 turnos al dia
         */

        LocalDateTime hoy = LocalDateTime.now();

        Turno t1 = new Turno();
        Turno t2 = new Turno();
        Turno t3 = new Turno();
        Turno t4 = new Turno();

        t1.setId(UUID.randomUUID().toString());
        t2.setId(UUID.randomUUID().toString());
        t3.setId(UUID.randomUUID().toString());
        t4.setId(UUID.randomUUID().toString());

        t1.setDisponible(true);
        t2.setDisponible(true);
        t3.setDisponible(true);
        t4.setDisponible(true);

        t1.setEsSobreturno(false);
        t2.setEsSobreturno(false);
        t3.setEsSobreturno(false);
        t4.setEsSobreturno(false);

        LocalDateTime turno1Inicio = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 9, 0);
        LocalDateTime turno1Fin = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 10, 0);
        LocalDateTime turno2Inicio = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 11, 0);
        LocalDateTime turno2Fin = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 12, 0);
        LocalDateTime turno3Inicio = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 14, 0);
        LocalDateTime turno3Fin = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 15, 0);
        LocalDateTime turno4Inicio = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 15, 0);
        LocalDateTime turno4Fin = LocalDateTime.of(hoy.getYear(), hoy.getMonth(), hoy.getDayOfMonth(), 16, 0);

        t1.setFechaInicio(turno1Inicio);
        t1.setFechaFin(turno1Fin);
        t1.setUbicacion("CONSULTORIO");

        t2.setFechaInicio(turno2Inicio);
        t2.setFechaFin(turno2Fin);
        t2.setUbicacion("CONSULTORIO");

        t3.setFechaInicio(turno3Inicio);
        t3.setFechaFin(turno3Fin);
        t3.setUbicacion("ZOOM");

        t4.setFechaInicio(turno4Inicio);
        t4.setFechaFin(turno4Fin);
        t4.setUbicacion("DOMICILIO");


        /**
         * Sobreturnos
         */
        Turno st1 = new Turno();
        Turno st2 = new Turno();

        st1.setId(UUID.randomUUID().toString());
        st2.setId(UUID.randomUUID().toString());
        st1.setEsSobreturno(true);
        st2.setEsSobreturno(true);

        st1.setFechaInicio(turno1Inicio);
        st1.setFechaFin(turno1Fin);
        st2.setFechaInicio(turno2Inicio);
        st2.setFechaFin(turno2Fin);

        st1.setUbicacion("CONSULTORIO");
        st2.setUbicacion("CONSULTORIO");

        st1.setDisponible(true);
        st2.setDisponible(true);

        this.turnos = new ArrayList<>();
        this.turnos.add(t1);
        this.turnos.add(t2);
        this.turnos.add(t3);
        this.turnos.add(t4);
        this.turnos.add(st1);
        this.turnos.add(st2);

    }

    public static Clinica getInstance() {
        if (instance == null) {
            instance = new Clinica();
        }
        return instance;
    }

    public ArrayList<Administrativo> getEmpleadosAdministrativos() {
        return empleadosAdministrativos;
    }

    public void setEmpleadosAdministrativos(ArrayList<Administrativo> empleadosAdministrativos) {
        this.empleadosAdministrativos = empleadosAdministrativos;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    public ArrayList<Prestacion> getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
        this.prestaciones = prestaciones;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
}

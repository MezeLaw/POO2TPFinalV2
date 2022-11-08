package personas;

import institucion.*;

import java.util.Scanner;

public class Administrativo extends Persona {


    public Administrativo(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    public Administrativo() {
        super(0, null, null);
    }


//TODO definir e implementar funcionalidad

    public void agregarPrestacion(Especialidad especialidad, Scanner sn, boolean esEstudio) {
        //Esto agrega la prestacion creada a la clinica->prestaciones
        //clinica.getPrestaciones().add(prestacion);
        Clinica clinica = Clinica.getInstance();
        if (esEstudio) {
            System.out.println("Ingrese nombre del estudio");
            String estudioNombre = sn.next().toUpperCase();

            Estudio estudio = new Estudio();
            estudio.setNombre(estudioNombre);
            Doctor doc = clinica.getDoctores().stream().filter(d -> d.getEspecialidad().getNombre().equals(especialidad.getNombre())).findFirst().get();
            estudio.setDoctor(doc);
            estudio.setEspecialidad(especialidad);
            estudio.setActiva(true);
            clinica.getPrestaciones().add(estudio);
        } else {

            System.out.println("Ingrese nombre de la practica");
            String ptnombre = sn.nextLine().toUpperCase();

            PracticaTradicional pt = new PracticaTradicional();
            pt.setNombre(ptnombre);
            Doctor docPractica = clinica.getDoctores().stream().filter(d -> d.getEspecialidad().getNombre().equals(especialidad.getNombre())).findFirst().get();
            pt.setDoctor(docPractica);
            pt.setEspecialidad(especialidad);
            pt.setActiva(true);
            clinica.getPrestaciones().add(pt);
        }
    }

    public void obtenerPrestacionesActivasDeLaClinica() {
        Clinica clinica = Clinica.getInstance();
        for (int i = 0; i < clinica.getPrestaciones().size(); i++) {
            if (clinica.getPrestaciones().get(i).isActiva()) {
                System.out.println(clinica.getPrestaciones().get(i).getNombre());
            }
        }
    }

    public void verTurnosDisponibles() {
        Clinica clinica = Clinica.getInstance();
        for (int i = 0; i < clinica.getTurnos().size(); i++) {
            if (clinica.getTurnos().get(i).isDisponible()) {
                System.out.println("->" + i + "- ID:" + clinica.getTurnos().get(i).getId() + "    ----------------    "
                        + clinica.getTurnos().get(i).getFechaInicio() + " - " + clinica.getTurnos().get(i).getFechaFin()
                        + "Disponible: " + clinica.getTurnos().get(i).isDisponible() + " Es sobreturno: "
                        + clinica.getTurnos().get(i).isEsSobreturno());
            }
        }
    }

    public void verTurnosTomadosPorDNI(int dni) {
        Clinica clinica = Clinica.getInstance();
        Paciente pacienteEncontrado = null;

        pacienteEncontrado = getPacientePorDNI(dni);

        if (pacienteEncontrado == null) {
            System.out.println("El paciente no se encuentra en la base de datos.");

        } else if (pacienteEncontrado.getTurnosAsociados() == null || pacienteEncontrado.getTurnosAsociados().size() < 1) {
            System.out.println("El paciente no registra turnos.");

        } else {
            System.out.println("TURNOS ENCONTRADOS:");
            for (Turno t : pacienteEncontrado.getTurnosAsociados()) {
                System.out.println(t.getId() + " - " + t.getPrestacion().getNombre());
            }
        }

    }

    public void darTurno(Scanner sn) {
        Clinica clinica = Clinica.getInstance();
        System.out.println("Ingrese el DNI del paciente: ");
        int dni = sn.nextInt();

        Paciente paciente = getPacientePorDNI(dni);

        if (paciente == null) {
            //Este MVP no crea pacientes si no existe previamente
            System.out.println("Paciente no encontrado");
        } else {
            System.out.println("Seleccione la prestacion a realizar:");

            for (int i = 0; i < clinica.getPrestaciones().size(); i++) {
                if (clinica.getPrestaciones().get(i).isActiva()) {
                    System.out.println(i + " - " + clinica.getPrestaciones().get(i).getNombre());
                }
            }

            int prestacionElegida = sn.nextInt();

            //Medico que da esa prestacion

            Doctor doc = clinica.getPrestaciones().get(prestacionElegida).getDoctor();

            System.out.println("Seleccione un turno de los disponibles: ");
            for (int i = 0; i < clinica.getTurnos().size(); i++) {
                if (clinica.getTurnos().get(i).isDisponible()) {
                    System.out.println(i + " - " + clinica.getTurnos().get(i).getFechaInicio());
                }
            }

            int turnoSeleccionado = sn.nextInt();
            Turno turnoElegido = clinica.getTurnos().get(turnoSeleccionado);
            turnoElegido.setPrestacion(clinica.getPrestaciones().get(prestacionElegida));
            turnoElegido.setDisponible(false);
            turnoElegido.setPaciente(paciente);
            clinica.getTurnos().set(turnoSeleccionado, turnoElegido);
            paciente.getTurnosAsociados().add(turnoElegido);
        }

    }

    public Paciente getPacientePorDNI(int dni) {
        Clinica clinica = Clinica.getInstance();
        for (Paciente p : clinica.getPacientes()) {
            if (p.getDni() == dni) {
                return p;
            }
        }
        return null;
    }
}

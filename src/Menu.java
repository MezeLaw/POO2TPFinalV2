import institucion.*;
import personas.Doctor;

import java.util.Scanner;

public class Menu {

    public static void mostrarMenu(Clinica clinica) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int op;

        while (!salir) {
            System.out.println("1. Menu Director");
            System.out.println("2. Menu Administrativo");
            System.out.println("3. Menu Doctor");
            System.out.println("0. Salir");
            try {
                op = sn.nextInt();
                switch (op) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Seleccione la opcion deseada:");
                        System.out.println("1. Agregar prestacion");        //En este primer diseño no inhabilitaremos prestaciones
                        System.out.println("2. Ver prestaciones activas");  //En este primer diseño solo veremos activas
                        System.out.println("3. Ver turnos disponibles");    //En este primer diseño no buscaremos por especialidad veremos si hay lugar
                        System.out.println("4. Turnos tomados por DNI");
                        System.out.println("5. Dar turno");
                        System.out.println("0. Salir");


                        int opcionElegida = sn.nextInt();

                        switch (opcionElegida){
                            case 1:
                                System.out.println("Seleccione:");
                                System.out.println("1. Prestacion - estudio");
                                System.out.println("2- Prestacion tradicional");

                                int prestacionDeseada = sn.nextInt();

                                switch (prestacionDeseada){
                                    case 1:
                                        System.out.println("Elija especialidad: ");
                                        for(int i=0; i<clinica.getEspecialidades().size(); i++){
                                            System.out.println(i +" - " + clinica.getEspecialidades().get(i).getNombre());
                                        }

                                        int esp = sn.nextInt();

                                        Especialidad especial = clinica.getEspecialidades().get(esp);

                                        System.out.println("Ingrese nombre del estudio");
                                        String estudioNombre = sn.next().toUpperCase();

                                        Estudio estudio = new Estudio();
                                        estudio.setNombre(estudioNombre);
                                        Doctor doc = clinica.getDoctores().stream().filter(d->d.getEspecialidad().getNombre().equals(especial.getNombre())).findFirst().get();
                                        estudio.setDoctor(doc);
                                        estudio.setEspecialidad(especial);
                                        estudio.setActiva(true);
                                        clinica.getPrestaciones().add(estudio);
                                        break;
                                    case 2:
                                        System.out.println("Elija especialidad: ");
                                        for(int i=0; i<clinica.getEspecialidades().size(); i++){
                                            System.out.println(i +" - " + clinica.getEspecialidades().get(i).getNombre());
                                        }

                                        int esp2 = sn.nextInt();

                                        Especialidad especial2 = clinica.getEspecialidades().get(esp2);

                                        System.out.println("Ingrese nombre de la practica");
                                        String ptnombre = sn.nextLine().toUpperCase();

                                        PracticaTradicional pt = new PracticaTradicional();
                                        pt.setNombre(ptnombre);
                                        Doctor docPractica = clinica.getDoctores().stream().filter(d->d.getEspecialidad().getNombre().equals(especial2.getNombre())).findFirst().get();
                                        pt.setDoctor(docPractica);
                                        pt.setEspecialidad(especial2);
                                        pt.setActiva(true);
                                        clinica.getPrestaciones().add(pt);
                                        break;
                                    default:
                                        System.out.println("Opcion invalida -> Ingrese una opcion por favor");
                                        mostrarMenu(clinica);
                                }
                                mostrarMenu(clinica);
                                break;
                            case 2:
                                for(int i=0; i<clinica.getPrestaciones().size(); i++){
                                    if(clinica.getPrestaciones().get(i).isActiva()){
                                        System.out.println(clinica.getPrestaciones().get(i).getNombre());
                                    }
                                }
                                mostrarMenu(clinica);
                                break;

                            case 3:
                                for(int i=0; i<clinica.getTurnos().size(); i++){
                                    if(clinica.getTurnos().get(i).isDisponible()){
                                        System.out.println( "->" +i + "- ID:" + clinica.getTurnos().get(i).getId() + "    ----------------    " + clinica.getTurnos().get(i).getFechaInicio() + " - " + clinica.getTurnos().get(i).getFechaFin());
                                    }
                                }
                                mostrarMenu(clinica);
                                break;
                            case 4:

                            case 5:

                            case 6:
                                mostrarMenu(clinica);
                            default:
                                System.out.println("Opcion invalida -> Ingrese una opcion por favor");
                                mostrarMenu(clinica);
                        }

                        break;
                    case 3:
                        //MenuDoctor.mostrarMenu(sn);
                        break;
                    case 4:
                        //MenuPaciente.mostrarMenu(administrativo, sn);
                        break;
                    case 0:
                        System.out.println("Has seleccionado la opcion 0");
                        System.out.println("Saliendo del sistema...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4. Opcion 0 para salir.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error al procesar su solicitud. Seleccione la opcion:");
            }
        }
    }
}
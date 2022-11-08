import institucion.*;
import personas.Administrativo;
import personas.Doctor;
import personas.Paciente;

import java.util.ArrayList;
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

                        switch (opcionElegida) {
                            case 1:
                                System.out.println("Seleccione:");
                                System.out.println("1. Prestacion - estudio");
                                System.out.println("2- Prestacion tradicional");

                                int prestacionDeseada = sn.nextInt();

                                switch (prestacionDeseada) {
                                    case 1:
                                        //Recupero al unico administrativo -- MVP obtengo arbitrariamente el de posicion 0
                                        //Siempre la clinica tendra a lmenos 1 administrativo
                                        System.out.println("Elija especialidad: ");
                                        for (int i = 0; i < clinica.getEspecialidades().size(); i++) {
                                            System.out.println(i + " - " + clinica.getEspecialidades().get(i).getNombre());
                                        }

                                        int esp = sn.nextInt();
                                        Especialidad especial = clinica.getEspecialidades().get(esp);
                                        clinica.getEmpleadosAdministrativos().get(0).agregarPrestacion(especial, sn, true);
                                        break;
                                    case 2:
                                        System.out.println("Elija especialidad: ");
                                        for (int i = 0; i < clinica.getEspecialidades().size(); i++) {
                                            System.out.println(i + " - " + clinica.getEspecialidades().get(i).getNombre());
                                        }

                                        int esp2 = sn.nextInt();
                                        Especialidad especial2 = clinica.getEspecialidades().get(esp2);
                                        clinica.getEmpleadosAdministrativos().get(0).agregarPrestacion(especial2, sn, false);

                                        break;
                                    default:
                                        System.out.println("Opcion invalida -> Ingrese una opcion por favor");
                                        mostrarMenu(clinica);
                                }
                                mostrarMenu(clinica);
                                break;
                            case 2:
                                clinica.getEmpleadosAdministrativos().get(0).obtenerPrestacionesActivasDeLaClinica();
                                mostrarMenu(clinica);
                                break;
                            case 3:
                                clinica.getEmpleadosAdministrativos().get(0).verTurnosDisponibles();
                                mostrarMenu(clinica);
                                break;
                            case 4:
                                //TODO opcion ppal
                                System.out.println("Ingrese su DNI, sin PUNTOS POR FAVOR:");
                                //ESTO NO CONTEMPLA CASOS COMO DNI REPETIDOS
                                int dniIngresado = sn.nextInt();
                                clinica.getEmpleadosAdministrativos().get(0).verTurnosTomadosPorDNI(dniIngresado);
                                //ESTE MVP sufre un bug con numeros mayores al rango de int. Ideal seria utilizar string quizas..
                                mostrarMenu(clinica);
                                break;
                            case 5:
                                //DAR TURNO
                            case 0:
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
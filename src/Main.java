import institucion.Clinica;

public class Main {

    public static void main(String[] args) {

        Clinica clinica = Clinica.getInstance();

        System.out.println(">>>> Bienvenido a la Clinica de PUEBLO <<<");

        Menu.mostrarMenu(clinica);

    }

}

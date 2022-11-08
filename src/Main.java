import institucion.Clinica;

public class Main {

    public static void main(String[] args) {

        try {

        Clinica clinica = Clinica.getInstance();

        System.out.println(">>>> Bienvenido a la Clinica de PUEBLO <<<");

        MenuApp.mostrarMenu(clinica);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

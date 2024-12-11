import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);
    private SistemaMatriculas sistema = new SistemaMatriculas();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    private void menu() {
        int opcion;

        do {
            System.out.println("""
                    ======= MENU =======
                    1) Crear persona
                    2) Crear formacion
                    3) Matricula persona
                    4) Agrega curso a diplomado
                    5) Lista perso. formacion
                    6) Lista form. de persona
                    7) Salir
                    """);

            System.out.print("Opcion: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> creaPersona();
                case 2 -> creaFormacion();
                case 3 -> matriculaPersona();
                case 4 -> agregaCursoADiplomado();
                case 5 -> listaPersonasDeFormacion();
                case 6 -> listaFormacionesDePersonas();
                default -> System.out.println("Opcion no valida");
            }

        } while (opcion != 7);
    }

    private void creaPersona() {
        System.out.print("Rut: ");
        String rut = scan.next();

        System.out.print("Nombre de persona: ");
        String nombre = scan.next();

        if(sistema.creaPersona(rut, nombre)){
            System.out.println("Persona creada");
        }else{
            System.out.println("Persona non creada");
        }

    }

    private void creaFormacion(){
        System.out.print("Diplomado[1] o Curso[2]: ");
        int opcion = scan.nextInt();

        switch(opcion){
            case 1:
                System.out.print("Codigo: ");
                int codigo = scan.nextInt();

                System.out.print("Nombre: ");
                String nombre = scan.next();

                if(sistema.creaDiplomado(codigo,nombre)){
                    System.out.println("Diplomado creada");
                }else{
                    System.out.println("Diplomado non creada");
                }
                break;
            case 2:
                System.out.print("Codigo: ");
                int codigo2 = scan.nextInt();

                System.out.print("Nombre: ");
                String nombre2 = scan.next();

                System.out.print("Costo: ");
                int costo2 = scan.nextInt();

                if(sistema.creaCurso(codigo2,nombre2,costo2)){
                    System.out.println("Curso creada");
                }else{
                    System.out.println("Curso non creada");
                }
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private void matriculaPersona(){
        System.out.print("Rut: ");
        String rut = scan.next();

        System.out.print("Codigo programa formacion: ");
        int codigo = scan.nextInt();

        if(sistema.matriculaPersona(rut, codigo)){
            System.out.println("Matricula formacion creada");
        }else{
            System.out.println("Matricula non creada");
        }
    }

    private void agregaCursoADiplomado(){
        System.out.print("Ingrese codigo curso: ");
        int codigo = scan.nextInt();

        System.out.print("Ingrese codigo diplomado: ");
        int cod_dip = scan.nextInt();

        if(sistema.agregaCursoADiplomado(codigo,cod_dip)){
            System.out.println("Curso agregado creada");
        }else{
            System.out.println("Curso non creada");
        }

    }

    private void listaPersonasDeFormacion(){
        System.out.print("Ingrese codigo de programa de formacion: ");
        int codigoFormacion = scan.nextInt();

        String[][] listaP = sistema.listaPersonasDeFormacion(codigoFormacion);

        for (String[] strings : listaP) {
            System.out.printf("%10s | %10s \n", strings[0], strings[1]);
        }
    }

    private void listaFormacionesDePersonas(){
        System.out.print("Ingrese rut de persona: ");
        String rutPersona = scan.next();

        String[][] listaF = sistema.listaFormacionesDePersona(rutPersona);

        if(listaF == null){
            System.out.println("Error! Lista nula!");
            return;
        }

        for (String[] strings : listaF) {
            System.out.printf("%10s | %10s | %10s | %10s \n", strings[0], strings[1], strings[2], strings[3]);
        }
    }
}

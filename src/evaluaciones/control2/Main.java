package evaluaciones.control2;

import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);
    private SistemaMatriculas sistema = new SistemaMatriculas();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    private void menu(){

        int opcion;

        do{
            System.out.println("""
                -----Menu-----
                
                1) Crea ejercicios.persistencia.persona.Persona
                2) Crea Formacion
                3) Matricula ejercicios.persistencia.persona.Persona
                4) Agrega curso a dip.
                5) Lista personas de formacion
                6) Lista formaciones de persona.
                
                7) Salir
                """);

            System.out.print("Introduzca una opcion: ");
            opcion = scan.nextInt();

            switch (opcion){
                case 1 -> creaPersona();
                case 2 -> creaFormacion();
                case 3 -> matriculaPersona();
                case 4 -> agregaCursoADiplomado();
                case 5 -> listaPersonasDeFormacion();
                case 6 -> listaFormacionesDePersonas();
                case 7 -> System.out.print("Saliendo...");
                default -> System.out.print("Error!");
            }
        }while(opcion != 7);
    }

    private void creaPersona(){
        System.out.print("Ingrese rut: ");
        String rut = scan.next();
        System.out.print("Ingrese nombre: ");
        String nombre = scan.next();

        if(sistema.creaPersona(rut, nombre)){
            System.out.println("ejercicios.persistencia.persona.Persona con exito");
        }else{
            System.out.println("ejercicios.persistencia.persona.Persona Error!");
        }
    }

    private void creaFormacion(){
        System.out.print("Diplomado[1] o Curso[2]: ");
        int opcion = scan.nextInt();

        switch (opcion){
            case 1:
                System.out.print("Ingrese nombre: ");
                String nombre = scan.next();
                System.out.print("Ingrese codigo: ");
                int codigo = scan.nextInt();

                if(sistema.creaDiplomado(codigo, nombre)){
                    System.out.println("Formacion con exito");
                }else{
                    System.out.println("Formacion Error!");
                }
                break;
            case 2:
                System.out.print("Ingrese nombre: ");
                String nombre2 = scan.next();
                System.out.print("Ingrese codigo: ");
                int codigo2 = scan.nextInt();
                System.out.print("Ingrese costo: ");
                int costo2 = scan.nextInt();

                if(sistema.creaCurso(codigo2, nombre2, costo2)){
                    System.out.println("Formacion con exito");
                }else{
                    System.out.println("Formacion Error!");
                }
                break;
            default:
                System.out.println("Error!");
        }

    }

    private void matriculaPersona(){
        System.out.print("Ingrese rut persona: ");
        String rut = scan.next();
        System.out.print("Ingrese codigo formacion: ");
        int codigoFormacion = scan.nextInt();

        if(sistema.matriculaPersona(rut,codigoFormacion)){
            System.out.println("Operacion con exito");
        }else{
            System.out.println("Operacion Error!");
        }
    }

    private void agregaCursoADiplomado(){
        System.out.print("Ingrese codigo curso: ");
        int codigoCurso = scan.nextInt();
        System.out.print("Ingrese codigo dip. :");
        int codigoDip = scan.nextInt();

        if(sistema.agregaCursoADiplomado(codigoCurso,codigoDip)){
            System.out.println("Operacion con exito");
        }else{
            System.out.println("Operacion Error!");
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

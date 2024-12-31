package evaluaciones.control2;

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
                    \n-----Menu principal-----
                    
                    1) Crea persona
                    2) Crea formación
                    3) Matricula persona
                    4) Agrega curso a dip.
                    5) Lista personas de formación
                    6) Lista formaciones de persona.
                    7) Salir
                    """);

            System.out.print("Introduzca una opcion: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> creaPersona();
                case 2 -> creaFormacion();
                case 3 -> matriculaPersona();
                case 4 -> agregaCursoADiplomado();
                case 5 -> listaPersonasDeFormacion();
                case 6 -> listaFormacionesDePersonas();
                case 7 -> System.out.print("Saliendo...");
                default -> System.out.print("Error, Ingrese datos validos!\n");
            }
        } while (opcion != 7);
    }

    private void creaPersona() {
        System.out.print("Ingrese rut: ");
        String rut = scan.next();
        System.out.print("Ingrese nombre: ");
        String nombre = scan.next();

        if (sistema.creaPersona(rut, nombre)) {
            System.out.println("Persona creada con exito");
        } else {
            System.out.println("Error al crear persona!");
        }
    }

    private void creaFormacion() {
        System.out.print("Diplomado[1] o Curso[2]: ");
        int opcion = scan.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese nombre: ");
                String nombre = scan.next();
                System.out.print("Ingrese codigo: ");
                int codigo = scan.nextInt();

                if (sistema.creaDiplomado(codigo, nombre)) {
                    System.out.println("Formacion con exito");
                } else {
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

                if (sistema.creaCurso(codigo2, nombre2, costo2)) {
                    System.out.println("Formacion con exito");
                } else {
                    System.out.println("Formacion Error!");
                }
                break;
            default:
                System.out.println("Error!");
        }

    }

    private void matriculaPersona() {
        System.out.print("Ingrese rut persona: ");
        String rut = scan.next();
        System.out.print("Ingrese codigo formacion: ");
        int codigoFormacion = scan.nextInt();

        if (sistema.matriculaPersona(rut, codigoFormacion)) {
            System.out.println("Operacion con exito");
        } else {
            System.out.println("Operacion Error!");
        }
    }

    private void agregaCursoADiplomado() {
        System.out.print("Ingrese codigo curso: ");
        int codigoCurso = scan.nextInt();
        System.out.print("Ingrese codigo dip. :");
        int codigoDip = scan.nextInt();

        if (sistema.agregaCursoADiplomado(codigoCurso, codigoDip)) {
            System.out.println("Operacion con exito");
        } else {
            System.out.println("Operacion Error!");
        }
    }

    private void listaPersonasDeFormacion() {
        System.out.print("Ingrese codigo de programa de formacion: ");
        int codigoFormacion = scan.nextInt();

        String[][] listaP = sistema.listaPersonasDeFormacion(codigoFormacion);
        String nombre = sistema.getNombreFormacion(codigoFormacion);

        if (listaP.length == 0) {
            System.out.println("No se encontro el programa de formacion, o no existen datos");
            return;
        }

        System.out.println("Listado Personas de programa de formación '" + nombre.toUpperCase() + "'");
        System.out.printf("%-14s %-10s \n", "Rut", "Nombre");

        for (String[] strings : listaP) {
            System.out.printf("%-14s %-10s \n", strings[0], strings[1]);
        }

        System.out.println("Numero total de estudiantes matriculados: " + listaP.length);
    }

    private void listaFormacionesDePersonas() {
        double valorTotal = 0;

        System.out.print("Ingrese rut de persona: ");
        String rutPersona = scan.next();

        String[][] listaF = sistema.listaFormacionesDePersona(rutPersona);

        if (listaF.length == 0) {
            System.out.println("No se encontro la persona, o no existen datos");
            return;
        }

        System.out.println("Listado Programa de Formación de Persona '" + sistema.getNombrePersona(rutPersona) + "'");

        System.out.printf("%-10s %-15s %-10s %-10s \n","Codigo","Nombre","Tipo","Costo($)");
        for (String[] strings : listaF) {
            System.out.printf("%-10s %-15s %-10s %-10s \n", strings[0], strings[1], strings[2], strings[3]);

            if(!strings[3].equalsIgnoreCase("sin costo")){
                valorTotal += Double.parseDouble(strings[3]);
            }
        }

        System.out.println("Monto total programas: $" + valorTotal);
    }
}

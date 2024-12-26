package ejercicios.excepciones.c.Vista;

import ejercicios.excepciones.c.Controlador.BibliotecaDigitalController;

import java.util.Scanner;

public class BibliotecaDigitalView {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        mostrarMenu();
    }

    public static void mostrarMenu(){

        do{
            System.out.println("""
                ===== BIBLIOTECA =====
                1) Prestar libro
                2) Devolver libro
                3) Añadir libro
                4) Salir""");

            System.out.print(">> ");
            int puntero = sc.nextInt();

            switch (puntero) {
                case 1:
                    prestar();
                    break;
                case 2:
                    devolver();
                    break;
                case 3:
                    anadir();
                    break;
                case 4:
                    System.out.println(".:: Saliendo del programa ::.");
                    return;
                default:
                    System.out.println("Opcion invalida!");
                    break;
            }
        }while (true);
    }

    private static void prestar(){
        System.out.print("Ingrese titulo? >> ");
        String titulo = sc.next();
        BibliotecaDigitalController.getInstancia().prestarLibro(titulo);
    }

    private static void devolver(){
        System.out.print("Ingrese titulo? >> ");
        String titulo = sc.next();
        BibliotecaDigitalController.getInstancia().devolverLibro(titulo);
    }

    private static void anadir(){
        System.out.print("Ingrese titulo? >> ");
        String titulo = sc.next();
        System.out.print("Ingrese autor? >> ");
        String autor = sc.next();

        BibliotecaDigitalController.getInstancia().anadirLibro(titulo,autor);
    }
}

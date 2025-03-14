package ejercicios.excepciones.biblioteca_digital.Vista;

import ejercicios.excepciones.biblioteca_digital.Controlador.BibliotecaDigitalController;
import ejercicios.excepciones.biblioteca_digital.Excepcion.LibroNoDisponibleException;

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

        try{
            BibliotecaDigitalController.getInstancia().prestarLibro(titulo);
            System.out.println("[OPERACIÓN EXITOSA]");
        } catch (LibroNoDisponibleException e){
            System.out.println(e.getMessage());
        }
    }

    private static void devolver(){
        System.out.print("Ingrese titulo? >> ");
        String titulo = sc.next();

        try{
            BibliotecaDigitalController.getInstancia().devolverLibro(titulo);
            System.out.println("[OPERACIÓN EXITOSA]");
        } catch (LibroNoDisponibleException e){
            System.out.println(e.getMessage());
        }

    }

    private static void anadir(){
        System.out.print("Ingrese titulo? >> ");
        String titulo = sc.next();
        System.out.print("Ingrese autor? >> ");
        String autor = sc.next();

        try{
            BibliotecaDigitalController.getInstancia().anadirLibro(titulo,autor);
        } catch (LibroNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }
}

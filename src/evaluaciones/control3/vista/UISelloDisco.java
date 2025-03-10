package evaluaciones.control3.vista;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import evaluaciones.control3.controlador.ControlSelloDisco;
import evaluaciones.control3.excepciones.SelloDiscoExcepcion;
import evaluaciones.control3.modelo.Genero;

public class UISelloDisco {
    private static UISelloDisco obj = new UISelloDisco();

    public static UISelloDisco getInstance() {
        return obj;
    }

    private static Scanner scan = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("""
                    
                    =====[ Menú Principal] =====
                    1) Crear Álbum
                    2) Crear Canción
                    3) Agregar canción a álbum
                    4) Eliminar canción de álbum
                    5) Listar todos los álbumnes
                    6) Listar canciones de un género
                    7) Listar canciones de un álbum
                    8) Salir
                    """);

            System.out.print("? ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> creaAlbum();
                case 2 -> creaCancion();
                case 3 -> agregaCancionEnAlbum();
                case 4 -> eliminaCancionDeAlbum();
                case 5 -> listaAlbumes();
                case 6 -> listaCancionesDeGenero();
                case 7 -> listaCancionesDeAlbum();
                case 8 -> System.out.println("Saliendo....");
            }
        } while (opcion != 8);
    }

    private void creaAlbum() {
        System.out.print("Ingrese nombre? ");
        String nombre = scan.next();

        System.out.print("Ingrese fecha? ");
        String fecha = scan.next();
        LocalDate fecha_c = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try {
            ControlSelloDisco.getInstance().creaAlbum(nombre, fecha_c);
            System.out.println("[ÉXITO] Álbum creado exitosamente.");
        } catch (SelloDiscoExcepcion e) {
            System.out.println("[ERROR] " + e.getMessage() + ".");
        }
    }

    private void creaCancion() {
        Genero gen = Genero.ROCK;

        System.out.print("Ingrese nombre? ");
        String nombre = scan.next();

        System.out.print("Ingrese duración? ");
        float duracion = scan.nextFloat();

        System.out.print("Ingrese género? ");
        String genero = scan.next();

        gen = selectorGeneros(genero);

        System.out.print("Ingrese nombre del intérprete? ");
        String interprete = scan.next();

        try {
            ControlSelloDisco.getInstance().creaCancion(nombre, duracion, gen, interprete);
            System.out.println("[ÉXITO] Canción creada exitosamente.");
        } catch (SelloDiscoExcepcion e) {
            System.out.println("[ERROR] " + e.getMessage() + ".");
        }
    }

    private void agregaCancionEnAlbum() {
        System.out.print("Ingrese nombre de canción? ");
        String nombre = scan.next();

        System.out.print("Ingrese nombre de álbum? ");
        String nombreAlbum = scan.next();

        try {
            ControlSelloDisco.getInstance().agregaCancionEnAlbum(nombre, nombreAlbum);
            System.out.println("[ÉXITO] Canción agregada a Album.");
        } catch (SelloDiscoExcepcion e) {
            System.out.println("[ERROR] " + e.getMessage() + ".");
        }
    }

    private void eliminaCancionDeAlbum() {
        System.out.print("Ingrese nombre de canción? ");
        String nombre = scan.next();

        System.out.print("Ingrese nombre de álbum? ");
        String nombreAlbum = scan.next();

        try {
            ControlSelloDisco.getInstance().eliminaCancionDeAlbum(nombre, nombreAlbum);
            System.out.println("[ÉXITO] Canción eliminada de álbum.");
        } catch (SelloDiscoExcepcion e) {
            System.out.println("[ERROR] " + e.getMessage() + ".");
        }
    }

    private void listaAlbumes() {
        String[] lista = ControlSelloDisco.getInstance().listaAlbumes();

        if (lista.length == 0){
            System.out.println("[ERROR] No existen albumes. ¿Creó alguno?.");
            return;
        }

        System.out.println("Información sobre álbumes creados.");
        System.out.printf("| %10s | %10s | %10s | %10s |\n", "Nombre", "Fec. Crea.", "Duración", "N° canc.");
        for(String val : lista){
            String[] data = val.split(";");
            System.out.printf("| %10s | %10s | %10s | %10s |\n", data[0], data[1], data[2], data[3]);
        }
        System.out.println();
    }

    private void listaCancionesDeGenero() {
        System.out.print("Ingrese género? ");
        String genero = scan.next();
        Genero gen = selectorGeneros(genero);

        String[] lista = ControlSelloDisco.getInstance().listaCancionesDeGenero(gen);

        if(lista.length == 0){
            System.out.println("[ERROR] No se encontraron canciones que concuerden con el geńero.\n" +
                    "¿Revisó lo que escribió?");
            return;
        }

        System.out.println("Información sobre canciones del género '"+genero+"'.");
        //System.out.printf("")
    }

    private void listaCancionesDeAlbum() {

    }

    private Genero selectorGeneros(String entradaUsuario){
        String[] generos = {"POP","ROCK","NEW_AGE"};

        for(String generoString : generos) {
            if(generoString.equals(entradaUsuario)){
                return Genero.valueOf(entradaUsuario);
            }
        }
        return null;
    }
}

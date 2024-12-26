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
                    ===== MENU =====
                    1) CREAR ALBUM
                    2) CREAR CANCION
                    3) AGREGA CANCION A ALBUM
                    4) ELIMINA CANCION DE ALBUM
                    5) LISTAR ALBUMES
                    6) LISTAR CANCIONES DE UN GENERO
                    7) LISTAR CANCIONES DE ALBUM
                    
                    8) SALIR
                    """);

            System.out.print("Seleccione: ");
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
        System.out.print("ingrese nombre: ");
        String nombre = scan.next();

        System.out.print("ingrese fecha: ");
        String fecha = scan.next();
        LocalDate fecha_c = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try {
            ControlSelloDisco.getInstance().creaAlbum(nombre, fecha_c);
            System.out.println("Album creada con exito");
        } catch (SelloDiscoExcepcion e) {
            System.out.println(e.getMessage());
            System.out.println("Error!");
        }

    }

    private void creaCancion() {
        Genero gen = Genero.ROCK;

        System.out.println("ingrese nombre: ");
        String nombre = scan.next();

        System.out.print("ingrese duracion: ");
        float duracion = scan.nextFloat();

        System.out.print("ingrese genero: ");
        String genero = scan.next();

        if (genero.equals("ROCK")) {
            gen = Genero.ROCK;
        }
        if (genero.equals("NEW_AGE")) {
            gen = Genero.NEW_AGE;
        }
        if (genero.equals("POP")) {
            gen = Genero.POP;
        }

        System.out.print("ingrese nombre del interprete: ");
        String interprete = scan.next();

        try {
            ControlSelloDisco.getInstance().creaCancion(nombre, duracion, gen, interprete);
        } catch (SelloDiscoExcepcion e) {
            System.out.println(e.getMessage());
            System.out.println("Error!");
        }
    }

    private void agregaCancionEnAlbum() {
        System.out.print("Ingrese nombre de cancion: ");
        String nombre = scan.next();

        System.out.print("Ingrese nombre de album: ");
        String nombreAlbum = scan.next();

        try {
            ControlSelloDisco.getInstance().agregaCancionEnAlbum(nombre, nombreAlbum);
            System.out.println("Album agregado");
        } catch (SelloDiscoExcepcion e) {
            System.out.println(e.getMessage());
            System.out.println("Error!");
        }
    }

    private void eliminaCancionDeAlbum() {
        System.out.print("Ingrese nombre de cancion: ");
        String nombre = scan.next();

        System.out.print("Ingrese nombre de album: ");
        String nombreAlbum = scan.next();

        try {
            ControlSelloDisco.getInstance().eliminaCancionDeAlbum(nombre, nombreAlbum);
            System.out.println("Album eliminado");
        } catch (SelloDiscoExcepcion e) {
            System.out.println(e.getMessage());
            System.out.println("Error!");
        }
    }

    private void listaAlbumes() {
        String[] lista = ControlSelloDisco.getInstance().listaAlbumes();

        if (lista.length == 0){
            System.out.println("No existe un album");
            return;
        }

        System.out.printf("| %10s | %10s | %10s | %10s |\n", "Nombre", "Fec. Crea.", "Duracion", "N° canc.");
        for(String val : lista){
            String[] data = val.split(";");
            System.out.printf("| %10s | %10s | %10s | %10s |\n", data[0], data[1], data[2], data[3]);
        }
        System.out.println();
    }

    private void listaCancionesDeGenero() {
        Genero gen = Genero.ROCK;

        System.out.print("ingrese genero: ");
        String genero = scan.next();

        if (genero.equals("ROCK")) {
            gen = Genero.ROCK;
        }
        if (genero.equals("NEW_AGE")) {
            gen = Genero.NEW_AGE;
        }
        if (genero.equals("POP")) {
            gen = Genero.POP;
        }

        String[] lista = ControlSelloDisco.getInstance().listaCancionesDeGenero(gen);

        //System.out.printf("")
    }

    private void listaCancionesDeAlbum() {

    }

}

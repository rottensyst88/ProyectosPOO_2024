package ejercicios.excepciones.c.Controlador;

import ejercicios.excepciones.c.Excepcion.LibroNoDisponibleException;
import ejercicios.excepciones.c.Modelo.BibliotecaDigital;
import ejercicios.excepciones.c.Modelo.LibroDigital;

public class BibliotecaDigitalController {
    private static final BibliotecaDigitalController instancia = new BibliotecaDigitalController();
    private final BibliotecaDigital biblioteca;

    public BibliotecaDigitalController() {
        biblioteca = new BibliotecaDigital();
    }

    public static BibliotecaDigitalController getInstancia(){
        return instancia;
    }

    public void prestarLibro(String titulo) {
        LibroDigital libro = biblioteca.buscarLibro(titulo);

        if (libro != null) {
            try {
                libro.prestar();
                System.out.println("El libro " + titulo + " ha sido prestado!");
            } catch (LibroNoDisponibleException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("El libro solicitado no existe!");
        }
    }

    public void devolverLibro(String titulo) {
        LibroDigital libro = biblioteca.buscarLibro(titulo);

        if(libro != null){
            if(libro.isPrestado()){
                libro.devolver();
                System.out.println("El libro "+titulo+" ha sido devuelto!");
            }else{
                System.out.println("El libro "+titulo+" no se encuentra prestado!");
            }
        }else{
            System.out.println("El libro solicitado no existe!");
        }
    }

    public void anadirLibro(String titulo, String autor){
        biblioteca.agregarLibros(new LibroDigital(titulo,autor));
    }
}

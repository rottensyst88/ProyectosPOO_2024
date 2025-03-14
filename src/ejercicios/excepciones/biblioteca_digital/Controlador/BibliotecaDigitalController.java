package ejercicios.excepciones.biblioteca_digital.Controlador;

import ejercicios.excepciones.biblioteca_digital.Excepcion.LibroNoDisponibleException;
import ejercicios.excepciones.biblioteca_digital.Modelo.BibliotecaDigital;
import ejercicios.excepciones.biblioteca_digital.Modelo.LibroDigital;

public class BibliotecaDigitalController {
    private static final BibliotecaDigitalController instancia = new BibliotecaDigitalController();
    private final BibliotecaDigital biblioteca;

    public BibliotecaDigitalController() {
        biblioteca = new BibliotecaDigital();
    }

    public static BibliotecaDigitalController getInstancia(){
        return instancia;
    }

    public void prestarLibro(String titulo) throws LibroNoDisponibleException{
        LibroDigital libro = biblioteca.buscarLibro(titulo);

        if (libro != null) {

            /*
            try {
                libro.prestar();
                System.out.println("El libro " + titulo + " ha sido prestado!");
            } catch (LibroNoDisponibleException e) {
                System.out.println(e.getMessage());
            }*/

            boolean verif = libro.prestar();
            if (verif) {
                System.out.println("El libro " + titulo + " ha sido prestado!");
            }else{
                throw new LibroNoDisponibleException("El libro " + titulo + " no se encuentra disponible!");
            }
        } else {
            throw new LibroNoDisponibleException("El libro solicitado no existe!");
        }
    }

    public void devolverLibro(String titulo) throws LibroNoDisponibleException {
        LibroDigital libro = biblioteca.buscarLibro(titulo);

        if(libro != null){
            if(libro.isPrestado()){
                libro.devolver();
                System.out.println("El libro "+titulo+" ha sido devuelto!");
            }else{
                throw new LibroNoDisponibleException("El libro "+titulo+" no se encuentra prestado!");
            }
        }else{
            throw new LibroNoDisponibleException("El libro "+titulo+" no existe!");
        }
    }

    public void anadirLibro(String titulo, String autor) throws LibroNoDisponibleException {


        if(biblioteca.agregarLibros(new LibroDigital(titulo,autor))){
            System.out.println("El libro "+titulo+" ha sido agregado!");
        }else{
            throw new LibroNoDisponibleException("El libro "+titulo+" ya existe!");
        }
    }
}

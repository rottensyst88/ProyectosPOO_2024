package ejercicios.excepciones.biblioteca_digital.Excepcion;

public class LibroNoDisponibleException extends RuntimeException {
    public LibroNoDisponibleException(String message) {
        super(message);
    }
}

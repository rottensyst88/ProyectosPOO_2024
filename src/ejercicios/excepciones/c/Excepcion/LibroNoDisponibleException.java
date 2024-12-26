package ejercicios.excepciones.c.Excepcion;

public class LibroNoDisponibleException extends RuntimeException {
    public LibroNoDisponibleException(String message) {
        super(message);
    }
}

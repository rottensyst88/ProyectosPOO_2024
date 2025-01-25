package ejercicios.excepciones.videoclub.Excepciones;

public class VideojuegoNoDisponibleException extends RuntimeException {
    public VideojuegoNoDisponibleException(String message) {
        super(message);
    }
}

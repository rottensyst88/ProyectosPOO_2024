package ejercicios.excepciones.videoclub.Modelo;

public class Videojuego {
    private String nombre;
    private boolean disponible;

    public Videojuego(String nombre) {
        this.nombre = nombre;
        disponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public boolean rentar() {
        if (!isDisponible()) {
            return false;
        }
        disponible = false;
        return true;
    }

    public void devolver() {
        disponible = true;
    }
}

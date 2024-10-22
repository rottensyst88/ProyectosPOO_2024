package ejercicio2Excepciones.Modelo;

import ejercicio2Excepciones.Excepciones.VideojuegoNoDisponibleException;

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

    public void rentar() throws VideojuegoNoDisponibleException {
        if (!isDisponible()) {
            throw new VideojuegoNoDisponibleException("El juego seleccionado no está disponible!");
        }
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }
}

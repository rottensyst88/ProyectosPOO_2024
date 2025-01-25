package ejercicios.excepciones.videoclub.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Videoclub {
    private static Videoclub instancia = null;
    private List<Videojuego> videojuegos;

    private Videoclub(){
        videojuegos = new ArrayList<>();
    }

    public static Videoclub getInstancia(){
        if(instancia == null){
            instancia = new Videoclub();
        }
        return instancia;
    }

    public void agregarVideojuego(Videojuego videojuego){
        videojuegos.add(videojuego);
    }

    public Videojuego buscarVideojuego(String nombre){
        for(Videojuego videojuego : videojuegos){
            if(videojuego.getNombre().equalsIgnoreCase(nombre)){
                return videojuego;
            }
        }
        return null;
    }
}

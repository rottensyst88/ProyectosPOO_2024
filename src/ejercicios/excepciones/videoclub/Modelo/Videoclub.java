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

    public boolean agregarVideojuego(Videojuego videojuego){

        boolean centinela = false;

        for(Videojuego videojuego2 : videojuegos){
            if(videojuego2.getNombre().equals(videojuego.getNombre())){
                centinela = true;
                break;
            }
        }

        if(!centinela){
            return videojuegos.add(videojuego);
        }
        return false;
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

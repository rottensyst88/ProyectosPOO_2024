package evaluaciones.control3.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nombre;
    private LocalDate fecha;
    List<Cancion> canciones = new ArrayList<>();

    public Album(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDuracion(){
        float contador = 0;

        for(Cancion cancion : canciones){
            contador += cancion.getDuracion();
        }
        return contador;

    }

    public void addCancion(Cancion cancion){
        canciones.add(cancion);
        cancion.addAlbum(this);
    }

    public void removeCancion(Cancion cancion){
        canciones.remove(cancion);
        cancion.removeAlbum(this);
    }

    public boolean isCancion(String nombreCancion){
        for(Cancion cancion : canciones){
            if(cancion.getNombre().equals(nombreCancion)){
                return true;
            }
        }

        return false;
    }

    public Cancion[] getCanciones(){
        return canciones.toArray(new Cancion[0]);
    }

    @Override
    public String toString(){
        return nombre + ";" + fecha;
    }
}

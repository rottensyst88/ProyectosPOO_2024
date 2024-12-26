package evaluaciones.control3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cancion {
    private String nombre;
    private float duracion;
    private Genero genero;
    private String nombreInterprete;
    List<Album> albumes = new ArrayList<>();

    public Cancion(String nombre, float duracion, Genero genero, String nombreInterprete) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.nombreInterprete = nombreInterprete;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void addAlbum(Album album) {
        albumes.add(album);
    }

    public void removeAlbum(Album album) {
        albumes.remove(album);
    }

    public Album[] getAlbumes() {
        if(albumes.isEmpty()) {
            return null;
        }
        return albumes.toArray(new Album[0]);
    }

    @Override
    public String toString(){
        return nombre + ";" + duracion + ";" + genero + ";" + nombreInterprete;
    }
}

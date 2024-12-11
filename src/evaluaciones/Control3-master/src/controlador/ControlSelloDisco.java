package controlador;
import modelo.*;
import excepciones.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControlSelloDisco {
    private static ControlSelloDisco instance = new ControlSelloDisco();
    public static ControlSelloDisco getInstance() {
        return instance;
    }

    List<Cancion> canciones = new ArrayList<>();
    List<Album> albumes = new ArrayList<>();

    public void creaAlbum(String nombre, LocalDate fechaCreacion) throws SelloDiscoExcepcion{
        Optional<Album> album_get = buscaAlbum(nombre);

        if (album_get.isPresent()) {
            throw new SelloDiscoExcepcion("El album ya existe");
        }

        Album album = new Album(nombre, fechaCreacion);
        albumes.add(album);
    }

    public void creaCancion(String nombre, float duracion, Genero genero, String nombreInterprete) throws SelloDiscoExcepcion{
        Optional<Cancion> cancion_get = buscaCancion(nombre);

        if(cancion_get.isPresent()) {
            throw new SelloDiscoExcepcion("El cancion ya existe");
        }
        Cancion cancion = new Cancion(nombre, duracion, genero, nombreInterprete);
        canciones.add(cancion);
    }

    public void agregaCancionEnAlbum(String nombreCancion, String nombreAlbum){
        Optional<Cancion> cancionBusqueda = buscaCancion(nombreCancion);
        Optional<Album> albumBusqueda = buscaAlbum(nombreAlbum);

        if(cancionBusqueda.isEmpty() || albumBusqueda.isEmpty()){
            throw new SelloDiscoExcepcion("Faltan datos");
        }

        Cancion[] cancions = albumBusqueda.get().getCanciones();

        for(Cancion cancion : cancions){
            if(cancion.getNombre().equals(nombreCancion)){
                throw new SelloDiscoExcepcion("La cancion ya existe");
            }
        }

        albumBusqueda.get().addCancion(cancionBusqueda.get());
    }

    public void eliminaCancionDeAlbum(String nombreCancion, String nombreAlbum){
        Optional<Cancion> cancionBusqueda = buscaCancion(nombreCancion);
        Optional<Album> albumBusqueda = buscaAlbum(nombreAlbum);

        if(cancionBusqueda.isEmpty() || albumBusqueda.isEmpty()){
            throw new SelloDiscoExcepcion("Faltan datos");
        }

        Cancion[] cancions = albumBusqueda.get().getCanciones();

        for(Cancion cancion : cancions){
            if(!cancion.getNombre().equals(nombreCancion)){
                throw new SelloDiscoExcepcion("La cancion nunca estuvo en Album");
            }
        }

        albumBusqueda.get().removeCancion(cancionBusqueda.get());
    }

    public String[] listaAlbumes(){
        String[] albums = new String[albumes.size()];

        for (int i = 0; i < albumes.size(); i++) {
            Album album = albumes.get(i);
            albums[i] = album.toString() + ";" + album.getDuracion() + ";" + album.getCanciones().length;
        }
        return new String[0];
    }

    public String[] listaCancionesDeGenero(Genero genero){
        List<Cancion> songs = new ArrayList<>();

        for(Cancion cancion : canciones){
            if(cancion.getGenero().equals(genero)){
                songs.add(cancion);
            }
        }

        if(songs.isEmpty()){
            return new String[0];
        }

        String[] songsArray = new String[songs.size()];

        for (int i = 0; i < songs.size(); i++) {
            Cancion cancion = songs.get(i);

            String[] x = cancion.toString().split(";");
            songsArray[i] = x[0] + x[1] + x[3] + cancion.getAlbumes().length;
        }

        return songsArray;
    }

    public String[] listaCancionesDeAlbum(String nombreAlbum) throws SelloDiscoExcepcion{
        Optional<Album> albumBusqueda = buscaAlbum(nombreAlbum);

        if(albumBusqueda.isEmpty()){
            throw new SelloDiscoExcepcion("Faltan datos");
        }

        Cancion[] cancion_ = albumBusqueda.get().getCanciones();
        String[] songsArray = new String[cancion_.length];

        for (int i = 0; i < cancion_.length; i++) {
            Cancion cancion = cancion_[i];
            songsArray[i] = cancion.toString();
        }

        return songsArray;
    }

    private Optional<Album> buscaAlbum(String nombreAlbum){
        for(Album album : albumes){
            if(album.getNombre().equals(nombreAlbum)){
                return Optional.of(album);
            }
        }
        return Optional.empty();
    }

    private Optional<Cancion> buscaCancion(String nombreCancion){
        for(Cancion cancion : canciones){
            if(cancion.getNombre().equals(nombreCancion)){
                return Optional.of(cancion);
            }
        }
        //return null; // NULLPOINTER EXCEPTION
        return Optional.empty();
    }
}

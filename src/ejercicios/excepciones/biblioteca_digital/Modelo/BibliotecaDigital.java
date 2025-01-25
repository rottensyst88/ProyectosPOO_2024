package ejercicios.excepciones.biblioteca_digital.Modelo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDigital {
    private List<LibroDigital> libros;

    public BibliotecaDigital(){
        libros = new ArrayList<>();
    }

    public void agregarLibros(LibroDigital libro){
        libros.add(libro);
    }

    public LibroDigital buscarLibro(String titulo){
        for(LibroDigital libroBuscado : libros){
            if(libroBuscado.getTitulo().equalsIgnoreCase(titulo)){
                return libroBuscado;
            }
        }
        return null;
    }
}
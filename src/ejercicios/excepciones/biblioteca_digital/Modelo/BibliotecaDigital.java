package ejercicios.excepciones.biblioteca_digital.Modelo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDigital {
    private List<LibroDigital> libros;

    public BibliotecaDigital(){
        libros = new ArrayList<>();
    }

    public boolean agregarLibros(LibroDigital libro){
        boolean centinela = false;


        for(LibroDigital libroAux: libros){
            if(libroAux.getTitulo().equals(libro.getTitulo())){
                centinela = true;
            }
        }

        if(!centinela){
            libros.add(libro);
            return true;
        }else{
            return false;
        }
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
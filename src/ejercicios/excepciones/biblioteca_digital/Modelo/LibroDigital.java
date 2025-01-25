package ejercicios.excepciones.biblioteca_digital.Modelo;
import ejercicios.excepciones.biblioteca_digital.Excepcion.LibroNoDisponibleException;

public class LibroDigital {
    private String titulo;
    private String autor;
    private boolean prestado;

    public LibroDigital(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        prestado = false;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public boolean isPrestado(){
        return prestado;
    }

    public void prestar() throws LibroNoDisponibleException {
        if (prestado){
            throw new LibroNoDisponibleException("El libro "+titulo+ " no esta disponible");
        }
        prestado = true;
    }

    public void devolver(){
        prestado = false;
    }
}
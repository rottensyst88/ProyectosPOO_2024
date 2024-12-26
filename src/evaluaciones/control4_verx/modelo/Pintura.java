package evaluaciones.control4_verx.modelo;

public class Pintura {
    private String titulo;
    private Estilo estilo; // Enumeración para los estilos
    private Tecnica tecnica; // Enumeración para las técnicas
    private Autor autor; // Asociado al autor por su ID
    private int anioCreacion;

    // Constructor
    public Pintura(){

    }
    public Pintura(String titulo, Estilo estilo, Tecnica tecnica, Autor autor, int anioCreacion) {
        this.titulo = titulo;
        this.estilo = estilo;
        this.tecnica = tecnica;
        this.anioCreacion = anioCreacion;
        this.autor = autor;
        autor.addPintura(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }

    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}

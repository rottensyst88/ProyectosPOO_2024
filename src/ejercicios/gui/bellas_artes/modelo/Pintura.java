package ejercicios.gui.bellas_artes.modelo;

public class Pintura {
    private String titulo;
    private Estilo estilo; // Enumeración para los estilos
    private Tecnica tecnica; // Enumeración para las técnicas
    private int anioCreacion;
    private Autor autor; // Asociado al autor por su ID
    private Museo museo;

    // Constructor
    public Pintura(String titulo, Estilo estilo, Tecnica tecnica, int anioCreacion, Autor autor, Museo museo) {
        // museo puede ser null
        this.titulo = titulo;
        this.estilo = estilo;
        this.tecnica = tecnica;
        this.anioCreacion = anioCreacion;
        this.autor = autor;
        autor.addPintura(this);
        this.museo = museo;
        if (museo != null )
            museo.addPintura(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public Museo getMuseo() {
        // Valor retornado puede ser null
        return museo;
    }
}

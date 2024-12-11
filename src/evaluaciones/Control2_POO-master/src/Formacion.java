import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Formacion {
    private int codigo;
    private String nombre;
    private List<Persona> personas = new ArrayList<>();

    public Formacion(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract int getCosto();

    @Override
    public boolean equals(Object otro){
        return (this.codigo == ((Formacion) otro).codigo);
    }

    public abstract String getTipo();

    public boolean addPersona(Persona persona){
        return personas.add(persona);
    }

    public Persona[] getPersonas(){
        ArrayList<Persona> personasF = new ArrayList<>();

        for(Persona persona : personas){
            personasF.add(persona);
        }
        return personasF.toArray(new Persona[0]);
    }
}

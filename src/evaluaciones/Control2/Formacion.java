package evaluaciones.Control2;

import java.util.ArrayList;
import java.util.List;

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
        return this.codigo == ((Formacion)otro).getCodigo();
    }

    public abstract String getTipo();

    public boolean addPersona(Persona persona){
        return personas.add(persona);
    }

    public Persona[] getPersonas(){
        Persona[] personasArray = new Persona[personas.size()];

        if (personasArray.length > 0){
            return personas.toArray(personasArray);
        }
        return new Persona[0];
    }
}

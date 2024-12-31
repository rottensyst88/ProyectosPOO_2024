package evaluaciones.control2;

import java.util.ArrayList;
import java.util.List;

public abstract class Formacion {
    private int codigo;
    private String nombre;
    private List<Persona> personas;

    public Formacion(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.personas = new ArrayList<>();
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
        if(otro instanceof Formacion){
            return this.codigo == ((Formacion)otro).getCodigo();
        }
        return false;
    }

    public abstract String getTipo();

    public boolean addPersona(Persona persona){
        if(this.personas.contains(persona)){
            return false;
        }
        return personas.add(persona);
    }

    public Persona[] getPersonas(){
        return personas.toArray(new Persona[0]);
    }
}

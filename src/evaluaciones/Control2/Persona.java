package evaluaciones.Control2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String rut;

    private List<Formacion> formaciones = new ArrayList<>();

    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object otro){
        return this.rut.equals(((Persona)otro).getRut());
    }

    public boolean matricula(Formacion programa){
        programa.addPersona(this);
        return formaciones.add(programa);
    }

    public Formacion[] getFormaciones(){
        Formacion[] formacionesArray = formaciones.toArray(new Formacion[0]);
        if(formacionesArray.length > 0){
            return formacionesArray;
        }
        return new Formacion[0];
    }
}

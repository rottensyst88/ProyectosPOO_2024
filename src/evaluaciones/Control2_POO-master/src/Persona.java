import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String rut;

    private List<Formacion> formaciones =  new ArrayList<>();

    public Persona(String rut, String nombre) {
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
        return (this.rut.equals(((Persona)otro).getRut()));
    }

    public boolean matricula(Formacion programa){

        /* EL ERROR ESTA EN QUE NO SE CONCRETO LA ASOCIACION CORRECTAMENTE */
        formaciones.add(programa);

        return programa.addPersona(this);
    }

    public Formacion[] getFormacion(){
        ArrayList<Formacion> formacionesF = new ArrayList<>();
        for(Formacion formacion : formaciones){
            formacionesF.add(formacion);
        }

        return formacionesF.toArray(new Formacion[0]);
    }
}

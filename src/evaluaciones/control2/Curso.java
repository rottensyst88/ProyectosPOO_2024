package evaluaciones.control2;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Formacion{
    private int costo;
    private List<Diplomado> diplomados = new ArrayList<Diplomado>();

    public Curso(int codigo, String nombre, int costo) {
        super(codigo, nombre);
        this.costo = costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCosto(){
        return costo;
    }

    public String getTipo(){
        String nombre = getNombre();
        return nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    public boolean addDiplomado(Diplomado diplomado){
        return diplomados.add(diplomado);
    }
}

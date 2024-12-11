import java.util.ArrayList;
import java.util.List;

public class Curso extends Formacion {
    private int costo;
    private List<Diplomado> diplomados = new ArrayList<>();

    public Curso(int codigo, String nombre, int costo){
        super(codigo, nombre);
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getTipo(){
        return getNombre().substring(0,1).toUpperCase()+getNombre().substring(1).toLowerCase();
    }

    public boolean addDiplomado(Diplomado diplomado){
        return diplomados.add(diplomado);
    }
}

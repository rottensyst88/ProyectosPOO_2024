import java.util.ArrayList;
import java.util.List;

public class Diplomado extends Formacion{

    private List<Curso> cursos = new ArrayList<>();

    public Diplomado(int codigo, String nombre){
        super(codigo, nombre);
    }

    public int getCosto(){
        int contador = 0;
        for (Curso curso : cursos){
            contador += curso.getCosto();
        }
        return (int)(contador*0.9);
    }

    public String getTipo(){
        return getNombre().substring(0,1).toUpperCase()+getNombre().substring(1).toLowerCase();
    }

    public boolean addCurso(Curso curso){

        /* faltaba comprobación de la lista */
        if(cursos.contains(curso)){
            return false;
        }

        curso.addDiplomado(this);
        return cursos.add(curso);
    }
}

package Control2;

import java.util.ArrayList;
import java.util.List;

public class Diplomado extends Formacion{

    private List<Curso> cursos = new ArrayList<Curso>();

    public Diplomado(int codigo, String nombre){
        super(codigo, nombre);
    }

    public int getCosto(){
        int contadorValor = 0;
        for(Curso curso : cursos){
            contadorValor += curso.getCosto();
        }
        return (int)(contadorValor*0.9);
    }

    public String getTipo(){
        String nombre = getNombre();
        return nombre.substring(0,1).toUpperCase()+nombre.substring(1).toLowerCase();
    }

    public boolean addCurso(Curso curso){
        curso.addDiplomado(this);
        return cursos.add(curso);
    }
}
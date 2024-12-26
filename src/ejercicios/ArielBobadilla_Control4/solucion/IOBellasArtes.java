package ejercicios.ArielBobadilla_Control4.solucion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.*;
import ejercicios.ArielBobadilla_Control4.modelo.*;

public class IOBellasArtes {
    private static IOBellasArtes instance=null;

    private IOBellasArtes(){}

    public static IOBellasArtes getInstance(){
        if (instance==null){
            instance=new IOBellasArtes();
        }
        return instance;
    }

    public List<Autor> importarAutores(String nombreArchivo) {

        ArrayList<Autor> autores=new ArrayList<>();

        try{
            String[] infoAutores = null;
            Autor autor = new Autor();

            Scanner datosNuevos = new Scanner(new File(nombreArchivo));
            datosNuevos.useDelimiter(";|, |\n");

            //me rindo, no lo pude hacer!

            while(datosNuevos.hasNext()){
                autor.setId(Integer.parseInt(datosNuevos.next()));
                autor.setNombre(datosNuevos.next());
                autor.setPais(datosNuevos.next());
                autor.setFechaNacimiento(datosNuevos.next());

                if(datosNuevos.next().equals("ninguno")){
                    autor.setPremios(Collections.emptyList()); // LISTA VACIA, CREO?
                }else{
                    autor.setPremios(Arrays.asList(datosNuevos.next().split(", ")));
                }

                autores.add(autor);
            }

        } catch (FileNotFoundException exc){
            System.out.println(exc.getMessage());
            return null;
        }
        return autores;
    }

    public List<Pintura> importarPinturas(String nombreArchivo, List<Autor> autores) {
        return null;
    }

    public void exportarAutores(String nombreArchivo, List<Autor> autores) {

        try{
            PrintStream autores_txt = new PrintStream(new File(nombreArchivo));

            for(Autor autor : autores){
                autores_txt.print(String.valueOf(autor.getId()) +";"+
                        autor.getNombre() + ";"+
                        autor.getPais()+ ";"+
                        autor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+";");

                if (autor.getCantPremios() == 0){
                    autores_txt.println("ninguno");
                } else{
                    autores_txt.println(String.join(", ", autor.getPremios()));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("error!");
        }
    }

    public void exportarPinturas(String nombreArchivo, List<Pintura> pinturas) {
    }
}

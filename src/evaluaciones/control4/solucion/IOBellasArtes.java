package evaluaciones.control4.solucion;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import evaluaciones.control4.modelo.*;

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
        Scanner archivo = null;

        try{
            archivo = new Scanner(new File(nombreArchivo));
        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado!");
            return null;
        }
        List<Autor> autores=new ArrayList<>();

        archivo.useDelimiter("\n");
        archivo.useLocale(Locale.ENGLISH);

        try{
            while (archivo.hasNextLine()){
                String[] arcSt = archivo.nextLine().split(";");
                Autor a = new Autor();
                a.setId(Integer.parseInt(arcSt[0]));
                a.setNombre(arcSt[1]);
                a.setPais(arcSt[2]);
                a.setFechaNacimiento(arcSt[3]);

                if(arcSt[4].contains("ninguno")){
                    a.setPremios(Collections.emptyList());
                }else{
                    a.setPremios(Arrays.asList(arcSt[4].split(", ")));
                }

                autores.add(a);
            }
        } catch (Exception e){
            System.out.println("Error en metodo 1!");
        }
        return autores;
    }

    public List<Pintura> importarPinturas(String nombreArchivo, List<Autor> autores) {
        Scanner archivo = null;

        try{
            archivo = new Scanner(new File(nombreArchivo));
        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado!");
            return null;
        }

        List<Pintura> pinturas=new ArrayList<>();

        archivo.useDelimiter("\n");
        archivo.useLocale(Locale.ENGLISH);

        try{
            while (archivo.hasNextLine()){
                boolean centinela = false;

                String[] arcSt = archivo.nextLine().split(";");
                Pintura p = new Pintura();
                Autor aF = null;

                for (Autor a : autores){
                    if (a.getId() == Integer.parseInt(arcSt[3])) {
                        aF = a;
                        centinela = true;
                        break;
                    }
                }

                if(centinela){
                    p.setTitulo(arcSt[0]);
                    p.setEstilo(Estilo.valueOf(arcSt[1].toUpperCase()));
                    p.setTecnica(Tecnica.valueOf(arcSt[2].toUpperCase()));
                    p.setAutor(aF);
                    p.setAnioCreacion(Integer.parseInt(arcSt[4]));
                }
                pinturas.add(p);
                aF.addPintura(p);
            }
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return pinturas;
    }

    public void exportarAutores(String nombreArchivo, List<Autor> autores) {
        PrintStream archivo = null;
        try{
            archivo = new PrintStream(new File(nombreArchivo));

            for(Autor a : autores){
                String premios = "";

                String datos = a.getId() + ";" + a.getNombre() + ";"
                + a.getPais() + ";" + String.valueOf(a.getFechaNacimiento().
                        format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))) + ";";

                if(a.getCantPremios() == 0){
                    premios = "ninguno";
                }else{
                    premios = String.join(", ", a.getPremios());
                }

                datos = datos.concat(premios);
                archivo.println(datos);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado!");
        } finally {
            try {
                archivo.close();
            } catch (NullPointerException e) {
                System.out.println("Error al cerrar el archivo!");
            }
        }
    }

    public void exportarPinturas(String nombreArchivo, List<Pintura> pinturas) {
        PrintStream archivo = null;
        try{
            archivo = new PrintStream(new File(nombreArchivo));

            for(Pintura p : pinturas){
                String datos = p.getTitulo() + ";" +
                        p.getEstilo().name().toLowerCase() + ";" +
                        p.getTecnica().name().toLowerCase() + ";" +
                        p.getAutor().getId() + ";" +
                        p.getAnioCreacion() + ";";

                archivo.println(datos);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado!");
        } finally {
            try{
                archivo.close();
            } catch (NullPointerException e){
                System.out.println("Error al cerrar el archivo!");
            }
        }
    }
}

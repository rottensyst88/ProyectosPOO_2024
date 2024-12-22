package main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        // IMPLEMENTACIÓN DE STREAMS

        // EJERCICIO 1
        long ejercicio1 = cursos.stream()
                .filter(x -> x.getDuracion() > 5f)
                .count();
        System.out.println("Cantidad de cursos con duración mayor a 5 horas -> " + ejercicio1);

        // EJERCICIO 2
        long ejercicio2 = cursos.stream()
                .filter(x -> x.getDuracion() < 2f)
                .count();
        System.out.println("Cantidad de cursos con duración menor a 2 horas -> " + ejercicio2);

        //EJERCICIO 3
        cursos.stream()
                .filter(x -> x.getVideos() >50)
                .map(x -> x.getTitulo())
                .forEach(x -> System.out.println("Listado de titulos con cantidad de videos mayor a 50: "+x));

        // EJERCICIO 4

    }
}

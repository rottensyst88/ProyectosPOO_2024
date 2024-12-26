package ejercicios.SistemaGUI_SOTO_FINAL.src.controlador;

import modelo.*;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsultasStreaming {
    private static ConsultasStreaming instance = null;

    private ConsultasStreaming() {}

    public static ConsultasStreaming getInstance() {
        if (instance == null) {
            instance = new ConsultasStreaming();
        }
        return instance;
    }

    protected String[][] listarMuseosDeTecnica(List<Museo> museos, Tecnica tecnica) {
        return new String[0][0];
    }

    protected String[][] listarAutoresDePais(List<Autor> autores, String pais) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return autores.stream()
                .filter(autor-> autor.getPais().equals(pais))
                    // Id Nombre País, Fecha Nac. Cant. Premios Cant. Pinturas
                .map(autor-> new String[]{String.format("%d", autor.getId()),
                        autor.getNombre(), autor.getPais(),
                        autor.getFechaNacimiento().format(formatter),
                        String.format("%,d",autor.getCantPremios()),
                        String.format("%,d", autor.getCantPinturas())}
                )
                .toArray(String[][]::new);
    }

    protected String[][] listarAutoresDeEstilo(List<Pintura> pinturas, Estilo estilo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return pinturas.stream()
                .filter(pintura-> pintura.getEstilo().equals(estilo))
                .map(Pintura::getAutor)
                .sorted(Comparator.comparing(Autor::getId))
                .distinct()
                    // Id Nombre País, Fecha Nac. Cant. Premios Cant. Pinturas
                .map(autor-> new String[]{String.format("%d", autor.getId()),
                        autor.getNombre(), autor.getPais(),
                        autor.getFechaNacimiento().format(formatter),
                        String.format("%,d",autor.getCantPremios()),
                        String.format("%,d", autor.getCantPinturas())}
                )
                .toArray(String[][]::new);
    }

    protected String[][] listarPinturasDeAutor(List<Pintura> pinturas, int id) {
        return pinturas.stream()
                .filter(pintura -> pintura.getAutor().getId()==id)
                    // "Título", "Estilo", "Técnica", "Autor", "Año"
                .map(pintura ->new String[]{pintura.getTitulo(),
                        pintura.getEstilo().toString(),
                        pintura.getTecnica().toString(),
                        pintura.getAutor().getNombre(),
                        String.format("%d",pintura.getAnioCreacion())} )
                .toArray(String[][]::new);
    }

    public String[][] listarPinturasCreadasEnRangoAnios(List<Pintura> pinturas,
                                                               int ini, int fin) {
        return pinturas.stream()
                .filter(pintura -> pintura.getAnioCreacion() >= ini
                        && pintura.getAnioCreacion() <= fin )
                    // "Título", "Estilo", "Técnica", "Autor", "Año"
                .map(pintura ->new String[]{pintura.getTitulo(),
                        pintura.getEstilo().toString(),
                        pintura.getTecnica().toString(),
                        pintura.getAutor().getNombre(),
                        String.format("%d",pintura.getAnioCreacion())} )
                .toArray(String[][]::new);
    }

}

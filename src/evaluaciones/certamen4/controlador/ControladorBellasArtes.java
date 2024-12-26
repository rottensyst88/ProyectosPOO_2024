package evaluaciones.certamen4.controlador;

import evaluaciones.certamen4.modelo.*;
import evaluaciones.certamen4.solucion.*;

import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ControladorBellasArtes {
    private static ControladorBellasArtes controladorSistema;
    List<Autor> autores;
    List<Pintura> pinturas;

    private ControladorBellasArtes() {
        autores = new ArrayList<>();
        pinturas = new ArrayList<>();
    }

    public static ControladorBellasArtes getInstancia() {
        if (controladorSistema == null) {
            controladorSistema = new ControladorBellasArtes();
        }
        return controladorSistema;
    }

    public void exportar() throws FileNotFoundException {
        IOBellasArtes.getInstance().exportarAutores( "autores.txt", autores);
        IOBellasArtes.getInstance().exportarPinturas( "pinturas.txt", pinturas);
    }

    public void importar() throws FileNotFoundException {
        autores = IOBellasArtes.getInstance().importarAutores("autores.txt");
        pinturas = IOBellasArtes.getInstance().importarPinturas("pinturas.txt", autores);
    }

    public void generarAutoresYPinturas() {
        autores.add(new Autor(1, "Claude Monet", "Francia", "1840-11-14",
                List.of("Legión de Honor", "Premio de Arte Francés")));
        autores.add(new Autor(2, "Vincent van Gogh", "Países Bajos", "1853-03-30",
                List.of()));
        autores.add(new Autor(3, "Pablo Picasso", "España", "1881-10-25",
                List.of("Legión de Honor", "Premio Lenin de la Paz")));
        autores.add(new Autor(4, "Salvador Dalí", "España", "1904-05-11",
                List.of("Gran Cruz de Isabel la Católica")));
        autores.add(new Autor(5, "Frida Kahlo", "México", "1907-07-06",
                List.of()));
        autores.add(new Autor(6, "Rembrandt", "Países Bajos", "1606-07-15",
                List.of("Reconocimiento póstumo")));
        autores.add(new Autor(7, "Leonardo da Vinci", "Italia", "1452-04-15",
                List.of("Genio universal")));
        autores.add(new Autor(8, "Diego Velázquez", "España", "1599-06-06",
                List.of("Reconocimiento por la corte española")));
        autores.add(new Autor(9, "Johannes Vermeer", "Países Bajos", "1632-10-31",
                List.of()));
        autores.add(new Autor(10, "Paul Cézanne", "Francia", "1839-01-19",
                List.of("Reconocimiento póstumo")));

        pinturas.add(new Pintura("Impresión: Sol naciente", Estilo.IMPRESIONISMO, Tecnica.OLEO, autores.get(0), 1872));
        pinturas.add(new Pintura("El estanque de los nenúfares", Estilo.IMPRESIONISMO, Tecnica.OLEO, autores.get(0), 1899));

        pinturas.add(new Pintura("La noche estrellada", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, autores.get(1), 1889));
        pinturas.add(new Pintura("Los girasoles", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, autores.get(1), 1888));

        pinturas.add(new Pintura("Las señoritas de Avignon", Estilo.CUBISMO, Tecnica.OLEO, autores.get(2), 1907));
        pinturas.add(new Pintura("El Guernica", Estilo.CUBISMO, Tecnica.OLEO, autores.get(2), 1937));

        pinturas.add(new Pintura("La solucion de la memoria", Estilo.SURREALISMO, Tecnica.OLEO, autores.get(3), 1931));
        pinturas.add(new Pintura("Sueño causado por el vuelo de una abeja", Estilo.SURREALISMO, Tecnica.OLEO, autores.get(3), 1944));

        pinturas.add(new Pintura("Las dos Fridas", Estilo.SURREALISMO, Tecnica.ACUARELA, autores.get(4), 1939));
        pinturas.add(new Pintura( "Autorretrato con collar de espinas", Estilo.SURREALISMO, Tecnica.OLEO, autores.get(4), 1940));

        pinturas.add(new Pintura( "La ronda de noche", Estilo.BARROCO, Tecnica.OLEO, autores.get(5), 1642));
        pinturas.add(new Pintura( "Autorretrato con dos círculos", Estilo.BARROCO, Tecnica.OLEO, autores.get(5), 1665));

        pinturas.add(new Pintura( "La última cena", Estilo.RENACIMIENTO, Tecnica.TEMPLE, autores.get(6), 1498));
        pinturas.add(new Pintura( "Mona Lisa", Estilo.RENACIMIENTO, Tecnica.OLEO, autores.get(6), 1503));

        pinturas.add(new Pintura( "Las meninas", Estilo.BARROCO, Tecnica.OLEO, autores.get(7), 1656));
        pinturas.add(new Pintura( "La rendición de Breda", Estilo.BARROCO, Tecnica.OLEO, autores.get(7), 1635));

        pinturas.add(new Pintura( "La joven de la perla", Estilo.BARROCO, Tecnica.OLEO, autores.get(8), 1665));
        pinturas.add(new Pintura( "Vista de Delft", Estilo.BARROCO, Tecnica.OLEO, autores.get(8), 1660));

        pinturas.add(new Pintura( "La montaña Sainte-Victoire", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, autores.get(9), 1904));
        pinturas.add(new Pintura( "Bodegón con manzanas y naranjas", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, autores.get(9), 1899));
    }

    public String[][] listarAutores() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[][] data = new String[autores.size()][6];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = String.format("%,d", autores.get(i).getId());
            data[i][1] = autores.get(i).getNombre();
            data[i][2] = autores.get(i).getPais();
            data[i][3] = autores.get(i).getFechaNacimiento().format(formatter);
            data[i][4] = String.format("%,d", autores.get(i).getCantPremios());
            data[i][5] = String.format("%,d", autores.get(i).getCantPinturas());
        }
        return data;
    }

    public String[][] listarPinturas() {
        String[][] data = new String[pinturas.size()][5];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = pinturas.get(i).getTitulo();
            data[i][1] = pinturas.get(i).getEstilo().name();
            data[i][2] = pinturas.get(i).getTecnica().name();
            data[i][3] = pinturas.get(i).getAutor().getNombre();
            data[i][4] = String.format("%,d", pinturas.get(i).getAnioCreacion());
        }
        return data;
    }

    public String[][] listarAutoresDePais(String nacionalidad) {
        return ConsultasStreaming.listarAutoresDePais(autores, nacionalidad);
    }

    public String[][] listarAutoresDeEstilo(String estilo) {
        return ConsultasStreaming.listarAutoresDeEstilo(pinturas, estilo);
    }


    public String[][] listarPinturasDeAutor(int id) {
        return ConsultasStreaming.listarPinturasDeAutor(pinturas, id);

    }

    public String[][] listarPinturasCreadasEnRangoAnios(int ini, int fin) {
        return ConsultasStreaming.listarPinturasCreadasEnRangoAnios(pinturas, ini, fin);
    }
}




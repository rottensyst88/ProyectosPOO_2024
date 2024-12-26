package ejercicios.SistemaGUI_SOTO_FINAL.src.controlador;

import modelo.*;
import persistencia.IOBellasArtes;

import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ControladorBellasArtes {
    private static ControladorBellasArtes controladorSistema;
    List<Autor> autores;
    List<Pintura> pinturas;
    List<Museo> museos;

    private ControladorBellasArtes() {
        autores = new ArrayList<>();
        pinturas = new ArrayList<>();
        museos = new ArrayList<>();
    }

    public static ControladorBellasArtes getInstancia() {
        if (controladorSistema == null) {
            controladorSistema = new ControladorBellasArtes();
        }
        return controladorSistema;
    }

    public void generarMuseosAutoresYPinturas() {
        museos.add(new Museo(1,"Museo Marmottan Monet","Louis Boilly 2, Paris","Francia"));
        museos.add(new Museo(2,"Museo Metropolitano de Arte","1000 5th Ave, NY 10028, Nueva York","Estados Unidos"));
        museos.add(new Museo(3,"Museo de Arte Moderno","Calle 53 (Manhattan) y Quinta Avenida, NY 10019, Nueva York",
                "Estados Unidos"));
        museos.add(new Museo(4,"Museo Van Gogh de Amsterdam","Museumplein 6, 1071 DJ Amsterdam","Países Bajos"));
        museos.add(new Museo(5,"Museo Nacional de Arte Reina Sofía","Calle Sta. Isabel, 52, Centro, 28012 Madrid",
                "España"));
        museos.add(new Museo(6,"Museo Nacional Thyssen-Bornemisza","Paseo del Prado 8, Centro, 28014 Madrid","España"));
        museos.add(new Museo(7,"Museo de Arte Moderno",
                "Av. Paseo de la Reforma s/n, Bosque de Chapultepec I Secc, Miguel Hidalgo, 11580 Ciudad de México, CDMX",
                "México"));
        museos.add(new Museo(8,"Harry Ransom Center","The University of Texas at Austin, 300 W 21st St, Austin, TX 78712",
                "Estados Unidos"));
        museos.add(new Museo(9,"Rijksmuseum de Ámsterdam","Museumstraat 1, 1071 XX Amsterdam","Países Bajos"));
        museos.add(new Museo(10,"Kenwood House","Hampstead Ln, London NW3 7JR","Reino Unido"));
        museos.add(new Museo(11,"Museo del Cenácolo Vinciano","Piazza di Santa Maria delle Grazie, 2, 20123 Milano MI",
                "Italia"));
        museos.add(new Museo(12,"Museo del Louvre","75001 Paris","Francia"));
        museos.add(new Museo(13,"Museo Nacional del Prado","Retiro, 28014 Madrid","España"));
        museos.add(new Museo(14,"Mauritshuis de La Haya","Plein 29, 2511 CS Den Haag","Países Bajos"));
        museos.add(new Museo(15,"Museo de Arte de Filadelfia","2600 Benjamin Franklin Parkway Filadelfia, Pensilvania",
                "Estados Unidos"));
        museos.add(new Museo(16,"Musée d'Orsay","Esplanade Valéry Giscard d'Estaing, 75007 Paris","Francia"));

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

        pinturas.add(new Pintura("Impresión: Sol naciente", Estilo.IMPRESIONISMO, Tecnica.OLEO, 1872, autores.get(0), museos.get(0)));
        pinturas.add(new Pintura("El estanque de los nenúfares", Estilo.IMPRESIONISMO, Tecnica.OLEO, 1899, autores.get(0), museos.get(1)));

        pinturas.add(new Pintura("La noche estrellada", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, 1889, autores.get(1), museos.get(2)));
        pinturas.add(new Pintura("Los girasoles", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, 1888, autores.get(1), museos.get(3)));

        pinturas.add(new Pintura("Las señoritas de Avignon", Estilo.CUBISMO, Tecnica.OLEO, 1907, autores.get(2), museos.get(2)));
        pinturas.add(new Pintura("El Guernica", Estilo.CUBISMO, Tecnica.OLEO, 1937, autores.get(2), museos.get(4)));

        pinturas.add(new Pintura("La solucion de la memoria", Estilo.SURREALISMO, Tecnica.OLEO, 1931, autores.get(3),null));
        pinturas.add(new Pintura("Sueño causado por el vuelo de una abeja", Estilo.SURREALISMO, Tecnica.OLEO, 1944, autores.get(3), museos.get(5)));

        pinturas.add(new Pintura("Las dos Fridas", Estilo.SURREALISMO, Tecnica.ACUARELA, 1939, autores.get(4), museos.get(5)));
        pinturas.add(new Pintura("Autorretrato con collar de espinas", Estilo.SURREALISMO, Tecnica.OLEO, 1940, autores.get(4), museos.get(7)));

        pinturas.add(new Pintura("La ronda de noche", Estilo.BARROCO, Tecnica.OLEO, 1642, autores.get(5), museos.get(8)));
        pinturas.add(new Pintura("Autorretrato con dos círculos", Estilo.BARROCO, Tecnica.OLEO, 1665, autores.get(5), museos.get(9)));

        pinturas.add(new Pintura("La última cena", Estilo.RENACIMIENTO, Tecnica.TEMPLE, 1498, autores.get(6), museos.get(10)));
        pinturas.add(new Pintura("Mona Lisa", Estilo.RENACIMIENTO, Tecnica.OLEO, 1503, autores.get(6), museos.get(11)));

        pinturas.add(new Pintura("Las meninas", Estilo.BARROCO, Tecnica.OLEO, 1656, autores.get(7), museos.get(12)));
        pinturas.add(new Pintura("La rendición de Breda", Estilo.BARROCO, Tecnica.OLEO, 1635, autores.get(7), museos.get(12)));

        pinturas.add(new Pintura("La joven de la perla", Estilo.BARROCO, Tecnica.OLEO, 1665, autores.get(8), museos.get(13)));
        pinturas.add(new Pintura("Vista de Delft", Estilo.BARROCO, Tecnica.OLEO, 1660, autores.get(8), museos.get(13)));

        pinturas.add(new Pintura("La montaña Sainte-Victoire", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, 1904, autores.get(9), museos.get(14)));
        pinturas.add(new Pintura("Bodegón con manzanas y naranjas", Estilo.POSTIMPRESIONISMO, Tecnica.OLEO, 1899, autores.get(9), museos.get(15)));
    }

    public void creaNuevoMuseo(int id,String nombre, String direccion, String pais)
            throws BellasArtesException {
        if (museos.stream().filter(museo -> museo.getId() == id).findAny().isEmpty()) {
            museos.add(new Museo(id, nombre, direccion, pais));
        } else {
            throw new BellasArtesException("Ya existe un museo con el id dado");
        }
    }

    public void guardarDatosSistema() throws FileNotFoundException {
        IOBellasArtes.getInstance().guardarAutores("autores.txt", autores);
        IOBellasArtes.getInstance().guardarPinturas("pinturas.txt", pinturas);
        IOBellasArtes.getInstance().guardarMuseos("museos.txt", museos);
    }

    public void leerDatosSistema() throws FileNotFoundException {
        museos = IOBellasArtes.getInstance().leerMuseos("museos.txt");
        autores = IOBellasArtes.getInstance().leerAutores("autores.txt");
        pinturas = IOBellasArtes.getInstance().leerPinturas("pinturas.txt", autores,museos);
    }

    public String[][] listarMuseos() {
        return museos.stream()
                .map(museo -> new String[] {
                        String.format("%d",museo.getId()),
                        museo.getNombre(),
                        museo.getDireccion(),
                        museo.getPais()
                })
                .toArray(String[][]::new);
    }

    public String[][] listarAutores() {
        return autores.stream()
                .map(autor -> new String[]{
                        String.format("%d",autor.getId()),
                        autor.getNombre(),
                        autor.getPais(),
                        autor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        String.format("%,d",autor.getCantPremios()),
                        String.format("%,d",autor.getCantPinturas())
                }).toArray(String[][]::new);
    }

    public String[][] listarPinturas() {
        return pinturas.stream()
                .map(pintura -> new String[]{
                        pintura.getTitulo(),
                        pintura.getEstilo().toString(),
                        pintura.getTecnica().toString(),
                        pintura.getAutor().getNombre(),
                        String.format("%d",pintura.getAnioCreacion())
                }).toArray(String[][]::new);
    }

    public String[][] listarMuseosDeTecnica(Tecnica tecnica) {
        return ConsultasStreaming.getInstance().listarMuseosDeTecnica(museos,tecnica);
    }

    public String[][] listarAutoresDeNacionalidad(String nacionalidad) {
        return ConsultasStreaming.getInstance().listarAutoresDePais(autores, nacionalidad);
    }

    public String[][] listarAutoresDeEstilo(Estilo estilo) {
        return ConsultasStreaming.getInstance().listarAutoresDeEstilo(pinturas, estilo);
    }

    public String[][] listarPinturasDeAutor(int id) {
        return ConsultasStreaming.getInstance().listarPinturasDeAutor(pinturas, id);

    }

    public String[][] listarPinturasCreadasEnRangoAnios(int ini, int fin) {
        return ConsultasStreaming.getInstance().listarPinturasCreadasEnRangoAnios(pinturas, ini, fin);
    }
}

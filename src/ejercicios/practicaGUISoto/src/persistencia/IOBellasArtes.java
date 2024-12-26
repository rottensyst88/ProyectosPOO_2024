package ejercicios.practicaGUISoto.src.persistencia;
import modelo.*;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class IOBellasArtes {
    // Singleton
    private static IOBellasArtes instance = null;

    private IOBellasArtes() {}

    public static IOBellasArtes getInstance() {
        if (instance == null) {
            instance = new IOBellasArtes();
        }
        return instance;
    }

    // Los datos de la importación se leen desde <nombreArchivo>
    public List<Museo> leerMuseos(String nombreArchivo) throws FileNotFoundException {
        List<Museo> museos = new ArrayList<>();
        Scanner sc = new Scanner(new File(nombreArchivo));
        sc.useDelimiter("[;\\n\\r]+");
        int id;
        String nombre, direccion, nombrePais;
        while (sc.hasNext()) {
            id = sc.nextInt();
            nombre = sc.next();
            direccion = sc.next();
            nombrePais = sc.next();
            museos.add(new Museo(id, nombre, direccion, nombrePais));
        }
        sc.close();
        return museos;
    }

    // Los datos de la importación se leen desde <nombreArchivo>
    public List<Autor> leerAutores(String nombreArchivo)
            throws FileNotFoundException {
        List<Autor> autores = new ArrayList<>();
        Scanner sc = new Scanner(new  File(nombreArchivo));
        sc.useDelimiter("[;\\n\\r]+");

        while (sc.hasNext()) {
            // "Id";"Nombre";"País";"Fecha NAC.";["ninguno"|"Premio"[, "premio"]*];
            Autor autor = new Autor();
            autor.setId(sc.nextInt());
            autor.setNombre(sc.next());
            autor.setPais(sc.next());
            autor.setFechaNacimiento(sc.next());
            String premios = sc.next();
            if (premios.equalsIgnoreCase("ninguno")) {
                autor.setPremios(List.of());
            } else {
                String[] premiosArr = premios.split(",");
                autor.setPremios(Arrays.asList(premiosArr));
            }
            autores.add(autor);
        }
        sc.close();
        return autores;
    }

    // Se requiere que previamente se lean los autores y museos, que son pasados como parámetro
    // Esto es necesario para crear cada objeto pintura.
    // Los datos de la importación se leen desde <nombreArchivo>
    public List<Pintura> leerPinturas(String nombreArchivo, List<Autor> autores, List<Museo> museos)
            throws FileNotFoundException {
        List<Pintura> pinturas = new ArrayList<>();
        Scanner sc = new Scanner(new  File(nombreArchivo));
        sc.useDelimiter("[;\\n\\r]+");
        String titulo;
        Estilo estilo;
        Tecnica tecnica;
        int anioCreacion;
        Autor autor;
        Optional<Autor> autorOptional;
        Museo museo;
        Optional<Museo> museoOptional;
        while (sc.hasNext()) {
            // "Título";"Estilo";"Técnica";"IdAutor";"Año"[;idMuseo]
            titulo = sc.next();
            estilo = Estilo.valueOf(sc.next());
            tecnica = Tecnica.valueOf(sc.next());
            int idAutor = sc.nextInt();
            autorOptional = autores.stream()
                    .filter(autorStream ->autorStream.getId() == idAutor)
                    .findFirst();
            anioCreacion = sc.nextInt();
            if (sc.hasNextInt()) {
                int idMuseo = sc.nextInt();
                museoOptional = museos.stream()
                        .filter(museoStream -> museoStream.getId() == idMuseo)
                        .findFirst();
            } else {
                museoOptional = Optional.empty();
            }
            if(autorOptional.isPresent()) {
                autor = autorOptional.get();
                museo = museoOptional.orElse(null);
                pinturas.add(new Pintura(titulo,estilo,tecnica,anioCreacion,autor,museo));
            } // Si no se encuentra el autor con idAutor, se ignora la pintura
        }
        sc.close();
        return pinturas;
    }

    // Los datos de los museos se guardan en <nombreArchivo>
    public void guardarMuseos(String nombreArchivo, List<Museo> museos)
        throws FileNotFoundException {
        PrintStream archivo = new PrintStream(nombreArchivo);
        for (Museo museo : museos) {
            // "Id";"Nombre";"Dirección";País"
            archivo.print(museo.getId() + ";");
            archivo.print(museo.getNombre() + ";");
            archivo.print(museo.getDireccion() + ";");
            archivo.print(museo.getPais() + ";");
        }
        archivo.close();
    }

    // Los datos de los autores se guardan en <nombreArchivo>
    public void guardarAutores(String nombreArchivo, List<Autor> autores)
            throws FileNotFoundException {
        PrintStream archivo = new PrintStream(nombreArchivo);
        for (Autor autor : autores) {
            // "Id";"Nombre";"País";"Fecha Nac.";["ninguno"|"Premio"[, "Premio"]*];
            archivo.print(autor.getId() + ";");
            archivo.print(autor.getNombre() + ";");
            archivo.print(autor.getPais() + ";");
            archivo.print(autor.getFechaNacimiento()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ";");
            String premios = Arrays.toString(autor.getPremios()
                    .toArray(new String[0]));
            archivo.print(autor.getCantPremios() == 0 ?
                    "ninguno" : premios.substring(1,premios.length()-1));
            archivo.println();
        }
        archivo.close();
    }

    // Los datos de las pinturas se guardan en <nombreArchivo>
    public void guardarPinturas(String nombreArchivo, List<Pintura> pinturas)
            throws FileNotFoundException {
        PrintStream archivo = new PrintStream(nombreArchivo);
        for (Pintura pintura : pinturas) {
            // "Título";"Estilo";"Técnica";"IdAutor";"Año"[;"IdMuseo"]
            archivo.print(pintura.getTitulo() + ";");
            archivo.print(pintura.getEstilo().toString() + ";");
            archivo.print(pintura.getTecnica().toString() + ";");
            archivo.print(pintura.getAutor().getId() + ";");
            archivo.print(pintura.getAnioCreacion() + ";");
            archivo.println();
        }
        archivo.close();
    }
}
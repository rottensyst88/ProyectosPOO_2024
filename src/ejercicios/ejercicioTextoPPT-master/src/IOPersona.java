import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class IOPersona {
    private static IOPersona instance;

    private IOPersona() {
        instance = this;
    }

    public static IOPersona getInstance() {
        if (instance == null) {
            instance = new IOPersona();
        }
        return instance;
    }

    public Persona[] readPersonas() throws FileNotFoundException {
        Scanner archivo = new Scanner(new File("/home/arielb/IdeaProjects/ejercicioTextoPPT/src/personas.txt"));
        ArrayList<Persona> personas = new ArrayList<>();

        archivo.useDelimiter("; |\n");
        archivo.useLocale(Locale.UK);

        while(archivo.hasNext()) {
            String nombre = archivo.next();
            String direccion = archivo.next();
            String fecha = archivo.next();
            //System.out.println("FECHA: " + fecha);
            LocalDate fechaNac = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            EstadoCivil estadoCivil = EstadoCivil.valueOf(archivo.next());
            float estatura = Float.parseFloat(archivo.next().split("cm")[0].trim());

            personas.add(new Persona(nombre, direccion, fechaNac, estadoCivil, estatura));
        }
        archivo.close();
        return personas.toArray(new Persona[0]);
    }

    public void SavePersonas(Persona[] personas) throws FileNotFoundException {
        PrintStream archivo = new PrintStream("/home/arielb/IdeaProjects/ejercicioTextoPPT/src/personas.txt");

        for(Persona persona : personas) {
            archivo.println(persona.toString());
        }

        archivo.close();
    }
}

package ejercicios.persistencia.persona;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Persona p1 = new Persona("Ariel Bobadilla","Talquipen Km 16",
                LocalDate.of(2004,12,6),EstadoCivil.SOLTERO,1.70f);
        Persona p2 = new Persona("Juan Bañados","Huasolandia 69",
                LocalDate.of(2004,12,12),EstadoCivil.CASADO,1.75f);
        Persona p3 = new Persona("Juliana Defaur","Desconocido XX",
                LocalDate.of(2004,6,6),EstadoCivil.SOLTERO,1.65f);
        Persona[] p = {p1,p2,p3};

        IOPersona.getInstance().SavePersonas(p);

        Persona[] x = IOPersona.getInstance().readPersonas();

        for(Persona z : x){
            System.out.println(z.toString());
        }
    }
}

package evaluaciones.control2;

import java.util.ArrayList;
import java.util.List;

public class SistemaMatriculas {

    private List<Persona> personas = new ArrayList<>();
    private List<Formacion> formaciones = new ArrayList<>();

    public boolean creaPersona(String rut, String nombre) {
        Persona p = new Persona(nombre, rut);
        if (personas.contains(p)) {
            return false;
        }
        personas.add(p);
        return true;
    }

    public boolean creaDiplomado(int codigo, String nombre) {
        Diplomado d = new Diplomado(codigo, nombre);
        if (formaciones.contains(d)) {
            return false;
        }
        formaciones.add(d);
        return true;
    }

    public boolean creaCurso(int codigo, String nombre, int costo) {
        Curso c = new Curso(codigo, nombre, costo);
        if (formaciones.contains(c)) {
            return false;
        }
        formaciones.add(c);
        return true;
    }

    public boolean matriculaPersona(String rut, int codigo) {
        Persona p = null;
        Formacion f = null;

        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                p = persona;
            }
        }

        for (Formacion formacion : formaciones) {
            if (formacion.getCodigo() == codigo) {
                f = formacion;
            }
        }

        if (p == null || f == null) {
            return false;
        }

        return p.matricula(f);
    }

    public boolean agregaCursoADiplomado(int codigoCurso, int codigoDiplomado) {
        Diplomado f = null;
        Curso c = null;

        for (Formacion formacion : formaciones) {
            if (formacion.getCodigo() == codigoDiplomado) {
                f = (Diplomado) formacion;
            }
        }

        for (Formacion formacion : formaciones) {
            if (formacion.getCodigo() == codigoCurso) {
                c = (Curso) formacion;
            }
        }

        if (f == null || c == null) {
            return false;
        }

        return f.addCurso(c);
    }

    public String getNombreFormacion(int codigo) {
        for (Formacion formacion : formaciones) {
            if (formacion.getCodigo() == codigo) {
                return formacion.getNombre();
            }
        }
        return null;
    }

    public String[][] listaPersonasDeFormacion(int codigo) {

        String[][] listaPersonas = new String[personas.size()][2];
        Persona[] personaL = null;

        for (Formacion formacion : formaciones) {
            if (formacion.getCodigo() == codigo) {
                personaL = formacion.getPersonas();
                break;
            }
        }

        if (personaL == null) {
            return new String[0][0];
        }

        for (int i = 0; i < personaL.length; i++) {
            Persona persona = personaL[i];
            listaPersonas[i][0] = persona.getRut();
            listaPersonas[i][1] = persona.getNombre();
        }

        return listaPersonas;
    }

    public String getNombrePersona(String rut) {
        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                return persona.getNombre();
            }
        }
        return null;
    }

    public String[][] listaFormacionesDePersona(String rut) {
        String[][] listaFormaciones = new String[0][0];
        Formacion[] formacionL = null;

        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                formacionL = persona.getFormaciones();
                break;
            }
        }

        if (formacionL == null || formacionL.length == 0) {
            return listaFormaciones; // Devolver arreglo vacío
        }

        listaFormaciones = new String[formacionL.length][4];

        for (int i = 0; i < formacionL.length; i++) {
            Formacion formacion = formacionL[i];

            listaFormaciones[i][0] = String.valueOf(formacion.getCodigo());
            listaFormaciones[i][1] = formacion.getNombre();
            listaFormaciones[i][2] = formacion.getTipo();

            if (formacion instanceof Diplomado) {
                listaFormaciones[i][3] = "Sin costo";
            } else {
                listaFormaciones[i][3] = String.valueOf(formacion.getCosto());
            }
        }

        return listaFormaciones;
    }

}

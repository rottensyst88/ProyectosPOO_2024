import java.util.ArrayList;
import java.util.List;

public class SistemaMatriculas {
    private List<Persona> personas = new ArrayList<>();
    private List<Formacion> formaciones = new ArrayList<>();

    public boolean creaPersona(String rut, String nombre){
        Persona p = new Persona(rut, nombre);
        if(personas.contains(p)){
            return false;
        }
        personas.add(p);
        return true;
    }

    public boolean creaDiplomado(int codigo, String nombre){
        Diplomado d = new Diplomado(codigo, nombre);
        if(formaciones.contains(d)){
            return false;
        }
        return formaciones.add(d);
    }

    public boolean creaCurso(int codigo, String nombre, int costo){
        Curso c = new Curso(codigo, nombre, costo);
        if(formaciones.contains(c)){
            return false;
        }
        return formaciones.add(c);
    }

    public boolean matriculaPersona(String rut, int codigo){
        Persona p = null;
        Formacion f = null;

        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                p = persona;
                break;
            }
        }

        for(Formacion formacion : formaciones){
            if(formacion.getCodigo() == codigo){
                f = formacion;
                break;
            }
        }

        if(p == null || f == null){
            return false;
        }

        for (Formacion form : p.getFormacion()){
            if(form.getCodigo() == codigo){
                return false;
            }
        }

        return p.matricula(f);
    }

    public boolean agregaCursoADiplomado(int codigoCurso, int codigoDiplomado){
        Curso c = null;
        Diplomado d = null;

        for(Formacion formacion : formaciones){
            if(formacion.getCodigo() == codigoCurso && formacion instanceof Curso){
                c = (Curso) formacion;
            }

            if(formacion.getCodigo() == codigoDiplomado && formacion instanceof Diplomado){
                d = (Diplomado) formacion;
            }
        }



        if(c == null || d == null){
            return false;
        }

        return d.addCurso(c);
    }

    public String getNombreFormacion(int codigo){
        for(Formacion formacion : formaciones){
            if(formacion.getCodigo() == codigo){
                return formacion.getNombre();
            }
        }
        return null;
    }


    public String[][] listaPersonasDeFormacion(int codigo){
        Persona[] Pers = null;

        for(Formacion formacion : formaciones){
            if(formacion.getCodigo() == codigo){
                Pers = formacion.getPersonas();
            }
        }

        if(Pers == null){
            return new String[0][0];
        }

        String[][] listaF = new String[Pers.length][2];

        for(Persona persona_a : Pers){
            listaF[0][0] = persona_a.getRut();
            listaF[0][1] = persona_a.getNombre();
        }

        return listaF;
    }

    public String getNombrePersona(String rut){
        for(Persona persona : personas){
            if(persona.getRut().equals(rut)){
                return persona.getNombre();
            }
        }
        return null;
    }

    public String[][] listaFormacionesDePersona(String rut){
        Formacion[] Form = null;

        for(Persona persona : personas){
            if(persona.getRut().equals(rut)){
                Form = persona.getFormacion();
            }
        }

        if(Form == null || Form.length == 0){
            System.out.print("Error! Listado vacio!");
            return new String[0][0];
        }

        String[][] listaF = new String[Form.length][4];

        /* ERROR AL MOMENTO DE GUARDAR DATOS EN LA LISTA, EL INDICE DE FILAS DE LA MATRIZ NO SE ACTUALIZABA */

        for (int i = 0; i < Form.length; i++) {
            Formacion formacion = Form[i];
            listaF[i][0] = String.valueOf(formacion.getCodigo());
            listaF[i][1] = formacion.getNombre();
            if (formacion instanceof Diplomado) {
                listaF[i][2] = "Diplomado";
                listaF[i][3] = String.valueOf(formacion.getCosto());
            } else {
                listaF[i][2] = "Curso";
                listaF[i][3] = String.valueOf(formacion.getCosto());
            }
        }

        return listaF;
    }





}

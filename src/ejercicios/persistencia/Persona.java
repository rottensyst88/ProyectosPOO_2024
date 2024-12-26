package ejercicios.persistencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;
    private EstadoCivil estadoCivil;
    private float estatura;

    public Persona(String nombre, String direccion, LocalDate fechaNacimiento, EstadoCivil estadoCivil, float estatura) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.estatura = estatura;
    }

    public int getEdad(){
        return (LocalDate.now().getYear() - fechaNacimiento.getYear());
    }

    @Override
    public String toString(){
        return (nombre+"; "+direccion+"; "+fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+
                "; "+estadoCivil+"; "+estatura+"cm" + " --> Su edad es " + getEdad()+" años");
    }
}

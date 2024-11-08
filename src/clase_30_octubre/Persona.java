package clase_30_octubre;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String direccion;
    private List<EMail> emails = new ArrayList<>();

    public Persona(int id, String nombre, String dir) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = dir;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean addEMail(String dirEmail) {
        return false;
    }

}

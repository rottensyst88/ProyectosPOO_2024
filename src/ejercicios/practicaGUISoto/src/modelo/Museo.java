package modelo;

import java.util.ArrayList;
import java.util.List;

public class Museo {
    private int id;
    private String nombre;
    private String direccion;
    private String pais;
    private List<Pintura> pinturas;

    public Museo(int id, String nombre, String direccion, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
        this.pinturas = new ArrayList<>();
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

    public String getPais() {
        return pais;
    }

    public void addPintura(Pintura pintura) {
        if (!pinturas.contains(pintura)) {
            pinturas.add(pintura);
        }
    }

    public Pintura[] getPinturas() {
        return pinturas.toArray(new Pintura[0]);
    }
}
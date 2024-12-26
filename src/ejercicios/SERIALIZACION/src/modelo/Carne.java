package ejercicios.SERIALIZACION.src.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Carne implements Serializable{
    private String nombre;
    private double pesoKilogramos;
    private double precio;
    private String marca;
    private long serie;
    private LocalDate fecha;

    public Carne(String nombre, double pesoKilogramos, double precio, String marca, long serie, LocalDate fecha) {
        this.nombre = nombre;
        this.pesoKilogramos = pesoKilogramos;
        this.precio = precio;
        this.marca = marca;
        this.serie = serie;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPesoKilogramos() {
        return pesoKilogramos;
    }

    public void setPesoKilogramos(double pesoKilogramos) {
        this.pesoKilogramos = pesoKilogramos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getSerie() {
        return serie;
    }

    public void setSerie(long serie) {
        this.serie = serie;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carne carne)) return false;
        return getSerie() == carne.getSerie();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSerie());
    }
}

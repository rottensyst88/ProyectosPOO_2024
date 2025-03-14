package ejercicios.serializacion.kiosko.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Leche implements Serializable {
    private String nombre;
    private int cantidad;
    private double precio;
    private String marca;
    private long serie;
    private LocalDate fecha;

    public Leche(String nombre, int cantidad, double precio, String marca, long serie, LocalDate fecha) {
        this.nombre = nombre;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        if (!(o instanceof Leche leche)) return false;
        return getSerie() == leche.getSerie();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSerie());
    }
}

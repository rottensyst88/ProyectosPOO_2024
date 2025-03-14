package ejercicios.serializacion.kiosko.controlador;
import ejercicios.serializacion.kiosko.excepcion.KioskoExcp;
import ejercicios.serializacion.kiosko.modelo.Carne;
import ejercicios.serializacion.kiosko.modelo.Leche;
import ejercicios.serializacion.modelo.*;
import ejercicios.serializacion.kiosko.serializacion.IOKiosko;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorKiosko implements Serializable {

    private static ControladorKiosko instance = new ControladorKiosko();

    private ControladorKiosko() {
    }

    public static ControladorKiosko getInstance() {
        return instance;
    }

    ArrayList<Leche> leches = new ArrayList<>();
    ArrayList<Carne> carnes = new ArrayList<>();

    public boolean agregarLeche(String nombre, int cantidad, double precio, String marca, long serie, LocalDate fecha){
        for(Leche leche : leches){
            if(leche.getSerie() == serie){
                return false;
            }
        }

        return leches.add(new Leche(nombre, cantidad, precio, marca, serie, fecha));
    }

    public boolean agregarCarne(String nombre, double pesoKilogramos, double precio, String marca, long serie, LocalDate fecha){
        for(Carne carne : carnes){
            if(carne.getSerie() == serie){
                return false;
            }
        }

        return carnes.add(new Carne(nombre, pesoKilogramos, precio, marca, serie, fecha));
    }

    public String[][] getLeches(){
        String[][] lecheArray = new String[this.leches.size()][];

        for (int i = 0; i < leches.size(); i++) {
            Leche leche = leches.get(i);

            lecheArray[i][0] = leche.getNombre();
            lecheArray[i][1] = String.valueOf(leche.getCantidad());
            lecheArray[i][2] = String.valueOf(leche.getPrecio());
            lecheArray[i][3] = leche.getMarca();
            lecheArray[i][4] = String.valueOf(leche.getSerie());
            lecheArray[i][5] = leche.getFecha().toString();
        }

        return lecheArray;
    }

    public String[][] getCarnes(){
        String[][] carneArray = new String[carnes.size()][6];

        for (int i = 0; i < carnes.size(); i++) {
            Carne carne = carnes.get(i);

            carneArray[i][0] = carne.getNombre();
            carneArray[i][1] = String.valueOf(carne.getPesoKilogramos());
            carneArray[i][2] = String.valueOf(carne.getPrecio());
            carneArray[i][3] = carne.getMarca();
            carneArray[i][4] = String.valueOf(carne.getSerie());
            carneArray[i][5] = carne.getFecha().toString();
        }
        return carneArray;
    }

    public void escribirDatos() {
        try{
            IOKiosko.getInstance().escribirDatos(this);
        } catch (KioskoExcp e){
            System.out.println(e.getMessage());
        }
    }

    public void leerDatos() throws KioskoExcp {
        instance = (ControladorKiosko) IOKiosko.getInstance().leerDatos();
    }
}

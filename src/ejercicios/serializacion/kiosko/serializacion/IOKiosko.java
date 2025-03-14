package ejercicios.serializacion.kiosko.serializacion;

import ejercicios.serializacion.kiosko.controlador.ControladorKiosko;

import java.io.*;

import ejercicios.serializacion.excepcion.*;
import ejercicios.serializacion.kiosko.excepcion.KioskoExcp;

public class IOKiosko implements Serializable {
    private static IOKiosko instance = new IOKiosko();

    private IOKiosko() {
    }
    public static IOKiosko getInstance() {
        return instance;
    }

    public void escribirDatos(ControladorKiosko controladorKiosko) throws KioskoExcp {
        ObjectOutputStream archivo = null;

        try{
            archivo = new ObjectOutputStream(new FileOutputStream("Kiosko.kio"));
            archivo.writeObject(controladorKiosko);
            archivo.close();

        } catch (FileNotFoundException e){
            throw new KioskoExcp(e.getMessage());
        } catch (IOException e) {
            throw new KioskoExcp(e.getMessage());
        }
    }

    public Object leerDatos() throws KioskoExcp {
        ObjectInputStream archivo = null;
        ControladorKiosko kiosko = null;

        try{
            archivo = new ObjectInputStream(new FileInputStream("Kiosko.kio"));

            kiosko = (ControladorKiosko) archivo.readObject();

        } catch (FileNotFoundException e){
            throw new KioskoExcp(e.getMessage());
        } catch (IOException e) {
            throw new KioskoExcp(e.getMessage());
        } catch (ClassNotFoundException e){
            throw new KioskoExcp(e.getMessage());
        }

        return kiosko;
    }
}

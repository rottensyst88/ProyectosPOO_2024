package clase_16_sept.leeArchivoTxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        File file = new File("src/clase_16_sept/ejemplo1/file.txt");

        try{
            Scanner sc = new Scanner(file);
            sc.useDelimiter("; |\r|\n|\n\r");

            while(sc.hasNext()){
                int id = sc.nextInt();
                String nombre = sc.next();
                String[] lista = sc.next().trim().split(",");

                System.out.printf("%s (%d telefonos)\n",nombre,lista.length);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
package ejercicios.ejercicioExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continua = true;

        do{
            try{
                System.out.println("Ingrese el denominador? ");
                int den = sc.nextInt();

                System.out.println("Ingrese el numerador: ");
                int num = sc.nextInt();

                System.out.println("El resultado es : " + num/den);

                continua = false;

            }catch (InputMismatchException e){
                System.out.println("ERROR! Ingrese un valor valido!");
                sc.next();
            }catch (ArithmeticException e){
                System.out.println("ERROR! No se puede dividir por cero!");
            }catch (Exception e){
                System.out.println("ERROR! Error inesperado durante la ejecución del código!");
            }finally {
                System.out.println("INTENTO DE DIVISIÓN REALIZADO!");
            }

        }while(continua);
    }

}

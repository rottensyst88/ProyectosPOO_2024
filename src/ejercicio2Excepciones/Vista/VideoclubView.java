package ejercicio2Excepciones.Vista;
import ejercicio2Excepciones.Controlador.VideoclubController;

import java.util.Scanner;

public class VideoclubView {

    private VideoclubController controller;

    public VideoclubView(VideoclubController controller) {
        this.controller = controller;
    }

    public void mostrarMenu() {
        Scanner tecl = new Scanner(System.in);

        do {
            System.out.println("""
                    ----- Videoclub -----
                    1) RENTAR JUEGO
                    2) DEVOLVER JUEGO
                    3) SALIR
                    """);

            System.out.print("Seleccione una opción: ");
            int select = tecl.nextInt();

            switch (select) {
                case 1 -> rentarJuego(controller, tecl);
                case 2 -> devolverJuego(controller, tecl);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Error! Use valores validos!");
            }
        } while (true);
    }

    private void rentarJuego(VideoclubController controller, Scanner tecl) {
        System.out.print("Ingrese nombre del videojuego: ");
        String nom = tecl.next();
        controller.rentarVideojuego(nom);
    }

    private void devolverJuego(VideoclubController controller, Scanner tecl) {
        System.out.print("Ingrese nombre del videojuego: ");
        String nom = tecl.next();
        controller.devolverVideojuego(nom);
    }
}

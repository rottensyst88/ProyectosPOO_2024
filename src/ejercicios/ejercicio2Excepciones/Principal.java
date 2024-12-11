package ejercicios.ejercicio2Excepciones;

import ejercicios.ejercicio2Excepciones.Controlador.VideoclubController;
import ejercicios.ejercicio2Excepciones.Modelo.Videoclub;
import ejercicios.ejercicio2Excepciones.Modelo.Videojuego;
import ejercicios.ejercicio2Excepciones.Vista.VideoclubView;

public class Principal {

    public static void main(String[] args) {
        Videoclub videoclub = Videoclub.getInstancia();
        videoclub.agregarVideojuego(new Videojuego("Test1"));
        videoclub.agregarVideojuego(new Videojuego("Test2"));
        videoclub.agregarVideojuego(new Videojuego("Test3"));
        VideoclubController controller = new VideoclubController(videoclub);
        VideoclubView view = new VideoclubView(controller);

        view.mostrarMenu();
    }
}

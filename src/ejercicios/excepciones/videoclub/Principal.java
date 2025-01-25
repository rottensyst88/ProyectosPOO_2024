package ejercicios.excepciones.videoclub;

import ejercicios.excepciones.videoclub.Controlador.VideoclubController;
import ejercicios.excepciones.videoclub.Modelo.Videoclub;
import ejercicios.excepciones.videoclub.Modelo.Videojuego;
import ejercicios.excepciones.videoclub.Vista.VideoclubView;

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

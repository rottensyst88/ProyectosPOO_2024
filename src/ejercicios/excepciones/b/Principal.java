package ejercicios.excepciones.b;

import ejercicios.excepciones.b.Controlador.VideoclubController;
import ejercicios.excepciones.b.Modelo.Videoclub;
import ejercicios.excepciones.b.Modelo.Videojuego;
import ejercicios.excepciones.b.Vista.VideoclubView;

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

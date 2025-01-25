package ejercicios.excepciones.videoclub.Controlador;

import ejercicios.excepciones.videoclub.Excepciones.VideojuegoNoDisponibleException;
import ejercicios.excepciones.videoclub.Modelo.Videoclub;
import ejercicios.excepciones.videoclub.Modelo.Videojuego;

public class VideoclubController {
    private Videoclub videoclub;

    public VideoclubController(Videoclub videoclub){
        this.videoclub = videoclub;
    }

    public void rentarVideojuego(String nombre){
        Videojuego videojuego = videoclub.buscarVideojuego(nombre);
        if(videojuego != null){
            try{
                videojuego.rentar();
                System.out.println("El videojuego "+nombre+" ha sido rentado!");
            } catch (VideojuegoNoDisponibleException e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("El videojuego no existe!");
        }
    }

    public void devolverVideojuego(String nombre){
        Videojuego videojuego = videoclub.buscarVideojuego(nombre);

        if(videojuego != null){
            if(!videojuego.isDisponible()){
                videojuego.devolver();
                System.out.println("El videojuego "+nombre+" ha sido devuelto!");
            }else{
                System.out.println("El videojuego ya se encuentra devuelto!");
            }
        }else{
            System.out.println("El videojuego no existe!");
        }
    }
}

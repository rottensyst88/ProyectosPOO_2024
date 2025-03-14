package ejercicios.excepciones.videoclub.Controlador;

import ejercicios.excepciones.videoclub.Excepciones.VideojuegoNoDisponibleException;
import ejercicios.excepciones.videoclub.Modelo.Videoclub;
import ejercicios.excepciones.videoclub.Modelo.Videojuego;

public class VideoclubController {
    private Videoclub videoclub;

    public VideoclubController(Videoclub videoclub){
        this.videoclub = videoclub;
    }

    public void rentarVideojuego(String nombre) throws VideojuegoNoDisponibleException{
        Videojuego videojuego = videoclub.buscarVideojuego(nombre);
        if(videojuego != null){

            boolean disponible = videojuego.rentar();
            if(disponible){
                System.out.println("Se ha rentado el videojuego " + nombre);
            }else{
                throw new VideojuegoNoDisponibleException("El videojuego "+nombre+" ya ha sido rentado, no lo tenemos disponible!");
            }

            /*
            try{
                videojuego.rentar();
                System.out.println("El videojuego "+nombre+" ha sido rentado!");
            } catch (VideojuegoNoDisponibleException e) {
                System.out.println(e.getMessage());
            }*/
        }else{
            throw new VideojuegoNoDisponibleException("Videojuego no encontrado!");
        }
    }

    public void devolverVideojuego(String nombre) throws VideojuegoNoDisponibleException{
        Videojuego videojuego = videoclub.buscarVideojuego(nombre);

        if(videojuego != null){
            if(!videojuego.isDisponible()){
                videojuego.devolver();
                System.out.println("El videojuego "+nombre+" ha sido devuelto!");
            }else{
                throw new VideojuegoNoDisponibleException("El videojuego ya se encuentra devuelto!");
            }
        }else{
            throw new VideojuegoNoDisponibleException("El videojuego no existe!");
        }
    }
}

package controlador;

import modelo.Usuario;

import java.util.ArrayList;

public class ControladorUsuario {
    /* SINGLETON */

    private static ControladorUsuario instance = new ControladorUsuario();

    private ControladorUsuario(){
    }

    public static ControladorUsuario getInstance(){
        return instance;
    }

    /* SINGLETON */

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public boolean crearUsuario(String username, String password, String email, String name){
        Usuario user = new Usuario(username, password, name, email);
        if(usuarios.contains(user)){
            return false;
        }
        return usuarios.add(user);
    }

    public boolean userIsValid(String username, String password){
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

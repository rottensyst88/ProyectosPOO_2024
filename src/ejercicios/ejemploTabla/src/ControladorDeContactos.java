import java.util.ArrayList;

public class ControladorDeContactos {
    private static ControladorDeContactos instance = new ControladorDeContactos();

    private ControladorDeContactos() {
    }

    public static ControladorDeContactos getInstance() {
        return instance;
    }

    private ArrayList<Contacto> misContactos = new ArrayList<>();

    public boolean agregarContacto(String nombre, String email, String telefono) {
        return misContactos.add(new Contacto(nombre, telefono, email));
    }

    public String[][] getContactos() {
        String[][] out = new String[misContactos.size()][3];
        for (int i = 0; i < misContactos.size(); i++) {
            Contacto contacto = misContactos.get(i);
            out[i][0] = contacto.getNombre();
            out[i][1] = contacto.getTelefono();
            out[i][2] = contacto.getEmail();
        }
        return out;
    }
}

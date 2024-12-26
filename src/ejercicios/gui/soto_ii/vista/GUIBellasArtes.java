package ejercicios.gui.soto_ii.vista;

import controlador.ControladorBellasArtes;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class GUIBellasArtes extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton generarDatosButton;
    private JButton guardarDatosButton;
    private JButton leerDatosButton;
    private JButton nuevoMuseoButton;
    private JButton nuevoAutorButton;
    private JButton nuevaPinturaButton;
    private JButton listarMuseosButton;

    public GUIBellasArtes() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        generarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarDatos();
            }
        });
        listarMuseosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarMuseos();
            }
        });
        guardarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        leerDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        nuevoMuseoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearMuseo();
            }
        });
        nuevoAutorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearAutor();
            }
        });
    }

    private void crearAutor() {
        GUINuevoAutor.main(null);
    }

    private void crearMuseo() {
        GUINuevoMuseo.main(null);
    }

    private void leerDatos() {
        try{
            ControladorBellasArtes.getInstancia().leerDatosSistema();
            JOptionPane.showMessageDialog(null, "Datos leidos con exito");
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se pudieron leer los datos: " + e.getMessage());
        }
    }

    private void guardarDatos() {
        try{
            ControladorBellasArtes.getInstancia().guardarDatosSistema();
            JOptionPane.showMessageDialog(null,"Datos guardados exitosamente");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar datos!");
        }
    }

    private void listarMuseos() {
        GUIListaMuseos.main(null);
    }

    private void generarDatos() {
        ControladorBellasArtes.getInstancia().generarMuseosAutoresYPinturas();
        JOptionPane.showMessageDialog(this, "Datos generados correctamente");
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUIBellasArtes dialog = new GUIBellasArtes();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

package ejercicios.SERIALIZACION.src.vista;

import controlador.ControladorKiosko;
import excepcion.KioskoExcp;

import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton crearCarneButton;
    private JButton leerDatosButton;
    private JButton listarCarneButton;
    private JButton guardarDatosButton;

    public VentanaPrincipal() {
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

        crearCarneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearCarne();
            }
        });
        listarCarneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarCarne();
            }
        });
        leerDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        guardarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
        try{
            ControladorKiosko.getInstance().escribirDatos();
            JOptionPane.showMessageDialog(this,"Datos guardados exitosamente");
        } catch (KioskoExcp e) {
            JOptionPane.showMessageDialog(this,"No se puede guardar los datos!");
        }
    }

    private void leerDatos() {
        try{
            ControladorKiosko.getInstance().leerDatos();
            JOptionPane.showMessageDialog(this,"Datos leidos exitosamente");
        } catch (KioskoExcp e) {
            JOptionPane.showMessageDialog(this,"No se puede leer los datos!");
        }

    }

    private void listarCarne() {
        tablaCulia.main(null);
    }

    private void crearCarne() {
        crearCarne.main(null);
    }

    private void onCancel() {
        dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        VentanaPrincipal dialog = new VentanaPrincipal();
        dialog.setTitle("Ventana principal de Kiosko");
        dialog.setLocationRelativeTo(null);
        //dialog.setSize(600, 800);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
    }
}

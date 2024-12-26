package ejercicios.SistemaGUI_SOTO_FINAL.src.vista;

import controlador.ControladorBellasArtes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;

public class GUIListaMuseos extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JTable tablaMuseos;

    public GUIListaMuseos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        String[] cabeceras = {"Id","Nombre","Dirección","País"};
        String[][] datos = ControladorBellasArtes.getInstancia().listarMuseos();
        tablaMuseos.setModel(new DefaultTableModel(datos, cabeceras));

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
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUIListaMuseos dialog = new GUIListaMuseos();
        dialog.pack();
        dialog.setVisible(true);
    }
}

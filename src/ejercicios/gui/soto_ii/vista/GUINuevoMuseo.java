package ejercicios.gui.soto_ii.vista;

import ejercicios.gui.soto_ii.controlador.BellasArtesException;
import ejercicios.gui.soto_ii.controlador.ControladorBellasArtes;

import javax.swing.*;
import java.awt.event.*;

public class GUINuevoMuseo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField direccionField;
    private JTextField nombreField;
    private JTextField idField;
    private JTextField paisField;

    public GUINuevoMuseo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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

    private void onOK() {
        String id = idField.getText();
        String nombre = nombreField.getText();
        String pais = paisField.getText();
        String direccion = direccionField.getText();

        if (id.isEmpty() || nombre.isEmpty() || pais.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe agregar los campos");
        } else {
            try {
                int idNum = Integer.parseInt(id);
                ControladorBellasArtes.getInstancia().creaNuevoMuseo(idNum, nombre, direccion, pais);
                JOptionPane.showMessageDialog(null, "Museo creado correctamente!");
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID ingresada no es valida!");
                idField.setText("");
            } catch (BellasArtesException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUINuevoMuseo dialog = new GUINuevoMuseo();
        dialog.pack();
        dialog.setVisible(true);
    }
}

package vista;

import javax.swing.*;
import java.awt.event.*;
import controlador.*;

public class GUINuevaPersona extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField rutField;
    private JTextField nombreField;

    public GUINuevaPersona() {
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
        String rut = rutField.getText();
        String nombre = nombreField.getText();

        if(rut.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La rutina no puede estar vacia");
        }else{
            try{
                SistemaMatriculas.getInstance().creaPersona(rut,nombre);
                JOptionPane.showMessageDialog(this,"Persona guardada correctamente!");
                dispose();
            } catch (SistemaMatriculasException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUINuevaPersona dialog = new GUINuevaPersona();
        dialog.setTitle("Nueva Persona");
        dialog.pack();
        dialog.setVisible(true);
    }
}

package vista;

import controlador.SistemaMatriculas;
import controlador.SistemaMatriculasException;

import javax.swing.*;
import java.awt.event.*;

public class GUIMatriculaPersona extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox personaField;
    private JComboBox programaFormacField;

    public GUIMatriculaPersona() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        String[][] datos = SistemaMatriculas.getInstance().listaPersonas();
        for(String[] x : datos){
            String dato = x[0] +", "+ x[1];
            personaField.addItem(dato);
        }

        String[][] formaciones = SistemaMatriculas.getInstance().listaFormaciones();
        for(String[] x : formaciones){
            String dato = x[0] +", "+ x[1];
            programaFormacField.addItem(dato);
        }


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
        String datoPersona = personaField.getSelectedItem().toString();
        String datoPrograma = programaFormacField.getSelectedItem().toString();

        String[] rut = datoPersona.split(", ");
        String[] codigo = datoPrograma.split(", ");

        int codigoEntero = Integer.parseInt(codigo[0]);

        try{
            SistemaMatriculas.getInstance().matriculaPersona(rut[0],codigoEntero);
            JOptionPane.showMessageDialog(this,"Operacion completada correctamente!");
            dispose();
        } catch (SistemaMatriculasException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUIMatriculaPersona dialog = new GUIMatriculaPersona();
        dialog.setTitle("Matricular persona");
        dialog.pack();
        dialog.setVisible(true);
    }
}

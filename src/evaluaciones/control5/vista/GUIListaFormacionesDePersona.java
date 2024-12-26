package evaluaciones.control5.vista;

import evaluaciones.control5.controlador.SistemaMatriculas;
import evaluaciones.control5.controlador.SistemaMatriculasException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class GUIListaFormacionesDePersona extends JDialog {
    private JPanel contentPane;
    private JButton generarListadoButton;
    private JButton volverButton;
    private JComboBox personaComboBox;
    private JTable tablaPersonas;

    public GUIListaFormacionesDePersona() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(generarListadoButton);

        String[][] personas = SistemaMatriculas.getInstance().listaPersonas();
        for(String[] x : personas){
            personaComboBox.addItem(x[1]);
        }

        String[] cabeceras = {"Codigo","Nombre","Modalidad","Tipo","Costo"};
        tablaPersonas.setModel(new DefaultTableModel(null,cabeceras));

        generarListadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        volverButton.addActionListener(new ActionListener() {
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
        String[] cabeceras = {"Codigo","Nombre","Modalidad","Tipo","Costo"};
        String datosPersona = personaComboBox.getSelectedItem().toString();
        String rut = null;

        for(String[] x : SistemaMatriculas.getInstance().listaPersonas()){
            if(x[1].equals(datosPersona)){
                rut = x[0];
                break;
            }
        }

        try{
            String[][] datos = SistemaMatriculas.getInstance().listaFormacionesDePersona(rut);

            if(datos.length == 0){
                JOptionPane.showMessageDialog(this, "La persona solicitada no registra formación");
                tablaPersonas.setModel(new DefaultTableModel(null,cabeceras));
            }else{
                tablaPersonas.setModel(new DefaultTableModel(datos,cabeceras));
            }

        } catch (SistemaMatriculasException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUIListaFormacionesDePersona dialog = new GUIListaFormacionesDePersona();
        dialog.setTitle("Listado de formaciones de una persona");
        dialog.pack();
        dialog.setVisible(true);
    }
}

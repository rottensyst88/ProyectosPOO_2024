package evaluaciones.control5.vista;

import evaluaciones.control5.controlador.SistemaMatriculas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class GUIListaPersonasDeFormacion extends JDialog {
    private JPanel contentPane;
    private JButton generarListadoButton;
    private JButton volverButton;
    private JTable tablaDatos;
    private JScrollPane scrollPAne;
    private JTextField formacionesField;

    public GUIListaPersonasDeFormacion() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(generarListadoButton);

        String[] cabeceras = {"Rut","Nombre"};
        tablaDatos.setModel(new DefaultTableModel(null,cabeceras));

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
        String[] cabeceras = {"Rut","Nombre"};
        String codigo = formacionesField.getText();

        try{
            int codigoEntero = Integer.parseInt(codigo);
            String[][] datos = SistemaMatriculas.getInstance().listaPersonasDeFormacion(codigoEntero);

            if(datos.length == 0){
                JOptionPane.showMessageDialog(this,"Programa de formacion no registra usuarios");
                tablaDatos.setModel(new DefaultTableModel(null,cabeceras));
            }else{
                tablaDatos.setModel(new DefaultTableModel(datos,cabeceras));
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Valor ingresado no valido");
            formacionesField.setText("");
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUIListaPersonasDeFormacion dialog = new GUIListaPersonasDeFormacion();
        dialog.setTitle("Listado de personas de un programa de formacion");
        dialog.pack();
        dialog.setVisible(true);
    }
}

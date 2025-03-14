package ejercicios.serializacion.kiosko.vista;

import ejercicios.serializacion.kiosko.controlador.ControladorKiosko;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class tablaCulia extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;

    public tablaCulia() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        String[] cabecera = {"Nombre","Peso","Precio","Marca","Serie","Fecha"};
        String[][] datos = ControladorKiosko.getInstance().getCarnes();
        table1.setModel(new DefaultTableModel(datos,cabecera));

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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        tablaCulia dialog = new tablaCulia();
        dialog.pack();
        dialog.setVisible(true);
    }
}

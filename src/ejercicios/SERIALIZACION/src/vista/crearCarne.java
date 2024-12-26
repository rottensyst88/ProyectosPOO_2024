package ejercicios.SERIALIZACION.src.vista;

import controlador.ControladorKiosko;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class crearCarne extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreF;
    private JTextField PesoF;
    private JTextField precioF;
    private JTextField marcaF;
    private JTextField serieF;
    private JTextField fechaF;

    public crearCarne() {
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
        String nombre = nombreF.getText();
        String peso = PesoF.getText();
        String precio = precioF.getText();
        String marca = marcaF.getText();
        String serie = serieF.getText();
        String fecha = fechaF.getText();

        if(nombre.isEmpty() || peso.isEmpty() || precio.isEmpty() || marca.isEmpty() || serie.isEmpty() || fecha.isEmpty()){
            JOptionPane.showMessageDialog(this,"Faltan datos por rellenar!");
        }else{
            ControladorKiosko.getInstance().agregarCarne(nombre,Double.parseDouble(peso),Double.parseDouble(precio),marca,Long.parseLong(serie),LocalDate.parse(fecha,DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            JOptionPane.showMessageDialog(this,"Carne creada correctamente");
            dispose();
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        crearCarne dialog = new crearCarne();
        dialog.pack();
        dialog.setVisible(true);
    }
}

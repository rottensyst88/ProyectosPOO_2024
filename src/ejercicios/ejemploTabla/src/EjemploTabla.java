package ejercicios.ejemploTabla.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class EjemploTabla extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel tituloLabel;
    private JTable TablaDeContactos;
    private JTextField nombreField;
    private JTextField telefonoField;
    private JTextField emailField;
    private JButton button1;

    public EjemploTabla() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        // Se llena la tabla

        String[] nombreColumnas = {"Nombre","Telefono","Email"};
        String[][] datosTabla = ControladorDeContactos.getInstance().getContactos();
        TablaDeContactos.setModel(new DefaultTableModel(datosTabla,nombreColumnas));



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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });
    }

    private void agregarContacto() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();

        if(nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()){
            JOptionPane.showMessageDialog(this,"Error! Datos invalidos!");
        }else{
            ControladorDeContactos.getInstance().agregarContacto(nombre,telefono,email);
            String[] nombreColumnas = {"Nombre","Telefono","Email"};
            String[][] datosTabla = ControladorDeContactos.getInstance().getContactos();
            TablaDeContactos.setModel(new DefaultTableModel(datosTabla,nombreColumnas));
            nombreField.setText("");
            telefonoField.setText("");
            emailField.setText("");
        }
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        EjemploTabla dialog = new EjemploTabla();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

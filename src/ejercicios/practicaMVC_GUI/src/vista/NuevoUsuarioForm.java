package ejercicios.practicaMVC_GUI.src.vista;

import controlador.ControladorUsuario;

import javax.swing.*;
import java.awt.event.*;

public class NuevoUsuarioForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel nombreLabel;
    private JTextField nombreTextField;
    private JTextField emailTextField;
    private JTextField userTextField;
    private JTextField pwdTextField;
    private JTextField RpwdTExtField;
    private JLabel emailLabel;
    private JLabel userLabel;
    private JLabel pwdLabel;
    private JLabel RpwdLabel;
    private JLabel nuevoUsuarioLabel;
    private JPasswordField pwdField;
    private JPasswordField RpwdField;

    public NuevoUsuarioForm() {
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
        ControladorUsuario controlador = ControladorUsuario.getInstance();
        String username = userTextField.getText();
        String email = emailTextField.getText();
        String name = nombreTextField.getText();
        String pwd = String.valueOf(pwdField.getPassword());
        String Rpwd = String.valueOf(RpwdField.getPassword());


        if (pwd.equals(Rpwd) && pwd.length() > 3) {
            if (controlador.crearUsuario(username,pwd,email,name)){
                JOptionPane.showMessageDialog(this,"Usuario creado exitosamente!");
                dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Error! El usuario ya existe!");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Error! Revise contraseñas!");
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        NuevoUsuarioForm dialog = new NuevoUsuarioForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

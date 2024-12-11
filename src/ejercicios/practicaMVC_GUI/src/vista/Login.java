package vista;

import javax.swing.*;
import java.awt.event.*;

import controlador.*;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel tituloLabel;
    private JTextField usuarioTextField;
    private JPasswordField passwordTextField;

    public Login() {
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
        String user = usuarioTextField.getText();
        String pwd = String.valueOf(passwordTextField.getPassword());

        if (ControladorUsuario.getInstance().userIsValid(user, pwd)) {
            dispose();
            MainForm.main(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error! Datos ingresados no validos!");
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        ControladorUsuario.getInstance()
                .crearUsuario("adminisp", "admin123", "pedro@att.com", "Pedro");

        ControladorUsuario.getInstance()
                .crearUsuario("juan", "juan123", "juan@aol.com", "Juan");

        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
    }
}

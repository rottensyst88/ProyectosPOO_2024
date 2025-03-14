package ejercicios.gui.imc;

import javax.swing.*;
import java.awt.event.*;

public class CalculadoraIMC extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField pesoTextField;
    private JTextField estaturaTextField;
    private JLabel tituloLabel;
    private JLabel pesoLabel;
    private JLabel estaturaLabel;
    private JLabel resultadoLabel;

    public CalculadoraIMC() {
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
        double peso = Double.parseDouble(pesoTextField.getText());
        double estatura = Double.parseDouble(estaturaTextField.getText());

        Double imc = peso / (estatura * estatura);
        String imcFormat = String.format("%.2f", imc);
        resultadoLabel.setText(imcFormat);
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        CalculadoraIMC dialog = new CalculadoraIMC();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

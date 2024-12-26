package ejercicios.gui.calculadora;

import javax.swing.*;
import java.awt.event.*;

public class UI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel titulo;
    private JTextField val1;
    private JComboBox selector;
    private JTextField val2;
    private JLabel resultado;

    public UI() {
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
        Double x,y;

        try {
            x = Double.parseDouble(val1.getText());
            y = Double.parseDouble(val2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valores incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String val_oper = String.valueOf(selector.getSelectedItem());
        selector.setSelectedItem(val_oper);
        Double res = null;

        switch (val_oper) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "*":
                res = x * y;
                break;
            case "/":
                if(y == 0){
                    JOptionPane.showMessageDialog(this, "Valores incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    res = x / y;
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Valores incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                dispose();
        }

        if(res != null){
            resultado.setText(""+ res);
        }
    }

    private void onCancel() {
        // add your code here if necesDouble ysary
        dispose();
    }

    public static void main(String[] args) {
        UI dialog = new UI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

package vista;

import controlador.SistemaMatriculas;
import controlador.SistemaMatriculasException;
import modelo.*;

import javax.swing.*;
import java.awt.event.*;

public class GUINuevaFormacion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField codigoField;
    private JTextField nombreField;
    private JComboBox modalidadComboBox;
    private JRadioButton cursoRadioB;
    private JRadioButton diplomadoRadioB;
    private JTextField costoField;

    public GUINuevaFormacion() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        cursoRadioB.setSelected(true);
        costoField.setEnabled(true);

        String[] datos = {"PRESENCIAL", "EN_LINEA", "HIBRIDO"};

        for (String x : datos) {
            modalidadComboBox.addItem(x);
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
        cursoRadioB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cursoRadioB.isSelected()) {
                    costoField.setEnabled(true);
                }
            }
        });
        diplomadoRadioB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (diplomadoRadioB.isSelected()) {
                    costoField.setEnabled(false);
                }
            }
        });
    }

    private void onOK() {
        try {
            String precio = "_";

            String codigo = codigoField.getText();
            String nombre = nombreField.getText();
            String modalidad = modalidadComboBox.getSelectedItem().toString();
            precio = costoField.getText();

            if (codigo.isEmpty() || nombre.isEmpty() || modalidad.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar los campos");
            } else {
                if (diplomadoRadioB.isSelected()) {
                    try {
                        SistemaMatriculas.getInstance().creaDiplomado(Integer.valueOf(codigo), nombre, Modalidad.valueOf(modalidad));
                        JOptionPane.showMessageDialog(this, "Diplomado creado exitosamente");
                        dispose();
                    } catch (SistemaMatriculasException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else {
                    try {
                        if (precio.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Debe ingresar un costo");
                        } else {
                            SistemaMatriculas.getInstance().creaCurso(Integer.valueOf(codigo), nombre, Modalidad.valueOf(modalidad), Integer.valueOf(precio));
                            JOptionPane.showMessageDialog(this, "Curso creado exitosamente");
                            dispose();
                        }

                    } catch (SistemaMatriculasException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Codigo no valido!");
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        GUINuevaFormacion dialog = new GUINuevaFormacion();
        dialog.setTitle("Nueva formación");
        dialog.pack();
        dialog.setVisible(true);
    }
}

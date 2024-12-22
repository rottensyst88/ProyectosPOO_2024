package vista;

import javax.swing.*;
import java.awt.event.*;

public class GUIInicial extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton nuevaPersonaButton;
    private JButton nuevaFormacionButton;
    private JButton matriculaPersonaButton;
    private JButton agregaCursoADiplomadoButton;
    private JButton listaFormacionesDePersonaButton;
    private JButton listaPersonasDeFormacionButton;

    public GUIInicial() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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

        agregaCursoADiplomadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCursoADiplomado();
            }
        });
        nuevaPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaPersona();
            }
        });
        nuevaFormacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaFormacion();
            }
        });
        matriculaPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matriculaPersona();
            }
        });
        listaFormacionesDePersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaFormacionesDePersona();
            }
        });
        listaPersonasDeFormacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPersonasDeFormacion();
            }
        });
    }

    private void listaPersonasDeFormacion() {
        GUIListaPersonasDeFormacion.main(null);
    }

    private void listaFormacionesDePersona() {
        GUIListaFormacionesDePersona.main(null);
    }

    private void matriculaPersona() {
        GUIMatriculaPersona.main(null);
    }

    private void nuevaFormacion() {
        GUINuevaFormacion.main(null);
    }

    private void nuevaPersona() {
        GUINuevaPersona.main(null);
    }

    private void agregarCursoADiplomado() {
        JOptionPane.showMessageDialog(this,"Función no implementada!");
    }

    private void onCancel() {
        System.exit(0);
    }

    public static void main(String[] args) {
        GUIInicial dialog = new GUIInicial();
        dialog.setTitle("Sistema de matriculas");
        dialog.pack();
        dialog.setVisible(true);
    }
}

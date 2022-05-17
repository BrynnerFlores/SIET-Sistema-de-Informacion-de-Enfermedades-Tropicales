package View.GestionExamenes;

import Model.POJO.VariableExamen;
import Presenter.GestionExamenes.PresenterGestionVariablesExamen;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brynner
 */
public class ModificarVariableExamen extends javax.swing.JDialog implements PresenterGestionVariablesExamen.CallBackVerificarExistenciaVariableExamen, PresenterGestionVariablesExamen.CallBackModificarVariableExamen {

    private final PresenterGestionVariablesExamen presenterGestionVariablesExamen;
    private VariableExamen variableExamen;

    public ModificarVariableExamen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionVariablesExamen = new PresenterGestionVariablesExamen();
        presenterGestionVariablesExamen.setCallBackVerificarExistenciaVariableExamen(this);
        presenterGestionVariablesExamen.setCallBackModificarVariableExamen(this);

        JTXTFVariableExamenNombre.addActionListener(action);
        JTXTFValorReferencia.addActionListener(action);
        JTXTFVariableExamenMetodo.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setVariableExamen(VariableExamen variableExamen) {
        this.variableExamen = variableExamen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFVariableExamenNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTXTFValorReferencia = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JTXTFVariableExamenMetodo = new javax.swing.JTextField();
        JLBLContadorNombreVariable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLBLContadorValorReferencia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLContadorMetodo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        JCMBXTipoVariable = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        JSPNValorMinimo = new javax.swing.JSpinner();
        JSPNValorMaximo = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Variable de Examen");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Variable de Examen"));

        jLabel1.setText("NOMBRE DE LA VARIABLE:");

        JTXTFVariableExamenNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFVariableExamenNombreFocusGained(evt);
            }
        });
        JTXTFVariableExamenNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFVariableExamenNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFVariableExamenNombreKeyTyped(evt);
            }
        });
        JTXTFVariableExamenNombre.setTransferHandler(null);

        jLabel3.setText("VALOR DE REFERENCIA:");

        JTXTFValorReferencia.setTransferHandler(null);
        JTXTFValorReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFValorReferenciaFocusGained(evt);
            }
        });
        JTXTFValorReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFValorReferenciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFValorReferenciaKeyTyped(evt);
            }
        });
        JTXTFValorReferencia.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jLabel5.setText("METODO:");

        JTXTFVariableExamenMetodo.setTransferHandler(null);
        JTXTFVariableExamenMetodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFVariableExamenMetodoFocusGained(evt);
            }
        });
        JTXTFVariableExamenMetodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFVariableExamenMetodoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFVariableExamenMetodoKeyTyped(evt);
            }
        });
        JTXTFVariableExamenMetodo.setTransferHandler(null);

        JLBLContadorNombreVariable.setText("0");

        jLabel6.setText("/50");

        JLBLContadorValorReferencia.setText("0");

        jLabel8.setText("/150");

        JLBLContadorMetodo.setText("0");

        jLabel9.setText("/50");

        jLabel4.setText("TIPO:");

        JCMBXTipoVariable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEXTO", "NUMERICO" }));
        JCMBXTipoVariable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXTipoVariableItemStateChanged(evt);
            }
        });

        jLabel7.setText("VALOR MINIMO:");

        JSPNValorMinimo.setEnabled(false);

        JSPNValorMaximo.setEnabled(false);

        jLabel10.setText("VALOR MAXIMO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFVariableExamenNombre)
                    .addComponent(JTXTFValorReferencia)
                    .addComponent(JTXTFVariableExamenMetodo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorMetodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreVariable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorValorReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jSeparator1)
                    .addComponent(JCMBXTipoVariable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JSPNValorMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSPNValorMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(JLBLContadorNombreVariable))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFVariableExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JLBLContadorValorReferencia))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFValorReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(JLBLContadorMetodo))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFVariableExamenMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXTipoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSPNValorMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPNValorMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (variableExamen == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFVariableExamenNombre.setText(variableExamen.getVariableExamenNombre());
                JTXTFValorReferencia.setText(variableExamen.getVariableExamenValorReferencia());
                JTXTFVariableExamenMetodo.setText(variableExamen.getVariableExamenMetodo());
                JCMBXTipoVariable.setSelectedIndex(variableExamen.getVariableTipoVariable().equals("TEXTO") ? 0 : 1);
                JSPNValorMinimo.setValue(variableExamen.getVariableValorMinimo() == null ? 0 : variableExamen.getVariableValorMinimo());
                JSPNValorMaximo.setValue(variableExamen.getVariableValorMaximo() == null ? 0 : variableExamen.getVariableValorMaximo());

                JLBLContadorNombreVariable.setText(String.valueOf(JTXTFVariableExamenNombre.getText().length()));
                JLBLContadorValorReferencia.setText(String.valueOf(JTXTFValorReferencia.getText().length()));
                JLBLContadorMetodo.setText(String.valueOf(JTXTFVariableExamenMetodo.getText().length()));
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFVariableExamenNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFVariableExamenNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFVariableExamenNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFVariableExamenNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenNombreKeyReleased
        JLBLContadorNombreVariable.setText(String.valueOf(JTXTFVariableExamenNombre.getText().length()));
    }//GEN-LAST:event_JTXTFVariableExamenNombreKeyReleased

    private void JTXTFValorReferenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFValorReferenciaKeyReleased
        JLBLContadorValorReferencia.setText(String.valueOf(JTXTFValorReferencia.getText().length()));
    }//GEN-LAST:event_JTXTFValorReferenciaKeyReleased

    private void JTXTFVariableExamenMetodoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenMetodoKeyReleased
        JLBLContadorMetodo.setText(String.valueOf(JTXTFVariableExamenMetodo.getText().length()));
    }//GEN-LAST:event_JTXTFVariableExamenMetodoKeyReleased

    private void JTXTFValorReferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFValorReferenciaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-:%.,/<> ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFValorReferencia.getText().length() >= 150) {
            evt.consume();
        } else {
            evt.setKeyChar(evt.getKeyChar());
        }
    }//GEN-LAST:event_JTXTFValorReferenciaKeyTyped

    private void JTXTFVariableExamenMetodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenMetodoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-:%.,()/ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFVariableExamenMetodo.getText().length() >= 50) {
            evt.consume();
        } else {
            evt.setKeyChar(evt.getKeyChar());
        }
    }//GEN-LAST:event_JTXTFVariableExamenMetodoKeyTyped

    private void JCMBXTipoVariableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXTipoVariableItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            switch (JCMBXTipoVariable.getSelectedIndex()) {
                case 0:
                    JSPNValorMinimo.setEnabled(false);
                    JSPNValorMaximo.setEnabled(false);
                    break;

                case 1:
                    JSPNValorMinimo.setEnabled(true);
                    JSPNValorMaximo.setEnabled(true);
                    break;
            }
        }
    }//GEN-LAST:event_JCMBXTipoVariableItemStateChanged

    private void JTXTFVariableExamenNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenNombreFocusGained
        JTXTFVariableExamenNombre.selectAll();
    }//GEN-LAST:event_JTXTFVariableExamenNombreFocusGained

    private void JTXTFValorReferenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFValorReferenciaFocusGained
        JTXTFValorReferencia.selectAll();
    }//GEN-LAST:event_JTXTFValorReferenciaFocusGained

    private void JTXTFVariableExamenMetodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenMetodoFocusGained
        JTXTFVariableExamenMetodo.selectAll();
    }//GEN-LAST:event_JTXTFVariableExamenMetodoFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarVariableExamen dialog = new ModificarVariableExamen(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNGuardar;
    private javax.swing.JComboBox<String> JCMBXTipoVariable;
    private javax.swing.JLabel JLBLContadorMetodo;
    private javax.swing.JLabel JLBLContadorNombreVariable;
    private javax.swing.JLabel JLBLContadorValorReferencia;
    private javax.swing.JSpinner JSPNValorMaximo;
    private javax.swing.JSpinner JSPNValorMinimo;
    private javax.swing.JTextField JTXTFValorReferencia;
    private javax.swing.JTextField JTXTFVariableExamenMetodo;
    private javax.swing.JTextField JTXTFVariableExamenNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            try {
                if (JTXTFVariableExamenNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa un nombre para la variable.", "SIET", JOptionPane.INFORMATION_MESSAGE);
                } else if (JCMBXTipoVariable.getSelectedIndex() < 0 && JCMBXTipoVariable.getSelectedIndex() > 1) {
                    JOptionPane.showMessageDialog(null, "Selecciona el tipo de variable.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final String variableExamenNombre = JTXTFVariableExamenNombre.getText();
                    final String variableExamenValorReferencia = JTXTFValorReferencia.getText();
                    final String variableExamenMetodo = JTXTFVariableExamenMetodo.getText();
                    final String variableTipoVariable = JCMBXTipoVariable.getSelectedIndex() == 0 ? "TEXTO" : "NUMERICO";

                    variableExamen.setVariableExamenNombre(variableExamenNombre);
                    variableExamen.setVariableExamenValorReferencia(variableExamenValorReferencia);
                    variableExamen.setVariableExamenMetodo(variableExamenMetodo);
                    variableExamen.setVariableTipoVariable(variableTipoVariable);

                    if (variableTipoVariable.equals("TEXTO")) {
                        variableExamen.setVariableValorMinimo(null);
                        variableExamen.setVariableValorMaximo(null);
                        presenterGestionVariablesExamen.modificarVariableExamen(variableExamen);
                    } else {
                        final int variableValorMinimo = Integer.valueOf(String.valueOf(JSPNValorMinimo.getValue()));
                        final int variableValorMaximo = Integer.valueOf(String.valueOf(JSPNValorMaximo.getValue()));
                        variableExamen.setVariableValorMinimo(variableValorMinimo);
                        variableExamen.setVariableValorMaximo(variableValorMaximo);
                        presenterGestionVariablesExamen.modificarVariableExamen(variableExamen);
                    }
                }
            } catch (final HeadlessException | NumberFormatException exception) {
                System.err.println("Error: " + exception.getMessage());
                JOptionPane.showMessageDialog(null, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    @Override
    public void variableExamenExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIER", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIER", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void variableExamenModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIER", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIER", JOptionPane.ERROR_MESSAGE);
    }
}

package View.GestionExamenes;

import Model.POJO.GrupoVariables;
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
public class CrearVariable extends javax.swing.JDialog implements PresenterGestionVariablesExamen.CallBackVerificarExistenciaVariableExamen, PresenterGestionVariablesExamen.CallBackCrearVariableExamen {

    private final PresenterGestionVariablesExamen presenterGestionVariablesExamen;
    private GrupoVariables grupoVariables;

    public CrearVariable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionVariablesExamen = new PresenterGestionVariablesExamen();
        presenterGestionVariablesExamen.setCallBackCrearVariableExamen(this);
        presenterGestionVariablesExamen.setCallBackVerificarExistenciaVariableExamen(this);
        JTXTFVariableNombre.addActionListener(action);
        JTXTFValorReferencia.addActionListener(action);
        JTXTFVariableExamenMetodo.addActionListener(action);
        JBTNCrear.addActionListener(action);
    }

    public void setGrupoVariables(GrupoVariables grupoVariables) {
        this.grupoVariables = grupoVariables;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLGrupoVariablesNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTXTFVariableNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTXTFValorReferencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTXTFVariableExamenMetodo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JLBLContadorNombreVariable = new javax.swing.JLabel();
        JLBLContadorValorReferencia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLContadorMetodo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNCrear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JCMBXTipoVariable = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JSPNValorMinimo = new javax.swing.JSpinner();
        JSPNValorMaximo = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Crear Variable");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Grupo de Variables"));

        jLabel1.setText("NOMBRE DEL GRUPO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLBLGrupoVariablesNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLBLGrupoVariablesNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Variable"));

        jLabel2.setText("NOMBRE DE LA VARIABLE:");

        JTXTFVariableNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFVariableNombreFocusGained(evt);
            }
        });
        JTXTFVariableNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFVariableNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFVariableNombreKeyTyped(evt);
            }
        });
        JTXTFVariableNombre.setTransferHandler(null);

        jLabel4.setText("VALOR DE REFERENCIA:");

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

        jLabel6.setText("/50");

        JLBLContadorNombreVariable.setText("0");

        JLBLContadorValorReferencia.setText("0");

        jLabel8.setText("/150");

        JLBLContadorMetodo.setText("0");

        jLabel9.setText("/50");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFVariableNombre)
                    .addComponent(JTXTFValorReferencia)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorMetodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(JTXTFVariableExamenMetodo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreVariable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorValorReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(JLBLContadorNombreVariable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFVariableNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JLBLContadorValorReferencia))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFValorReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(JLBLContadorMetodo))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFVariableExamenMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNCrear.setText("CREAR");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Variable"));

        jLabel3.setText("TIPO:");

        JCMBXTipoVariable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEXTO", "NUMERICO" }));
        JCMBXTipoVariable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXTipoVariableItemStateChanged(evt);
            }
        });

        jLabel7.setText("VALOR MINIMO:");

        jLabel10.setText("VALOR MAXIMO:");

        JSPNValorMinimo.setEnabled(false);

        JSPNValorMaximo.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCMBXTipoVariable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JSPNValorMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSPNValorMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXTipoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSPNValorMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPNValorMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNCrear))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNCrear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (grupoVariables == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLGrupoVariablesNombre.setText(grupoVariables.getGrupoVariableNombre());
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFVariableNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFVariableNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFVariableNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFVariableNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFVariableNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFVariableNombreKeyReleased
        JLBLContadorNombreVariable.setText(String.valueOf(JTXTFVariableNombre.getText().length()));
    }//GEN-LAST:event_JTXTFVariableNombreKeyReleased

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

    private void JTXTFVariableNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFVariableNombreFocusGained
        JTXTFVariableNombre.selectAll();
    }//GEN-LAST:event_JTXTFVariableNombreFocusGained

    private void JTXTFValorReferenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFValorReferenciaFocusGained
        JTXTFValorReferencia.selectAll();
    }//GEN-LAST:event_JTXTFValorReferenciaFocusGained

    private void JTXTFVariableExamenMetodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFVariableExamenMetodoFocusGained
        JTXTFVariableExamenMetodo.selectAll();
    }//GEN-LAST:event_JTXTFVariableExamenMetodoFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CrearVariable dialog = new CrearVariable(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCrear;
    private javax.swing.JComboBox<String> JCMBXTipoVariable;
    private javax.swing.JLabel JLBLContadorMetodo;
    private javax.swing.JLabel JLBLContadorNombreVariable;
    private javax.swing.JLabel JLBLContadorValorReferencia;
    private javax.swing.JLabel JLBLGrupoVariablesNombre;
    private javax.swing.JSpinner JSPNValorMaximo;
    private javax.swing.JSpinner JSPNValorMinimo;
    private javax.swing.JTextField JTXTFValorReferencia;
    private javax.swing.JTextField JTXTFVariableExamenMetodo;
    private javax.swing.JTextField JTXTFVariableNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            try {
                if (JTXTFVariableNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa un nombre para la variable.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (JCMBXTipoVariable.getSelectedIndex() < 0 && JCMBXTipoVariable.getSelectedIndex() > 1) {
                    JOptionPane.showMessageDialog(null, "Selecciona el tipo de variable.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final String variableExamenNombre = JTXTFVariableNombre.getText();
                    final String variableExamenValorReferencia = JTXTFValorReferencia.getText();
                    final String variableExamenMetodo = JTXTFVariableExamenMetodo.getText();
                    final String variableTipoVariable = JCMBXTipoVariable.getSelectedIndex() == 0 ? "TEXTO" : "NUMERICO";

                    if (variableTipoVariable.equals("TEXTO")) {
                        presenterGestionVariablesExamen.crearVariableExamen(new VariableExamen(grupoVariables, variableExamenNombre, variableExamenValorReferencia, variableExamenMetodo, variableTipoVariable, null, null, 1));
                    } else {
                        final int variableValorMinimo = Integer.valueOf(String.valueOf(JSPNValorMinimo.getValue()));
                        final int variableValorMaximo = Integer.valueOf(String.valueOf(JSPNValorMaximo.getValue()));
                        presenterGestionVariablesExamen.crearVariableExamen(new VariableExamen(grupoVariables, variableExamenNombre, variableExamenValorReferencia, variableExamenMetodo, variableTipoVariable, variableValorMinimo, variableValorMaximo, 1));
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
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void variableExamenCreado(final String msg) {
        dispose();
    }

    @Override
    public void errorCrearVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearVariableExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}

package View.GestionEstablecimientos;

import Model.POJO.Establecimiento;
import Presenter.GestionEstablecimiento.PresenterGestionEstablecimiento;
import java.awt.event.ActionEvent;
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
public class RegistrarEstablecimiento extends javax.swing.JDialog implements PresenterGestionEstablecimiento.CallBackVerificarExistenciaEstablecimiento, PresenterGestionEstablecimiento.CallBackRegistrarEstablecimiento {

    private final PresenterGestionEstablecimiento presenterGestionEstablecimiento;

    public RegistrarEstablecimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        presenterGestionEstablecimiento = new PresenterGestionEstablecimiento();
        presenterGestionEstablecimiento.setCallBackVerificarExistenciaEstablecimiento(this);
        presenterGestionEstablecimiento.setCallBackRegistrarEstablecimiento(this);
        JTXTFEstablecimientoNombre.addActionListener(action);
        JBTNRegistrar.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFEstablecimientoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JCMBXEstablecimientoTipo = new javax.swing.JComboBox<>();
        JCMBXEstablecimientoArea = new javax.swing.JComboBox<>();
        JLBLContadorNombreEstablecimiento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Registrar Establecimiento");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Nuevo Establecimiento"));

        jLabel1.setText("NOMBRE:");

        JTXTFEstablecimientoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEstablecimientoNombreFocusGained(evt);
            }
        });
        JTXTFEstablecimientoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEstablecimientoNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEstablecimientoNombreKeyTyped(evt);
            }
        });
        JTXTFEstablecimientoNombre.setTransferHandler(null);

        jLabel2.setText("TIPO:");

        jLabel3.setText("AREA:");

        JCMBXEstablecimientoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PUBLICO", "PRIVADO" }));
        JCMBXEstablecimientoTipo.setSelectedIndex(-1);

        JCMBXEstablecimientoArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "URBANO", "RURAL" }));
        JCMBXEstablecimientoArea.setSelectedIndex(-1);

        JLBLContadorNombreEstablecimiento.setText("0");

        jLabel4.setText("/80");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNRegistrar.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFEstablecimientoNombre)
                    .addComponent(JCMBXEstablecimientoTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCMBXEstablecimientoArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreEstablecimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNRegistrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JLBLContadorNombreEstablecimiento))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFEstablecimientoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXEstablecimientoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXEstablecimientoArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNRegistrar))
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

    private void JTXTFEstablecimientoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEstablecimientoNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEstablecimientoNombre.getText().length() >= 80) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEstablecimientoNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFEstablecimientoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEstablecimientoNombreKeyReleased
        JLBLContadorNombreEstablecimiento.setText(String.valueOf(JTXTFEstablecimientoNombre.getText().length()));
    }//GEN-LAST:event_JTXTFEstablecimientoNombreKeyReleased

    private void JTXTFEstablecimientoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEstablecimientoNombreFocusGained
        JTXTFEstablecimientoNombre.selectAll();
    }//GEN-LAST:event_JTXTFEstablecimientoNombreFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarEstablecimiento dialog = new RegistrarEstablecimiento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNRegistrar;
    private javax.swing.JComboBox<String> JCMBXEstablecimientoArea;
    private javax.swing.JComboBox<String> JCMBXEstablecimientoTipo;
    private javax.swing.JLabel JLBLContadorNombreEstablecimiento;
    private javax.swing.JTextField JTXTFEstablecimientoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String establecimientoNombre = JTXTFEstablecimientoNombre.getText();

            if (establecimientoNombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del establecimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JCMBXEstablecimientoTipo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el tipo del establecimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JCMBXEstablecimientoArea.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el area del establecimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final String establecimientoTipo = JCMBXEstablecimientoTipo.getSelectedItem().toString();
                final String establecimientoArea = JCMBXEstablecimientoArea.getSelectedItem().toString();
                presenterGestionEstablecimiento.registrarEstablecimiento(new Establecimiento(establecimientoNombre, establecimientoTipo, establecimientoArea, 1));
            }
        }
    };

    @Override
    public void establecimientoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaEstablecimiento(String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void establecimientoRegistrado(final String msg) {
        dispose();
    }

    @Override
    public void errorRegistrarEstablecimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoRegistrarEstablecimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
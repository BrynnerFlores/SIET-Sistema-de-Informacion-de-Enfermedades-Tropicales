package View.GestionMuestrasBiologicas;

import Model.POJO.MuestraBiologica;
import Presenter.GestionMuestrasBiologicas.PresenterGestionMuestrasBiologicas;
import java.awt.HeadlessException;
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
public class ModificarMuestraBiologica extends javax.swing.JDialog implements PresenterGestionMuestrasBiologicas.CallBackModificarMuestraBiologica {

    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;
    private MuestraBiologica muestraBiologica;

    public ModificarMuestraBiologica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionMuestrasBiologicas.setCallBackModificarMuestraBiologica(this);
        JTXTFTipoMuestraBiologica.addActionListener(action);
        JBTNModificarMuestraBiologica.addActionListener(action);
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFTipoMuestraBiologica = new javax.swing.JTextField();
        JBTNCancelarModificarMuestraBiologica = new javax.swing.JButton();
        JBTNModificarMuestraBiologica = new javax.swing.JButton();
        JLBLContadorMuestraBiologica = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Muestra Biológica");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Muestra Biológica"));

        jLabel1.setText("MUESTRA BIOLOGICA:");

        JTXTFTipoMuestraBiologica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFTipoMuestraBiologicaFocusGained(evt);
            }
        });
        JTXTFTipoMuestraBiologica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFTipoMuestraBiologicaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFTipoMuestraBiologicaKeyTyped(evt);
            }
        });
        JTXTFTipoMuestraBiologica.setTransferHandler(null);

        JBTNCancelarModificarMuestraBiologica.setText("CANCELAR");
        JBTNCancelarModificarMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarModificarMuestraBiologicaActionPerformed(evt);
            }
        });

        JBTNModificarMuestraBiologica.setText("GUARDAR");

        JLBLContadorMuestraBiologica.setText("0");

        jLabel4.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFTipoMuestraBiologica)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorMuestraBiologica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelarModificarMuestraBiologica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(JBTNModificarMuestraBiologica)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JLBLContadorMuestraBiologica))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTXTFTipoMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelarModificarMuestraBiologica)
                    .addComponent(JBTNModificarMuestraBiologica))
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

    private void JTXTFTipoMuestraBiologicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTipoMuestraBiologicaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFTipoMuestraBiologica.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFTipoMuestraBiologicaKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (muestraBiologica == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFTipoMuestraBiologica.setText(muestraBiologica.getMuestraBiologicaTipo());
                JLBLContadorMuestraBiologica.setText(String.valueOf(JTXTFTipoMuestraBiologica.getText().length()));
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JBTNCancelarModificarMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarModificarMuestraBiologicaActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarModificarMuestraBiologicaActionPerformed

    private void JTXTFTipoMuestraBiologicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTipoMuestraBiologicaKeyReleased
        JLBLContadorMuestraBiologica.setText(String.valueOf(JTXTFTipoMuestraBiologica.getText().length()));
    }//GEN-LAST:event_JTXTFTipoMuestraBiologicaKeyReleased

    private void JTXTFTipoMuestraBiologicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFTipoMuestraBiologicaFocusGained
        JTXTFTipoMuestraBiologica.selectAll();
    }//GEN-LAST:event_JTXTFTipoMuestraBiologicaFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarMuestraBiologica dialog = new ModificarMuestraBiologica(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCancelarModificarMuestraBiologica;
    private javax.swing.JButton JBTNModificarMuestraBiologica;
    private javax.swing.JLabel JLBLContadorMuestraBiologica;
    private javax.swing.JTextField JTXTFTipoMuestraBiologica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String muestra_biologica_tipo = JTXTFTipoMuestraBiologica.getText();

            if (muestra_biologica_tipo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa el tipo para la muestra biológica.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else {
                muestraBiologica.setMuestraBiologicaTipo(muestra_biologica_tipo);
                presenterGestionMuestrasBiologicas.modificarMuestraBiologica(muestraBiologica);
            }
        }
    };

    @Override
    public void muestraBiologicaModificada(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarMuestraBiologica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarMuestraBiologica(String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
package View.GestionMuestrasBiologicas;

import Model.POJO.MuestraBiologica;
import Presenter.GestionMuestrasBiologicas.PresenterGestionMuestrasBiologicas;
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
public class CrearMuestraBiologica extends javax.swing.JDialog implements PresenterGestionMuestrasBiologicas.CallBackCrearMuestraBiologica{

    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;
    
    public CrearMuestraBiologica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionMuestrasBiologicas.setCallBackCrearMuestraBiologica(this);
        JTXTFNombreMuestraBiologica.addActionListener(action);
        JBTNCrearMuestraBiologica.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFNombreMuestraBiologica = new javax.swing.JTextField();
        JBTNCancelarCrearMuestraBiologica = new javax.swing.JButton();
        JBTNCrearMuestraBiologica = new javax.swing.JButton();
        JLBLContadorMuestraBiologica = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Crear Muestra Biológica");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Muestra Biológica"));

        jLabel1.setText("MUESTRA BIOLOGICA:");

        JTXTFNombreMuestraBiologica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNombreMuestraBiologicaFocusGained(evt);
            }
        });
        JTXTFNombreMuestraBiologica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFNombreMuestraBiologicaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFNombreMuestraBiologicaKeyTyped(evt);
            }
        });
        JTXTFNombreMuestraBiologica.setTransferHandler(null);

        JBTNCancelarCrearMuestraBiologica.setText("CANCELAR");
        JBTNCancelarCrearMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarCrearMuestraBiologicaActionPerformed(evt);
            }
        });

        JBTNCrearMuestraBiologica.setText("CREAR");

        JLBLContadorMuestraBiologica.setText("0");

        jLabel4.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFNombreMuestraBiologica)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorMuestraBiologica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelarCrearMuestraBiologica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(JBTNCrearMuestraBiologica)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombreMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelarCrearMuestraBiologica)
                    .addComponent(JBTNCrearMuestraBiologica))
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

    private void JTXTFNombreMuestraBiologicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombreMuestraBiologicaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFNombreMuestraBiologica.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFNombreMuestraBiologicaKeyTyped

    private void JBTNCancelarCrearMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarCrearMuestraBiologicaActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarCrearMuestraBiologicaActionPerformed

    private void JTXTFNombreMuestraBiologicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombreMuestraBiologicaKeyReleased
        JLBLContadorMuestraBiologica.setText(String.valueOf(JTXTFNombreMuestraBiologica.getText().length()));
    }//GEN-LAST:event_JTXTFNombreMuestraBiologicaKeyReleased

    private void JTXTFNombreMuestraBiologicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombreMuestraBiologicaFocusGained
        JTXTFNombreMuestraBiologica.selectAll();
    }//GEN-LAST:event_JTXTFNombreMuestraBiologicaFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CrearMuestraBiologica dialog = new CrearMuestraBiologica(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    
    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            final String muestra_biologica_nombre = JTXTFNombreMuestraBiologica.getText();
        
            if (muestra_biologica_nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa un nombre para la nueva muestra biológica.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else {
                final MuestraBiologica muestraBiologica = new MuestraBiologica(muestra_biologica_nombre.toUpperCase(), 1);
                presenterGestionMuestrasBiologicas.crearMuestraBiologica(muestraBiologica);
            }
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNCancelarCrearMuestraBiologica;
    private javax.swing.JButton JBTNCrearMuestraBiologica;
    private javax.swing.JLabel JLBLContadorMuestraBiologica;
    private javax.swing.JTextField JTXTFNombreMuestraBiologica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void muestraBiologicaCreada(final String msg) {
        dispose();
    }

    @Override
    public void errorCrearMuestraBiologica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearMuestraBiologica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
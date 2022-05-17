package View.GestionMuestrasBiologicas;

import Model.POJO.AspectoCalidad;
import Presenter.GestionMuestrasBiologicas.PresenterGestionAspectos;
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
public class ModificarAspecto extends javax.swing.JDialog implements PresenterGestionAspectos.CallBackVerificarExistencia, PresenterGestionAspectos.CallBackModificarAspecto {

    private final PresenterGestionAspectos presenterGestionAspectos;
    private AspectoCalidad aspecto;

    public ModificarAspecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionAspectos = new PresenterGestionAspectos();
        presenterGestionAspectos.setCallBackVerificarExistencia(this);
        presenterGestionAspectos.setCallBackModificarAspecto(this);
        JTXTFAspectoCalidad.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setAspecto(AspectoCalidad aspecto) {
        this.aspecto = aspecto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFAspectoCalidad = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        JLBLContadorAspecto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Aspecto/Calidad");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aspecto/Calidad de la Muestra Biológica"));

        jLabel1.setText("ASPECTO/CALIDAD:");

        JTXTFAspectoCalidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFAspectoCalidadFocusGained(evt);
            }
        });
        JTXTFAspectoCalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFAspectoCalidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFAspectoCalidadKeyTyped(evt);
            }
        });
        JTXTFAspectoCalidad.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        JLBLContadorAspecto.setText("0");

        jLabel4.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFAspectoCalidad)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorAspecto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JLBLContadorAspecto))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFAspectoCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if (aspecto == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFAspectoCalidad.setText(aspecto.getAspectoCalidad());
                JLBLContadorAspecto.setText(String.valueOf(JTXTFAspectoCalidad.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFAspectoCalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFAspectoCalidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFAspectoCalidad.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFAspectoCalidadKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFAspectoCalidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFAspectoCalidadKeyReleased
        JLBLContadorAspecto.setText(String.valueOf(JTXTFAspectoCalidad.getText().length()));
    }//GEN-LAST:event_JTXTFAspectoCalidadKeyReleased

    private void JTXTFAspectoCalidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFAspectoCalidadFocusGained
        JTXTFAspectoCalidad.selectAll();
    }//GEN-LAST:event_JTXTFAspectoCalidadFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarAspecto dialog = new ModificarAspecto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLContadorAspecto;
    private javax.swing.JTextField JTXTFAspectoCalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String aspectoCalidad = JTXTFAspectoCalidad.getText();

            if (aspectoCalidad.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa el tipo de aspecto.");
            } else if (aspectoCalidad.equals(aspecto.getAspectoCalidad())) {
                dispose();
            } else {
                aspecto.setAspectoCalidad(aspectoCalidad);
                presenterGestionAspectos.modificarAspecto(aspecto);
            }
        }
    };

    @Override
    public void aspectoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistencia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void aspectoModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarAspecto(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarAspecto(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
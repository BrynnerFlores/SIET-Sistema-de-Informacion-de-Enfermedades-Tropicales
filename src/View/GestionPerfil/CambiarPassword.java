package View.GestionPerfil;

import Model.POJO.Cuenta;
import Presenter.GestionPerfil.PresenterGestionPerfil;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author brynner
 */
public class CambiarPassword extends javax.swing.JDialog implements PresenterGestionPerfil.CallBackVerificarPasswordValido, PresenterGestionPerfil.CallBackCambiarPassword {
    
    private final PresenterGestionPerfil presenterGestionPerfil;
    private Cuenta cuenta;
    
    public CambiarPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        presenterGestionPerfil = new PresenterGestionPerfil();
        presenterGestionPerfil.setCallBackVerificarPasswordValido(this);
        presenterGestionPerfil.setCallBackCambiarPassword(this);
        
        JPSWFPasswordActual.addActionListener(action);
        JPSWFNuevoPassword.addActionListener(action);
        JPSWFRepetirPassword.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPSWFPasswordActual = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        JPSWFNuevoPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        JPSWFRepetirPassword = new javax.swing.JPasswordField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Cambiar Contraseña");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Contraseña"));

        jLabel1.setText("Ingresa tu contraseña actual:");

        JPSWFPasswordActual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPSWFPasswordActualFocusGained(evt);
            }
        });

        jLabel2.setText("Ingresa tu nueva contraseña:");

        JPSWFNuevoPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPSWFNuevoPasswordFocusGained(evt);
            }
        });

        jLabel3.setText("Repite tu nueva contraseña:");

        JPSWFRepetirPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPSWFRepetirPasswordFocusGained(evt);
            }
        });

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPSWFPasswordActual)
                    .addComponent(JPSWFNuevoPassword)
                    .addComponent(JPSWFRepetirPassword)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPSWFPasswordActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPSWFNuevoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPSWFRepetirPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if (cuenta == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JPSWFPasswordActualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPSWFPasswordActualFocusGained
        JPSWFPasswordActual.selectAll();
    }//GEN-LAST:event_JPSWFPasswordActualFocusGained

    private void JPSWFNuevoPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPSWFNuevoPasswordFocusGained
        JPSWFNuevoPassword.selectAll();
    }//GEN-LAST:event_JPSWFNuevoPasswordFocusGained

    private void JPSWFRepetirPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPSWFRepetirPasswordFocusGained
        JPSWFRepetirPassword.selectAll();
    }//GEN-LAST:event_JPSWFRepetirPasswordFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CambiarPassword dialog = new CambiarPassword(new javax.swing.JFrame(), true);
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
    private javax.swing.JPasswordField JPSWFNuevoPassword;
    private javax.swing.JPasswordField JPSWFPasswordActual;
    private javax.swing.JPasswordField JPSWFRepetirPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            final String passwordActual = new String(JPSWFPasswordActual.getPassword());
            final String nuevoPassword = new String(JPSWFNuevoPassword.getPassword());
            final String repetirPassword = new String(JPSWFRepetirPassword.getPassword());
            
            if (passwordActual.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu contraseña actual.", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSWFPasswordActual.requestFocus();
            } else if (nuevoPassword.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu nueva contraseña.\nLa contraseña no puede ser vacio.", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSWFNuevoPassword.requestFocus();
            } else if (repetirPassword.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Repite tu nueva contraseña.\nLa contraseña no puede ser vacio.", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSWFRepetirPassword.requestFocus();
            } else if (!nuevoPassword.equals(repetirPassword)) {
                JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden. Vuelve a ingresarlos", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSWFRepetirPassword.requestFocus();
            } else {
                cuenta.setCuentaClave(passwordActual);
                presenterGestionPerfil.cambiarPassword(cuenta, nuevoPassword);
            }
        }
    };
    
    @Override
    public void passwordNoValido(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarPasswordValido(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void passwordCambiado(final String msg) {
        dispose();
    }

    @Override
    public void errorCambiarPassword(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCambiarPassword(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
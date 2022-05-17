package View.Acceso;

import Presenter.Acceso.PresenterIniciarSesion;
import View.Configuraciones.ConexionBaseDatos;
import View.Principal;
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
public class IniciarSesion extends javax.swing.JFrame implements PresenterIniciarSesion.CallBackIniciarSesion, PresenterIniciarSesion.CallBackGuardarCuenta {

    private final PresenterIniciarSesion presenterIniciarSesion;
    
    public IniciarSesion() {
        initComponents();
        
        presenterIniciarSesion = new PresenterIniciarSesion();
        presenterIniciarSesion.setCallBackIniciarSesion(this);
        presenterIniciarSesion.setCallBackGuardarCuenta(this);
        JTXTFCedulaIdentidad.addActionListener(action);
        JPSFPassword.addActionListener(action);
        JBTNInicarSesion.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFCedulaIdentidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JCHBXMantenerSesionIniciada = new javax.swing.JCheckBox();
        JCHBXMostrarPassword = new javax.swing.JCheckBox();
        JBTNInicarSesion = new javax.swing.JButton();
        JBTNRegistrarse = new javax.swing.JButton();
        JPSFPassword = new javax.swing.JPasswordField();
        JLBLContadorCedulaIdentidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLContadorPassword = new javax.swing.JLabel();
        JBTNConexionBaseDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso al Sistema - Iniciar Sesión");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Credenciales de Usuario"));

        jLabel1.setText("C.I:");

        JTXTFCedulaIdentidad.setToolTipText("");
        JTXTFCedulaIdentidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFCedulaIdentidadFocusGained(evt);
            }
        });
        JTXTFCedulaIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFCedulaIdentidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFCedulaIdentidadKeyTyped(evt);
            }
        });
        JTXTFCedulaIdentidad.setTransferHandler(null);

        jLabel2.setText("Contraseña:");

        JCHBXMantenerSesionIniciada.setText("Mantener sesion iniciada");
        JCHBXMantenerSesionIniciada.setActionCommand("Mantener sesión iniciada");

        JCHBXMostrarPassword.setText("Mostrar contraseña");
        JCHBXMostrarPassword.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCHBXMostrarPasswordItemStateChanged(evt);
            }
        });

        JBTNInicarSesion.setText("INICIAR SESION");

        JBTNRegistrarse.setText("REGISTRARSE");
        JBTNRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNRegistrarseActionPerformed(evt);
            }
        });

        JPSFPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JPSFPasswordFocusLost(evt);
            }
        });
        JPSFPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JPSFPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPSFPasswordKeyTyped(evt);
            }
        });
        JPSFPassword.setTransferHandler(null);

        JLBLContadorCedulaIdentidad.setText("0");

        jLabel4.setText("/20");

        jLabel3.setText("/50");

        JLBLContadorPassword.setText("0");

        JBTNConexionBaseDatos.setText("CONEXION A BASE DE DATOS");
        JBTNConexionBaseDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNConexionBaseDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBTNConexionBaseDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPSFPassword)
                    .addComponent(JTXTFCedulaIdentidad)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JCHBXMantenerSesionIniciada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(JCHBXMostrarPassword))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNRegistrarse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNInicarSesion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorCedulaIdentidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLBLContadorCedulaIdentidad)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(JLBLContadorPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPSFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCHBXMostrarPassword)
                    .addComponent(JCHBXMantenerSesionIniciada))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNInicarSesion)
                    .addComponent(JBTNRegistrarse))
                .addGap(18, 18, 18)
                .addComponent(JBTNConexionBaseDatos)
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

    private void JCHBXMostrarPasswordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCHBXMostrarPasswordItemStateChanged
        if (JCHBXMostrarPassword.isSelected()) {
            JPSFPassword.setEchoChar((char) 0);
        } else {
            JPSFPassword.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_JCHBXMostrarPasswordItemStateChanged

    private void JBTNRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNRegistrarseActionPerformed
        final CrearCuenta registrarse = new CrearCuenta();
        registrarse.setVisible(true);
        dispose();
    }//GEN-LAST:event_JBTNRegistrarseActionPerformed

    private void JTXTFCedulaIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9- ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFCedulaIdentidad.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyTyped

    private void JTXTFCedulaIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyReleased
        JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyReleased

    private void JPSFPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPSFPasswordKeyTyped
        if (new String(JPSFPassword.getPassword()).length() >= 50) {
            evt.consume();
        } else {
            evt.setKeyChar(evt.getKeyChar());
        }
    }//GEN-LAST:event_JPSFPasswordKeyTyped

    private void JPSFPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPSFPasswordKeyReleased
        JLBLContadorPassword.setText(String.valueOf(JPSFPassword.getText().length()));
    }//GEN-LAST:event_JPSFPasswordKeyReleased

    private void JBTNConexionBaseDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNConexionBaseDatosActionPerformed
        final ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos(null, true);
        conexionBaseDatos.setVisible(true);
    }//GEN-LAST:event_JBTNConexionBaseDatosActionPerformed

    private void JTXTFCedulaIdentidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadFocusGained
        JTXTFCedulaIdentidad.selectAll();
    }//GEN-LAST:event_JTXTFCedulaIdentidadFocusGained

    private void JPSFPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPSFPasswordFocusLost
        JPSFPassword.selectAll();
    }//GEN-LAST:event_JPSFPasswordFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new IniciarSesion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNConexionBaseDatos;
    private javax.swing.JButton JBTNInicarSesion;
    private javax.swing.JButton JBTNRegistrarse;
    private javax.swing.JCheckBox JCHBXMantenerSesionIniciada;
    private javax.swing.JCheckBox JCHBXMostrarPassword;
    private javax.swing.JLabel JLBLContadorCedulaIdentidad;
    private javax.swing.JLabel JLBLContadorPassword;
    private javax.swing.JPasswordField JPSFPassword;
    private javax.swing.JTextField JTXTFCedulaIdentidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String ci = JTXTFCedulaIdentidad.getText();
            final String password = new String(JPSFPassword.getPassword());

            if (ci.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa tu cedula de identidad.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa tu contraseña.", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSFPassword.requestFocus();
            } else {
                if (JCHBXMantenerSesionIniciada.isSelected()) {
                    presenterIniciarSesion.iniciarSesion(ci, password, true);
                } else {
                    presenterIniciarSesion.iniciarSesion(ci, password, false);
                }
            }
        }
    };

    @Override
    public void credencialesCorrectos() {
        final Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }

    @Override
    public void errorIniciarSesion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorGuardarCuenta(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void errorDesconocido(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
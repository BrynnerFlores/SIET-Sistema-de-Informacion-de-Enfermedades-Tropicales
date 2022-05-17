package View.Acceso;

import Model.POJO.PersonalTecnico;
import Model.POJO.Cuenta;
import Model.POJO.Persona;
import Presenter.Acceso.PresenterCrearCuenta;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Brynner
 */
public class CrearCuenta extends javax.swing.JFrame implements PresenterCrearCuenta.CallBackVerificarExistencia, PresenterCrearCuenta.CallBackCrearCuenta {

    private final PresenterCrearCuenta presenterCrearCuenta;

    public CrearCuenta() {
        initComponents();

        presenterCrearCuenta = new PresenterCrearCuenta();
        presenterCrearCuenta.setCallBackVerificarExistencia(this);
        presenterCrearCuenta.setCallBackCrearCuenta(this);

        JTXTFCedulaIdentidad.addActionListener(action);
        JTXTFApellidos.addActionListener(action);
        JTXTFNombres.addActionListener(action);
        JPSWFPassword.addActionListener(action);
        JPSWFRepetirPassword.addActionListener(action);
        JBTNRegistrarse.addActionListener(action);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFCedulaIdentidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTXTFApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTXTFNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCMBXSexo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLBLContadorCedulaIdentidad = new javax.swing.JLabel();
        JLBLContadorApellidos = new javax.swing.JLabel();
        JLBLContadorNombre = new javax.swing.JLabel();
        JCMBXProfesion = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JPSWFPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        JPSWFRepetirPassword = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLBLContadorPassword = new javax.swing.JLabel();
        JLBLContadorRepetirPassword = new javax.swing.JLabel();
        JBTNInicarSesion = new javax.swing.JButton();
        JBTNRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso al Sistema - Registrarse");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresa tus datos"));
        jPanel1.setPreferredSize(new java.awt.Dimension(365, 230));

        jLabel1.setText("C.I:");

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

        jLabel2.setText("APELLIDO(S):");
        jLabel2.setToolTipText("");

        JTXTFApellidos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JTXTFApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFApellidosFocusGained(evt);
            }
        });
        JTXTFApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFApellidosKeyTyped(evt);
            }
        });
        JTXTFApellidos.setTransferHandler(null);

        jLabel3.setText("NOMBRE(S):");

        JTXTFNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNombresFocusGained(evt);
            }
        });
        JTXTFNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFNombresKeyTyped(evt);
            }
        });
        JTXTFNombres.setTransferHandler(null);

        jLabel4.setText("SEXO:");

        JCMBXSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        JCMBXSexo.setSelectedIndex(-1);

        jLabel7.setText("PROFESION:");

        jLabel8.setText("/20");
        jLabel8.setToolTipText("");

        jLabel9.setText("/50");

        jLabel10.setText("/50");

        JLBLContadorCedulaIdentidad.setText("0");

        JLBLContadorApellidos.setText("0");

        JLBLContadorNombre.setText("0");

        JCMBXProfesion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIOQUIMICO(A)", "TECNICO EN LABORATORIO" }));
        JCMBXProfesion.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JCMBXProfesion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTXTFCedulaIdentidad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFNombres, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCMBXSexo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorCedulaIdentidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addComponent(JLBLContadorApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(JLBLContadorCedulaIdentidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(JLBLContadorApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(JLBLContadorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Define una contraseña para tu cuenta"));

        jLabel5.setText("CONTRASEÑA:");

        JPSWFPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPSWFPasswordFocusGained(evt);
            }
        });
        JPSWFPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JPSWFPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPSWFPasswordKeyTyped(evt);
            }
        });
        JPSWFPassword.setTransferHandler(null);

        jLabel6.setText("REPETIR CONTRASEÑA:");

        JPSWFRepetirPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPSWFRepetirPasswordFocusGained(evt);
            }
        });
        JPSWFRepetirPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JPSWFRepetirPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPSWFRepetirPasswordKeyTyped(evt);
            }
        });
        JPSWFRepetirPassword.setTransferHandler(null);

        jLabel12.setText("/50");

        jLabel13.setText("/50");

        JLBLContadorPassword.setText("0");

        JLBLContadorRepetirPassword.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPSWFPassword)
                    .addComponent(JPSWFRepetirPassword)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorRepetirPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(JLBLContadorPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPSWFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(JLBLContadorRepetirPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPSWFRepetirPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JBTNInicarSesion.setText("INICIAR SESION");
        JBTNInicarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNInicarSesionActionPerformed(evt);
            }
        });

        JBTNRegistrarse.setText("REGISTRARSE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNInicarSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(JBTNRegistrarse))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNInicarSesion)
                    .addComponent(JBTNRegistrarse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBTNInicarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNInicarSesionActionPerformed
        final IniciarSesion iniciarSesion = new IniciarSesion();
        iniciarSesion.setVisible(true);
        dispose();
    }//GEN-LAST:event_JBTNInicarSesionActionPerformed

    private void JTXTFApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFApellidosKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFApellidos.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFApellidosKeyTyped

    private void JTXTFNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombresKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFNombres.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFNombresKeyTyped

    private void JTXTFCedulaIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFCedulaIdentidad.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyTyped

    private void JPSWFPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPSWFPasswordKeyTyped
        if (new String(JPSWFPassword.getPassword()).length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_JPSWFPasswordKeyTyped

    private void JPSWFRepetirPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPSWFRepetirPasswordKeyTyped
        if (new String(JPSWFRepetirPassword.getPassword()).length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_JPSWFRepetirPasswordKeyTyped

    private void JTXTFCedulaIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyReleased
        JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyReleased

    private void JTXTFApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFApellidosKeyReleased
        JLBLContadorApellidos.setText(String.valueOf(JTXTFApellidos.getText().length()));
    }//GEN-LAST:event_JTXTFApellidosKeyReleased

    private void JTXTFNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombresKeyReleased
        JLBLContadorNombre.setText(String.valueOf(JTXTFNombres.getText().length()));
    }//GEN-LAST:event_JTXTFNombresKeyReleased

    private void JPSWFPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPSWFPasswordKeyReleased
        JLBLContadorPassword.setText(String.valueOf(new String(JPSWFPassword.getPassword()).length()));
    }//GEN-LAST:event_JPSWFPasswordKeyReleased

    private void JPSWFRepetirPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPSWFRepetirPasswordKeyReleased
        JLBLContadorRepetirPassword.setText(String.valueOf(new String(JPSWFRepetirPassword.getPassword()).length()));
    }//GEN-LAST:event_JPSWFRepetirPasswordKeyReleased

    private void JTXTFCedulaIdentidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadFocusGained
        JTXTFCedulaIdentidad.selectAll();
    }//GEN-LAST:event_JTXTFCedulaIdentidadFocusGained

    private void JTXTFApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFApellidosFocusGained
        JTXTFApellidos.selectAll();
    }//GEN-LAST:event_JTXTFApellidosFocusGained

    private void JTXTFNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombresFocusGained
        JTXTFNombres.selectAll();
    }//GEN-LAST:event_JTXTFNombresFocusGained

    private void JPSWFPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPSWFPasswordFocusGained
        JPSWFPassword.selectAll();
    }//GEN-LAST:event_JPSWFPasswordFocusGained

    private void JPSWFRepetirPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPSWFRepetirPasswordFocusGained
        JPSWFRepetirPassword.selectAll();
    }//GEN-LAST:event_JPSWFRepetirPasswordFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CrearCuenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNInicarSesion;
    private javax.swing.JButton JBTNRegistrarse;
    private javax.swing.JComboBox<String> JCMBXProfesion;
    private javax.swing.JComboBox<String> JCMBXSexo;
    private javax.swing.JLabel JLBLContadorApellidos;
    private javax.swing.JLabel JLBLContadorCedulaIdentidad;
    private javax.swing.JLabel JLBLContadorNombre;
    private javax.swing.JLabel JLBLContadorPassword;
    private javax.swing.JLabel JLBLContadorRepetirPassword;
    private javax.swing.JPasswordField JPSWFPassword;
    private javax.swing.JPasswordField JPSWFRepetirPassword;
    private javax.swing.JTextField JTXTFApellidos;
    private javax.swing.JTextField JTXTFCedulaIdentidad;
    private javax.swing.JTextField JTXTFNombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    // End of variables declaration//GEN-END:variables

    private boolean CIEsValido(final String ci) {
        try {
            int existeGuion = 0;
            int existeLetra = 0;
            for (int i = 0; i < ci.length(); i++) {
                switch (String.valueOf(ci.charAt(i))) {
                    case "-":
                        existeGuion++;
                        break;

                    default:
                        if (!NumberUtils.isParsable(String.valueOf(ci.charAt(i)))) {
                            existeLetra++;
                        }
                        break;
                }
            }

            return !(existeGuion > 1 || existeLetra > 1);
        } catch (final Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo", "SIET", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String ci = JTXTFCedulaIdentidad.getText();
            final String apellidos = JTXTFApellidos.getText();
            final String nombres = JTXTFNombres.getText();
            final int sexoIndex = JCMBXSexo.getSelectedIndex();
            final String clave = new String(JPSWFPassword.getPassword());
            final String repetirClave = new String(JPSWFRepetirPassword.getPassword());

            if (ci.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu cédula de identidad.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFCedulaIdentidad.requestFocus();
            } else if (apellidos.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu(s) apellido(s).", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFApellidos.requestFocus();
            } else if (nombres.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu(s) nombre(s).", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFNombres.requestFocus();
            } else if (sexoIndex == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona tu sexo.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JCMBXProfesion.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona tu profesión.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXProfesion.requestFocus();
            } else if (clave.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa una contraseña para tu cuenta.\nLa contraseña no puede ser vacia ni contener puro espacios.", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSWFPassword.requestFocus();
            } else if (repetirClave.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Vuelve a ingresar la contraseña.", "SIET", JOptionPane.ERROR_MESSAGE);
                JPSWFRepetirPassword.requestFocus();
            } else if (!clave.equals(repetirClave)) {
                JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                if (CIEsValido(ci)) {
                    final String sexo = JCMBXSexo.getSelectedIndex() == 0 ? "M" : "F";
                    final String profesion = JCMBXProfesion.getSelectedItem().toString();
                    final Persona persona = new Persona(ci, apellidos, nombres, sexo);
                    final PersonalTecnico personalTecnico = new PersonalTecnico(persona, profesion, false);
                    final Cuenta cuenta = new Cuenta(personalTecnico, clave, "USER", 1);
                    presenterCrearCuenta.crearCuenta(cuenta, false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cédula de identidad no válida.", "SIET", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    @Override
    public void cuentaCreada(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.INFORMATION_MESSAGE);
        final IniciarSesion iniciarSesion = new IniciarSesion();
        iniciarSesion.setVisible(true);
        dispose();
    }

    @Override
    public void cuentaExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaCuenta(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorCrearCuenta(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearCuenta(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
package View.GestionPerfil;

import Model.POJO.Cuenta;
import Presenter.GestionPerfil.PresenterGestionPerfil;
import java.awt.HeadlessException;
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
public class ModificarInformacion extends javax.swing.JDialog implements PresenterGestionPerfil.CallBackVerificarExistencia, PresenterGestionPerfil.CallBackModificarInformacion {

    private final PresenterGestionPerfil presenterGestionPerfil;
    private Cuenta cuenta;

    public ModificarInformacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionPerfil = new PresenterGestionPerfil();
        presenterGestionPerfil.setCallBackVerificarExistencia(this);
        presenterGestionPerfil.setCallBackModificarInformacion(this);

        JTXTFCedulaIdentidad.addActionListener(action);
        JTXTFApellidos.addActionListener(action);
        JTXTFNombres.addActionListener(action);
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
        JTXTFCedulaIdentidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTXTFApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTXTFNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCMBXSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        JLBLContadorCedulaIdentidad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLContadorApellidos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLBLContadorNombre = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JCMBXProfesion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Información");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Información"));

        jLabel1.setText("C.I:");

        JTXTFCedulaIdentidad.setTransferHandler(null);
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

        jLabel2.setText("APELLIDO(S):");

        JTXTFApellidos.setTransferHandler(null);
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

        jLabel3.setText("NOMBRE(S):");

        JTXTFNombres.setTransferHandler(null);
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

        jLabel4.setText("SEXO:");

        JCMBXSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        JCMBXSexo.setSelectedIndex(-1);

        jLabel5.setText("PROFESION:");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        JLBLContadorCedulaIdentidad.setText("0");

        jLabel8.setText("/20");

        JLBLContadorApellidos.setText("0");

        jLabel9.setText("/50");

        JLBLContadorNombre.setText("0");

        jLabel10.setText("/50");

        JCMBXProfesion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIOQUIMICO(A)", "TECNICO EN LABORATORIO" }));
        JCMBXProfesion.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCMBXProfesion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTXTFCedulaIdentidad)
                    .addComponent(JTXTFApellidos)
                    .addComponent(JTXTFNombres)
                    .addComponent(JCMBXSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorCedulaIdentidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JLBLContadorCedulaIdentidad))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(JLBLContadorApellidos))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(JLBLContadorNombre))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            } else {
                JTXTFCedulaIdentidad.setText(cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad());
                JTXTFApellidos.setText(cuenta.getPersonalTecnico().getPersona().getPersonaApellido());
                JTXTFNombres.setText(cuenta.getPersonalTecnico().getPersona().getPersonaNombre());
                JCMBXSexo.setSelectedIndex(cuenta.getPersonalTecnico().getPersona().getPersonaSexo().equals("M") ? 0 : 1);
                JCMBXProfesion.setSelectedIndex(getIndexProfesion(cuenta.getPersonalTecnico().getPertecProfesion()));

                JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
                JLBLContadorApellidos.setText(String.valueOf(JTXTFApellidos.getText().length()));
                JLBLContadorNombre.setText(String.valueOf(JTXTFNombres.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

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

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFCedulaIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyReleased
        JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyReleased

    private void JTXTFApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFApellidosKeyReleased
        JLBLContadorApellidos.setText(String.valueOf(JTXTFApellidos.getText().length()));
    }//GEN-LAST:event_JTXTFApellidosKeyReleased

    private void JTXTFNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombresKeyReleased
        JLBLContadorNombre.setText(String.valueOf(JTXTFNombres.getText().length()));
    }//GEN-LAST:event_JTXTFNombresKeyReleased

    private void JTXTFCedulaIdentidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadFocusGained
        JTXTFCedulaIdentidad.selectAll();
    }//GEN-LAST:event_JTXTFCedulaIdentidadFocusGained

    private void JTXTFApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFApellidosFocusGained
        JTXTFApellidos.selectAll();
    }//GEN-LAST:event_JTXTFApellidosFocusGained

    private void JTXTFNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombresFocusGained
        JTXTFNombres.selectAll();
    }//GEN-LAST:event_JTXTFNombresFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarInformacion dialog = new ModificarInformacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JCMBXProfesion;
    private javax.swing.JComboBox<String> JCMBXSexo;
    private javax.swing.JLabel JLBLContadorApellidos;
    private javax.swing.JLabel JLBLContadorCedulaIdentidad;
    private javax.swing.JLabel JLBLContadorNombre;
    private javax.swing.JTextField JTXTFApellidos;
    private javax.swing.JTextField JTXTFCedulaIdentidad;
    private javax.swing.JTextField JTXTFNombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private int getIndexProfesion(final String profesion) {
        try {
            int posicion = -1;
            final int size = JCMBXProfesion.getItemCount();
            for (int i = 0; i < size; i++) {
                if (JCMBXProfesion.getItemAt(i).equals(profesion)) {
                    posicion = i;
                    break;
                }
            }
            return posicion;
        } catch (final Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

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
        public void actionPerformed(final ActionEvent e) {
            final String cedulaIdentidad = JTXTFCedulaIdentidad.getText();
            final String apellidos = JTXTFApellidos.getText();
            final String nombres = JTXTFNombres.getText();

            if (cedulaIdentidad.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu cédula de identidad.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFCedulaIdentidad.requestFocus();
            } else if (apellidos.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu(s) apellido(s).", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFApellidos.requestFocus();
            } else if (nombres.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa tu(s) nombre(s).", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFNombres.requestFocus();
            } else if (JCMBXSexo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona tu sexo.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JCMBXProfesion.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona tu profesión.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXProfesion.requestFocus();
            } else {
                if (CIEsValido(cedulaIdentidad)) {
                    cuenta.getPersonalTecnico().getPersona().setPersonaCedulaIdentidad(cedulaIdentidad);
                    cuenta.getPersonalTecnico().getPersona().setPersonaApellido(apellidos);
                    cuenta.getPersonalTecnico().getPersona().setPersonaNombre(nombres);
                    cuenta.getPersonalTecnico().getPersona().setPersonaSexo(JCMBXSexo.getSelectedItem().toString().equals("MASCULINO") ? "M" : "F");
                    cuenta.getPersonalTecnico().setPertecProfesion(JCMBXProfesion.getSelectedItem().toString());

                    presenterGestionPerfil.modificarInformacion(cuenta);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cédula de identidad no válida.", "SIET", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    @Override
    public void cuentaExiste(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaCuenta(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void informacionModificada(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarInformacion(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarInformacion(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
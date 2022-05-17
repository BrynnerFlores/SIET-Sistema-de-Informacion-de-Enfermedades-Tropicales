package View.GestionPacientes;

import Model.POJO.Paciente;
import Model.POJO.Persona;
import Presenter.GestionPacientes.PresenterGestionPacientes;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class ModificarPaciente extends javax.swing.JDialog implements PresenterGestionPacientes.CallBackModificarPaciente {

    private final PresenterGestionPacientes presenterGestionPacientes;
    private Paciente paciente;

    public ModificarPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionPacientes.setCallBackModificarPaciente(this);

        JTXTFCedulaIdentidad.addActionListener(action);
        JTXTFApellidos.addActionListener(action);
        JTXTFNombres.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        JCMBXPersonaSexo = new javax.swing.JComboBox<>();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JDTCHOOSERPacienteFechaNacimiento = new com.toedter.calendar.JDateChooser();
        JLBLContadorCedulaIdentidad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLContadorApellidos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLBLContadorNombre = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Paciente");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Persona"));

        jLabel1.setText("CEDULA DE IDENTIDAD:");

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

        JCMBXPersonaSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        JCMBXPersonaSexo.setSelectedIndex(-1);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jLabel5.setText("FECHA DE NACIMIENTO:");

        JDTCHOOSERPacienteFechaNacimiento.setDate(null);
        JDTCHOOSERPacienteFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERPacienteFechaNacimiento.setMaxSelectableDate(Calendar.getInstance().getTime());

        JLBLContadorCedulaIdentidad.setText("0");

        jLabel8.setText("/20");

        JLBLContadorApellidos.setText("0");

        jLabel9.setText("/50");

        JLBLContadorNombre.setText("0");

        jLabel10.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFCedulaIdentidad)
                    .addComponent(JTXTFApellidos)
                    .addComponent(JTXTFNombres)
                    .addComponent(JDTCHOOSERPacienteFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCMBXPersonaSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
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
                        .addComponent(jLabel10)))
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
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDTCHOOSERPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXPersonaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTXTFCedulaIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-.]*)$");
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
        final Pattern pt = Pattern.compile("^([a-zA-ZñÑ ]*)$");
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
        final Pattern pt = Pattern.compile("^([a-zA-ZñÑ ]*)$");
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFCedulaIdentidad.setText(paciente.getPersona().getPersonaCedulaIdentidad());
                JTXTFApellidos.setText(paciente.getPersona().getPersonaApellido());
                JTXTFNombres.setText(paciente.getPersona().getPersonaNombre());
                JDTCHOOSERPacienteFechaNacimiento.setDate(paciente.getPacienteFechaNacimiento());
                JCMBXPersonaSexo.setSelectedIndex(paciente.getPersona().getPersonaSexo().equals("M") ? 0 : 1);
                
                JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
                JLBLContadorApellidos.setText(String.valueOf(JTXTFApellidos.getText().length()));
                JLBLContadorNombre.setText(String.valueOf(JTXTFNombres.getText().length()));
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

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
            ModificarPaciente dialog = new ModificarPaciente(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JCMBXPersonaSexo;
    private com.toedter.calendar.JDateChooser JDTCHOOSERPacienteFechaNacimiento;
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

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            if (JTXTFCedulaIdentidad.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa la cedula de identidad.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JTXTFApellidos.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa el apellido.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JTXTFNombres.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa el nombre.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JDTCHOOSERPacienteFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Selecciona la fecha de nacimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (JCMBXPersonaSexo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona el sexo.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final String persona_cedula_identidad = JTXTFCedulaIdentidad.getText();
                final String persona_apellido = JTXTFApellidos.getText();
                final String persona_nombre = JTXTFNombres.getText();
                final Date pacienteFechaNacimiento = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERPacienteFechaNacimiento.getDate()));
                final String persona_sexo = JCMBXPersonaSexo.getItemAt(JCMBXPersonaSexo.getSelectedIndex()).equals("MASCULINO") ? "M" : "F";
                final Persona persona = paciente.getPersona();
                persona.setPersonaCedulaIdentidad(persona_cedula_identidad);
                persona.setPersonaApellido(persona_apellido);
                persona.setPersonaNombre(persona_nombre);
                persona.setPersonaSexo(persona_sexo);
                paciente.setPersona(persona);
                paciente.setPacienteFechaNacimiento(pacienteFechaNacimiento);
                presenterGestionPacientes.modificarPaciente(paciente);
            }
        }
    };

    @Override
    public void pacienteModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarPaciente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarPaciente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
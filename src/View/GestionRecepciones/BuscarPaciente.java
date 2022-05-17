package View.GestionRecepciones;

import Model.POJO.Paciente;
import Presenter.GestionPacientes.PresenterGestionPacientes;
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
public class BuscarPaciente extends javax.swing.JDialog implements PresenterGestionPacientes.CallBackVerificarExistencia, PresenterGestionPacientes.CallBackObtenerPaciente {

    private final PresenterGestionPacientes presenterGestionPacientes;

    public BuscarPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();

        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionPacientes.setCallBackVerificarExistencia(this);
        presenterGestionPacientes.setCallBackObtenerPaciente(this);
        JTXTFPacienteCedulaIdentidad.addActionListener(action);
        JBTNBuscar.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFPacienteCedulaIdentidad = new javax.swing.JTextField();
        JBTNBuscar = new javax.swing.JButton();
        JBTNCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JLBLContadorCedulaIdentidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Buscar Paciente");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Paciente"));

        jLabel1.setText("Ingresa la cédula de identidad:");

        JTXTFPacienteCedulaIdentidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFPacienteCedulaIdentidadFocusGained(evt);
            }
        });
        JTXTFPacienteCedulaIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFPacienteCedulaIdentidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFPacienteCedulaIdentidadKeyTyped(evt);
            }
        });
        JTXTFPacienteCedulaIdentidad.setTransferHandler(null);

        JBTNBuscar.setText("BUSCAR");
        JBTNBuscar.setToolTipText("");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("/20");

        JLBLContadorCedulaIdentidad.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorCedulaIdentidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(JTXTFPacienteCedulaIdentidad)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(JBTNBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLBLContadorCedulaIdentidad)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFPacienteCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNBuscar)
                    .addComponent(JBTNCancelar))
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

    private void JTXTFPacienteCedulaIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFPacienteCedulaIdentidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-.]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFPacienteCedulaIdentidad.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFPacienteCedulaIdentidadKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFPacienteCedulaIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFPacienteCedulaIdentidadKeyReleased
        JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFPacienteCedulaIdentidad.getText().length()));
    }//GEN-LAST:event_JTXTFPacienteCedulaIdentidadKeyReleased

    private void JTXTFPacienteCedulaIdentidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFPacienteCedulaIdentidadFocusGained
        JTXTFPacienteCedulaIdentidad.selectAll();
    }//GEN-LAST:event_JTXTFPacienteCedulaIdentidadFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            BuscarPaciente dialog = new BuscarPaciente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNBuscar;
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JLabel JLBLContadorCedulaIdentidad;
    private javax.swing.JTextField JTXTFPacienteCedulaIdentidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String cedulaIdentidad = JTXTFPacienteCedulaIdentidad.getText();
            if (cedulaIdentidad.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa la cédula de identidad del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                presenterGestionPacientes.obtenerPaciente(cedulaIdentidad);
            }
        }
    };

    @Override
    public void pacienteExiste(final String msg) {}

    @Override
    public void errorVerificarExistenciaPaciente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void pacienteObtenido(final Paciente paciente) {
        this.setVisible(false);
        final RegistrarRecepcion registrarRecepcion = new RegistrarRecepcion(null, true);
        registrarRecepcion.setPacienteExiste(true);
        registrarRecepcion.setPaciente(paciente);
        registrarRecepcion.setVisible(true);
    }

    @Override
    public void pacienteNoEncontrado(final String msg) {
        this.setVisible(false);
        final RegistrarRecepcion registrarRecepcion = new RegistrarRecepcion(null, true);
        registrarRecepcion.setPacienteExiste(false);
        registrarRecepcion.setCedulaIdentidad(JTXTFPacienteCedulaIdentidad.getText());
        registrarRecepcion.setVisible(true);
    }

    @Override
    public void errorObtenerPaciente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerPaciente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
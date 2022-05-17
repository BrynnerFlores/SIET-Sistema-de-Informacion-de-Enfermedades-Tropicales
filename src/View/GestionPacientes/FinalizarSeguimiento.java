package View.GestionPacientes;

import Model.POJO.SeguimientoPaciente;
import Presenter.GestionPacientes.PresenterGestionSeguimientoPaciente;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Brynner
 */
public class FinalizarSeguimiento extends javax.swing.JDialog implements PresenterGestionSeguimientoPaciente.CallBackVerificarSeguimientoFinalizado, PresenterGestionSeguimientoPaciente.CallBackFinalizarSeguimiento  {
    
    private final PresenterGestionSeguimientoPaciente presenterGestionSeguimientoPaciente;
    private SeguimientoPaciente seguimientoPaciente;
    
    public FinalizarSeguimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        presenterGestionSeguimientoPaciente = new PresenterGestionSeguimientoPaciente();
        presenterGestionSeguimientoPaciente.setCallBackVerificarSeguimientoFinalizado(this);
        presenterGestionSeguimientoPaciente.setCallBackFinalizarSeguimiento(this);
    }

    public void setSeguimientoPaciente(SeguimientoPaciente seguimientoPaciente) {
        this.seguimientoPaciente = seguimientoPaciente;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLPaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLExamenNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JDTCHOOSERFechaFinalSeguimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNHoraFinalSeguimiento = new javax.swing.JSpinner(spinnerDateModel);
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREADetallesObservacionesFinalSeguimiento = new javax.swing.JTextArea();
        JLBLContadorDetallesUObservacionesFinalizacionSeguimiento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Finalizar Seguimiento");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar Seguimiento"));

        jLabel1.setText("PACIENTE EN SEGUIMIENTO:");

        JLBLPaciente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("EXAMEN EN SEGUIMIENTO:");

        JLBLExamenNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("FECHA FINAL DEL SEGUIMIENTO:");

        JDTCHOOSERFechaFinalSeguimiento.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaFinalSeguimiento.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERFechaFinalSeguimiento.setMaxSelectableDate(Calendar.getInstance().getTime());

        jLabel7.setText("HORA FINAL DEL SEGUIMIENTO");

        JSPNHoraFinalSeguimiento.setEditor(new JSpinner.DateEditor(JSPNHoraFinalSeguimiento, "HH:mm:ss"));

        jLabel6.setText("DETALLES U OBSERVACIONES PARA LA FINALIZACION DEL SEGUIMIENTO:");

        JTXTAREADetallesObservacionesFinalSeguimiento.setColumns(20);
        JTXTAREADetallesObservacionesFinalSeguimiento.setLineWrap(true);
        JTXTAREADetallesObservacionesFinalSeguimiento.setRows(5);
        JTXTAREADetallesObservacionesFinalSeguimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREADetallesObservacionesFinalSeguimientoFocusGained(evt);
            }
        });
        JTXTAREADetallesObservacionesFinalSeguimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesFinalSeguimientoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped(evt);
            }
        });
        JTXTAREADetallesObservacionesFinalSeguimiento.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREADetallesObservacionesFinalSeguimiento);

        JLBLContadorDetallesUObservacionesFinalizacionSeguimiento.setText("0");

        jLabel2.setText("/200");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNFinalizar.setText("FINALIZAR");
        JBTNFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorDetallesUObservacionesFinalizacionSeguimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLBLPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(JDTCHOOSERFechaFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(JSPNHoraFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNFinalizar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSPNHoraFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTCHOOSERFechaFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(JLBLContadorDetallesUObservacionesFinalizacionSeguimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNFinalizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if (seguimientoPaciente == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLPaciente.setText(seguimientoPaciente.getPaciente().getPersona().getPersonaApellido() + " " + seguimientoPaciente.getPaciente().getPersona().getPersonaNombre());
                JLBLExamenNombre.setText(seguimientoPaciente.getExamen().getExamenNombre());
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9,. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREADetallesObservacionesFinalSeguimiento.getText().length() >= 200) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JBTNFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNFinalizarActionPerformed
        if (JDTCHOOSERFechaFinalSeguimiento.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de finalización del seguimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            JDTCHOOSERFechaFinalSeguimiento.requestFocus();
        } else if (JSPNHoraFinalSeguimiento.getValue().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona la hora de finalización del seguimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            JSPNHoraFinalSeguimiento.requestFocus();
        } else {
            final Date fechaInicioSeguimiento = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaFinalSeguimiento.getDate()));
            final Time horaInicioSeguimiento = Time.valueOf(new JSpinner.DateEditor(JSPNHoraFinalSeguimiento, "HH:mm:ss").getFormat().format(JSPNHoraFinalSeguimiento.getValue()));
            final String observacionesDetallesFinalSeguimiento = JTXTAREADetallesObservacionesFinalSeguimiento.getText();
            
            seguimientoPaciente.setFechaFinal(fechaInicioSeguimiento);
            seguimientoPaciente.setHoraFinal(horaInicioSeguimiento);
            seguimientoPaciente.setDetallesObservacionesFinal(observacionesDetallesFinalSeguimiento);
            
            presenterGestionSeguimientoPaciente.finalizarSeguimiento(seguimientoPaciente);
        }
    }//GEN-LAST:event_JBTNFinalizarActionPerformed

    private void JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased
        JLBLContadorDetallesUObservacionesFinalizacionSeguimiento.setText(String.valueOf(JTXTAREADetallesObservacionesFinalSeguimiento.getText().length()));
    }//GEN-LAST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased

    private void JTXTAREADetallesObservacionesFinalSeguimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyPressed

    private void JTXTAREADetallesObservacionesFinalSeguimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesFinalSeguimientoFocusGained
        JTXTAREADetallesObservacionesFinalSeguimiento.selectAll();
    }//GEN-LAST:event_JTXTAREADetallesObservacionesFinalSeguimientoFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            FinalizarSeguimiento dialog = new FinalizarSeguimiento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNFinalizar;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaFinalSeguimiento;
    private javax.swing.JLabel JLBLContadorDetallesUObservacionesFinalizacionSeguimiento;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JLabel JLBLPaciente;
    private javax.swing.JSpinner JSPNHoraFinalSeguimiento;
    private javax.swing.JTextArea JTXTAREADetallesObservacionesFinalSeguimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void seguimientoEstaFinalizado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void errorVerificarSeguimientoFinalizado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void seguimientoFinalizado(final String msg) {
        dispose();
    }

    @Override
    public void errorFinalizarSeguimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void errorDesconocidoFinalizarSeguimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }
}
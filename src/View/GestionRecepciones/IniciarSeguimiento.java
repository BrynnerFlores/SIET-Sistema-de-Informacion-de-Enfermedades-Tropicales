package View.GestionRecepciones;

import Model.POJO.ExamenSolicitado;
import Model.POJO.SeguimientoPaciente;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import Presenter.GestionPacientes.PresenterGestionSeguimientoPaciente;
import Presenter.GestionRecepciones.PresenterGestionExamenesSolicitados;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
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
public class IniciarSeguimiento extends javax.swing.JDialog implements PresenterGestionExamenesSolicitados.CallBackObtenerResultadosGenerales, PresenterGestionSeguimientoPaciente.CallBackVerificarSeguimientoExiste, PresenterGestionSeguimientoPaciente.CallBackVerificarSeguimientoIniciado, PresenterGestionSeguimientoPaciente.CallBackIniciarSeguimiento {
    
    private final PresenterGestionSeguimientoPaciente presenterGestionSeguimientoPaciente;
    private final PresenterGestionExamenesSolicitados presenterGestionExamenesSolicitados;
    
    private ExamenSolicitado examenSolicitado;
    
    public IniciarSeguimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        
        presenterGestionSeguimientoPaciente = new PresenterGestionSeguimientoPaciente();
        presenterGestionExamenesSolicitados = new PresenterGestionExamenesSolicitados();
        presenterGestionSeguimientoPaciente.setCallBackVerificarSeguimientoExiste(this);
        presenterGestionSeguimientoPaciente.setCallBackVerificarSeguimientoIniciado(this);
        presenterGestionExamenesSolicitados.setCallBackObtenerResultadosGenerales(this);
        presenterGestionSeguimientoPaciente.setCallBackIniciarSeguimiento(this);
        
    }
    
    public void setExamenSolicitado(ExamenSolicitado examenSolicitado) {
        this.examenSolicitado = examenSolicitado;
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
        jLabel7 = new javax.swing.JLabel();
        JDTCHOOSERFechaInicioSeguimiento = new com.toedter.calendar.JDateChooser();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNHoraInicioSeguimiento = new javax.swing.JSpinner(spinnerDateModel);
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREADetallesObservacionesInicioSeguimiento = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        JLBLContadorDetallesUObservacionesInicioSeguimiento = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Iniciar Seguimiento");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos para el seguimiento del paciente"));

        jLabel1.setText("PACIENTE EN SEGUIMIENTO:");

        JLBLPaciente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("EXAMEN EN SEGUIMIENTO:");

        JLBLExamenNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("FECHA INICIO DEL SEGUIMIENTO:");

        jLabel7.setText("HORA INICIO DEL SEGUIMIENTO");

        JDTCHOOSERFechaInicioSeguimiento.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaInicioSeguimiento.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERFechaInicioSeguimiento.setMaxSelectableDate(Calendar.getInstance().getTime());

        JSPNHoraInicioSeguimiento.setEditor(new JSpinner.DateEditor(JSPNHoraInicioSeguimiento, "HH:mm:ss"));

        jLabel6.setText("DETALLES U OBSERVACIONES PARA EL INICIO DEL SEGUIMIENTO:");

        JTXTAREADetallesObservacionesInicioSeguimiento.setColumns(20);
        JTXTAREADetallesObservacionesInicioSeguimiento.setLineWrap(true);
        JTXTAREADetallesObservacionesInicioSeguimiento.setRows(5);
        JTXTAREADetallesObservacionesInicioSeguimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREADetallesObservacionesInicioSeguimientoFocusGained(evt);
            }
        });
        JTXTAREADetallesObservacionesInicioSeguimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesInicioSeguimientoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesInicioSeguimientoKeyTyped(evt);
            }
        });
        JTXTAREADetallesObservacionesInicioSeguimiento.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREADetallesObservacionesInicioSeguimiento);

        jLabel2.setText("/200");

        JLBLContadorDetallesUObservacionesInicioSeguimiento.setText("0");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNIniciar.setText("INICIAR");
        JBTNIniciar.setToolTipText("");
        JBTNIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNIniciarActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorDetallesUObservacionesInicioSeguimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNIniciar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(JDTCHOOSERFechaInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(JSPNHoraInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSPNHoraInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTCHOOSERFechaInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(JLBLContadorDetallesUObservacionesInicioSeguimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNIniciar))
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
            if (examenSolicitado == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLPaciente.setText(examenSolicitado.getRecepcion().getPaciente().getPersona().getPersonaApellido() + " " + examenSolicitado.getRecepcion().getPaciente().getPersona().getPersonaNombre());
                JLBLExamenNombre.setText(examenSolicitado.getExamen().getExamenNombre());
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error desconocido. Vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTAREADetallesObservacionesInicioSeguimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREADetallesObservacionesInicioSeguimiento.getText().length() >= 200) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JBTNIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNIniciarActionPerformed
        if (JDTCHOOSERFechaInicioSeguimiento.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha en la que se está iniciando el seguimiento al paciente.");
            JDTCHOOSERFechaInicioSeguimiento.requestFocus();
        } else if (JSPNHoraInicioSeguimiento.getValue().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona la hora en la que se está iniciando el seguimiento al paciente.");
        } else {
            presenterGestionExamenesSolicitados.obtenerResultadosGenerales(examenSolicitado);
        }
    }//GEN-LAST:event_JBTNIniciarActionPerformed

    private void JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased
        JLBLContadorDetallesUObservacionesInicioSeguimiento.setText(String.valueOf(JTXTAREADetallesObservacionesInicioSeguimiento.getText().length()));
    }//GEN-LAST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased

    private void JTXTAREADetallesObservacionesInicioSeguimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyPressed

    private void JTXTAREADetallesObservacionesInicioSeguimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesInicioSeguimientoFocusGained
        JTXTAREADetallesObservacionesInicioSeguimiento.selectAll();
    }//GEN-LAST:event_JTXTAREADetallesObservacionesInicioSeguimientoFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            IniciarSeguimiento dialog = new IniciarSeguimiento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNIniciar;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaInicioSeguimiento;
    private javax.swing.JLabel JLBLContadorDetallesUObservacionesInicioSeguimiento;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JLabel JLBLPaciente;
    private javax.swing.JSpinner JSPNHoraInicioSeguimiento;
    private javax.swing.JTextArea JTXTAREADetallesObservacionesInicioSeguimiento;
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
    public void resultadosGeneralesObtenidos(final List<ResultadoGeneralPersonalizado> resultadoGeneralesPersonalizados) {
        boolean resultadoEsControl = false;
        
        for (final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado : resultadoGeneralesPersonalizados) {
            if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() != null) {
                resultadoEsControl = true;
                break;
            }
        }
        
        if (resultadoEsControl) {
            JOptionPane.showMessageDialog(rootPane, "Este exámen es parte de un control de seguimiento, no puede iniciarse como seguimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
        } else {
            final Date fechaInicioSeguimiento = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaInicioSeguimiento.getDate()));
            final Time horaInicioSeguimiento = Time.valueOf(new JSpinner.DateEditor(JSPNHoraInicioSeguimiento, "HH:mm:ss").getFormat().format(JSPNHoraInicioSeguimiento.getValue()));
            final String observacionesDetallesInicioSeguimiento = JTXTAREADetallesObservacionesInicioSeguimiento.getText();
            
            presenterGestionSeguimientoPaciente.iniciarSeguimiento(new SeguimientoPaciente(examenSolicitado.getRecepcion().getPaciente(), examenSolicitado.getExamen(), examenSolicitado, fechaInicioSeguimiento, horaInicioSeguimiento, "EN SEGUIMIENTO", observacionesDetallesInicioSeguimiento));
        }
    }

    @Override
    public void listaResultadosGeneralesVacia(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void errorObtenerResultadosGenerales(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void errorDesconocidoObtenerResultadosGenerales(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }
    
    @Override
    public void seguimientoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarSeguimientoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void seguimientoEstaIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarSeguimientoIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void seguimientoIniciado(final String msg) {
        dispose();
    }

    @Override
    public void errorIniciarSeguimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoIniciarSeguimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
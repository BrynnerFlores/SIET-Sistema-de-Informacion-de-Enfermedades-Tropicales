package View.GestionPacientes;

import Model.POJO.SeguimientoPaciente;
import java.awt.HeadlessException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brynner
 */
public class VerDetallesSeguimiento extends javax.swing.JDialog {
    
    private SeguimientoPaciente seguimientoPaciente;
    
    public VerDetallesSeguimiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setSeguimientoPaciente(SeguimientoPaciente seguimientoPaciente) {
        this.seguimientoPaciente = seguimientoPaciente;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLExamen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLProgreso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLFechaInicioSeguimiento = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLHoraInicioSeguimiento = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLBLFechaFinalSeguimiento = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JLBLHoraFinalSeguimiento = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREADetallesObservacionesInicioSeguimiento = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTXTAREADetallesObservacionesFinalSeguimiento = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        JLBLContadorDetallesObservacionesInicioSeguimiento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLBLContadorDetallesObservacionesFinalSeguimiento = new javax.swing.JLabel();
        JBTNCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Detalles del Seguimiento");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Seguimiento"));

        jLabel1.setText("EXAMEN:");

        JLBLExamen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("PROGRESO:");

        JLBLProgreso.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("FECHA INICIO SEGUIMIENTO:");
        jLabel5.setToolTipText("");

        JLBLFechaInicioSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("HORA INICIO SEGUIMIENTO:");

        JLBLHoraInicioSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("FECHA FINAL SEGUIMIENTO:");

        JLBLFechaFinalSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("HORA FINAL SEGUIMIENTO:");

        JLBLHoraFinalSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("DETALLES U OBSERVACIONES AL INICIO DEL SEGUIMIENTO:");

        JTXTAREADetallesObservacionesInicioSeguimiento.setEditable(false);
        JTXTAREADetallesObservacionesInicioSeguimiento.setColumns(20);
        JTXTAREADetallesObservacionesInicioSeguimiento.setLineWrap(true);
        JTXTAREADetallesObservacionesInicioSeguimiento.setRows(5);
        JTXTAREADetallesObservacionesInicioSeguimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesInicioSeguimientoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(JTXTAREADetallesObservacionesInicioSeguimiento);

        jLabel14.setText("DETALLES U OBSERVACIONES AL FINALIZAR EL SEGUIMIENTO:");

        JTXTAREADetallesObservacionesFinalSeguimiento.setEditable(false);
        JTXTAREADetallesObservacionesFinalSeguimiento.setColumns(20);
        JTXTAREADetallesObservacionesFinalSeguimiento.setLineWrap(true);
        JTXTAREADetallesObservacionesFinalSeguimiento.setRows(5);
        JTXTAREADetallesObservacionesFinalSeguimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(JTXTAREADetallesObservacionesFinalSeguimiento);

        jLabel2.setText("/200");

        JLBLContadorDetallesObservacionesInicioSeguimiento.setText("0");

        jLabel4.setText("/200");

        JLBLContadorDetallesObservacionesFinalSeguimiento.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorDetallesObservacionesInicioSeguimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorDetallesObservacionesFinalSeguimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLBLFechaInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(JLBLHoraInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLBLFechaFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(JLBLHoraFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLBLExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(JLBLProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLProgreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLFechaInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLHoraFinalSeguimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLFechaFinalSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2)
                    .addComponent(JLBLContadorDetallesObservacionesInicioSeguimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel4)
                    .addComponent(JLBLContadorDetallesObservacionesFinalSeguimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCerrar.setText("CERRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTNCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBTNCerrar)
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
                JLBLExamen.setText(seguimientoPaciente.getExamen().getExamenNombre());
                JLBLProgreso.setText(seguimientoPaciente.getProgreso());
                JLBLFechaInicioSeguimiento.setText(seguimientoPaciente.getFechaInicio().toString());
                JLBLHoraInicioSeguimiento.setText(seguimientoPaciente.getHoraInicio().toString());
                JLBLFechaFinalSeguimiento.setText(seguimientoPaciente.getFechaFinal() == null ? "" : seguimientoPaciente.getFechaFinal().toString());
                JLBLHoraFinalSeguimiento.setText(seguimientoPaciente.getHoraFinal() == null ? "" : seguimientoPaciente.getHoraFinal().toString());
                JTXTAREADetallesObservacionesInicioSeguimiento.setText(seguimientoPaciente.getDetallesObservacionesInicio() == null ? "" : seguimientoPaciente.getDetallesObservacionesInicio());
                JTXTAREADetallesObservacionesFinalSeguimiento.setText(seguimientoPaciente.getDetallesObservacionesFinal() == null  ? "" : seguimientoPaciente.getDetallesObservacionesFinal());
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
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

    private void JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREADetallesObservacionesFinalSeguimiento.getText().length() >= 200) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyTyped

    private void JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased
        JLBLContadorDetallesObservacionesInicioSeguimiento.setText(String.valueOf(JTXTAREADetallesObservacionesInicioSeguimiento.getText().length()));
    }//GEN-LAST:event_JTXTAREADetallesObservacionesInicioSeguimientoKeyReleased

    private void JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased
        JLBLContadorDetallesObservacionesFinalSeguimiento.setText(String.valueOf(JTXTAREADetallesObservacionesFinalSeguimiento.getText().length()));
    }//GEN-LAST:event_JTXTAREADetallesObservacionesFinalSeguimientoKeyReleased
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerDetallesSeguimiento dialog = new VerDetallesSeguimiento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLContadorDetallesObservacionesFinalSeguimiento;
    private javax.swing.JLabel JLBLContadorDetallesObservacionesInicioSeguimiento;
    private javax.swing.JLabel JLBLExamen;
    private javax.swing.JLabel JLBLFechaFinalSeguimiento;
    private javax.swing.JLabel JLBLFechaInicioSeguimiento;
    private javax.swing.JLabel JLBLHoraFinalSeguimiento;
    private javax.swing.JLabel JLBLHoraInicioSeguimiento;
    private javax.swing.JLabel JLBLProgreso;
    private javax.swing.JTextArea JTXTAREADetallesObservacionesFinalSeguimiento;
    private javax.swing.JTextArea JTXTAREADetallesObservacionesInicioSeguimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
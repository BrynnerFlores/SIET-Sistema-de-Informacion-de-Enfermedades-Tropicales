package View.GestionReactivos;

import Model.POJO.ReactivoEntrega;
import Presenter.GestionReactivos.PresenterGestionReactivosEntregas;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Brynner
 */
public class ModificarEntrega extends javax.swing.JDialog implements PresenterGestionReactivosEntregas.CallBackActualizarEntrega {

    private final PresenterGestionReactivosEntregas presenterGestionReactivosEntregas;
    private ReactivoEntrega reactivoEntrega;

    public ModificarEntrega(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionReactivosEntregas = new PresenterGestionReactivosEntregas();
        presenterGestionReactivosEntregas.setCallBackActualizarEntrega(this);

        JTXTFProveedor.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setReactivoEntrega(ReactivoEntrega reactivoEntrega) {
        this.reactivoEntrega = reactivoEntrega;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JLBLPersonalTecnico = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTXTFProveedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JDTCHOOSERFechaEntrega = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNHoraEntrega = new javax.swing.JSpinner(spinnerDateModel);
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREAObservaciones = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        JLBLContadorProveedor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLContadorObservaciones = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Entrega");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Entrega"));

        jLabel2.setText("ENTREGADO A:");

        JLBLPersonalTecnico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("RECIBIDO DE:");

        JTXTFProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFProveedorFocusGained(evt);
            }
        });
        JTXTFProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFProveedorKeyTyped(evt);
            }
        });
        JTXTFProveedor.setTransferHandler(null);

        jLabel3.setText("FECHA DE ENTREGA:");

        JDTCHOOSERFechaEntrega.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaEntrega.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERFechaEntrega.setMaxSelectableDate(Calendar.getInstance().getTime());

        jLabel5.setText("HORA DE ENTREGA:");

        JSPNHoraEntrega.setEditor(new JSpinner.DateEditor(JSPNHoraEntrega, "HH:mm:ss"));

        jLabel6.setText("OBSERVACIONES:");

        JTXTAREAObservaciones.setColumns(20);
        JTXTAREAObservaciones.setLineWrap(true);
        JTXTAREAObservaciones.setRows(5);
        JTXTAREAObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAObservacionesFocusGained(evt);
            }
        });
        JTXTAREAObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyTyped(evt);
            }
        });
        JTXTAREAObservaciones.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREAObservaciones);

        jLabel1.setText("/50");

        JLBLContadorProveedor.setText("0");

        jLabel7.setText("/150");

        JLBLContadorObservaciones.setText("0");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorObservaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(JLBLPersonalTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(JDTCHOOSERFechaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTXTFProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(JSPNHoraEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JLBLContadorProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLPersonalTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTXTFProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDTCHOOSERFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPNHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JLBLContadorObservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (reactivoEntrega == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLPersonalTecnico.setText(reactivoEntrega.getPersonalTecnico().getPersona().getPersonaApellido() + " " + reactivoEntrega.getPersonalTecnico().getPersona().getPersonaNombre());
                JTXTFProveedor.setText(reactivoEntrega.getProveedor());
                JLBLContadorProveedor.setText(String.valueOf(JTXTFProveedor.getText().length()));
                JDTCHOOSERFechaEntrega.setDate(reactivoEntrega.getFechaEntrega());
                JSPNHoraEntrega.setValue(reactivoEntrega.getHoraEntrega());
                JTXTAREAObservaciones.setText(reactivoEntrega.getObservaciones());
                JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAObservaciones.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFProveedorKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFProveedor.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFProveedorKeyTyped

    private void JTXTAREAObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAObservaciones.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAObservacionesKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFProveedorKeyReleased
        JLBLContadorProveedor.setText(String.valueOf(JTXTFProveedor.getText().length()));
    }//GEN-LAST:event_JTXTFProveedorKeyReleased

    private void JTXTAREAObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyReleased
        JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAObservaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREAObservacionesKeyReleased

    private void JTXTAREAObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAObservacionesKeyPressed

    private void JTXTFProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFProveedorFocusGained
        JTXTFProveedor.selectAll();
    }//GEN-LAST:event_JTXTFProveedorFocusGained

    private void JTXTAREAObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesFocusGained
        JTXTAREAObservaciones.selectAll();
    }//GEN-LAST:event_JTXTAREAObservacionesFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarEntrega dialog = new ModificarEntrega(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaEntrega;
    private javax.swing.JLabel JLBLContadorObservaciones;
    private javax.swing.JLabel JLBLContadorProveedor;
    private javax.swing.JLabel JLBLPersonalTecnico;
    private javax.swing.JSpinner JSPNHoraEntrega;
    private javax.swing.JTextArea JTXTAREAObservaciones;
    private javax.swing.JTextField JTXTFProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String proveedor = JTXTFProveedor.getText().trim();
            final Date fechaEntrega = JDTCHOOSERFechaEntrega.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaEntrega.getDate()));
            final Time horaEntrega = JSPNHoraEntrega.getValue() == null ? null : Time.valueOf(new JSpinner.DateEditor(JSPNHoraEntrega, "HH:mm:ss").getFormat().format(JSPNHoraEntrega.getValue()));
            final String observaciones = JTXTAREAObservaciones.getText().trim();

            if (proveedor.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el proveedor.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFProveedor.requestFocus();
            } else if (fechaEntrega == null) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de entrega.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else if (horaEntrega == null) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa la hora de entrega.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                reactivoEntrega.setProveedor(proveedor);
                reactivoEntrega.setFechaEntrega(fechaEntrega);
                reactivoEntrega.setHoraEntrega(horaEntrega);
                reactivoEntrega.setObservaciones(observaciones);
                presenterGestionReactivosEntregas.actualizarEntrega(reactivoEntrega);
            }
        }
    };

    @Override
    public void entregaActualizada(final String msg) {
        dispose();
    }

    @Override
    public void errorActualizarEntrega(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoActualizarEntrega(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Equipo;
import Model.POJO.Intervencion;
import Presenter.GestionEquipos.PresenterGestionEquipos;
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
public class EnviarIntervencion extends javax.swing.JDialog implements PresenterGestionEquipos.CallBackRegistrarIntervencion {
    
    private final PresenterGestionEquipos presenterGestionEquipos;
    private Equipo equipo;
    
    public EnviarIntervencion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionEquipos.setCallBackRegistrarIntervencion(this);
        JTXTFIntervencionCausa.addActionListener(action);
        JBTNEnviarIntervencion.addActionListener(action);
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JDTCHOOSERIntervencionFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        JTXTFIntervencionCausa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREAIntervencionDescripcionActividad = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTXTAREAIntervencionObservaciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        JTXTFIntervencionTrabajoRealizado = new javax.swing.JTextField();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNIntervencionHoraInicio = new javax.swing.JSpinner(spinnerDateModel);
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JLBLContadorCausaIntervencion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLContadorTrabajoRealizado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLContadorDescripcionActividad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLContadorObservaciones = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNEnviarIntervencion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Enviar Equipo a Intervención");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Intervención"));

        jLabel2.setText("FECHA INICIO DE INTERVENCION:");

        JDTCHOOSERIntervencionFechaInicio.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERIntervencionFechaInicio.setDateFormatString("yyyy-MM-dd");

        jLabel4.setText("CAUSA DE INTERVENCION:");

        JTXTFIntervencionCausa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFIntervencionCausaFocusGained(evt);
            }
        });
        JTXTFIntervencionCausa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionCausaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionCausaKeyTyped(evt);
            }
        });
        JTXTFIntervencionCausa.setTransferHandler(null);

        jLabel6.setText("DESCRIPCION DE ACTIVIDAD:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTXTAREAIntervencionDescripcionActividad.setColumns(20);
        JTXTAREAIntervencionDescripcionActividad.setLineWrap(true);
        JTXTAREAIntervencionDescripcionActividad.setRows(5);
        JTXTAREAIntervencionDescripcionActividad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAIntervencionDescripcionActividadFocusGained(evt);
            }
        });
        JTXTAREAIntervencionDescripcionActividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionDescripcionActividadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionDescripcionActividadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionDescripcionActividadKeyTyped(evt);
            }
        });
        JTXTAREAIntervencionDescripcionActividad.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREAIntervencionDescripcionActividad);

        jLabel8.setText("OBSERVACIONES:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTXTAREAIntervencionObservaciones.setColumns(20);
        JTXTAREAIntervencionObservaciones.setLineWrap(true);
        JTXTAREAIntervencionObservaciones.setRows(5);
        JTXTAREAIntervencionObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAIntervencionObservacionesFocusGained(evt);
            }
        });
        JTXTAREAIntervencionObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionObservacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionObservacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionObservacionesKeyTyped(evt);
            }
        });
        JTXTAREAIntervencionObservaciones.setTransferHandler(null);
        jScrollPane2.setViewportView(JTXTAREAIntervencionObservaciones);

        jLabel9.setText("TRABAJO REALIZADO:");

        JTXTFIntervencionTrabajoRealizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFIntervencionTrabajoRealizadoFocusGained(evt);
            }
        });
        JTXTFIntervencionTrabajoRealizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionTrabajoRealizadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionTrabajoRealizadoKeyTyped(evt);
            }
        });
        JTXTFIntervencionTrabajoRealizado.setTransferHandler(null);

        JSPNIntervencionHoraInicio.setEditor(new JSpinner.DateEditor(JSPNIntervencionHoraInicio, "HH:mm:ss"));

        jLabel10.setText("HORA INICIO DE INTERVENCION:");

        jLabel1.setText("/50");

        JLBLContadorCausaIntervencion.setText("0");

        jLabel3.setText("/50");

        JLBLContadorTrabajoRealizado.setText("0");
        JLBLContadorTrabajoRealizado.setToolTipText("");

        jLabel5.setText("/150");

        JLBLContadorDescripcionActividad.setText("0");

        jLabel7.setText("/150");

        JLBLContadorObservaciones.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDTCHOOSERIntervencionFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 266, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(JLBLContadorDescripcionActividad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(JLBLContadorObservaciones)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))))
                            .addComponent(JSPNIntervencionHoraInicio)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTXTFIntervencionCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorCausaIntervencion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLBLContadorTrabajoRealizado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(JTXTFIntervencionTrabajoRealizado))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JDTCHOOSERIntervencionFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPNIntervencionHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(JLBLContadorTrabajoRealizado))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1)
                        .addComponent(JLBLContadorCausaIntervencion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTXTFIntervencionTrabajoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTXTFIntervencionCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(JLBLContadorDescripcionActividad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(JLBLContadorObservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNEnviarIntervencion.setText("ENVIAR A INTERVENCION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNEnviarIntervencion)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNEnviarIntervencion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (equipo == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFIntervencionCausaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionCausaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z.Ññ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFIntervencionCausa.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFIntervencionCausaKeyTyped

    private void JTXTAREAIntervencionDescripcionActividadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9.ñÑ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAIntervencionDescripcionActividad.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadKeyTyped

    private void JTXTAREAIntervencionObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9.Ññ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAIntervencionObservaciones.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFIntervencionTrabajoRealizadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionTrabajoRealizadoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z.ñÑ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFIntervencionTrabajoRealizado.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFIntervencionTrabajoRealizadoKeyTyped

    private void JTXTFIntervencionCausaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionCausaKeyReleased
        JLBLContadorCausaIntervencion.setText(String.valueOf(JTXTFIntervencionCausa.getText().length()));
    }//GEN-LAST:event_JTXTFIntervencionCausaKeyReleased

    private void JTXTFIntervencionTrabajoRealizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionTrabajoRealizadoKeyReleased
        JLBLContadorTrabajoRealizado.setText(String.valueOf(JTXTFIntervencionTrabajoRealizado.getText().length()));
    }//GEN-LAST:event_JTXTFIntervencionTrabajoRealizadoKeyReleased

    private void JTXTAREAIntervencionDescripcionActividadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadKeyReleased
        JLBLContadorDescripcionActividad.setText(String.valueOf(JTXTAREAIntervencionDescripcionActividad.getText().length()));
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadKeyReleased

    private void JTXTAREAIntervencionObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesKeyReleased
        JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAIntervencionObservaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesKeyReleased

    private void JTXTAREAIntervencionDescripcionActividadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadKeyPressed

    private void JTXTAREAIntervencionObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesKeyPressed

    private void JTXTFIntervencionCausaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFIntervencionCausaFocusGained
        JTXTFIntervencionCausa.selectAll();
    }//GEN-LAST:event_JTXTFIntervencionCausaFocusGained

    private void JTXTFIntervencionTrabajoRealizadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFIntervencionTrabajoRealizadoFocusGained
        JTXTFIntervencionTrabajoRealizado.selectAll();
    }//GEN-LAST:event_JTXTFIntervencionTrabajoRealizadoFocusGained

    private void JTXTAREAIntervencionDescripcionActividadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadFocusGained

    private void JTXTAREAIntervencionObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            EnviarIntervencion dialog = new EnviarIntervencion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNEnviarIntervencion;
    private com.toedter.calendar.JDateChooser JDTCHOOSERIntervencionFechaInicio;
    private javax.swing.JLabel JLBLContadorCausaIntervencion;
    private javax.swing.JLabel JLBLContadorDescripcionActividad;
    private javax.swing.JLabel JLBLContadorObservaciones;
    private javax.swing.JLabel JLBLContadorTrabajoRealizado;
    private javax.swing.JSpinner JSPNIntervencionHoraInicio;
    private javax.swing.JTextArea JTXTAREAIntervencionDescripcionActividad;
    private javax.swing.JTextArea JTXTAREAIntervencionObservaciones;
    private javax.swing.JTextField JTXTFIntervencionCausa;
    private javax.swing.JTextField JTXTFIntervencionTrabajoRealizado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                final Date intervencionFechaInicio = JDTCHOOSERIntervencionFechaInicio.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERIntervencionFechaInicio.getDate()));
                final Time intervencionHoraInicio = Time.valueOf(new JSpinner.DateEditor(JSPNIntervencionHoraInicio, "HH:mm:ss").getFormat().format(JSPNIntervencionHoraInicio.getValue()));
                final String intervencionCausa = JTXTFIntervencionCausa.getText();
                final String intervencionTrabajoRealizado = JTXTFIntervencionTrabajoRealizado.getText();
                final String intervencionDescripcionActividad = JTXTAREAIntervencionDescripcionActividad.getText();
                final String intervencionObservaciones = JTXTAREAIntervencionObservaciones.getText();
                
                
                if (intervencionFechaInicio == null) {
                    JOptionPane.showMessageDialog(null, "Ingresa la fecha de intervención.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionHoraInicio == null) {
                    JOptionPane.showMessageDialog(null, "Ingresa la hora de la intervención.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionCausa.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa la causa de la intervención.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionTrabajoRealizado.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el trabajo realizado.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionDescripcionActividad.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa una descripción de la actividad.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final Intervencion intervencion = new Intervencion(equipo, intervencionFechaInicio, intervencionHoraInicio, null, null, intervencionCausa, intervencionTrabajoRealizado, intervencionDescripcionActividad, intervencionObservaciones, 1);
                    presenterGestionEquipos.registrarIntervencion(intervencion);
                }
            } catch (final HeadlessException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error enviar a intervencion el equipo: " + exception.getMessage());
            }
        }
    };

    @Override
    public void intervencionRegistrada(final String msg) {
        dispose();
    }

    @Override
    public void errorRegistrarIntervencion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoRegistrarIntervencion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
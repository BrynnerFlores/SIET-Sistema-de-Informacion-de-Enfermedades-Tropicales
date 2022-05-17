package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.PersonalTecnico;
import Model.POJO.Equipo;
import Model.POJO.EquipoEliminado;
import Presenter.GestionEquipos.PresenterGestionEquipos;
import View.Utilitarios.Utilidades;
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
public class EliminarEquipo extends javax.swing.JDialog implements PresenterGestionEquipos.CallBackEliminarEquipo {

    private final PresenterGestionEquipos presenterGestionEquipos;
    private Equipo equipo;

    public EliminarEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionEquipos.setCallBackEliminarEquipo(this);
        JBTNEliminar.addActionListener(action);
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JLBLEquipoNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JLBLEquipoMarca = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLEquipoModelo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLEquipoNumeroSerie = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JDTCHOOSERFechaEliminacion = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREAMotivoEliminacion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNHoraEliminacion = new javax.swing.JSpinner(spinnerDateModel);
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLBLResponsableEliminacionEquipo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLContadorMotivoEliminacion = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Eliminar Equipo");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Equipo"));

        jLabel5.setText("NOMBRE:");

        JLBLEquipoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("MARCA:");

        JLBLEquipoMarca.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("MODELO:");

        JLBLEquipoModelo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("NUMERO DE SERIE:");
        jLabel7.setToolTipText("");

        JLBLEquipoNumeroSerie.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(JLBLEquipoMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JLBLEquipoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(JLBLEquipoNumeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(JLBLEquipoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLEquipoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLEquipoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLEquipoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Eliminación"));

        jLabel2.setText("FECHA DE ELIMINACION:");

        JDTCHOOSERFechaEliminacion.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaEliminacion.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERFechaEliminacion.setMaxSelectableDate(Calendar.getInstance().getTime());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTXTAREAMotivoEliminacion.setColumns(20);
        JTXTAREAMotivoEliminacion.setLineWrap(true);
        JTXTAREAMotivoEliminacion.setRows(5);
        JTXTAREAMotivoEliminacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAMotivoEliminacionFocusGained(evt);
            }
        });
        JTXTAREAMotivoEliminacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAMotivoEliminacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAMotivoEliminacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAMotivoEliminacionKeyTyped(evt);
            }
        });
        JTXTAREAMotivoEliminacion.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREAMotivoEliminacion);

        jLabel9.setText("MOTIVO DE ELIMINACION:");

        JSPNHoraEliminacion.setEditor(new JSpinner.DateEditor(JSPNHoraEliminacion, "HH:mm:ss"));

        jLabel4.setText("HORA DE ELIMINACION:");

        jLabel6.setText("RESPONSABLE DE ELIMINACION:");

        JLBLResponsableEliminacionEquipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("/150");

        JLBLContadorMotivoEliminacion.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDTCHOOSERFechaEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JSPNHoraEliminacion, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JLBLContadorMotivoEliminacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JLBLResponsableEliminacionEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLResponsableEliminacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JDTCHOOSERFechaEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPNHoraEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(JLBLContadorMotivoEliminacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNEliminar.setText("ELIMINAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNEliminar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNEliminar))
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
            } else {
                final PersonalTecnico personalTecnico = Utilidades.obtenerCuentaLocal().getPersonalTecnico();

                if (personalTecnico == null) {
                    JOptionPane.showMessageDialog(this, "Se produjo un error al obtener los datos del personal técnico, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                    dispose();
                } else {
                    JLBLEquipoNombre.setText(equipo.getEquipoNombre());
                    JLBLEquipoMarca.setText(equipo.getEquipoMarca());
                    JLBLEquipoModelo.setText(equipo.getEquipoModelo());
                    JLBLEquipoNumeroSerie.setText(equipo.getEquipoNumeroSerie());
                    JLBLResponsableEliminacionEquipo.setText(personalTecnico.getPersona().getPersonaApellido() + " " + personalTecnico.getPersona().getPersonaNombre());
                }
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTAREAMotivoEliminacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAMotivoEliminacionKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9.ñÑ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAMotivoEliminacion.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAMotivoEliminacionKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTAREAMotivoEliminacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAMotivoEliminacionKeyReleased
        JLBLContadorMotivoEliminacion.setText(String.valueOf(JTXTAREAMotivoEliminacion.getText().length()));
    }//GEN-LAST:event_JTXTAREAMotivoEliminacionKeyReleased

    private void JTXTAREAMotivoEliminacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAMotivoEliminacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAMotivoEliminacionKeyPressed

    private void JTXTAREAMotivoEliminacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAMotivoEliminacionFocusGained
        JTXTAREAMotivoEliminacion.selectAll();
    }//GEN-LAST:event_JTXTAREAMotivoEliminacionFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            EliminarEquipo dialog = new EliminarEquipo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNEliminar;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaEliminacion;
    private javax.swing.JLabel JLBLContadorMotivoEliminacion;
    private javax.swing.JLabel JLBLEquipoMarca;
    private javax.swing.JLabel JLBLEquipoModelo;
    private javax.swing.JLabel JLBLEquipoNombre;
    private javax.swing.JLabel JLBLEquipoNumeroSerie;
    private javax.swing.JLabel JLBLResponsableEliminacionEquipo;
    private javax.swing.JSpinner JSPNHoraEliminacion;
    private javax.swing.JTextArea JTXTAREAMotivoEliminacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                final Date fechaEliminacion = JDTCHOOSERFechaEliminacion.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaEliminacion.getDate()));
                final Time horaEliminacion = Time.valueOf(new JSpinner.DateEditor(JSPNHoraEliminacion, "HH:mm:ss").getFormat().format(JSPNHoraEliminacion.getValue()));
                final String motivoEliminacion = JTXTAREAMotivoEliminacion.getText();

                if (fechaEliminacion == null) {
                    JOptionPane.showMessageDialog(null, "Ingresa la fecha de elimación del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (motivoEliminacion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el motivo de la eliminación del equipo.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final EquipoEliminado equipoEliminado = new EquipoEliminado(equipo, fechaEliminacion, horaEliminacion, motivoEliminacion);
                    presenterGestionEquipos.eliminarEquipo(equipoEliminado);
                }
            } catch (final HeadlessException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error eliminar equipo: " + exception.getMessage());
            }
        }
    };
    
    @Override
    public void equipoEliminado(final String msg) {
        dispose();
    }

    @Override
    public void errorEliminarEquipo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarEquipo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
package View.GestionPacientes;

import Model.POJO.ExamenSolicitado;
import Model.POJO.Paciente;
import Model.POJO.SeguimientoPaciente;
import Model.POJOPersonalizado.SeguimientoPacientePersonalizado;
import Presenter.GestionPacientes.PresenterGestionPacientes;
import Presenter.GestionPacientes.PresenterGestionSeguimientoPaciente;
import View.GestionRecepciones.VerResultadosIngresados;
import View.Utilitarios.ModelTable.GestionPacientes.TableModelVerSeguimientos;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Brynner
 */
public class VerSeguimientos extends javax.swing.JDialog implements PresenterGestionPacientes.CallBackObtenerSeguimientos, PresenterGestionSeguimientoPaciente.CallBackObtenerAntecedente {
    
    private final TableModelVerSeguimientos tableModelVerSeguimientos;
    private final PresenterGestionPacientes presenterGestionPacientes;
    private final PresenterGestionSeguimientoPaciente presenterGestionSeguimientoPaciente;
    private Paciente paciente;
    
    public VerSeguimientos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        tableModelVerSeguimientos = new TableModelVerSeguimientos();
        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionSeguimientoPaciente = new PresenterGestionSeguimientoPaciente();
        presenterGestionPacientes.setCallBackObtenerSeguimientos(this);
        presenterGestionSeguimientoPaciente.setCallBackObtenerAntecedente(this);
        
        initComponents();
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemSeguimientoPaciente = new javax.swing.JPopupMenu();
        JMENUITEMVerDetalles = new javax.swing.JMenuItem();
        JMENUITEMVerControles = new javax.swing.JMenuItem();
        JMENUITEMVerAntecedente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMFinalizarSeguimiento = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLPacienteNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLPacienteFechaNacimiento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLPacienteApellido = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLPacienteSexo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLSeguimientosPaciente = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMVerDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerDetalles.setText("Ver Detalles");
        JMENUITEMVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSeguimientoPaciente.add(JMENUITEMVerDetalles);

        JMENUITEMVerControles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerControles.setText("Ver Controles");
        JMENUITEMVerControles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerControlesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSeguimientoPaciente.add(JMENUITEMVerControles);

        JMENUITEMVerAntecedente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerAntecedente.setText("Ver Antecedente");
        JMENUITEMVerAntecedente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerAntecedenteActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSeguimientoPaciente.add(JMENUITEMVerAntecedente);
        JPOPUPMENUItemSeguimientoPaciente.add(jSeparator1);

        JMENUITEMFinalizarSeguimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/finalizar_seguimiento.png"))); // NOI18N
        JMENUITEMFinalizarSeguimiento.setText("Finalizar Seguimiento");
        JMENUITEMFinalizarSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMFinalizarSeguimientoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSeguimientoPaciente.add(JMENUITEMFinalizarSeguimiento);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Seguimientos del Paciente");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));

        jLabel1.setText("NOMBRE:");

        JLBLPacienteNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("FECHA NACIMIENTO:");

        JLBLPacienteFechaNacimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("APELLIDO:");

        JLBLPacienteApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("SEXO:");

        JLBLPacienteSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLPacienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(JLBLPacienteApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JLBLPacienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLPacienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLPacienteApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLPacienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seguimientos del Paciente"));

        JTBLSeguimientosPaciente.setModel(tableModelVerSeguimientos);
        JTBLSeguimientosPaciente.setComponentPopupMenu(JPOPUPMENUItemSeguimientoPaciente);
        JTBLSeguimientosPaciente.setRowHeight(20);
        JTBLSeguimientosPaciente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLSeguimientosPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLSeguimientosPacienteMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);

        JTBLSeguimientosPaciente.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(1).setPreferredWidth(180);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(2).setPreferredWidth(80);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(3).setPreferredWidth(80);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTBLSeguimientosPaciente.getColumnModel().getColumn(5).setPreferredWidth(80);
        jScrollPane1.setViewportView(JTBLSeguimientosPaciente);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLPacienteApellido.setText(paciente.getPersona().getPersonaApellido());
                JLBLPacienteNombre.setText(paciente.getPersona().getPersonaNombre());
                JLBLPacienteFechaNacimiento.setText(paciente.getPacienteFechaNacimiento().toString());
                JLBLPacienteSexo.setText(paciente.getPersona().getPersonaSexo().equals("M") ? "MASCULINO" : "FEMENINO");
                
                presenterGestionPacientes.obtenerSeguimientos(paciente);
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLSeguimientosPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLSeguimientosPacienteMousePressed
        final int currentRow = JTBLSeguimientosPaciente.rowAtPoint(evt.getPoint());
        JTBLSeguimientosPaciente.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLSeguimientosPacienteMousePressed

    private void JMENUITEMVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesActionPerformed
        final VerDetallesSeguimiento verDetallesSeguimiento = new VerDetallesSeguimiento(null, true);
        verDetallesSeguimiento.setSeguimientoPaciente(obtenerSeguimientoPacienteSeleccionado());
        verDetallesSeguimiento.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesActionPerformed

    private void JMENUITEMVerControlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerControlesActionPerformed
        final VerControles verControles = new VerControles(null, true);
        verControles.setSeguimientoPaciente(obtenerSeguimientoPacienteSeleccionado());
        verControles.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerControlesActionPerformed

    private void JMENUITEMVerAntecedenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerAntecedenteActionPerformed
        presenterGestionSeguimientoPaciente.ObtenerAntecedente(obtenerSeguimientoPacienteSeleccionado());
    }//GEN-LAST:event_JMENUITEMVerAntecedenteActionPerformed

    private void JMENUITEMFinalizarSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMFinalizarSeguimientoActionPerformed
        final SeguimientoPaciente seguimientoPaciente = obtenerSeguimientoPacienteSeleccionado();
        
        if (seguimientoPaciente.getProgreso().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "El seguimiento ya está finalizado", "SIET", JOptionPane.ERROR_MESSAGE);
        } else {
            final FinalizarSeguimiento finalizarSeguimiento = new FinalizarSeguimiento(null, true);
            finalizarSeguimiento.setSeguimientoPaciente(obtenerSeguimientoPacienteSeleccionado());
            finalizarSeguimiento.setVisible(true);
            
            if (!finalizarSeguimiento.isVisible()) {
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_JMENUITEMFinalizarSeguimientoActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerSeguimientos dialog = new VerSeguimientos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLPacienteApellido;
    private javax.swing.JLabel JLBLPacienteFechaNacimiento;
    private javax.swing.JLabel JLBLPacienteNombre;
    private javax.swing.JLabel JLBLPacienteSexo;
    private javax.swing.JMenuItem JMENUITEMFinalizarSeguimiento;
    private javax.swing.JMenuItem JMENUITEMVerAntecedente;
    private javax.swing.JMenuItem JMENUITEMVerControles;
    private javax.swing.JMenuItem JMENUITEMVerDetalles;
    private javax.swing.JPopupMenu JPOPUPMENUItemSeguimientoPaciente;
    private javax.swing.JTable JTBLSeguimientosPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelVerSeguimientos.limpiarLista();
        presenterGestionPacientes.obtenerSeguimientos(paciente);
    }
    
    private SeguimientoPaciente obtenerSeguimientoPacienteSeleccionado() {
        final int rowModel = JTBLSeguimientosPaciente.convertRowIndexToModel(JTBLSeguimientosPaciente.getSelectedRow());
        return tableModelVerSeguimientos.getSeguimientoPacientePersonalizado(rowModel).getSeguimientoPaciente();
    }
    
    @Override
    public void seguimientosObtenido(final List<SeguimientoPacientePersonalizado> seguimientosPacientePersonalizado) {
        tableModelVerSeguimientos.setSeguimientosPacientePersonalizados(seguimientosPacientePersonalizado);
        JTBLSeguimientosPaciente.getTableHeader().setReorderingAllowed(false);
    }
    
    @Override
    public void listaSeguimientosVacias(final String msg) {
    }
    
    @Override
    public void errorObtenerSeguimientos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void errorDesconocidoObtenerSeguimientos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void antecedenteObtenido(final ExamenSolicitado examenSolicitado) {
        final VerResultadosIngresados verResultadosIngresados = new VerResultadosIngresados(null, true);
        verResultadosIngresados.setExamenSolicitado(examenSolicitado);
        verResultadosIngresados.setVisible(true);
    }
    
    @Override
    public void errorObtenerAntecedente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void errorDesconocidoObtenerAntecedente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}

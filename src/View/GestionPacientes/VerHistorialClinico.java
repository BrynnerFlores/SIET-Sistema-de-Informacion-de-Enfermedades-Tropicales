package View.GestionPacientes;

import Model.POJO.Paciente;
import Model.POJO.Recepcion;
import Model.POJOPersonalizado.RecepcionPersonalizada;
import Presenter.GestionPacientes.PresenterGestionPacientes;
import View.GestionRecepciones.VerDetallesRecepcion;
import View.Utilitarios.ModelTable.GestionPacientes.TableModelVerHistorialClinico;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Brynner
 */
public class VerHistorialClinico extends javax.swing.JDialog implements PresenterGestionPacientes.CallBackObtenerHistorialClinico {

    private final TableModelVerHistorialClinico tableModelVerHistorialClinico;
    private final PresenterGestionPacientes presenterGestionPacientes;

    private Paciente paciente;

    public VerHistorialClinico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        tableModelVerHistorialClinico = new TableModelVerHistorialClinico();
        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionPacientes.setCallBackObtenerHistorialClinico(this);

        initComponents();
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemRecpcion = new javax.swing.JPopupMenu();
        JMENUITEMVerDetallesRecepcion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLPacienteCedulaIdentidad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLPacienteApellidos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLPacienteNombres = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLPacienteFechaNacimiento = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLBLPacienteSexo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLRecepciones = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMVerDetallesRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerDetallesRecepcion.setText("Ver Detalles de Recepción");
        JMENUITEMVerDetallesRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesRecepcionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRecpcion.add(JMENUITEMVerDetallesRecepcion);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Historial Clínico");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));

        jLabel1.setText("CEDULA DE IDENTIDAD:");

        JLBLPacienteCedulaIdentidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("APELLIDO(S):");

        JLBLPacienteApellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("NOMBRE(S):");

        JLBLPacienteNombres.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("FECHA DE NACIMIENTO:");

        JLBLPacienteFechaNacimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("SEXO:");

        JLBLPacienteSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLBLPacienteCedulaIdentidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(JLBLPacienteApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(JLBLPacienteNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(JLBLPacienteSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLPacienteCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLPacienteNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLPacienteApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLPacienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepciones"));

        JTBLRecepciones.setModel(tableModelVerHistorialClinico);
        JTBLRecepciones.setComponentPopupMenu(JPOPUPMENUItemRecpcion);
        JTBLRecepciones.setRowHeight(20);
        JTBLRecepciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLRecepciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLRecepcionesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLRecepciones.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLRecepciones.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);

        JTBLRecepciones.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLRecepciones.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTBLRecepciones.getColumnModel().getColumn(2).setPreferredWidth(50);
        JTBLRecepciones.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLRecepciones.getColumnModel().getColumn(4).setPreferredWidth(200);
        JTBLRecepciones.getColumnModel().getColumn(5).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLRecepciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTNActualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                JLBLPacienteCedulaIdentidad.setText(paciente.getPersona().getPersonaCedulaIdentidad());
                JLBLPacienteApellidos.setText(paciente.getPersona().getPersonaApellido());
                JLBLPacienteNombres.setText(paciente.getPersona().getPersonaNombre());
                JLBLPacienteFechaNacimiento.setText(paciente.getPacienteFechaNacimiento().toString());
                JLBLPacienteSexo.setText(paciente.getPersona().getPersonaSexo().equals("M") ? "MASCULINO" : "FEMENINO");

                presenterGestionPacientes.obtenerHistorialClinico(paciente);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLRecepcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLRecepcionesMousePressed
        final int currentRow = JTBLRecepciones.rowAtPoint(evt.getPoint());
        JTBLRecepciones.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLRecepcionesMousePressed

    private void JMENUITEMVerDetallesRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesRecepcionActionPerformed
        final VerDetallesRecepcion verDetallesRecepcion = new VerDetallesRecepcion(null, true);
        verDetallesRecepcion.setHabilitarModificacion(false);
        verDetallesRecepcion.setRecepcion(obtenerRecepcionSeleccionada());
        verDetallesRecepcion.setVisible(true);

        if (!verDetallesRecepcion.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerDetallesRecepcionActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerHistorialClinico dialog = new VerHistorialClinico(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLPacienteApellidos;
    private javax.swing.JLabel JLBLPacienteCedulaIdentidad;
    private javax.swing.JLabel JLBLPacienteFechaNacimiento;
    private javax.swing.JLabel JLBLPacienteNombres;
    private javax.swing.JLabel JLBLPacienteSexo;
    private javax.swing.JMenuItem JMENUITEMVerDetallesRecepcion;
    private javax.swing.JPopupMenu JPOPUPMENUItemRecpcion;
    private javax.swing.JTable JTBLRecepciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelVerHistorialClinico.limpiarLista();
        presenterGestionPacientes.obtenerHistorialClinico(paciente);
    }

    private Recepcion obtenerRecepcionSeleccionada() {
        final int rowModel = JTBLRecepciones.convertRowIndexToModel(JTBLRecepciones.getSelectedRow());
        return tableModelVerHistorialClinico.getRecepcionPersonalizada(rowModel).getRecepcion();
    }

    @Override
    public void historialClinicoObtenido(final List<RecepcionPersonalizada> recepcionesPersonalizadas) {
        tableModelVerHistorialClinico.setRecepcionesPersonalizadas(recepcionesPersonalizadas);
        JTBLRecepciones.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaHistorialClinicoVacias(final String msg) {
    }

    @Override
    public void errorObtenerHistorialClinico(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerHistorialClinico(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
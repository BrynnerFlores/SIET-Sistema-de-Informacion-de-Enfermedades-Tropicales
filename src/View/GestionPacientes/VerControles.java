package View.GestionPacientes;

import Model.POJO.ExamenSolicitado;
import Model.POJO.SeguimientoPaciente;
import Presenter.GestionPacientes.PresenterGestionSeguimientoPaciente;
import View.GestionRecepciones.VerResultadosIngresados;
import View.Utilitarios.ModelTable.GestionPacientes.TableModelVerControles;
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
public class VerControles extends javax.swing.JDialog implements PresenterGestionSeguimientoPaciente.CallBackResolucionInversaDeExamenSolicitado {
    
    private final TableModelVerControles tableModelVerControles;
    private final PresenterGestionSeguimientoPaciente presenterGestionSeguimientoPaciente;
    
    private SeguimientoPaciente seguimientoPaciente;
    
    public VerControles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        tableModelVerControles = new TableModelVerControles();
        presenterGestionSeguimientoPaciente = new PresenterGestionSeguimientoPaciente();
        presenterGestionSeguimientoPaciente.setCallBackResolucionInversaDeExamenSolicitado(this);
        
        initComponents();
    }

    public void setSeguimientoPaciente(SeguimientoPaciente seguimientoPaciente) {
        this.seguimientoPaciente = seguimientoPaciente;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemControlSeguimiento = new javax.swing.JPopupMenu();
        JMENUITEMVerResultados = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLExamen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLBLEstadoSeguimiento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLFechaInicioSeguimiento = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLHoraInicioSeguimiento = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLControlesSeguimiento = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMVerResultados.setText("Ver Resultados");
        JMENUITEMVerResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerResultadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemControlSeguimiento.add(JMENUITEMVerResultados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Controles");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Seguimiento"));

        jLabel1.setText("EXAMEN:");

        JLBLExamen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ESTADO DEL SEGUIMIENTO:");

        JLBLEstadoSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("FECHA INICIO DEL SEGUIMIENTO:");

        JLBLFechaInicioSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("HORA INICIO DEL SEGUIMIENTO:");

        JLBLHoraInicioSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JLBLEstadoSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLFechaInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JLBLHoraInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLEstadoSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLFechaInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraInicioSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        JTBLControlesSeguimiento.setModel(tableModelVerControles);
        JTBLControlesSeguimiento.setComponentPopupMenu(JPOPUPMENUItemControlSeguimiento);
        JTBLControlesSeguimiento.setRowHeight(20);
        JTBLControlesSeguimiento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLControlesSeguimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLControlesSeguimientoMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLControlesSeguimiento.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLControlesSeguimiento.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLControlesSeguimiento.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLControlesSeguimiento.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);

        JTBLControlesSeguimiento.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLControlesSeguimiento.getColumnModel().getColumn(1).setPreferredWidth(200);
        JTBLControlesSeguimiento.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTBLControlesSeguimiento.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTBLControlesSeguimiento.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTBLControlesSeguimiento.getColumnModel().getColumn(5).setPreferredWidth(150);
        jScrollPane1.setViewportView(JTBLControlesSeguimiento);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(18, 18, 18)
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
            if (seguimientoPaciente == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLExamen.setText(seguimientoPaciente.getExamen().getExamenNombre());
                JLBLEstadoSeguimiento.setText(seguimientoPaciente.getProgreso());
                JLBLFechaInicioSeguimiento.setText(seguimientoPaciente.getFechaInicio().toString());
                JLBLHoraInicioSeguimiento.setText(seguimientoPaciente.getHoraInicio().toString());
                
                presenterGestionSeguimientoPaciente.resolucionInversaDeExamenSolicitado(seguimientoPaciente);
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLControlesSeguimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLControlesSeguimientoMousePressed
        final int currentRow = JTBLControlesSeguimiento.rowAtPoint(evt.getPoint());
        JTBLControlesSeguimiento.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLControlesSeguimientoMousePressed

    private void JMENUITEMVerResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerResultadosActionPerformed
        final VerResultadosIngresados verResultadosIngresados = new VerResultadosIngresados(null, true);
        verResultadosIngresados.setExamenSolicitado(obtenerExamenSolicitadoSeleccionado());
        verResultadosIngresados.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerResultadosActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerControles dialog = new VerControles(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLEstadoSeguimiento;
    private javax.swing.JLabel JLBLExamen;
    private javax.swing.JLabel JLBLFechaInicioSeguimiento;
    private javax.swing.JLabel JLBLHoraInicioSeguimiento;
    private javax.swing.JMenuItem JMENUITEMVerResultados;
    private javax.swing.JPopupMenu JPOPUPMENUItemControlSeguimiento;
    private javax.swing.JTable JTBLControlesSeguimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private ExamenSolicitado obtenerExamenSolicitadoSeleccionado() {
        final int rowModel = JTBLControlesSeguimiento.convertRowIndexToModel(JTBLControlesSeguimiento.getSelectedRow());
        return tableModelVerControles.getExamenSolicitado(rowModel);
    }
    
    private void actualizarTabla() {
        tableModelVerControles.limpiarLista();
        presenterGestionSeguimientoPaciente.resolucionInversaDeExamenSolicitado(seguimientoPaciente);
    }
    
    @Override
    public void examenesSolicitadosResueltos(final List<ExamenSolicitado> examenesSolicitados) {
        tableModelVerControles.setExamenesSolcitados(examenesSolicitados);
        JTBLControlesSeguimiento.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaExamenesSolicitadosVacia(final String msg) {
    }

    @Override
    public void errorResolucionExamenesSolicitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void errorDesconocidoResolucionExamenesSolicitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }
}
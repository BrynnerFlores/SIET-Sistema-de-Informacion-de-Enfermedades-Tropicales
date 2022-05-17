package View.GestionReactivos;

import Model.POJO.LoteEliminado;
import Model.POJO.ReactivoEntrega;
import Presenter.GestionReactivos.PresenterGestionReactivosEntregas;
import View.Utilitarios.ModelTable.GestionReactivos.TableModelLotesEliminados;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brynner
 */
public class VerLotesEliminados extends javax.swing.JDialog implements PresenterGestionReactivosEntregas.CallBackObtenerLotesEliminados {

    private final TableModelLotesEliminados tableModelLotesEliminados;
    private final PresenterGestionReactivosEntregas presenterGestionReactivosEntregas;
    
    private ReactivoEntrega reactivoEntrega;

    public VerLotesEliminados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionReactivosEntregas = new PresenterGestionReactivosEntregas();
        presenterGestionReactivosEntregas.setCallBackObtenerLotesEliminados(this);

        tableModelLotesEliminados = new TableModelLotesEliminados();

        initComponents();
    }

    public void setReactivoEntrega(ReactivoEntrega reactivoEntrega) {
        this.reactivoEntrega = reactivoEntrega;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemReactivoLote = new javax.swing.JPopupMenu();
        JMENUITEMVerDetallesConsumo = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLBioquimico = new javax.swing.JLabel();
        JLBLProveedor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLBLFechaEntrega = new javax.swing.JLabel();
        JLBLHoraEntrega = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLLotesEliminados = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNCerrar = new javax.swing.JButton();

        JMENUITEMVerDetallesConsumo.setText("Ver Detalles de Consumo");
        JMENUITEMVerDetallesConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesConsumoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemReactivoLote.add(JMENUITEMVerDetallesConsumo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Lotes Eliminados");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Entrega"));

        jLabel1.setText("ENTREGADO A:");

        jLabel2.setText("RECIBIDO DE:");

        JLBLBioquimico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("FECHA DE ENTREGA:");

        jLabel6.setText("HORA DE ENTREGA:");

        JLBLFechaEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLHoraEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLBLBioquimico, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLBLProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLBLFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLBLHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLBioquimico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBLFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lotes Eliminados"));

        JTBLLotesEliminados.setModel(tableModelLotesEliminados);
        JTBLLotesEliminados.setComponentPopupMenu(JPOPUPMENUItemReactivoLote);
        JTBLLotesEliminados.setRowHeight(20);
        JTBLLotesEliminados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLLotesEliminadosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLLotesEliminados.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLLotesEliminados.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLLotesEliminados.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);

        JTBLLotesEliminados.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLLotesEliminados.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTBLLotesEliminados.getColumnModel().getColumn(2).setPreferredWidth(250);
        JTBLLotesEliminados.getColumnModel().getColumn(3).setPreferredWidth(50);
        JTBLLotesEliminados.getColumnModel().getColumn(4).setPreferredWidth(50);
        jScrollPane1.setViewportView(JTBLLotesEliminados);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.setToolTipText("");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNCerrar)
                .addGap(18, 18, 18)
                .addComponent(JBTNActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNCerrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                JLBLBioquimico.setText(reactivoEntrega.getPersonalTecnico().getPersona().getPersonaApellido() + " " + reactivoEntrega.getPersonalTecnico().getPersona().getPersonaNombre());
                JLBLProveedor.setText(reactivoEntrega.getProveedor());
                JLBLFechaEntrega.setText(reactivoEntrega.getFechaEntrega().toString());
                JLBLHoraEntrega.setText(reactivoEntrega.getHoraEntrega().toString());

                presenterGestionReactivosEntregas.obtenerLotesEliminados(reactivoEntrega);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLLotesEliminadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLLotesEliminadosMousePressed
        final int currentRow = JTBLLotesEliminados.rowAtPoint(evt.getPoint());
        JTBLLotesEliminados.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLLotesEliminadosMousePressed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JMENUITEMVerDetallesConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesConsumoActionPerformed
        final VerDetallesConsumo verDetallesConsumo = new VerDetallesConsumo(null, true);
        verDetallesConsumo.setReactivoLote(obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote());
        verDetallesConsumo.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesConsumoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerLotesEliminados dialog = new VerLotesEliminados(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLBioquimico;
    private javax.swing.JLabel JLBLFechaEntrega;
    private javax.swing.JLabel JLBLHoraEntrega;
    private javax.swing.JLabel JLBLProveedor;
    private javax.swing.JMenuItem JMENUITEMVerDetallesConsumo;
    private javax.swing.JPopupMenu JPOPUPMENUItemReactivoLote;
    private javax.swing.JTable JTBLLotesEliminados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelLotesEliminados.limpiarLista();
        presenterGestionReactivosEntregas.obtenerLotesEliminados(reactivoEntrega);
    }
    
    private LoteEliminado obtenerReactivoLotePersonalizadoSeleccionado() {
        final int rowModel = JTBLLotesEliminados.convertRowIndexToModel(JTBLLotesEliminados.getSelectedRow());
        return tableModelLotesEliminados.getLoteEliminado(rowModel);
    }
    
    @Override
    public void lotesEliminadosObtenidos(final List<LoteEliminado> lotesEliminados) {
        tableModelLotesEliminados.setLotesEliminados(lotesEliminados);
        JTBLLotesEliminados.setRowSorter(new TableRowSorter<>(tableModelLotesEliminados));
        JTBLLotesEliminados.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaLotesEliminadosVacia(final String msg) {
    }

    @Override
    public void errorObtenerLotesEliminados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerLotesEliminados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
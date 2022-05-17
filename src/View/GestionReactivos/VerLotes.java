package View.GestionReactivos;

import Model.POJO.Reactivo;
import Model.POJO.ReactivoLote;
import Model.POJOPersonalizado.ReactivoLotePersonalizado;
import Presenter.GestionReactivos.PresenterGestionReactivos;
import Presenter.GestionReactivos.PresenterGestionReactivosLotes;
import View.Utilitarios.ModelTable.GestionReactivos.TableModelDetallesReactivo;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brynner
 */
public class VerLotes extends javax.swing.JDialog implements PresenterGestionReactivos.CallBackObtenerLotes, PresenterGestionReactivosLotes.CallBackVerificarLoteAgotado, PresenterGestionReactivosLotes.CallBackVerificarLoteConsumoIniciado, PresenterGestionReactivosLotes.CallBackVerificarLotesConsumoIniciado, PresenterGestionReactivosLotes.CallBackIniciarConsumo, PresenterGestionReactivosLotes.CallBackDetenerConsumo {

    private final TableModelDetallesReactivo tableModelDetallesReactivo;
    private final PresenterGestionReactivos presenterGestionReactivos;
    private final PresenterGestionReactivosLotes presenterGestionReactivosLotes;
    
    private Reactivo reactivo;

    public VerLotes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionReactivos = new PresenterGestionReactivos();
        presenterGestionReactivosLotes = new PresenterGestionReactivosLotes();
        presenterGestionReactivos.setCallBackObtenerLotes(this);
        presenterGestionReactivosLotes.setCallBackVerificarLoteAgotado(this);
        presenterGestionReactivosLotes.setCallBackVerificarLoteConsumoIniciado(this);
        presenterGestionReactivosLotes.setCallBackVerificarLotesConsumoIniciado(this);
        presenterGestionReactivosLotes.setCallBackIniciarConsumo(this);
        presenterGestionReactivosLotes.setCallBackDetenerConsumo(this);

        tableModelDetallesReactivo = new TableModelDetallesReactivo();

        initComponents();
    }

    public void setReactivo(Reactivo reactivo) {
        this.reactivo = reactivo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemRegistroEntrega = new javax.swing.JPopupMenu();
        JMENUITEMIniciarConsumo = new javax.swing.JMenuItem();
        JMENUITEMDetenerConsumo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEliminarLote = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEliminarUnidad = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerDetallesConsumo = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLReactivo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEntregas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMIniciarConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/iniciar.png"))); // NOI18N
        JMENUITEMIniciarConsumo.setText("Iniciar Consumo");
        JMENUITEMIniciarConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMIniciarConsumoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRegistroEntrega.add(JMENUITEMIniciarConsumo);

        JMENUITEMDetenerConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/stop.png"))); // NOI18N
        JMENUITEMDetenerConsumo.setText("Detener Consumo");
        JMENUITEMDetenerConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMDetenerConsumoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRegistroEntrega.add(JMENUITEMDetenerConsumo);
        JPOPUPMENUItemRegistroEntrega.add(jSeparator1);

        JMENUITEMEliminarLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarLote.setText("Eliminar Lote");
        JMENUITEMEliminarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarLoteActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRegistroEntrega.add(JMENUITEMEliminarLote);
        JPOPUPMENUItemRegistroEntrega.add(jSeparator2);

        JMENUITEMEliminarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarUnidad.setText("Eliminar Unidad");
        JMENUITEMEliminarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarUnidadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRegistroEntrega.add(JMENUITEMEliminarUnidad);
        JPOPUPMENUItemRegistroEntrega.add(jSeparator3);

        JMENUITEMVerDetallesConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerDetallesConsumo.setText("Ver Detalles de Consumo");
        JMENUITEMVerDetallesConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesConsumoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemRegistroEntrega.add(JMENUITEMVerDetallesConsumo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Lotes");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Reactivo"));

        jLabel1.setText("REACTIVO:");

        JLBLReactivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JLBLReactivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lotes"));

        JTBLEntregas.setModel(tableModelDetallesReactivo);
        JTBLEntregas.setComponentPopupMenu(JPOPUPMENUItemRegistroEntrega);
        JTBLEntregas.setRowHeight(20);
        JTBLEntregas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLEntregas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLEntregasMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLEntregas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(8).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(9).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregas.getColumnModel().getColumn(10).setCellRenderer(defaultTableCellRenderer);

        JTBLEntregas.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLEntregas.getColumnModel().getColumn(1).setPreferredWidth(50);
        JTBLEntregas.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLEntregas.getColumnModel().getColumn(3).setPreferredWidth(150);
        JTBLEntregas.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTBLEntregas.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTBLEntregas.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTBLEntregas.getColumnModel().getColumn(7).setPreferredWidth(100);
        JTBLEntregas.getColumnModel().getColumn(8).setPreferredWidth(100);
        JTBLEntregas.getColumnModel().getColumn(9).setPreferredWidth(100);
        JTBLEntregas.getColumnModel().getColumn(10).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLEntregas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNCerrar)
                .addGap(18, 18, 18)
                .addComponent(JBTNActualizar)
                .addContainerGap(1104, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (reactivo == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLReactivo.setText(reactivo.getNombre());
                presenterGestionReactivos.obtenerLotes(reactivo);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLEntregasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLEntregasMousePressed
        final int currentRow = JTBLEntregas.rowAtPoint(evt.getPoint());
        JTBLEntregas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLEntregasMousePressed

    private void JMENUITEMVerDetallesConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesConsumoActionPerformed
        final VerDetallesConsumo verDetallesConsumo = new VerDetallesConsumo(null, true);
        verDetallesConsumo.setReactivoLote(obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote());
        verDetallesConsumo.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesConsumoActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JMENUITEMEliminarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarLoteActionPerformed
        final ReactivoLotePersonalizado reactivoLotePersonalizado = obtenerReactivoLotePersonalizadoSeleccionado();

        if (reactivoLotePersonalizado.getSaldo() > 0) {
            final EliminarLote eliminarLote = new EliminarLote(null, true);
            eliminarLote.setReactivoLote(obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote());
            eliminarLote.setVisible(true);

            if (!eliminarLote.isVisible()) {
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se puede eliminar el lote, todas las unidades ya fueron consumidas.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEliminarLoteActionPerformed

    private void JMENUITEMIniciarConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMIniciarConsumoActionPerformed
        final boolean isLoteVencido = verificarLoteVencido();

        if (isLoteVencido) {
            JOptionPane.showMessageDialog(rootPane, "No se puede iniciar, el lote esta vencido.", "SIET", JOptionPane.ERROR_MESSAGE);
        } else {
            presenterGestionReactivosLotes.iniciarConsumo(obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote());
        }
    }//GEN-LAST:event_JMENUITEMIniciarConsumoActionPerformed

    private void JMENUITEMDetenerConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMDetenerConsumoActionPerformed
        final boolean isLoteVencido = verificarLoteVencido();

        if (isLoteVencido) {
            JOptionPane.showMessageDialog(rootPane, "No se puede detener, el lote esta vencido.", "SIET", JOptionPane.ERROR_MESSAGE);
        } else {
            presenterGestionReactivosLotes.detenerConsumo(obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote());
        }
    }//GEN-LAST:event_JMENUITEMDetenerConsumoActionPerformed

    private void JMENUITEMEliminarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarUnidadActionPerformed
        final ReactivoLotePersonalizado reactivoLotePersonalizado = obtenerReactivoLotePersonalizadoSeleccionado();

        if (reactivoLotePersonalizado.getSaldo() > 0) {
            final boolean isLoteVencido = verificarLoteVencido();

            if (isLoteVencido) {
                JOptionPane.showMessageDialog(rootPane, "No se puede eliminar una unidad, el lote esta vencido.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final EliminarUnidad eliminarUnidad = new EliminarUnidad(null, true);
                eliminarUnidad.setReactivoLote(obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote());
                eliminarUnidad.setTotalSaldo(obtenerReactivoLotePersonalizadoSeleccionado().getSaldo());
                eliminarUnidad.setVisible(true);

                if (!eliminarUnidad.isVisible()) {
                    actualizarTabla();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se puede eliminar una unidad, todas las unidades ya fueron consumidas.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JMENUITEMEliminarUnidadActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerLotes dialog = new VerLotes(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLReactivo;
    private javax.swing.JMenuItem JMENUITEMDetenerConsumo;
    private javax.swing.JMenuItem JMENUITEMEliminarLote;
    private javax.swing.JMenuItem JMENUITEMEliminarUnidad;
    private javax.swing.JMenuItem JMENUITEMIniciarConsumo;
    private javax.swing.JMenuItem JMENUITEMVerDetallesConsumo;
    private javax.swing.JPopupMenu JPOPUPMENUItemRegistroEntrega;
    private javax.swing.JTable JTBLEntregas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelDetallesReactivo.limpiarLista();
        presenterGestionReactivos.obtenerLotes(reactivo);
    }

    private ReactivoLotePersonalizado obtenerReactivoLotePersonalizadoSeleccionado() {
        final int rowModel = JTBLEntregas.convertRowIndexToModel(JTBLEntregas.getSelectedRow());
        return tableModelDetallesReactivo.getReactivoLotePersonalizado(rowModel);
    }

    private boolean verificarLoteVencido() {
        final ReactivoLote reactivoLote = obtenerReactivoLotePersonalizadoSeleccionado().getReactivoLote();

        return reactivoLote.getFechaVencimiento().before(Calendar.getInstance().getTime());
    }

    @Override
    public void lotesObtenidos(final List<ReactivoLotePersonalizado> reactivosLotesPersonalizados) {
        tableModelDetallesReactivo.setReactivosLotesPersonalizados(reactivosLotesPersonalizados);
        JTBLEntregas.setRowSorter(new TableRowSorter<>(tableModelDetallesReactivo));
        JTBLEntregas.getTableHeader().setReorderingAllowed(false);
        JTBLEntregas.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(Date.valueOf(String.valueOf(value)));
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                final LocalDate fechaVencimiento = LocalDate.of(year, month + 1, dayOfMonth);
                final LocalDate currentDate = LocalDate.now();
                final Period timeDiff = Period.between(currentDate, fechaVencimiento);
                if (timeDiff.getYears() == 0 && timeDiff.getMonths() == 0 && (timeDiff.getDays() == 0 || timeDiff.getDays() < 0)) {
                    component.setBackground(Color.red);
                } else if (timeDiff.getYears() == 0 && timeDiff.getMonths() <= 3) {
                    component.setBackground(Color.YELLOW);
                } else {
                    component.setBackground(Color.GREEN);
                }
                return component;
            }
        });

        JTBLEntregas.getColumnModel().getColumn(10).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                switch (String.valueOf(value)) {
                    case "AGOTADO":
                    case "VENCIDO": {
                        component.setBackground(Color.RED);
                    }
                    break;

                    default:
                        component.setBackground(Color.GREEN);
                        break;
                }
                return component;
            }
        });
    }

    @Override
    public void listaLotesVacia(final String msg) {
    }

    @Override
    public void errorObtenerLotes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerLotes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void loteAgotado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarLoteAgotado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void consumoEstaIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarLoteConsumoIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void existeUnLoteEnConsumoIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarLotesConsumoIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void consumoIniciado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorIniciarConsumo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoIniciarConsumo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void consumoDetenido(final String msg) {
        actualizarTabla();
    }

    @Override
    public void consumoNoIniciado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDetenerConsumo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoDetenerConsumo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
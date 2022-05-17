package View.GestionReactivos;

import Model.POJO.ReactivoEntrega;
import Model.POJOPersonalizado.ReactivoEntregaPersonalizado;
import Presenter.GestionReactivos.PresenterGestionReactivosEntregas;
import View.Utilitarios.ModelTable.GestionReactivos.TableModelReactivosEntregas;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brynner
 */
public class EntregasReactivos extends javax.swing.JInternalFrame implements PresenterGestionReactivosEntregas.CallBackObtenerEntregas {

    private final TableModelReactivosEntregas tableModelReactivosEntregas;
    private final PresenterGestionReactivosEntregas presenterGestionReactivosEntregas;
    
    public EntregasReactivos() {
        
        presenterGestionReactivosEntregas = new PresenterGestionReactivosEntregas();
        presenterGestionReactivosEntregas.setCallBackObtenerEntregas(this);
        
        tableModelReactivosEntregas = new TableModelReactivosEntregas();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEntregas = new javax.swing.JPopupMenu();
        JMENUITEMRegistrarLote = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerDetallesEntrega = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerLotesEliminados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarEntrega = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarEntrega = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEntregasReactivos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNRegistrarEntrega = new javax.swing.JButton();

        JMENUITEMRegistrarLote.setText("Registrar Lote");
        JMENUITEMRegistrarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMRegistrarLoteActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEntregas.add(JMENUITEMRegistrarLote);
        JPOPUPMENUItemEntregas.add(jSeparator1);

        JMENUITEMVerDetallesEntrega.setText("Ver Detalles de Entrega");
        JMENUITEMVerDetallesEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesEntregaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEntregas.add(JMENUITEMVerDetallesEntrega);
        JPOPUPMENUItemEntregas.add(jSeparator3);

        JMENUITEMVerLotesEliminados.setText("Ver Lotes Eliminados");
        JMENUITEMVerLotesEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerLotesEliminadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEntregas.add(JMENUITEMVerLotesEliminados);
        JPOPUPMENUItemEntregas.add(jSeparator2);

        JMENUITEMModificarEntrega.setText("Modificar Entrega");
        JMENUITEMModificarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarEntregaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEntregas.add(JMENUITEMModificarEntrega);

        setTitle("Entregas de Reactivos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_entregas.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Entrega"));

        JTXTFBuscarEntrega.setEnabled(false);
        JTXTFBuscarEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarEntregaFocusGained(evt);
            }
        });
        JTXTFBuscarEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEntregaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEntregaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEntrega)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FECHA ENTREGA", "CODIGO" }));
        JCMBXBuscarPor.setEnabled(false);
        JCMBXBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXBuscarPorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Entregas"));

        JTBLEntregasReactivos.setModel(tableModelReactivosEntregas);
        JTBLEntregasReactivos.setComponentPopupMenu(JPOPUPMENUItemEntregas);
        JTBLEntregasReactivos.setRowHeight(20);
        JTBLEntregasReactivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLEntregasReactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLEntregasReactivosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLEntregasReactivos.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregasReactivos.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregasReactivos.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregasReactivos.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLEntregasReactivos.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);

        JTBLEntregasReactivos.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLEntregasReactivos.getColumnModel().getColumn(1).setPreferredWidth(30);
        JTBLEntregasReactivos.getColumnModel().getColumn(2).setPreferredWidth(200);
        JTBLEntregasReactivos.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLEntregasReactivos.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTBLEntregasReactivos.getColumnModel().getColumn(5).setPreferredWidth(80);
        JTBLEntregasReactivos.getColumnModel().getColumn(6).setPreferredWidth(50);
        jScrollPane1.setViewportView(JTBLEntregasReactivos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNRegistrarEntrega.setText("REGISTRAR ENTREGA");
        JBTNRegistrarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNRegistrarEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNRegistrarEntrega)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNRegistrarEntrega))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        try {
            presenterGestionReactivosEntregas.obtenerEntregas();
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarEntregaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEntregaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([0-9-]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarEntrega.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarEntregaKeyTyped

    private void JTXTFBuscarEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEntregaKeyReleased
        final String search = JTXTFBuscarEntrega.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLEntregasReactivos.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 4));
                break;

            case 1:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 4));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarEntregaKeyReleased

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarEntrega.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTBLEntregasReactivosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLEntregasReactivosMousePressed
        final int currentRow = JTBLEntregasReactivos.rowAtPoint(evt.getPoint());
        JTBLEntregasReactivos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLEntregasReactivosMousePressed

    private void JMENUITEMRegistrarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMRegistrarLoteActionPerformed
        final RegistrarLote registrarLote = new RegistrarLote(null, true);
        registrarLote.setReactivoEntrega(obtenerReactivoEntregaSeleccionado());
        registrarLote.setVisible(true);

        if (!registrarLote.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMRegistrarLoteActionPerformed

    private void JMENUITEMVerDetallesEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesEntregaActionPerformed
        final VerDetallesEntrega verDetallesEntrega = new VerDetallesEntrega(null, true);
        verDetallesEntrega.setReactivoEntrega(obtenerReactivoEntregaSeleccionado());
        verDetallesEntrega.setVisible(true);
        
        if (!verDetallesEntrega.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerDetallesEntregaActionPerformed

    private void JMENUITEMModificarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarEntregaActionPerformed
        final ModificarEntrega modificarEntrega = new ModificarEntrega(null, true);
        modificarEntrega.setReactivoEntrega(obtenerReactivoEntregaSeleccionado());
        modificarEntrega.setVisible(true);
        
        if (!modificarEntrega.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarEntregaActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNRegistrarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNRegistrarEntregaActionPerformed
        final RegistrarEntrega registrarEntrega = new RegistrarEntrega(null, true);
        registrarEntrega.setVisible(true);
        
        if (!registrarEntrega.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNRegistrarEntregaActionPerformed

    private void JMENUITEMVerLotesEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerLotesEliminadosActionPerformed
        final VerLotesEliminados verLotesEliminados = new VerLotesEliminados(null, true);
        verLotesEliminados.setReactivoEntrega(obtenerReactivoEntregaSeleccionado());
        verLotesEliminados.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerLotesEliminadosActionPerformed

    private void JTXTFBuscarEntregaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarEntregaFocusGained
        JTXTFBuscarEntrega.selectAll();
    }//GEN-LAST:event_JTXTFBuscarEntregaFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNRegistrarEntrega;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMModificarEntrega;
    private javax.swing.JMenuItem JMENUITEMRegistrarLote;
    private javax.swing.JMenuItem JMENUITEMVerDetallesEntrega;
    private javax.swing.JMenuItem JMENUITEMVerLotesEliminados;
    private javax.swing.JPopupMenu JPOPUPMENUItemEntregas;
    private javax.swing.JTable JTBLEntregasReactivos;
    private javax.swing.JTextField JTXTFBuscarEntrega;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelReactivosEntregas.limpiarLista();
        presenterGestionReactivosEntregas.obtenerEntregas();
    }
    
    private ReactivoEntrega obtenerReactivoEntregaSeleccionado() {
        final int rowModel = JTBLEntregasReactivos.convertRowIndexToModel(JTBLEntregasReactivos.getSelectedRow());
        return tableModelReactivosEntregas.getReactivoEntrega(rowModel);
    }

    @Override
    public void entregasObtenidas(final List<ReactivoEntregaPersonalizado> reactivosEntregasPersonalizadas) {
        tableModelReactivosEntregas.setReactivosEntregas(reactivosEntregasPersonalizadas);
        JTBLEntregasReactivos.setRowSorter(new TableRowSorter<>(tableModelReactivosEntregas));
        JTBLEntregasReactivos.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarEntrega.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
        
    }

    @Override
    public void listaEntregasVacia(final String msg) {
        JTXTFBuscarEntrega.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerEntregas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEntregas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
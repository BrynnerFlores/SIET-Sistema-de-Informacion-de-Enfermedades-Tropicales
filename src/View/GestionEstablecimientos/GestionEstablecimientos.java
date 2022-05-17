package View.GestionEstablecimientos;

import Model.POJO.Establecimiento;
import Presenter.GestionEstablecimiento.PresenterGestionEstablecimiento;
import View.Utilitarios.ModelTable.GestionEstablecimientos.TableModelGestionEstablecimientos;
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
public class GestionEstablecimientos extends javax.swing.JInternalFrame implements PresenterGestionEstablecimiento.CallBackObtenerEstablecimientos, PresenterGestionEstablecimiento.CallBackEliminarEstablecimiento {

    private final TableModelGestionEstablecimientos tableModelGestionEstablecimientos;
    private final PresenterGestionEstablecimiento presenterGestionEstablecimiento;

    public GestionEstablecimientos() {

        presenterGestionEstablecimiento = new PresenterGestionEstablecimiento();
        presenterGestionEstablecimiento.setCallBackObtenerEstablecimientos(this);
        presenterGestionEstablecimiento.setCallBackEliminarEstablecimiento(this);
        tableModelGestionEstablecimientos = new TableModelGestionEstablecimientos();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEstablecimientos = new javax.swing.JPopupMenu();
        JMENUITEMModificarEstablecimiento = new javax.swing.JMenuItem();
        JMENUITEMEliminarEstablecimiento = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarEstablecimiento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEstablecimientos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNRegistrar = new javax.swing.JButton();

        JMENUITEMModificarEstablecimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarEstablecimiento.setText("Modificar Establecimiento");
        JMENUITEMModificarEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarEstablecimientoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEstablecimientos.add(JMENUITEMModificarEstablecimiento);

        JMENUITEMEliminarEstablecimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarEstablecimiento.setText("Eliminar Establecimiento");
        JMENUITEMEliminarEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarEstablecimientoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEstablecimientos.add(JMENUITEMEliminarEstablecimiento);

        setResizable(true);
        setTitle("Gestión de Establecimientos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/establecimientos_salud.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Establecimiento"));

        JTXTFBuscarEstablecimiento.setEnabled(false);
        JTXTFBuscarEstablecimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarEstablecimientoFocusGained(evt);
            }
        });
        JTXTFBuscarEstablecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEstablecimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEstablecimientoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEstablecimiento)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "CODIGO" }));
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
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Establecimientos"));

        JTBLEstablecimientos.setModel(tableModelGestionEstablecimientos);
        JTBLEstablecimientos.setComponentPopupMenu(JPOPUPMENUItemEstablecimientos);
        JTBLEstablecimientos.setEnabled(false);
        JTBLEstablecimientos.setRowHeight(20);
        JTBLEstablecimientos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLEstablecimientos.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLEstablecimientos.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLEstablecimientos.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLEstablecimientos.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);

        JTBLEstablecimientos.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLEstablecimientos.getColumnModel().getColumn(1).setPreferredWidth(20);
        JTBLEstablecimientos.getColumnModel().getColumn(2).setPreferredWidth(800);
        JTBLEstablecimientos.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTBLEstablecimientos.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTBLEstablecimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLEstablecimientosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTBLEstablecimientos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNRegistrar.setText("NUEVO ESTABLECIMIENTO");
        JBTNRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNRegistrar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNRegistrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        presenterGestionEstablecimiento.obtenerEstablecimientos();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarEstablecimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEstablecimientoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarEstablecimiento.getText().length() >= 80) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarEstablecimientoKeyTyped

    private void JTXTFBuscarEstablecimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEstablecimientoKeyReleased
        final String search = JTXTFBuscarEstablecimiento.getText();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLEstablecimientos.getRowSorter();

        if (JCMBXBuscarPor.getSelectedIndex() == 0) {
            sorter.setRowFilter(RowFilter.regexFilter(search, 2));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(search, 1));
        }
    }//GEN-LAST:event_JTXTFBuscarEstablecimientoKeyReleased

    private void JMENUITEMModificarEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarEstablecimientoActionPerformed
        final ModificarEstablecimiento modificarEstablecimiento = new ModificarEstablecimiento(null, true);
        modificarEstablecimiento.setEstablecimiento(obtenerEstablecimientoSeleccionado());
        modificarEstablecimiento.setVisible(true);
        
        if (!modificarEstablecimiento.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarEstablecimientoActionPerformed

    private void JMENUITEMEliminarEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarEstablecimientoActionPerformed
        final Establecimiento establecimiento = obtenerEstablecimientoSeleccionado();
        
        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el establecimiento?\n\nDATOS:\n\nCODIGO: " + establecimiento.getCodigoEstablecimiento() + "\nNOMBRE: " + establecimiento.getEstablecimientoNombre() + "\nTIPO: " + establecimiento.getEstablecimientoTipo() + "\nAREA: " + establecimiento.getEstablecimientoArea() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionEstablecimiento.eliminarEstablecimiento(establecimiento);
        }
    }//GEN-LAST:event_JMENUITEMEliminarEstablecimientoActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNRegistrarActionPerformed
        final RegistrarEstablecimiento registrarEstablecimiento = new RegistrarEstablecimiento(null, true);
        registrarEstablecimiento.setVisible(true);

        if (!registrarEstablecimiento.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNRegistrarActionPerformed

    private void JTBLEstablecimientosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLEstablecimientosMousePressed
        final int currentRow = JTBLEstablecimientos.rowAtPoint(evt.getPoint());
        JTBLEstablecimientos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLEstablecimientosMousePressed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarEstablecimiento.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTXTFBuscarEstablecimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarEstablecimientoFocusGained
        JTXTFBuscarEstablecimiento.selectAll();
    }//GEN-LAST:event_JTXTFBuscarEstablecimientoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNRegistrar;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMEliminarEstablecimiento;
    private javax.swing.JMenuItem JMENUITEMModificarEstablecimiento;
    private javax.swing.JPopupMenu JPOPUPMENUItemEstablecimientos;
    private javax.swing.JTable JTBLEstablecimientos;
    private javax.swing.JTextField JTXTFBuscarEstablecimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private Establecimiento obtenerEstablecimientoSeleccionado() {
        final int rowModel = JTBLEstablecimientos.convertRowIndexToModel(JTBLEstablecimientos.getSelectedRow());
        return tableModelGestionEstablecimientos.getEstablecimiento(rowModel);
    }
    
    private void actualizarTabla() {
        tableModelGestionEstablecimientos.limpiarLista();
        presenterGestionEstablecimiento.obtenerEstablecimientos();
    }

    @Override
    public void establecimientosObtenidos(final List<Establecimiento> establecimientos) {
        tableModelGestionEstablecimientos.setEstablecimientos(establecimientos);
        JTBLEstablecimientos.setRowSorter(new TableRowSorter<>(tableModelGestionEstablecimientos));
        JTBLEstablecimientos.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarEstablecimiento.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaEstablecimientosVacia(final String msg) {
    }

    @Override
    public void errorObtenerEstablecimientos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEstablecimientos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void establecimientoEliminado() {
        actualizarTabla();
    }

    @Override
    public void errorEliminarEstablecimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarEstablecimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
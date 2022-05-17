package View.GestionEquipos.GestionEquiposIntervencion;

import View.GestionEquipos.GestionEquiposActivos.*;
import Model.POJO.Intervencion;
import Presenter.GestionEquipos.PresenterGestionIntervenciones;
import View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposIntervencion.TableModelGestionEquiposIntervencion;
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
public class GestionEquiposIntervencion extends javax.swing.JInternalFrame implements PresenterGestionIntervenciones.CallBackObtenerIntervenciones {
    
    private final TableModelGestionEquiposIntervencion tableModelGestionEquiposIntervencion;
    private final PresenterGestionIntervenciones presenterGestionIntervenciones;

    public GestionEquiposIntervencion() {
        
        tableModelGestionEquiposIntervencion = new TableModelGestionEquiposIntervencion();
        
        presenterGestionIntervenciones = new PresenterGestionIntervenciones();
        presenterGestionIntervenciones.setCallBackObtenerIntervenciones(this);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEquipoActivo = new javax.swing.JPopupMenu();
        JMENUITEMVerDetallesDelEquipo = new javax.swing.JMenuItem();
        JMENUITEMVerDetallesIntervencion = new javax.swing.JMenuItem();
        JMENUITEMVerHistorialDelEquipo = new javax.swing.JMenuItem();
        JMENUITEMModificarIntervencion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMFinalizarIntervencion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarEquipo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLIntervenciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();

        JMENUITEMVerDetallesDelEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_equipo.png"))); // NOI18N
        JMENUITEMVerDetallesDelEquipo.setText("Ver Detalles del Equipo");
        JMENUITEMVerDetallesDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesDelEquipoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMVerDetallesDelEquipo);

        JMENUITEMVerDetallesIntervencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerDetallesIntervencion.setText("Ver Detalles de Intervención");
        JMENUITEMVerDetallesIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesIntervencionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMVerDetallesIntervencion);

        JMENUITEMVerHistorialDelEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerHistorialDelEquipo.setText("Ver Historial del Equipo");
        JMENUITEMVerHistorialDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerHistorialDelEquipoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMVerHistorialDelEquipo);

        JMENUITEMModificarIntervencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarIntervencion.setText("Modificar Intervención");
        JMENUITEMModificarIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarIntervencionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMModificarIntervencion);
        JPOPUPMENUItemEquipoActivo.add(jSeparator1);

        JMENUITEMFinalizarIntervencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/stop.png"))); // NOI18N
        JMENUITEMFinalizarIntervencion.setText("Finalizar Intervención");
        JMENUITEMFinalizarIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMFinalizarIntervencionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMFinalizarIntervencion);

        setTitle("Gestión de Equipos en Intervención");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_intervencion.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Equipo"));

        JTXTFBuscarEquipo.setEnabled(false);
        JTXTFBuscarEquipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarEquipoFocusGained(evt);
            }
        });
        JTXTFBuscarEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEquipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEquipoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEquipo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NUMERO DE SERIE" }));
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos en Intervención"));

        JTBLIntervenciones.setModel(tableModelGestionEquiposIntervencion);
        JTBLIntervenciones.setComponentPopupMenu(JPOPUPMENUItemEquipoActivo);
        JTBLIntervenciones.setEnabled(false);
        JTBLIntervenciones.setRowHeight(20);
        JTBLIntervenciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLIntervenciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLIntervencionesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLIntervenciones.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervenciones.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervenciones.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervenciones.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervenciones.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);

        JTBLIntervenciones.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLIntervenciones.getColumnModel().getColumn(4).setPreferredWidth(200);
        jScrollPane1.setViewportView(JTBLIntervenciones);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addContainerGap(1079, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNActualizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        presenterGestionIntervenciones.obtenerIntervenciones();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEquipoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarEquipo.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarEquipoKeyTyped

    private void JTBLIntervencionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLIntervencionesMousePressed
        final int currentRow = JTBLIntervenciones.rowAtPoint(evt.getPoint());
        JTBLIntervenciones.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLIntervencionesMousePressed

    private void JMENUITEMFinalizarIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMFinalizarIntervencionActionPerformed
        final FinalizarIntervencion finalizarIntervencion = new FinalizarIntervencion(null, true);
        finalizarIntervencion.setIntervencion(obtenerIntervencionSeleccionada());
        finalizarIntervencion.setVisible(true);

        if (!finalizarIntervencion.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMFinalizarIntervencionActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JTXTFBuscarEquipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEquipoKeyReleased
        final String search = JTXTFBuscarEquipo.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLIntervenciones.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 7));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 7));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarEquipoKeyReleased

    private void JMENUITEMVerDetallesDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesDelEquipoActionPerformed
        final VerDetallesEquipo verDetallesEquipo = new VerDetallesEquipo(null, true);
        verDetallesEquipo.setEquipo(obtenerIntervencionSeleccionada().getEquipo());
        verDetallesEquipo.setPermitirModificacion(false);
        verDetallesEquipo.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesDelEquipoActionPerformed

    private void JMENUITEMModificarIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarIntervencionActionPerformed
        final ModificarIntervencion modificarIntervencion = new ModificarIntervencion(null, true);
        modificarIntervencion.setIntervencion(obtenerIntervencionSeleccionada());
        modificarIntervencion.setVisible(true);

        if (!modificarIntervencion.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarIntervencionActionPerformed

    private void JMENUITEMVerDetallesIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesIntervencionActionPerformed
        final DetallesIntervencion detallesIntervencion = new DetallesIntervencion(null, true);
        detallesIntervencion.setIntervencion(obtenerIntervencionSeleccionada());
        detallesIntervencion.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesIntervencionActionPerformed

    private void JMENUITEMVerHistorialDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerHistorialDelEquipoActionPerformed
        final VerHistorialEquipo verHistorialEquipo = new VerHistorialEquipo(null, true);
        verHistorialEquipo.setEquipo(obtenerIntervencionSeleccionada().getEquipo());
        verHistorialEquipo.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerHistorialDelEquipoActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarEquipo.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTXTFBuscarEquipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarEquipoFocusGained
        JTXTFBuscarEquipo.selectAll();
    }//GEN-LAST:event_JTXTFBuscarEquipoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMFinalizarIntervencion;
    private javax.swing.JMenuItem JMENUITEMModificarIntervencion;
    private javax.swing.JMenuItem JMENUITEMVerDetallesDelEquipo;
    private javax.swing.JMenuItem JMENUITEMVerDetallesIntervencion;
    private javax.swing.JMenuItem JMENUITEMVerHistorialDelEquipo;
    private javax.swing.JPopupMenu JPOPUPMENUItemEquipoActivo;
    private javax.swing.JTable JTBLIntervenciones;
    private javax.swing.JTextField JTXTFBuscarEquipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelGestionEquiposIntervencion.limpiarLista();
        presenterGestionIntervenciones.obtenerIntervenciones();
    }
    private Intervencion obtenerIntervencionSeleccionada() {
        final int rowModel = JTBLIntervenciones.convertRowIndexToModel(JTBLIntervenciones.getSelectedRow());
        return tableModelGestionEquiposIntervencion.getIntervencion(rowModel);
    }

    @Override
    public void intervencionesObtenidas(final List<Intervencion> intervenciones) {
        tableModelGestionEquiposIntervencion.setIntervenciones(intervenciones);
        JTBLIntervenciones.setRowSorter(new TableRowSorter<>(tableModelGestionEquiposIntervencion));
        JTBLIntervenciones.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarEquipo.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaIntervencionesVacia(final String msg) {
        JTXTFBuscarEquipo.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerIntervenciones(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerIntervenciones(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Equipo;
import Presenter.GestionEquipos.PresenterGestionEquipos;
import View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposActivos.TableModelGestionEquiposActivos;
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
public class GestionEquiposActivos extends javax.swing.JInternalFrame implements PresenterGestionEquipos.CallBackObtenerEquipos {

    private final TableModelGestionEquiposActivos tableModelEquiposActivos;
    private final PresenterGestionEquipos presenterGestionEquipos;

    public GestionEquiposActivos() {
        
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionEquipos.setCallBackObtenerEquipos(this);
        
        tableModelEquiposActivos = new TableModelGestionEquiposActivos();
        
        initComponents();
        
        presenterGestionEquipos.obtenerEquipos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEquipoActivo = new javax.swing.JPopupMenu();
        JMENUITEMAgregarCaracterizticas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMEnviarIntervencion = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerHistorialDelEquipo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMVerDetallesDelEquipo = new javax.swing.JMenuItem();
        JMENUITEMModificarEquipoActivo = new javax.swing.JMenuItem();
        JMENUITEMEliminarEquipoActivo = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarEquipo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEquiposActivos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNRegistrarEquipo = new javax.swing.JButton();

        JMENUITEMAgregarCaracterizticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAgregarCaracterizticas.setText("Agregar Caracterizticas");
        JMENUITEMAgregarCaracterizticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAgregarCaracterizticasActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMAgregarCaracterizticas);
        JPOPUPMENUItemEquipoActivo.add(jSeparator1);

        JMENUITEMEnviarIntervencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_intervencion.png"))); // NOI18N
        JMENUITEMEnviarIntervencion.setText("Enviar a Intervencion");
        JMENUITEMEnviarIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEnviarIntervencionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMEnviarIntervencion);
        JPOPUPMENUItemEquipoActivo.add(jSeparator2);

        JMENUITEMVerHistorialDelEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerHistorialDelEquipo.setText("Ver Historial del Equipo");
        JMENUITEMVerHistorialDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerHistorialDelEquipoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMVerHistorialDelEquipo);
        JPOPUPMENUItemEquipoActivo.add(jSeparator3);

        JMENUITEMVerDetallesDelEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_equipo.png"))); // NOI18N
        JMENUITEMVerDetallesDelEquipo.setText("Ver Detalles del Equipo");
        JMENUITEMVerDetallesDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesDelEquipoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMVerDetallesDelEquipo);

        JMENUITEMModificarEquipoActivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_equipo.png"))); // NOI18N
        JMENUITEMModificarEquipoActivo.setText("Modificar Equipo");
        JMENUITEMModificarEquipoActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarEquipoActivoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMModificarEquipoActivo);

        JMENUITEMEliminarEquipoActivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarEquipoActivo.setText("Eliminar Equipo");
        JMENUITEMEliminarEquipoActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarEquipoActivoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoActivo.add(JMENUITEMEliminarEquipoActivo);

        setTitle("Gestión de Equipos Activos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_equipos_activos.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 700));

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos Activos"));

        JTBLEquiposActivos.setModel(tableModelEquiposActivos);
        JTBLEquiposActivos.setComponentPopupMenu(JPOPUPMENUItemEquipoActivo);
        JTBLEquiposActivos.setEnabled(false);
        JTBLEquiposActivos.setRowHeight(20);
        JTBLEquiposActivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLEquiposActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLEquiposActivosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLEquiposActivos.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(8).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(9).setCellRenderer(defaultTableCellRenderer);
        JTBLEquiposActivos.getColumnModel().getColumn(11).setCellRenderer(defaultTableCellRenderer);

        JTBLEquiposActivos.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLEquiposActivos.getColumnModel().getColumn(1).setPreferredWidth(50);
        JTBLEquiposActivos.getColumnModel().getColumn(2).setPreferredWidth(250);
        JTBLEquiposActivos.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTBLEquiposActivos.getColumnModel().getColumn(4).setPreferredWidth(50);
        JTBLEquiposActivos.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTBLEquiposActivos.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTBLEquiposActivos.getColumnModel().getColumn(7).setPreferredWidth(50);
        JTBLEquiposActivos.getColumnModel().getColumn(8).setPreferredWidth(50);
        JTBLEquiposActivos.getColumnModel().getColumn(9).setPreferredWidth(50);
        JTBLEquiposActivos.getColumnModel().getColumn(10).setPreferredWidth(100);
        JTBLEquiposActivos.getColumnModel().getColumn(11).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLEquiposActivos);

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

        JBTNRegistrarEquipo.setText("REGISTRAR EQUIPO");
        JBTNRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNRegistrarEquipoActionPerformed(evt);
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
                .addComponent(JBTNRegistrarEquipo)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNRegistrarEquipo))
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

    private void JTBLEquiposActivosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLEquiposActivosMousePressed
        final int currentRow = JTBLEquiposActivos.rowAtPoint(evt.getPoint());
        JTBLEquiposActivos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLEquiposActivosMousePressed

    private void JMENUITEMAgregarCaracterizticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAgregarCaracterizticasActionPerformed
        final AgregarCaracterizticas agregarCaracterizticas = new AgregarCaracterizticas(null, true);
        agregarCaracterizticas.setEquipo(obtenerEquipoSeleccionado());
        agregarCaracterizticas.setVisible(true);
    }//GEN-LAST:event_JMENUITEMAgregarCaracterizticasActionPerformed

    private void JMENUITEMEnviarIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEnviarIntervencionActionPerformed
        final EnviarIntervencion enviarIntervencion = new EnviarIntervencion(null, true);
        enviarIntervencion.setEquipo(obtenerEquipoSeleccionado());
        enviarIntervencion.setVisible(true);
        
        if (!enviarIntervencion.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMEnviarIntervencionActionPerformed

    private void JMENUITEMModificarEquipoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarEquipoActivoActionPerformed
        final ModificarEquipo modificarEquipo = new ModificarEquipo(null, true);
        modificarEquipo.setEquipo(obtenerEquipoSeleccionado());
        modificarEquipo.setVisible(true);

        if (!modificarEquipo.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarEquipoActivoActionPerformed

    private void JMENUITEMEliminarEquipoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarEquipoActivoActionPerformed
        final EliminarEquipo eliminarEquipo = new EliminarEquipo(null, true);
        eliminarEquipo.setEquipo(obtenerEquipoSeleccionado());
        eliminarEquipo.setVisible(true);
        
        if (!eliminarEquipo.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMEliminarEquipoActivoActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNRegistrarEquipoActionPerformed
        final RegistrarEquipo registrarEquipo = new RegistrarEquipo(null, true);
        registrarEquipo.setVisible(true);

        if (!registrarEquipo.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNRegistrarEquipoActionPerformed

    private void JTXTFBuscarEquipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEquipoKeyReleased
        final String search = JTXTFBuscarEquipo.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLEquiposActivos.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 5));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 5));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarEquipoKeyReleased

    private void JMENUITEMVerDetallesDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesDelEquipoActionPerformed
        final VerDetallesEquipo verDetallesEquipo = new VerDetallesEquipo(null, true);
        verDetallesEquipo.setEquipo(obtenerEquipoSeleccionado());
        verDetallesEquipo.setPermitirModificacion(true);
        verDetallesEquipo.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesDelEquipoActionPerformed

    private void JMENUITEMVerHistorialDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerHistorialDelEquipoActionPerformed
        final VerHistorialEquipo verHistorialEquipo = new VerHistorialEquipo(null, true);
        verHistorialEquipo.setEquipo(obtenerEquipoSeleccionado());
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
    private javax.swing.JButton JBTNRegistrarEquipo;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMAgregarCaracterizticas;
    private javax.swing.JMenuItem JMENUITEMEliminarEquipoActivo;
    private javax.swing.JMenuItem JMENUITEMEnviarIntervencion;
    private javax.swing.JMenuItem JMENUITEMModificarEquipoActivo;
    private javax.swing.JMenuItem JMENUITEMVerDetallesDelEquipo;
    private javax.swing.JMenuItem JMENUITEMVerHistorialDelEquipo;
    private javax.swing.JPopupMenu JPOPUPMENUItemEquipoActivo;
    private javax.swing.JTable JTBLEquiposActivos;
    private javax.swing.JTextField JTXTFBuscarEquipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelEquiposActivos.limpiarLista();
        presenterGestionEquipos.obtenerEquipos();
    }
    
    private Equipo obtenerEquipoSeleccionado() {
        final int rowModel = JTBLEquiposActivos.convertRowIndexToModel(JTBLEquiposActivos.getSelectedRow());
        return tableModelEquiposActivos.getEquipo(rowModel);
    }

    @Override
    public void equiposObtenidas(final List<Equipo> equipos) {
        tableModelEquiposActivos.setEquipos(equipos);
        JTBLEquiposActivos.setRowSorter(new TableRowSorter<>(tableModelEquiposActivos));
        JTBLEquiposActivos.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarEquipo.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaEquiposVacia(final String msg) {
        JTXTFBuscarEquipo.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerEquipos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEquipos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
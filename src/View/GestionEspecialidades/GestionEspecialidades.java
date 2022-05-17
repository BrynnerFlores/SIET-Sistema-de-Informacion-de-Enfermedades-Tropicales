package View.GestionEspecialidades;

import Model.POJO.Especialidad;
import Model.POJOPersonalizado.EspecialidadPersonalizada;
import Presenter.GestionEspecialidades.PresenterGestionEspecialidades;
import View.Utilitarios.ModelTable.GestionEspecialidades.TableModelGestionEspecialidades;
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
public class GestionEspecialidades extends javax.swing.JInternalFrame implements PresenterGestionEspecialidades.CallBackObtenerEspecialidades, PresenterGestionEspecialidades.CallBackEliminarEspecialidad {

    private final TableModelGestionEspecialidades tableModelGestionEspecialidades;
    private final PresenterGestionEspecialidades presenterGestionEspecialidades;

    public GestionEspecialidades() {

        presenterGestionEspecialidades = new PresenterGestionEspecialidades();
        presenterGestionEspecialidades.setCallBackObtenerEspecialidades(this);
        presenterGestionEspecialidades.setCallBackEliminarEspecialidad(this);
        
        tableModelGestionEspecialidades = new TableModelGestionEspecialidades();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEspecialidades = new javax.swing.JPopupMenu();
        JMENUITEMVerSubespecialidades = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarEspecialidad = new javax.swing.JMenuItem();
        JMENUITEMEliminarEspecialidad = new javax.swing.JMenuItem();
        jPanel15 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        JTXTFBuscarEspecialidad = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEspecialidades = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        JBTNCrearEspecialidad = new javax.swing.JButton();
        JBTNActualizarListaEspecialidades = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JPOPUPMENUItemEspecialidades.setComponentPopupMenu(JPOPUPMENUItemEspecialidades);

        JMENUITEMVerSubespecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMVerSubespecialidades.setText("Ver Subespecialidades");
        JMENUITEMVerSubespecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerSubespecialidadesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEspecialidades.add(JMENUITEMVerSubespecialidades);
        JPOPUPMENUItemEspecialidades.add(jSeparator1);

        JMENUITEMModificarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarEspecialidad.setText("Modificar Especialidad");
        JMENUITEMModificarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarEspecialidadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEspecialidades.add(JMENUITEMModificarEspecialidad);

        JMENUITEMEliminarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarEspecialidad.setText("Eliminar Especialidad");
        JMENUITEMEliminarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarEspecialidadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEspecialidades.add(JMENUITEMEliminarEspecialidad);

        setResizable(true);
        setTitle("Gestión de Especialidades");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/documento.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1100, 700));
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Especialidad"));

        JTXTFBuscarEspecialidad.setEnabled(false);
        JTXTFBuscarEspecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarEspecialidadFocusGained(evt);
            }
        });
        JTXTFBuscarEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEspecialidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarEspecialidadKeyTyped(evt);
            }
        });
        JTXTFBuscarEspecialidad.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarEspecialidad)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTXTFBuscarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Especialidades"));

        JTBLEspecialidades.setModel(tableModelGestionEspecialidades);
        JTBLEspecialidades.setComponentPopupMenu(JPOPUPMENUItemEspecialidades);
        JTBLEspecialidades.setEnabled(false);
        JTBLEspecialidades.setRowHeight(20);
        JTBLEspecialidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLEspecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLEspecialidadesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLEspecialidades.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLEspecialidades.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLEspecialidades.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);

        JTBLEspecialidades.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLEspecialidades.getColumnModel().getColumn(1).setPreferredWidth(20);
        JTBLEspecialidades.getColumnModel().getColumn(2).setPreferredWidth(900);
        JTBLEspecialidades.getColumnModel().getColumn(3).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLEspecialidades);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNCrearEspecialidad.setText("CREAR ESPECIALIDAD");
        JBTNCrearEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCrearEspecialidadActionPerformed(evt);
            }
        });

        JBTNActualizarListaEspecialidades.setText("ACTUALZAR");
        JBTNActualizarListaEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarListaEspecialidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizarListaEspecialidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 932, Short.MAX_VALUE)
                .addComponent(JBTNCrearEspecialidad)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCrearEspecialidad)
                    .addComponent(JBTNActualizarListaEspecialidades))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESPECIALIDAD", "CODIGO" }));
        JCMBXBuscarPor.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
        JCMBXBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXBuscarPorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTXTFBuscarEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEspecialidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarEspecialidad.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarEspecialidadKeyTyped

    private void JTXTFBuscarEspecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarEspecialidadKeyReleased
        final String search = JTXTFBuscarEspecialidad.getText();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLEspecialidades.getRowSorter();

        if (JCMBXBuscarPor.getSelectedIndex() == 0) {
            sorter.setRowFilter(RowFilter.regexFilter(search, 2));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(search, 1));
        }
    }//GEN-LAST:event_JTXTFBuscarEspecialidadKeyReleased

    private void JBTNCrearEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCrearEspecialidadActionPerformed
        final CrearEspecialidad crearEspecialidad = new CrearEspecialidad(null, true);
        crearEspecialidad.setVisible(true);

        if (!crearEspecialidad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNCrearEspecialidadActionPerformed

    private void JBTNActualizarListaEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarListaEspecialidadesActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarListaEspecialidadesActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        presenterGestionEspecialidades.obtenerEspecialidades();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTBLEspecialidadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLEspecialidadesMousePressed
        final int currentRow = JTBLEspecialidades.rowAtPoint(evt.getPoint());
        JTBLEspecialidades.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLEspecialidadesMousePressed

    private void JMENUITEMModificarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarEspecialidadActionPerformed
        final Especialidad especialidad = obtenerEspecialidadSeleccionada();

        final ModificarEspecialidad modificarEspecialidad = new ModificarEspecialidad(null, true);
        modificarEspecialidad.setEspecialidad(especialidad);
        modificarEspecialidad.setVisible(true);

        if (!modificarEspecialidad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarEspecialidadActionPerformed

    private void JMENUITEMEliminarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarEspecialidadActionPerformed
        final Especialidad especialidad = obtenerEspecialidadSeleccionada();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar Especialidad?\n\nDatos:\n\nESPECIALIDAD: " + especialidad.getEspecialidadNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionEspecialidades.eliminarEspecialidad(especialidad);
        }
    }//GEN-LAST:event_JMENUITEMEliminarEspecialidadActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarEspecialidad.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JMENUITEMVerSubespecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerSubespecialidadesActionPerformed
        final Especialidad especialidad = obtenerEspecialidadSeleccionada();

        final VerSubespecialidades verSubespecialidades = new VerSubespecialidades(null, true);
        verSubespecialidades.setEspecialidad(especialidad);
        verSubespecialidades.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerSubespecialidadesActionPerformed

    private void JTXTFBuscarEspecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarEspecialidadFocusGained
        JTXTFBuscarEspecialidad.selectAll();
    }//GEN-LAST:event_JTXTFBuscarEspecialidadFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizarListaEspecialidades;
    private javax.swing.JButton JBTNCrearEspecialidad;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMEliminarEspecialidad;
    private javax.swing.JMenuItem JMENUITEMModificarEspecialidad;
    private javax.swing.JMenuItem JMENUITEMVerSubespecialidades;
    private javax.swing.JPopupMenu JPOPUPMENUItemEspecialidades;
    private javax.swing.JTable JTBLEspecialidades;
    private javax.swing.JTextField JTXTFBuscarEspecialidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private Especialidad obtenerEspecialidadSeleccionada() {
        final int rowModel = JTBLEspecialidades.convertRowIndexToModel(JTBLEspecialidades.getSelectedRow());
        return tableModelGestionEspecialidades.getEspecialidad(rowModel);
    }

    private void actualizarTabla() {
        tableModelGestionEspecialidades.limpiarLista();
        presenterGestionEspecialidades.obtenerEspecialidades();
    }

    @Override
    public void especialidadesObtenidas(final List<EspecialidadPersonalizada> especialidadesPersonalizadas) {
        tableModelGestionEspecialidades.setEspecialidadesPersonalizadas(especialidadesPersonalizadas);
        JTBLEspecialidades.setRowSorter(new TableRowSorter<>(tableModelGestionEspecialidades));
        JTBLEspecialidades.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarEspecialidad.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaEspecialidadesVacia(final String msg) {
        JTXTFBuscarEspecialidad.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerEspecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEspecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void especialidadEliminada(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarEspecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarEspecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
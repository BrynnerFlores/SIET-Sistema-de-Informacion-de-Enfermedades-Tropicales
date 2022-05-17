package View.GestionSubespecialidades;

import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.SubespecialidadPersonalizada;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModelTable.GestionSubespecialidades.TableModelGestionSubespecialidades;
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
public class GestionSubespecialidades extends javax.swing.JInternalFrame implements PresenterGestionSubespecialidades.CallBackVerificarExistenciaSubespecialidad, PresenterGestionSubespecialidades.CallBackObtenerSubespecialidades, PresenterGestionSubespecialidades.CallBackEliminarSubespecialidad {
    
    private final TableModelGestionSubespecialidades tableModelGestionSubespecialidades;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;

    public GestionSubespecialidades() {
        
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionSubespecialidades.setCallBackObtenerSubespecialidades(this);
        presenterGestionSubespecialidades.setCallBackVerificarExistenciaSubespecialidad(this);
        presenterGestionSubespecialidades.setCallBackEliminarSubespecialidad(this);
        
        tableModelGestionSubespecialidades = new TableModelGestionSubespecialidades();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemSubespecialidades = new javax.swing.JPopupMenu();
        JMENUITEMAsignarMuestrasBiologicas = new javax.swing.JMenuItem();
        JMENUITEMVerMuestrasBiologicasAsignadas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMAgregarEnfermedad = new javax.swing.JMenuItem();
        JMENUITEMVerEnfermedadesAgregadas = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarSubespecialidad = new javax.swing.JMenuItem();
        JMENUITEMEliminarSubespecialidad = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        JTXTFBuscarSubespecialidad = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBLSubespecialidades = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        JBTNActualizarListaSubespecialidades = new javax.swing.JButton();
        JBTNCrearSubespecialidad = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JMENUITEMAsignarMuestrasBiologicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAsignarMuestrasBiologicas.setText("Asignar Muestras Biológicas");
        JMENUITEMAsignarMuestrasBiologicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAsignarMuestrasBiologicasActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSubespecialidades.add(JMENUITEMAsignarMuestrasBiologicas);

        JMENUITEMVerMuestrasBiologicasAsignadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMVerMuestrasBiologicasAsignadas.setText("Ver Muestras Biológicas Asignadas");
        JMENUITEMVerMuestrasBiologicasAsignadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerMuestrasBiologicasAsignadasActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSubespecialidades.add(JMENUITEMVerMuestrasBiologicasAsignadas);
        JPOPUPMENUItemSubespecialidades.add(jSeparator1);

        JMENUITEMAgregarEnfermedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAgregarEnfermedad.setText("Agregar Enfermedad");
        JMENUITEMAgregarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAgregarEnfermedadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSubespecialidades.add(JMENUITEMAgregarEnfermedad);

        JMENUITEMVerEnfermedadesAgregadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMVerEnfermedadesAgregadas.setText("Ver Enfermedades Agregadas");
        JMENUITEMVerEnfermedadesAgregadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerEnfermedadesAgregadasActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSubespecialidades.add(JMENUITEMVerEnfermedadesAgregadas);
        JPOPUPMENUItemSubespecialidades.add(jSeparator2);

        JMENUITEMModificarSubespecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarSubespecialidad.setText("Modificar Subespecialidad");
        JMENUITEMModificarSubespecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarSubespecialidadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSubespecialidades.add(JMENUITEMModificarSubespecialidad);

        JMENUITEMEliminarSubespecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarSubespecialidad.setText("Eliminar Subespecialidad");
        JMENUITEMEliminarSubespecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarSubespecialidadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemSubespecialidades.add(JMENUITEMEliminarSubespecialidad);

        setTitle("Gestión de Subespecialidades");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/documento.png"))); // NOI18N
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Subespecialidad"));

        JTXTFBuscarSubespecialidad.setEnabled(false);
        JTXTFBuscarSubespecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarSubespecialidadFocusGained(evt);
            }
        });
        JTXTFBuscarSubespecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarSubespecialidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarSubespecialidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarSubespecialidad)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarSubespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Subespecialidades"));

        JTBLSubespecialidades.setModel(tableModelGestionSubespecialidades);
        JTBLSubespecialidades.setComponentPopupMenu(JPOPUPMENUItemSubespecialidades);
        JTBLSubespecialidades.setEnabled(false);
        JTBLSubespecialidades.setRowHeight(20);
        JTBLSubespecialidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLSubespecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLSubespecialidadesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLSubespecialidades.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLSubespecialidades.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLSubespecialidades.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLSubespecialidades.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLSubespecialidades.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);

        JTBLSubespecialidades.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLSubespecialidades.getColumnModel().getColumn(1).setPreferredWidth(20);
        JTBLSubespecialidades.getColumnModel().getColumn(2).setPreferredWidth(450);
        JTBLSubespecialidades.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLSubespecialidades.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTBLSubespecialidades.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTBLSubespecialidades.getColumnModel().getColumn(6).setPreferredWidth(100);
        jScrollPane2.setViewportView(JTBLSubespecialidades);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizarListaSubespecialidades.setText("ACTUALIZAR");
        JBTNActualizarListaSubespecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarListaSubespecialidadesActionPerformed(evt);
            }
        });

        JBTNCrearSubespecialidad.setText("CREAR SUBESPECIALIDAD");
        JBTNCrearSubespecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCrearSubespecialidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizarListaSubespecialidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNCrearSubespecialidad)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizarListaSubespecialidades)
                    .addComponent(JBTNCrearSubespecialidad))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBESPECIALIDAD", "CODIGO" }));
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        presenterGestionSubespecialidades.obtenerSubespecialidades();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarSubespecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarSubespecialidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarSubespecialidad.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarSubespecialidadKeyTyped

    private void JTXTFBuscarSubespecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarSubespecialidadKeyReleased
        final String search = JTXTFBuscarSubespecialidad.getText();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLSubespecialidades.getRowSorter();

        if (JCMBXBuscarPor.getSelectedIndex() == 0) {
            sorter.setRowFilter(RowFilter.regexFilter(search, 2));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(search, 1));
        }
    }//GEN-LAST:event_JTXTFBuscarSubespecialidadKeyReleased

    private void JTBLSubespecialidadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLSubespecialidadesMousePressed
        final int currentRow = JTBLSubespecialidades.rowAtPoint(evt.getPoint());
        JTBLSubespecialidades.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLSubespecialidadesMousePressed

    private void JMENUITEMAsignarMuestrasBiologicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAsignarMuestrasBiologicasActionPerformed
        final Subespecialidad subespecialidad = obtenerSubespecialidadSeleccionada();

        final AsignarMuestrasBiologicas asignarMuestrasBiologicas = new AsignarMuestrasBiologicas(null, true);
        asignarMuestrasBiologicas.setSubespecialidad(subespecialidad);
        asignarMuestrasBiologicas.setVisible(true);

        if (!asignarMuestrasBiologicas.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMAsignarMuestrasBiologicasActionPerformed

    private void JMENUITEMVerMuestrasBiologicasAsignadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerMuestrasBiologicasAsignadasActionPerformed
        final Subespecialidad subespecialidad = obtenerSubespecialidadSeleccionada();

        final VerMuestrasBiologicasAsignadas verMuestrasBiologicasAsignadas = new VerMuestrasBiologicasAsignadas(null, true);
        verMuestrasBiologicasAsignadas.setSubespecialidad(subespecialidad);
        verMuestrasBiologicasAsignadas.setVisible(true);
        
        if (!verMuestrasBiologicasAsignadas.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerMuestrasBiologicasAsignadasActionPerformed

    private void JBTNActualizarListaSubespecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarListaSubespecialidadesActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarListaSubespecialidadesActionPerformed

    private void JBTNCrearSubespecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCrearSubespecialidadActionPerformed
        final CrearSubespecialidad crearSubespecialidad = new CrearSubespecialidad(null, true);
        crearSubespecialidad.setVisible(true);

        if (!crearSubespecialidad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNCrearSubespecialidadActionPerformed

    private void JMENUITEMModificarSubespecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarSubespecialidadActionPerformed
        final Subespecialidad subespecialidad = obtenerSubespecialidadSeleccionada();

        final ModificarSubespecialidad modificarSubespecialidad = new ModificarSubespecialidad(null, true);
        modificarSubespecialidad.setSubespecialidad(subespecialidad);
        modificarSubespecialidad.setVisible(true);

        if (!modificarSubespecialidad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarSubespecialidadActionPerformed

    private void JMENUITEMEliminarSubespecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarSubespecialidadActionPerformed
        final Subespecialidad subespecialidad = obtenerSubespecialidadSeleccionada();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar Subespecialidad?\n\nDatos:\n\nSUBESPECIALIDAD: " + subespecialidad.getSubespecialidadNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionSubespecialidades.eliminarSubespecialidad(subespecialidad);
        }
    }//GEN-LAST:event_JMENUITEMEliminarSubespecialidadActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarSubespecialidad.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JMENUITEMAgregarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAgregarEnfermedadActionPerformed
        final AgregarEnfermedad agregarEnfermedad = new AgregarEnfermedad(null, true);
        agregarEnfermedad.setSubespecialidad(obtenerSubespecialidadSeleccionada());
        agregarEnfermedad.setVisible(true);
        
        if(!agregarEnfermedad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMAgregarEnfermedadActionPerformed

    private void JMENUITEMVerEnfermedadesAgregadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerEnfermedadesAgregadasActionPerformed
        final VerEnfermedadesAgregadas verEnfermedadesAgregadas = new VerEnfermedadesAgregadas(null, true);
        verEnfermedadesAgregadas.setSubespecialidad(obtenerSubespecialidadSeleccionada());
        verEnfermedadesAgregadas.setVisible(true);
        
        if(!verEnfermedadesAgregadas.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerEnfermedadesAgregadasActionPerformed

    private void JTXTFBuscarSubespecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarSubespecialidadFocusGained
        JTXTFBuscarSubespecialidad.selectAll();
    }//GEN-LAST:event_JTXTFBuscarSubespecialidadFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizarListaSubespecialidades;
    private javax.swing.JButton JBTNCrearSubespecialidad;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMAgregarEnfermedad;
    private javax.swing.JMenuItem JMENUITEMAsignarMuestrasBiologicas;
    private javax.swing.JMenuItem JMENUITEMEliminarSubespecialidad;
    private javax.swing.JMenuItem JMENUITEMModificarSubespecialidad;
    private javax.swing.JMenuItem JMENUITEMVerEnfermedadesAgregadas;
    private javax.swing.JMenuItem JMENUITEMVerMuestrasBiologicasAsignadas;
    private javax.swing.JPopupMenu JPOPUPMENUItemSubespecialidades;
    private javax.swing.JTable JTBLSubespecialidades;
    private javax.swing.JTextField JTXTFBuscarSubespecialidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelGestionSubespecialidades.limpiarLista();
        presenterGestionSubespecialidades.obtenerSubespecialidades();
    }
    private Subespecialidad obtenerSubespecialidadSeleccionada() {
        final int rowModel = JTBLSubespecialidades.convertRowIndexToModel(JTBLSubespecialidades.getSelectedRow());
        return tableModelGestionSubespecialidades.getSubespecialidad(rowModel);
    }
    
    @Override
    public void subespecialidadesObtenidas(final List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas) {
        tableModelGestionSubespecialidades.setSubespecialidadesPersonalizadas(subespecialidadesPersonalizadas);
        JTBLSubespecialidades.setRowSorter(new TableRowSorter<>(tableModelGestionSubespecialidades));
        JTBLSubespecialidades.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarSubespecialidad.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaSubespecialidadesVacia(final String msg) {
        JTXTFBuscarSubespecialidad.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerSubespecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerSubespecialidades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void existeSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void subespecialidadEliminada(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarSubespecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
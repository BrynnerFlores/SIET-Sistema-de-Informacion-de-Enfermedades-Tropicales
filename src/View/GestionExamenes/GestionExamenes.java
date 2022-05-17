package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJOPersonalizado.ExamenPersonalizado;
import Presenter.GestionExamenes.PresenterGestionExamenes;
import View.Utilitarios.ModelTable.GestionExamenes.TableModelGestionExamenes;
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
public class GestionExamenes extends javax.swing.JInternalFrame implements PresenterGestionExamenes.CallBackObtenerExamenes, PresenterGestionExamenes.CallBackEliminarExamen {

    private final TableModelGestionExamenes tableModelGestionExamenes;
    private final PresenterGestionExamenes presenterGestionExamenes;

    public GestionExamenes() {

        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionExamenes.setCallBackObtenerExamenes(this);
        presenterGestionExamenes.setCallBackEliminarExamen(this);

        tableModelGestionExamenes = new TableModelGestionExamenes();

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemExamenes = new javax.swing.JPopupMenu();
        JMENUITEMCrearGrupoDeVariables = new javax.swing.JMenuItem();
        JMENUITEMVerGrupoVariables = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMAgregarPosibleResultado = new javax.swing.JMenuItem();
        JMENUITEMVerPosiblesResultados = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMAgregarTecnica = new javax.swing.JMenuItem();
        JMENUITEMVerTecnicasAgregadas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarExamen = new javax.swing.JMenuItem();
        JMENUITEMEliminarExamen = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        JTXTFBuscarExamen = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLExamenes = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNCrearExamen = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JMENUITEMCrearGrupoDeVariables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/nuevo_documento.png"))); // NOI18N
        JMENUITEMCrearGrupoDeVariables.setText("Crear Grupo de Variables");
        JMENUITEMCrearGrupoDeVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMCrearGrupoDeVariablesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMCrearGrupoDeVariables);

        JMENUITEMVerGrupoVariables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_informacion.png"))); // NOI18N
        JMENUITEMVerGrupoVariables.setText("Ver Grupos de Variables");
        JMENUITEMVerGrupoVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerGrupoVariablesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMVerGrupoVariables);
        JPOPUPMENUItemExamenes.add(jSeparator1);

        JMENUITEMAgregarPosibleResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAgregarPosibleResultado.setText("Agregar Posible Resultado");
        JMENUITEMAgregarPosibleResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAgregarPosibleResultadoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMAgregarPosibleResultado);

        JMENUITEMVerPosiblesResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerPosiblesResultados.setText("Ver Posibles Resultados");
        JMENUITEMVerPosiblesResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerPosiblesResultadosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMVerPosiblesResultados);
        JPOPUPMENUItemExamenes.add(jSeparator2);

        JMENUITEMAgregarTecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAgregarTecnica.setText("Agregar Técnica");
        JMENUITEMAgregarTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAgregarTecnicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMAgregarTecnica);

        JMENUITEMVerTecnicasAgregadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerTecnicasAgregadas.setText("Ver Técnicas Agregadas");
        JMENUITEMVerTecnicasAgregadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerTecnicasAgregadasActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMVerTecnicasAgregadas);
        JPOPUPMENUItemExamenes.add(jSeparator3);

        JMENUITEMModificarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarExamen.setText("Modificar Examen");
        JMENUITEMModificarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarExamenActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMModificarExamen);

        JMENUITEMEliminarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarExamen.setText("Eliminar Examen");
        JMENUITEMEliminarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarExamenActionPerformed(evt);
            }
        });
        JPOPUPMENUItemExamenes.add(JMENUITEMEliminarExamen);

        setTitle("Gestión de Exámenes");
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Examen"));

        JTXTFBuscarExamen.setEnabled(false);
        JTXTFBuscarExamen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarExamenFocusGained(evt);
            }
        });
        JTXTFBuscarExamen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarExamenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarExamenKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarExamen)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Exámenes"));

        JTBLExamenes.setModel(tableModelGestionExamenes);
        JTBLExamenes.setComponentPopupMenu(JPOPUPMENUItemExamenes);
        JTBLExamenes.setEnabled(false);
        JTBLExamenes.setRowHeight(20);
        JTBLExamenes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLExamenesMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLExamenes.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLExamenes.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLExamenes.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLExamenes.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
        JTBLExamenes.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);

        JTBLExamenes.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLExamenes.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLExamenes.getColumnModel().getColumn(2).setPreferredWidth(400);
        JTBLExamenes.getColumnModel().getColumn(3).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(4).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(5).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(6).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(7).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLExamenes);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
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

        JBTNCrearExamen.setText("CREAR EXAMEN");
        JBTNCrearExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCrearExamenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNCrearExamen)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNCrearExamen))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXAMEN", "CODIGO" }));
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        presenterGestionExamenes.obtenerExamenes();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarExamenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarExamenKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarExamen.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarExamenKeyTyped

    private void JTXTFBuscarExamenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarExamenKeyReleased
        final String search = JTXTFBuscarExamen.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLExamenes.getRowSorter();

        if (JCMBXBuscarPor.getSelectedIndex() == 0) {
            sorter.setRowFilter(RowFilter.regexFilter(search, 2));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(search, 1));
        }
    }//GEN-LAST:event_JTXTFBuscarExamenKeyReleased

    private void JTBLExamenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLExamenesMousePressed
        final int currentRow = JTBLExamenes.rowAtPoint(evt.getPoint());
        JTBLExamenes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLExamenesMousePressed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNCrearExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCrearExamenActionPerformed
        final CrearExamen crearExamen = new CrearExamen(null, true);
        crearExamen.setVisible(true);

        if (!crearExamen.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNCrearExamenActionPerformed

    private void JMENUITEMCrearGrupoDeVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMCrearGrupoDeVariablesActionPerformed
        final Examen examen = obtenerExamenSeleccionado();

        final CrearGrupoVariables crearGrupoVariables = new CrearGrupoVariables(null, true);
        crearGrupoVariables.setExamen(examen);
        crearGrupoVariables.setVisible(true);

        if (!crearGrupoVariables.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMCrearGrupoDeVariablesActionPerformed

    private void JMENUITEMModificarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarExamenActionPerformed
        final Examen examen = obtenerExamenSeleccionado();

        final ModificarExamen modificarExamen = new ModificarExamen(null, true);
        modificarExamen.setExamen(examen);
        modificarExamen.setVisible(true);

        if (!modificarExamen.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarExamenActionPerformed

    private void JMENUITEMVerGrupoVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerGrupoVariablesActionPerformed
        final Examen examen = obtenerExamenSeleccionado();

        final VerGruposVariables verGruposVariables = new VerGruposVariables(null, true);
        verGruposVariables.setExamen(examen);
        verGruposVariables.setVisible(true);
        
        if (!verGruposVariables.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerGrupoVariablesActionPerformed

    private void JMENUITEMEliminarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarExamenActionPerformed
        final Examen examen = obtenerExamenSeleccionado();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar examen?\n\nDatos:\n"
                + "\nEXAMEN: " + examen.getExamenNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionExamenes.eliminarExamen(examen);
        }
    }//GEN-LAST:event_JMENUITEMEliminarExamenActionPerformed

    private void JMENUITEMAgregarPosibleResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAgregarPosibleResultadoActionPerformed
        final AgregarPosiblesResultados agregarPosiblesResultados = new AgregarPosiblesResultados(null, true);
        agregarPosiblesResultados.setExamen(obtenerExamenSeleccionado());
        agregarPosiblesResultados.setVisible(true);
        
        if (!agregarPosiblesResultados.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMAgregarPosibleResultadoActionPerformed

    private void JMENUITEMVerPosiblesResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerPosiblesResultadosActionPerformed
        final VerPosiblesResultados verPosiblesResultados = new VerPosiblesResultados(null, true);
        verPosiblesResultados.setExamen(obtenerExamenSeleccionado());
        verPosiblesResultados.setVisible(true);
        
        if (!verPosiblesResultados.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerPosiblesResultadosActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarExamen.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JMENUITEMAgregarTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAgregarTecnicaActionPerformed
        final AgregarTecnica agregarTecnica = new AgregarTecnica(null, true);
        agregarTecnica.setExamen(obtenerExamenSeleccionado());
        agregarTecnica.setVisible(true);
        
        if (!agregarTecnica.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMAgregarTecnicaActionPerformed

    private void JMENUITEMVerTecnicasAgregadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerTecnicasAgregadasActionPerformed
        final VerTecnicasAgregadas verTecnicasAgregadas = new VerTecnicasAgregadas(null, true);
        verTecnicasAgregadas.setExamen(obtenerExamenSeleccionado());
        verTecnicasAgregadas.setVisible(true);
        
        if (!verTecnicasAgregadas.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerTecnicasAgregadasActionPerformed

    private void JTXTFBuscarExamenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarExamenFocusGained
        JTXTFBuscarExamen.selectAll();
    }//GEN-LAST:event_JTXTFBuscarExamenFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNCrearExamen;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMAgregarPosibleResultado;
    private javax.swing.JMenuItem JMENUITEMAgregarTecnica;
    private javax.swing.JMenuItem JMENUITEMCrearGrupoDeVariables;
    private javax.swing.JMenuItem JMENUITEMEliminarExamen;
    private javax.swing.JMenuItem JMENUITEMModificarExamen;
    private javax.swing.JMenuItem JMENUITEMVerGrupoVariables;
    private javax.swing.JMenuItem JMENUITEMVerPosiblesResultados;
    private javax.swing.JMenuItem JMENUITEMVerTecnicasAgregadas;
    private javax.swing.JPopupMenu JPOPUPMENUItemExamenes;
    private javax.swing.JTable JTBLExamenes;
    private javax.swing.JTextField JTXTFBuscarExamen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelGestionExamenes.limpiarLista();
        presenterGestionExamenes.obtenerExamenes();
    }

    private Examen obtenerExamenSeleccionado() {
        final int rowModel = JTBLExamenes.convertRowIndexToModel(JTBLExamenes.getSelectedRow());
        return tableModelGestionExamenes.getExamen(rowModel);
    }

    @Override
    public void examenesObtenidos(final List<ExamenPersonalizado> examenesPersonalizados) {
        tableModelGestionExamenes.setExamenes(examenesPersonalizados);
        JTBLExamenes.setRowSorter(new TableRowSorter<>(tableModelGestionExamenes));
        JTBLExamenes.getTableHeader().setReorderingAllowed(false);
        
        JTXTFBuscarExamen.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaExamenesVacia(final String msg) {
        JTXTFBuscarExamen.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerExamenes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerExamenes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void examenEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarExamen(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
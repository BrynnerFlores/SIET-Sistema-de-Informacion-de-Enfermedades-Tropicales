package View.GestionMuestrasBiologicas;

import Model.POJO.MuestraBiologica;
import Model.POJOPersonalizado.MuestraBiologicaPersonalizada;
import Presenter.GestionMuestrasBiologicas.PresenterGestionMuestrasBiologicas;
import View.Utilitarios.ModelTable.GestionMuestrasBiologicas.TableModelGestionMuestrasBiologicas;
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
public class GestionMuestrasBiologicas extends javax.swing.JInternalFrame implements PresenterGestionMuestrasBiologicas.CallBackObtenerMuestrasBiologicas, PresenterGestionMuestrasBiologicas.CallBackEliminarMuestraBiologica {

    private final TableModelGestionMuestrasBiologicas tableModelGestionMuestrasBiologicas;
    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;

    public GestionMuestrasBiologicas() {
        
        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionMuestrasBiologicas.setCallBackObtenerMuestrasBiologicas(this);
        presenterGestionMuestrasBiologicas.setCallBackEliminarMuestraBiologica(this);
        
        tableModelGestionMuestrasBiologicas = new TableModelGestionMuestrasBiologicas();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemMuestrasBiologicas = new javax.swing.JPopupMenu();
        JMENIITEMAgregarAspectoCalidad = new javax.swing.JMenuItem();
        JMENUITEMVerAspectosCalidades = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMAgregarParasitos = new javax.swing.JMenuItem();
        JMENUITEMVerParasitos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarMuestraBiologica = new javax.swing.JMenuItem();
        JMENUITEMEliminarMuestraBiologica = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarMuestraBiologica = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLMuestrasBiologicas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNCrearMuestraBiologica = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();

        JMENIITEMAgregarAspectoCalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENIITEMAgregarAspectoCalidad.setText("Agregar Aspecto/Calidad");
        JMENIITEMAgregarAspectoCalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENIITEMAgregarAspectoCalidadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENIITEMAgregarAspectoCalidad);

        JMENUITEMVerAspectosCalidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerAspectosCalidades.setText("Ver Aspectos/Calidades");
        JMENUITEMVerAspectosCalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerAspectosCalidadesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENUITEMVerAspectosCalidades);
        JPOPUPMENUItemMuestrasBiologicas.add(jSeparator1);

        JMENUITEMAgregarParasitos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/asignar.png"))); // NOI18N
        JMENUITEMAgregarParasitos.setText("Agregar Parásitos");
        JMENUITEMAgregarParasitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMAgregarParasitosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENUITEMAgregarParasitos);

        JMENUITEMVerParasitos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerParasitos.setText("Ver Parásitos");
        JMENUITEMVerParasitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerParasitosActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENUITEMVerParasitos);
        JPOPUPMENUItemMuestrasBiologicas.add(jSeparator2);

        JMENUITEMModificarMuestraBiologica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarMuestraBiologica.setText("Modificar Muestra Biológica");
        JMENUITEMModificarMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarMuestraBiologicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENUITEMModificarMuestraBiologica);

        JMENUITEMEliminarMuestraBiologica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarMuestraBiologica.setText("Eliminar Muestra Biológica");
        JMENUITEMEliminarMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarMuestraBiologicaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemMuestrasBiologicas.add(JMENUITEMEliminarMuestraBiologica);

        setTitle("Gestión de Muestras Biológicas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/muestras_biologicas.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Muestra Biológica"));

        JTXTFBuscarMuestraBiologica.setEnabled(false);
        JTXTFBuscarMuestraBiologica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarMuestraBiologicaFocusGained(evt);
            }
        });
        JTXTFBuscarMuestraBiologica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarMuestraBiologicaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarMuestraBiologicaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarMuestraBiologica)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Muestras Biológicas"));

        JTBLMuestrasBiologicas.setModel(tableModelGestionMuestrasBiologicas);
        JTBLMuestrasBiologicas.setComponentPopupMenu(JPOPUPMENUItemMuestrasBiologicas);
        JTBLMuestrasBiologicas.setEnabled(false);
        JTBLMuestrasBiologicas.setRowHeight(20);
        JTBLMuestrasBiologicas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLMuestrasBiologicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLMuestrasBiologicasMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);

        JTBLMuestrasBiologicas.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(2).setPreferredWidth(800);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTBLMuestrasBiologicas.getColumnModel().getColumn(4).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLMuestrasBiologicas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
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

        JBTNCrearMuestraBiologica.setText("CREAR MUESTRA BIOLOGICA");
        JBTNCrearMuestraBiologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCrearMuestraBiologicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNCrearMuestraBiologica)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNCrearMuestraBiologica))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MUESTRA BIOLOGICA", "CODIGO" }));
        JCMBXBuscarPor.setEnabled(false);
        JCMBXBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXBuscarPorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JCMBXBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        presenterGestionMuestrasBiologicas.obtenerMuestrasBiologicas();
    }//GEN-LAST:event_formInternalFrameActivated

    private void JTXTFBuscarMuestraBiologicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarMuestraBiologicaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarMuestraBiologica.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarMuestraBiologicaKeyTyped

    private void JTXTFBuscarMuestraBiologicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarMuestraBiologicaKeyReleased
        final String search = JTXTFBuscarMuestraBiologica.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLMuestrasBiologicas.getRowSorter();

        if (JCMBXBuscarPor.getSelectedIndex() == 0) {
            sorter.setRowFilter(RowFilter.regexFilter(search, 2));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(search, 1));
        }
    }//GEN-LAST:event_JTXTFBuscarMuestraBiologicaKeyReleased

    private void JTBLMuestrasBiologicasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLMuestrasBiologicasMousePressed
        final int currentRow = JTBLMuestrasBiologicas.rowAtPoint(evt.getPoint());
        JTBLMuestrasBiologicas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLMuestrasBiologicasMousePressed

    private void JMENUITEMModificarMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarMuestraBiologicaActionPerformed
        final ModificarMuestraBiologica modificarMuestraBiologica = new ModificarMuestraBiologica(null, true);
        modificarMuestraBiologica.setMuestraBiologica(obtenerMuestraBiologicaSeleccionada());
        modificarMuestraBiologica.setVisible(true);

        if (!modificarMuestraBiologica.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarMuestraBiologicaActionPerformed

    private void JMENUITEMEliminarMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarMuestraBiologicaActionPerformed
        final MuestraBiologica muestraBiologica = obtenerMuestraBiologicaSeleccionada();

        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar la muestra biológica?\n\nYa no estará disponible para ser usado en futuros exámenes.\nNo se veran afectados los resultados de los exámenes pasados.\n\nDATOS:\n\nMUESTRA BIOLOGICA = " + muestraBiologica.getMuestraBiologicaTipo() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (option == 0) {
            presenterGestionMuestrasBiologicas.eliminarMuestraBiologica(muestraBiologica);
        }
    }//GEN-LAST:event_JMENUITEMEliminarMuestraBiologicaActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        presenterGestionMuestrasBiologicas.obtenerMuestrasBiologicas();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNCrearMuestraBiologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCrearMuestraBiologicaActionPerformed
        final CrearMuestraBiologica crearMuestraBiologica = new CrearMuestraBiologica(null, true);
        crearMuestraBiologica.setVisible(true);

        if (!crearMuestraBiologica.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNCrearMuestraBiologicaActionPerformed

    private void JMENIITEMAgregarAspectoCalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENIITEMAgregarAspectoCalidadActionPerformed
        final AgregarAspectoCalidad agregarAspecto = new AgregarAspectoCalidad(null, true);
        agregarAspecto.setMuestraBiologica(obtenerMuestraBiologicaSeleccionada());
        agregarAspecto.setVisible(true);
        
        if (!agregarAspecto.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENIITEMAgregarAspectoCalidadActionPerformed

    private void JMENUITEMVerAspectosCalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerAspectosCalidadesActionPerformed
        final VerAspectoCalidad verAspectos = new VerAspectoCalidad(null, true);
        verAspectos.setMuestraBiologica(obtenerMuestraBiologicaSeleccionada());
        verAspectos.setVisible(true);
        
        if (!verAspectos.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerAspectosCalidadesActionPerformed

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarMuestraBiologica.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JMENUITEMAgregarParasitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMAgregarParasitosActionPerformed
        final AgregarParasito agregarParasito = new AgregarParasito(null, true);
        agregarParasito.setMuestraBiologica(obtenerMuestraBiologicaSeleccionada());
        agregarParasito.setVisible(true);
        
        if (!agregarParasito.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMAgregarParasitosActionPerformed

    private void JMENUITEMVerParasitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerParasitosActionPerformed
        final VerParasitos verParasitos = new VerParasitos(null, true);
        verParasitos.setMuestraBiologica(obtenerMuestraBiologicaSeleccionada());
        verParasitos.setVisible(true);
        
        if (!verParasitos.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerParasitosActionPerformed

    private void JTXTFBuscarMuestraBiologicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarMuestraBiologicaFocusGained
        JTXTFBuscarMuestraBiologica.selectAll();
    }//GEN-LAST:event_JTXTFBuscarMuestraBiologicaFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNCrearMuestraBiologica;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENIITEMAgregarAspectoCalidad;
    private javax.swing.JMenuItem JMENUITEMAgregarParasitos;
    private javax.swing.JMenuItem JMENUITEMEliminarMuestraBiologica;
    private javax.swing.JMenuItem JMENUITEMModificarMuestraBiologica;
    private javax.swing.JMenuItem JMENUITEMVerAspectosCalidades;
    private javax.swing.JMenuItem JMENUITEMVerParasitos;
    private javax.swing.JPopupMenu JPOPUPMENUItemMuestrasBiologicas;
    private javax.swing.JTable JTBLMuestrasBiologicas;
    private javax.swing.JTextField JTXTFBuscarMuestraBiologica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelGestionMuestrasBiologicas.limpiarLista();
        presenterGestionMuestrasBiologicas.obtenerMuestrasBiologicas();
    }
    private MuestraBiologica obtenerMuestraBiologicaSeleccionada() {
        final int rowModel = JTBLMuestrasBiologicas.convertRowIndexToModel(JTBLMuestrasBiologicas.getSelectedRow());
        return tableModelGestionMuestrasBiologicas.getMuestraBiologica(rowModel);
    }

    @Override
    public void muestrasBiologicasObtenidas(final List<MuestraBiologicaPersonalizada> muestrasBiologicasPersonalizadas) {
        tableModelGestionMuestrasBiologicas.setMuestrasBiologicasPersonalizadas(muestrasBiologicasPersonalizadas);
        JTBLMuestrasBiologicas.setRowSorter(new TableRowSorter<>(tableModelGestionMuestrasBiologicas));
        JTBLMuestrasBiologicas.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarMuestraBiologica.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
    }

    @Override
    public void listaMuestrasBiologicasVacia(final String msg) {
        JTXTFBuscarMuestraBiologica.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerMuestrasBiologicas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerMuestrasBiologicas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void muestraBiologicaEliminada() {
        presenterGestionMuestrasBiologicas.obtenerMuestrasBiologicas();
    }

    @Override
    public void errorEliminarMuestraBiologica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarMuestraBiologica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
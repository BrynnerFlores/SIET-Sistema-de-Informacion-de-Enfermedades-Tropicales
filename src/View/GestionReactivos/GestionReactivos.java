package View.GestionReactivos;

import Model.POJO.Reactivo;
import Model.POJO.Reportes.Reactivos.ReactivosInforme;
import Model.POJOPersonalizado.ReactivoPersonalizado;
import Presenter.GestionReactivos.PresenterGestionReactivos;
import View.Utilitarios.ModelTable.GestionReactivos.TableModelGestionReactivos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Brynner
 */
public class GestionReactivos extends javax.swing.JInternalFrame implements PresenterGestionReactivos.CallBackObtenerReactivos, PresenterGestionReactivos.CallBackEliminarReactivo {
    
    private final TableModelGestionReactivos tableModelGestionReactivos;
    private final PresenterGestionReactivos presenterGestionReactivos;
    
    public GestionReactivos() {
        
        tableModelGestionReactivos = new TableModelGestionReactivos();
        
        presenterGestionReactivos = new PresenterGestionReactivos();
        presenterGestionReactivos.setCallBackObtenerReactivos(this);
        presenterGestionReactivos.setCallBackEliminarReactivo(this);
        
        initComponents();
        
        presenterGestionReactivos.obtenerReactivos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemReactivo = new javax.swing.JPopupMenu();
        JMENUITEMVerLotes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMENUITEMModificarReactivo = new javax.swing.JMenuItem();
        JMENUITEMEliminarReactivo = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarReactivo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLReactivos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNNuevoReactivo = new javax.swing.JButton();
        JBTNImprimir = new javax.swing.JButton();

        JMENUITEMVerLotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_detalles_recepcion.png"))); // NOI18N
        JMENUITEMVerLotes.setText("Ver Lotes");
        JMENUITEMVerLotes.setToolTipText("");
        JMENUITEMVerLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerLotesActionPerformed(evt);
            }
        });
        JPOPUPMENUItemReactivo.add(JMENUITEMVerLotes);
        JPOPUPMENUItemReactivo.add(jSeparator2);

        JMENUITEMModificarReactivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarReactivo.setText("Modificar Reactivo");
        JMENUITEMModificarReactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarReactivoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemReactivo.add(JMENUITEMModificarReactivo);

        JMENUITEMEliminarReactivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarReactivo.setText("Eliminar Reactivo");
        JMENUITEMEliminarReactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarReactivoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemReactivo.add(JMENUITEMEliminarReactivo);

        setTitle("Gestión de Reactivos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/ver_reactivos.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Reactivo"));

        JTXTFBuscarReactivo.setEnabled(false);
        JTXTFBuscarReactivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarReactivoFocusGained(evt);
            }
        });
        JTXTFBuscarReactivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarReactivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarReactivoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarReactivo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REACTIVO", "CODIGO" }));
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Reactivos"));

        JTBLReactivos.setModel(tableModelGestionReactivos);
        JTBLReactivos.setComponentPopupMenu(JPOPUPMENUItemReactivo);
        JTBLReactivos.setRowHeight(20);
        JTBLReactivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLReactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLReactivosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLReactivos.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivos.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLReactivos.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);

        JTBLReactivos.getColumnModel().getColumn(0).setPreferredWidth(10);
        JTBLReactivos.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLReactivos.getColumnModel().getColumn(2).setPreferredWidth(950);
        JTBLReactivos.getColumnModel().getColumn(3).setPreferredWidth(100);
        jScrollPane1.setViewportView(JTBLReactivos);

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

        JBTNNuevoReactivo.setText("NUEVO REACTIVO");
        JBTNNuevoReactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNNuevoReactivoActionPerformed(evt);
            }
        });

        JBTNImprimir.setText("IMPRIMIR");
        JBTNImprimir.setEnabled(false);
        JBTNImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addGap(18, 18, 18)
                .addComponent(JBTNImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNNuevoReactivo)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNNuevoReactivo)
                    .addComponent(JBTNImprimir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void JTXTFBuscarReactivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarReactivoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFBuscarReactivo.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarReactivoKeyTyped

    private void JTXTFBuscarReactivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarReactivoKeyReleased
        final String search = JTXTFBuscarReactivo.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLReactivos.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 2));
                break;

            case 1:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 2));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarReactivoKeyReleased

    private void JCMBXBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXBuscarPorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JTXTFBuscarReactivo.requestFocus();
        }
    }//GEN-LAST:event_JCMBXBuscarPorItemStateChanged

    private void JTBLReactivosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLReactivosMousePressed
        final int currentRow = JTBLReactivos.rowAtPoint(evt.getPoint());
        JTBLReactivos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLReactivosMousePressed

    private void JMENUITEMVerLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerLotesActionPerformed
        final VerLotes verLotes = new VerLotes(null, true);
        verLotes.setReactivo(obtenerReactivoSeleccionado());
        verLotes.setVisible(true);
        
        if (!verLotes.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMVerLotesActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNNuevoReactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNNuevoReactivoActionPerformed
        final NuevoReactivo nuevoReactivo = new NuevoReactivo(null, true);
        nuevoReactivo.setVisible(true);
        
        if (!nuevoReactivo.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNNuevoReactivoActionPerformed

    private void JMENUITEMModificarReactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarReactivoActionPerformed
        final ModificarReactivo modificarReactivo = new ModificarReactivo(null, true);
        modificarReactivo.setReactivo(obtenerReactivoSeleccionado());
        modificarReactivo.setVisible(true);
        
        if (!modificarReactivo.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarReactivoActionPerformed

    private void JMENUITEMEliminarReactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarReactivoActionPerformed
        final Reactivo reactivo = obtenerReactivoSeleccionado();
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar el reactivo?\n\nDatos:\n\nREACTIVO: " + reactivo.getNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionReactivos.eliminarReactivo(reactivo);
        }
    }//GEN-LAST:event_JMENUITEMEliminarReactivoActionPerformed

    private void JTXTFBuscarReactivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarReactivoFocusGained
        JTXTFBuscarReactivo.selectAll();
    }//GEN-LAST:event_JTXTFBuscarReactivoFocusGained

    private void JBTNImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNImprimirActionPerformed
        try {
            final Map<String, Object> parameters = new HashMap<>();
            final List<ReactivosInforme> reactivosInforme = new ArrayList<>();
            
            parameters.put("LOGO_CERETROP", getClass().getResourceAsStream("/View/icons/logo_ceretrop.png"));
            
            for (int i = 0; i < tableModelGestionReactivos.getReactivosPersonalizados().size(); i++) {
                final ReactivoPersonalizado reactivoPersonalizado = tableModelGestionReactivos.getReactivoPersonalizado(i);
                reactivosInforme.add(new ReactivosInforme(i+1, reactivoPersonalizado.getReactivo().getNombre(), reactivoPersonalizado.getSaldo()));
            }
            
            final JRBeanCollectionDataSource dataSourceTablaIntervenciones = new JRBeanCollectionDataSource(reactivosInforme);
            parameters.put("TABLA_REACTIVOS", dataSourceTablaIntervenciones);

            final JasperReport jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("ReporteReactivos.jrxml"));
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jasperViewer.setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
            jasperViewer.setTitle("SIET - Sistema de Información de Enfermedades Tropicales");
            jasperViewer.setVisible(true);
        } catch (final JRException exception) {
            System.err.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNImprimir;
    private javax.swing.JButton JBTNNuevoReactivo;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMEliminarReactivo;
    private javax.swing.JMenuItem JMENUITEMModificarReactivo;
    private javax.swing.JMenuItem JMENUITEMVerLotes;
    private javax.swing.JPopupMenu JPOPUPMENUItemReactivo;
    private javax.swing.JTable JTBLReactivos;
    private javax.swing.JTextField JTXTFBuscarReactivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private Reactivo obtenerReactivoSeleccionado() {
        final int rowModel = JTBLReactivos.convertRowIndexToModel(JTBLReactivos.getSelectedRow());
        return tableModelGestionReactivos.getReactivoPersonalizado(rowModel).getReactivo();
    }
    
    private void actualizarTabla() {
        tableModelGestionReactivos.limpiarLista();
        presenterGestionReactivos.obtenerReactivos();
    }
    
    @Override
    public void reactivosObtenidos(final List<ReactivoPersonalizado> reactivosPersonalizados) {
        tableModelGestionReactivos.setReactivosPersonalizados(reactivosPersonalizados);
        JTBLReactivos.setRowSorter(new TableRowSorter<>(tableModelGestionReactivos));
        JTBLReactivos.getTableHeader().setReorderingAllowed(false);
        JTBLReactivos.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (Integer.valueOf(String.valueOf(value)) <= 2) {
                    component.setBackground(Color.RED);
                } else if (Integer.valueOf(String.valueOf(value)) > 2 && Integer.valueOf(String.valueOf(value)) <= 4) {
                    component.setBackground(Color.YELLOW);
                } else {
                    component.setBackground(Color.GREEN);
                }
                return component;
            }
        });
        
        JTXTFBuscarReactivo.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);
        JBTNImprimir.setEnabled(true);
    }

    @Override
    public void listaReactivosVacia(final String msg) {
        JTXTFBuscarReactivo.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
        JBTNImprimir.setEnabled(false);
    }

    @Override
    public void errorObtenerReactivos(final String msg) {
        JBTNImprimir.setEnabled(false);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerReactivos(final String msg) {
        JBTNImprimir.setEnabled(false);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void reactivoEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarReactivo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarReactivo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
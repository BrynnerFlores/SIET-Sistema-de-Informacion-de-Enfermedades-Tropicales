package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Equipo;
import Model.POJO.Intervencion;
import Presenter.GestionEquipos.PresenterGestionEquipos;
import View.GestionEquipos.GestionEquiposIntervencion.DetallesIntervencion;
import View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposActivos.TableModelHistorialEquipo;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class VerHistorialEquipo extends javax.swing.JDialog implements PresenterGestionEquipos.CallBackObtenerIntervencionesEquipo {

    private final TableModelHistorialEquipo tableModelHistorialEquipo;
    private final PresenterGestionEquipos presenterGestionEquipos;
    private Equipo equipo;

    public VerHistorialEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        tableModelHistorialEquipo = new TableModelHistorialEquipo();
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionEquipos.setCallBackObtenerIntervencionesEquipo(this);

        initComponents();
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEquipoIntervencion = new javax.swing.JPopupMenu();
        JMENUITEMVerDetallesIntervencion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JTXTFBuscarIntervencion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JCMBXBuscarPor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLIntervencionesEquipo = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();
        JBTNImprimir = new javax.swing.JButton();

        JMENUITEMVerDetallesIntervencion.setText("Ver Detalles de Intervención");
        JMENUITEMVerDetallesIntervencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMVerDetallesIntervencionActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEquipoIntervencion.add(JMENUITEMVerDetallesIntervencion);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Historial del Equipo");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Intervención"));

        JTXTFBuscarIntervencion.setEnabled(false);
        JTXTFBuscarIntervencion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFBuscarIntervencionFocusGained(evt);
            }
        });
        JTXTFBuscarIntervencion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFBuscarIntervencionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFBuscarIntervencionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarIntervencion)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTXTFBuscarIntervencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        JCMBXBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO" }));
        JCMBXBuscarPor.setEnabled(false);

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervenciones del Equipo"));

        JTBLIntervencionesEquipo.setModel(tableModelHistorialEquipo);
        JTBLIntervencionesEquipo.setComponentPopupMenu(JPOPUPMENUItemEquipoIntervencion);
        JTBLIntervencionesEquipo.setEnabled(false);
        JTBLIntervencionesEquipo.setRowHeight(20);
        JTBLIntervencionesEquipo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLIntervencionesEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLIntervencionesEquipoMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(8).setCellRenderer(defaultTableCellRenderer);

        JTBLIntervencionesEquipo.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(1).setPreferredWidth(80);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(2).setPreferredWidth(80);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(3).setPreferredWidth(80);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(5).setPreferredWidth(150);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(6).setPreferredWidth(250);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(7).setPreferredWidth(50);
        JTBLIntervencionesEquipo.getColumnModel().getColumn(8).setPreferredWidth(150);
        jScrollPane1.setViewportView(JTBLIntervencionesEquipo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
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

        JBTNImprimir.setText("IMPRIMIR");
        JBTNImprimir.setEnabled(false);
        JBTNImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNImprimirActionPerformed(evt);
            }
        });

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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNImprimir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNImprimir))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (equipo == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                presenterGestionEquipos.obtenerIntervencionesEquipo(equipo);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFBuscarIntervencionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarIntervencionKeyTyped
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFBuscarIntervencionKeyTyped

    private void JTXTFBuscarIntervencionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFBuscarIntervencionKeyReleased
        final String search = JTXTFBuscarIntervencion.getText().toUpperCase();
        final TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) JTBLIntervencionesEquipo.getRowSorter();

        final int selectedIndex = JCMBXBuscarPor.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;

            default:
                sorter.setRowFilter(RowFilter.regexFilter(search, 1));
                break;
        }
    }//GEN-LAST:event_JTXTFBuscarIntervencionKeyReleased

    private void JTBLIntervencionesEquipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLIntervencionesEquipoMousePressed
        final int currentRow = JTBLIntervencionesEquipo.rowAtPoint(evt.getPoint());
        JTBLIntervencionesEquipo.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLIntervencionesEquipoMousePressed

    private void JMENUITEMVerDetallesIntervencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMVerDetallesIntervencionActionPerformed
        final DetallesIntervencion detallesIntervencion = new DetallesIntervencion(null, true);
        detallesIntervencion.setIntervencion(obtenerIntervencionEquipoSeleccionada());
        detallesIntervencion.setVisible(true);
    }//GEN-LAST:event_JMENUITEMVerDetallesIntervencionActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JTXTFBuscarIntervencionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFBuscarIntervencionFocusGained
        JTXTFBuscarIntervencion.selectAll();
    }//GEN-LAST:event_JTXTFBuscarIntervencionFocusGained

    private void JBTNImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNImprimirActionPerformed
        try {
            final Map<String, Object> parameters = new HashMap<>();
            parameters.put("LOGO_CERETROP", getClass().getResourceAsStream("/View/icons/logo_ceretrop.png"));
            parameters.put("LOGO_CERETROP_DETALLES", getClass().getResourceAsStream("/View/icons/logo_ceretrop_opacity.png"));
            parameters.put("LOGO_BERMEJO", getClass().getResourceAsStream("/View/icons/logo_bermejo.png"));
            parameters.put("FOTO_EQUIPO", new ImageIcon(new ImageIcon(equipo.getEquipoFoto()).getImage()).getImage());
            parameters.put("EQUIPO", equipo.getEquipoNombre());
            parameters.put("MARCA", equipo.getEquipoMarca());
            parameters.put("MODELO", equipo.getEquipoModelo());
            parameters.put("SERIE", equipo.getEquipoNumeroSerie());
            parameters.put("FECHA_ADQUISICION", equipo.getEquipoFechaAdquisicion().toString());
            parameters.put("PROVEEDOR", equipo.getEquipoProveedor());
            parameters.put("RESPONSABLE_ENTREGA", equipo.getEquipoResponsableEntrega());
            parameters.put("TIEMPO_GARANTIA", String.valueOf(equipo.getEquipoGarantia()));
            parameters.put("UBICACION", equipo.getEquipoUbicacion());
            parameters.put("AREA_DE_SERVICIO", equipo.getSubespecialidad().getSubespecialidadNombre());
            parameters.put("INTEGRIDAD", equipo.getEquipoIntegridad());
            
            final JRBeanCollectionDataSource dataSourceTablaIntervenciones = new JRBeanCollectionDataSource(tableModelHistorialEquipo.getIntervenciones());
            parameters.put("TABLA_INTERVENCIONES", dataSourceTablaIntervenciones);

            final JasperReport jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("HistorialEquipo.jrxml"));
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jasperViewer.setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
            jasperViewer.setTitle("SIET - Sistema de Información de Enfermedades Tropicales");
            jasperViewer.setVisible(true);
        } catch (final JRException jRException) {
            System.err.println("Error: " + jRException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNImprimirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerHistorialEquipo dialog = new VerHistorialEquipo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNImprimir;
    private javax.swing.JComboBox<String> JCMBXBuscarPor;
    private javax.swing.JMenuItem JMENUITEMVerDetallesIntervencion;
    private javax.swing.JPopupMenu JPOPUPMENUItemEquipoIntervencion;
    private javax.swing.JTable JTBLIntervencionesEquipo;
    private javax.swing.JTextField JTXTFBuscarIntervencion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private Intervencion obtenerIntervencionEquipoSeleccionada() {
        final int rowModel = JTBLIntervencionesEquipo.convertRowIndexToModel(JTBLIntervencionesEquipo.getSelectedRow());
        return tableModelHistorialEquipo.getIntervencion(rowModel);
    }

    private void actualizarTabla() {
        tableModelHistorialEquipo.limpiarLista();
        presenterGestionEquipos.obtenerIntervencionesEquipo(equipo);
    }

    @Override
    public void intervencionesEquipoObtenidas(final List<Intervencion> intervenciones) {
        tableModelHistorialEquipo.setIntervenciones(intervenciones);
        JTBLIntervencionesEquipo.setRowSorter(new TableRowSorter<>(tableModelHistorialEquipo));
        JTBLIntervencionesEquipo.getTableHeader().setReorderingAllowed(false);

        JTXTFBuscarIntervencion.setEnabled(true);
        JCMBXBuscarPor.setEnabled(true);

        JBTNImprimir.setEnabled(true);
    }

    @Override
    public void listaIntervencionesEquipoVacia(final String msg) {
        JBTNImprimir.setEnabled(false);
        JTXTFBuscarIntervencion.setEnabled(false);
        JCMBXBuscarPor.setEnabled(false);
    }

    @Override
    public void errorObtenerIntervencionesEquipo(final String msg) {
        JBTNImprimir.setEnabled(false);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerIntervencionesEquipo(final String msg) {
        JBTNImprimir.setEnabled(false);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
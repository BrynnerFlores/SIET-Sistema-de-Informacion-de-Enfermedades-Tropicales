package View.GestionMuestrasBiologicas;

import Model.POJO.AspectoCalidad;
import Model.POJO.MuestraBiologica;
import Presenter.GestionMuestrasBiologicas.PresenterGestionAspectos;
import Presenter.GestionMuestrasBiologicas.PresenterGestionMuestrasBiologicas;
import View.Utilitarios.ModelTable.GestionMuestrasBiologicas.TableModelAspectoCalidad;
import java.awt.HeadlessException;
import java.awt.Point;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Brynner
 */
public class VerAspectoCalidad extends javax.swing.JDialog implements PresenterGestionMuestrasBiologicas.CallBackObtenerAspectos, PresenterGestionAspectos.CallBackEliminarAspecto {

    private final TableModelAspectoCalidad tableModelAspectos;
    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;
    private final PresenterGestionAspectos presenterGestionAspectos;
    private MuestraBiologica muestraBiologica;

    public VerAspectoCalidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionAspectos = new PresenterGestionAspectos();
        presenterGestionMuestrasBiologicas.setCallBackObtenerAspectos(this);
        presenterGestionAspectos.setCallBackEliminarAspecto(this);
        
        tableModelAspectos = new TableModelAspectoCalidad();
        
        initComponents();
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemAspecto = new javax.swing.JPopupMenu();
        JMENUITEMModificarAspecto = new javax.swing.JMenuItem();
        JMENUITEMEliminarAspecto = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLMuestraBiologicaTipo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLAspectoCalidad = new javax.swing.JTable();
        JBTNActualizar = new javax.swing.JButton();
        JBTNCerrar = new javax.swing.JButton();
        JBTNAgregarAspectoCalidad = new javax.swing.JButton();

        JMENUITEMModificarAspecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarAspecto.setText("Modificar Aspecto/Calidad");
        JMENUITEMModificarAspecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarAspectoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemAspecto.add(JMENUITEMModificarAspecto);

        JMENUITEMEliminarAspecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarAspecto.setText("Eliminar Aspecto/Calidad");
        JMENUITEMEliminarAspecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarAspectoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemAspecto.add(JMENUITEMEliminarAspecto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Aspecto Calidad");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Muestra Biológica"));

        jLabel1.setText("TIPO:");

        JLBLMuestraBiologicaTipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 470, Short.MAX_VALUE))
                    .addComponent(JLBLMuestraBiologicaTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLMuestraBiologicaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aspectos/Calidad de la Muestra Biológica"));

        JTBLAspectoCalidad.setModel(tableModelAspectos);
        JTBLAspectoCalidad.setComponentPopupMenu(JPOPUPMENUItemAspecto);
        JTBLAspectoCalidad.setEnabled(false);
        JTBLAspectoCalidad.setRowHeight(20);
        JTBLAspectoCalidad.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLAspectoCalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLAspectoCalidadMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLAspectoCalidad.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLAspectoCalidad.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);

        JTBLAspectoCalidad.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLAspectoCalidad.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLAspectoCalidad.getColumnModel().getColumn(2).setPreferredWidth(300);
        jScrollPane1.setViewportView(JTBLAspectoCalidad);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        JBTNAgregarAspectoCalidad.setText("AGREGAR ASPECTO CALIDAD");
        JBTNAgregarAspectoCalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAgregarAspectoCalidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNAgregarAspectoCalidad)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNAgregarAspectoCalidad))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTBLAspectoCalidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLAspectoCalidadMousePressed
        final Point point = evt.getPoint();
        final int currentRow = JTBLAspectoCalidad.rowAtPoint(point);
        JTBLAspectoCalidad.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLAspectoCalidadMousePressed

    private void JMENUITEMModificarAspectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarAspectoActionPerformed
        final ModificarAspecto modificarAspecto = new ModificarAspecto(null, true);
        modificarAspecto.setAspecto(obtenerAspectoSeleccionado());
        modificarAspecto.setVisible(true);
        
        if (!modificarAspecto.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarAspectoActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (muestraBiologica == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLMuestraBiologicaTipo.setText(muestraBiologica.getMuestraBiologicaTipo());
                actualizarTabla();
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JBTNAgregarAspectoCalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAgregarAspectoCalidadActionPerformed
        final AgregarAspectoCalidad agregarAspecto = new AgregarAspectoCalidad(null, true);
        agregarAspecto.setMuestraBiologica(muestraBiologica);
        agregarAspecto.setVisible(true);
        
        if (!agregarAspecto.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNAgregarAspectoCalidadActionPerformed

    private void JMENUITEMEliminarAspectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarAspectoActionPerformed
        final AspectoCalidad aspecto = obtenerAspectoSeleccionado();
        
        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el aspecto/calidad de la muestra biológica?\n\nDATOS:\n\nCODIGO: " + aspecto.getCodigoAspectoCalidad() + "\nTIPO: " + aspecto.getAspectoCalidad()+ "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionAspectos.eliminarAspecto(aspecto);
        }
    }//GEN-LAST:event_JMENUITEMEliminarAspectoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerAspectoCalidad dialog = new VerAspectoCalidad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAgregarAspectoCalidad;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLMuestraBiologicaTipo;
    private javax.swing.JMenuItem JMENUITEMEliminarAspecto;
    private javax.swing.JMenuItem JMENUITEMModificarAspecto;
    private javax.swing.JPopupMenu JPOPUPMENUItemAspecto;
    private javax.swing.JTable JTBLAspectoCalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    private void actualizarTabla() {
        tableModelAspectos.limpiarLista();
        presenterGestionMuestrasBiologicas.obtenerAspectos(muestraBiologica);
    }
    
    private AspectoCalidad obtenerAspectoSeleccionado() {
        final int rowModel = JTBLAspectoCalidad.convertRowIndexToModel(JTBLAspectoCalidad.getSelectedRow());
        return tableModelAspectos.getAspecto(rowModel);
    }
    
    @Override
    public void aspectosObtenidos(final List<AspectoCalidad> aspectos) {
        tableModelAspectos.setAspectos(aspectos);
        JTBLAspectoCalidad.getTableHeader().setReorderingAllowed(false);
    }
    
    @Override
    public void listaAspectosVacia(final String msg) {
    }

    @Override
    public void errorObtenerAspectos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerAspectos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void aspectoEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarAspecto(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarAspecto(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
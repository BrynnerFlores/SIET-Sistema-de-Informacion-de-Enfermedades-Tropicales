package View.GestionMuestrasBiologicas;

import Model.POJO.MuestraBiologica;
import Model.POJO.Parasito;
import Presenter.GestionMuestrasBiologicas.PresenterGestionMuestrasBiologicas;
import Presenter.GestionMuestrasBiologicas.PresenterGestionParasitos;
import View.Utilitarios.ModelTable.GestionMuestrasBiologicas.TableModelParasitos;
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
public class VerParasitos extends javax.swing.JDialog implements PresenterGestionMuestrasBiologicas.CallBackObtenerParasitos, PresenterGestionParasitos.CallBackEliminarParasito {

    private final TableModelParasitos tableModelParasitos;
    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;
    private final PresenterGestionParasitos presenterGestionParasitos;
    private MuestraBiologica muestraBiologica;

    public VerParasitos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionParasitos = new PresenterGestionParasitos();
        presenterGestionMuestrasBiologicas.setCallBackObtenerParasitos(this);
        presenterGestionParasitos.setCallBackEliminarParasito(this);
        
        tableModelParasitos = new TableModelParasitos();
        
        initComponents();
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemParasito = new javax.swing.JPopupMenu();
        JMENUITEMModificarParasito = new javax.swing.JMenuItem();
        JMENUITEMEliminarParasito = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLMuestraBiologicaTipo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLParasitos = new javax.swing.JTable();
        JBTNActualizar = new javax.swing.JButton();
        JBTNCerrar = new javax.swing.JButton();
        JBTNAgregarParasito = new javax.swing.JButton();

        JMENUITEMModificarParasito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarParasito.setText("Modificar Parasito");
        JMENUITEMModificarParasito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarParasitoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemParasito.add(JMENUITEMModificarParasito);

        JMENUITEMEliminarParasito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarParasito.setText("Eliminar Parasito");
        JMENUITEMEliminarParasito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarParasitoActionPerformed(evt);
            }
        });
        JPOPUPMENUItemParasito.add(JMENUITEMEliminarParasito);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Parásitos");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Parásitos de la Muestra Biológica"));

        JTBLParasitos.setModel(tableModelParasitos);
        JTBLParasitos.setComponentPopupMenu(JPOPUPMENUItemParasito);
        JTBLParasitos.setEnabled(false);
        JTBLParasitos.setRowHeight(20);
        JTBLParasitos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLParasitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLParasitosMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLParasitos.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLParasitos.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);

        JTBLParasitos.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLParasitos.getColumnModel().getColumn(1).setPreferredWidth(40);
        JTBLParasitos.getColumnModel().getColumn(2).setPreferredWidth(300);
        jScrollPane1.setViewportView(JTBLParasitos);

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

        JBTNAgregarParasito.setText("AGREGAR PARASITO");
        JBTNAgregarParasito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAgregarParasitoActionPerformed(evt);
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
                        .addComponent(JBTNAgregarParasito)))
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
                    .addComponent(JBTNAgregarParasito))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTBLParasitosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLParasitosMousePressed
        final Point point = evt.getPoint();
        final int currentRow = JTBLParasitos.rowAtPoint(point);
        JTBLParasitos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLParasitosMousePressed

    private void JMENUITEMModificarParasitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarParasitoActionPerformed
        final ModificarParasito modificarParasito = new ModificarParasito(null, true);
        modificarParasito.setParasito(obtenerParasitoSeleccionado());
        modificarParasito.setVisible(true);
        
        if (!modificarParasito.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarParasitoActionPerformed

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

    private void JBTNAgregarParasitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAgregarParasitoActionPerformed
        final AgregarParasito agregarParasito = new AgregarParasito(null, true);
        agregarParasito.setMuestraBiologica(muestraBiologica);
        agregarParasito.setVisible(true);
        
        if (!agregarParasito.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNAgregarParasitoActionPerformed

    private void JMENUITEMEliminarParasitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarParasitoActionPerformed
        final Parasito parasito = obtenerParasitoSeleccionado();
        
        final int option = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el parasito de la muestra biológica?\n\nDATOS:\n\nCODIGO: " + parasito.getCodigoParasito() + "\nNOMBRE: " + parasito.getParasitoNombre()+ "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);
        
        if (option == 0) {
            presenterGestionParasitos.eliminarParasito(parasito);
        }
    }//GEN-LAST:event_JMENUITEMEliminarParasitoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerParasitos dialog = new VerParasitos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAgregarParasito;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLMuestraBiologicaTipo;
    private javax.swing.JMenuItem JMENUITEMEliminarParasito;
    private javax.swing.JMenuItem JMENUITEMModificarParasito;
    private javax.swing.JPopupMenu JPOPUPMENUItemParasito;
    private javax.swing.JTable JTBLParasitos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    private void actualizarTabla() {
        tableModelParasitos.limpiarLista();
        presenterGestionMuestrasBiologicas.obtenerParasitos(muestraBiologica);
    }
    
    private Parasito obtenerParasitoSeleccionado() {
        final int rowModel = JTBLParasitos.convertRowIndexToModel(JTBLParasitos.getSelectedRow());
        return tableModelParasitos.getParasito(rowModel);
    }
    
    @Override
    public void parasitosObtenidos(final List<Parasito> parasitos) {
        tableModelParasitos.setParasitos(parasitos);
        JTBLParasitos.getTableHeader().setReorderingAllowed(false);
    }
    
    @Override
    public void listaParasitosVacia(final String msg) {
    }

    @Override
    public void errorObtenerParasitos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerParasitos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void parasitoEliminado(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarParasito(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarParasito(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
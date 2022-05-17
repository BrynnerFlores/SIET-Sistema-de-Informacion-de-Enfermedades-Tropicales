package View.GestionSubespecialidades;

import Model.POJO.Enfermedad;
import Model.POJO.Subespecialidad;
import Presenter.GestionSubespecialidades.PresenterGestionEnfermedades;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModelTable.GestionSubespecialidades.TableModelVerEnfermedadesAgregadas;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brynner
 */
public class VerEnfermedadesAgregadas extends javax.swing.JDialog implements PresenterGestionSubespecialidades.CallBackObtenerEnfermedades, PresenterGestionEnfermedades.CallBackEliminarEnfermedad {
    
    private final TableModelVerEnfermedadesAgregadas tableModelVerEnfermedadesAgregadas;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;
    private final PresenterGestionEnfermedades presenterGestionEnfermedades;
    
    private Subespecialidad subespecialidad;
    
    public VerEnfermedadesAgregadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        tableModelVerEnfermedadesAgregadas = new TableModelVerEnfermedadesAgregadas();
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();
        presenterGestionEnfermedades = new PresenterGestionEnfermedades();
        presenterGestionSubespecialidades.setCallBackObtenerEnfermedades(this);
        presenterGestionEnfermedades.setCallBackEliminarEnfermedad(this);
        
        initComponents();
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemEnfermedadAgregada = new javax.swing.JPopupMenu();
        JMENUITEMModificarEnfermedad = new javax.swing.JMenuItem();
        JMENUITEMEliminarEnfermedad = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLSubespecialidadNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEnfermedadesAgregadas = new javax.swing.JTable();
        JBTNCerrar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();
        JBTNAgregarEnfermedad = new javax.swing.JButton();

        JMENUITEMModificarEnfermedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarEnfermedad.setText("Modificar Enfermedad");
        JMENUITEMModificarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarEnfermedadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEnfermedadAgregada.add(JMENUITEMModificarEnfermedad);

        JMENUITEMEliminarEnfermedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarEnfermedad.setText("Eliminar Enfermedad");
        JMENUITEMEliminarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarEnfermedadActionPerformed(evt);
            }
        });
        JPOPUPMENUItemEnfermedadAgregada.add(JMENUITEMEliminarEnfermedad);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Enfermedades Agregadas");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Subespecialidad"));

        jLabel1.setText("SUBESPECIALIDAD:");

        JLBLSubespecialidadNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JLBLSubespecialidadNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLSubespecialidadNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Enfermedades Agregadas"));

        JTBLEnfermedadesAgregadas.setModel(tableModelVerEnfermedadesAgregadas);
        JTBLEnfermedadesAgregadas.setComponentPopupMenu(JPOPUPMENUItemEnfermedadAgregada);
        JTBLEnfermedadesAgregadas.setRowHeight(20);
        JTBLEnfermedadesAgregadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLEnfermedadesAgregadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLEnfermedadesAgregadasMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLEnfermedadesAgregadas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLEnfermedadesAgregadas.getColumnModel().getColumn(0).setPreferredWidth(30);
        JTBLEnfermedadesAgregadas.getColumnModel().getColumn(1).setPreferredWidth(500);
        jScrollPane1.setViewportView(JTBLEnfermedadesAgregadas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JBTNAgregarEnfermedad.setText("AGREGAR ENFERMEDAD");
        JBTNAgregarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAgregarEnfermedadActionPerformed(evt);
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
                        .addComponent(JBTNAgregarEnfermedad)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNAgregarEnfermedad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (subespecialidad == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLSubespecialidadNombre.setText(subespecialidad.getSubespecialidadNombre());
                presenterGestionSubespecialidades.obtenerEnfermedades(subespecialidad);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLEnfermedadesAgregadasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLEnfermedadesAgregadasMousePressed
        final int currentRow = JTBLEnfermedadesAgregadas.rowAtPoint(evt.getPoint());
        JTBLEnfermedadesAgregadas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLEnfermedadesAgregadasMousePressed

    private void JMENUITEMModificarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarEnfermedadActionPerformed
        final ModificarEnfermedad modificarEnfermedad = new ModificarEnfermedad(null, true);
        modificarEnfermedad.setEnfermedad(obtenerEnfermedadSeleccionada());
        modificarEnfermedad.setVisible(true);
        
        if (!modificarEnfermedad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JMENUITEMModificarEnfermedadActionPerformed

    private void JMENUITEMEliminarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarEnfermedadActionPerformed
        final Enfermedad enfermedad = obtenerEnfermedadSeleccionada();
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar la enfermedad?\n\nDatos:\n\nENFERMEDAD: " + enfermedad.getEnfermedadNombre() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionEnfermedades.eliminarEnfermedad(enfermedad);
        }
    }//GEN-LAST:event_JMENUITEMEliminarEnfermedadActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JBTNAgregarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAgregarEnfermedadActionPerformed
        final AgregarEnfermedad agregarEnfermedad = new AgregarEnfermedad(null, true);
        agregarEnfermedad.setSubespecialidad(subespecialidad);
        agregarEnfermedad.setVisible(true);
        
        if(!agregarEnfermedad.isVisible()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_JBTNAgregarEnfermedadActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerEnfermedadesAgregadas dialog = new VerEnfermedadesAgregadas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAgregarEnfermedad;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JLabel JLBLSubespecialidadNombre;
    private javax.swing.JMenuItem JMENUITEMEliminarEnfermedad;
    private javax.swing.JMenuItem JMENUITEMModificarEnfermedad;
    private javax.swing.JPopupMenu JPOPUPMENUItemEnfermedadAgregada;
    private javax.swing.JTable JTBLEnfermedadesAgregadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private Enfermedad obtenerEnfermedadSeleccionada() {
        final int rowModel = JTBLEnfermedadesAgregadas.convertRowIndexToModel(JTBLEnfermedadesAgregadas.getSelectedRow());
        return tableModelVerEnfermedadesAgregadas.getEnfermedad(rowModel);
    }
    
    private void actualizarTabla() {
        tableModelVerEnfermedadesAgregadas.limpiarLista();
        presenterGestionSubespecialidades.obtenerEnfermedades(subespecialidad);
    }
    
    @Override
    public void enfermedadesObtenidas(final List<Enfermedad> enfermedades) {
        tableModelVerEnfermedadesAgregadas.setEnfermedades(enfermedades);
        JTBLEnfermedadesAgregadas.setRowSorter(new TableRowSorter<>(tableModelVerEnfermedadesAgregadas));
        JTBLEnfermedadesAgregadas.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaEnfermedadesVacia(final String msg) {
    }

    @Override
    public void errorObtenerEnfermedades(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEnfermedades(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void enfermedadEliminada(final String msg) {
        actualizarTabla();
    }

    @Override
    public void errorEliminarEnfermedad(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarEnfermedad(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
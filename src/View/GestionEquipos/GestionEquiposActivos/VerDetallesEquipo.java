package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Caracteriztica;
import Model.POJO.Equipo;
import Presenter.GestionEquipos.PresenterGestionEquipos;
import View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposActivos.TableModelCaracterizticas;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
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
public class VerDetallesEquipo extends javax.swing.JDialog implements PresenterGestionEquipos.CallBackObtenerCaracterizticas, PresenterGestionEquipos.CallBackEliminarCaracteriztica {
    
    private final TableModelCaracterizticas tableModelCaracterizticas;
    private final PresenterGestionEquipos presenterGestionEquipos;
    private boolean permitirModificacion;
    private Equipo equipo;

    public VerDetallesEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        tableModelCaracterizticas = new TableModelCaracterizticas();
        
        initComponents();
        
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionEquipos.setCallBackObtenerCaracterizticas(this);
        presenterGestionEquipos.setCallBackEliminarCaracteriztica(this);
        permitirModificacion = false;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setPermitirModificacion(boolean permitirModificacion) {
        this.permitirModificacion = permitirModificacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemCaracteriztica = new javax.swing.JPopupMenu();
        JMENUITEMModificarCaracteriztica = new javax.swing.JMenuItem();
        JMENUITEMEliminarCaracteriztica = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JLBLEquipoFoto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        JLBLEquipoNombre = new javax.swing.JLabel();
        JLBLEquipoMarca = new javax.swing.JLabel();
        JLBLEquipoModelo = new javax.swing.JLabel();
        JLBLEquipoNumeroSerie = new javax.swing.JLabel();
        JLBLEquipoFechaAdquisicion = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        JLBLEquipoProveedor = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        JLBLEquipoResponsableEntrega = new javax.swing.JLabel();
        JLBLEquipoTiempoGarantia = new javax.swing.JLabel();
        JLBLEquipoIntegridad = new javax.swing.JLabel();
        JLBLEquipoAreaServicio = new javax.swing.JLabel();
        JLBLEquipoUbicacion = new javax.swing.JLabel();
        JLBLEquipoResponsable = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTXTAREAEquipoObservaciones = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLCaracterizticas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        JBTNActualizar = new javax.swing.JButton();
        JBTNAceptar = new javax.swing.JButton();

        JMENUITEMModificarCaracteriztica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/modificar_password.png"))); // NOI18N
        JMENUITEMModificarCaracteriztica.setText("Modificar Caracteríztica");
        JMENUITEMModificarCaracteriztica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMModificarCaracterizticaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemCaracteriztica.add(JMENUITEMModificarCaracteriztica);

        JMENUITEMEliminarCaracteriztica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/menu/eliminar.png"))); // NOI18N
        JMENUITEMEliminarCaracteriztica.setText("Eliminar Caracteríztica");
        JMENUITEMEliminarCaracteriztica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMENUITEMEliminarCaracterizticaActionPerformed(evt);
            }
        });
        JPOPUPMENUItemCaracteriztica.add(JMENUITEMEliminarCaracteriztica);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Detalles del Equipo");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Equipo"));

        JLBLEquipoFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBLEquipoFoto.setText("(sin foto)");
        JLBLEquipoFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JLBLEquipoFoto.setMaximumSize(new Dimension(JLBLEquipoFoto.getWidth(), JLBLEquipoFoto.getHeight())
        );
        JLBLEquipoFoto.setMinimumSize(new Dimension(JLBLEquipoFoto.getWidth(), JLBLEquipoFoto.getHeight()));
        JLBLEquipoFoto.setPreferredSize(new Dimension(JLBLEquipoFoto.getWidth(), JLBLEquipoFoto.getHeight()));

        jLabel21.setText("NOMBRE:");

        jLabel23.setText("MARCA:");

        jLabel25.setText("MODELO:");

        jLabel27.setText("NUMERO DE SERIE:");

        jLabel29.setText("FECHA DE ADQUISICION:");

        JLBLEquipoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoMarca.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoModelo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoNumeroSerie.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoFechaAdquisicion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setText("PROVEEDOR:");
        jLabel32.setToolTipText("");

        JLBLEquipoProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLBLEquipoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoNumeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoFechaAdquisicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32))
                .addGap(0, 175, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoFechaAdquisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel31.setText("RESPONSABLE DE ENTREGA:");
        jLabel31.setToolTipText("");

        jLabel33.setText("TIEMPO DE GARANTIA(AÑOS):");

        jLabel35.setText("INTEGRIDAD:");

        jLabel37.setText("AREA DE SERVICIO:");

        jLabel39.setText("UBICACION:");

        JLBLEquipoResponsableEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoTiempoGarantia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoIntegridad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoAreaServicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoUbicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLEquipoResponsable.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel40.setText("RESPONSABLE:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLBLEquipoResponsableEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoTiempoGarantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoIntegridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoAreaServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JLBLEquipoResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(0, 151, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoResponsableEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoTiempoGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoIntegridad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoAreaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel41.setText("OBSERVACIONES:");

        jLabel1.setText("FOTO DEL EQUIPO:");

        JTXTAREAEquipoObservaciones.setColumns(20);
        JTXTAREAEquipoObservaciones.setLineWrap(true);
        JTXTAREAEquipoObservaciones.setRows(5);
        JTXTAREAEquipoObservaciones.setEditable(false);
        jScrollPane2.setViewportView(JTXTAREAEquipoObservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLEquipoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLEquipoFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Caracterízticas del Equipo"));

        JTBLCaracterizticas.setModel(tableModelCaracterizticas);
        JTBLCaracterizticas.setComponentPopupMenu(JPOPUPMENUItemCaracteriztica);
        JTBLCaracterizticas.setEnabled(false);
        JTBLCaracterizticas.setRowHeight(20);
        JTBLCaracterizticas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLCaracterizticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLCaracterizticasMousePressed(evt);
            }
        });
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLCaracterizticas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLCaracterizticas.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLCaracterizticas.getColumnModel().getColumn(1).setPreferredWidth(250);
        JTBLCaracterizticas.getColumnModel().getColumn(2).setPreferredWidth(250);
        jScrollPane1.setViewportView(JTBLCaracterizticas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNAceptar.setText("ACEPTAR");
        JBTNAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTNAceptar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNAceptar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                if (permitirModificacion) {
                    JMENUITEMModificarCaracteriztica.setEnabled(true);
                    JMENUITEMEliminarCaracteriztica.setEnabled(true);
                } else {
                    JMENUITEMModificarCaracteriztica.setEnabled(false);
                    JMENUITEMEliminarCaracteriztica.setEnabled(false);
                }
                JLBLEquipoFoto.setIcon(new ImageIcon(new ImageIcon(equipo.getEquipoFoto()).getImage().getScaledInstance(JLBLEquipoFoto.getWidth(), JLBLEquipoFoto.getHeight(), Image.SCALE_DEFAULT)));
                JLBLEquipoNombre.setText(equipo.getEquipoNombre());
                JLBLEquipoMarca.setText(equipo.getEquipoMarca());
                JLBLEquipoModelo.setText(equipo.getEquipoModelo());
                JLBLEquipoNumeroSerie.setText(equipo.getEquipoNumeroSerie());
                JLBLEquipoFechaAdquisicion.setText(equipo.getEquipoFechaAdquisicion().toString());
                JLBLEquipoProveedor.setText(equipo.getEquipoProveedor());
                JLBLEquipoResponsableEntrega.setText(equipo.getEquipoResponsableEntrega());
                JLBLEquipoTiempoGarantia.setText(String.valueOf(equipo.getEquipoGarantia()));
                JLBLEquipoIntegridad.setText(equipo.getEquipoIntegridad());
                JLBLEquipoAreaServicio.setText(equipo.getSubespecialidad().getSubespecialidadNombre());
                JLBLEquipoUbicacion.setText(equipo.getEquipoUbicacion());
                JLBLEquipoResponsable.setText(equipo.getPersonalTecnico().getPersona().getPersonaApellido() + " " + equipo.getPersonalTecnico().getPersona().getPersonaNombre());
                JTXTAREAEquipoObservaciones.setText(equipo.getEquipoObservaciones());
                presenterGestionEquipos.obtenerCaracterizticas(equipo);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLCaracterizticasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLCaracterizticasMousePressed
        final int currentRow = JTBLCaracterizticas.rowAtPoint(evt.getPoint());
        JTBLCaracterizticas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLCaracterizticasMousePressed

    private void JMENUITEMModificarCaracterizticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMModificarCaracterizticaActionPerformed
        final ModificarCaracteriztica modificarCaracteriztica = new ModificarCaracteriztica(null, true);
        modificarCaracteriztica.setCaracteriztica(obtenerCaracterizticaSeleccionada());
        modificarCaracteriztica.setVisible(true);

        if (!modificarCaracteriztica.isVisible()) {
            presenterGestionEquipos.obtenerCaracterizticas(equipo);
        }
    }//GEN-LAST:event_JMENUITEMModificarCaracterizticaActionPerformed

    private void JMENUITEMEliminarCaracterizticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMENUITEMEliminarCaracterizticaActionPerformed
        final Caracteriztica caracteriztica = obtenerCaracterizticaSeleccionada();

        int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Eliminar la caracteríztica del equipo?\n\nDatos:\nCaracteriztica: " + caracteriztica.getEquipoCaracteriztica() + "\nValor: " + caracteriztica.getEquipoCaracterizticaValor() + "\n\n¿Eliminar?\n\n", "SIET", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == 0) {
            presenterGestionEquipos.eliminarCaracteriztica(caracteriztica);
        }
    }//GEN-LAST:event_JMENUITEMEliminarCaracterizticaActionPerformed

    private void JBTNAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNAceptarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerDetallesEquipo dialog = new VerDetallesEquipo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNAceptar;
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JLabel JLBLEquipoAreaServicio;
    private javax.swing.JLabel JLBLEquipoFechaAdquisicion;
    private javax.swing.JLabel JLBLEquipoFoto;
    private javax.swing.JLabel JLBLEquipoIntegridad;
    private javax.swing.JLabel JLBLEquipoMarca;
    private javax.swing.JLabel JLBLEquipoModelo;
    private javax.swing.JLabel JLBLEquipoNombre;
    private javax.swing.JLabel JLBLEquipoNumeroSerie;
    private javax.swing.JLabel JLBLEquipoProveedor;
    private javax.swing.JLabel JLBLEquipoResponsable;
    private javax.swing.JLabel JLBLEquipoResponsableEntrega;
    private javax.swing.JLabel JLBLEquipoTiempoGarantia;
    private javax.swing.JLabel JLBLEquipoUbicacion;
    private javax.swing.JMenuItem JMENUITEMEliminarCaracteriztica;
    private javax.swing.JMenuItem JMENUITEMModificarCaracteriztica;
    private javax.swing.JPopupMenu JPOPUPMENUItemCaracteriztica;
    private javax.swing.JTable JTBLCaracterizticas;
    private javax.swing.JTextArea JTXTAREAEquipoObservaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void actualizar() {
        tableModelCaracterizticas.limpiarLista();
        presenterGestionEquipos.obtenerCaracterizticas(equipo);
    }
    
    private Caracteriztica obtenerCaracterizticaSeleccionada() {
        final int rowModel = JTBLCaracterizticas.convertRowIndexToModel(JTBLCaracterizticas.getSelectedRow());
        return tableModelCaracterizticas.getCaracteriztica(rowModel);
    }

    @Override
    public void caracterizticasObtenidas(final List<Caracteriztica> caracterizticas) {
        tableModelCaracterizticas.setCaracterizticas(caracterizticas);
        JTBLCaracterizticas.setRowSorter(new TableRowSorter<>(tableModelCaracterizticas));
        JTBLCaracterizticas.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaCaracterizticasVacia(final String msg) {
    }

    @Override
    public void errorObtenerCaracterizticas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerCaracterizticas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void caracterizticaEliminada(final String msg) {
        actualizar();
    }

    @Override
    public void errorEliminarCaracteriztica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoEliminarCaracteriztica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
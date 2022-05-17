package View.GestionEquipos.GestionEquiposIntervencion;

import Model.POJO.Equipo;
import Model.POJO.Intervencion;
import Presenter.GestionEquipos.PresenterGestionIntervenciones;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Brynner
 */
public class ModificarIntervencion extends javax.swing.JDialog implements PresenterGestionIntervenciones.CallBackModificarIntervencion {
    
    private final PresenterGestionIntervenciones presenterGestionIntervenciones;
    private Intervencion intervencion;
    
    public ModificarIntervencion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionIntervenciones = new PresenterGestionIntervenciones();
        presenterGestionIntervenciones.setCallBackModificarIntervencion(this);
        JTXTFIntervencionCausa.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setIntervencion(Intervencion intervencion) {
        this.intervencion = intervencion;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JLBLEquipoNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JLBLEquipoMarca = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JLBLEquipoModelo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLBLEquipoNumeroSerie = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREAIntervencionDescripcionActividad = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTXTAREAIntervencionObservaciones = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JDTCHOOSERIntervencionFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        JTXTFIntervencionCausa = new javax.swing.JTextField();
        JLBLContadorCausaIntervencion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNIntervencionFechaInicio = new javax.swing.JSpinner(spinnerDateModel);
        jLabel9 = new javax.swing.JLabel();
        JTXTFIntervencionTrabajoRealizado = new javax.swing.JTextField();
        JLBLContadorTrabajoRealizado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLBLContadorDescripcionActividad = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLBLContadorObservaciones = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Intervención");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Equipo"));

        jLabel5.setText("NOMBRE:");

        JLBLEquipoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("MARCA:");

        JLBLEquipoMarca.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5)
            .addComponent(JLBLEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1)
            .addComponent(JLBLEquipoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("MODELO:");

        JLBLEquipoModelo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("NUMERO DE SERIE:");
        jLabel7.setToolTipText("");

        JLBLEquipoNumeroSerie.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
            .addComponent(jLabel7)
            .addComponent(JLBLEquipoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(JLBLEquipoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLEquipoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Intervención"));

        jLabel6.setText("DESCRIPCION DE LA ACTIVIDAD:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTXTAREAIntervencionDescripcionActividad.setColumns(20);
        JTXTAREAIntervencionDescripcionActividad.setLineWrap(true);
        JTXTAREAIntervencionDescripcionActividad.setRows(5);
        JTXTAREAIntervencionDescripcionActividad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAIntervencionDescripcionActividadFocusGained(evt);
            }
        });
        JTXTAREAIntervencionDescripcionActividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionDescripcionActividadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionDescripcionActividadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionDescripcionActividadKeyTyped(evt);
            }
        });
        JTXTAREAIntervencionDescripcionActividad.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREAIntervencionDescripcionActividad);

        jLabel8.setText("OBSERVACIONES:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTXTAREAIntervencionObservaciones.setColumns(20);
        JTXTAREAIntervencionObservaciones.setLineWrap(true);
        JTXTAREAIntervencionObservaciones.setRows(5);
        JTXTAREAIntervencionObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAIntervencionObservacionesFocusGained(evt);
            }
        });
        JTXTAREAIntervencionObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionObservacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionObservacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAIntervencionObservacionesKeyTyped(evt);
            }
        });
        JTXTAREAIntervencionObservaciones.setTransferHandler(null);
        jScrollPane2.setViewportView(JTXTAREAIntervencionObservaciones);

        jLabel2.setText("FECHA INICIO DE INTERVENCION:");

        JDTCHOOSERIntervencionFecha.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERIntervencionFecha.setDateFormatString("yyyy-MM-dd");

        jLabel4.setText("CAUSA DE INTERVENCION:");

        JTXTFIntervencionCausa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFIntervencionCausaFocusGained(evt);
            }
        });
        JTXTFIntervencionCausa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionCausaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionCausaKeyTyped(evt);
            }
        });
        JTXTFIntervencionCausa.setTransferHandler(null);

        JLBLContadorCausaIntervencion.setText("0");

        jLabel11.setText("/50");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addComponent(JDTCHOOSERIntervencionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLContadorCausaIntervencion)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel11))
                .addComponent(JTXTFIntervencionCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDTCHOOSERIntervencionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(JLBLContadorCausaIntervencion))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFIntervencionCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel10.setText("HORA INICIO DE INTERVENCION:");

        JSPNIntervencionFechaInicio.setEditor(new JSpinner.DateEditor(JSPNIntervencionFechaInicio, "HH:mm:ss"));

        jLabel9.setText("TRABAJO REALIZADO:");

        JTXTFIntervencionTrabajoRealizado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFIntervencionTrabajoRealizadoFocusGained(evt);
            }
        });
        JTXTFIntervencionTrabajoRealizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionTrabajoRealizadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFIntervencionTrabajoRealizadoKeyTyped(evt);
            }
        });
        JTXTFIntervencionTrabajoRealizado.setTransferHandler(null);

        JLBLContadorTrabajoRealizado.setText("0");
        JLBLContadorTrabajoRealizado.setToolTipText("");

        jLabel12.setText("/50");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLBLContadorTrabajoRealizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(JSPNIntervencionFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addComponent(JTXTFIntervencionTrabajoRealizado, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPNIntervencionFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(JLBLContadorTrabajoRealizado))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFIntervencionTrabajoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JLBLContadorDescripcionActividad.setText("0");

        jLabel13.setText("/150");

        JLBLContadorObservaciones.setText("0");

        jLabel14.setText("/150");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorDescripcionActividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorObservaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(JLBLContadorDescripcionActividad))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(JLBLContadorObservaciones))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNGuardar)
                    .addComponent(JBTNCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (intervencion == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                final Equipo equipo = intervencion.getEquipo();
                JLBLEquipoNombre.setText(equipo.getEquipoNombre());
                JLBLEquipoMarca.setText(equipo.getEquipoMarca());
                JLBLEquipoModelo.setText(equipo.getEquipoModelo());
                JLBLEquipoNumeroSerie.setText(equipo.getEquipoNumeroSerie());
                JDTCHOOSERIntervencionFecha.setDate(intervencion.getIntervencionFechaInicio());
                JSPNIntervencionFechaInicio.setValue(intervencion.getIntervencionHoraInicio());
                JTXTFIntervencionCausa.setText(intervencion.getIntervencionCausa());
                JTXTFIntervencionTrabajoRealizado.setText(intervencion.getIntervencionTrabajoRealizado());
                JTXTAREAIntervencionDescripcionActividad.setText(intervencion.getIntervencionDescripcionActividad());
                JTXTAREAIntervencionObservaciones.setText(intervencion.getIntervencionObservaciones());
                
                JLBLContadorCausaIntervencion.setText(String.valueOf(JTXTFIntervencionCausa.getText().length()));
                JLBLContadorTrabajoRealizado.setText(String.valueOf(JTXTFIntervencionTrabajoRealizado.getText().length()));
                JLBLContadorDescripcionActividad.setText(String.valueOf(JTXTAREAIntervencionDescripcionActividad.getText().length()));
                JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAIntervencionObservaciones.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFIntervencionCausaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionCausaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFIntervencionCausa.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFIntervencionCausaKeyTyped

    private void JTXTAREAIntervencionDescripcionActividadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAIntervencionDescripcionActividad.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadKeyTyped

    private void JTXTAREAIntervencionObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAIntervencionObservaciones.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFIntervencionTrabajoRealizadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionTrabajoRealizadoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFIntervencionTrabajoRealizado.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFIntervencionTrabajoRealizadoKeyTyped

    private void JTXTFIntervencionCausaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionCausaKeyReleased
        JLBLContadorCausaIntervencion.setText(String.valueOf(JTXTFIntervencionCausa.getText().length()));
    }//GEN-LAST:event_JTXTFIntervencionCausaKeyReleased

    private void JTXTFIntervencionTrabajoRealizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFIntervencionTrabajoRealizadoKeyReleased
        JLBLContadorTrabajoRealizado.setText(String.valueOf(JTXTFIntervencionTrabajoRealizado.getText().length()));
    }//GEN-LAST:event_JTXTFIntervencionTrabajoRealizadoKeyReleased

    private void JTXTAREAIntervencionDescripcionActividadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadKeyReleased
        JLBLContadorDescripcionActividad.setText(String.valueOf(JTXTAREAIntervencionDescripcionActividad.getText().length()));
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadKeyReleased

    private void JTXTAREAIntervencionObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesKeyReleased
        JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAIntervencionObservaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesKeyReleased

    private void JTXTAREAIntervencionDescripcionActividadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadKeyPressed

    private void JTXTAREAIntervencionObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesKeyPressed

    private void JTXTFIntervencionCausaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFIntervencionCausaFocusGained
        JTXTFIntervencionCausa.selectAll();
    }//GEN-LAST:event_JTXTFIntervencionCausaFocusGained

    private void JTXTFIntervencionTrabajoRealizadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFIntervencionTrabajoRealizadoFocusGained
        JTXTFIntervencionTrabajoRealizado.selectAll();
    }//GEN-LAST:event_JTXTFIntervencionTrabajoRealizadoFocusGained

    private void JTXTAREAIntervencionDescripcionActividadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionDescripcionActividadFocusGained
        JTXTAREAIntervencionDescripcionActividad.selectAll();
    }//GEN-LAST:event_JTXTAREAIntervencionDescripcionActividadFocusGained

    private void JTXTAREAIntervencionObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAIntervencionObservacionesFocusGained
        JTXTAREAIntervencionObservaciones.selectAll();
    }//GEN-LAST:event_JTXTAREAIntervencionObservacionesFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarIntervencion dialog = new ModificarIntervencion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNGuardar;
    private com.toedter.calendar.JDateChooser JDTCHOOSERIntervencionFecha;
    private javax.swing.JLabel JLBLContadorCausaIntervencion;
    private javax.swing.JLabel JLBLContadorDescripcionActividad;
    private javax.swing.JLabel JLBLContadorObservaciones;
    private javax.swing.JLabel JLBLContadorTrabajoRealizado;
    private javax.swing.JLabel JLBLEquipoMarca;
    private javax.swing.JLabel JLBLEquipoModelo;
    private javax.swing.JLabel JLBLEquipoNombre;
    private javax.swing.JLabel JLBLEquipoNumeroSerie;
    private javax.swing.JSpinner JSPNIntervencionFechaInicio;
    private javax.swing.JTextArea JTXTAREAIntervencionDescripcionActividad;
    private javax.swing.JTextArea JTXTAREAIntervencionObservaciones;
    private javax.swing.JTextField JTXTFIntervencionCausa;
    private javax.swing.JTextField JTXTFIntervencionTrabajoRealizado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                final Date intervencionFechaInicio = JDTCHOOSERIntervencionFecha.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERIntervencionFecha.getDate()));
                final Date intervencionFechaFinal = null;
                final String intervencionCausa = JTXTFIntervencionCausa.getText();
                final String intervencionTrabajoRealizado = JTXTFIntervencionTrabajoRealizado.getText();
                final String intervencionDescripcionActividad = JTXTAREAIntervencionDescripcionActividad.getText();
                final String intervencionObservaciones = JTXTAREAIntervencionObservaciones.getText();
                
                
                if (intervencionFechaInicio == null) {
                    JOptionPane.showMessageDialog(null, "Ingresa la fecha de intervención.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionCausa.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa la causa de la intervención.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionTrabajoRealizado.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa el trabajo realizado.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else if (intervencionDescripcionActividad.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa una descripción de la actividad.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    intervencion.setIntervencionFechaInicio(intervencionFechaInicio);
                    intervencion.setIntervencionCausa(intervencionCausa);
                    intervencion.setIntervencionTrabajoRealizado(intervencionTrabajoRealizado);
                    intervencion.setIntervencionDescripcionActividad(intervencionDescripcionActividad);
                    intervencion.setIntervencionObservaciones(intervencionObservaciones);
                    presenterGestionIntervenciones.modificarIntervencion(intervencion);
                }
            } catch (final HeadlessException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error modificar intervencion equipo: " + exception.getMessage());
            }
        }
    };

    @Override
    public void intervencionModificada(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarIntervencion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarIntervencion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
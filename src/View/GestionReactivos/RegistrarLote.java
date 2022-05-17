package View.GestionReactivos;

import Model.POJO.Reactivo;
import Model.POJO.ReactivoEntrega;
import Model.POJO.ReactivoLote;
import Model.POJOPersonalizado.ReactivoPersonalizado;
import Presenter.GestionReactivos.PresenterGestionReactivos;
import Presenter.GestionReactivos.PresenterGestionReactivosLotes;
import View.Utilitarios.ModeloItemComboBox.ItemReactivo;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brynner
 */
public class RegistrarLote extends javax.swing.JDialog implements PresenterGestionReactivos.CallBackObtenerReactivos, PresenterGestionReactivosLotes.CallBackVerificarExistenciaLote, PresenterGestionReactivosLotes.CallBackRegistrarLote {

    private final PresenterGestionReactivos presenterGestionReactivos;
    private final PresenterGestionReactivosLotes presenterGestionReactivosLotes;
    
    private ReactivoEntrega reactivoEntrega;

    public RegistrarLote(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionReactivos = new PresenterGestionReactivos();
        presenterGestionReactivosLotes = new PresenterGestionReactivosLotes();
        presenterGestionReactivos.setCallBackObtenerReactivos(this);
        presenterGestionReactivosLotes.setCallBackVerificarExistenciaLote(this);
        presenterGestionReactivosLotes.setCallBackRegistrarLote(this);

        JTXTFPresentacion.addActionListener(action);
        JTXTFTotalUnidades.addActionListener(action);
        JTXTFMarca.addActionListener(action);
        JTXTFLote.addActionListener(action);
        JBTNRegistrar.addActionListener(action);
    }

    public void setReactivoEntrega(ReactivoEntrega reactivoEntrega) {
        this.reactivoEntrega = reactivoEntrega;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLBioquimico = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLProveedor = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JLBLFechaEntrega = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JLBLHoraEntrega = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JTXTFPresentacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCMBXAlmacenamiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JCMBXUbicacion = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        JTXTFTotalUnidades = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JTXTFMarca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JTXTFLote = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JDTCHOOSEFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTXTAREAObservaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        JCMBXReactivo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        JLBLContadorPresentacion = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLBLContadorTotalUnidades = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JLBLContadorMarcaReactivo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JLBLContadorNumeroLote = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JLBLContadorObservaciones = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Nuevo Lote");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Entrega"));

        jLabel1.setText("ENTREGADO A:");

        JLBLBioquimico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("RECIBIDO DE:");

        JLBLProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("FECHA DE ENTREGA:");

        JLBLFechaEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("HORA DE ENTREGA:");

        JLBLHoraEntrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JLBLBioquimico, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                    .addComponent(JLBLFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLBioquimico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Lote"));

        jLabel3.setText("PRESENTACION:");

        JTXTFPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFPresentacionFocusGained(evt);
            }
        });
        JTXTFPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFPresentacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFPresentacionKeyTyped(evt);
            }
        });
        JTXTFPresentacion.setTransferHandler(null);

        jLabel4.setText("ALMACENAMIENTO:");

        JCMBXAlmacenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AMBIENTE", "REFRIGERADO" }));

        jLabel5.setText("UBICACION");

        JCMBXUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALMACEN" }));
        JCMBXUbicacion.setSelectedIndex(-1);

        jLabel8.setText("TOTAL UNIDADES:");

        JTXTFTotalUnidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFTotalUnidadesFocusGained(evt);
            }
        });
        JTXTFTotalUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFTotalUnidadesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFTotalUnidadesKeyTyped(evt);
            }
        });
        JTXTFTotalUnidades.setTransferHandler(null);

        jLabel9.setText("MARCA:");

        JTXTFMarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFMarcaFocusGained(evt);
            }
        });
        JTXTFMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFMarcaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFMarcaKeyTyped(evt);
            }
        });
        JTXTFMarca.setTransferHandler(null);

        jLabel10.setText("LOTE:");

        JTXTFLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFLoteFocusGained(evt);
            }
        });
        JTXTFLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFLoteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFLoteKeyTyped(evt);
            }
        });
        JTXTFLote.setTransferHandler(null);

        jLabel11.setText("FECHA DE VENCIMIENTO:");

        JDTCHOOSEFechaVencimiento.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSEFechaVencimiento.setMinSelectableDate(Calendar.getInstance().getTime());

        jLabel13.setText("OBSERVACIONES:");

        JTXTAREAObservaciones.setColumns(20);
        JTXTAREAObservaciones.setLineWrap(true);
        JTXTAREAObservaciones.setRows(5);
        JTXTAREAObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAObservacionesFocusGained(evt);
            }
        });
        JTXTAREAObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyTyped(evt);
            }
        });
        JTXTAREAObservaciones.setTransferHandler(null);
        jScrollPane1.setViewportView(JTXTAREAObservaciones);

        jLabel6.setText("REACTIVO:");

        jLabel7.setText("/20");

        JLBLContadorPresentacion.setText("0");

        jLabel12.setText("/3");

        JLBLContadorTotalUnidades.setText("0");

        jLabel14.setText("/20");

        JLBLContadorMarcaReactivo.setText("0");

        jLabel15.setText("/10");

        JLBLContadorNumeroLote.setText("0");

        jLabel17.setText("/150");

        JLBLContadorObservaciones.setText("0");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNRegistrar.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCMBXReactivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTXTFLote)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNumeroLote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNRegistrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JTXTFPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JCMBXUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JLBLContadorPresentacion)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JLBLContadorTotalUnidades)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel12))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JTXTFTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(JCMBXAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JLBLContadorObservaciones)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTXTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLBLContadorMarcaReactivo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JDTCHOOSEFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(JLBLContadorPresentacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTXTFPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCMBXAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(JLBLContadorTotalUnidades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBXUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTXTFTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(JLBLContadorMarcaReactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTXTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDTCHOOSEFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(JLBLContadorNumeroLote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(JLBLContadorObservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (reactivoEntrega == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLBioquimico.setText(reactivoEntrega.getPersonalTecnico().getPersona().getPersonaApellido() + " " + reactivoEntrega.getPersonalTecnico().getPersona().getPersonaNombre());
                JLBLProveedor.setText(reactivoEntrega.getProveedor());
                JLBLFechaEntrega.setText(reactivoEntrega.getFechaEntrega().toString());
                JLBLHoraEntrega.setText(reactivoEntrega.getHoraEntrega().toString());

                presenterGestionReactivos.obtenerReactivos();

            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFPresentacionKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z1-9\\.()*/ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFPresentacion.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFPresentacionKeyTyped

    private void JTXTFTotalUnidadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTotalUnidadesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([0-9]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFTotalUnidades.getText().length() >= 3) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFTotalUnidadesKeyTyped

    private void JTXTFMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFMarcaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFMarca.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFMarcaKeyTyped

    private void JTXTFLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFLoteKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFLote.getText().length() >= 10) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFLoteKeyTyped

    private void JTXTAREAObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAObservaciones.getText().length() >= 150) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAObservacionesKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFPresentacionKeyReleased
        JLBLContadorPresentacion.setText(String.valueOf(JTXTFPresentacion.getText().length()));
    }//GEN-LAST:event_JTXTFPresentacionKeyReleased

    private void JTXTFTotalUnidadesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTotalUnidadesKeyReleased
        JLBLContadorTotalUnidades.setText(String.valueOf(JTXTFTotalUnidades.getText().length()));
    }//GEN-LAST:event_JTXTFTotalUnidadesKeyReleased

    private void JTXTFMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFMarcaKeyReleased
        JLBLContadorMarcaReactivo.setText(String.valueOf(JTXTFMarca.getText().length()));
    }//GEN-LAST:event_JTXTFMarcaKeyReleased

    private void JTXTFLoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFLoteKeyReleased
        JLBLContadorNumeroLote.setText(String.valueOf(JTXTFLote.getText().length()));
    }//GEN-LAST:event_JTXTFLoteKeyReleased

    private void JTXTAREAObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyReleased
        JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAObservaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREAObservacionesKeyReleased

    private void JTXTAREAObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAObservacionesKeyPressed

    private void JTXTFPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFPresentacionFocusGained
        JTXTFPresentacion.selectAll();
    }//GEN-LAST:event_JTXTFPresentacionFocusGained

    private void JTXTFMarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFMarcaFocusGained
        JTXTFMarca.selectAll();
    }//GEN-LAST:event_JTXTFMarcaFocusGained

    private void JTXTFTotalUnidadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFTotalUnidadesFocusGained
        JTXTFTotalUnidades.selectAll();
    }//GEN-LAST:event_JTXTFTotalUnidadesFocusGained

    private void JTXTFLoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFLoteFocusGained
        JTXTFLote.selectAll();
    }//GEN-LAST:event_JTXTFLoteFocusGained

    private void JTXTAREAObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesFocusGained
        JTXTAREAObservaciones.selectAll();
    }//GEN-LAST:event_JTXTAREAObservacionesFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarLote dialog = new RegistrarLote(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNRegistrar;
    private javax.swing.JComboBox<String> JCMBXAlmacenamiento;
    private javax.swing.JComboBox<ItemReactivo> JCMBXReactivo;
    private javax.swing.JComboBox<String> JCMBXUbicacion;
    private com.toedter.calendar.JDateChooser JDTCHOOSEFechaVencimiento;
    private javax.swing.JLabel JLBLBioquimico;
    private javax.swing.JLabel JLBLContadorMarcaReactivo;
    private javax.swing.JLabel JLBLContadorNumeroLote;
    private javax.swing.JLabel JLBLContadorObservaciones;
    private javax.swing.JLabel JLBLContadorPresentacion;
    private javax.swing.JLabel JLBLContadorTotalUnidades;
    private javax.swing.JLabel JLBLFechaEntrega;
    private javax.swing.JLabel JLBLHoraEntrega;
    private javax.swing.JLabel JLBLProveedor;
    private javax.swing.JTextArea JTXTAREAObservaciones;
    private javax.swing.JTextField JTXTFLote;
    private javax.swing.JTextField JTXTFMarca;
    private javax.swing.JTextField JTXTFPresentacion;
    private javax.swing.JTextField JTXTFTotalUnidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String presentacion = JTXTFPresentacion.getText();
            final int totalUnidades = JTXTFTotalUnidades.getText().trim().isEmpty() ? 0 : Integer.valueOf(JTXTFTotalUnidades.getText());
            final String marca = JTXTFMarca.getText();
            final String lote = JTXTFLote.getText();
            final Date fechaVencimiento = JDTCHOOSEFechaVencimiento.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSEFechaVencimiento.getDate()));
            final String observaciones = JTXTAREAObservaciones.getText();
            
            if (JCMBXReactivo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el reactivo.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXReactivo.requestFocus();
            } else if (presentacion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa la presentación.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFPresentacion.requestFocus();
            } else if (JCMBXAlmacenamiento.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el almacenamiento.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXAlmacenamiento.requestFocus();
            } else if (JCMBXUbicacion.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la ubicación.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXUbicacion.requestFocus();
            } else if (totalUnidades == 0) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el total de unidades en el lote.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFTotalUnidades.requestFocus();
            } else if (marca.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa la marca.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFMarca.requestFocus();
            } else if (lote.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el lote.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFLote.requestFocus();
            } else if (fechaVencimiento == null) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de vencimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final ItemReactivo itemReactivo = (ItemReactivo) JCMBXReactivo.getSelectedItem();
                
                final Reactivo reactivo = new Reactivo(itemReactivo.getCodigoReactivo(), itemReactivo.getNombre(), itemReactivo.getEstado());
                final String almacenamiento = JCMBXAlmacenamiento.getSelectedItem().toString();
                final String ubicacion = JCMBXUbicacion.getSelectedItem().toString();

                final ReactivoLote reactivoLote = new ReactivoLote(reactivoEntrega, reactivo, lote, presentacion, almacenamiento, ubicacion, totalUnidades, marca, fechaVencimiento, observaciones, "EN ALMACEN", 1);
                presenterGestionReactivosLotes.registrarLote(reactivoLote);
            }
        }
    };

    @Override
        public void reactivosObtenidos(final List<ReactivoPersonalizado> reactivosPersonalizados) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        reactivosPersonalizados.forEach((reactivoPersonalizado) -> {
            final Reactivo reactivo = reactivoPersonalizado.getReactivo();
            defaultComboBoxModel.addElement(new ItemReactivo(reactivo.getCodigoReactivo(), reactivo.getNombre(), reactivo.getEstado()));
        });
        
        JCMBXReactivo.setModel(defaultComboBoxModel);
        JCMBXReactivo.setSelectedIndex(-1);
    }

    @Override
        public void listaReactivosVacia(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
        public void errorObtenerReactivos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
        public void errorDesconocidoObtenerReactivos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
        public void loteExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
        public void errorVerificarExistenciaLote(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
        public void loteRegistrado(final String msg) {
        dispose();
    }

    @Override
        public void errorRegistrarLote(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
        public void errorDesconocidoRegistrarLote(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
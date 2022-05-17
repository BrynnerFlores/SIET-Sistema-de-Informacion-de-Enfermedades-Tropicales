package View.GestionRecepciones;

import Model.POJO.Establecimiento;
import Model.POJO.Examen;
import Model.POJO.ExamenSolicitado;
import Model.POJO.MuestraBiologica;
import Model.POJO.Paciente;
import Model.POJO.Recepcion;
import Model.POJOPersonalizado.ExamenPersonalizado;
import Model.POJOPersonalizado.ExamenSolicitadoPersonalizado;
import Presenter.GestionRecepciones.PresenterGestionRecepciones;
import View.Utilitarios.ModelTable.GestionRecepciones.ExamenSeleccionado;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelRegistrarModificarRecepcion;
import View.Utilitarios.ModeloItemComboBox.ItemEstablecimiento;
import View.Utilitarios.ModeloItemComboBox.ItemMuestraBiologica;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Brynner
 */
public class ModificarRecepcion extends javax.swing.JDialog implements PresenterGestionRecepciones.CallBackObtenerExamenes, PresenterGestionRecepciones.CallBackObtenerMuestrasBiologicas, PresenterGestionRecepciones.CallBackObtenerExamenesSolicitados, PresenterGestionRecepciones.CallBackObtenerEstablecimientos, PresenterGestionRecepciones.CallBackVerificarPermitirModificacion, PresenterGestionRecepciones.CallBackActualizarRecepcion, TableModelListener, ItemListener {

    private final PresenterGestionRecepciones presenterGestionRecepciones;
    private final TableModelRegistrarModificarRecepcion tableModelRegistrarModificarRecepcion;
    private final JComboBox jComboBoxEstadoMuestras;
    private final JComboBox jComboBoxTotalMuestrasBiologicas;
    private JComboBox<ItemMuestraBiologica> jComboBoxMuestrasBiologicas;

    private Recepcion recepcion;

    public ModificarRecepcion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionRecepciones = new PresenterGestionRecepciones();
        tableModelRegistrarModificarRecepcion = new TableModelRegistrarModificarRecepcion();

        presenterGestionRecepciones.setCallBackObtenerExamenes(this);
        presenterGestionRecepciones.setCallBackObtenerMuestrasBiologicas(this);
        presenterGestionRecepciones.setCallBackObtenerExamenesSolicitados(this);
        presenterGestionRecepciones.setCallBackObtenerEstablecimientos(this);
        presenterGestionRecepciones.setCallBackVerificarPermitirModificacion(this);
        presenterGestionRecepciones.setCallBackActualizarRecepcion(this);

        jComboBoxEstadoMuestras = new JComboBox();
        jComboBoxEstadoMuestras.addItem("TOMADO EN EL LABORATORIO");
        jComboBoxEstadoMuestras.addItem("REFERIDO AL LABORATORIO");
        jComboBoxEstadoMuestras.addItem("REFERIDO POR EL LABORATORIO");
        jComboBoxEstadoMuestras.addItemListener(this);

        jComboBoxTotalMuestrasBiologicas = new JComboBox();
        jComboBoxTotalMuestrasBiologicas.addItem("1");
        jComboBoxTotalMuestrasBiologicas.addItem("2");
        jComboBoxTotalMuestrasBiologicas.addItemListener(this);

        initComponents();
        
        JTXTFNumeroDiasSintomas.addActionListener(action);
        JTXTFSolicitante.addActionListener(action);
        JBTNGuardar.addActionListener(action);

    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLBLCedulaIdentidad = new javax.swing.JLabel();
        JLBLApellido = new javax.swing.JLabel();
        JLBLNombre = new javax.swing.JLabel();
        JLBLSexo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JLBLPacienteFechaNacimiento = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JLBLPacienteEdad = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JTXTFSolicitante = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLBLPersonalTecnico = new javax.swing.JLabel();
        JCMBXEstablecimiento = new javax.swing.JComboBox<>();
        JLBLHoraRecepcion = new javax.swing.JLabel();
        JLBLFechaRecepcion = new javax.swing.JLabel();
        JLBLContadorSolicitante = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JLBLCodigoRegistroLaboratorio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLExamenes = new javax.swing.JTable();
        JBTNCancelar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JCMBXMujerEmbarazada = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JCMBXMujerParto = new javax.swing.JComboBox<>();
        JCMBXMujerPostParto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTXTFNumeroDiasSintomas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JDTCHOOSERFechaProcesamiento = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        JLBLContadorNumeroDiasSintomas = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Recepción");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel1.setText("CEDULA DE IDENTIDAD:");

        jLabel2.setText("APELLIDO(S):");

        jLabel3.setText("NOMBRE(S):");
        jLabel3.setToolTipText("");

        jLabel4.setText("SEXO:");

        JLBLCedulaIdentidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("FECHA DE  NACIMIENTO:");

        JLBLPacienteFechaNacimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("EDAD:");

        JLBLPacienteEdad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLCedulaIdentidad, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(JLBLApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(JLBLNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(JLBLSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4)
                            .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLPacienteEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(JLBLPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(JLBLPacienteEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Recepción"));

        jLabel9.setText("RECEPCIONISTA:");

        JTXTFSolicitante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFSolicitanteFocusGained(evt);
            }
        });
        JTXTFSolicitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFSolicitanteKeyTyped(evt);
            }
        });
        JTXTFSolicitante.setTransferHandler(null);

        jLabel10.setText("SOLICITADO POR:");

        jLabel11.setText("ESTABLECIMIENTO DE SALUD:");

        jLabel12.setText("FECHA DE RECEPCION:");

        jLabel13.setText("HORA DE RECEPCION:");

        JLBLPersonalTecnico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLHoraRecepcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLFechaRecepcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLContadorSolicitante.setText("0");

        jLabel20.setText("/50");

        jLabel16.setText("CODIGO DE REGISTRO DE LABORATORIO:");

        JLBLCodigoRegistroLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLCodigoRegistroLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorSolicitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLBLFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLBLHoraRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(JLBLPersonalTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(JCMBXEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel13))
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLPersonalTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(JLBLContadorSolicitante))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLHoraRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLCodigoRegistroLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Exámenes Solicitados"));

        JTBLExamenes.setModel(tableModelRegistrarModificarRecepcion);
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
        JTBLExamenes.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);

        JTBLExamenes.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLExamenes.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTBLExamenes.getColumnModel().getColumn(2).setPreferredWidth(200);
        JTBLExamenes.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTBLExamenes.getColumnModel().getColumn(4).setPreferredWidth(150);
        JTBLExamenes.getColumnModel().getColumn(5).setPreferredWidth(100);

        final TableColumn tableColumnTotalMuestrasBiologicas = JTBLExamenes.getColumnModel().getColumn(3);
        final TableColumn tableColumnEstadoMuestras = JTBLExamenes.getColumnModel().getColumn(4);
        tableColumnTotalMuestrasBiologicas.setCellEditor(new DefaultCellEditor(jComboBoxTotalMuestrasBiologicas));
        tableColumnEstadoMuestras.setCellEditor(new DefaultCellEditor(jComboBoxEstadoMuestras));
        jScrollPane1.setViewportView(JTBLExamenes);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNActualizar.setText("ACTUALIZAR");

        JBTNGuardar.setText("GUARDAR");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        JCMBXMujerEmbarazada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        JCMBXMujerEmbarazada.setEnabled(false);

        jLabel5.setText("¿MUJER EMBARAZADA?");

        JCMBXMujerParto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        JCMBXMujerParto.setEnabled(false);

        JCMBXMujerPostParto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        JCMBXMujerPostParto.setEnabled(false);

        jLabel6.setText("¿PARTO?");

        jLabel7.setText("¿POST PARTO?");

        JTXTFNumeroDiasSintomas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNumeroDiasSintomasFocusGained(evt);
            }
        });
        JTXTFNumeroDiasSintomas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFNumeroDiasSintomasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFNumeroDiasSintomasKeyTyped(evt);
            }
        });
        JTXTFNumeroDiasSintomas.setTransferHandler(null);

        jLabel8.setText("NUMERO DE DIAS DE SINTOMAS:");

        JDTCHOOSERFechaProcesamiento.setDate(null);
        JDTCHOOSERFechaProcesamiento.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERFechaProcesamiento.setMaxSelectableDate(Calendar.getInstance().getTime());

        jLabel15.setText("FECHA DE PROCESAMIENTO:");

        JLBLContadorNumeroDiasSintomas.setText("0");

        jLabel21.setText("/2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNumeroDiasSintomas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(JCMBXMujerEmbarazada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(JCMBXMujerParto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(JCMBXMujerPostParto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFNumeroDiasSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(JDTCHOOSERFechaProcesamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXMujerEmbarazada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXMujerParto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXMujerPostParto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(JLBLContadorNumeroDiasSintomas))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNumeroDiasSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDTCHOOSERFechaProcesamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNGuardar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (recepcion == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                presenterGestionRecepciones.obtenerExamenes();
                presenterGestionRecepciones.obtenerMuestrasBiologicas();
                presenterGestionRecepciones.obtenerEstablecimientos();
                presenterGestionRecepciones.obtenerExamenesSolicitados(recepcion);

                final Paciente paciente = recepcion.getPaciente();
                JLBLCedulaIdentidad.setText(paciente.getPersona().getPersonaCedulaIdentidad());
                JLBLApellido.setText(paciente.getPersona().getPersonaApellido());
                JLBLNombre.setText(paciente.getPersona().getPersonaNombre());
                JLBLSexo.setText(paciente.getPersona().getPersonaSexo().equals("M") ? "MASCULINO" : "FEMENINO");
                JLBLPacienteFechaNacimiento.setText(paciente.getPacienteFechaNacimiento().toString());
                JLBLPacienteEdad.setText(String.valueOf(recepcion.getEdadPacienteYears() + " Años " + recepcion.getEdadPacienteMeses() + " Meses " + recepcion.getEdadPacienteDias() + " Días"));
                JCMBXMujerEmbarazada.setSelectedIndex(recepcion.isMujerEmbarazada() ? 1 : 0);
                JCMBXMujerParto.setSelectedIndex(recepcion.isMujerParto() ? 1 : 0);
                JCMBXMujerPostParto.setSelectedIndex(recepcion.isMujerPostParto() ? 1 : 0);
                JTXTFNumeroDiasSintomas.setText(recepcion.getNumeroDiasSintomas() == 0 ? null : String.valueOf(recepcion.getNumeroDiasSintomas()));
                JLBLContadorNumeroDiasSintomas.setText(String.valueOf(JTXTFNumeroDiasSintomas.getText().length()));
                JDTCHOOSERFechaProcesamiento.setDate(recepcion.getFechaProcesamiento());

                if (paciente.getPersona().getPersonaSexo().equals("M")) {
                    JCMBXMujerEmbarazada.setEnabled(false);
                    JCMBXMujerParto.setEnabled(false);
                    JCMBXMujerPostParto.setEnabled(false);
                } else {
                    JCMBXMujerEmbarazada.setEnabled(true);
                    JCMBXMujerParto.setEnabled(true);
                    JCMBXMujerPostParto.setEnabled(true);
                }

                JLBLPersonalTecnico.setText(recepcion.getPersonalTecnico().getPersona().getPersonaApellido() + " " + recepcion.getPersonalTecnico().getPersona().getPersonaNombre());
                JTXTFSolicitante.setText(recepcion.getSolicitante());
                JLBLContadorSolicitante.setText(String.valueOf(JTXTFSolicitante.getText().length()));
                JCMBXEstablecimiento.setSelectedIndex(obtenerEstablecimientoRegistrado(recepcion.getEstablecimiento().getCodigoEstablecimiento()));
                JLBLFechaRecepcion.setText(recepcion.getFechaRecepcion().toString());
                JLBLHoraRecepcion.setText(recepcion.getHoraRecepcion().toString());
                JLBLCodigoRegistroLaboratorio.setText(recepcion.getCodigoRegistroLaboratorio());
            }

        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error ,vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLExamenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLExamenesMousePressed
        final int currentRow = JTBLExamenes.rowAtPoint(evt.getPoint());
        JTBLExamenes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLExamenesMousePressed

    private void JTXTFSolicitanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFSolicitanteKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFSolicitante.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFSolicitanteKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFNumeroDiasSintomasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNumeroDiasSintomasKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([0-9]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFNumeroDiasSintomas.getText().length() >= 2) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFNumeroDiasSintomasKeyTyped

    private void JTXTFNumeroDiasSintomasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNumeroDiasSintomasKeyReleased
        JLBLContadorNumeroDiasSintomas.setText(String.valueOf(JTXTFNumeroDiasSintomas.getText().length()));
    }//GEN-LAST:event_JTXTFNumeroDiasSintomasKeyReleased

    private void JTXTFNumeroDiasSintomasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNumeroDiasSintomasFocusGained
        JTXTFNumeroDiasSintomas.selectAll();
    }//GEN-LAST:event_JTXTFNumeroDiasSintomasFocusGained

    private void JTXTFSolicitanteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFSolicitanteFocusGained
        JTXTFSolicitante.selectAll();
    }//GEN-LAST:event_JTXTFSolicitanteFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarRecepcion dialog = new ModificarRecepcion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNGuardar;
    private javax.swing.JComboBox<ItemEstablecimiento> JCMBXEstablecimiento;
    private javax.swing.JComboBox<String> JCMBXMujerEmbarazada;
    private javax.swing.JComboBox<String> JCMBXMujerParto;
    private javax.swing.JComboBox<String> JCMBXMujerPostParto;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaProcesamiento;
    private javax.swing.JLabel JLBLApellido;
    private javax.swing.JLabel JLBLCedulaIdentidad;
    private javax.swing.JLabel JLBLCodigoRegistroLaboratorio;
    private javax.swing.JLabel JLBLContadorNumeroDiasSintomas;
    private javax.swing.JLabel JLBLContadorSolicitante;
    private javax.swing.JLabel JLBLFechaRecepcion;
    private javax.swing.JLabel JLBLHoraRecepcion;
    private javax.swing.JLabel JLBLNombre;
    private javax.swing.JLabel JLBLPacienteEdad;
    private javax.swing.JLabel JLBLPacienteFechaNacimiento;
    private javax.swing.JLabel JLBLPersonalTecnico;
    private javax.swing.JLabel JLBLSexo;
    private javax.swing.JTable JTBLExamenes;
    private javax.swing.JTextField JTXTFNumeroDiasSintomas;
    private javax.swing.JTextField JTXTFSolicitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private int obtenerEstablecimientoRegistrado(final int codigoEstablecimiento) {
        final int sizeModel = JCMBXEstablecimiento.getModel().getSize();

        for (int i = 0; i < sizeModel; i++) {
            if (JCMBXEstablecimiento.getItemAt(i).getCodigoEstablecimiento() == codigoEstablecimiento) {
                return i;
            }
        }
        return -1;
    }

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            if (JTXTFSolicitante.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del médico.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFSolicitante.requestFocus();
            } else if (JCMBXEstablecimiento.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el establecimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final List<ExamenSeleccionado> examenesSeleccionados = tableModelRegistrarModificarRecepcion.getExamenesSeleccionados();

                if (examenesSeleccionados.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona al menos un exámen.", "SIET", JOptionPane.ERROR_MESSAGE);
                } else {
                    final boolean mujerEmbarazada = JCMBXMujerEmbarazada.getSelectedIndex() == 1;
                    final boolean mujerParto = JCMBXMujerParto.getSelectedIndex() == 1;
                    final boolean mujerPostParto = JCMBXMujerPostParto.getSelectedIndex() == 1;
                    final int numeroDiasSintomas = JTXTFNumeroDiasSintomas.getText().trim().isEmpty() ? 0 : Integer.valueOf(JTXTFNumeroDiasSintomas.getText());
                    final Date fechaProcesamiento = JDTCHOOSERFechaProcesamiento.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaProcesamiento.getDate()));
                    final String solicitante = JTXTFSolicitante.getText();
                    final ItemEstablecimiento itemEstablecimiento = (ItemEstablecimiento) JCMBXEstablecimiento.getSelectedItem();
                    final Establecimiento establecimiento = new Establecimiento(itemEstablecimiento.getCodigoEstablecimiento(), itemEstablecimiento.getEstablecimientoNombre(), itemEstablecimiento.getEstablecimientoTipo(), itemEstablecimiento.getEstablecimientoArea(), itemEstablecimiento.getEstablecimientoEstado());
                    recepcion.setMujerEmbarazada(mujerEmbarazada);
                    recepcion.setMujerParto(mujerParto);
                    recepcion.setMujerPostParto(mujerPostParto);
                    recepcion.setNumeroDiasSintomas(numeroDiasSintomas);
                    recepcion.setFechaProcesamiento(fechaProcesamiento);
                    recepcion.setEstablecimiento(establecimiento);
                    recepcion.setSolicitante(solicitante);
                    boolean examenFound = false;
                    final List<ExamenSolicitado> nuevosExamenesSolicitados = new ArrayList<>();
                    final List<ExamenSolicitado> antiguosExamenesSolicitados = tableModelRegistrarModificarRecepcion.getExamenesSolicitados();

                    /*
                    *   Este ciclo se encarga de preservar los examenes que el paciente ya solicito con anterioridad y que en esta modificacion no lo esta eliminando.
                     */
                    for (final ExamenSeleccionado examenSeleccionado : examenesSeleccionados) {
                        for (final ExamenSolicitado antiguoExamenSolicitado : antiguosExamenesSolicitados) {
                            if (examenSeleccionado.getExamen().getCodigoExamen() == antiguoExamenSolicitado.getExamen().getCodigoExamen()) {
                                examenFound = true;
                                nuevosExamenesSolicitados.add(new ExamenSolicitado(antiguoExamenSolicitado.getCodigoExamenSolicitado(), recepcion, examenSeleccionado.getExamen(), examenSeleccionado.getMuestraBiologica(), examenSeleccionado.getTotalMuestrasBiologicas(), examenSeleccionado.getEstadoMuestraBiologica(), 1));
                                break;
                            }
                        }

                        // Si en ciclo no se pudo encontrar el examen seleccionado dentro de la lista de los examenes solicitados por el paciente con anterioridad, quiere decir que el paciente esta solicitando un
                        // nuevo examen a su recepcion.
                        if (examenFound == false) {
                            nuevosExamenesSolicitados.add(new ExamenSolicitado(0, recepcion, examenSeleccionado.getExamen(), examenSeleccionado.getMuestraBiologica(), examenSeleccionado.getTotalMuestrasBiologicas(), examenSeleccionado.getEstadoMuestraBiologica(), 1));
                        }
                        examenFound = false;
                    }

                    /*
                    *   Este ciclo se encarga de identificar los examenes que el paciente desea eliminar de su recepcion.
                     */
                    for (final ExamenSolicitado antiguoExamenSolicitado : antiguosExamenesSolicitados) {
                        for (final ExamenSeleccionado examenSeleccionado : examenesSeleccionados) {
                            if (antiguoExamenSolicitado.getExamen().getCodigoExamen() == examenSeleccionado.getExamen().getCodigoExamen()) {
                                examenFound = true;
                                break;
                            }
                        }

                        if (examenFound == false) {
                            nuevosExamenesSolicitados.add(new ExamenSolicitado(antiguoExamenSolicitado.getCodigoExamenSolicitado(), recepcion, antiguoExamenSolicitado.getExamen(), antiguoExamenSolicitado.getMuestraBiologica(), antiguoExamenSolicitado.getTotalMuestrasBiologicas(), antiguoExamenSolicitado.getMuestraBiologicaEstado(), 0));
                        }
                        examenFound = false;
                    }
                    presenterGestionRecepciones.actualizarRecepcion(nuevosExamenesSolicitados);
                }
            }
        }
    };

    private int getIndexMuestraBiologicaSeleccionada(final ItemMuestraBiologica itemMuestraBiologica) {
        final int size = jComboBoxMuestrasBiologicas.getItemCount();
        for (int i = 0; i < size; i++) {
            if (jComboBoxMuestrasBiologicas.getItemAt(i).getCodigoMuestraBiologica() == itemMuestraBiologica.getCodigoMuestraBiologica()) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexEstadoMuestraBiologica(final String estadoMuestraBiologica) {
        final int size = jComboBoxEstadoMuestras.getItemCount();
        for (int i = 0; i < size; i++) {
            if (jComboBoxEstadoMuestras.getItemAt(i).equals(estadoMuestraBiologica)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void examenesObtenidos(final List<ExamenPersonalizado> examenesPersonalizados) {
        tableModelRegistrarModificarRecepcion.setExamenesPersonalizados(examenesPersonalizados);
        tableModelRegistrarModificarRecepcion.addTableModelListener(this);
        JTBLExamenes.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void listaExamenesVacia(final String msg) {
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
    public void muestrasBiologicasObtenidas(final List<MuestraBiologica> muestrasBiologicas) {
        final TableColumn tableColumn = JTBLExamenes.getColumnModel().getColumn(2);
        jComboBoxMuestrasBiologicas = new JComboBox<>();
        muestrasBiologicas.forEach((muestraBiologica) -> {
            jComboBoxMuestrasBiologicas.addItem(new ItemMuestraBiologica(muestraBiologica.getCodigoMuestraBiologica(), muestraBiologica.getMuestraBiologicaTipo(), muestraBiologica.getMuestraBiologicaEstado()));
        });
        jComboBoxMuestrasBiologicas.addItemListener(this);
        tableColumn.setCellEditor(new DefaultCellEditor(jComboBoxMuestrasBiologicas));
    }

    @Override
    public void listaMuestrasBiologicasVacia(final String msg) {
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
    public void examenesSolicitadosObtenidos(final List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados) {
        final List<ExamenSolicitado> examenesSolicitados = new ArrayList<>();
        examenesSolicitadosPersonalizados.forEach((examenSolicitadoPesonalizado) -> {
            examenesSolicitados.add(new ExamenSolicitado(examenSolicitadoPesonalizado.getExamenSolicitado().getCodigoExamenSolicitado(), recepcion, examenSolicitadoPesonalizado.getExamenSolicitado().getExamen(), examenSolicitadoPesonalizado.getExamenSolicitado().getMuestraBiologica(), examenSolicitadoPesonalizado.getExamenSolicitado().getTotalMuestrasBiologicas(), examenSolicitadoPesonalizado.getExamenSolicitado().getMuestraBiologicaEstado(), examenSolicitadoPesonalizado.getExamenSolicitado().getExamenSolicitadoEstado()));
        });
        tableModelRegistrarModificarRecepcion.setExamenesSolicitados(examenesSolicitados);

        final List<Examen> examenes = tableModelRegistrarModificarRecepcion.getExamenes();
        final int examenesSize = examenes.size();

        examenesSolicitados.forEach((examenSolicitado) -> {
            for (int rowIndex = 0; rowIndex < examenesSize; rowIndex++) {

                if (examenes.get(rowIndex).getCodigoExamen() == examenSolicitado.getExamen().getCodigoExamen()) {
                    final ItemMuestraBiologica itemMuestraBiologica = new ItemMuestraBiologica(examenSolicitado.getMuestraBiologica().getCodigoMuestraBiologica(), examenSolicitado.getMuestraBiologica().getMuestraBiologicaTipo(), examenSolicitado.getMuestraBiologica().getMuestraBiologicaEstado());

                    jComboBoxMuestrasBiologicas.setSelectedIndex(getIndexMuestraBiologicaSeleccionada(itemMuestraBiologica));
                    jComboBoxTotalMuestrasBiologicas.setSelectedIndex(examenSolicitado.getTotalMuestrasBiologicas() == 1 ? 0 : 1);
                    jComboBoxEstadoMuestras.setSelectedIndex(getIndexEstadoMuestraBiologica(examenSolicitado.getMuestraBiologicaEstado()));
                    tableModelRegistrarModificarRecepcion.setValueAt(true, rowIndex, 5);
                    break;
                }
            }
        });
    }

    @Override
    public void listaExamenesSolicitadosVacia(final String msg) {
    }

    @Override
    public void errorObtenerExamenesSolicitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerExamenesSolicitados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void establecimientosObtenidos(final List<Establecimiento> establecimientos) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        establecimientos.forEach((establecimiento) -> {
            defaultComboBoxModel.addElement(new ItemEstablecimiento(establecimiento.getCodigoEstablecimiento(), establecimiento.getEstablecimientoNombre(), establecimiento.getEstablecimientoTipo(), establecimiento.getEstablecimientoArea(), establecimiento.getEstablecimientoEstado()));
        });
        JCMBXEstablecimiento.setModel(defaultComboBoxModel);
        JCMBXEstablecimiento.setSelectedIndex(-1);
    }

    @Override
    public void listaEstablecimientosVacia(final String msg) {
    }

    @Override
    public void errorObtenerEstablecimientos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEstablecimientos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void muestraValida(final String msg) {
    }

    @Override
    public void muestraNoValida(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorValidarMuestra(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void aspectoValido(final String msg) {
    }

    @Override
    public void aspectoNoValido(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorValidarAspecto(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void permisoNegado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarPermisoModificacion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void recepcionActualizada(final String msg) {
        dispose();
    }

    @Override
    public void errorActualizarRecepcion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoActualizarRecepcion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void tableChanged(final TableModelEvent tme) {
        if (tme.getColumn() == 5 && JTBLExamenes.getSelectedRowCount() > 0) {
            final int rowModel = JTBLExamenes.convertRowIndexToModel(JTBLExamenes.getSelectedRow());
            final boolean select = Boolean.parseBoolean(JTBLExamenes.getModel().getValueAt(rowModel, 5).toString());

            final Examen examen = tableModelRegistrarModificarRecepcion.getExamen(rowModel);

            if (select) {
                final ItemMuestraBiologica itemMuestraBiologica = (ItemMuestraBiologica) jComboBoxMuestrasBiologicas.getSelectedItem();
                final int totalMuestrasBiologicas = Integer.valueOf(String.valueOf(jComboBoxTotalMuestrasBiologicas.getSelectedItem()));
                final String estadoMuestraBiologica = jComboBoxEstadoMuestras.getModel().getSelectedItem().toString();

                tableModelRegistrarModificarRecepcion.setValueAt(itemMuestraBiologica.getMuestraBiologicaNombre(), rowModel, 2);
                tableModelRegistrarModificarRecepcion.setValueAt(totalMuestrasBiologicas, rowModel, 3);
                tableModelRegistrarModificarRecepcion.setValueAt(estadoMuestraBiologica, rowModel, 4);

                final MuestraBiologica muestraBiologica = new MuestraBiologica(itemMuestraBiologica.getCodigoMuestraBiologica(), itemMuestraBiologica.getMuestraBiologicaNombre(), itemMuestraBiologica.getMuestraBiologicaEstado());
                tableModelRegistrarModificarRecepcion.setExamenSeleccionado(new ExamenSeleccionado(examen, muestraBiologica, totalMuestrasBiologicas, estadoMuestraBiologica));
            } else {
                tableModelRegistrarModificarRecepcion.setValueAt(null, rowModel, 2);
                tableModelRegistrarModificarRecepcion.setValueAt(-1, rowModel, 3);
                tableModelRegistrarModificarRecepcion.setValueAt(null, rowModel, 4);
                tableModelRegistrarModificarRecepcion.removeExamenSeleccionado(examen);
            }
        } else if (tme.getColumn() == 5 && JTBLExamenes.getSelectedRowCount() == 0) {
            final int rowSizeModel = JTBLExamenes.getModel().getRowCount();

            for (int rowIndex = 0; rowIndex < rowSizeModel; rowIndex++) {
                if (Boolean.valueOf(tableModelRegistrarModificarRecepcion.getValueAt(rowIndex, 5).toString())) {
                    final Examen examen = tableModelRegistrarModificarRecepcion.getExamen(rowIndex);
                    if (!tableModelRegistrarModificarRecepcion.examenSeleccionadoExiste(examen)) {
                        final ItemMuestraBiologica itemMuestraBiologica = (ItemMuestraBiologica) jComboBoxMuestrasBiologicas.getSelectedItem();
                        final int totalMuestrasBiologicas = Integer.valueOf(String.valueOf(jComboBoxTotalMuestrasBiologicas.getSelectedItem()));
                        final String estadoMuestraBiologica = jComboBoxEstadoMuestras.getSelectedItem().toString();

                        tableModelRegistrarModificarRecepcion.setValueAt(itemMuestraBiologica.getMuestraBiologicaNombre(), rowIndex, 2);
                        tableModelRegistrarModificarRecepcion.setValueAt(totalMuestrasBiologicas, rowIndex, 3);
                        tableModelRegistrarModificarRecepcion.setValueAt(estadoMuestraBiologica, rowIndex, 4);

                        final MuestraBiologica muestraBiologica = new MuestraBiologica(itemMuestraBiologica.getCodigoMuestraBiologica(), itemMuestraBiologica.getMuestraBiologicaNombre(), itemMuestraBiologica.getMuestraBiologicaEstado());
                        tableModelRegistrarModificarRecepcion.setExamenSeleccionado(new ExamenSeleccionado(examen, muestraBiologica, totalMuestrasBiologicas, estadoMuestraBiologica));
                    }
                }
            }
        }
    }

    @Override
    public void itemStateChanged(final ItemEvent ie) {
        if (JTBLExamenes.getSelectedRowCount() > 0) {
            final int rowModel = JTBLExamenes.convertRowIndexToModel(JTBLExamenes.getSelectedRow());
            final Examen examen = tableModelRegistrarModificarRecepcion.getExamen(rowModel);

            if (ie.getSource() == jComboBoxMuestrasBiologicas && ie.getStateChange() == ItemEvent.SELECTED) {
                final ItemMuestraBiologica itemMuestraBiologica = (ItemMuestraBiologica) jComboBoxMuestrasBiologicas.getSelectedItem();
                final MuestraBiologica muestraBiologica = new MuestraBiologica(itemMuestraBiologica.getCodigoMuestraBiologica(), itemMuestraBiologica.getMuestraBiologicaNombre(), itemMuestraBiologica.getMuestraBiologicaEstado());
                tableModelRegistrarModificarRecepcion.updateMuestraBiologica(examen, muestraBiologica);
            } else if (ie.getSource() == jComboBoxTotalMuestrasBiologicas && ie.getStateChange() == ItemEvent.SELECTED) {
                tableModelRegistrarModificarRecepcion.updateTotalMuestrasBiologicas(examen, Integer.parseInt(jComboBoxTotalMuestrasBiologicas.getSelectedItem().toString()));
            } else if (ie.getSource() == jComboBoxEstadoMuestras && ie.getStateChange() == ItemEvent.SELECTED) {
                tableModelRegistrarModificarRecepcion.updateEstadoMuestraBiologica(examen, jComboBoxEstadoMuestras.getSelectedItem().toString());
            }
        }
    }
}
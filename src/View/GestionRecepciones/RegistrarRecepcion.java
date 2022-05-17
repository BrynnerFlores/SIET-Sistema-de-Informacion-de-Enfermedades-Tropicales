package View.GestionRecepciones;

import Model.POJO.PersonalTecnico;
import Model.POJO.Establecimiento;
import Model.POJO.Examen;
import Model.POJO.ExamenSolicitado;
import Model.POJO.MuestraBiologica;
import Model.POJO.Paciente;
import Model.POJO.Persona;
import Model.POJO.Recepcion;
import Model.POJOPersonalizado.ExamenPersonalizado;
import Presenter.GestionRecepciones.PresenterGestionRecepciones;
import View.Utilitarios.Utilidades;
import View.Utilitarios.ModelTable.GestionRecepciones.ExamenSeleccionado;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelRegistrarModificarRecepcion;
import View.Utilitarios.ModeloItemComboBox.ItemEstablecimiento;
import View.Utilitarios.ModeloItemComboBox.ItemMuestraBiologica;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Brynner
 */
public class RegistrarRecepcion extends javax.swing.JDialog implements PresenterGestionRecepciones.CallBackObtenerExamenes, PresenterGestionRecepciones.CallBackObtenerMuestrasBiologicas, PresenterGestionRecepciones.CallBackObtenerEstablecimientos, PresenterGestionRecepciones.CallBackRegistrarRecepcion, TableModelListener, ItemListener, PresenterGestionRecepciones.CallBackGenerarCodigoRegistroLaboratorio {

    private final PresenterGestionRecepciones presenterGestionRecepciones;
    private final TableModelRegistrarModificarRecepcion tableModelRegistrarModificarRecepcion;
    private final JComboBox jComboBoxEstadoMuestras;
    private final JComboBox jComboBoxTotalMuestrasBiologicas;
    private JComboBox<ItemMuestraBiologica> jComboBoxMuestrasBiologicas;

    private PersonalTecnico personalTecnico;
    private Paciente paciente;
    private String cedulaIdentidad;
    private String codigoRegistroLaboratorio;
    private boolean pacienteExiste;
    private int pacienteEdadYears = -1;
    private int pacienteEdadMeses = -1;
    private int pacienteEdadDias = -1;

    public RegistrarRecepcion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        tableModelRegistrarModificarRecepcion = new TableModelRegistrarModificarRecepcion();

        presenterGestionRecepciones = new PresenterGestionRecepciones();
        presenterGestionRecepciones.setCallBackObtenerExamenes(this);
        presenterGestionRecepciones.setCallBackObtenerMuestrasBiologicas(this);
        presenterGestionRecepciones.setCallBackObtenerEstablecimientos(this);
        presenterGestionRecepciones.setCallBackRegistrarRecepcion(this);
        presenterGestionRecepciones.setCallBackGenerarCodigoRegistroLaboratorio(this);

        personalTecnico = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
        codigoRegistroLaboratorio = null;

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

        JTXTFCedulaIdentidad.addActionListener(action);
        JTXTFApellidos.addActionListener(action);
        JTXTFNombres.addActionListener(action);
        JTXTFNumeroDiasSintomas.addActionListener(action);
        JTXTFSolicitante.addActionListener(action);
        JBTNRegistrar.addActionListener(action);

    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setCedulaIdentidad(String cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public void setPacienteExiste(boolean pacienteExiste) {
        this.pacienteExiste = pacienteExiste;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTXTFNombres = new javax.swing.JTextField();
        JTXTFApellidos = new javax.swing.JTextField();
        JTXTFCedulaIdentidad = new javax.swing.JTextField();
        JDTCHOOSERPacienteFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JLBLPacienteEdad = new javax.swing.JLabel();
        JCMBXSexo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        JLBLContadorCedulaIdentidad = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JLBLContadorApellidos = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JLBLContadorNombre = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JTXTFSolicitante = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JDTCHOOSERFechaRecepcion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPHoraRecepcion = new javax.swing.JSpinner(spinnerDateModel);
        jLabel13 = new javax.swing.JLabel();
        JLBLPersonalTecnico = new javax.swing.JLabel();
        JCMBXEstablecimiento = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        JLBLContadorSolicitante = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        JLBLNumeroRegistroLaboratorio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLExamenes = new javax.swing.JTable();
        JBTNCancelar = new javax.swing.JButton();
        JBTNRegistrar = new javax.swing.JButton();
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
        jLabel21 = new javax.swing.JLabel();
        JLBLContadorNumeroDiasSintomas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Nueva Recepcion");
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

        JTXTFNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNombresFocusGained(evt);
            }
        });
        JTXTFNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFNombresKeyTyped(evt);
            }
        });
        JTXTFNombres.setTransferHandler(null);

        JTXTFApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFApellidosFocusGained(evt);
            }
        });
        JTXTFApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFApellidosKeyTyped(evt);
            }
        });
        JTXTFApellidos.setTransferHandler(null);

        JTXTFCedulaIdentidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFCedulaIdentidadFocusGained(evt);
            }
        });
        JTXTFCedulaIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFCedulaIdentidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFCedulaIdentidadKeyTyped(evt);
            }
        });
        JTXTFCedulaIdentidad.setTransferHandler(null);

        JDTCHOOSERPacienteFechaNacimiento.setDate(null);
        JDTCHOOSERPacienteFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERPacienteFechaNacimiento.setMaxSelectableDate(Calendar.getInstance().getTime());
        JDTCHOOSERPacienteFechaNacimiento.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                final LocalDate today = LocalDate.now();
                final LocalDate birthday = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERPacienteFechaNacimiento.getDate()), formatter);

                final Period period = Period.between(birthday, today);
                pacienteEdadYears = period.getYears();
                pacienteEdadMeses = period.getMonths();
                pacienteEdadDias = period.getDays();

                JLBLPacienteEdad.setText(pacienteEdadYears + " Años " + pacienteEdadMeses + " Meses " + pacienteEdadDias + " Días");
            }
        });

        jLabel16.setText("FECHA DE  NACIMIENTO:");

        jLabel17.setText("EDAD:");

        JLBLPacienteEdad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JCMBXSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        JCMBXSexo.setSelectedIndex(-1);
        JCMBXSexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXSexoItemStateChanged(evt);
            }
        });

        jLabel4.setText("SEXO:");

        JLBLContadorCedulaIdentidad.setText("0");

        jLabel14.setText("/20");

        JLBLContadorApellidos.setText("0");

        jLabel18.setText("/50");

        JLBLContadorNombre.setText("0");

        jLabel19.setText("/50");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorCedulaIdentidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTXTFNombres, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTXTFApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(JTXTFCedulaIdentidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JCMBXSexo, javax.swing.GroupLayout.Alignment.LEADING, 0, 350, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JDTCHOOSERPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JLBLPacienteEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(JLBLContadorCedulaIdentidad))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(JLBLContadorApellidos))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(JLBLContadorNombre))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDTCHOOSERPacienteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLPacienteEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFSolicitanteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFSolicitanteKeyTyped(evt);
            }
        });
        JTXTFSolicitante.setTransferHandler(null);

        jLabel10.setText("SOLICITADO POR:");

        jLabel11.setText("ESTABLECIMIENTO DE SALUD:");

        JDTCHOOSERFechaRecepcion.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaRecepcion.setDateFormatString("yyyy-MM-dd");
        JDTCHOOSERFechaRecepcion.setMaxSelectableDate(Calendar.getInstance().getTime());

        jLabel12.setText("FECHA DE RECEPCION:");

        JSPHoraRecepcion.setEditor(new JSpinner.DateEditor(JSPHoraRecepcion, "HH:mm:ss"));

        jLabel13.setText("HORA DE RECEPCION:");

        JLBLPersonalTecnico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("/50");

        JLBLContadorSolicitante.setText("0");

        jLabel22.setText("CODIGO DE REGISTRO DE LABORATORIO:");

        JLBLNumeroRegistroLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLNumeroRegistroLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorSolicitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(JLBLPersonalTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXTFSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(JCMBXEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(JDTCHOOSERFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JSPHoraRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addComponent(jLabel22))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel20)
                    .addComponent(JLBLContadorSolicitante))
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
                    .addComponent(JDTCHOOSERFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPHoraRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLNumeroRegistroLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        JTBLExamenes.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLExamenes.getColumnModel().getColumn(1).setPreferredWidth(350);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNRegistrar.setText("REGISTRAR");

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

        jLabel21.setText("/2");

        JLBLContadorNumeroDiasSintomas.setText("0");

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
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel21)
                    .addComponent(JLBLContadorNumeroDiasSintomas))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNRegistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNRegistrar))
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
            if (personalTecnico == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                if (pacienteExiste) {
                    if (paciente == null) {
                        JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                        dispose();
                    } else {
                        JTXTFCedulaIdentidad.setEditable(false);
                        JTXTFApellidos.setEditable(false);
                        JTXTFNombres.setEditable(false);
                        JDTCHOOSERPacienteFechaNacimiento.setEnabled(false);
                        JCMBXSexo.setEnabled(false);
                        
                        JTXTFCedulaIdentidad.setText(paciente.getPersona().getPersonaCedulaIdentidad());
                        JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
                        JTXTFApellidos.setText(paciente.getPersona().getPersonaApellido());
                        JLBLContadorApellidos.setText(String.valueOf(JTXTFApellidos.getText().length()));
                        JTXTFNombres.setText(paciente.getPersona().getPersonaNombre());
                        JLBLContadorNombre.setText(String.valueOf(JTXTFNombres.getText().length()));
                        JDTCHOOSERPacienteFechaNacimiento.setDate(paciente.getPacienteFechaNacimiento());
                        JCMBXSexo.setSelectedIndex(paciente.getPersona().getPersonaSexo().equals("M") ? 0 : 1);

                        JLBLPersonalTecnico.setText(personalTecnico.getPersona().getPersonaApellido() + " " + personalTecnico.getPersona().getPersonaNombre());
                        presenterGestionRecepciones.generarCodigoRegistroLaboratorio();
                        presenterGestionRecepciones.obtenerExamenes();
                        presenterGestionRecepciones.obtenerMuestrasBiologicas();
                        presenterGestionRecepciones.obtenerEstablecimientos();
                    }
                } else {
                    if (cedulaIdentidad.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Se produjo un error, cédula de identidad no recibida. Vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                        dispose();
                    } else {
                        JLBLContadorCedulaIdentidad.setText(String.valueOf(cedulaIdentidad.length()));
                        JTXTFCedulaIdentidad.setText(cedulaIdentidad);

                        JLBLPersonalTecnico.setText(personalTecnico.getPersona().getPersonaApellido() + " " + personalTecnico.getPersona().getPersonaNombre());
                        presenterGestionRecepciones.generarCodigoRegistroLaboratorio();
                        presenterGestionRecepciones.obtenerExamenes();
                        presenterGestionRecepciones.obtenerMuestrasBiologicas();
                        presenterGestionRecepciones.obtenerEstablecimientos();

                        JTXTFApellidos.requestFocus();
                    }
                }
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTBLExamenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLExamenesMousePressed
        final int currentRow = JTBLExamenes.rowAtPoint(evt.getPoint());
        JTBLExamenes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLExamenesMousePressed

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFCedulaIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-.]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFCedulaIdentidad.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyTyped

    private void JTXTFApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFApellidosKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-ZñÑ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFApellidos.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFApellidosKeyTyped

    private void JTXTFNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombresKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-ZñÑ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFNombres.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFNombresKeyTyped

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

    private void JCMBXSexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXSexoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (JCMBXSexo.getSelectedIndex() == 0) {
                JCMBXMujerEmbarazada.setEnabled(false);
                JCMBXMujerParto.setEnabled(false);
                JCMBXMujerPostParto.setEnabled(false);
            } else {
                JCMBXMujerEmbarazada.setEnabled(true);
                JCMBXMujerParto.setEnabled(true);
                JCMBXMujerPostParto.setEnabled(true);
            }
        }
    }//GEN-LAST:event_JCMBXSexoItemStateChanged

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

    private void JTXTFCedulaIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadKeyReleased
        JLBLContadorCedulaIdentidad.setText(String.valueOf(JTXTFCedulaIdentidad.getText().length()));
    }//GEN-LAST:event_JTXTFCedulaIdentidadKeyReleased

    private void JTXTFApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFApellidosKeyReleased
        JLBLContadorApellidos.setText(String.valueOf(JTXTFApellidos.getText().length()));
    }//GEN-LAST:event_JTXTFApellidosKeyReleased

    private void JTXTFNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombresKeyReleased
        JLBLContadorNombre.setText(String.valueOf(JTXTFNombres.getText().length()));
    }//GEN-LAST:event_JTXTFNombresKeyReleased

    private void JTXTFSolicitanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFSolicitanteKeyReleased
        JLBLContadorSolicitante.setText(String.valueOf(JTXTFSolicitante.getText().length()));
    }//GEN-LAST:event_JTXTFSolicitanteKeyReleased

    private void JTXTFNumeroDiasSintomasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNumeroDiasSintomasKeyReleased
        JLBLContadorNumeroDiasSintomas.setText(String.valueOf(JTXTFNumeroDiasSintomas.getText().length()));
    }//GEN-LAST:event_JTXTFNumeroDiasSintomasKeyReleased

    private void JTXTFCedulaIdentidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFCedulaIdentidadFocusGained
        JTXTFCedulaIdentidad.selectAll();
    }//GEN-LAST:event_JTXTFCedulaIdentidadFocusGained

    private void JTXTFApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFApellidosFocusGained
        JTXTFApellidos.selectAll();
    }//GEN-LAST:event_JTXTFApellidosFocusGained

    private void JTXTFNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombresFocusGained
        JTXTFNombres.selectAll();
    }//GEN-LAST:event_JTXTFNombresFocusGained

    private void JTXTFNumeroDiasSintomasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNumeroDiasSintomasFocusGained
        JTXTFNumeroDiasSintomas.selectAll();
    }//GEN-LAST:event_JTXTFNumeroDiasSintomasFocusGained

    private void JTXTFSolicitanteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFSolicitanteFocusGained
        JTXTFSolicitante.selectAll();
    }//GEN-LAST:event_JTXTFSolicitanteFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarRecepcion dialog = new RegistrarRecepcion(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<ItemEstablecimiento> JCMBXEstablecimiento;
    private javax.swing.JComboBox<String> JCMBXMujerEmbarazada;
    private javax.swing.JComboBox<String> JCMBXMujerParto;
    private javax.swing.JComboBox<String> JCMBXMujerPostParto;
    private javax.swing.JComboBox<String> JCMBXSexo;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaProcesamiento;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaRecepcion;
    private com.toedter.calendar.JDateChooser JDTCHOOSERPacienteFechaNacimiento;
    private javax.swing.JLabel JLBLContadorApellidos;
    private javax.swing.JLabel JLBLContadorCedulaIdentidad;
    private javax.swing.JLabel JLBLContadorNombre;
    private javax.swing.JLabel JLBLContadorNumeroDiasSintomas;
    private javax.swing.JLabel JLBLContadorSolicitante;
    private javax.swing.JLabel JLBLNumeroRegistroLaboratorio;
    private javax.swing.JLabel JLBLPacienteEdad;
    private javax.swing.JLabel JLBLPersonalTecnico;
    private javax.swing.JSpinner JSPHoraRecepcion;
    private javax.swing.JTable JTBLExamenes;
    private javax.swing.JTextField JTXTFApellidos;
    private javax.swing.JTextField JTXTFCedulaIdentidad;
    private javax.swing.JTextField JTXTFNombres;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            if (pacienteExiste) {
                if (JTXTFSolicitante.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del solicitante.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFSolicitante.requestFocus();
                } else if (JCMBXEstablecimiento.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona el establecimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JCMBXEstablecimiento.requestFocus();
                } else if (JDTCHOOSERFechaRecepcion.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa la fecha de recepción.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JCMBXEstablecimiento.requestFocus();
                } else if (JSPHoraRecepcion == null || JSPHoraRecepcion.getValue().toString().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa la hora de recepción.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JSPHoraRecepcion.requestFocus();
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
                        final Date fechaRecepcion = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaRecepcion.getDate()));
                        final Time horaRecepcion = Time.valueOf(new JSpinner.DateEditor(JSPHoraRecepcion, "HH:mm:ss").getFormat().format(JSPHoraRecepcion.getValue()));
                        
                        final Recepcion recepcion = paciente.getPersona().getPersonaSexo().equals("M") ? new Recepcion(personalTecnico, paciente, establecimiento, codigoRegistroLaboratorio, pacienteEdadYears, pacienteEdadMeses, pacienteEdadDias, false, false, false, numeroDiasSintomas, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, 1) : new Recepcion(personalTecnico, paciente, establecimiento, codigoRegistroLaboratorio, pacienteEdadYears, pacienteEdadMeses, pacienteEdadDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintomas, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, 1);
                        final List<ExamenSolicitado> examenesSolicitados = new ArrayList<>();
                        examenesSeleccionados.forEach((examenSeleccionado) -> {
                            examenesSolicitados.add(new ExamenSolicitado(recepcion, examenSeleccionado.getExamen(), examenSeleccionado.getMuestraBiologica(), examenSeleccionado.getTotalMuestrasBiologicas(), examenSeleccionado.getEstadoMuestraBiologica(), 1));
                        });
                        
                        
                        if (codigoRegistroLaboratorio == null) {
                            JOptionPane.showMessageDialog(rootPane, "No se pudo generar el codigo de regitro de laboratorio, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                        } else {
                            presenterGestionRecepciones.registrarRecepcion(examenesSolicitados);
                        }
                    }
                }
            } else {
                if (JTXTFCedulaIdentidad.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa la cedula de identidad del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFCedulaIdentidad.requestFocus();
                } else if (JTXTFApellidos.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa el apellido del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFApellidos.requestFocus();
                } else if (JTXTFNombres.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFNombres.requestFocus();
                } else if (JDTCHOOSERPacienteFechaNacimiento.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de nacimiento del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFNombres.requestFocus();
                } else if (pacienteEdadYears == -1 || pacienteEdadMeses == -1 || pacienteEdadDias == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de nacimiento del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFNombres.requestFocus();
                } else if (JCMBXSexo.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona el sexo del paciente.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JCMBXSexo.requestFocus();
                } else if (JTXTFSolicitante.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del médico.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFSolicitante.requestFocus();
                } else if (JCMBXEstablecimiento.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona el establecimiento.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JCMBXEstablecimiento.requestFocus();
                } else if (JDTCHOOSERFechaRecepcion.getDate() == null) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de recepción.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JDTCHOOSERFechaRecepcion.requestFocus();
                } else if (JSPHoraRecepcion.getValue() == null || JSPHoraRecepcion.getValue().toString().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona la hora de recepción.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JSPHoraRecepcion.requestFocus();
                } else {
                    final List<ExamenSeleccionado> examenesSeleccionados = tableModelRegistrarModificarRecepcion.getExamenesSeleccionados();

                    if (examenesSeleccionados.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Selecciona al menos un exámen.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else {
                        final String personaApellido = JTXTFApellidos.getText();
                        final String personaNombre = JTXTFNombres.getText();
                        final Date pacienteFechaNacimiento = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERPacienteFechaNacimiento.getDate()));
                        final String personaSexo = JCMBXSexo.getSelectedIndex() == 0 ? "M" : "F";
                        final boolean mujerEmbarazada = JCMBXMujerEmbarazada.getSelectedIndex() == 1;
                        final boolean mujerParto = JCMBXMujerParto.getSelectedIndex() == 1;
                        final boolean mujerPostParto = JCMBXMujerPostParto.getSelectedIndex() == 1;
                        final int numeroDiasSintomas = JTXTFNumeroDiasSintomas.getText().isEmpty() ? 0 : Integer.valueOf(JTXTFNumeroDiasSintomas.getText());
                        final Date fechaProcesamiento = JDTCHOOSERFechaProcesamiento.getDate() == null ? null : Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaProcesamiento.getDate()));
                        final String solicitante = JTXTFSolicitante.getText();
                        final ItemEstablecimiento itemEstablecimiento = (ItemEstablecimiento) JCMBXEstablecimiento.getSelectedItem();
                        final Establecimiento establecimiento = new Establecimiento(itemEstablecimiento.getCodigoEstablecimiento(), itemEstablecimiento.getEstablecimientoNombre(), itemEstablecimiento.getEstablecimientoTipo(), itemEstablecimiento.getEstablecimientoArea(), itemEstablecimiento.getEstablecimientoEstado());
                        final Date fechaRecepcion = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaRecepcion.getDate()));
                        final Time horaRecepcion = Time.valueOf(new JSpinner.DateEditor(JSPHoraRecepcion, "HH:mm:ss").getFormat().format(JSPHoraRecepcion.getValue()));

                        final Persona persona = new Persona(-1, cedulaIdentidad, personaApellido, personaNombre, personaSexo);
                        final Paciente paciente = new Paciente(persona, pacienteFechaNacimiento);
                        final Recepcion recepcion = personaSexo.equals("M") ? new Recepcion(personalTecnico, paciente, establecimiento, codigoRegistroLaboratorio, pacienteEdadYears, pacienteEdadMeses, pacienteEdadDias, false, false, false, numeroDiasSintomas, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, 1) : new Recepcion(personalTecnico, paciente, establecimiento, codigoRegistroLaboratorio, pacienteEdadYears, pacienteEdadMeses, pacienteEdadDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintomas, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, 1);
                        final List<ExamenSolicitado> examenesSolicitados = new ArrayList<>();
                        examenesSeleccionados.forEach((examenSeleccionado) -> {
                            examenesSolicitados.add(new ExamenSolicitado(recepcion, examenSeleccionado.getExamen(), examenSeleccionado.getMuestraBiologica(), examenSeleccionado.getTotalMuestrasBiologicas(), examenSeleccionado.getEstadoMuestraBiologica(), 1));
                        });
                        
                        if (codigoRegistroLaboratorio == null) {
                            JOptionPane.showMessageDialog(rootPane, "No se pudo generar el codigo de regitro de laboratorio, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                        } else {
                            presenterGestionRecepciones.registrarRecepcion(examenesSolicitados);
                        }
                    }
                }
            }
        }
    };

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
    public void recepcionRegistrada(final String msg) {
        dispose();
    }

    @Override
    public void errorRegistrarRecepcion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoRegistrarRecepcion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void tableChanged(final TableModelEvent tme) {
        if (tme.getColumn() == 5) {
            final int rowModel = JTBLExamenes.convertRowIndexToModel(JTBLExamenes.getSelectedRow());
            final boolean select = Boolean.parseBoolean(JTBLExamenes.getModel().getValueAt(rowModel, 5).toString());

            final Examen examen = tableModelRegistrarModificarRecepcion.getExamen(rowModel);

            if (select) {
                final ItemMuestraBiologica itemMuestraBiologica = (ItemMuestraBiologica) jComboBoxMuestrasBiologicas.getSelectedItem();
                final int totalMuestrasBiologicas = Integer.valueOf(String.valueOf(jComboBoxTotalMuestrasBiologicas.getSelectedItem()));
                final String estadoMuestraBiologica = jComboBoxEstadoMuestras.getSelectedItem().toString();

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
        }
    }

    @Override
    public void itemStateChanged(final ItemEvent ie) {
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

    @Override
    public void codigoGenerado(final String codigo) {
        codigoRegistroLaboratorio = codigo;
        JLBLNumeroRegistroLaboratorio.setText(codigoRegistroLaboratorio);
    }

    @Override
    public void errorGenerarCodigo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoGenerarCodigo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
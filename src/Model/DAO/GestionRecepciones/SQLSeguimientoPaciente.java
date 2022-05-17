package Model.DAO.GestionRecepciones;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Establecimiento;
import Model.POJO.ExamenSolicitado;
import Model.POJO.LogConsulta;
import Model.POJO.MuestraBiologica;
import Model.POJO.PersonalTecnico;
import Model.POJO.Recepcion;
import Model.POJO.SeguimientoPaciente;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLSeguimientoPaciente {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();
    
    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO asegpac(paspcosepa, faspcodpac, faspcodexa, faspcoexso, caspfecini, casphorini, caspprogre, caspdeobin) VALUES(nextval('paspcosepa_sequence'), ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_FINALIZAR_SEGUIMIENTO = "UPDATE asegpac SET caspfecfin = ?, casphorfin = ?, caspprogre = 'FINALIZADO', caspdeobfi = ? WHERE paspcosepa = ? AND caspprogre = 'EN SEGUIMIENTO'";
    private final String SQL_OBTENER_ANTECEDENTE = "SELECT * FROM aexasol INNER JOIN amuebio ON amuebio.pambcomubi = aexasol.faescomubi INNER JOIN arecepc ON arecepc.parecodrec = aexasol.faescodrec WHERE aexasol.paescoexso IN (SELECT faspcoexso FROM asegpac WHERE paspcosepa = ?)";
    private final String SQL_RESOLUCION_INVERSA_DE_EXAMENES_SOLICITADOS = "SELECT * FROM aexasol INNER JOIN amuebio ON amuebio.pambcomubi = aexasol.faescomubi INNER JOIN arecepc ON arecepc.parecodrec = aexasol.faescodrec INNER JOIN aestabl ON aestabl.paeacodest = arecepc.farecodest WHERE paescoexso IN (SELECT fargcoexso FROM aresgen WHERE fargcosepa IN (SELECT paspcosepa FROM asegpac WHERE paspcosepa = ?))";
    private final String SQL_VERIFICAR_SEGUIMIENTO_EXISTE = "SELECT EXISTS(SELECT 1 FROM asegpac WHERE faspcodpac = ? AND faspcodexa = ? AND faspcoexso = ?)";
    private final String SQL_VERIFICAR_SEGUIMIENTO_INICIADO = "SELECT EXISTS (SELECT 1 FROM asegpac WHERE faspcodpac = ? AND faspcodexa = ? AND caspprogre = 'EN SEGUIMIENTO')";
    private final String SQL_VERIFICAR_SEGUIMIENTO_FINALIZADO = "SELECT EXISTS (SELECT 1 FROM asegpac WHERE paspcosepa = ? AND caspprogre = 'FINALIZADO')";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLSeguimientoPaciente() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public boolean insertar(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, seguimientoPaciente.getPaciente().getCodigoPaciente());
            statement.setInt(2, seguimientoPaciente.getExamen().getCodigoExamen());
            statement.setInt(3, seguimientoPaciente.getExamenSolicitado().getCodigoExamenSolicitado());
            statement.setDate(4, seguimientoPaciente.getFechaInicio());
            statement.setTime(5, seguimientoPaciente.getHoraInicio());
            statement.setString(6, seguimientoPaciente.getProgreso());
            statement.setString(7, seguimientoPaciente.getDetallesObservacionesInicio());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSeguimientoPaciente - Insertar: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public boolean finalizarSeguimiento(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_FINALIZAR_SEGUIMIENTO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_FINALIZAR_SEGUIMIENTO);
            statement.setDate(1, seguimientoPaciente.getFechaFinal());
            statement.setTime(2, seguimientoPaciente.getHoraFinal());
            statement.setString(3, seguimientoPaciente.getDetallesObservacionesFinal());
            statement.setInt(4, seguimientoPaciente.getCodigoSeguimientoPaciente());
            
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSeguimientoPaciente - Finalizar Seguimiento: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public ExamenSolicitado obtenerAntecendente(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ANTECEDENTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_ANTECEDENTE);
            statement.setInt(1, seguimientoPaciente.getCodigoSeguimientoPaciente());
            resultSet = statement.executeQuery();
            
            ExamenSolicitado examenSolicitado = null;
            if (resultSet.next()) {
                final int codigoExamenSolicitado = resultSet.getInt(1);
                final int totalMuestraBiologica = resultSet.getInt(5);
                final String estadoMuestraBiologica = resultSet.getString(6);
                final int examenSolicitadoEstado = resultSet.getInt(7);
                
                final int codigoMuestraBiologica = resultSet.getInt(8);
                final String muestraBiologicaTipo = resultSet.getString(9);
                final int muestraBiologicaEstado = resultSet.getInt(10);
                
                final int codigoRecepcion = resultSet.getInt(11);
                final String codigoRegistroLaboratorio = resultSet.getString(15);
                final int edadPacienteYears = resultSet.getInt(16);
                final int edadPacienteMeses = resultSet.getInt(17);
                final int edadPacienteDias = resultSet.getInt(18);
                final boolean mujerEmbarazada = resultSet.getBoolean(19);
                final boolean mujerParto = resultSet.getBoolean(20);
                final boolean mujerPostParto = resultSet.getBoolean(21);
                final int numeroDiasSintoma = resultSet.getInt(22);
                final Date fechaProcesamiento = resultSet.getDate(23);
                final String solicitante = resultSet.getString(24);
                final Date fechaRecepcion = resultSet.getDate(25);
                final Time horaRecepcion = resultSet.getTime(26);
                final int estado = resultSet.getInt(27);
                
                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigoMuestraBiologica, muestraBiologicaTipo, muestraBiologicaEstado);
                final Recepcion recepcion = new Recepcion(codigoRecepcion, null, seguimientoPaciente.getPaciente(), null, codigoRegistroLaboratorio, edadPacienteYears, edadPacienteMeses, edadPacienteDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintoma, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, estado);
                
                examenSolicitado = new ExamenSolicitado(codigoExamenSolicitado, recepcion, seguimientoPaciente.getExamen(), muestraBiologica, totalMuestraBiologica, estadoMuestraBiologica, examenSolicitadoEstado);
            }
            return examenSolicitado;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSeguimientoPaciente - Obtener Antecedente: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public List<ExamenSolicitado> resolucionInversaDeExamenesSolicitados(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_RESOLUCION_INVERSA_DE_EXAMENES_SOLICITADOS));
            
            final List<ExamenSolicitado> examenesSolicitados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_RESOLUCION_INVERSA_DE_EXAMENES_SOLICITADOS);
            statement.setInt(1, seguimientoPaciente.getCodigoSeguimientoPaciente());
            
            resultSet = statement.executeQuery();
            
            examenesSolicitados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoExamenSolicitado = resultSet.getInt(1);
                final int totalMuestraBiologica = resultSet.getInt(5);
                final String estadoMuestraBiologica = resultSet.getString(6);
                final int examenSolicitadoEstado = resultSet.getInt(7);
                
                final int codigoMuestraBiologica = resultSet.getInt(8);
                final String muestraBiologicaTipo = resultSet.getString(9);
                final int muestraBiologicaEstado = resultSet.getInt(10);
                
                final int codigoRecepcion = resultSet.getInt(11);
                final String codigoRegistroLaboratorio = resultSet.getString(15);
                final int edadPacienteYears = resultSet.getInt(16);
                final int edadPacienteMeses = resultSet.getInt(17);
                final int edadPacienteDias = resultSet.getInt(18);
                final boolean mujerEmbarazada = resultSet.getBoolean(19);
                final boolean mujerParto = resultSet.getBoolean(20);
                final boolean mujerPostParto = resultSet.getBoolean(21);
                final int numeroDiasSintoma = resultSet.getInt(22);
                final Date fechaProcesamiento = resultSet.getDate(23);
                final String solicitante = resultSet.getString(24);
                final Date fechaRecepcion = resultSet.getDate(25);
                final Time horaRecepcion = resultSet.getTime(26);
                final int estado = resultSet.getInt(27);
                
                final int codigoEstablecimiento = resultSet.getInt(28);
                final String establecimientoNombre = resultSet.getString(29);
                final String establecimientoTipo = resultSet.getString(30);
                final String establecimientoArea = resultSet.getString(31);
                final int establecimientoEstado = resultSet.getInt(32);
                
                final Establecimiento establecimiento = new Establecimiento(codigoEstablecimiento, establecimientoNombre, establecimientoTipo, establecimientoArea, establecimientoEstado);
                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigoMuestraBiologica, muestraBiologicaTipo, muestraBiologicaEstado);
                final Recepcion recepcion = new Recepcion(codigoRecepcion, null, seguimientoPaciente.getPaciente(), establecimiento, codigoRegistroLaboratorio, edadPacienteYears, edadPacienteMeses, edadPacienteDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintoma, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, estado);
                
                examenesSolicitados.add(new ExamenSolicitado(codigoExamenSolicitado, recepcion, seguimientoPaciente.getExamen(), muestraBiologica, totalMuestraBiologica, estadoMuestraBiologica, examenSolicitadoEstado));
            }
            return examenesSolicitados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLSeguimientoPaciente - Resolucion Inversa de Examenes Solicitados: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarSeguimientoExiste(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SEGUIMIENTO_EXISTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_SEGUIMIENTO_EXISTE);
            statement.setInt(1, seguimientoPaciente.getPaciente().getCodigoPaciente());
            statement.setInt(2, seguimientoPaciente.getExamen().getCodigoExamen());
            statement.setInt(3, seguimientoPaciente.getExamenSolicitado().getCodigoExamenSolicitado());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean existe = resultSet.getBoolean(1);

            if (existe) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSeguimientoPaciente - Verificar Seguimiento Existe: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarSeguimientoIniciado(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SEGUIMIENTO_INICIADO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_SEGUIMIENTO_INICIADO);
            statement.setInt(1, seguimientoPaciente.getPaciente().getCodigoPaciente());
            statement.setInt(2, seguimientoPaciente.getExamen().getCodigoExamen());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isIniciado = resultSet.getBoolean(1);

            if (isIniciado) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSeguimientoPaciente - Verificar Seguimiento Iniciado: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarSeguimientoFinalizado(final SeguimientoPaciente seguimientoPaciente) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SEGUIMIENTO_FINALIZADO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_SEGUIMIENTO_FINALIZADO);
            statement.setInt(1, seguimientoPaciente.getCodigoSeguimientoPaciente());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isFinalizado = resultSet.getBoolean(1);

            if (isFinalizado) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSeguimientoPaciente - Verificar Seguimiento Finalizado: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLSeguimientoPaciente - InsertarEnLog: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    // </editor-fold>
    
}
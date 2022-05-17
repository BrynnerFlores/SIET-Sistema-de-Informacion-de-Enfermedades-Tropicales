package Model.DAO.GestionReactivo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.LoteEliminado;
import Model.POJO.Persona;
import Model.POJO.Reactivo;
import Model.POJO.ReactivoEntrega;
import Model.POJO.ReactivoLote;
import Model.POJOPersonalizado.ReactivoEntregaPersonalizado;
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
public class SQLReactivoEntrega {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_ENTREGA = "INSERT INTO areaent(parecoreen, farecopete, careprovee, carefecent, carehorent, careobserv, careestado) VALUES(nextval('parecoreen_sequence'), ?, ?, ?, ?, ?, ?)";
    private final String SQL_OBTENER_ENTREGAS = "SELECT * FROM areaent INNER JOIN apertec ON apertec.paptcopete = areaent.farecopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper WHERE areaent.careestado = 1 ORDER BY areaent.parecoreen DESC";
    private final String SQL_OBTENER_LOTES = "SELECT * FROM (SELECT *, ABS(carlfecven - current_date) AS ddif FROM arealot rl INNER JOIN areacti ON areacti.parccodrea = rl.farlcodrea WHERE farlcoreen IN (SELECT parecoreen FROM areaent WHERE parecoreen = ? AND careestado = 1) AND carlestado = 1) t0 ORDER BY ddif ASC";
    private final String SQL_OBTENER_LOTES_ELIMINADOS = "SELECT * FROM aloteli INNER JOIN arealot ON arealot.parlcorelo = aloteli.falecorelo INNER JOIN areaent ON areaent.parecoreen = arealot.farlcoreen INNER JOIN areacti ON areacti.parccodrea = arealot.farlcodrea WHERE areaent.parecoreen = ?";
    private final String SQL_OBTENER_TOTAL_LOTES = "SELECT COUNT(*) FROM arealot WHERE farlcoreen = ? AND farlcoreen IN (SELECT parecoreen FROM areaent WHERE careestado = 1)";
    private final String SQL_ACTUALIZAR_ENTREGA = "UPDATE areaent SET careprovee = ?, carefecent = ?, carehorent = ?, careobserv = ? WHERE parecoreen = ? AND careestado = 1";
    private final PersonalTecnico PERSONAL_TECNICO;
    

    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLReactivoEntrega() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final ReactivoEntrega reactivoEntrega) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_ENTREGA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_ENTREGA);
            statement.setInt(1, reactivoEntrega.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, reactivoEntrega.getProveedor());
            statement.setDate(3, reactivoEntrega.getFechaEntrega());
            statement.setTime(4, reactivoEntrega.getHoraEntrega());
            statement.setString(5, reactivoEntrega.getObservaciones());
            statement.setInt(6, reactivoEntrega.getEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoEntrega - Insertar " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException ex) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Boolean actualizarEntrega(final ReactivoEntrega reactivoEntrega) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_ENTREGA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR_ENTREGA);
            statement.setString(1, reactivoEntrega.getProveedor());
            statement.setDate(2, reactivoEntrega.getFechaEntrega());
            statement.setTime(3, reactivoEntrega.getHoraEntrega());
            statement.setString(4, reactivoEntrega.getObservaciones());
            statement.setInt(5, reactivoEntrega.getCodigoEntrega());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoEntrega - Actualizar Entrega " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                statement.close();
            }
                
                if (connection != null && !connection.isClosed()) {
                connection.close();
            }
                } catch (final SQLException ex) {
                    Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    public List<ReactivoEntregaPersonalizado> obtenerEntregas() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ENTREGAS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_LOTES));
            
            final List<ReactivoEntregaPersonalizado> reactivosEntregasPersonalizados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_ENTREGAS);

            resultSet = statement.executeQuery();

            reactivosEntregasPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoEntrega = resultSet.getInt(1);
                final String proveedor = resultSet.getString(3);
                final Date fechaEntega = resultSet.getDate(4);
                final Time horaEntega = resultSet.getTime(5);
                final String observaciones = resultSet.getString(6);
                final int estado = resultSet.getInt(7);

                final int codigoPersonalTecnico = resultSet.getInt(8);
                final String personalTecnicoProfesion = resultSet.getString(10);
                final Date fechaInicio = resultSet.getDate(11);
                final Time horaInicio = resultSet.getTime(12);
                final boolean personalTecnicoHabilitado = resultSet.getBoolean(15);

                final int codigoPersona = resultSet.getInt(16);
                final String personaCedulaIdentidad = resultSet.getString(17);
                final String personaApellido = resultSet.getString(18);
                final String personaNombre = resultSet.getString(19);
                final String personaSexo = resultSet.getString(20);

                final Persona persona = new Persona(codigoPersona, personaCedulaIdentidad, personaApellido, personaNombre, personaSexo);
                final PersonalTecnico personalTecnico = new PersonalTecnico(codigoPersonalTecnico, persona, personalTecnicoProfesion, fechaInicio, horaInicio, personalTecnicoHabilitado);
                final ReactivoEntrega reactivoEntrega = new ReactivoEntrega(codigoEntrega, personalTecnico, proveedor, fechaEntega, horaEntega, observaciones, estado);

                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_LOTES);
                statement.setInt(1, reactivoEntrega.getCodigoEntrega());
                resultSetAux = statement.executeQuery();
                resultSetAux.next();
                final int totalLotes = resultSetAux.getInt(1);

                reactivosEntregasPersonalizados.add(new ReactivoEntregaPersonalizado(reactivoEntrega, totalLotes));
            }
            return reactivosEntregasPersonalizados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLReactivoEntrega - Obtener Entregas: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (resultSetAux != null && !resultSetAux.isClosed()) {
                    resultSetAux.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public List<ReactivoLote> obtenerLotes(final ReactivoEntrega reactivoEntrega) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_LOTES));
            
            final List<ReactivoLote> reactivosLotes;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_LOTES);
            statement.setInt(1, reactivoEntrega.getCodigoEntrega());

            resultSet = statement.executeQuery();

            reactivosLotes = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoReactivoLote = resultSet.getInt(1);
                final String numeroLote = resultSet.getString(4);
                final String presentacion = resultSet.getString(5);
                final String almacenamiento = resultSet.getString(6);
                final String ubicacion = resultSet.getString(7);
                final int totalUnidades = resultSet.getInt(8);
                final String marca = resultSet.getString(9);

                final Date fechaVencimiento = resultSet.getDate(10);
                final String obsevaciones = resultSet.getString(11);
                final String estadoConsumo = resultSet.getString(12);
                final int estado = resultSet.getInt(13);
                
                final int codigoReactivo = resultSet.getInt(14);
                final String reactivoNombre = resultSet.getString(15);
                final int reactivoEstado = resultSet.getInt(16);
                
                final Reactivo reactivo = new Reactivo(codigoReactivo, reactivoNombre, reactivoEstado);
                final ReactivoLote reactivoLote = new ReactivoLote(codigoReactivoLote, reactivoEntrega, reactivo, numeroLote, presentacion, almacenamiento, ubicacion, totalUnidades, marca, fechaVencimiento, obsevaciones, estadoConsumo, estado);

                reactivosLotes.add(reactivoLote);
            }
            return reactivosLotes;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLReactivoEntrega - Obtener Lotes: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (resultSetAux != null && !resultSetAux.isClosed()) {
                    resultSetAux.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public List<LoteEliminado> obtenerLotesEliminados(final ReactivoEntrega reactivoEntrega) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_LOTES_ELIMINADOS));
            
            final List<LoteEliminado> lotesEliminados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_LOTES_ELIMINADOS);
            statement.setInt(1, reactivoEntrega.getCodigoEntrega());

            resultSet = statement.executeQuery();

            lotesEliminados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoLoteEliminado = resultSet.getInt(1);
                final String causaEliminacion = resultSet.getString(3);
                final Date fechaEliminacion = resultSet.getDate(4);
                final Time horaEliminacion = resultSet.getTime(5);

                final int codigoLote = resultSet.getInt(6);
                final String numeroLote = resultSet.getString(9);
                final String presentacion = resultSet.getString(10);
                final String almacenamiento = resultSet.getString(11);
                final String ubicacion = resultSet.getString(12);
                final int totalUnidades = resultSet.getInt(13);
                final String marcarReactivo = resultSet.getString(14);
                final Date fechaVencimiento = resultSet.getDate(15);
                final String observacionesLote = resultSet.getString(16);
                final String estadoConsumo = resultSet.getString(17);
                final int estado = resultSet.getInt(18);
                
                final int codigoReactivo = resultSet.getInt(26);
                final String reactivoNombre = resultSet.getString(27);
                final int reactivoEstado = resultSet.getInt(28);
                
                final Reactivo reactivo = new Reactivo(codigoReactivo, reactivoNombre, reactivoEstado);
                final ReactivoLote reactivoLote = new ReactivoLote(codigoLote, reactivoEntrega, reactivo, numeroLote, presentacion, almacenamiento, ubicacion, totalUnidades, marcarReactivo, fechaVencimiento, observacionesLote, estadoConsumo, estado);
                lotesEliminados.add(new LoteEliminado(codigoLoteEliminado, reactivoLote, causaEliminacion, fechaEliminacion, horaEliminacion));
            }
            return lotesEliminados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLReactivoEntrega - Obtener Lotes Eliminados: " + sqlException.getMessage());
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

    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoEntrega - InsertarEnLog: " + sqlException.getMessage());
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
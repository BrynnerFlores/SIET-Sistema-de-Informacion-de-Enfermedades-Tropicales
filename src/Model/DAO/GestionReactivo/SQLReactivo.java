package Model.DAO.GestionReactivo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.Reactivo;
import Model.POJO.ReactivoEntrega;
import Model.POJO.ReactivoLote;
import Model.POJOPersonalizado.ReactivoLotePersonalizado;
import Model.POJOPersonalizado.ReactivoPersonalizado;
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
public class SQLReactivo {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_REACTIVO = "INSERT INTO areacti(parccodrea, carcnombre, carcestado) VALUES(nextval('parccodrea_sequence'), ?, ?)";
    private final String SQL_OBTENER_REACTIVOS = "SELECT * FROM areacti WHERE carcestado = 1 ORDER BY parccodrea DESC";
    private final String SQL_OBTENER_LOTES = "SELECT * FROM arealot INNER JOIN areaent ON areaent.parecoreen = arealot.farlcoreen WHERE farlcodrea = ? AND farlcodrea IN (SELECT parccodrea FROM areacti WHERE carcestado = 1) AND carlestado = 1";
    private final String SQL_OBTENER_SALDO_LOTES = "SELECT COUNT(*) FROM arealot INNER JOIN areaent ON areaent.parecoreen = arealot.farlcoreen INNER JOIN areacti ON areacti.parccodrea = arealot.farlcodrea WHERE areacti.parccodrea = ? AND arealot.carlfecven > current_date AND arealot.carlestcon != 'AGOTADO' AND arealot.carlestado = 1 AND areaent.careestado = 1 AND areacti.carcestado = 1";
    private final String SQL_OBTENER_SALDO_UNIDADES = "SELECT CASE WHEN EXISTS (SELECT 1 FROM aunieli WHERE fauecorelo IN (SELECT parlcorelo FROM arealot WHERE parlcorelo = ? AND carlestado = 1)) THEN (SELECT (SELECT carltotuni FROM arealot WHERE parlcorelo = ? AND carlestado = 1) - (SELECT COUNT(*) FROM aunieli WHERE fauecorelo IN (SELECT parlcorelo FROM arealot WHERE parlcorelo = ? AND carlestado = 1))) ELSE (SELECT carltotuni FROM arealot WHERE parlcorelo = ? AND carlestado = 1) END";
    private final String SQL_ACTUALIZAR = "UPDATE areacti SET carcnombre = ? WHERE parccodrea = ? AND carcestado = 1";
    private final String SQL_ELIMINAR = "UPDATE areacti SET carcestado = 0 WHERE parccodrea = ?";
    private final String SQL_ESTABLECER_LOTE_VENCIDO = "UPDATE arealot SET carlestcon = 'VENCIDO' WHERE carlfecven <= (SELECT CURRENT_DATE) AND carlestado = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM areacti WHERE parccodrea != ? AND carcnombre = ? AND carcestado = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLReactivo() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Reactivo reactivo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_REACTIVO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_REACTIVO);
            statement.setString(1, reactivo.getNombre());
            statement.setInt(2, reactivo.getEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivo - Insertar " + sqlException.getMessage());
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
    
    public List<ReactivoPersonalizado> obtenerReactivos() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_REACTIVOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SALDO_LOTES));
            
            final List<ReactivoPersonalizado> reactivosPersonalizados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_REACTIVOS);

            resultSet = statement.executeQuery();

            reactivosPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoReactivo = resultSet.getInt(1);
                final String nombre = resultSet.getString(2);
                final int estado = resultSet.getInt(3);

                final Reactivo reactivo = new Reactivo(codigoReactivo, nombre, estado);

                statement = connection.prepareStatement(SQL_OBTENER_SALDO_LOTES);
                statement.setInt(1, reactivo.getCodigoReactivo());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int saldo = resultSetAux.getInt(1);

                reactivosPersonalizados.add(new ReactivoPersonalizado(reactivo, saldo));
            }
            return reactivosPersonalizados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLReactivo - Obtener Reactivos: " + sqlException.getMessage());
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
    
    public List<ReactivoLotePersonalizado> obtenerLotes(final Reactivo reactivo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ESTABLECER_LOTE_VENCIDO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_LOTES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SALDO_UNIDADES));
            
            final List<ReactivoLotePersonalizado> reactivosLotesPersonalizados;
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.prepareStatement(SQL_ESTABLECER_LOTE_VENCIDO);
            statement.executeUpdate();

            statement = connection.prepareStatement(SQL_OBTENER_LOTES);
            statement.setInt(1, reactivo.getCodigoReactivo());

            resultSet = statement.executeQuery();

            reactivosLotesPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoReactivoLote = resultSet.getInt(1);
                final String numeroLote = resultSet.getString(4);
                final String presentacion = resultSet.getString(5);
                final String almacenamiento = resultSet.getString(6);
                final String ubicacion = resultSet.getString(7);
                final int totalUnidades = resultSet.getInt(8);
                final String marcaReactivo = resultSet.getString(9);
                final Date fechaVencimiento = resultSet.getDate(10);
                final String observacionesLote = resultSet.getString(11);
                final String estadoConsumo = resultSet.getString(12);
                final int estadoLote = resultSet.getInt(13);

                final int codigoEntrega = resultSet.getInt(14);
                final String proveedor = resultSet.getString(16);
                final Date fechaEntrega = resultSet.getDate(17);
                final Time horaEntrega = resultSet.getTime(18);
                final String observacionesEntrega = resultSet.getString(19);
                final int estadoEntrega = resultSet.getInt(20);

                final ReactivoEntrega reactivoEntrega = new ReactivoEntrega(codigoEntrega, null, proveedor, fechaEntrega, horaEntrega, observacionesEntrega, estadoEntrega);
                final ReactivoLote reactivoLote = new ReactivoLote(codigoReactivoLote, reactivoEntrega, reactivo, numeroLote, presentacion, almacenamiento, ubicacion, totalUnidades, marcaReactivo, fechaVencimiento, observacionesLote, estadoConsumo, estadoLote);

                statement = connection.prepareStatement(SQL_OBTENER_SALDO_UNIDADES);
                statement.setInt(1, reactivoLote.getCodigoLote());
                statement.setInt(2, reactivoLote.getCodigoLote());
                statement.setInt(3, reactivoLote.getCodigoLote());
                statement.setInt(4, reactivoLote.getCodigoLote());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int saldo = resultSetAux.getInt(1);

                reactivosLotesPersonalizados.add(new ReactivoLotePersonalizado(reactivoLote, saldo));
            }
            return reactivosLotesPersonalizados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLReactivo - Obtener Lotes: " + sqlException.getMessage());
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

    public Boolean actualizar(final Reactivo reactivo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, reactivo.getNombre());
            statement.setInt(2, reactivo.getCodigoReactivo());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivo - Actualizar: " + sqlException.getMessage());
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
    
    public Boolean eliminar(final Reactivo reactivo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, reactivo.getCodigoReactivo());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivo - Eliminar " + sqlException.getMessage());
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

    public int verificarExistencia(final Reactivo reactivo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, reactivo.getCodigoReactivo());
            statement.setString(2, reactivo.getNombre());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivo - Verificar Existencia: " + sqlException.getMessage());
            return -1;
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
            System.err.println("Error en SQLReactivo - InsertarEnLog: " + sqlException.getMessage());
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
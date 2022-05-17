package Model.DAO.GestionReactivo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.ReactivoLote;
import Model.POJO.UnidadEliminada;
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
public class SQLReactivoLote {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_LOTE = "INSERT INTO arealot(parlcorelo, farlcoreen, farlcodrea, carlnumlot, carlpresen, carlalmace, carlubicac, carltotuni, carlmarrea, carlfecven, carlobserv, carlestcon, carlestado) VALUES(nextval('parlcorelo_sequence'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_INICIAR_CONSUMO = "UPDATE arealot SET carlestcon = 'EN CONSUMO' WHERE parlcorelo = ? AND carlestado = 1";
    private final String SQL_OBTENER_UNIDADES_ELIMINADAS = "SELECT * FROM aunieli WHERE fauecorelo = ? AND fauecorelo IN (SELECT parlcorelo FROM arealot) ORDER BY pauecounel DESC";
    private final String SQL_DETENER_CONSUMO = "UPDATE arealot SET carlestcon = 'EN ALMACEN' WHERE parlcorelo = ? AND carlestado = 1";
    private final String SQL_VERIFICAR_EXISTENCIA_LOTE = "SELECT EXISTS (SELECT 1 FROM arealot WHERE carlnumlot = ? AND carlestado = 1)";
    private final String SQL_VERIFICAR_LOTE_CONSUMO_INICIADO = "SELECT CASE WHEN EXISTS (SELECT 1 FROM arealot WHERE parlcorelo = ? AND carlestcon = 'EN CONSUMO') THEN 1 ELSE 0 END";
    private final String SQL_VERIFICAR_LOTES_CONSUMO_INICIADO = "SELECT CASE WHEN EXISTS (SELECT 1 FROM arealot WHERE parlcorelo != ? AND carlestcon = 'EN CONSUMO') THEN 1 ELSE 0 END";
    private final String SQL_VERIFICAR_LOTE_AGOTADO = "SELECT CASE WHEN (SELECT carlestcon FROM arealot WHERE parlcorelo = ? AND carlestado = 1) = 'AGOTADO' THEN 1 ELSE 0 END";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLReactivoLote() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_LOTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_LOTE);
            statement.setInt(1, reactivoLote.getReactivoEntrega().getCodigoEntrega());
            statement.setInt(2, reactivoLote.getReactivo().getCodigoReactivo());
            statement.setString(3, reactivoLote.getNumeroLote());
            statement.setString(4, reactivoLote.getPresentacion());
            statement.setString(5, reactivoLote.getAlmacenamiento());
            statement.setString(6, reactivoLote.getUbicacion());
            statement.setInt(7, reactivoLote.getTotalUnidades());
            statement.setString(8, reactivoLote.getMarcaReactivo());
            statement.setDate(9, reactivoLote.getFechaVencimiento());
            statement.setString(10, reactivoLote.getObservaciones());
            statement.setString(11, reactivoLote.getEstadoConsumo());
            statement.setInt(12, reactivoLote.getEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Insertar " + sqlException.getMessage());
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

    public Boolean iniciarConsumo(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INICIAR_CONSUMO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INICIAR_CONSUMO);
            statement.setInt(1, reactivoLote.getCodigoLote());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Iniciar Consumo " + sqlException.getMessage());
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

    public Boolean detenerConsumo(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_DETENER_CONSUMO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_DETENER_CONSUMO);
            statement.setInt(1, reactivoLote.getCodigoLote());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Detener Consumo " + sqlException.getMessage());
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

    public List<UnidadEliminada> obtenerUnidadesEliminadas(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_UNIDADES_ELIMINADAS));
            
            final List<UnidadEliminada> unidadesEliminadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_UNIDADES_ELIMINADAS);
            statement.setInt(1, reactivoLote.getCodigoLote());

            resultSet = statement.executeQuery();

            unidadesEliminadas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoUnidadEliminada = resultSet.getInt(1);
                final String causaEliminacion = resultSet.getString(3);
                final Date fechaEliminacion = resultSet.getDate(4);
                final Time horaEliminacion = resultSet.getTime(5);

                unidadesEliminadas.add(new UnidadEliminada(codigoUnidadEliminada, reactivoLote, causaEliminacion, fechaEliminacion, horaEliminacion));
            }
            return unidadesEliminadas;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLReactivoLote - Obtener Unidades Eliminadas: " + sqlException.getMessage());
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

    public int verificarExistenciaLote(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA_LOTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA_LOTE);
            statement.setString(1, reactivoLote.getNumeroLote());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Verificar Existencia Lote: " + sqlException.getMessage());
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

    public int verificarLoteConsumoIniciado(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_LOTE_CONSUMO_INICIADO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_LOTE_CONSUMO_INICIADO);
            statement.setInt(1, reactivoLote.getCodigoLote());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Verificar Lote Consumo Iniciado: " + sqlException.getMessage());
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

    public int verificarLotesConsumoIniciado(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_LOTES_CONSUMO_INICIADO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_LOTES_CONSUMO_INICIADO);
            statement.setInt(1, reactivoLote.getCodigoLote());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Verificar Lotes Consumo Iniciado: " + sqlException.getMessage());
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

    public int verificarLoteAgotado(final ReactivoLote reactivoLote) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_LOTE_AGOTADO));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_LOTE_AGOTADO);
            statement.setInt(1, reactivoLote.getCodigoLote());

            resultSet = statement.executeQuery();

            resultSet.next();
            final int loteAgotado = resultSet.getInt(1);

            switch (loteAgotado) {
                case 0:
                    return 0;

                case 1:
                    return 1;

                default:
                    return -1;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLReactivoLote - Verificar Lote Agotado: " + sqlException.getMessage());
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
            System.err.println("Error en SQLReactivoLote - InsertarEnLog: " + sqlException.getMessage());
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
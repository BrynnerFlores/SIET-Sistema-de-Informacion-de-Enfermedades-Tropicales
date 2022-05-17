package Model.DAO.GestionReactivo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.UnidadEliminada;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLUnidadEliminada {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_UNIDAD_ELIMINADA = "INSERT INTO aunieli(pauecounel, fauecorelo, cauecaueli, cauefeceli, cauehoreli) VALUES(nextval('pauecounel_sequence'), ?, ?, ?, ?)";
    private final String SQL_VERIFICAR_SALDO_UNIDADES = "SELECT CASE WHEN (SELECT carltotuni FROM arealot WHERE parlcorelo = ? AND carlestado = 1) > (SELECT COUNT(*) FROM aunieli WHERE fauecorelo IN (SELECT parlcorelo FROM arealot WHERE parlcorelo = ? AND carlestado = 1)) THEN 1 ELSE 0 END";
    private final String SQL_ESTABLECER_LOTE_AGOTADO = "UPDATE arealot SET carlestcon = 'AGOTADO' WHERE parlcorelo = ? AND carlestado = 1";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLUnidadEliminada() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public int verificarSaldoUnidades(final UnidadEliminada unidadEliminada) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SALDO_UNIDADES));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_SALDO_UNIDADES);
            statement.setInt(1, unidadEliminada.getReactivoLote().getCodigoLote());
            statement.setInt(2, unidadEliminada.getReactivoLote().getCodigoLote());

            resultSet = statement.executeQuery();

            resultSet.next();

            switch (resultSet.getInt(1)) {
                case 0:
                    return 0;

                case 1:
                    return 1;

                default:
                    return -1;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLUnidadEliminada - Verificar Saldo Unidades" + sqlException.getMessage());
            return -1;
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

    public Boolean eliminarUnidad(final UnidadEliminada unidadEliminada, final int unidadesAEliminar) {
        try {
            boolean isUnidadesEliminadas = true;
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_UNIDAD_ELIMINADA));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SALDO_UNIDADES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ESTABLECER_LOTE_AGOTADO));
            
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INSERTAR_UNIDAD_ELIMINADA);
            statement.setInt(1, unidadEliminada.getReactivoLote().getCodigoLote());
            statement.setString(2, unidadEliminada.getCausaEliminacion());
            statement.setDate(3, unidadEliminada.getFechaEliminacion());
            statement.setTime(4, unidadEliminada.getHoraEliminacion());
            
            for (int i = 0; i < unidadesAEliminar; i++) {
                if (statement.executeUpdate() != 1) {
                    isUnidadesEliminadas = false;
                    break;
                }
            }
            
            if (isUnidadesEliminadas) {
                statement = connection.prepareStatement(SQL_VERIFICAR_SALDO_UNIDADES);
                statement.setInt(1, unidadEliminada.getReactivoLote().getCodigoLote());
                statement.setInt(2, unidadEliminada.getReactivoLote().getCodigoLote());

                resultSet = statement.executeQuery();

                resultSet.next();
                
                switch (resultSet.getInt(1)) {
                    case 0:
                        statement = connection.prepareStatement(SQL_ESTABLECER_LOTE_AGOTADO);
                        statement.setInt(1, unidadEliminada.getReactivoLote().getCodigoLote());

                        if (statement.executeUpdate() == 1) {
                            connection.commit();
                            return true;
                        } else {
                            connection.rollback();
                            return false;
                        }
                    case 1:
                        connection.commit();
                        return true;

                    default:
                        connection.rollback();
                        return false;
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLUnidadEliminada - Eliminar Lote " + sqlException.getMessage());
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

    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLUnidadEliminada - InsertarEnLog: " + sqlException.getMessage());
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
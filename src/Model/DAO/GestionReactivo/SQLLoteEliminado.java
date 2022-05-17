package Model.DAO.GestionReactivo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.LoteEliminado;
import Model.POJO.PersonalTecnico;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLLoteEliminado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_LOTE_ELIMINADO = "INSERT INTO aloteli(palecoloel, falecorelo, calecaueli, calefeceli, calehoreli) VALUES(nextval('palecoloel_sequence'), ?, ?, ?, ?)";
    private final String SQL_ELIMINAR_LOTE = "UPDATE arealot SET carlestado = 0 WHERE parlcorelo = ? AND carlestado = 1";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLLoteEliminado() {
        connection = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean eliminarLote(final LoteEliminado loteEliminado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_LOTE_ELIMINADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_LOTE));
            
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INSERTAR_LOTE_ELIMINADO);
            statement.setInt(1, loteEliminado.getReactivoLote().getCodigoLote());
            statement.setString(2, loteEliminado.getCausaEliminacion());
            statement.setDate(3, loteEliminado.getFechaEliminacion());
            statement.setTime(4, loteEliminado.getHoraEliminacion());
            
            if (statement.executeUpdate() == 1) {
                statement = connection.prepareStatement(SQL_ELIMINAR_LOTE);
                statement.setInt(1, loteEliminado.getReactivoLote().getCodigoLote());
                
                if (statement.executeUpdate() == 1) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLLoteEliminado - Eliminar Lote " + sqlException.getMessage());
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
            System.err.println("Error en SQLLoteEliminado - InsertarEnLog: " + sqlException.getMessage());
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
package Model.DAO.GestionPersonalTecnico;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.Persona;
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
public class SQLPersonalTecnico {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_OBTENER_PERSONAL_TECNICO = "SELECT paptcopete, captperpro, captpefein, to_char(captpehoin, 'HH24:MI:SS'), captperhab, papscodper, capspeceid, capsperape, capspernom, capspersex FROM apertec INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper WHERE captperhab = TRUE";
    private final String SQL_HABILITAR = "UPDATE apertec SET captpefein = (SELECT CURRENT_DATE), captpehoin = (SELECT CURRENT_TIME), captperhab = TRUE WHERE paptcopete = ? AND captperhab = FALSE";
    private final PersonalTecnico PERSONAL_TECNICO;
    
    private PreparedStatement statement;
    private Connection connection;
    private ResultSet resultSet;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLPersonalTecnico() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public List<PersonalTecnico> obtenerPersonalTecnico() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PERSONAL_TECNICO));
            
            final List<PersonalTecnico> personalesTecnicos;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_PERSONAL_TECNICO);

            resultSet = statement.executeQuery();
            
            personalesTecnicos = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoPersonalTecnico = resultSet.getInt(1);
                final String personalTecnicoProfesion = resultSet.getString(2);
                final Date personalTecnicoFechaInicio = resultSet.getDate(3);
                final Time personalTecnicoHoraInicio = resultSet.getTime(4);
                final boolean personalTecnicosHabilitado = resultSet.getBoolean(5);
                
                final int codigoPersona = resultSet.getInt(6);
                final String personaCedulaIdentidad = resultSet.getString(7);
                final String personaApellido = resultSet.getString(8);
                final String personaNombre = resultSet.getString(9);
                final String personaSexo = resultSet.getString(10);
                
                final Persona persona = new Persona(codigoPersona, personaCedulaIdentidad, personaApellido, personaNombre, personaSexo);
                personalesTecnicos.add(new PersonalTecnico(codigoPersonalTecnico, persona, personalTecnicoProfesion, personalTecnicoFechaInicio, personalTecnicoHoraInicio, personalTecnicosHabilitado));
            }
            return personalesTecnicos;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLPersonalTecnico - Obtener Personal Tecnico: " + sqlException.getMessage());
            return null;
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
    
    public Boolean habilitar(final PersonalTecnico personalTecnico) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_HABILITAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_HABILITAR);
            statement.setInt(1, personalTecnico.getCodigoPersonalTecnico());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLPersonal Tecnico - Habilitar: " + sqlException.getMessage());
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
    
    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLPersonalTecnico - InsertarEnLog: " + sqlException.getMessage());
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
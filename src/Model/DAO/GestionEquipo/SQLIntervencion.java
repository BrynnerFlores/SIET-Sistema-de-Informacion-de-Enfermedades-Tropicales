package Model.DAO.GestionEquipo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.PersonalTecnico;
import Model.POJO.Equipo;
import Model.POJO.Intervencion;
import Model.POJO.LogConsulta;
import Model.POJO.Persona;
import Model.POJO.Subespecialidad;
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
public class SQLIntervencion {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO ainterv(paiecodint, faiecodequ, caieinfein, caieinhoin, caieintcau, caieintrre, caieindeac, caieintobs, caieintest) VALUES(nextval('paiecodint_sequence'), ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_OBTENER = "SELECT paiecodint, faiecodequ, caieinfein, caieinhoin, caieintcau, caieintrre, caieindeac, caieintobs, caieintest, paeicodequ, faeicopete, faeicodsub, caeiequnom, caeiequmar, caeiequmod, caeieqnuse, caeieqfead, caeiequpro, caeieqreen, caeiequint, caeiequgar, caeiequubi, caeiequobs, caeiequfot, caeiequest, paptcopete, faptcodper, captperpro, captpefein, captpehoin, captperhab, papscodper, capspeceid, capsperape, capspernom, capspersex, pasecodsub, casesubnom, casesubest FROM ainterv INNER JOIN aequipo ON ainterv.faiecodequ = aequipo.paeicodequ INNER JOIN apertec ON aequipo.faeicopete = apertec.paptcopete INNER JOIN aperson ON aperson.papscodper = apertec.faptcodper INNER JOIN asubesp ON asubesp.pasecodsub = aequipo.faeicodsub WHERE ainterv.caieintest = 1";
    private final String SQL_ACTUALIZAR = "UPDATE ainterv SET caieinfein = ?, caieinhoin = ?, caieintcau = ?, caieintrre = ?, caieindeac = ?, caieintobs = ? WHERE paiecodint = ? AND caieintest = 1";
    private final String SQL_FINALIZAR = "UPDATE ainterv SET caieinfefi = ?, caieinhofi = ?, caieintest = 0 WHERE paiecodint = ? AND caieintest = 1";
    private final PersonalTecnico PERSONAL_TECNICO;
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLIntervencion() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Intervencion intervencion) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            final Equipo equipo = intervencion.getEquipo();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, equipo.getCodigoEquipo());
            statement.setDate(2, intervencion.getIntervencionFechaInicio());
            statement.setTime(3, intervencion.getIntervencionHoraInicio());
            statement.setString(4, intervencion.getIntervencionCausa());
            statement.setString(5, intervencion.getIntervencionTrabajoRealizado());
            statement.setString(6, intervencion.getIntervencionDescripcionActividad());
            statement.setString(7, intervencion.getIntervencionObservaciones());
            statement.setInt(8, intervencion.getIntervencionEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLIntervencion - Insertar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLIntervencion - Insertar: " + exception.getMessage());
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

    public List<Intervencion> obtenerTodos() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER));
            
            final List<Intervencion> intervenciones;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER);
            resultSet = statement.executeQuery();

            intervenciones = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_intervencion = resultSet.getInt(1);
                final Date intervencion_fecha_inicio = resultSet.getDate(3);
                final Time intervencion_hora_inicio = resultSet.getTime(4);
                final String intervencion_causa = resultSet.getString(5);
                final String intervencion_tabajo_realizado = resultSet.getString(6);
                final String intervencion_descripcion_actividad = resultSet.getString(7);
                final String intervencion_observaciones = resultSet.getString(8);
                final int intervervencion_estado = resultSet.getInt(9);

                final int codigo_equipo = resultSet.getInt(10);
                final String equipo_nombre = resultSet.getString(13);
                final String equipo_marca = resultSet.getString(14);
                final String equipo_modelo = resultSet.getString(15);
                final String equipo_numero_serie = resultSet.getString(16);
                final Date equipo_fecha_adquisicion = resultSet.getDate(17);
                final String equipo_proveedor = resultSet.getString(18);
                final String equipo_responsable_entrega = resultSet.getString(19);
                final String equipo_integridad = resultSet.getString(20);
                final int equipo_garantia = resultSet.getInt(21);
                final String equipo_ubicacion = resultSet.getString(22);
                final String equipo_observaciones = resultSet.getString(23);
                final byte[] equipo_foto = resultSet.getBytes(24);
                final int equipo_estado = resultSet.getInt(25);

                final int codigo_personal_tecnico = resultSet.getInt(26);
                final String personal_tecnico_profesion = resultSet.getString(28);
                final Date personal_tecnico_fecha_inicio = resultSet.getDate(29);
                final Time personal_tecnico_hora_inicio = resultSet.getTime(30);
                final Boolean personal_tecnico_habilitado = resultSet.getBoolean(31);

                final int pcodigo_persona = resultSet.getInt(32);
                final String cedula_identidad = resultSet.getString(33);
                final String persona_apellido = resultSet.getString(34);
                final String persona_nombre = resultSet.getString(35);
                final String personas_sexo = resultSet.getString(36);

                final int codigo_subespecialidad = resultSet.getInt(37);
                final String subespecialidad_nombre = resultSet.getString(38);
                final int subespecialidad_estado = resultSet.getInt(39);

                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                final Subespecialidad subespecialidad = new Subespecialidad(codigo_subespecialidad, null, subespecialidad_nombre, subespecialidad_estado);
                final PersonalTecnico personalTecnico = new PersonalTecnico(codigo_personal_tecnico, persona, personal_tecnico_profesion, personal_tecnico_fecha_inicio, personal_tecnico_hora_inicio, personal_tecnico_habilitado);
                final Equipo equipo = new Equipo(codigo_equipo, personalTecnico, subespecialidad, equipo_nombre, equipo_marca, equipo_modelo, equipo_numero_serie, equipo_fecha_adquisicion, equipo_proveedor, equipo_responsable_entrega, equipo_integridad, equipo_garantia, equipo_ubicacion, equipo_observaciones, equipo_foto, equipo_estado);
                intervenciones.add(new Intervencion(codigo_intervencion, equipo, intervencion_fecha_inicio, intervencion_hora_inicio, null, null, intervencion_causa, intervencion_tabajo_realizado, intervencion_descripcion_actividad, intervencion_observaciones, intervervencion_estado));
            }
            return intervenciones;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLIntervencion - ObtenerTodos: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null) {
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

    public Boolean actualizar(final Intervencion intervencion) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setDate(1, intervencion.getIntervencionFechaInicio());
            statement.setTime(2, intervencion.getIntervencionHoraInicio());
            statement.setString(3, intervencion.getIntervencionCausa());
            statement.setString(4, intervencion.getIntervencionTrabajoRealizado());
            statement.setString(5, intervencion.getIntervencionDescripcionActividad());
            statement.setString(6, intervencion.getIntervencionObservaciones());
            statement.setInt(7, intervencion.getCodigoIntervencion());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLIntervencion - Actualizar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLIntervencion - Actualizar: " + exception.getMessage());
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

    public Boolean finalizar(final Intervencion intervencion) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_FINALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_FINALIZAR);
            statement.setDate(1, intervencion.getIntervencionFechaFinal());
            statement.setTime(2, intervencion.getIntervencionHoraFinal());
            statement.setInt(3, intervencion.getCodigoIntervencion());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLIntervencion - Finalizar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLIntervencion - Finalizar: " + exception.getMessage());
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
            System.err.println("Error en SQLIntervencion - InsertarEnLog: " + sqlException.getMessage());
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
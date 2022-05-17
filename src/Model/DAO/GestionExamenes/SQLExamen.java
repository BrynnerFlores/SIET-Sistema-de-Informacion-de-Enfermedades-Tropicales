package Model.DAO.GestionExamenes;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Especialidad;
import Model.POJO.Examen;
import Model.POJO.ExamenPosibleResultado;
import Model.POJO.GrupoVariables;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.Subespecialidad;
import Model.POJO.Tecnica;
import Model.POJOPersonalizado.ExamenPersonalizado;
import Model.POJOPersonalizado.GrupoVariablesPersonalizado;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLExamen {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();
    
    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO aexamen(paemcodexa, faemcodsub, caemexanom, caemexaest) VALUES(nextval('paemcodexa_sequence'), ?, ?, ?)";
    private final String SQL_OBTENER_TODOS = "SELECT * FROM aexamen INNER JOIN asubesp ON asubesp.pasecodsub = aexamen.faemcodsub INNER JOIN aespeci ON aespeci.paeecodesp = asubesp.fasecodesp WHERE caemexaest = 1 AND casesubest = 1 ORDER BY paemcodexa";
    private final String SQL_OBTENER_TOTAL_POSIBLES_RESULTADOS = "SELECT COUNT(*) FROM aexpore WHERE faeocodexa = ? AND caeoporees = 1";
    private final String SQL_OBTENER_TOTAL_GRUPO_VARIABLES = "SELECT COUNT(*) FROM agruvar WHERE fagvcodexa = ? AND cagvgrvaes = 1";
    private final String SQL_OBTENER_TOTAL_TECNICAS = "SELECT COUNT(*) FROM atecnic WHERE fatncodexa = ? AND catntecest = 1";
    private final String SQL_OBTENER_GRUPO_VARIABLES = "SELECT * FROM agruvar INNER JOIN aexamen ON aexamen.paemcodexa = agruvar.fagvcodexa INNER JOIN asubesp ON asubesp.pasecodsub = aexamen.faemcodsub WHERE aexamen.paemcodexa = ? AND cagvgrvaes = 1 AND caemexaest = 1 AND casesubest = 1 ORDER BY pagvcogrva";
    private final String SQL_OBTENER_TOTAL_VARIABLES = "SELECT COUNT(*) FROM avarexa WHERE favecogrva = ? AND favecogrva IN (SELECT pagvcogrva FROM agruvar WHERE cagvgrvaes = 1) AND cavevarest = 1";
    private final String SQL_OBTENER_POSIBLES_RESULTADOS = "SELECT * FROM aexpore WHERE faeocodexa = ? AND caeoporees = 1 ORDER BY paeocopore ASC";
    private final String SQL_OBTENER_TECNICAS_AGREGADAS = "SELECT * FROM atecnic WHERE fatncodexa = ? AND catntecest = 1 ORDER BY patncodtec ASC";
    private final String SQL_ACTUALIZAR = "UPDATE aexamen SET faemcodsub = ?, caemexanom = ? WHERE paemcodexa = ? AND caemexaest = 1";
    private final String SQL_ELIMINAR_EXAMEN = "UPDATE aexamen SET caemexaest = 0 WHERE paemcodexa = ? AND caemexaest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aexamen WHERE paemcodexa != ? AND caemexanom = ? AND caemexaest = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLExamen() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            final Subespecialidad subespecialidad = examen.getSubespecialidad();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, subespecialidad.getCodigoSubespecialidad());
            statement.setString(2, examen.getExamenNombre());
            statement.setInt(3, examen.getExamenEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLExamen - Insertar: " + sqlException.getMessage());
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

    public List<ExamenPersonalizado> obtenerExamenes() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TODOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_GRUPO_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_POSIBLES_RESULTADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_TECNICAS));
            
            final List<ExamenPersonalizado> examenesPersonalizados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_TODOS);
            resultSet = statement.executeQuery();

            examenesPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_examen = resultSet.getInt(1);
                final String examen_nombre = resultSet.getString(3);
                final int examen_estado = resultSet.getInt(4);

                final int codigo_subespecialidad = resultSet.getInt(5);
                final String subespecialidad_nombre = resultSet.getString(7);
                final int subespecialidad_estado = resultSet.getInt(8);
                
                final int codigo_especialidad = resultSet.getInt(9);
                final String especialdiad_nombre = resultSet.getString(10);
                final int especialidad_estado = resultSet.getInt(11);
                
                final Especialidad especialidad = new Especialidad(codigo_especialidad, especialdiad_nombre, especialidad_estado);
                final Subespecialidad subespecialidad = new Subespecialidad(codigo_subespecialidad, especialidad, subespecialidad_nombre, subespecialidad_estado);
                final Examen examen = new Examen(codigo_examen, subespecialidad, examen_nombre, examen_estado);
                
                // OBTENIENDO EL TOTAL DE GRUPO DE VARIABLES
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_GRUPO_VARIABLES);
                statement.setInt(1, examen.getCodigoExamen());

                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int TOTAL_GRUPO_VARIABLES = resultSetAux.getInt(1);
                
                // OBTENIENDO EL TOTAL DE POSIBLES RESULTADOS
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_POSIBLES_RESULTADOS);
                statement.setInt(1, examen.getCodigoExamen());

                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int TOTAL_POSIBLES_RESULTADOS = resultSetAux.getInt(1);
                
                // OBTENIENDO EL TOTAL DE TECNICAS
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_TECNICAS);
                statement.setInt(1, examen.getCodigoExamen());

                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int TOTAL_TECNICAS = resultSetAux.getInt(1);
                
                examenesPersonalizados.add(new ExamenPersonalizado(examen, TOTAL_POSIBLES_RESULTADOS, TOTAL_TECNICAS, TOTAL_GRUPO_VARIABLES));
            }
            return examenesPersonalizados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLExamen - Obtener Todos " + sqlException.getMessage());
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

    public List<GrupoVariablesPersonalizado> obtenerGrupoVariables(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_GRUPO_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_VARIABLES));
            
            final List<GrupoVariablesPersonalizado> gruposVariablesPersonalizados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_GRUPO_VARIABLES);
            statement.setInt(1, examen.getCodigoExamen());
            resultSet = statement.executeQuery();

            gruposVariablesPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_grupo_variable = resultSet.getInt(1);
                final String grupo_variable_nombre = resultSet.getString(3);
                final int grupo_variable_estado = resultSet.getInt(4);
                
                final GrupoVariables grupoVariables = new GrupoVariables(codigo_grupo_variable, examen, grupo_variable_nombre, grupo_variable_estado);

                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_VARIABLES);
                statement.setInt(1, grupoVariables.getCodigoGrupoVariable());
                resultSetAux = statement.executeQuery();
                resultSetAux.next();
                final int totalExamenes = resultSetAux.getInt(1);

                gruposVariablesPersonalizados.add(new GrupoVariablesPersonalizado(grupoVariables, totalExamenes));
            }
            return gruposVariablesPersonalizados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLExamen - Obtener Grupo Variables: " + sqlException.getMessage());
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
    
    public List<ExamenPosibleResultado> obtenerPosiblesResultados(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_POSIBLES_RESULTADOS));
            
            final List<ExamenPosibleResultado> examenPosiblesResultados;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_POSIBLES_RESULTADOS);
            statement.setInt(1, examen.getCodigoExamen());
            resultSet = statement.executeQuery();

            examenPosiblesResultados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_posible_resultado = resultSet.getInt(1);
                final String posible_resultado_nombre = resultSet.getString(3);
                final int posible_resultado_estado = resultSet.getInt(4);
                
                examenPosiblesResultados.add(new ExamenPosibleResultado(codigo_posible_resultado, examen, posible_resultado_nombre, posible_resultado_estado));
            }
            return examenPosiblesResultados;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLExamen - Obtener Posible Resultado: " + sqlException.getMessage());
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
    
    public List<Tecnica> obtenerTecnicasAgregadas(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TECNICAS_AGREGADAS));
            
            final List<Tecnica> tecnicasAgregadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_TECNICAS_AGREGADAS);
            statement.setInt(1, examen.getCodigoExamen());
            resultSet = statement.executeQuery();

            tecnicasAgregadas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoTecnica = resultSet.getInt(1);
                final String tecnicaNombre = resultSet.getString(3);
                final String tecnicaMetodo = resultSet.getString(4);
                final int tecnicaEstado = resultSet.getInt(5);
                
                tecnicasAgregadas.add(new Tecnica(codigoTecnica, examen, tecnicaNombre, tecnicaMetodo, tecnicaEstado));
            }
            return tecnicasAgregadas;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLExamen - Obtener Tecnicas Agregadas: " + sqlException.getMessage());
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

    public Boolean actualizar(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setInt(1, examen.getSubespecialidad().getCodigoSubespecialidad());
            statement.setString(2, examen.getExamenNombre());
            statement.setInt(3, examen.getCodigoExamen());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLExamen - Actualizar: " + sqlException.getMessage());
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
    
    public Boolean eliminar(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_EXAMEN));
            
            connection = DriverManager.getConnection(url, user, password);
            
            statement = connection.prepareStatement(SQL_ELIMINAR_EXAMEN);
            statement.setInt(1, examen.getCodigoExamen());
            
            if (statement.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLExamen - Eliminar: " + sqlException.getMessage());
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
    
    public int verificarExistencia(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, examen.getCodigoExamen());
            statement.setString(2, examen.getExamenNombre());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLExamen - Verificar Existencia: " + sqlException.getMessage());
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
            System.err.println("Error en SQLExamen - InsertarEnLog: " + sqlException.getMessage());
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
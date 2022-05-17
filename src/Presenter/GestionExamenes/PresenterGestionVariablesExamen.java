package Presenter.GestionExamenes;

import Model.DAO.GestionExamenes.SQLVariableExamen;
import Model.POJO.Examen;
import Model.POJO.VariableExamen;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionVariablesExamen {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLVariableExamen sqlVariableExamen;
    
    private CallBackCrearVariableExamen callBackCrearVariableExamen;
    private CallBackObtenerVariablesExamenes callBackObtenerVariablesExamenes;
    private CallBackModificarVariableExamen callBackModificarVariableExamen;
    private CallBackEliminarVariableExamen callBackEliminarVariableExamen;
    private CallBackVerificarExistenciaVariableExamen callBackVerificarExistenciaVariableExamen;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionVariablesExamen() {
        sqlVariableExamen = new SQLVariableExamen();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackCrearVariableExamen(CallBackCrearVariableExamen callBackCrearVariableExamen) {
        this.callBackCrearVariableExamen = callBackCrearVariableExamen;
    }

    public void setCallBackObtenerVariablesExamenes(CallBackObtenerVariablesExamenes callBackObtenerVariablesExamenes) {
        this.callBackObtenerVariablesExamenes = callBackObtenerVariablesExamenes;
    }

    public void setCallBackModificarVariableExamen(CallBackModificarVariableExamen callBackModificarVariableExamen) {
        this.callBackModificarVariableExamen = callBackModificarVariableExamen;
    }

    public void setCallBackEliminarVariableExamen(CallBackEliminarVariableExamen callBackEliminarVariableExamen) {
        this.callBackEliminarVariableExamen = callBackEliminarVariableExamen;
    }

    public void setCallBackVerificarExistenciaVariableExamen(CallBackVerificarExistenciaVariableExamen callBackVerificarExistenciaVariableExamen) {
        this.callBackVerificarExistenciaVariableExamen = callBackVerificarExistenciaVariableExamen;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void crearVariableExamen(final VariableExamen variableExamen) {
        try {
            final int result = sqlVariableExamen.verificarExistencia(variableExamen);

            switch (result) {
                case 0:
                    if (sqlVariableExamen.insertar(variableExamen)) {
                        callBackCrearVariableExamen.variableExamenCreado("variable de examen creada exitosamente.");
                    } else {
                        callBackCrearVariableExamen.errorCrearVariableExamen("Se produjo un error al crear la variable de examen, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaVariableExamen.variableExamenExiste("Ya existe una variable con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaVariableExamen.errorVerificarExistenciaVariableExamen("Se produjo un error al verificar la existencia de alguna variable con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionVariablesExamen - Crear VariableExamen: " + e.getMessage());
            callBackCrearVariableExamen.errorDesconocidoCrearVariableExamen("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerVariablesExamen(final Examen examen) {
        try {
            final List<VariableExamen> variablesExamenes = sqlVariableExamen.obtenerVariables(examen);

            if (variablesExamenes == null) {
                callBackObtenerVariablesExamenes.errorObtenerVariablesExamenes("Se produjo un error al intentar obtener a las variables del examen, vuelve a intentarlo.");
            } else if (variablesExamenes.isEmpty()) {
                callBackObtenerVariablesExamenes.listaVariablesExamenesVacia("No se encontraron registros de variables de examenes en la base de datos.");
            } else {
                callBackObtenerVariablesExamenes.variablesExamenesObtenidos(variablesExamenes);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionVariablesExamen - Obtener Variables Examen: " + e.getMessage());
            callBackObtenerVariablesExamenes.errorDesconocidoObtenerVariablesExamenes("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void modificarVariableExamen(final VariableExamen variableExamen) {
        try {
            final int result = sqlVariableExamen.verificarExistencia(variableExamen);

            switch (result) {
                case 0:
                    if (sqlVariableExamen.actualizar(variableExamen)) {
                        callBackModificarVariableExamen.variableExamenModificado("Variable modificada correctamente.");
                    } else {
                        callBackModificarVariableExamen.errorModificarVariableExamen("Se produjo un error al modificar los datos de la variable.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaVariableExamen.variableExamenExiste("Ya existe una variable con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaVariableExamen.errorVerificarExistenciaVariableExamen("Se produjo un error al verificar la existencia de alguna variable con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionVariablesExamen - Modificar VariableExamen: " + e.getMessage());
            callBackModificarVariableExamen.errorDesconocidoModificarVariableExamen("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarVariableExamen(final VariableExamen variableExamen) {
        try {
            if (sqlVariableExamen.eliminar(variableExamen)) {
                callBackEliminarVariableExamen.variableExamenEliminada("Variable eliminada.");
            } else {
                callBackEliminarVariableExamen.errorEliminarVariableExamen("Se produjo un error al eliminar la variable.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionVariableExamen - Eliminar VariableExamen: " + e.getMessage());
            callBackEliminarVariableExamen.errorDesconocidoEliminarVariableExamen("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackCrearVariableExamen {

        void variableExamenCreado(final String msg);

        void errorCrearVariableExamen(final String msg);

        void errorDesconocidoCrearVariableExamen(final String msg);
    }

    public interface CallBackObtenerVariablesExamenes {

        void variablesExamenesObtenidos(final List<VariableExamen> variablesExamenes);

        void listaVariablesExamenesVacia(final String msg);

        void errorObtenerVariablesExamenes(final String msg);

        void errorDesconocidoObtenerVariablesExamenes(final String msg);
    }
    
    public interface CallBackModificarVariableExamen {

        void variableExamenModificado(final String msg);

        void errorModificarVariableExamen(final String msg);

        void errorDesconocidoModificarVariableExamen(final String msg);
    }

    public interface CallBackEliminarVariableExamen {

        void variableExamenEliminada(final String msg);

        void errorEliminarVariableExamen(final String msg);

        void errorDesconocidoEliminarVariableExamen(final String msg);
    }
    
    public interface CallBackVerificarExistenciaVariableExamen {

        void variableExamenExiste(final String msg);

        void errorVerificarExistenciaVariableExamen(final String msg);
    }

    // </editor-fold>
    
}
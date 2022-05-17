package Presenter.GestionExamenes;

import Model.DAO.GestionExamenes.SQLGrupoVariables;
import Model.POJO.GrupoVariables;
import Model.POJO.VariableExamen;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionGrupoVariables {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLGrupoVariables sqlGrupoVariables;
    
    private CallBackVerificarExistenciaGrupoVariables callBackVerificarExistenciaGrupoVariables;
    private CallBackCrearGrupoVariables callBackCrearGrupoVariables;
    private CallBackObtenerVariables callBackObtenerVariables;
    private CallBackEliminarGrupoVariables callBackEliminarGrupoVariables;
    private CallBackModificarGrupoVariables callBackModificarGrupoVariables;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionGrupoVariables() {
        sqlGrupoVariables = new SQLGrupoVariables();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackVerificarExistenciaGrupoVariables(CallBackVerificarExistenciaGrupoVariables callBackVerificarExistenciaGrupoVariables) {
        this.callBackVerificarExistenciaGrupoVariables = callBackVerificarExistenciaGrupoVariables;
    }

    public void setCallBackCrearGrupoVariables(CallBackCrearGrupoVariables callBackCrearGrupoVariables) {
        this.callBackCrearGrupoVariables = callBackCrearGrupoVariables;
    }

    public void setCallBackObtenerVariables(CallBackObtenerVariables callBackObtenerVariables) {
        this.callBackObtenerVariables = callBackObtenerVariables;
    }

    public void setCallBackEliminarGrupoVariables(CallBackEliminarGrupoVariables callBackEliminarGrupoVariables) {
        this.callBackEliminarGrupoVariables = callBackEliminarGrupoVariables;
    }

    public void setCallBackModificarGrupoVariables(CallBackModificarGrupoVariables callBackModificarGrupoVariables) {
        this.callBackModificarGrupoVariables = callBackModificarGrupoVariables;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void crearGrupoVariables(final GrupoVariables grupoVariables) {
        try {
            final int result = sqlGrupoVariables.verificarExistencia(grupoVariables);

            switch (result) {
                case 0:
                    if (sqlGrupoVariables.insertar(grupoVariables)) {
                        callBackCrearGrupoVariables.grupoVariablesCreado("Grupo de variables creado exitosamente.");
                    } else {
                        callBackCrearGrupoVariables.errorCrearGrupoVariables("Se produjo un error al crear el grupo de variables, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaGrupoVariables.grupoVariablesExiste("Ya existe un grupo de variables con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaGrupoVariables.errorVerificarExistenciaGrupoVariables("Se produjo un error al verificar la existencia de algun grupo de variables con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionGrupoVariables - Crear GrupoVariables: " + e.getMessage());
            callBackCrearGrupoVariables.errorDesconocidoCrearGrupoVariables("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerVariables(final GrupoVariables grupoVariables) {
        try {
            final List<VariableExamen> variablesExamen = sqlGrupoVariables.obtenerVariables(grupoVariables);

            if (variablesExamen == null) {
                callBackObtenerVariables.errorObtenerVariables("Se produjo un error al intentar obtener a las variables, vuelve a intentarlo.");
            } else if (variablesExamen.isEmpty()) {
                callBackObtenerVariables.listaVariablesVacia("No se encontraron registros de variables en la base de datos.");
            } else {
                callBackObtenerVariables.variablesObtenidas(variablesExamen);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionGrupoVariables - Obtener Variables: " + e.getMessage());
            callBackObtenerVariables.errorDesconocidoObtenerVariables("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarGrupoVariables(final GrupoVariables grupoVariables) {
        try {
            final int result = sqlGrupoVariables.verificarExistencia(grupoVariables);

            switch (result) {
                case 0:
                    if (sqlGrupoVariables.actualizar(grupoVariables)) {
                        callBackModificarGrupoVariables.grupoVariablesModificado("Grupo de variables modificado correctamente.");
                    } else {
                        callBackModificarGrupoVariables.errorModificarGrupoVariables("Se produjo un error al modificar el grupo de variables.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaGrupoVariables.grupoVariablesExiste("Ya existe un grupo de variables con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaGrupoVariables.errorVerificarExistenciaGrupoVariables("Se produjo un error al verificar la existencia de algun grupo de variables con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionGrupoVariables - Modificar GrupoVariables: " + e.getMessage());
            callBackModificarGrupoVariables.errorDesconocidoModificarGrupoVariables("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarGrupoVariables(final GrupoVariables grupoVariables) {
        try {
            final boolean grupoEliminado = sqlGrupoVariables.eliminar(grupoVariables);
            
            if (grupoEliminado) {
                callBackEliminarGrupoVariables.grupoVariablesEliminado("Grupo de variables eliminado.");
            } else {
                callBackEliminarGrupoVariables.errorEliminarGrupoVariables("Se produjo un error al eliminar el grupo de variables.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionGrupoVariables - Eliminar GrupoVariables: " + e.getMessage());
            callBackEliminarGrupoVariables.errorDesconocidoEliminarGrupoVariables("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarExistenciaGrupoVariables {

        void grupoVariablesExiste(final String msg);

        void errorVerificarExistenciaGrupoVariables(final String msg);
    }

    public interface CallBackCrearGrupoVariables {

        void grupoVariablesCreado(final String msg);

        void errorCrearGrupoVariables(final String msg);

        void errorDesconocidoCrearGrupoVariables(final String msg);
    }

    public interface CallBackObtenerVariables {

        void variablesObtenidas(final List<VariableExamen> variablesExamen);

        void listaVariablesVacia(final String msg);

        void errorObtenerVariables(final String msg);

        void errorDesconocidoObtenerVariables(final String msg);
    }

    public interface CallBackModificarGrupoVariables {

        void grupoVariablesModificado(final String msg);

        void errorModificarGrupoVariables(final String msg);

        void errorDesconocidoModificarGrupoVariables(final String msg);
    }
    
    public interface CallBackEliminarGrupoVariables {

        void grupoVariablesEliminado(final String msg);

        void errorEliminarGrupoVariables(final String msg);

        void errorDesconocidoEliminarGrupoVariables(final String msg);
    }

    // </editor-fold>
    
}
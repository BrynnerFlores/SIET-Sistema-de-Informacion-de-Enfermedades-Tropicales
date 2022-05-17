package Presenter.GestionExamenes;

import Model.DAO.GestionExamenes.SQLExamen;
import Model.POJO.Examen;
import Model.POJO.ExamenPosibleResultado;
import Model.POJO.Tecnica;
import Model.POJOPersonalizado.ExamenPersonalizado;
import Model.POJOPersonalizado.GrupoVariablesPersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionExamenes {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLExamen sqlExamen;
    
    private CallBackObtenerExamenes callBackObtenerExamenes;
    private CallBackObtenerGruposVariables callBackObtenerGruposVariables;
    private CallBackVerificarExistenciaExamen callBackVerificarExistenciaExamen;
    private CallBackCrearExamen callBackCrearExamen;
    private CallBackModificarExamen callBackModificarExamen;
    private CallBackEliminarExamen callBackEliminarExamen;
    private CallBackObtenerPosiblesResultados callBackObtenerPosiblesResultados;
    private CallBackObtenerTecnicasAgregadas callBackObtenerTecnicasAgregadas;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionExamenes() {
        sqlExamen = new SQLExamen();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerExamenes(CallBackObtenerExamenes callBackObtenerExamenes) {
        this.callBackObtenerExamenes = callBackObtenerExamenes;
    }

    public void setCallBackObtenerGruposVariables(CallBackObtenerGruposVariables callBackObtenerGruposVariables) {
        this.callBackObtenerGruposVariables = callBackObtenerGruposVariables;
    }

    public void setCallBackVerificarExistenciaExamen(CallBackVerificarExistenciaExamen callBackVerificarExistenciaExamen) {
        this.callBackVerificarExistenciaExamen = callBackVerificarExistenciaExamen;
    }

    public void setCallBackCrearExamen(CallBackCrearExamen callBackCrearExamen) {
        this.callBackCrearExamen = callBackCrearExamen;
    }

    public void setCallBackModificarExamen(CallBackModificarExamen callBackModificarExamen) {
        this.callBackModificarExamen = callBackModificarExamen;
    }

    public void setCallBackEliminarExamen(CallBackEliminarExamen callBackEliminarExamen) {
        this.callBackEliminarExamen = callBackEliminarExamen;
    }

    public void setCallBackObtenerPosiblesResultados(CallBackObtenerPosiblesResultados callBackObtenerPosiblesResultados) {
        this.callBackObtenerPosiblesResultados = callBackObtenerPosiblesResultados;
    }

    public void setCallBackObtenerTecnicasAgregadas(CallBackObtenerTecnicasAgregadas callBackObtenerTecnicasAgregadas) {
        this.callBackObtenerTecnicasAgregadas = callBackObtenerTecnicasAgregadas;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerExamenes() {
        try {
            final List<ExamenPersonalizado> examenesPersonalizados = sqlExamen.obtenerExamenes();

            if (examenesPersonalizados == null) {
                callBackObtenerExamenes.errorObtenerExamenes("Se produjo un error al intentar obtener a los examenes, vuelve a intentarlo.");
            } else if (examenesPersonalizados.isEmpty()) {
                callBackObtenerExamenes.listaExamenesVacia("No se encontraron registros de examenes en la base de datos.");
            } else {
                callBackObtenerExamenes.examenesObtenidos(examenesPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenes - Obtener Examenes: " + e.getMessage());
            callBackObtenerExamenes.errorDesconocidoObtenerExamenes("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerGruposVariables(final Examen examen) {
        try {
            final List<GrupoVariablesPersonalizado> gruposVariablesPersonalizados = sqlExamen.obtenerGrupoVariables(examen);

            if (gruposVariablesPersonalizados == null) {
                callBackObtenerGruposVariables.errorObtenerGruposVariables("Se produjo un error al intentar obtener a los grupos de variables, vuelve a intentarlo.");
            } else if (gruposVariablesPersonalizados.isEmpty()) {
                callBackObtenerGruposVariables.listaGruposVariablesVacia("No se encontraron registros de grupos de variables en la base de datos.");
            } else {
                callBackObtenerGruposVariables.gruposVariablesObtenidos(gruposVariablesPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenes - obtenerGruposVariables: " + e.getMessage());
            callBackObtenerGruposVariables.errorDesconocidoObtenerGruposVariables("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void crearExamen(final Examen examen) {
        try {
            final int result = sqlExamen.verificarExistencia(examen);

            switch (result) {
                case 0:
                    if (sqlExamen.insertar(examen)) {
                        callBackCrearExamen.examenCreado("Examen creado exitosamente.");
                    } else {
                        callBackCrearExamen.errorCrearExamen("Se produjo un error al crear el examen, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaExamen.examenExiste("Ya existe un examen con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaExamen.errorVerificarExistenciaExamen("Se produjo un error al verificar la existencia de algun examen con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamen - Crear Examen: " + e.getMessage());
            callBackCrearExamen.errorDesconocidoCrearExamen("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarExamen(final Examen examen) {
        try {
            final int result = sqlExamen.verificarExistencia(examen);

            switch (result) {
                case 0:
                    if (sqlExamen.actualizar(examen)) {
                        callBackModificarExamen.examenModificado("Examen modificado correctamente.");
                    } else {
                        callBackModificarExamen.errorModificarExamen("Se produjo un error al modificar el examen.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaExamen.examenExiste("Ya existe un examen con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaExamen.errorVerificarExistenciaExamen("Se produjo un error al verificar la existencia de algun examen con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenes - Modificar Examen: " + e.getMessage());
            callBackModificarExamen.errorDesconocidoModificarExamen("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarExamen(final Examen examen) {
        try {
            if (sqlExamen.eliminar(examen)) {
                callBackEliminarExamen.examenEliminado("Exámen Eliminado.");
            } else {
                callBackEliminarExamen.errorEliminarExamen("Se produjo un error al eliminar el exámen.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenes - Eliminar Examen: " + e.getMessage());
            callBackEliminarExamen.errorDesconocidoEliminarExamen("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerPosiblesResultados(final Examen examen) {
        try {
            final List<ExamenPosibleResultado> examenPosiblesResultados = sqlExamen.obtenerPosiblesResultados(examen);

            if (examenPosiblesResultados == null) {
                callBackObtenerPosiblesResultados.errorObtenerPosiblesResultados("Se produjo un error, vuelve a intentarlo.");
            } else if (examenPosiblesResultados.isEmpty()) {
                callBackObtenerPosiblesResultados.listaPosiblesResultadosVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerPosiblesResultados.posiblesResultadosObtenidos(examenPosiblesResultados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamen - Obtener Posibles Resultados: " + e.getMessage());
            callBackObtenerPosiblesResultados.errorDesconocidoObtenerPosiblesResultados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerTecnicasAgregadas(final Examen examen) {
        try {
            final List<Tecnica> tecnicasAgregadas = sqlExamen.obtenerTecnicasAgregadas(examen);

            if (tecnicasAgregadas == null) {
                callBackObtenerTecnicasAgregadas.errorObtenerTecnicasAgregadas("Se produjo un error, vuelve a intentarlo.");
            } else if (tecnicasAgregadas.isEmpty()) {
                callBackObtenerTecnicasAgregadas.listaTecnicasAgregadasVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerTecnicasAgregadas.tecnicasAgregadasObtenidas(tecnicasAgregadas);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionExamenes - Obtener Técnicas Agregadas: " + e.getMessage());
            callBackObtenerTecnicasAgregadas.errorDesconocidoObtenerTecnicasAgregadas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerExamenes {

        void examenesObtenidos(final List<ExamenPersonalizado> examenesPersonalizados);

        void listaExamenesVacia(final String msg);

        void errorObtenerExamenes(final String msg);

        void errorDesconocidoObtenerExamenes(final String msg);
    }

    public interface CallBackObtenerGruposVariables {

        void gruposVariablesObtenidos(final List<GrupoVariablesPersonalizado> gruposVariablesPersonalizados);

        void listaGruposVariablesVacia(final String msg);

        void errorObtenerGruposVariables(final String msg);

        void errorDesconocidoObtenerGruposVariables(final String msg);
    }

    public interface CallBackVerificarExistenciaExamen {

        void examenExiste(final String msg);

        void errorVerificarExistenciaExamen(final String msg);
    }

    public interface CallBackCrearExamen {

        void examenCreado(final String msg);

        void errorCrearExamen(final String msg);

        void errorDesconocidoCrearExamen(final String msg);
    }

    public interface CallBackModificarExamen {

        void examenModificado(final String msg);

        void errorModificarExamen(final String msg);

        void errorDesconocidoModificarExamen(final String msg);
    }
    
    public interface CallBackEliminarExamen {

        void examenEliminado(final String msg);

        void errorEliminarExamen(final String msg);

        void errorDesconocidoEliminarExamen(final String msg);
    }
    
    public interface CallBackObtenerPosiblesResultados {

        void posiblesResultadosObtenidos(final List<ExamenPosibleResultado> examenesPosiblesResultados);

        void listaPosiblesResultadosVacia(final String msg);

        void errorObtenerPosiblesResultados(final String msg);

        void errorDesconocidoObtenerPosiblesResultados(final String msg);
    }
    
    public interface CallBackObtenerTecnicasAgregadas {

        void tecnicasAgregadasObtenidas(final List<Tecnica> tecnicasAgregadas);

        void listaTecnicasAgregadasVacia(final String msg);

        void errorObtenerTecnicasAgregadas(final String msg);

        void errorDesconocidoObtenerTecnicasAgregadas(final String msg);
    }
    
    // </editor-fold>
    
}
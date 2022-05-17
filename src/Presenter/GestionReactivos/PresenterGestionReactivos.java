package Presenter.GestionReactivos;

import Model.DAO.GestionReactivo.SQLReactivo;
import Model.POJO.Reactivo;
import Model.POJOPersonalizado.ReactivoLotePersonalizado;
import Model.POJOPersonalizado.ReactivoPersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionReactivos {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLReactivo sqlReactivo;

    private CallBackObtenerReactivos callBackObtenerReactivos;
    private CallBackObtenerLotes callBackObtenerLotes;
    private CallBackRegistrarReactivo callBackRegistrarReactivo;
    private CallBackModificarReactivo callBackModificarReactivo;
    private CallBackEliminarReactivo callBackEliminarReactivo;
    private CallBackVerificarExistenciaReactivo callBackVerificarExistenciaReactivo;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionReactivos() {
        sqlReactivo = new SQLReactivo();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerReactivos(CallBackObtenerReactivos callBackObtenerReactivos) {
        this.callBackObtenerReactivos = callBackObtenerReactivos;
    }

    public void setCallBackObtenerLotes(CallBackObtenerLotes callBackObtenerLotes) {
        this.callBackObtenerLotes = callBackObtenerLotes;
    }

    public void setCallBackRegistrarReactivo(CallBackRegistrarReactivo callBackRegistrarReactivo) {
        this.callBackRegistrarReactivo = callBackRegistrarReactivo;
    }

    public void setCallBackModificarReactivo(CallBackModificarReactivo callBackModificarReactivo) {
        this.callBackModificarReactivo = callBackModificarReactivo;
    }

    public void setCallBackEliminarReactivo(CallBackEliminarReactivo callBackEliminarReactivo) {
        this.callBackEliminarReactivo = callBackEliminarReactivo;
    }

    public void setCallBackVerificarExistenciaReactivo(CallBackVerificarExistenciaReactivo callBackVerificarExistenciaReactivo) {
        this.callBackVerificarExistenciaReactivo = callBackVerificarExistenciaReactivo;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerReactivos() {
        try {
            final List<ReactivoPersonalizado> reactivosPersonalizados = sqlReactivo.obtenerReactivos();

            if (reactivosPersonalizados == null) {
                callBackObtenerReactivos.errorObtenerReactivos("Se produjo un error al obtener a los reactivos, vuelve a intentarlo.");
            } else if (reactivosPersonalizados.isEmpty()) {
                callBackObtenerReactivos.listaReactivosVacia("No se encontraron registros de reactivos en la base de datos.");
            } else {
                callBackObtenerReactivos.reactivosObtenidos(reactivosPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivos - Obtener Reactivos: " + e.getMessage());
            callBackObtenerReactivos.errorDesconocidoObtenerReactivos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerLotes(final Reactivo reactivo) {
        try {
            final List<ReactivoLotePersonalizado> reactivosLotesPersonalizados = sqlReactivo.obtenerLotes(reactivo);

            if (reactivosLotesPersonalizados == null) {
                callBackObtenerLotes.errorObtenerLotes("Se produjo un error al obtener a los lotes, vuelve a intentarlo.");
            } else if (reactivosLotesPersonalizados.isEmpty()) {
                callBackObtenerLotes.listaLotesVacia("No se encontraron registros de lotes en la base de datos.");
            } else {
                callBackObtenerLotes.lotesObtenidos(reactivosLotesPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivos - Obtener Lotes: " + e.getMessage());
            callBackObtenerLotes.errorDesconocidoObtenerLotes("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void registrarReactivo(final Reactivo reactivo) {
        try {
            final int result = sqlReactivo.verificarExistencia(reactivo);

            switch (result) {
                case 0:
                    if (sqlReactivo.insertar(reactivo)) {
                        callBackRegistrarReactivo.reactivoRegistrado("Registrado correctamente.");
                    } else {
                        callBackRegistrarReactivo.errorRegistrarReactivo("Se produjo un error al registrar el nuevo reactivo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaReactivo.reactivoExiste("Ya existe un reactivo con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaReactivo.errorVerificarExistenciaReactivo("Se produjo un error al verificar la existencia de algun reactivo con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivos - Registrar Reactivos: " + e.getMessage());
            callBackRegistrarReactivo.errorDesconocidoRegistrarReactivo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void modificarReactivo(final Reactivo reactivo) {
        try {
            final int result = sqlReactivo.verificarExistencia(reactivo);

            switch (result) {
                case 0:
                    if (sqlReactivo.actualizar(reactivo)) {
                        callBackModificarReactivo.reactivoModificado("Modificado correctamente.");
                    } else {
                        callBackModificarReactivo.errorModificarReactivo("Se produjo un error al modificar el reactivo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaReactivo.reactivoExiste("Ya existe un reactivo con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaReactivo.errorVerificarExistenciaReactivo("Se produjo un error al verificar la existencia de algun reactivo con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivos - Modificar Reactivos: " + e.getMessage());
            callBackModificarReactivo.errorDesconocidoModificarReactivo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarReactivo(final Reactivo reactivo) {
        try {
            if (sqlReactivo.eliminar(reactivo)) {
                callBackEliminarReactivo.reactivoEliminado("Eliminado.");
            } else {
                callBackEliminarReactivo.errorEliminarReactivo("Se produjo un error, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivos - Modificar Reactivos: " + e.getMessage());
            callBackEliminarReactivo.errorDesconocidoEliminarReactivo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerReactivos {

        void reactivosObtenidos(final List<ReactivoPersonalizado> reactivosPersonalizados);

        void listaReactivosVacia(final String msg);

        void errorObtenerReactivos(final String msg);

        void errorDesconocidoObtenerReactivos(final String msg);
    }
    
    public interface CallBackObtenerLotes {

        void lotesObtenidos(final List<ReactivoLotePersonalizado> reactivosLotesPersonalizados);

        void listaLotesVacia(final String msg);

        void errorObtenerLotes(final String msg);

        void errorDesconocidoObtenerLotes(final String msg);
    }

    public interface CallBackRegistrarReactivo {

        void reactivoRegistrado(final String msg);

        void errorRegistrarReactivo(final String msg);

        void errorDesconocidoRegistrarReactivo(final String msg);
    }

    public interface CallBackModificarReactivo {

        void reactivoModificado(final String msg);

        void errorModificarReactivo(final String msg);

        void errorDesconocidoModificarReactivo(final String msg);
    }
    
    public interface CallBackEliminarReactivo {

        void reactivoEliminado(final String msg);

        void errorEliminarReactivo(final String msg);

        void errorDesconocidoEliminarReactivo(final String msg);
    }
    
    public interface CallBackVerificarExistenciaReactivo {

        void reactivoExiste(final String msg);

        void errorVerificarExistenciaReactivo(final String msg);

        void errorDesconocidoVerificarExistenciaReactivo(final String msg);
    }

    // </editor-fold>
    
}
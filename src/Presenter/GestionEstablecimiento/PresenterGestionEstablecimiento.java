package Presenter.GestionEstablecimiento;

import Model.DAO.GestionRecepciones.SQLEstablecimiento;
import Model.POJO.Establecimiento;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionEstablecimiento {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLEstablecimiento sqlEstablecimiento;
    
    private CallBackObtenerEstablecimientos callBackObtenerEstablecimientos;
    private CallBackRegistrarEstablecimiento callBackRegistrarEstablecimiento;
    private CallBackModificarEstablecimiento callBackModificarEstablecimiento;
    private CallBackEliminarEstablecimiento callBackEliminarEstablecimiento;
    private CallBackVerificarExistenciaEstablecimiento callBackVerificarExistenciaEstablecimiento;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionEstablecimiento() {
        sqlEstablecimiento = new SQLEstablecimiento();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerEstablecimientos(CallBackObtenerEstablecimientos callBackObtenerEstablecimientos) {
        this.callBackObtenerEstablecimientos = callBackObtenerEstablecimientos;
    }

    public void setCallBackRegistrarEstablecimiento(CallBackRegistrarEstablecimiento callBackRegistrarEstablecimiento) {
        this.callBackRegistrarEstablecimiento = callBackRegistrarEstablecimiento;
    }

    public void setCallBackModificarEstablecimiento(CallBackModificarEstablecimiento callBackModificarEstablecimiento) {
        this.callBackModificarEstablecimiento = callBackModificarEstablecimiento;
    }

    public void setCallBackEliminarEstablecimiento(CallBackEliminarEstablecimiento callBackEliminarEstablecimiento) {
        this.callBackEliminarEstablecimiento = callBackEliminarEstablecimiento;
    }

    public void setCallBackVerificarExistenciaEstablecimiento(CallBackVerificarExistenciaEstablecimiento callBackVerificarExistenciaEstablecimiento) {
        this.callBackVerificarExistenciaEstablecimiento = callBackVerificarExistenciaEstablecimiento;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerEstablecimientos() {
        try {
            final List<Establecimiento> establecimientos = sqlEstablecimiento.obtenerEstablecimientos();

            if (establecimientos == null) {
                callBackObtenerEstablecimientos.errorObtenerEstablecimientos("Se produjo un error al intentar obtener a los establecimientos, vuelve a intentarlo.");
            } else if (establecimientos.isEmpty()) {
                callBackObtenerEstablecimientos.listaEstablecimientosVacia("No se encontraron registros de establecimientos en la base de datos.");
            } else {
                callBackObtenerEstablecimientos.establecimientosObtenidos(establecimientos);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEstablecimientos - Obtener Establecimientos: " + e.getMessage());
            callBackObtenerEstablecimientos.errorDesconocidoObtenerEstablecimientos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void registrarEstablecimiento(final Establecimiento establecimiento) {
        try {
            final int result = sqlEstablecimiento.verificarExistencia(establecimiento);

            switch (result) {
                case 0:
                    if (sqlEstablecimiento.insertar(establecimiento)) {
                        callBackRegistrarEstablecimiento.establecimientoRegistrado("Establecimiento registrado exitosamente.");
                    } else {
                        callBackRegistrarEstablecimiento.errorRegistrarEstablecimiento("Se produjo un error al registrar el establecimiento, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEstablecimiento.establecimientoExiste("Ya existe un establecimiento con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEstablecimiento.errorVerificarExistenciaEstablecimiento("Se produjo un error al verificar la existencia de algun establecimiento con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEstablecimientos - Registrar Establecimiento: " + e.getMessage());
            callBackRegistrarEstablecimiento.errorDesconocidoRegistrarEstablecimiento("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarEstablecimiento(final Establecimiento establecimiento) {
        try {
            final int result = sqlEstablecimiento.verificarExistencia(establecimiento);

            switch (result) {
                case 0:
                    if (sqlEstablecimiento.actualizar(establecimiento)) {
                        callBackModificarEstablecimiento.establecimientoModificado("Establecimiento modificado correctamente.");
                    } else {
                        callBackModificarEstablecimiento.errorModificarEstablecimiento("Se produjo un error al modificar el establecimiento.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaEstablecimiento.establecimientoExiste("Ya existe un establecimiento con el mismo nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaEstablecimiento.errorVerificarExistenciaEstablecimiento("Se produjo un error al verificar la existencia de algun establecimiento con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEstablecimientos - Modificar Establecimiento: " + e.getMessage());
            callBackModificarEstablecimiento.errorDesconocidoModificarEstablecimiento("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarEstablecimiento(final Establecimiento establecimiento) {
        try {
            if (sqlEstablecimiento.eliminar(establecimiento)) {
                callBackEliminarEstablecimiento.establecimientoEliminado();
            } else {
                callBackEliminarEstablecimiento.errorEliminarEstablecimiento("Se produjo un error al eliminar el establecimiento.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionEstablecimientos - Eliminar Establecimiento: " + e.getMessage());
            callBackEliminarEstablecimiento.errorDesconocidoEliminarEstablecimiento("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerEstablecimientos {

        void establecimientosObtenidos(final List<Establecimiento> establecimientos);

        void listaEstablecimientosVacia(final String msg);

        void errorObtenerEstablecimientos(final String msg);

        void errorDesconocidoObtenerEstablecimientos(final String msg);
    }

    public interface CallBackVerificarExistenciaEstablecimiento {

        void establecimientoExiste(final String msg);

        void errorVerificarExistenciaEstablecimiento(final String msg);
    }

    public interface CallBackRegistrarEstablecimiento {

        void establecimientoRegistrado(final String msg);

        void errorRegistrarEstablecimiento(final String msg);

        void errorDesconocidoRegistrarEstablecimiento(final String msg);
    }

    public interface CallBackModificarEstablecimiento {

        void establecimientoModificado(final String msg);

        void errorModificarEstablecimiento(final String msg);

        void errorDesconocidoModificarEstablecimiento(final String msg);
    }

    public interface CallBackEliminarEstablecimiento {

        void establecimientoEliminado();

        void errorEliminarEstablecimiento(final String msg);

        void errorDesconocidoEliminarEstablecimiento(final String msg);
    }

    // </editor-fold>
    
}
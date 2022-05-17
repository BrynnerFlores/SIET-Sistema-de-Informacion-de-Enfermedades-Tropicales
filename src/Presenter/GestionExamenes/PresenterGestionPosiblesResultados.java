package Presenter.GestionExamenes;

import Model.DAO.GestionExamenes.SQLExamenPosibleResultado;
import Model.POJO.ExamenPosibleResultado;

/**
 *
 * @author Brynner
 */
public class PresenterGestionPosiblesResultados {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLExamenPosibleResultado sqlExamenPosibleResultado;
    
    private CallBackAgregarPosibleResultado callBackAgregarPosibleResultado;
    private CallBackModificarPosibleResultado callBackModificarPosibleResultado;
    private CallBackEliminarPosibleResultado callBackEliminarPosibleResultado;
    private CallBackVerificarExistencia callBackVerificarExistencia;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionPosiblesResultados() {
        sqlExamenPosibleResultado = new SQLExamenPosibleResultado();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackAgregarPosibleResultado(CallBackAgregarPosibleResultado callBackAgregarPosibleResultado) {
        this.callBackAgregarPosibleResultado = callBackAgregarPosibleResultado;
    }

    public void setCallBackModificarPosibleResultado(CallBackModificarPosibleResultado callBackModificarPosibleResultado) {
        this.callBackModificarPosibleResultado = callBackModificarPosibleResultado;
    }

    public void setCallBackEliminarPosibleResultado(CallBackEliminarPosibleResultado callBackEliminarPosibleResultado) {
        this.callBackEliminarPosibleResultado = callBackEliminarPosibleResultado;
    }
    
    public void setCallBackVerificarExistencia(CallBackVerificarExistencia callBackVerificarExistencia) {    
        this.callBackVerificarExistencia = callBackVerificarExistencia;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void agregarPosibleResultado(final ExamenPosibleResultado examenPosibleResultado) {
        try {
            final int result = sqlExamenPosibleResultado.verificarExistencia(examenPosibleResultado);

            switch (result) {
                case 0:
                    if (sqlExamenPosibleResultado.insertar(examenPosibleResultado)) {
                        callBackAgregarPosibleResultado.posibleResultadoAgregado("Posible Resultado Agregado.");
                    } else {
                        callBackAgregarPosibleResultado.errorAgregarPosibleResultado("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.posibleResultadoExiste("Ya existe un posible resultado con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistencia("Se produjo un error al verificar la existencia de alguna variable con el nombre que ingresaste, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPosibleResultados - Agregar Posibles Resultados: " + e.getMessage());
            callBackAgregarPosibleResultado.errorDesconocidoAgregarPosibleResultado("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void modificarPosibleResultado(final ExamenPosibleResultado examenPosibleResultado) {
        try {
            final int result = sqlExamenPosibleResultado.verificarExistencia(examenPosibleResultado);

            switch (result) {
                case 0:
                    if (sqlExamenPosibleResultado.actualizar(examenPosibleResultado)) {
                        callBackModificarPosibleResultado.posibleResultadoModificado("Posible Resultado modificado.");
                    } else {
                        callBackModificarPosibleResultado.errorModificarPosibleResultado("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.posibleResultadoExiste("Ya existe un posible resultado con el nombre que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistencia("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPosibleResultados - Modificar Posible Resultado: " + e.getMessage());
            callBackModificarPosibleResultado.errorDesconocidoModificarPosibleResultado("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarPosibleResultado(final ExamenPosibleResultado examenPosibleResultado) {
        try {
            if (sqlExamenPosibleResultado.eliminar(examenPosibleResultado)) {
                callBackEliminarPosibleResultado.posibleResultadoEliminado("Posible Resultado eliminado.");
            } else {
                callBackEliminarPosibleResultado.errorEliminarPosibleResultado("Se produjo un error, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPosibleResultados - Eliminar Posible Resultado: " + e.getMessage());
            callBackEliminarPosibleResultado.errorDesconocidoEliminarPosibleResultado("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackAgregarPosibleResultado {

        void posibleResultadoAgregado(final String msg);

        void errorAgregarPosibleResultado(final String msg);

        void errorDesconocidoAgregarPosibleResultado(final String msg);
    }
    
    public interface CallBackModificarPosibleResultado {

        void posibleResultadoModificado(final String msg);

        void errorModificarPosibleResultado(final String msg);

        void errorDesconocidoModificarPosibleResultado(final String msg);
    }

    public interface CallBackEliminarPosibleResultado {

        void posibleResultadoEliminado(final String msg);

        void errorEliminarPosibleResultado(final String msg);

        void errorDesconocidoEliminarPosibleResultado(final String msg);
    }
    
    public interface CallBackVerificarExistencia {

        void posibleResultadoExiste(final String msg);

        void errorVerificarExistencia(final String msg);
    }

    // </editor-fold>
    
}
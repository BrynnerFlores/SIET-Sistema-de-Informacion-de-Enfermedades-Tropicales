package Presenter.GestionReactivos;

import Model.DAO.GestionReactivo.SQLLoteEliminado;
import Model.DAO.GestionReactivo.SQLReactivoLote;
import Model.DAO.GestionReactivo.SQLUnidadEliminada;
import Model.POJO.LoteEliminado;
import Model.POJO.ReactivoLote;
import Model.POJO.UnidadEliminada;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionReactivosLotes {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLReactivoLote sqlReactivoLote;
    private final SQLLoteEliminado sqlLoteEliminado;
    private final SQLUnidadEliminada sqlUnidadEliminada;

    private CallBackRegistrarLote callBackRegistrarLote;
    private CallBackVerificarExistenciaLote callBackVerificarExistenciaLote;
    private CallBackVerificarSaldoUnidades callBackVerificarSaldoUnidades;
    private CallBackIniciarConsumo callBackIniciarConsumo;
    private CallBackDetenerConsumo callBackDetenerConsumo;
    private CallBackEliminarLote callBackEliminarLote;
    private CallBackEliminarUnidad callBackEliminarUnidad;
    private CallBackVerificarLoteConsumoIniciado callBackVerificarLoteConsumoIniciado;
    private CallBackVerificarLotesConsumoIniciado callBackVerificarLotesConsumoIniciado;
    private CallBackObtenerUnidadesEliminadas callBackObtenerUnidadesEliminadas;
    private CallBackVerificarLoteAgotado callBackVerificarLoteAgotado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionReactivosLotes() {
        sqlReactivoLote = new SQLReactivoLote();
        sqlLoteEliminado = new SQLLoteEliminado();
        sqlUnidadEliminada = new SQLUnidadEliminada();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackRegistrarLote(CallBackRegistrarLote callBackRegistrarLote) {
        this.callBackRegistrarLote = callBackRegistrarLote;
    }

    public void setCallBackVerificarExistenciaLote(CallBackVerificarExistenciaLote callBackVerificarExistenciaLote) {
        this.callBackVerificarExistenciaLote = callBackVerificarExistenciaLote;
    }

    public void setCallBackIniciarConsumo(CallBackIniciarConsumo callBackIniciarConsumo) {
        this.callBackIniciarConsumo = callBackIniciarConsumo;
    }

    public void setCallBackDetenerConsumo(CallBackDetenerConsumo callBackDetenerConsumo) {
        this.callBackDetenerConsumo = callBackDetenerConsumo;
    }

    public void setCallBackEliminarLote(CallBackEliminarLote callBackEliminarLote) {
        this.callBackEliminarLote = callBackEliminarLote;
    }

    public void setCallBackVerificarSaldoUnidades(CallBackVerificarSaldoUnidades callBackVerificarSaldoUnidades) {
        this.callBackVerificarSaldoUnidades = callBackVerificarSaldoUnidades;
    }

    public void setCallBackEliminarUnidad(CallBackEliminarUnidad callBackEliminarUnidad) {
        this.callBackEliminarUnidad = callBackEliminarUnidad;
    }

    public void setCallBackVerificarLoteConsumoIniciado(CallBackVerificarLoteConsumoIniciado callBackVerificarLoteConsumoIniciado) {
        this.callBackVerificarLoteConsumoIniciado = callBackVerificarLoteConsumoIniciado;
    }

    public void setCallBackVerificarLotesConsumoIniciado(CallBackVerificarLotesConsumoIniciado callBackVerificarLotesConsumoIniciado) {
        this.callBackVerificarLotesConsumoIniciado = callBackVerificarLotesConsumoIniciado;
    }

    public void setCallBackObtenerUnidadesEliminadas(CallBackObtenerUnidadesEliminadas callBackObtenerUnidadesEliminadas) {
        this.callBackObtenerUnidadesEliminadas = callBackObtenerUnidadesEliminadas;
    }

    public void setCallBackVerificarLoteAgotado(CallBackVerificarLoteAgotado callBackVerificarLoteAgotado) {
        this.callBackVerificarLoteAgotado = callBackVerificarLoteAgotado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void registrarLote(final ReactivoLote reactivoLote) {
        try {
            final int result = sqlReactivoLote.verificarExistenciaLote(reactivoLote);

            switch (result) {
                case 0:
                    if (sqlReactivoLote.insertar(reactivoLote)) {
                        callBackRegistrarLote.loteRegistrado("Registrado correctamente.");
                    } else {
                        callBackRegistrarLote.errorRegistrarLote("Se produjo un error en el registro de entrada del nuevo lote de reactivos.");
                    }
                    break;

                case 1:
                    callBackVerificarExistenciaLote.loteExiste("Ya existe un lote de reactivos con el mismo número de lote que ingresaste.");
                    break;

                default:
                    callBackVerificarExistenciaLote.errorVerificarExistenciaLote("Se produjo un error en la verificación de existencia.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosLotes - Registrar Lote: " + e.getMessage());
            callBackRegistrarLote.errorDesconocidoRegistrarLote("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }

    public void iniciarConsumo(final ReactivoLote reactivoLote) {
        try {
            int result = sqlReactivoLote.verificarLoteAgotado(reactivoLote);

            switch (result) {
                case 0:
                    result = sqlReactivoLote.verificarLoteConsumoIniciado(reactivoLote);

                    switch (result) {
                        case 0:
                            result = sqlReactivoLote.verificarLotesConsumoIniciado(reactivoLote);

                            switch (result) {
                                case 0:
                                    final boolean consumoIniciado = sqlReactivoLote.iniciarConsumo(reactivoLote);

                                    if (consumoIniciado) {
                                        callBackIniciarConsumo.consumoIniciado("Consumo Iniciado.");
                                    } else {
                                        callBackIniciarConsumo.errorIniciarConsumo("Se produjo un error, vuelve a intentarlo.");
                                    }
                                    break;

                                case 1:
                                    callBackVerificarLotesConsumoIniciado.existeUnLoteEnConsumoIniciado("Ya existe un lote que está en consumo iniciado.\nDebes finalizarlo para poder iniciar uno nuevo.");
                                    break;

                                default:
                                    callBackVerificarLotesConsumoIniciado.errorDesconocidoVerificarLotesConsumoIniciado("Se produjo un error desconocido, vuelve a intentarlo.");
                                    break;
                            }

                            break;

                        case 1:
                            callBackVerificarLoteConsumoIniciado.consumoEstaIniciado("El consumo de este lote ya está iniciado.");
                            break;

                        default:
                            callBackVerificarLoteConsumoIniciado.errorDesconocidoVerificarLoteConsumoIniciado("Se produjo un error desconocido, vuelve a intentarlo.");
                            break;
                    }
                    break;

                case 1:
                    callBackVerificarLoteAgotado.loteAgotado("No se puede iniciar, el lote está agotado.");
                    break;

                default:
                    callBackVerificarLoteAgotado.errorDesconocidoVerificarLoteAgotado("Se produjo un error desconocido, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosLotes - Registrar Lote: " + e.getMessage());
            callBackIniciarConsumo.errorDesconocidoIniciarConsumo("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }

    public void detenerConsumo(final ReactivoLote reactivoLote) {
        try {
            int result = sqlReactivoLote.verificarLoteConsumoIniciado(reactivoLote);

            switch (result) {
                case 0:
                    callBackDetenerConsumo.consumoNoIniciado("El consumo de este lote no está iniciado.");
                    break;

                case 1:
                    final boolean consumoDetenido = sqlReactivoLote.detenerConsumo(reactivoLote);

                    if (consumoDetenido) {
                        callBackDetenerConsumo.consumoDetenido("Consumo Detenido.");
                    } else {
                        callBackDetenerConsumo.errorDetenerConsumo("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                default:
                    callBackVerificarLoteConsumoIniciado.errorDesconocidoVerificarLoteConsumoIniciado("Se produjo un error desconocido, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosLotes - Detener Lote: " + e.getMessage());
            callBackDetenerConsumo.errorDesconocidoDetenerConsumo("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarLote(final LoteEliminado loteEliminado) {
        try {
            final boolean result = sqlLoteEliminado.eliminarLote(loteEliminado);

            if (result) {
                callBackEliminarLote.loteEliminado("Eliminado correctamente.");
            } else {
                callBackEliminarLote.errorEliminarLote("Se produjo un error. Vuelve a intentarlo.");
            }

        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosLotes - Eliminar Lote: " + e.getMessage());
            callBackEliminarLote.errorDesconocidoEliminarLote("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarUnidad(final UnidadEliminada unidadEliminada, final int unidadesAEliminar) {
        try {
            final int existeSaldoDisponible = sqlUnidadEliminada.verificarSaldoUnidades(unidadEliminada);

            switch (existeSaldoDisponible) {
                case 0:
                    callBackVerificarSaldoUnidades.noExisteSaldoDisponible("No existen unidades disponibles en este lote.");
                    break;

                case 1:
                    final boolean eliminado = sqlUnidadEliminada.eliminarUnidad(unidadEliminada, unidadesAEliminar);

                    if (eliminado) {
                        callBackEliminarUnidad.unidadEliminada("Eliminado correctamente.");
                    } else {
                        callBackEliminarUnidad.errorEliminarUnidad("Se produjo un error. Vuelve a intentarlo.");
                    }
                    break;

                default:
                    callBackVerificarSaldoUnidades.errorDesconocidoVerificarSaldoUnidades("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
                    break;
            }

        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosLotes - Eliminar Lote: " + e.getMessage());
            callBackEliminarUnidad.errorDesconocidoEliminarUnidad("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerUnidadesEliminadas(final ReactivoLote reactivoLote) {
        try {
            final List<UnidadEliminada> unidadesEliminadas = sqlReactivoLote.obtenerUnidadesEliminadas(reactivoLote);

            if (unidadesEliminadas == null) {
                callBackObtenerUnidadesEliminadas.errorObtenerUnidadesEliminadas("Se produjo un error. Vuelve a intentarlo.");
            } else if (unidadesEliminadas.isEmpty()) {
                callBackObtenerUnidadesEliminadas.listaUnidadesEliminadasVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerUnidadesEliminadas.unidadesEliminadasObtenidas(unidadesEliminadas);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionReactivosLotes - Obtener Unidades Eliminadas: " + e.getMessage());
            callBackObtenerUnidadesEliminadas.errorDesconocidoObtenerUnidadesEliminadas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackRegistrarLote {

        void loteRegistrado(final String msg);

        void errorRegistrarLote(final String msg);

        void errorDesconocidoRegistrarLote(final String msg);
    }

    public interface CallBackVerificarExistenciaLote {

        void loteExiste(final String msg);

        void errorVerificarExistenciaLote(final String msg);

    }

    public interface CallBackIniciarConsumo {

        void consumoIniciado(final String msg);

        void errorIniciarConsumo(final String msg);

        void errorDesconocidoIniciarConsumo(final String msg);
    }

    public interface CallBackDetenerConsumo {

        void consumoDetenido(final String msg);

        void consumoNoIniciado(final String msg);

        void errorDetenerConsumo(final String msg);

        void errorDesconocidoDetenerConsumo(final String msg);
    }

    public interface CallBackEliminarLote {

        void loteEliminado(final String msg);

        void errorEliminarLote(final String msg);

        void errorDesconocidoEliminarLote(final String msg);
    }

    public interface CallBackEliminarUnidad {

        void unidadEliminada(final String msg);

        void errorEliminarUnidad(final String msg);

        void errorDesconocidoEliminarUnidad(final String msg);
    }

    public interface CallBackVerificarLoteConsumoIniciado {

        void consumoEstaIniciado(final String msg);

        void errorDesconocidoVerificarLoteConsumoIniciado(final String msg);

    }

    public interface CallBackVerificarLotesConsumoIniciado {

        void existeUnLoteEnConsumoIniciado(final String msg);

        void errorDesconocidoVerificarLotesConsumoIniciado(final String msg);

    }

    public interface CallBackVerificarSaldoUnidades {

        void noExisteSaldoDisponible(final String msg);

        void errorDesconocidoVerificarSaldoUnidades(final String msg);

    }
    
    public interface CallBackVerificarLoteAgotado {

        void loteAgotado(final String msg);

        void errorDesconocidoVerificarLoteAgotado(final String msg);

    }

    public interface CallBackObtenerUnidadesEliminadas {

        void unidadesEliminadasObtenidas(final List<UnidadEliminada> unidadesEliminadas);

        void listaUnidadesEliminadasVacia(final String msg);

        void errorObtenerUnidadesEliminadas(final String msg);

        void errorDesconocidoObtenerUnidadesEliminadas(final String msg);
    }
    
    // </editor-fold>
    
}
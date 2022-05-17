package Presenter.GestionPacientes;

import Model.DAO.GestionRecepciones.SQLSeguimientoPaciente;
import Model.POJO.ExamenSolicitado;
import Model.POJO.SeguimientoPaciente;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionSeguimientoPaciente {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLSeguimientoPaciente sqlSeguimientoPaciente;
    
    private CallBackVerificarSeguimientoExiste callBackVerificarSeguimientoExiste;
    private CallBackVerificarSeguimientoIniciado callBackVerificarSeguimientoIniciado;
    private CallBackIniciarSeguimiento callBackIniciarSeguimiento;
    private CallBackVerificarSeguimientoFinalizado callBackVerificarSeguimientoFinalizado;
    private CallBackFinalizarSeguimiento callBackFinalizarSeguimiento;
    private CallBackObtenerAntecedente callBackObtenerAntecedente;
    private CallBackResolucionInversaDeExamenSolicitado callBackResolucionInversaDeExamenSolicitado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionSeguimientoPaciente() {
        sqlSeguimientoPaciente = new SQLSeguimientoPaciente();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackVerificarSeguimientoExiste(CallBackVerificarSeguimientoExiste callBackVerificarSeguimientoExiste) {
        this.callBackVerificarSeguimientoExiste = callBackVerificarSeguimientoExiste;
    }

    public void setCallBackIniciarSeguimiento(CallBackIniciarSeguimiento callBackIniciarSeguimiento) {
        this.callBackIniciarSeguimiento = callBackIniciarSeguimiento;
    }

    public void setCallBackVerificarSeguimientoIniciado(CallBackVerificarSeguimientoIniciado callBackVerificarSeguimientoIniciado) {
        this.callBackVerificarSeguimientoIniciado = callBackVerificarSeguimientoIniciado;
    }

    public void setCallBackVerificarSeguimientoFinalizado(CallBackVerificarSeguimientoFinalizado callBackVerificarSeguimientoFinalizado) {
        this.callBackVerificarSeguimientoFinalizado = callBackVerificarSeguimientoFinalizado;
    }

    public void setCallBackFinalizarSeguimiento(CallBackFinalizarSeguimiento callBackFinalizarSeguimiento) {
        this.callBackFinalizarSeguimiento = callBackFinalizarSeguimiento;
    }

    public void setCallBackObtenerAntecedente(CallBackObtenerAntecedente callBackObtenerAntecedente) {
        this.callBackObtenerAntecedente = callBackObtenerAntecedente;
    }

    public void setCallBackResolucionInversaDeExamenSolicitado(CallBackResolucionInversaDeExamenSolicitado callBackResolucionInversaDeExamenSolicitado) {
        this.callBackResolucionInversaDeExamenSolicitado = callBackResolucionInversaDeExamenSolicitado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void iniciarSeguimiento(final SeguimientoPaciente seguimientoPaciente) {
        try {
            final int seguimientoExiste = sqlSeguimientoPaciente.verificarSeguimientoExiste(seguimientoPaciente);

            switch (seguimientoExiste) {
                case 0:
                    final int seguimientoIniciado = sqlSeguimientoPaciente.verificarSeguimientoIniciado(seguimientoPaciente);

                    switch (seguimientoIniciado) {
                        case 0:
                            if (sqlSeguimientoPaciente.insertar(seguimientoPaciente)) {
                                callBackIniciarSeguimiento.seguimientoIniciado("Seguimiento Iniciado.");
                            } else {
                                callBackIniciarSeguimiento.errorIniciarSeguimiento("Se produjo un error, vuelve a intentarlo.");
                            }
                            break;

                        case 1:
                            callBackVerificarSeguimientoIniciado.seguimientoEstaIniciado("El paciente ya está en seguimiento.");
                            break;

                        default:
                            callBackVerificarSeguimientoIniciado.errorVerificarSeguimientoIniciado("Se produjo un error, vuelve a intentarlo.");
                            break;
                    }
                    break;

                case 1:
                    callBackVerificarSeguimientoExiste.seguimientoExiste("Este exámen ya pertenece a un seguimiento, no puede volver a iniciarse.");
                    break;

                default:
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSeguimientoPaciente - Iniciar Seguimiento: " + e.getMessage());
            callBackIniciarSeguimiento.errorDesconocidoIniciarSeguimiento("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void finalizarSeguimiento(final SeguimientoPaciente seguimientoPaciente) {
        try {
            final int result = sqlSeguimientoPaciente.verificarSeguimientoFinalizado(seguimientoPaciente);

            switch (result) {
                case 0:
                    if (sqlSeguimientoPaciente.finalizarSeguimiento(seguimientoPaciente)) {
                        callBackFinalizarSeguimiento.seguimientoFinalizado("Seguimiento Finalizado.");
                    } else {
                        callBackFinalizarSeguimiento.errorFinalizarSeguimiento("Se produjo un error, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarSeguimientoFinalizado.seguimientoEstaFinalizado("Este seguimiento ya esta finalizado.");
                    break;

                default:
                    callBackVerificarSeguimientoFinalizado.errorVerificarSeguimientoFinalizado("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSeguimientoPaciente - Iniciar Seguimiento: " + e.getMessage());
            callBackFinalizarSeguimiento.errorDesconocidoFinalizarSeguimiento("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void ObtenerAntecedente(final SeguimientoPaciente seguimientoPaciente) {
        try {
            final ExamenSolicitado examenSolicitado = sqlSeguimientoPaciente.obtenerAntecendente(seguimientoPaciente);
            if (examenSolicitado == null) {
                callBackObtenerAntecedente.errorObtenerAntecedente("Se produjo un error.");
            } else {
                callBackObtenerAntecedente.antecedenteObtenido(examenSolicitado);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionSeguimientoPaciente - Obtener Antecedente: " + e.getMessage());
            callBackObtenerAntecedente.errorDesconocidoObtenerAntecedente("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void resolucionInversaDeExamenSolicitado(final SeguimientoPaciente seguimientoPaciente) {
        try {
            final List<ExamenSolicitado> examenesSolicitados = sqlSeguimientoPaciente.resolucionInversaDeExamenesSolicitados(seguimientoPaciente);

            if (examenesSolicitados == null) {
                callBackResolucionInversaDeExamenSolicitado.errorResolucionExamenesSolicitados("Se produjo un error, vuelve a intentarlo.");
            } else if (examenesSolicitados.isEmpty()) {
                callBackResolucionInversaDeExamenSolicitado.listaExamenesSolicitadosVacia("No se encontraron controles del seguimiento en la base de datos.");
            } else {
                callBackResolucionInversaDeExamenSolicitado.examenesSolicitadosResueltos(examenesSolicitados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionResultadoGeneral - Resolucion Inversa de Examenes Solicitados: " + e.getMessage());
            callBackResolucionInversaDeExamenSolicitado.errorDesconocidoResolucionExamenesSolicitados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarSeguimientoExiste {

        void seguimientoExiste(final String msg);

        void errorVerificarSeguimientoExiste(final String msg);

    }

    public interface CallBackVerificarSeguimientoIniciado {

        void seguimientoEstaIniciado(final String msg);

        void errorVerificarSeguimientoIniciado(final String msg);

    }

    public interface CallBackIniciarSeguimiento {

        void seguimientoIniciado(final String msg);

        void errorIniciarSeguimiento(final String msg);

        void errorDesconocidoIniciarSeguimiento(final String msg);
    }

    public interface CallBackVerificarSeguimientoFinalizado {

        void seguimientoEstaFinalizado(final String msg);

        void errorVerificarSeguimientoFinalizado(final String msg);

    }

    public interface CallBackFinalizarSeguimiento {

        void seguimientoFinalizado(final String msg);

        void errorFinalizarSeguimiento(final String msg);

        void errorDesconocidoFinalizarSeguimiento(final String msg);
    }

    public interface CallBackObtenerAntecedente {

        void antecedenteObtenido(final ExamenSolicitado examenSolicitado);

        void errorObtenerAntecedente(final String msg);

        void errorDesconocidoObtenerAntecedente(final String msg);
    }

    public interface CallBackResolucionInversaDeExamenSolicitado {

        void examenesSolicitadosResueltos(final List<ExamenSolicitado> examenesSolicitados);

        void listaExamenesSolicitadosVacia(final String msg);

        void errorResolucionExamenesSolicitados(final String msg);

        void errorDesconocidoResolucionExamenesSolicitados(final String msg);
    }

    // </editor-fold>
    
}
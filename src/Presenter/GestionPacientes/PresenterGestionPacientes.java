package Presenter.GestionPacientes;

import Model.DAO.GestionPacientes.SQLPaciente;
import Model.POJO.ExamenSolicitado;
import Model.POJO.Paciente;
import Model.POJO.SeguimientoPaciente;
import Model.POJOPersonalizado.PacientePersonalizado;
import Model.POJOPersonalizado.RecepcionPersonalizada;
import Model.POJOPersonalizado.SeguimientoPacientePersonalizado;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionPacientes {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLPaciente sqlPaciente;
    
    private CallBackObtenerPacientes callBackObtenerPacientes;
    private CallBackObtenerPaciente callBackObtenerPaciente;
    private CallBackObtenerSeguimiento callBackObtenerSeguimiento;
    private CallBackObtenerSeguimientos callBackObtenerSeguimientos;
    private CallBackModificarPaciente callBackModificarPaciente;
    private CallBackVerificarExistencia callBackVerificarExistencia;
    private CallBackObtenerHistorialClinico callBackObtenerHistorialClinico;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionPacientes() {
        sqlPaciente = new SQLPaciente();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerPacientes(CallBackObtenerPacientes callBackObtenerPacientes) {
        this.callBackObtenerPacientes = callBackObtenerPacientes;
    }
    
    public void setCallBackObtenerPaciente(CallBackObtenerPaciente callBackObtenerPaciente) {
        this.callBackObtenerPaciente = callBackObtenerPaciente;
    }

    public void setCallBackObtenerSeguimiento(CallBackObtenerSeguimiento callBackObtenerSeguimiento) {
        this.callBackObtenerSeguimiento = callBackObtenerSeguimiento;
    }

    public void setCallBackObtenerSeguimientos(CallBackObtenerSeguimientos callBackObtenerSeguimientos) {
        this.callBackObtenerSeguimientos = callBackObtenerSeguimientos;
    }
    
    public void setCallBackModificarPaciente(CallBackModificarPaciente callBackModificarPaciente) {
        this.callBackModificarPaciente = callBackModificarPaciente;
    }
    
    public void setCallBackVerificarExistencia(CallBackVerificarExistencia callBackVerificarExistencia) {
        this.callBackVerificarExistencia = callBackVerificarExistencia;
    }

    public void setCallBackObtenerHistorialClinico(CallBackObtenerHistorialClinico callBackObtenerHistorialClinico) {
        this.callBackObtenerHistorialClinico = callBackObtenerHistorialClinico;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerPacientes() {
        try {
            final List<PacientePersonalizado> pacientesPersonalizados = sqlPaciente.obtenerPacientes();

            if (pacientesPersonalizados == null) {
                callBackObtenerPacientes.errorObtenerPacientes("Se produjo un error al intentar obtener a los pacientes, vuelve a intentarlo.");
            } else if (pacientesPersonalizados.isEmpty()) {
                callBackObtenerPacientes.listaPacientesVacia("No se encontraron registros de Pacientes en la base de datos.");
            } else {
                callBackObtenerPacientes.pacientesObtenidos(pacientesPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("Error PresenterGestionPacientes - Obtener Pacientes: " + e.getMessage());
            callBackObtenerPacientes.errorDesconocidoObtenerPacientes("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerPaciente(final String cedulaIdentidad) {
        try {
            final int result = sqlPaciente.verificarExistencia(cedulaIdentidad);

            switch (result) {
                case 0:
                    callBackObtenerPaciente.pacienteNoEncontrado("No se encontro el paciente en la base de datos.");
                    break;

                case 1:
                    final Paciente paciente = sqlPaciente.obtenerPaciente(cedulaIdentidad);

                    if (paciente == null) {
                        callBackObtenerPaciente.errorObtenerPaciente("Se produjo un error al obtener al paciente, vuelve a intentarlo.");
                    } else {
                        callBackObtenerPaciente.pacienteObtenido(paciente);
                    }
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistenciaPaciente("Se produjo un error al verificar la existencia del paciente, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error PresenterGestionPacientes - Obtener Paciente: " + e.getMessage());
            callBackObtenerPaciente.errorDesconocidoObtenerPaciente("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerSeguimiento(final Paciente paciente, final ExamenSolicitado examenSolicitado) {
        try {
            final List<SeguimientoPaciente> seguimientoPaciente = sqlPaciente.obtenerSeguimiento(paciente, examenSolicitado);
            
            if (seguimientoPaciente == null) {
                callBackObtenerSeguimiento.errorObtenerSeguimiento("Se produjo un error, vuelve a intentarlo.");
            } else if (seguimientoPaciente.isEmpty()) {
                callBackObtenerSeguimiento.seguimientoNoEncontrado("No se encontraron seguimientos del paciente relacionados con el examen solicitado.");
            } else {
                callBackObtenerSeguimiento.seguimientoObtenido(seguimientoPaciente);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPaciente - Obtener Seguimiento: " + e.getMessage());
            callBackObtenerSeguimiento.errorDesconocidoObtenerSeguimiento("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void obtenerSeguimientos(final Paciente paciente) {
        try {
            final List<SeguimientoPacientePersonalizado> seguimientosPacientePersonalizado = sqlPaciente.obtenerSeguimientos(paciente);
            
            if (seguimientosPacientePersonalizado == null) {
                callBackObtenerSeguimientos.errorObtenerSeguimientos("Se produjo un error, vuelve a intentarlo.");
            } else if (seguimientosPacientePersonalizado.isEmpty()) {
                callBackObtenerSeguimientos.listaSeguimientosVacias("No se encontraron seguimientos al paciente.");
            } else {
                callBackObtenerSeguimientos.seguimientosObtenido(seguimientosPacientePersonalizado);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPaciente - Obtener Seguimientos: " + e.getMessage());
            callBackObtenerSeguimientos.errorDesconocidoObtenerSeguimientos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void modificarPaciente(final Paciente paciente) {
        try {
            if (sqlPaciente.actualizar(paciente)) {
                callBackModificarPaciente.pacienteModificado("Paciente modificado correctamente.");
            } else {
                callBackModificarPaciente.errorModificarPaciente("Se produjo un error al modificar los datos del paciente.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPaciente - Modificar Paciente: " + e.getMessage());
            callBackModificarPaciente.errorDesconocidoModificarPaciente("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerHistorialClinico(final Paciente paciente) {
        try {
            final List<RecepcionPersonalizada> recepcionesPersonalizadas = sqlPaciente.obtenerHistorialClinico(paciente);

            if (recepcionesPersonalizadas == null) {
                callBackObtenerHistorialClinico.errorObtenerHistorialClinico("Se produjo un error, vuelve a intentarlo.");
            } else if (recepcionesPersonalizadas.isEmpty()) {
                callBackObtenerHistorialClinico.listaHistorialClinicoVacias("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerHistorialClinico.historialClinicoObtenido(recepcionesPersonalizadas);
            }
        } catch (final Exception e) {
            System.err.println("Error PresenterGestionPacientes - Obtener Historial Clinico: " + e.getMessage());
            callBackObtenerHistorialClinico.errorDesconocidoObtenerHistorialClinico("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerPacientes {

        void pacientesObtenidos(final List<PacientePersonalizado> pacientesPersonalizados);

        void listaPacientesVacia(final String msg);

        void errorObtenerPacientes(final String msg);

        void errorDesconocidoObtenerPacientes(final String msg);
    }
    
    public interface CallBackObtenerPaciente {

        void pacienteObtenido(final Paciente paciente);

        void pacienteNoEncontrado(final String msg);

        void errorObtenerPaciente(final String msg);

        void errorDesconocidoObtenerPaciente(final String msg);
    }
    
    public interface CallBackObtenerSeguimiento {

        void seguimientoObtenido(final List<SeguimientoPaciente> seguimientoPaciente);
        
        void seguimientoNoEncontrado (final String msg);

        void errorObtenerSeguimiento(final String msg);

        void errorDesconocidoObtenerSeguimiento(final String msg);
    }
    
    public interface CallBackObtenerSeguimientos {

        void seguimientosObtenido(final List<SeguimientoPacientePersonalizado> seguimientosPacientePersonalizado);
        
        void listaSeguimientosVacias (final String msg);

        void errorObtenerSeguimientos(final String msg);

        void errorDesconocidoObtenerSeguimientos(final String msg);
    }
    
    public interface CallBackModificarPaciente {

        void pacienteModificado(final String msg);

        void errorModificarPaciente(final String msg);

        void errorDesconocidoModificarPaciente(final String msg);
    }

    public interface CallBackVerificarExistencia {

        void pacienteExiste(final String msg);

        void errorVerificarExistenciaPaciente(final String msg);
    }
    
    public interface CallBackObtenerHistorialClinico {

        void historialClinicoObtenido(final List<RecepcionPersonalizada> recepcionesPersonalizadas);
        
        void listaHistorialClinicoVacias (final String msg);

        void errorObtenerHistorialClinico(final String msg);

        void errorDesconocidoObtenerHistorialClinico(final String msg);
    }
    
    // </editor-fold>
    
}
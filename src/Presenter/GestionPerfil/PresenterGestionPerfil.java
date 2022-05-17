package Presenter.GestionPerfil;

import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Cuenta;

/**
 *
 * @author Brynner
 */
public class PresenterGestionPerfil {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLCuenta sqlCuenta;
    
    private CallBackModificarInformacion callBackModificarInformacion;
    private CallBackVerificarExistencia callBackVerificarExistencia;
    private CallBackVerificarPasswordValido callBackVerificarPasswordValido;
    private CallBackCambiarPassword callBackCambiarPassword;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionPerfil() {
        sqlCuenta = new SQLCuenta();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public void setCallBackModificarInformacion(CallBackModificarInformacion callBackModificarInformacion) {
        this.callBackModificarInformacion = callBackModificarInformacion;
    }

    public void setCallBackVerificarExistencia(CallBackVerificarExistencia callBackVerificarExistencia) {
        this.callBackVerificarExistencia = callBackVerificarExistencia;
    }

    public void setCallBackVerificarPasswordValido(CallBackVerificarPasswordValido callBackVerificarPasswordValido) {
        this.callBackVerificarPasswordValido = callBackVerificarPasswordValido;
    }

    public void setCallBackCambiarPassword(CallBackCambiarPassword callBackCambiarPassword) {
        this.callBackCambiarPassword = callBackCambiarPassword;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">

    public void modificarInformacion(final Cuenta cuenta) {
        try {
            final int result = sqlCuenta.verificarExistencia(cuenta);

            switch (result) {
                case 0:
                    if (sqlCuenta.actualizar(cuenta)) {
                        callBackModificarInformacion.informacionModificada("Información modificada correctamente.");
                    } else {
                        callBackModificarInformacion.errorModificarInformacion("Se produjo un error al modificar la información.");
                    }
                    break;
                case 1:
                    callBackVerificarExistencia.cuentaExiste("Ya existe una cuenta asociada con el número de cédula de identidad que ingresaste.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistenciaCuenta("Se produjo un error al verificar la existencia, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPerfil - Modificar Informacion: " + e.getMessage());
            callBackModificarInformacion.errorDesconocidoModificarInformacion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void cambiarPassword(final Cuenta cuenta, final String nuevoPassword) {
        try {
            final int result = sqlCuenta.verificarPasswordValido(cuenta);

            switch (result) {
                case 0:
                    callBackVerificarPasswordValido.passwordNoValido("Contraseña actual incorrecta.");
                    break;
                    
                case 1:
                    if (sqlCuenta.cambiarPassword(cuenta, nuevoPassword)) {
                        callBackCambiarPassword.passwordCambiado("Contraseña cambiada.");
                    } else {
                        callBackCambiarPassword.errorCambiarPassword("Se produjo un error al modificar la contraseña.");
                    }
                    break;

                default:
                    callBackVerificarPasswordValido.errorVerificarPasswordValido("Se produjo un error al verificar la existencia, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPerfil - Modificar Password: " + e.getMessage());
            callBackCambiarPassword.errorDesconocidoCambiarPassword("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">

    public interface CallBackVerificarExistencia {

        void cuentaExiste(final String msg);

        void errorVerificarExistenciaCuenta(final String msg);
    }

    public interface CallBackModificarInformacion {

        void informacionModificada(final String msg);

        void errorModificarInformacion(final String msg);

        void errorDesconocidoModificarInformacion(final String msg);
    }
    
    public interface CallBackVerificarPasswordValido {
        
        void passwordNoValido(final String msg);
        
        void errorVerificarPasswordValido(final String msg);
    }
    
    public interface CallBackCambiarPassword {
        
        void passwordCambiado(final String msg);
        
        void errorCambiarPassword(final String msg);
        
        void errorDesconocidoCambiarPassword(final String msg);
        
    }

    // </editor-fold>
    
}
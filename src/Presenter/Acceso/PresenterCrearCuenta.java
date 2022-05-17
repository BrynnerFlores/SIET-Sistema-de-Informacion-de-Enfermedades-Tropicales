package Presenter.Acceso;

import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Cuenta;

/**
 *
 * @author Brynner
 */
public class PresenterCrearCuenta {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLCuenta sqlCuenta;
    
    private CallBackVerificarExistencia callBackVerificarExistencia;
    private CallBackCrearCuenta callBackCrearCuenta;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterCrearCuenta() {
        sqlCuenta = new SQLCuenta();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackVerificarExistencia(CallBackVerificarExistencia callBackVerificarExistencia) {
        this.callBackVerificarExistencia = callBackVerificarExistencia;
    }

    public void setCallBackCrearCuenta(CallBackCrearCuenta callBackCrearCuenta) {
        this.callBackCrearCuenta = callBackCrearCuenta;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void crearCuenta(final Cuenta cuenta, final boolean mantenerSesionIniciada) {
        try {
            final int result = sqlCuenta.verificarExistencia(cuenta);

            switch (result) {
                case 0:
                    if (sqlCuenta.insertar(cuenta)) {
                        callBackCrearCuenta.cuentaCreada("Cuenta Creada. Debes iniciar sesión para ingresar el sistema.");
                    } else {
                        callBackCrearCuenta.errorCrearCuenta("Se produjo un error al crear la cuenta, vuelve a intentarlo.");
                    }
                    break;

                case 1:
                    callBackVerificarExistencia.cuentaExiste("Tu número de cédula de identidad ya se encuentra asociada a otra cuenta.");
                    break;

                default:
                    callBackVerificarExistencia.errorVerificarExistenciaCuenta("Se produjo un error al verificar si alguna cuenta ya tiene asociado tu número de cédula de identidad.");
                    break;
            }
        } catch (final Exception e) {
            System.out.print("Error Presenter Crear Cuenta - Crear Cuenta: " + e.getMessage());
            callBackCrearCuenta.errorDesconocidoCrearCuenta("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackVerificarExistencia {

        void cuentaExiste(final String msg);

        void errorVerificarExistenciaCuenta(final String msg);
    }

    public interface CallBackCrearCuenta {

        void cuentaCreada(final String msg);

        void errorCrearCuenta(final String msg);

        void errorDesconocidoCrearCuenta(final String msg);
    }

    // </editor-fold>
    
}
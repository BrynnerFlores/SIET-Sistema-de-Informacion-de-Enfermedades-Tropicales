package Presenter.GestionPersonalTecnico;

import Model.DAO.GestionPersonalTecnico.SQLPersonalTecnico;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.PersonalTecnico;
import Model.POJO.Cuenta;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionPersonalTecnico {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLCuenta sqlCuenta;
    private final SQLPersonalTecnico sqlPersonalTecnico;

    private CallBackObtenerCuentasPersonalesTecnicosHabilitados callBackObtenerCuentasPersonalesTecnicosHabilitados;
    private CallBackObtenerCuentasPersonalesTecnicosInhabilitados callBackObtenerCuentasPersonalesTecnicosInhabilitados;
    private CallBackObtenerPersonalesTecnicos callBackObtenerPersonalesTecnicos;
    private CallBackReestablecerPassword callBackReestablecerPassword;
    private CallBackEliminarPersonalTecnico callBackEliminarPersonalTecnico;
    private CallBackAgregarPersonalTecnico callBackAgregarPersonalTecnico;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionPersonalTecnico() {
        sqlCuenta = new SQLCuenta();
        sqlPersonalTecnico = new SQLPersonalTecnico();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    
    public void setCallBackObtenerCuentasPersonalesTecnicosHabilitados(CallBackObtenerCuentasPersonalesTecnicosHabilitados callBackObtenerCuentasPersonalesTecnicosHabilitados) {
        this.callBackObtenerCuentasPersonalesTecnicosHabilitados = callBackObtenerCuentasPersonalesTecnicosHabilitados;
    }

    public void setCallBackObtenerCuentasPersonalesTecnicosInhabilitados(CallBackObtenerCuentasPersonalesTecnicosInhabilitados callBackObtenerCuentasPersonalesTecnicosInhabilitados) {
        this.callBackObtenerCuentasPersonalesTecnicosInhabilitados = callBackObtenerCuentasPersonalesTecnicosInhabilitados;
    }

    public void setCallBackObtenerPersonalesTecnicos(CallBackObtenerPersonalesTecnicos callBackObtenerPersonalesTecnicos) {
        this.callBackObtenerPersonalesTecnicos = callBackObtenerPersonalesTecnicos;
    }

    public void setCallBackReestablecerPassword(CallBackReestablecerPassword callBackReestablecerPassword) {
        this.callBackReestablecerPassword = callBackReestablecerPassword;
    }

    public void setCallBackEliminarPersonalTecnico(CallBackEliminarPersonalTecnico callBackEliminarPersonalTecnico) {
        this.callBackEliminarPersonalTecnico = callBackEliminarPersonalTecnico;
    }
    
    public void setCallBackAgregarPersonalTecnico(CallBackAgregarPersonalTecnico callBackAgregarPersonalTecnico) {    
        this.callBackAgregarPersonalTecnico = callBackAgregarPersonalTecnico;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerCuentasPersonalesTecnicosHabilitados(final Cuenta cuenta) {
        try {
            final List<Cuenta> cuentasPersonalesTecnicosHabilitados = sqlCuenta.obtenerCuentasPersonalesTecnicosHabilitados(cuenta);

            if (cuentasPersonalesTecnicosHabilitados == null) {
                callBackObtenerCuentasPersonalesTecnicosHabilitados.errorObtenerCuentasPersonalesTecnicosHabilitados("Se produjo un error, vuelve a intentarlo.");
            } else if (cuentasPersonalesTecnicosHabilitados.isEmpty()) {
                callBackObtenerCuentasPersonalesTecnicosHabilitados.listaCuentasPersonalesTecnicosHabilitadosVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerCuentasPersonalesTecnicosHabilitados.cuentasPersonalesTecnicosHabilitadosObtenidos(cuentasPersonalesTecnicosHabilitados);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionPersonalTecnico - Obtener Cuentas Personales Tecnicos Habilitados: " + e.getMessage());
            callBackObtenerCuentasPersonalesTecnicosHabilitados.errorDesconocidoObtenerCuentasPersonalesTecnicosHabilitados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerCuentasPersonalesTecnicosInhabilitados() {
        try {
            final List<Cuenta> cuentasPersonalesTecnicosInhabilitados = sqlCuenta.obtenerCuentasPersonalesTecnicosInhabilitados();

            if (cuentasPersonalesTecnicosInhabilitados == null) {
                callBackObtenerCuentasPersonalesTecnicosInhabilitados.errorObtenerCuentasPersonalesTecnicosInhabilitados("Se produjo un error, vuelve a intentarlo.");
            } else if (cuentasPersonalesTecnicosInhabilitados.isEmpty()) {
                callBackObtenerCuentasPersonalesTecnicosInhabilitados.listaCuentasPersonalesTecnicosInhabilitadosVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerCuentasPersonalesTecnicosInhabilitados.cuentasPersonalesTecnicosInhabilitadosObtenidos(cuentasPersonalesTecnicosInhabilitados);
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionPersonalTecnico - Obtener Cuentas Personales Tecnicos Inhabilitados: " + e.getMessage());
            callBackObtenerCuentasPersonalesTecnicosInhabilitados.errorDesconocidoObtenerCuentasPersonalesTecnicosInhabilitados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerPersonalesTecnicos() {
        try {
            final List<PersonalTecnico> personalesTecnicos = sqlPersonalTecnico.obtenerPersonalTecnico();

            if (personalesTecnicos == null) {
                callBackObtenerPersonalesTecnicos.errorObtenerPersonalesTecnicos("Se produjo un error, vuelve a intentarlo.");
            } else if (personalesTecnicos.isEmpty()) {
                callBackObtenerPersonalesTecnicos.listaPersonalesTecnicosVacia("No se encontraron registros en la base de datos.");
            } else {
                callBackObtenerPersonalesTecnicos.personalesTecnicosObtenidos(personalesTecnicos);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionPersonalTecnico - Obtener Personal Tecnico: " + e.getMessage());
            callBackObtenerPersonalesTecnicos.errorDesconocidoObtenerPersonalesTecnicos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void reestablecerPassword(final Cuenta cuenta) {
        try {
            final String nuevoPassword = generarNuevoPassword(5);
            final boolean result = sqlCuenta.cambiarPassword(cuenta, nuevoPassword);

            if (result) {
                callBackReestablecerPassword.passwordReestablecido("Contraseña Reestablecida.\nLa nueva contraseña es:\n" + nuevoPassword);
            } else {
                callBackReestablecerPassword.errorReestablecerPassword("Se produjo un error al reestablecer la contraseña.\nVuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionBioquimicos - Reestablecer Password " + e.getMessage());
            callBackReestablecerPassword.errorDesconocidoReestablecerPassword("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void eliminarPersonalTecnico(final Cuenta cuenta) {
        try {
            if (sqlCuenta.eliminar(cuenta)) {
                callBackEliminarPersonalTecnico.personalTecnicoEliminado();
            } else {
                callBackEliminarPersonalTecnico.errorEliminarPersonalTecnico("Se produjo un error al eliminar, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.out.print("PresenterGestionPersonalTecnico - Eliminar Personal Tecnico: " + e.getMessage());
            callBackEliminarPersonalTecnico.errorDesconocidoEliminarPersonalTecnico("Se produjo un error desconocido, vuelve a intentarlo.\nSi el problema persiste contactate con el desarrollador.");
        }
    }

    public void agregarPersonalTecnico(final PersonalTecnico personalTecnico) {
        try {
            if (sqlPersonalTecnico.habilitar(personalTecnico)) {
                callBackAgregarPersonalTecnico.personalTecnicoAgregado("Agregado correctamente.");
            } else {
                callBackAgregarPersonalTecnico.errorAgregarPersonalTecnico("Se produjo un error, vuelve a intentarlo.");
            }
        } catch (final Exception e) {
            System.err.println("PresenterGestionPersonalTecnico - Agregar Personal Tecnico: " + e.getMessage());
            callBackAgregarPersonalTecnico.errorDesconocidoAgregarPersonalTecnico("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    private String generarNuevoPassword(final int length) {
        final String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        final StringBuilder sb = new StringBuilder(length); 
  
        for (int i = 0; i < length; i++) { 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
            sb.append(AlphaNumericString .charAt(index)); 
        } 
        return sb.toString();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerCuentasPersonalesTecnicosHabilitados {

        void cuentasPersonalesTecnicosHabilitadosObtenidos(final List<Cuenta> cuentas);

        void listaCuentasPersonalesTecnicosHabilitadosVacia(final String msg);

        void errorObtenerCuentasPersonalesTecnicosHabilitados(final String msg);

        void errorDesconocidoObtenerCuentasPersonalesTecnicosHabilitados(final String msg);
    }

    public interface CallBackObtenerCuentasPersonalesTecnicosInhabilitados {

        void cuentasPersonalesTecnicosInhabilitadosObtenidos(final List<Cuenta> cuentas);

        void listaCuentasPersonalesTecnicosInhabilitadosVacia(final String msg);

        void errorObtenerCuentasPersonalesTecnicosInhabilitados(final String msg);

        void errorDesconocidoObtenerCuentasPersonalesTecnicosInhabilitados(final String msg);
    }

    public interface CallBackObtenerPersonalesTecnicos {

        void personalesTecnicosObtenidos(final List<PersonalTecnico> personalesTecnicos);

        void listaPersonalesTecnicosVacia(final String msg);

        void errorObtenerPersonalesTecnicos(final String msg);

        void errorDesconocidoObtenerPersonalesTecnicos(final String msg);
    }

    public interface CallBackReestablecerPassword {

        void passwordReestablecido(final String msg);

        void errorReestablecerPassword(final String msg);

        void errorDesconocidoReestablecerPassword(final String msg);
    }

    public interface CallBackAgregarPersonalTecnico {

        void personalTecnicoAgregado(final String msg);

        void errorAgregarPersonalTecnico(final String msg);

        void errorDesconocidoAgregarPersonalTecnico(final String msg);
    }

    public interface CallBackEliminarPersonalTecnico {

        void personalTecnicoEliminado();

        void errorEliminarPersonalTecnico(final String msg);

        void errorDesconocidoEliminarPersonalTecnico(final String msg);
    }

    // </editor-fold>
    
}
package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class Cuenta {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoCuenta;
    private PersonalTecnico personalTecnico;
    private String cuentaClave;
    private String cuentaRol;
    private Date cuentaFechaRegistro;
    private Time cuentaHoraRegistro;
    private int cuentaEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public Cuenta(int codigoCuenta, PersonalTecnico personalTecnico, String cuentaClave, String cuentaRol, Date cuentaFechaRegistro, Time cuentaHoraRegistro, int cuentaEstado) {
        this.codigoCuenta = codigoCuenta;
        this.personalTecnico = personalTecnico;
        this.cuentaClave = cuentaClave;
        this.cuentaRol = cuentaRol;
        this.cuentaFechaRegistro = cuentaFechaRegistro;
        this.cuentaHoraRegistro = cuentaHoraRegistro;
        this.cuentaEstado = cuentaEstado;
    }
    
    public Cuenta(PersonalTecnico personalTecnico, String cuentaClave, String cuentaRol, int cuentaEstado) {
        this.personalTecnico = personalTecnico;
        this.cuentaClave = cuentaClave;
        this.cuentaRol = cuentaRol;
        this.cuentaEstado = cuentaEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public PersonalTecnico getPersonalTecnico() {
        return personalTecnico;
    }

    public void setPersonalTecnico(PersonalTecnico personalTecnico) {
        this.personalTecnico = personalTecnico;
    }

    public String getCuentaClave() {
        return cuentaClave;
    }

    public void setCuentaClave(String cuentaClave) {
        this.cuentaClave = cuentaClave;
    }

    public String getCuentaRol() {
        return cuentaRol;
    }

    public void setCuentaRol(String cuentaRol) {
        this.cuentaRol = cuentaRol;
    }

    public Date getCuentaFechaRegistro() {
        return cuentaFechaRegistro;
    }

    public void setCuentaFechaRegistro(Date cuentaFechaRegistro) {
        this.cuentaFechaRegistro = cuentaFechaRegistro;
    }

    public Time getCuentaHoraRegistro() {
        return cuentaHoraRegistro;
    }

    public void setCuentaHoraRegistro(Time cuentaHoraRegistro) {
        this.cuentaHoraRegistro = cuentaHoraRegistro;
    }

    public int getCuentaEstado() {
        return cuentaEstado;
    }

    public void setCuentaEstado(int cuentaEstado) {
        this.cuentaEstado = cuentaEstado;
    }
    
    // </editor-fold>
    
}
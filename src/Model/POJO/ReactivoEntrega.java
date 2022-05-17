package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class ReactivoEntrega {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEntrega;
    private PersonalTecnico personalTecnico;
    private String proveedor;
    private Date fechaEntrega;
    private Time horaEntrega;
    private String observaciones;
    private int estado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ReactivoEntrega(int codigoEntrega, PersonalTecnico personalTecnico, String proveedor, Date fechaEntrega, Time horaEntrega, String observaciones, int estado) {
        this.codigoEntrega = codigoEntrega;
        this.personalTecnico = personalTecnico;
        this.proveedor = proveedor;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    
    public ReactivoEntrega(PersonalTecnico personalTecnico, String proveedor, Date fechaEntrega, Time horaEntrega, String observaciones, int estado) {
        this.personalTecnico = personalTecnico;
        this.proveedor = proveedor;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEntrega() {
        return codigoEntrega;
    }

    public void setCodigoEntrega(int codigoEntrega) {
        this.codigoEntrega = codigoEntrega;
    }

    public PersonalTecnico getPersonalTecnico() {
        return personalTecnico;
    }

    public void setPersonalTecnico(PersonalTecnico personalTecnico) {
        this.personalTecnico = personalTecnico;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    // </editor-fold>
    
}
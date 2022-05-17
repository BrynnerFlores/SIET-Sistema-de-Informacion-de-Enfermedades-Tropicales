package Model.POJO;

import java.sql.Date;

/**
 *
 * @author Brynner
 */
public class ReactivoLote {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoLote;
    private ReactivoEntrega reactivoEntrega;
    private Reactivo reactivo;
    private String numeroLote;
    private String presentacion;
    private String almacenamiento;
    private String ubicacion;
    private int totalUnidades;
    private String marcaReactivo;
    private Date fechaVencimiento;
    private String observaciones;
    private String estadoConsumo;
    private int estado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ReactivoLote(int codigoLote, ReactivoEntrega reactivoEntrega, Reactivo reactivo, String numeroLote, String presentacion, String almacenamiento, String ubicacion, int totalUnidades, String marcaReactivo, Date fechaVencimiento, String observaciones, String estadoConsumo, int estado) {
        this.codigoLote = codigoLote;
        this.reactivoEntrega = reactivoEntrega;
        this.reactivo = reactivo;
        this.numeroLote = numeroLote;
        this.presentacion = presentacion;
        this.almacenamiento = almacenamiento;
        this.ubicacion = ubicacion;
        this.totalUnidades = totalUnidades;
        this.marcaReactivo = marcaReactivo;
        this.fechaVencimiento = fechaVencimiento;
        this.observaciones = observaciones;
        this.estadoConsumo = estadoConsumo;
        this.estado = estado;
    }
        
    public ReactivoLote(ReactivoEntrega reactivoEntrega, Reactivo reactivo, String numeroLote, String presentacion, String almacenamiento, String ubicacion, int totalUnidades, String marcaReactivo, Date fechaVencimiento, String observaciones, String estadoConsumo, int estado) {
        this.reactivoEntrega = reactivoEntrega;
        this.reactivo = reactivo;
        this.numeroLote = numeroLote;
        this.presentacion = presentacion;
        this.almacenamiento = almacenamiento;
        this.ubicacion = ubicacion;
        this.totalUnidades = totalUnidades;
        this.marcaReactivo = marcaReactivo;
        this.fechaVencimiento = fechaVencimiento;
        this.observaciones = observaciones;
        this.estadoConsumo = estadoConsumo;
        this.estado = estado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(int codigoLote) {
        this.codigoLote = codigoLote;
    }

    public ReactivoEntrega getReactivoEntrega() {
        return reactivoEntrega;
    }

    public void setReactivoEntrega(ReactivoEntrega reactivoEntrega) {
        this.reactivoEntrega = reactivoEntrega;
    }

    public Reactivo getReactivo() {
        return reactivo;
    }

    public void setReactivo(Reactivo reactivo) {
        this.reactivo = reactivo;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(int totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

    public String getMarcaReactivo() {
        return marcaReactivo;
    }

    public void setMarcaReactivo(String marcaReactivo) {
        this.marcaReactivo = marcaReactivo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstadoConsumo() {
        return estadoConsumo;
    }

    public void setEstadoConsumo(String estadoConsumo) {
        this.estadoConsumo = estadoConsumo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    // </editor-fold>
    
}
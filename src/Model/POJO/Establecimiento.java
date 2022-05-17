package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Establecimiento {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEstablecimiento;
    private String establecimientoNombre;
    private String establecimientoTipo;
    private String establecimientoArea;
    private int establecimientoEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Establecimiento(int codigoEstablecimiento, String establecimientoNombre, String establecimientoTipo, String establecimientoArea, int establecimientoEstado) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.establecimientoNombre = establecimientoNombre;
        this.establecimientoTipo = establecimientoTipo;
        this.establecimientoArea = establecimientoArea;
        this.establecimientoEstado = establecimientoEstado;
    }

    public Establecimiento(String establecimientoNombre, String establecimientoTipo, String establecimientoArea, int establecimientoEstado) {
        this.establecimientoNombre = establecimientoNombre;
        this.establecimientoTipo = establecimientoTipo;
        this.establecimientoArea = establecimientoArea;
        this.establecimientoEstado = establecimientoEstado;
    }
    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(int codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getEstablecimientoNombre() {
        return establecimientoNombre;
    }

    public void setEstablecimientoNombre(String establecimientoNombre) {
        this.establecimientoNombre = establecimientoNombre;
    }

    public String getEstablecimientoTipo() {
        return establecimientoTipo;
    }

    public void setEstablecimientoTipo(String establecimientoTipo) {
        this.establecimientoTipo = establecimientoTipo;
    }

    public String getEstablecimientoArea() {
        return establecimientoArea;
    }

    public void setEstablecimientoArea(String establecimientoArea) {
        this.establecimientoArea = establecimientoArea;
    }

    public int getEstablecimientoEstado() {
        return establecimientoEstado;
    }
    
    public void setEstablecimientoEstado(int establecimientoEstado) {    
        this.establecimientoEstado = establecimientoEstado;
    }
    
    // </editor-fold>
    
}
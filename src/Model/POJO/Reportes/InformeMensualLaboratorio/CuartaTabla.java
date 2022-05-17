package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class CuartaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int frotis;
    private int cultivo;
    private int idmr;
    private int ifi;
    private int elisa;
    private int pcr;
    private int otras;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public CuartaTabla(int frotis, int cultivo, int idmr, int ifi, int elisa, int pcr, int otras) {
        this.frotis = frotis;
        this.cultivo = cultivo;
        this.idmr = idmr;
        this.ifi = ifi;
        this.elisa = elisa;
        this.pcr = pcr;
        this.otras = otras;
    }
    
    public CuartaTabla() {
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getFrotis() {
        return frotis;
    }

    public void setFrotis(int frotis) {
        this.frotis = frotis;
    }

    public int getCultivo() {
        return cultivo;
    }

    public void setCultivo(int cultivo) {
        this.cultivo = cultivo;
    }

    public int getIdmr() {
        return idmr;
    }

    public void setIdmr(int idmr) {
        this.idmr = idmr;
    }

    public int getIfi() {
        return ifi;
    }

    public void setIfi(int ifi) {
        this.ifi = ifi;
    }

    public int getElisa() {
        return elisa;
    }

    public void setElisa(int elisa) {
        this.elisa = elisa;
    }

    public int getPcr() {
        return pcr;
    }

    public void setPcr(int pcr) {
        this.pcr = pcr;
    }

    public int getOtras() {
        return otras;
    }

    public void setOtras(int otras) {
        this.otras = otras;
    }
    
    // </editor-fold>
    
}
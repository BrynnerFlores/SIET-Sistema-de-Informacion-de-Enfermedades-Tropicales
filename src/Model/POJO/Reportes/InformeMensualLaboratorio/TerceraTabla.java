package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class TerceraTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int micrometodoParasitologico;
    private int otrosParasitologico;
    private int icSerologico;
    private int haiSerologico;
    private int elisaSerologico;
    private int ifiSerologico;
    private int otrosSerologico;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public TerceraTabla(int micrometodoParasitologico, int otrosParasitologico, int icSerologico, int haiSerologico, int elisaSerologico, int ifiSerologico, int otrosSerologico) {
        this.micrometodoParasitologico = micrometodoParasitologico;
        this.otrosParasitologico = otrosParasitologico;
        this.icSerologico = icSerologico;
        this.haiSerologico = haiSerologico;
        this.elisaSerologico = elisaSerologico;
        this.ifiSerologico = ifiSerologico;
        this.otrosSerologico = otrosSerologico;
    }
    
    public TerceraTabla() {
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public int getMicrometodoParasitologico() {
        return micrometodoParasitologico;
    }

    public void setMicrometodoParasitologico(int micrometodoParasitologico) {
        this.micrometodoParasitologico = micrometodoParasitologico;
    }

    public int getOtrosParasitologico() {
        return otrosParasitologico;
    }

    public void setOtrosParasitologico(int otrosParasitologico) {
        this.otrosParasitologico = otrosParasitologico;
    }

    public int getIcSerologico() {
        return icSerologico;
    }

    public void setIcSerologico(int icSerologico) {
        this.icSerologico = icSerologico;
    }

    public int getHaiSerologico() {
        return haiSerologico;
    }

    public void setHaiSerologico(int haiSerologico) {
        this.haiSerologico = haiSerologico;
    }

    public int getElisaSerologico() {
        return elisaSerologico;
    }

    public void setElisaSerologico(int elisaSerologico) {
        this.elisaSerologico = elisaSerologico;
    }

    public int getIfiSerologico() {
        return ifiSerologico;
    }

    public void setIfiSerologico(int ifiSerologico) {
        this.ifiSerologico = ifiSerologico;
    }

    public int getOtrosSerologico() {
        return otrosSerologico;
    }

    public void setOtrosSerologico(int otrosSerologico) {
        this.otrosSerologico = otrosSerologico;
    }
    
    // </editor-fold>
    
}
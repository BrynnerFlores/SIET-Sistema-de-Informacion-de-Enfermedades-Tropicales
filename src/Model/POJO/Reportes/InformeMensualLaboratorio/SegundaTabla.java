package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class SegundaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int sangreSuero;
    private int hecesFecales;
    private int esputo;
    private int orina;
    private int secrecion;
    private int liquidoBiologico;
    private int otras;
    private int total;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SegundaTabla(int sangreSuero, int hecesFecales, int esputo, int orina, int secrecion, int liquidoBiologico, int otras, int total) {
        this.sangreSuero = sangreSuero;
        this.hecesFecales = hecesFecales;
        this.esputo = esputo;
        this.orina = orina;
        this.secrecion = secrecion;
        this.liquidoBiologico = liquidoBiologico;
        this.otras = otras;
        this.total = total;
    }

    public SegundaTabla() {
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public int getSangreSuero() {
        return sangreSuero;
    }

    public void setSangreSuero(int sangreSuero) {
        this.sangreSuero = sangreSuero;
    }

    public int getHecesFecales() {
        return hecesFecales;
    }

    public void setHecesFecales(int hecesFecales) {
        this.hecesFecales = hecesFecales;
    }

    public int getEsputo() {
        return esputo;
    }

    public void setEsputo(int esputo) {
        this.esputo = esputo;
    }

    public int getOrina() {
        return orina;
    }

    public void setOrina(int orina) {
        this.orina = orina;
    }

    public int getSecrecion() {
        return secrecion;
    }

    public void setSecrecion(int secrecion) {
        this.secrecion = secrecion;
    }

    public int getLiquidoBiologico() {
        return liquidoBiologico;
    }

    public void setLiquidoBiologico(int liquidoBiologico) {
        this.liquidoBiologico = liquidoBiologico;
    }

    public int getOtras() {
        return otras;
    }

    public void setOtras(int otras) {
        this.otras = otras;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    // </editor-fold>
    
}
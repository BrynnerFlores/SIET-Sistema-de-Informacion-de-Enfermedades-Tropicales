package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class QuintaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int pruebaRapida;
    private int elisa;
    private int westernBlott;
    private int cargaViral;
    private int subpoblacionesLinfocitarias;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public QuintaTabla(int pruebaRapida, int elisa, int westernBlott, int cargaViral, int subpoblacionesLinfocitarias) {
        this.pruebaRapida = pruebaRapida;
        this.elisa = elisa;
        this.westernBlott = westernBlott;
        this.cargaViral = cargaViral;
        this.subpoblacionesLinfocitarias = subpoblacionesLinfocitarias;
    }
    
    public QuintaTabla() {
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getPruebaRapida() {
        return pruebaRapida;
    }

    public void setPruebaRapida(int pruebaRapida) {
        this.pruebaRapida = pruebaRapida;
    }

    public int getElisa() {
        return elisa;
    }

    public void setElisa(int elisa) {
        this.elisa = elisa;
    }

    public int getWesternBlott() {
        return westernBlott;
    }

    public void setWesternBlott(int westernBlott) {
        this.westernBlott = westernBlott;
    }

    public int getCargaViral() {
        return cargaViral;
    }

    public void setCargaViral(int cargaViral) {
        this.cargaViral = cargaViral;
    }

    public int getSubpoblacionesLinfocitarias() {
        return subpoblacionesLinfocitarias;
    }

    public void setSubpoblacionesLinfocitarias(int subpoblacionesLinfocitarias) {
        this.subpoblacionesLinfocitarias = subpoblacionesLinfocitarias;
    }
    
    // </editor-fold>
    
}
package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class SeptimaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int muestrasProcesadas;
    private int inadecuadas;
    private int negativas;
    private int positivas;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SeptimaTabla(int muestrasProcesadas, int inadecuadas, int negativas, int positivas) {
        this.muestrasProcesadas = muestrasProcesadas;
        this.inadecuadas = inadecuadas;
        this.negativas = negativas;
        this.positivas = positivas;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getMuestrasProcesadas() {
        return muestrasProcesadas;
    }

    public void setMuestrasProcesadas(int muestrasProcesadas) {
        this.muestrasProcesadas = muestrasProcesadas;
    }

    public int getInadecuadas() {
        return inadecuadas;
    }

    public void setInadecuadas(int inadecuadas) {
        this.inadecuadas = inadecuadas;
    }

    public int getNegativas() {
        return negativas;
    }

    public void setNegativas(int negativas) {
        this.negativas = negativas;
    }

    public int getPositivas() {
        return positivas;
    }

    public void setPositivas(int positivas) {
        this.positivas = positivas;
    }
    
    // </editor-fold>
    
}
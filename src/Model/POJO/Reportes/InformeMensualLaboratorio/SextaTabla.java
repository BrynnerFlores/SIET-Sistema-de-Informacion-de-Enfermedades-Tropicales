package Model.POJO.Reportes.InformeMensualLaboratorio;

/**
 *
 * @author Brynner
 */
public class SextaTabla {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int muestrasProcesadas;
    private int negativos;
    private int positivos;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SextaTabla(int muestrasProcesadas, int negativos, int positivos) {
        this.muestrasProcesadas = muestrasProcesadas;
        this.negativos = negativos;
        this.positivos = positivos;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getMuestrasProcesadas() {
        return muestrasProcesadas;
    }

    public void setMuestrasProcesadas(int muestrasProcesadas) {
        this.muestrasProcesadas = muestrasProcesadas;
    }

    public int getNegativos() {
        return negativos;
    }

    public void setNegativos(int negativos) {
        this.negativos = negativos;
    }

    public int getPositivos() {
        return positivos;
    }

    public void setPositivos(int positivos) {
        this.positivos = positivos;
    }

    // </editor-fold>
    
}
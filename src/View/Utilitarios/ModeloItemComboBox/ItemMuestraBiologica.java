package View.Utilitarios.ModeloItemComboBox;

/**
 *
 * @author Brynner
 */
public class ItemMuestraBiologica {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoMuestraBiologica;
    private String muestraBiologicaNombre;
    private int muestraBiologicaEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ItemMuestraBiologica(int codigoMuestraBiologica, String muestraBiologicaNombre, int muestraBiologicaEstado) {
        this.codigoMuestraBiologica = codigoMuestraBiologica;
        this.muestraBiologicaNombre = muestraBiologicaNombre;
        this.muestraBiologicaEstado = muestraBiologicaEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public int getCodigoMuestraBiologica() {
        return codigoMuestraBiologica;
    }

    public String getMuestraBiologicaNombre() {
        return muestraBiologicaNombre;
    }

    public int getMuestraBiologicaEstado() {
        return muestraBiologicaEstado;
    }
    
    // </editor-fold>

    @Override
    public String toString() {
        return getMuestraBiologicaNombre();
    }   
}
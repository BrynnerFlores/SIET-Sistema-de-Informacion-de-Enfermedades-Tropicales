package Model.POJO.Reportes.Reactivos;

/**
 *
 * @author Brynner
 */
public class ReactivosInforme {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int index;
    private String reactivoNombre;
    private int reactivoTotalLotesDisponibles;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ReactivosInforme(int index, String reactivoNombre, int reactivoTotalLotesDisponibles) {
        this.index = index;
        this.reactivoNombre = reactivoNombre;
        this.reactivoTotalLotesDisponibles = reactivoTotalLotesDisponibles;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getIndex() {
        return index;
    }

    public String getReactivoNombre() {
        return reactivoNombre;
    }

    public int getReactivoTotalLotesDisponibles() {
        return reactivoTotalLotesDisponibles;
    }
    
    // </editor-fold>
    
}
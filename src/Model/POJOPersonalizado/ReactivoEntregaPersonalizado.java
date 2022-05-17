package Model.POJOPersonalizado;

import Model.POJO.ReactivoEntrega;

/**
 *
 * @author Brynner
 */
public class ReactivoEntregaPersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private ReactivoEntrega reactivoEntrega;
    private int totalLotes;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ReactivoEntregaPersonalizado(ReactivoEntrega reactivoEntrega, int totalLotes) {
        this.reactivoEntrega = reactivoEntrega;
        this.totalLotes = totalLotes;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public ReactivoEntrega getReactivoEntrega() {
        return reactivoEntrega;
    }

    public int getTotalLotes() {
        return totalLotes;
    }

    // </editor-fold>
    
}
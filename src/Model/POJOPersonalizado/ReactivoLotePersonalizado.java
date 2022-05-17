package Model.POJOPersonalizado;

import Model.POJO.*;

/**
 *
 * @author Brynner
 */
public class ReactivoLotePersonalizado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private ReactivoLote reactivoLote;
    private int saldo;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ReactivoLotePersonalizado(ReactivoLote reactivoLote, int saldo) {
        this.reactivoLote = reactivoLote;
        this.saldo = saldo;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public ReactivoLote getReactivoLote() {
        return reactivoLote;
    }

    public int getSaldo() {
        return saldo;
    }
    
    // </editor-fold>
    
}
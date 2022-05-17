package Model.POJOPersonalizado;

import Model.POJO.*;

/**
 *
 * @author Brynner
 */
public class ReactivoPersonalizado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private Reactivo reactivo;
    private int saldo;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ReactivoPersonalizado(Reactivo reactivo, int saldo) {
        this.reactivo = reactivo;
        this.saldo = saldo;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public Reactivo getReactivo() {
        return reactivo;
    }

    public int getSaldo() {
        return saldo;
    }
    
    // </editor-fold>
    
}
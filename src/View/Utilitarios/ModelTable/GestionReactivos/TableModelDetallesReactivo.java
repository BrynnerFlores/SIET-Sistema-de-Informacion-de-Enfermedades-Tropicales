package View.Utilitarios.ModelTable.GestionReactivos;

import Model.POJO.ReactivoLote;
import Model.POJOPersonalizado.ReactivoLotePersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brynn
 */
public class TableModelDetallesReactivo extends AbstractTableModel {

    private final String[] columnas = {"Nº", "LOTE", "PRESENTACION", "ALMACENAMIENTO", "UBICACION", "MARCA", "FEC. VENCIMIENTO", "# UNIDADES", "# SALDO", "COD ENTREGA", "ESTADO"};
    private List<ReactivoLotePersonalizado> reactivosLotesPersonalizados;

    public void setReactivosLotesPersonalizados(List<ReactivoLotePersonalizado> reactivosLotesPersonalizados) {
        this.reactivosLotesPersonalizados = reactivosLotesPersonalizados;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (reactivosLotesPersonalizados != null) {
            reactivosLotesPersonalizados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return reactivosLotesPersonalizados == null ? 0 : reactivosLotesPersonalizados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        final ReactivoLotePersonalizado reactivoLotePersonalizado = reactivosLotesPersonalizados.get(rowIndex);
        final ReactivoLote reactivoLote = reactivoLotePersonalizado.getReactivoLote();

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return reactivoLote.getNumeroLote();

            case 2:
                return reactivoLote.getPresentacion();

            case 3:
                return reactivoLote.getAlmacenamiento();

            case 4:
                return reactivoLote.getUbicacion();

            case 5:
                return reactivoLote.getMarcaReactivo();

            case 6:
                return reactivoLote.getFechaVencimiento();

            case 7:
                return reactivoLote.getTotalUnidades();
                
            case 8:
                return reactivoLotePersonalizado.getSaldo();
                
            case 9:
                return reactivoLote.getReactivoEntrega().getCodigoEntrega();
                
            case 10:
                switch (reactivoLote.getEstadoConsumo()) {
                    case "EN ALMACEN":
                        return "EN ALMACEN";

                    case "EN CONSUMO":
                        return "EN CONSUMO";
                        
                    case "AGOTADO":
                        return "AGOTADO";
                        
                    default:
                        return "VENCIDO";
                }

            default:
                return null;
        }
    }
    
    public ReactivoLotePersonalizado getReactivoLotePersonalizado(final int rowIndex) {
        return reactivosLotesPersonalizados.get(rowIndex);
    }
}
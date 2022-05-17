package View.Utilitarios.ModelTable.GestionReactivos;

import Model.POJO.LoteEliminado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelLotesEliminados extends AbstractTableModel {

    private final String[] columnas = {"Nº", "REACTIVO", "CAUSA DE ELIMINACION", "FECHA ELIMINACION", "HORA ELIMINACION"};
    private List<LoteEliminado> lotesEliminados;

    public void setLotesEliminados(List<LoteEliminado> lotesEliminados) {
        this.lotesEliminados = lotesEliminados;
    }
    
    public void limpiarLista() {
        if (lotesEliminados != null) {
            lotesEliminados.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return lotesEliminados == null ? 0 : lotesEliminados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        final LoteEliminado loteEliminado = lotesEliminados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
                
            case 1:
                return loteEliminado.getReactivoLote().getReactivo().getNombre();

            case 2:
                return loteEliminado.getCausaEliminacion();

            case 3:
                return loteEliminado.getFechaEliminacion();

            case 4:
                return loteEliminado.getHoraEliminacion();

            default:
                return null;
        }
    }
    
    public LoteEliminado getLoteEliminado(final int rowIndex) {
        return lotesEliminados.get(rowIndex);
    }
}
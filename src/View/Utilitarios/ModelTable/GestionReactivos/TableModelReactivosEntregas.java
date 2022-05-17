package View.Utilitarios.ModelTable.GestionReactivos;

import Model.POJO.ReactivoEntrega;
import Model.POJOPersonalizado.ReactivoEntregaPersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelReactivosEntregas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "RECIBIDO DE", "ENTREGADO A", "FECHA DE ENTREGA", "HORA DE ENTREGA", "# TOTAL LOTES"};
    private List<ReactivoEntregaPersonalizado> reactivosEntregasPersonalizadas;

    public void setReactivosEntregas(List<ReactivoEntregaPersonalizado> reactivosEntregasPersonalizadas) {
        this.reactivosEntregasPersonalizadas = reactivosEntregasPersonalizadas;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (reactivosEntregasPersonalizadas != null) {
            reactivosEntregasPersonalizadas.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return reactivosEntregasPersonalizadas == null ? 0 : reactivosEntregasPersonalizadas.size();
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
        final ReactivoEntrega reactivoEntrega = reactivosEntregasPersonalizadas.get(rowIndex).getReactivoEntrega();

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return reactivoEntrega.getCodigoEntrega();

            case 2:
                return reactivoEntrega.getProveedor();

            case 3:
                return reactivoEntrega.getPersonalTecnico().getPersona().getPersonaApellido() + " " + reactivoEntrega.getPersonalTecnico().getPersona().getPersonaNombre();

            case 4:
                return reactivoEntrega.getFechaEntrega();

            case 5:
                return reactivoEntrega.getHoraEntrega();

            case 6:
                return reactivosEntregasPersonalizadas.get(rowIndex).getTotalLotes();

            default:
                return null;
        }
    }

    public ReactivoEntrega getReactivoEntrega(final int rowIndex) {
        return reactivosEntregasPersonalizadas.get(rowIndex).getReactivoEntrega();
    }
}
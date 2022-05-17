package View.Utilitarios.ModelTable.GestionReactivos;

import Model.POJO.ReactivoLote;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelReactivosLotes extends AbstractTableModel {

    private final String[] columnas = {"Nº", "LOTE", "PRESENTACION", "ALMACENAMIENTO", "UBICACION", "MARCA", "FEC. VENCIMIENTO", "# UNIDADES", "REACTIVO"};
    private List<ReactivoLote> reactivosLotes;

    public void setReactivosLotes(List<ReactivoLote> reactivosLotes) {
        this.reactivosLotes = reactivosLotes;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (reactivosLotes != null) {
            reactivosLotes.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return reactivosLotes == null ? 0 : reactivosLotes.size();
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
        final ReactivoLote reactivoLote = reactivosLotes.get(rowIndex);

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
                return reactivoLote.getReactivo().getNombre();

            /*
                case 9:
                switch (reactivoLote.getEstadoConsumo()) {
                    case 0:
                        return "EN ALMACEN";

                    case 1:
                        return "EN CONSUMO";

                    default:
                        return "AGOTADO";
                }
                */

            default:
                return null;
        }
    }

    public ReactivoLote getReactivoLote(final int rowIndex) {
        return reactivosLotes.get(rowIndex);
    }
    
    public int existeLoteEnConsumoIniciado() {
        try {
            for (final ReactivoLote reactivoLote : reactivosLotes) {
                if (reactivoLote.getEstadoConsumo().equals("EN CONSUMO")) {
                    return 1;
                }
            }
            return 0;
        } catch (final Exception exception) {
            System.err.println("Error: " + exception.getMessage() + "\nClase: TableModelReactivosLotes\nMetodo: existeLoteEnConsumoIniciado()");
            return -1;
        }
    }
}
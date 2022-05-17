package View.Utilitarios.ModelTable.GestionEstablecimientos;

import Model.POJO.Establecimiento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionEstablecimientos extends AbstractTableModel {

    private final String[] columnas;
    private List<Establecimiento> establecimientos;

    public TableModelGestionEstablecimientos() {
        this.columnas = new String[]{"Nº", "CODIGO", "NOMBRE", "TIPO", "AREA"};
    }

    public void setEstablecimientos(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
        fireTableDataChanged();
    }

    public void limpiarLista() {
        if (establecimientos != null) {
            establecimientos.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return establecimientos == null ? 0 : establecimientos.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        final Establecimiento establecimiento = this.establecimientos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return establecimiento.getCodigoEstablecimiento();

            case 2:
                return establecimiento.getEstablecimientoNombre();

            case 3:
                return establecimiento.getEstablecimientoTipo();

            case 4:
                return establecimiento.getEstablecimientoArea();

            default:
                return null;
        }
    }

    public Establecimiento getEstablecimiento(final int rowIndex) {
        return establecimientos.get(rowIndex);
    }
}

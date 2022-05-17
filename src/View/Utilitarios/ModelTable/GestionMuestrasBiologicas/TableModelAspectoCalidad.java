package View.Utilitarios.ModelTable.GestionMuestrasBiologicas;

import Model.POJO.AspectoCalidad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelAspectoCalidad extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "ASPECTO/CALIDAD"};
    private List<AspectoCalidad> aspectos;

    public void setAspectos(List<AspectoCalidad> aspectos) {
        this.aspectos = aspectos;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (aspectos != null) {
            aspectos.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return aspectos == null ? 0 : aspectos.size();
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
        final AspectoCalidad aspecto = aspectos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return aspecto.getCodigoAspectoCalidad();

            case 2:
                return aspecto.getAspectoCalidad();
                
            default:
                return null;
        }
    }
    
    public AspectoCalidad getAspecto(final int rowIndex) {
        return aspectos.get(rowIndex);
    }
}
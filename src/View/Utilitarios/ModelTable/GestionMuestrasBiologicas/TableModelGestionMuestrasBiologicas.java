package View.Utilitarios.ModelTable.GestionMuestrasBiologicas;

import Model.POJO.MuestraBiologica;
import Model.POJOPersonalizado.MuestraBiologicaPersonalizada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionMuestrasBiologicas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "MUESTRA BIOLOGICA", "# ASPECTO/CALIDAD", "# PARASITOS"};
    private List<MuestraBiologicaPersonalizada> muestrasBiologicasPersonalizadas;

    public void setMuestrasBiologicasPersonalizadas(List<MuestraBiologicaPersonalizada> muestrasBiologicasPersonalizadas) {
        this.muestrasBiologicasPersonalizadas = muestrasBiologicasPersonalizadas;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (muestrasBiologicasPersonalizadas != null) {
            muestrasBiologicasPersonalizadas.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return muestrasBiologicasPersonalizadas == null ? 0 : muestrasBiologicasPersonalizadas.size();
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
        final MuestraBiologica muestraBiologica = muestrasBiologicasPersonalizadas.get(rowIndex).getMuestraBiologica();

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return muestraBiologica.getCodigoMuestraBiologica();

            case 2:
                return muestraBiologica.getMuestraBiologicaTipo();
                
            case 3:
                return muestrasBiologicasPersonalizadas.get(rowIndex).getTotalAspectos();
                
            case 4:
                return muestrasBiologicasPersonalizadas.get(rowIndex).getTotalParasitos();

            default:
                return null;
        }
    }
    
    public MuestraBiologica getMuestraBiologica(final int rowIndex) {
        return muestrasBiologicasPersonalizadas.get(rowIndex).getMuestraBiologica();
    }
}
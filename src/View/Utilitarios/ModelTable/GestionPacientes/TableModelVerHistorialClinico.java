package View.Utilitarios.ModelTable.GestionPacientes;

import Model.POJOPersonalizado.RecepcionPersonalizada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerHistorialClinico extends AbstractTableModel {

    private final String[] columnas = {"Nº", "COD. REG. LAB", "EDAD", "FECHA RECEPCION", "HORA RECEPCION", "# EXAMNS SOLICITADOS"};
    private List<RecepcionPersonalizada> recepcionesPersonalizadas;

    public void setRecepcionesPersonalizadas(List<RecepcionPersonalizada> recepcionesPersonalizadas) {
        this.recepcionesPersonalizadas = recepcionesPersonalizadas;
        fireTableDataChanged();
    }

    public List<RecepcionPersonalizada> getRecepcionesPersonalizadas() {
        return recepcionesPersonalizadas;
    }
        
    public void limpiarLista() {
        if (recepcionesPersonalizadas != null) {
            recepcionesPersonalizadas.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return recepcionesPersonalizadas == null ? 0 : recepcionesPersonalizadas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
                
            case 1:
                return recepcionesPersonalizadas.get(rowIndex).getRecepcion().getCodigoRegistroLaboratorio();

            case 2:
                if (recepcionesPersonalizadas.get(rowIndex).getRecepcion().getEdadPacienteYears() == 0) {
                    if (recepcionesPersonalizadas.get(rowIndex).getRecepcion().getEdadPacienteMeses() == 0) {
                        if (recepcionesPersonalizadas.get(rowIndex).getRecepcion().getEdadPacienteDias() == 0) {
                            return "R.N";
                        } else {
                            return recepcionesPersonalizadas.get(rowIndex).getRecepcion().getEdadPacienteDias() + " Días";
                        }
                    } else {
                        return recepcionesPersonalizadas.get(rowIndex).getRecepcion().getEdadPacienteMeses() + " Meses";
                    }
                } else {
                    return recepcionesPersonalizadas.get(rowIndex).getRecepcion().getEdadPacienteYears() + " Años";
                }

            case 3:
                return recepcionesPersonalizadas.get(rowIndex).getRecepcion().getFechaRecepcion();

            case 4:
                return recepcionesPersonalizadas.get(rowIndex).getRecepcion().getHoraRecepcion();

            case 5:
                return recepcionesPersonalizadas.get(rowIndex).getTotalExamenesSolicitados();

            default:
                return null;
        }
    }

    public RecepcionPersonalizada getRecepcionPersonalizada(final int rowIndex) {
        return recepcionesPersonalizadas.get(rowIndex);
    }
}

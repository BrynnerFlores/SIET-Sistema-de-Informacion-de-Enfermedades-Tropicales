package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJOPersonalizado.RecepcionPersonalizada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionRecepciones extends AbstractTableModel {

    private final String[] columnas = {"Nº", "COD. REG. LAB", "CI", "APELLIDO", "NOMBRE", "EDAD", "SEXO", "FECHA RECEPCION", "HORA RECEPCION", "# EXAMNS SOLICITADOS", "# EXAMNS PENDIENTES"};
    private List<RecepcionPersonalizada> recepcionesPersonalizadas;

    public void setRecepcionesPersonalizadas(List<RecepcionPersonalizada> recepcionesPersonalizadas) {
        this.recepcionesPersonalizadas = recepcionesPersonalizadas;
        fireTableDataChanged();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        final RecepcionPersonalizada recepcionPersonalizada = recepcionesPersonalizadas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return recepcionPersonalizada.getRecepcion().getCodigoRegistroLaboratorio();

            case 2:
                return recepcionPersonalizada.getRecepcion().getPaciente().getPersona().getPersonaCedulaIdentidad();

            case 3:
                return recepcionPersonalizada.getRecepcion().getPaciente().getPersona().getPersonaApellido();

            case 4:
                return recepcionPersonalizada.getRecepcion().getPaciente().getPersona().getPersonaNombre();

            case 5:
                if (recepcionPersonalizada.getRecepcion().getEdadPacienteYears() == 0) {
                    if (recepcionPersonalizada.getRecepcion().getEdadPacienteMeses() == 0) {
                        if (recepcionPersonalizada.getRecepcion().getEdadPacienteDias() == 0) {
                            return "R.N";
                        } else {
                            return recepcionPersonalizada.getRecepcion().getEdadPacienteDias() + " Días";
                        }
                    } else {
                        return recepcionPersonalizada.getRecepcion().getEdadPacienteMeses() + " Meses";
                    }
                } else {
                    return recepcionPersonalizada.getRecepcion().getEdadPacienteYears() + " Años";
                }

            case 6:
                return recepcionPersonalizada.getRecepcion().getPaciente().getPersona().getPersonaSexo();

            case 7:
                return recepcionPersonalizada.getRecepcion().getFechaRecepcion();

            case 8:
                return recepcionPersonalizada.getRecepcion().getHoraRecepcion();

            case 9:
                return recepcionPersonalizada.getTotalExamenesSolicitados();

            case 10:
                return recepcionPersonalizada.getTotalExamenesPendientes();

            default:
                return null;
        }
    }

    public RecepcionPersonalizada getRecepcionPersonalizada(final int rowIndex) {
        return recepcionesPersonalizadas.get(rowIndex);
    }
}
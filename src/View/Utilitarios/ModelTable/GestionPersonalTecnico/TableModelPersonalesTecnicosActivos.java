package View.Utilitarios.ModelTable.GestionPersonalTecnico;

import Model.POJO.Cuenta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelPersonalesTecnicosActivos extends AbstractTableModel {

    private final String[] columnas = {"Nº", "C.I", "APELLIDO", "NOMBRE", "SEXO", "PROFESION", "FECHA DE ALTA", "HORA DE ALTA"};
    private List<Cuenta> cuentas;

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (cuentas != null) {
            cuentas.clear();
            fireTableDataChanged();
        }
    }
    
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
    @Override
    public int getRowCount() {
        return cuentas == null ? 0 : cuentas.size();
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
        final Cuenta cuenta = cuentas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad();

            case 2:
                return cuenta.getPersonalTecnico().getPersona().getPersonaApellido();

            case 3:
                return cuenta.getPersonalTecnico().getPersona().getPersonaNombre();
                
            case 4:
                return cuenta.getPersonalTecnico().getPersona().getPersonaSexo();
                
            case 5:
                return cuenta.getPersonalTecnico().getPertecProfesion();
                
            case 6:
                return cuenta.getPersonalTecnico().getPertecFechaInicio();
                
            case 7:
                return cuenta.getPersonalTecnico().getPertecHoraInicio();
                
                default: return null;
        }
    }
    
    public Cuenta getCuentaBioquimico(final int rowIndex) {
        return cuentas.get(rowIndex);
    }
}
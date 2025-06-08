package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import modelo.Historial;

public class HistorialUpdateAction extends ActionSupport {

    private Historial historial; // debe estar presente con su getter y setter

    public String execute() {
        try {
            if (historial == null || historial.getId() == null) {
                addActionError("No se ha recibido el historial a actualizar.");
                return ERROR;
            }
            // Recuperar el historial original
            HistorialDao dao = new HistorialDao();
            Historial original = dao.obtenerPorId(historial.getId());
            if (original == null) {
                addActionError("No existe el historial en la base de datos.");
                return ERROR;
            }
            // Actualiza los campos editables
            original.setDiagnostico(historial.getDiagnostico());
            original.setTratamiento(historial.getTratamiento());
            // ... otros campos si tienes

            dao.actualizarHistorial(original);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error actualizando historial.");
            return ERROR;
        }
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}

package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import dao.HistorialDao;
import modelo.Cita;
import modelo.Historial;

public class HistorialNewAction extends ActionSupport {

    private Long citaId;
    private Historial historial = new Historial();

    public String execute() {
        
        Cita cita = new CitaDao().obtenerCitaPorId(citaId);
        if (cita == null || !cita.getEstado().equals("Completada")) {
            addActionError("Solo puedes crear historial de citas realizadas.");
            return ERROR;
        }
        historial.setIdCita(citaId);
        return SUCCESS;
    }

    // getters y setters
    public Long getCitaId() {
        return citaId;
    }

    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}

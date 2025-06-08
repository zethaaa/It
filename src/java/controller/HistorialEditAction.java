package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import modelo.Historial;

public class HistorialEditAction extends ActionSupport {

    private Long citaId;
    private Historial historial;

    public String execute() {
        historial = new HistorialDao().obtenerPorCitaId(citaId);
        return (historial != null) ? SUCCESS : ERROR;
    }

    // getter y setter
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

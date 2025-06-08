package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import modelo.Historial;

public class HistorialUpdateAction extends ActionSupport {

    private Historial historial;

    public String execute() {
        new HistorialDao().actualizarHistorial(historial);
        return SUCCESS;
    }

    // getter y setter
    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}

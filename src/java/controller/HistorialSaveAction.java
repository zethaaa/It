package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import modelo.Historial;

public class HistorialSaveAction extends ActionSupport {

    private Historial historial = new Historial();

    public String execute() {
        new HistorialDao().guardarHistorial(historial);
        return SUCCESS;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}

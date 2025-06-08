package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import modelo.Historial;

public class HistorialEditAction extends ActionSupport {

    private Long id; // este es el id del historial, lo recibes por parámetro
    private Historial historial;

    public String execute() {
        historial = new HistorialDao().obtenerPorId(id);
        if (historial == null) {
            addActionError("No existe el historial.");
            return ERROR;
        }
        return SUCCESS;
    }

    // getters y setters para 'id' y 'historial'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}

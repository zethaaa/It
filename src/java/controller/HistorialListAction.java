package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import modelo.Historial;

import java.util.List;

public class HistorialListAction extends ActionSupport {

    private List<Historial> listaHistoriales;

    public String execute() {
        listaHistoriales = new HistorialDao().listarHistoriales();
        return SUCCESS;
    }

    public List<Historial> getListaHistoriales() {
        return listaHistoriales;
    }

    public void setListaHistoriales(List<Historial> listaHistoriales) {
        this.listaHistoriales = listaHistoriales;
    }
}

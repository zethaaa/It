package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;

public class HistorialDeleteAction extends ActionSupport {

    private Long id;

    public String execute() {
        try {
            new HistorialDao().eliminarHistorial(id);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

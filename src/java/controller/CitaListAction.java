package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import modelo.Cita;
import java.util.List;

public class CitaListAction extends ActionSupport {

    private List<Cita> citas;

    public String execute() {
        CitaDao dao = new CitaDao();
        citas = dao.listarCitas();
        return SUCCESS;
    }

    public List<Cita> getCitas() {
        return citas;
    }
}

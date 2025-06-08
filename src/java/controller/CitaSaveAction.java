package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.CitaDao;
import modelo.Cita;

public class CitaSaveAction extends ActionSupport implements ModelDriven<Cita> {

    private Cita cita = new Cita();

    @Override
    public Cita getModel() {
        return cita;
    }

    public String execute() {
        try {
            CitaDao dao = new CitaDao();
            dao.guardarCita(cita);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}

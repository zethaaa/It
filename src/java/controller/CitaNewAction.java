package controller;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Cita;

public class CitaNewAction extends ActionSupport {

    private Cita cita = new Cita();

    public String execute() {
        return SUCCESS;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import dao.PacienteDao;

public class CitaDeleteAction extends ActionSupport {
    private long id;

    public String execute() {
        CitaDao dao = new CitaDao();
        dao.eliminarCita(id);
        return SUCCESS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

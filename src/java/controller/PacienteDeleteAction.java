/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;

public class PacienteDeleteAction extends ActionSupport {
    private long id;

    public String execute() {
        PacienteDao dao = new PacienteDao();
        dao.eliminarPaciente(id);
        return SUCCESS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

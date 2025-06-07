/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;
import modelo.Pacientes;
import java.util.List;

public class PacienteListAction extends ActionSupport {
    private List<Pacientes> pacientes;

    public String execute() {
        PacienteDao dao = new PacienteDao();
        try {
            pacientes = dao.consultaPacientes();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Pacientes> getPacientes() {
        return pacientes;
    }
}

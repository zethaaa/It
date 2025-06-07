/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;
import java.util.Arrays;
import java.util.List;
import modelo.Pacientes;

public class PacienteUpdateAction extends ActionSupport {
    private Pacientes paciente;
    


    public String execute() {
        PacienteDao dao = new PacienteDao();
        dao.actualizarPaciente(paciente);
        return SUCCESS;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    
}

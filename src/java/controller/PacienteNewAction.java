package controller;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Pacientes;
import java.util.Arrays;
import java.util.List;

public class PacienteNewAction extends ActionSupport {
    private Pacientes paciente = new Pacientes();

    // Debe llamarse IGUAL que en el JSP y tener el getter público
    private List<String> listaGeneros = Arrays.asList("Masculino", "Femenino");

    public String execute() {
        return SUCCESS;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List<String> getListaGeneros() {
        return listaGeneros;
    }
}

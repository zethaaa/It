package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;
import java.util.Arrays;
import java.util.List;
import modelo.Pacientes;

public class PacienteEditAction extends ActionSupport {

    private Long id; // CAMBIO: de int a Long
    private Pacientes paciente;
    private List<String> listaGeneros = Arrays.asList("Masculino", "Femenino");

    public String execute() {
        PacienteDao dao = new PacienteDao();
        paciente = dao.obtenerPacientePorId(id); // CAMBIO: id es Long
        return SUCCESS;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Long getId() { // CAMBIO: de int a Long
        return id;
    }

    public void setId(Long id) { // CAMBIO: de int a Long
        this.id = id;
    }

    public List<String> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<String> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

}

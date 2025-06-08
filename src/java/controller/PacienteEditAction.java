package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;
import modelo.Pacientes;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class PacienteEditAction extends ActionSupport {

    private Long id;
    private Pacientes paciente;
    private String fechaRegistroString; // Campo auxiliar para la fecha
    private List<String> listaGeneros = Arrays.asList("Masculino", "Femenino");

    public String execute() {
        PacienteDao dao = new PacienteDao();
        paciente = dao.obtenerPacientePorId(id);

        // Si el paciente tiene fechaRegistro, la formateamos a yyyy-MM-dd para el input type="date"
        if (paciente != null && paciente.getFechaRegistro() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaRegistroString = sdf.format(paciente.getFechaRegistro());
        }

        return SUCCESS;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setListaGeneros(List<String> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    public String getFechaRegistroString() {
        return fechaRegistroString;
    }

    public void setFechaRegistroString(String fechaRegistroString) {
        this.fechaRegistroString = fechaRegistroString;
    }
}

package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import modelo.Pacientes;

public class PacienteUpdateAction extends ActionSupport {

    private Pacientes paciente;
    private String fechaRegistroString; 

    public String execute() {
        try {
            if (fechaRegistroString != null && !fechaRegistroString.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                paciente.setFechaRegistro(sdf.parse(fechaRegistroString));
            }
            PacienteDao dao = new PacienteDao();
            dao.actualizarPaciente(paciente);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public List<String> getListaGeneros() {
        return Arrays.asList("Masculino", "Femenino");
    }

    public String getFechaRegistroString() {
        return fechaRegistroString;
    }

    public void setFechaRegistroString(String fechaRegistroString) {
        this.fechaRegistroString = fechaRegistroString;
    }

}

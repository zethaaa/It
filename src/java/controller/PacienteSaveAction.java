package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.PacienteDao;
import java.text.SimpleDateFormat;
import java.util.*;
import modelo.Pacientes;

public class PacienteSaveAction extends ActionSupport implements ModelDriven<Pacientes> {

    private Pacientes paciente = new Pacientes();

    @Override
    public Pacientes getModel() {
        return paciente;
    }

    @Override
    public String execute() {
        try {
            // Si la fecha llega como String y no se ha convertido, la conviertes manualmente:
            if (paciente.getFechaRegistro() == null && fechaRegistroString != null && !fechaRegistroString.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                paciente.setFechaRegistro(sdf.parse(fechaRegistroString));
            }
            PacienteDao dao = new PacienteDao();
            dao.guardarPaciente(paciente);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private String fechaRegistroString;

    public void setFechaRegistroString(String fechaRegistroString) {
        this.fechaRegistroString = fechaRegistroString;
    }

    public String getFechaRegistroString() {
        return fechaRegistroString;
    }

    public List<String> getListaGeneros() {
        return Arrays.asList("Masculino", "Femenino");
    }
}

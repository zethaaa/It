package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import dao.MedicoDao;
import dao.PacienteDao;
import modelo.Cita;
import modelo.Medico;
import modelo.Pacientes;
import modelo.CitaVista;
import java.util.ArrayList;
import java.util.List;

public class CitaListAction extends ActionSupport {

    private List<CitaVista> listaCitasVista;

    public String execute() {
        List<Cita> listaCitas = new CitaDao().listarCitas();
        List<Pacientes> listaPacientes = new PacienteDao().consultaPacientes();
        List<Medico> listaMedicos = new MedicoDao().consultaMedicos();

        listaCitasVista = new ArrayList<>();
        for (Cita cita : listaCitas) {
            String nombrePaciente = "";
            String nombreMedico = "";
             // Buscar nombre del paciente por ID
            for (Pacientes p : listaPacientes) {
                if (p.getId().intValue() == cita.getIdPaciente()) {
                    nombrePaciente = p.getNombre();
                    break;
                }
            }
            // Buscar nombre del médico por ID
            for (Medico m : listaMedicos) {
                if (m.getId().intValue() == cita.getIdMedico()) {
                    nombreMedico = m.getNombre();
                    break;
                }
            }
            listaCitasVista.add(new CitaVista(cita, nombrePaciente, nombreMedico));
        }
        return SUCCESS;
    }

    public List<CitaVista> getListaCitasVista() {
        return listaCitasVista;
    }

    public void setListaCitasVista(List<CitaVista> listaCitasVista) {
        this.listaCitasVista = listaCitasVista;
    }
}

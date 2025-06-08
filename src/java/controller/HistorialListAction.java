package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.HistorialDao;
import dao.CitaDao;
import dao.PacienteDao;
import modelo.Historial;
import modelo.Cita;
import modelo.Pacientes;
import modelo.HistorialVista;
import java.util.ArrayList;
import java.util.List;

public class HistorialListAction extends ActionSupport {

    private List<HistorialVista> listaHistorialesVista;

    public String execute() {
        HistorialDao historialDao = new HistorialDao();
        CitaDao citaDao = new CitaDao();
        PacienteDao pacienteDao = new PacienteDao();

        List<Historial> historiales = historialDao.listarHistoriales();
        listaHistorialesVista = new ArrayList<>();

        for (Historial h : historiales) {
            HistorialVista hv = new HistorialVista();
            hv.setId(h.getId());
            hv.setDiagnostico(h.getDiagnostico());
            hv.setTratamiento(h.getTratamiento());

            // Cargar cita y paciente
            Cita cita = citaDao.obtenerCitaPorId(h.getIdCita());
            if (cita != null) {
                hv.setMotivoCita(cita.getMotivo());
                Pacientes paciente = pacienteDao.obtenerPacientePorId(cita.getIdPaciente().longValue());
                if (paciente != null) {
                    hv.setNombrePaciente(paciente.getNombre());
                } else {
                    hv.setNombrePaciente("Desconocido");
                }
            } else {
                hv.setMotivoCita("Desconocido");
                hv.setNombrePaciente("Desconocido");
            }
            listaHistorialesVista.add(hv);
        }

        return SUCCESS;
    }

    public List<HistorialVista> getListaHistorialesVista() {
        return listaHistorialesVista;
    }

    public void setListaHistorialesVista(List<HistorialVista> listaHistorialesVista) {
        this.listaHistorialesVista = listaHistorialesVista;
    }
}

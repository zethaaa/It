package controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import dao.PacienteDao;
import dao.MedicoDao;
import modelo.Cita;
import modelo.Pacientes;
import modelo.Medico;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class CitaEditAction extends ActionSupport {

    private Long id;
    private Cita cita;
    private List<Pacientes> listaPacientes;
    private List<Medico> listaMedicos;
    private String fechaCitaString; // Auxiliar para input
    private List<String> listaEstados = Arrays.asList("Programada", "Cancelada", "Completada");

    public String execute() {
        cita = new CitaDao().obtenerCitaPorId(id);
        listaPacientes = new PacienteDao().consultaPacientes();
        listaMedicos = new MedicoDao().consultaMedicos();

        if (cita != null && cita.getFechaCita() != null) {
            // Para input datetime-local: "yyyy-MM-dd'T'HH:mm"
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            fechaCitaString = sdf.format(cita.getFechaCita());
        }

        return SUCCESS;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public List<Pacientes> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Pacientes> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public String getFechaCitaString() {
        return fechaCitaString;
    }

    public void setFechaCitaString(String fechaCitaString) {
        this.fechaCitaString = fechaCitaString;
    }

    public List<String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<String> listaEstados) {
        this.listaEstados = listaEstados;
    }

}

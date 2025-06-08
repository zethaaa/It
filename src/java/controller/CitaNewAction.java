package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.PacienteDao;
import dao.MedicoDao;
import modelo.Pacientes;
import modelo.Medico;
import java.util.List;
import java.util.Arrays;

public class CitaNewAction extends ActionSupport {

    private List<Pacientes> listaPacientes;
    private List<Medico> listaMedicos; // Si tienes más de uno
    private List<String> listaEstados = Arrays.asList("Programada", "Cancelada", "Completada");

    public String execute() {
        listaPacientes = new PacienteDao().consultaPacientes();
        listaMedicos = new MedicoDao().consultaMedicos(); // Si solo tienes uno, ponlo fijo
        return SUCCESS;
    }

    public List<Pacientes> getListaPacientes() {
        return listaPacientes;
    }

    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public List<String> getListaEstados() {
        return listaEstados;
    }
}

package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import modelo.Cita;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CitaSaveAction extends ActionSupport {

    private Integer idPaciente;
    private Integer idMedico;
    private String fechaCitaStr;
    private String motivo;
    private String estado;

    public String execute() {
        try {
            Cita cita = new Cita();
            cita.setIdPaciente(idPaciente);
            cita.setIdMedico(idMedico);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date fecha = sdf.parse(fechaCitaStr);
            cita.setFechaCita(fecha);
            cita.setMotivo(motivo);
            cita.setEstado(estado);

            new CitaDao().guardarCita(cita);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getFechaCitaStr() {
        return fechaCitaStr;
    }

    public void setFechaCitaStr(String fechaCitaStr) {
        this.fechaCitaStr = fechaCitaStr;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

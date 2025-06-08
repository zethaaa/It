package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.CitaDao;
import modelo.Cita;
import java.text.SimpleDateFormat;

public class CitaUpdateAction extends ActionSupport {

    private Cita cita;
    private String fechaCitaString;

    public String execute() {
        try {

            if (fechaCitaString != null && !fechaCitaString.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                cita.setFechaCita(sdf.parse(fechaCitaString));
            }
            CitaDao dao = new CitaDao();

            dao.actualizarCita(cita);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getFechaCitaString() {
        return fechaCitaString;
    }

    public void setFechaCitaString(String fechaCitaString) {
        this.fechaCitaString = fechaCitaString;
    }
}

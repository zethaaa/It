// Ubícalo en el paquete 'modelo' o 'controller', como prefieras.
package modelo;

public class CitaVista {

    private Cita cita;
    private String nombrePaciente;
    private String nombreMedico;

    public CitaVista(Cita cita, String nombrePaciente, String nombreMedico) {
        this.cita = cita;
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
}

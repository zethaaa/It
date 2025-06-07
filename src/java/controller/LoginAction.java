package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.MedicoDao;
import modelo.Medico;
import org.apache.struts2.ServletActionContext;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpSession;

public class LoginAction extends ActionSupport {

    private String email;
    private String password;

    // Getters y setters
    public String execute() {
        MedicoDao dao = new MedicoDao();
        Medico medico = dao.findByEmail(email);

        if (medico != null && BCrypt.checkpw(password, medico.getPassword())) {
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("usuario", medico);
            return SUCCESS; // Redirige a lo que configures en struts.xml
        } else {
            addActionError("Email o contraseña incorrectos");
            return INPUT; // Redirige a login.jsp
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

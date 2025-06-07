package controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class SessionInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession(false);

        // Si hay usuario en sesión, sigue normalmente
        if (session != null && session.getAttribute("usuario") != null) {
            return invocation.invoke();
        } else {
            String actionName = invocation.getProxy().getActionName();
            if (actionName.equals("login") || actionName.equals("logout")) {
                return invocation.invoke();
            }
            // Devuelve loginRedirect para que la acción pueda redirigir
            return "loginRedirect";
        }
    }

}

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; }
        form { margin: 40px auto; width: 300px; padding: 20px; border: 1px solid #bbb; border-radius: 10px; }
        label, input { display: block; width: 100%; }
        .error { color: red; margin-bottom: 10px; }
    </style>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <s:form action="login">
        <s:textfield name="email" label="Email"/>
        <s:password name="password" label="Contraseña"/>
        <s:submit value="Entrar"/>
        <s:fielderror cssClass="error"/>
    </s:form>
</body>
</html>

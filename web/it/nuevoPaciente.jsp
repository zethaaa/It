<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo Paciente</title>
    </head>
    <body>
        <h2>Registrar Nuevo Paciente</h2>
        <s:form action="PacienteSave">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><s:textfield name="nombre" required="true" maxlength="100"/></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><s:textfield name="edad" type="number" min="0" max="120" required="true"/></td>
                </tr>
                <tr>
                    <td>Género:</td>
                    <td><s:select name="genero" list="listaGeneros" label="Género"/></td>
                </tr>
                <tr>
                    <td>Fecha registro:</td>
                    <td><s:textfield name="fechaRegistroString" type="date"/></td>
                </tr>
                <tr>
                    <td>Teléfono:</td>
                    <td><s:textfield name="telefono" type="tel" pattern="[0-9]{9,15}" title="Introduce un teléfono válido"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><s:textfield name="email" type="email" required="true" maxlength="100"/></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><s:textfield name="direccion" maxlength="255"/></td>
                </tr>
            </table>
            <s:submit value="Guardar" />
            <a href="PacienteList">Volver</a>
        </s:form>
    </body>
</html>

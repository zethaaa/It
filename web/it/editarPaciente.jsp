<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Paciente</title>
    </head>
    <body>
        <h2>Editar Paciente</h2>
        <s:form action="PacienteUpdate">
            <s:hidden name="paciente.id"/>
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><s:textfield name="paciente.nombre" required="true" maxlength="100"/></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><s:textfield name="paciente.edad" type="number" min="0" max="120" required="true"/></td>
                </tr>
                <tr>
                    <td>Género:</td>
                    <td>
                        <s:select name="paciente.genero" list="listaGeneros" label="Género"/>
                    </td>
                </tr>
                <tr>
                    <td>Fecha registro:</td>
                    <td>
                        <s:textfield name="fechaRegistroString" type="date" value="%{fechaRegistroString}"/>
                    </td>
                </tr>
                <tr>
                    <td>Teléfono:</td>
                    <td><s:textfield name="paciente.telefono" type="tel"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><s:textfield name="paciente.email" type="email" required="true" maxlength="100"/></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><s:textfield name="paciente.direccion" maxlength="255"/></td>
                </tr>
            </table>
            <s:submit value="Actualizar" />
            <a href="PacienteList">Volver</a>
        </s:form>
    </body>
</html>


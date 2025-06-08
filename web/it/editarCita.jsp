<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Cita</title>
    </head>
    <body>
        <h2>Editar Cita</h2>
        <s:form action="CitaUpdate">
            <s:hidden name="cita.id"/>
            <table>
                <tr>
                    <td>Paciente:</td>
                    <td>
                        <s:select name="cita.idPaciente" list="listaPacientes" listKey="id" listValue="nombre" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>Médico:</td>
                    <td>
                        <s:select name="cita.idMedico" list="listaMedicos" listKey="id" listValue="nombre" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>Fecha y hora:</td>
                    <td>
                        <s:textfield name="fechaCitaString" type="datetime-local" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>Motivo:</td>
                    <td>
                        <s:textfield name="cita.motivo" maxlength="255" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>Estado:</td>
                    <td>
                        <s:select name="cita.estado" list="listaEstados" required="true"/>
                    </td>
                </tr>
            </table>
            <s:submit value="Actualizar"/>
            <a href="CitaList">Volver</a>
        </s:form>
    </body>
</html>

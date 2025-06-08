<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nueva Cita</title>
    </head>
    <body>
        <h2>Registrar Nueva Cita</h2>
        <s:form action="CitaSave">
            <table>
                <tr>
                    <td>Paciente:</td>
                    <td>
                        <s:select name="idPaciente" list="listaPacientes" listKey="id" listValue="nombre" required="true" />
                    </td>
                </tr>
                <tr>
                    <td>Médico:</td>
                    <td>
                        <s:select name="idMedico" list="listaMedicos" listKey="id" listValue="nombre" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>Fecha y Hora:</td>
                    <td>
                        <input type="datetime-local" name="fechaCitaStr" required />
                    </td>
                </tr>
                <tr>
                    <td>Motivo:</td>
                    <td>
                        <s:textfield name="motivo" required="true" maxlength="255"/>
                    </td>
                </tr>
                <tr>
                    <td>Estado:</td>
                    <td>
                        <s:select name="estado" list="listaEstados" required="true"/>
                    </td>
                </tr>
            </table>
            <s:submit value="Guardar"/>
            <a href="CitaList">Volver al listado</a>
        </s:form>
    </body>
</html>

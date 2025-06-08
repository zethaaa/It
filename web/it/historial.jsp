<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Historiales Médicos</title>
    </head>
    <body>
        <h2>Listado de Historiales Médicos</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Paciente</th>
                <th>Motivo (Cita)</th>
                <th>Diagnóstico</th>
                <th>Tratamiento</th>
                <th>Acciones</th>
            </tr>
            <s:iterator value="listaHistoriales" var="historial">
                <tr>
                    <td><s:property value="#historial.id"/></td>
                    <td><s:property value="#historial.cita.idPaciente"/></td>
                    <td><s:property value="#historial.cita.motivo"/></td>
                    <td><s:property value="#historial.diagnostico"/></td>
                    <td><s:property value="#historial.tratamiento"/></td>
                    <td>
                        <a href="HistorialEdit?id=<s:property value='#historial.id'/>">Editar</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <br>
        <a href="HistorialNew">Añadir Nuevo Historial</a>
        <a href="menu">Volver al menú</a>
    </body>
</html>

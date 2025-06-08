<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Historiales Médicos</title>
        <style>
            table { border-collapse: collapse; }
            th, td { border: 1px solid #222; padding: 5px 10px; }
            th { background: #eee; }
        </style>
    </head>
    <body>
        <h2>Listado de Historiales Médicos</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Paciente</th>
                <th>Motivo (Cita)</th>
                <th>Diagnóstico</th>
                <th>Tratamiento</th>
                <th>Acciones</th>
            </tr>
            <s:iterator value="listaHistorialesVista" var="h">
                <tr>
                    <td><s:property value="#h.id"/></td>
                    <td><s:property value="#h.nombrePaciente"/></td>
                    <td><s:property value="#h.motivoCita"/></td>
                    <td><s:property value="#h.diagnostico"/></td>
                    <td><s:property value="#h.tratamiento"/></td>
                    <td>
                        <a href="HistorialEdit?id=<s:property value='#h.id'/>">Editar</a>
                        <a href="HistorialDelete?id=<s:property value='#h.id'/>"
                           onclick="return confirm('¿Seguro que quieres borrar este historial?');">Borrar</a>

                    </td>
                </tr>
            </s:iterator>
        </table>
        <br>
        <a href="menu">Volver al menú</a>
    </body>
</html>

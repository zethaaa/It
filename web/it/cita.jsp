<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestión de Citas</title>
        <style>
            table { border-collapse: collapse; }
            th, td { border: 1px solid #222; padding: 5px 10px; }
            th { background: #eee; }
        </style>
    </head>
    <body>
        <h2>Listado de Citas</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Paciente</th>
                <th>Médico</th>
                <th>Fecha</th>
                <th>Motivo</th>
                <th>Estado</th>
                <th>Acciones</th>

            </tr>
            <s:iterator value="listaCitasVista" var="item">
                <tr>
                    <td><s:property value="#item.cita.id"/></td>
                    <td><s:property value="#item.nombrePaciente"/></td>
                    <td><s:property value="#item.nombreMedico"/></td>
                    <td><s:property value="#item.cita.fechaCita"/></td>
                    <td><s:property value="#item.cita.motivo"/></td>
                    <td><s:property value="#item.cita.estado"/></td>

                    <td>
                        <a href="CitaEdit?id=<s:property value='#item.cita.id'/>">Editar</a>
                        <a href="CitaDelete?id=<s:property value='#item.cita.id'/>" onclick="return confirm('¿Seguro que quieres borrar?');">Borrar</a>
                        <s:if test="#item.cita.estado == 'Completada'">
                            <a href="HistorialNew?citaId=<s:property value='#item.cita.id'/>">Crear historial</a>
                        </s:if> 
                    </td>
                </tr>
            </s:iterator>
        </table>

        <br>
        <a href="CitaNew">Nueva cita</a>
        <a href="menu">Volver al menú</a>
    </body>
</html>

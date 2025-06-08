<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Historial</title>
    </head>
    <body>
        <h2>Editar Historial Médico</h2>
        <s:form action="HistorialUpdate">
            <s:hidden name="id"/>
            <table>
                <tr>
                    <td>Cita (Motivo):</td>
                    <td>
                        <s:property value="historial.cita.motivo"/>
                    </td>
                </tr>
                <tr>
                    <td>Diagnóstico:</td>
                    <td>
                        <s:textarea name="diagnostico" required="true" rows="4" cols="40"/>
                    </td>
                </tr>
                <tr>
                    <td>Tratamiento:</td>
                    <td>
                        <s:textarea name="tratamiento" required="true" rows="4" cols="40"/>
                    </td>
                </tr>
            </table>
            <s:submit value="Actualizar"/>
            <a href="HistorialList">Volver</a>
        </s:form>
    </body>
</html>

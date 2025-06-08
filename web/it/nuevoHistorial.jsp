<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Nuevo Historial</title>
    </head>
    <body>
        <h2>Nuevo Historial</h2>
        <s:form action="HistorialSave">
            <s:hidden name="historial.idCita" value="%{historial.idCita}" />
            <table>
                <tr>
                    <td>Diagnóstico:</td>
                    <td><s:textfield name="historial.diagnostico" required="true" maxlength="255"/></td>
                </tr>
                <tr>
                    <td>Tratamiento:</td>
                    <td><s:textfield name="historial.tratamiento" required="true" maxlength="255"/></td>
                </tr>
            </table>
            <s:submit value="Guardar" />
            <a href="HistorialList">Volver</a>
        </s:form>
    </body>
</html>

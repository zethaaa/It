<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Listado de Pacientes</title>
        <style>
            table { border-collapse: collapse; width: 100%; }
            th, td { padding: 8px; border: 1px solid #999; text-align: left; }
        </style>
    </head>
    <body>
        <h2>Pacientes</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Género</th>
                <th>Fecha de Registro</th>
                <th>Teléfono</th>
                <th>Email</th>
                <th>Dirección</th>
                <th>Acciones</th>
            </tr>
            <s:iterator value="pacientes" var="p">
                <tr>
                    <td><s:property value="#p.id"/></td>
                    <td><s:property value="#p.nombre"/></td>
                    <td><s:property value="#p.edad"/></td>
                    <td><s:property value="#p.genero"/></td>
                    <td><s:property value="#p.fechaRegistro"/></td>
                    <td><s:property value="#p.telefono"/></td>
                    <td><s:property value="#p.email"/></td>
                    <td><s:property value="#p.direccion"/></td>
                    <td>
                        <a href="PacienteEdit?id=<s:property value='#p.id'/>">Editar</a> |
                        <a href="PacienteDelete?id=<s:property value='#p.id'/>"
                           onclick="return confirm('¿Seguro que quieres eliminar este paciente?');">Eliminar</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <br>
        <a href="PacienteNew">Añadir nuevo paciente</a>
        <br>

        <a href="logout">Cerrar sesión</a>

        <br>

        <a href="menu">Volver</a>


    </body>
</html>

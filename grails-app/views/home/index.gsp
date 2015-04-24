<%--
  Created by IntelliJ IDEA.
  User: seb
  Date: 24/04/15
  Time: 19:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
<head>
</head>

<body>
<div id="list-home" class="content scaffold-list" role="main">
    <g:form>
        <fieldset class="form">
            <div class="fieldcontain">
                <label for="nom">
                    Le nom contient contient :
                </label>
                <g:textField name="nom"/>
            </div>

            <div class="fieldcontain">
                <label for="codePostal">
                    Code Postal:
                </label>
                <g:select name="codePostal" from="${projetjee2015.Adresse.list().codePostal.unique()}"/>
            </div>

            <div class="fieldcontain">
                <label for="rue">
                    La rue contient :
                </label>
                <g:textField name="rue"/>
            </div>

            <div style="float: right">
                <g:actionSubmit action="doSearchMusee" value="Rechercher"/>
            </div>
        </fieldset>
    </g:form>

    <g:each in="${museeInstanceList}" status="i" var="museeInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link></td>
            <td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

        </tr>
    </g:each>
</div>
</body>
</html>
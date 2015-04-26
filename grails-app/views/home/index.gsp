<%--
  Created by IntelliJ IDEA.
  User: seb
  Date: 24/04/15
  Time: 19:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'home.label', default: 'Home')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
<head>
</head>
<body>

<g:if test="${!projetjee2015.Utilisateur.get(1).musees.isEmpty()}">
    <g:include view="utilisateur/favorit.gsp"></g:include>
</g:if>
<div>
    <div id="create-Recherche" class="content scaffold-create" role="main">
        <h1>Recherche de musées</h1>
        <g:form>
            <fieldset class="form">
                <div class="fieldcontain">
                    <label for="nom">
                        Le nom contient
                    </label>
                    <g:textField name="nom"/>
                </div>

                <div class="fieldcontain">
                    <label for="codePostal">
                        Code Postal
                    </label>
                    <g:select name="codePostal" from="${projetjee2015.Adresse.list().codePostal.unique()}"
                        noSelection="[0:'']"/>
                </div>

                <div class="fieldcontain">
                    <label for="rue">
                        La rue contient
                    </label>
                    <g:textField name="rue"/>
                </div>

                <div style="float: right">
                    <g:actionSubmit action="doSearchMusee" value="Rechercher"/>
                </div>
            </fieldset>
        </g:form>

        <table style="font-size: 0.8em">
            <g:each in="${museeInstanceList}" status="i" var="museeInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td>${fieldValue(bean: museeInstance, field: "nom")}</td>
                    <td width="10%">${fieldValue(bean: museeInstance, field: "telephone")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "adresse")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>

                    <td><g:link action="addFav" id="${museeInstance.id}" params="[nom: nomSearch,
                                                                                  codePostal: codePostalSearch,
                                                                                  rue: rueSearch ]">
                        <input type="button" value="Ajouter à ma liste de musées" class="button"
                               ${projetjee2015.Utilisateur.get(1).musees.contains(museeInstance)?'disabled':''}/>
                    </g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </div>
</div>
</body>
</html>
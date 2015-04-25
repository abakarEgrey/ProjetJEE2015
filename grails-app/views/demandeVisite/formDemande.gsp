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
    <g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
<head>
</head>
<body>
    <a href="#create-demandeVisite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        </ul>
    </div>
    <div>
        <div id="create-demandeVisite" class="content scaffold-create" role="main">

            <g:if test="${demandeVisiteInstance?.code}">
                <div style="margin: 5px;text-align: center">
                    Demande de visite enregistrée, votre code est
                    <span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${demandeVisiteInstance}" field="code"/></span>
                    <br>
                    Votre demande sera traitée prochainement.
                </div>
            </g:if>

            <h1>Demande de Visite</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <g:hasErrors bean="${demandeVisiteInstance}">
                <ul class="errors" role="alert">
                    La date de fin n'est pas valide.
                </ul>
            </g:hasErrors>
            <g:form url="[resource:demandeVisiteInstance, action:'nouvelDemande']" >
                <fieldset class="form">
                    <g:render template="form"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </div>
</body>
</html>
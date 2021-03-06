
<%@ page import="projetjee2015.DemandeVisiteMusee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-demandeVisiteMusee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-demandeVisiteMusee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="demandeVisiteMusee.musee.label" default="Musee" /></th>
					
						<th><g:message code="demandeVisiteMusee.demande.label" default="Demande" /></th>
					
						<g:sortableColumn property="dateDemande" title="${message(code: 'demandeVisiteMusee.dateDemande.label', default: 'Date Demande')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${demandeVisiteMuseeInstanceList}" status="i" var="demandeVisiteMuseeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${demandeVisiteMuseeInstance.id}">${fieldValue(bean: demandeVisiteMuseeInstance, field: "musee")}</g:link></td>
					
						<td>${fieldValue(bean: demandeVisiteMuseeInstance, field: "demande")}</td>
					
						<td><g:formatDate date="${demandeVisiteMuseeInstance.dateDemande}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${demandeVisiteMuseeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

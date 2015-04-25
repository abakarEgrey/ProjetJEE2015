<%@ page import="projetjee2015.DemandeVisiteMusee" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteMuseeInstance, field: 'musee', 'error')} required">
	<label for="musee">
		<g:message code="demandeVisiteMusee.musee.label" default="Musee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="musee" name="musee.id" from="${projetjee2015.Musee.list()}" optionKey="id" required="" value="${demandeVisiteMuseeInstance?.musee?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteMuseeInstance, field: 'demande', 'error')} required">
	<label for="demande">
		<g:message code="demandeVisiteMusee.demande.label" default="Demande" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="demande" name="demande.id" from="${projetjee2015.DemandeVisite.list()}" optionKey="id" required="" value="${demandeVisiteMuseeInstance?.demande?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteMuseeInstance, field: 'dateDemande', 'error')} required">
	<label for="dateDemande">
		<g:message code="demandeVisiteMusee.dateDemande.label" default="Date Demande" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDemande" precision="day"  value="${demandeVisiteMuseeInstance?.dateDemande}"  />

</div>


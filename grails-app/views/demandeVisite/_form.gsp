<%@ page import="projetjee2015.DemandeVisite" %>


<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'musees', 'error')} ">
    <label for="musees">
        <g:message code="demandeVisite.musees.label" default="Musees" />
    </label>
    <g:select name="musee" from="${projetjee2015.Utilisateur.get(1).musees.unique()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateDebutPeriode', 'error')} required">
	<label for="dateDebutPeriode">
		<g:message code="demandeVisite.dateDebutPeriode.label" default="Date Debut Periode" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDebutPeriode" precision="day"  value="${demandeVisiteInstance?.dateDebutPeriode}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateFinPeriode', 'error')} required">
	<label for="dateFinPeriode">
		<g:message code="demandeVisite.dateFinPeriode.label" default="Date Fin Periode" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateFinPeriode" precision="day"  value="${demandeVisiteInstance?.dateFinPeriode}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonne', 'error')} required">
	<label for="nbPersonne">
		<g:message code="demandeVisite.nbPersonne.label" default="Nb Personne" />
		<span class="required-indicator">*</span>
	</label>
    <g:select name="nbPersonne" from="${1..6}"/>

</div>


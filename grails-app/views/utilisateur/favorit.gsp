<%--
  Created by IntelliJ IDEA.
  User: seb
  Date: 24/04/15
  Time: 23:46
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<div style="float: right;border: 1px solid black;padding: 5px">
    <h2>Mes musées préférés</h2>
    <hr/>
    <ul style="list-style-type: none">
        <g:each in="${projetjee2015.Utilisateur.get(1).musees}" status="i" var="museeInstance">
            <li>
                ${fieldValue(bean: museeInstance, field: "nom")}
                <g:if test="${projetjee2015.Utilisateur.get(1).musees.size() >= 2}">
                    <g:link action="removeFav" id="${museeInstance.id}" params="[nom: nomSearch,
                                                                              codePostal: codePostalSearch,
                                                                              rue: rueSearch ]">
                        <input type="button" value="X" class="button"/>
                    </g:link>
                </g:if>
            </li>
        </g:each>
    </ul>
</div>
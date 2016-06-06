<%-- 
    Document   : gestionMessage
    Created on : 6 juin 2016, 16:17:02
    Author     : user
--%>

<%@page import="twinoserver.modele.Message"%>
<%@page import="java.util.LinkedList"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%@page import="twinoserver.modele.Tache"%>
<%@page import="twinoserver.modele.TacheAtom"%>

<!DOCTYPE html>
<html>
	<head>
    	<script>
        	function show(shown, hidden) {
            	document.getElementById(shown).style.display = 'block';
            	document.getElementById(hidden).style.display = 'none';
            	return false;
        	}
    	</script><script type="text/javascript" src="afficher_cacher_div.js"></script>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Messagerie</title>
	</head>
	<body>

    	<%@ include file="/WEB-INF/header.jsp" %>
    	</br>

    	<div class="container">
<div class="table-wrapper" id="Page1">
            	<header class="major">
                	<h2>Votre message</h2>
                	<p><a href="#" onclick="return show('Page2', 'Page1');">Répondre au destinataire</a>
                    	<a href="controleurMessagerie?action=supprimerMessage&numMessage=${messages.numMessage}">Supprimer le message</a></p>
            	</header>
</div>    
    	<%-- Section globale pour les deux pages --%>   	 
    	<div id="Page1">
        	<h3><b>Objet :</b> ${messages.titre}</h3>
        	<h3><b> Expéditeur : </b> ${messages.adresseMailExp}</h3>
        	<a href="controleurProfil?action=consulterProfil&ident=${messages.adresseMailExp}">Consulter le profil : ${messages.adresseMailExp}</a>
        	<h3> <b>Contenu du message : </b>${messages.message}</h3>
        	<form method="POST" action="controleurMessagerie">
            	<% Message m = (Message) request.getAttribute("messages");
                	String titre = m.getTitre().substring(0, 7);
                	if (titre.equals("Reponse")) {%>
            	<input   type = "hidden" name = "action" value = "accept" >
            	<input type="hidden" name="titre" value="${messages.titre}">

            	<%
            	} else if (titre.equals("Tâche t")) {%>
            	<input type="hidden" name="action" value="payer">
            	<input type="hidden" name="message" value="${messages.titre}">

            	<%}
            	%>
            	<input type="hidden" name="adresseMailExp" value="${messages.adresseMailDest}">
            	<input type="hidden" name="adresseMailDest" value="${messages.adresseMailExp}">

            	<%
                	if (titre.equals("Reponse")) {
                    	out.print("<input type=\"submit\" value=\"Accepter\" name=\"confirm\">   <input type=\"submit\" value=\"Refuser\" name=\"confirm\">");
                	} else if (titre.equals("Tâche t")) {
                    	out.print("<input type=\"submit\" value=\"Payer\" name=\"confirm\">   <input type=\"submit\" value=\"Refuser\" name=\"confirm\">");
            	%>
            	<form method="POST" action="controleurMessagerie">
                	<input type="hidden" name="action" value="payer">
                	<input type="hidden" name="message" value="<%=request.getAttribute("message")%>">
                	<input type="hidden" name="adresseMailExp" value="<%=request.getAttribute("adresseMailExp")%>">
                	<input type="hidden" name="adresseMailDest" value="<%=request.getAttribute("adresseMailDest")%>">
                	<label>Numéro de carte bancaire : </label><input type="text">
                	<label>Code de sécurité : </label><input type ="text">
                	<label>Date d'expiration : </label>
                	<label>Mois</label>
                	<select>
                    	<option value="Janvier">Janvier</option>
                    	<option value="Février">Février</option>
                    	<option value="Mars">Mars</option>
                    	<option value="Avril">Avril</option>
                    	<option value="Mai">Mai</option>
                    	<option value="Juin">Juin</option>
                    	<option value="Juillet">Juillet</option>
                    	<option value="Août">Août</option>
                    	<option value="Septembre">Septembre</option>
                    	<option value="Octobre">Octobre</option>
                    	<option value="Novembre">Novembre</option>
                    	<option value="Décembre">Décembre</option>
                	</select>
                	<label>Année</label><input type="text">

            	</form>
        	<%}%>
    	</div>   	 
    	<div id="Page2" style="display:none">
        	<form method="POST" action="controleurMessagerie">
            	<input type="hidden" name="action" value="repondre">
            	<input type="hidden" name="adresseMailDest" value="${messages.adresseMailExp}">
            	<input type="hidden" name="adresseMailExp" value="${messages.adresseMailDest}">             	 
            	<label>A : ${messages.adresseMailExp}</label>
            	<label> Objet : </label> <input type="text" name="titre"/>
            	<label> Message : </label><input type="text" class="style_input" name="message"/></br>
            	<input type="submit" value="Envoyer le message">
        	</form>
    	</div> 	 
    	</div>   	 
	</body>

</html>



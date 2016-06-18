<%-- 
    Document   : Messagerie
    Created on : 6 juin 2016, 16:22:39
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="twinoserver.modele.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="twinoserver.modele.Tache"%>
<%@page import="twinoserver.modele.TacheAtom"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<script>
        	function show(shown, hidden) {
            	document.getElementById(shown).style.display = 'block';
            	document.getElementById(hidden).style.display = 'none';
            	return false;
        	}
    	</script>
 <script type="text/javascript" src="afficher_cacher_div.js"></script>
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Messagerie</title>
	</head>
	<body>

    	<%
        	String var = (String) session.getAttribute("utilisateur");

        	if (var != null) { %>
                	<%@ include file="/WEB-INF/header_connecte.jsp" %>
        	<%  } else { %>
                	<%@ include file="/WEB-INF/header_guest.jsp" %>
    	<% } %>

</br>
    	<section id="main" class="wrapper">
<div class="container">
<div class="table-wrapper" id="Page1">
            	<header class="major">
                	<h2>Messagerie</h2>
            	</header>

<table>
                	<thead>
                    	<tr>
                        	<th>Expéditeur</th>
                        	<th>Objet du message</th>
                        	<th>Date</th>
                    	</tr>
                	</thead>
                	<tbody>
                    	<% LinkedList<Message> messages = (LinkedList<Message>) request.getAttribute("messages");
                        	for (Message m : messages) {
                            	int numMessage = m.getNumMessage();
                            	if (m.getEstLu() == 1) {
                                	out.print("<tr><td>" + m.getAdresseMailExp() + "</td>");
                                	out.print("<td><a href=\"controleurMessagerie?action=gestionMessages&numMessage=" + numMessage + "\">" + m.getTitre() + "</a></td>");
                                	out.print("<td>" + m.getDateHeure() + "</td></tr>");
                            	} else {
                                	out.print("<tr><td><b><b>" + m.getAdresseMailExp() + "</b></b></td>");
                                	out.print("<td><a href=\"controleurMessagerie?action=gestionMessages&numMessage=" + numMessage + "\">" + m.getTitre() + "</a></b></td>");
                                	out.print("<td><b>" + m.getDateHeure() + "</b></td></tr>");
                            	}
                        	}
                    	%>
                	</tbody>
            	</table>
</div>
        	<div id="Page2" style="display:none">
            	<header class="major">
                	<h2>Envoyer un message</h2>
                	<p><a href="#" onclick="return show('Page1', 'Page2');">Retour à la messagerie</a></p>
            	</header>
</br>
            	<form method="POST" action="controleurMessagerie">
                	<input type="hidden" name="action" value="envoyerMessage">
                	<input type="hidden" name="adresseMailExp" value="aymeric">   <%-- à changer quand session ok --%>
                	<label> A :</label><input type="text" name="adresseMailDest"/>
                	<label> Objet : </label> <input type="text" name="titre"/>
                	<label> Message : </label><textarea name="message" id="message" placeholder="Entrer votre message" rows="6"></textarea><input type="submit" value="Envoyer le message">
            	</form>
        	</div>
        	</div>
    	</section>
	</body>
</html>


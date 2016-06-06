<%-- 
    Document   : MesTaches
    Created on : 6 juin 2016, 16:21:57
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="twinoserver.modele.Tache"%>
<%@page import="twinoserver.modele.TacheAtom"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Mes tâches</title>
	</head>
	<body>
   	 
    	<!-- Header -->
<%
      	String var= (String) session.getAttribute("utilisateur");
      	 
        	if (var != null) { %>
            	<%@ include file="/WEB-INF/header_connecte.jsp" %>   
        	<%  }%>
    	
</br>
    	<div class="container">
<div>
        	<header class="major">
                        	<h2>Mes tâches</h2>
                        	<p>Cliquez sur une tâche !<p>
        	</header>
</div>
        	<% LinkedList<TacheAtom> tacheAtomique = (LinkedList<TacheAtom>) request.getAttribute("taches");
           	for (TacheAtom ta : tacheAtomique){
               	out.print("<pre><code><a href=\"controleurTache?action=gestionMesTaches&numTache=" + ta.getNumTache()  + "&numTacheAtom=" + ta.getNumTacheAtom()  + "\">" + ta.getTitre()  + "</a>"
                       	+ "     	Prix : " + ta.getRemuneration()
                       	+ "     	Date au plus tôt : " + ta.getDateTot()
                       	+ "     	Date au plus tard : " + ta.getDateTard()  + "</pre></code>");
           	}
        	%>
    	</div>
	</body>
</html>
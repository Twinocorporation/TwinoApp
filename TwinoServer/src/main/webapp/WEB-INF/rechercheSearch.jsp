<%-- 
    Document   : rechercheSearch
    Created on : 6 juin 2016, 16:24:34
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
    	<title>Résultat de la recherche</title>
	</head>
	<body>
   	 
<%
    	String var= (String) session.getAttribute("utilisateur");
      	 
    	if (var != null) { %>
        	<%@ include file="/WEB-INF/header_connecte.jsp" %>              	 
    	<%  }else{ %>
        	<header id="header">
   			 <h1><a href="index.jsp">Help Service</a></h1>
   			 <nav id="nav">
   				 <ul>
                                        	<li><a href="controleurTache?action=accueil">Accueil</a></li>
                                        	<li><a href="controleurProfil?action=inscription">Inscription</a></li>
                                        	<li><a href="controleurProfil?action=connexion">Connexion</a></li>
   					 
   				 </ul>
   			 </nav>
        	</header>
    	<%}
%>
       	 

	<section >
    	<div class="container">
 <section id="main" class="wrapper">
                  	<header class="major">
                          	<h2>Résultat de la recherche</h2>
                          	<p>Cliquez sur les tâches pour plus d'informations !</p>
                  	</header>
<section>
       	 
   	 
        	<% LinkedList<TacheAtom> tacheAtomique = (LinkedList<TacheAtom>) request.getAttribute("tacheAtom");
           	for (TacheAtom ta : tacheAtomique){
               	out.print(" <pre><code> <h2><a href=\"controleurTache?action=searchAnnonceSuite&numTache=" + ta.getNumTache()  + "&numTacheAtom=" + ta.getNumTacheAtom()  + "\">" + ta.getTitre()  + "</a></h2>"
                       	+ "        	Prix : " + ta.getRemuneration()  + ""
                       	+ "        	Date au plus tôt : " + ta.getDateTot()  + ""
                       	+ "        	Date au plus tard : " + ta.getDateTard() + "</pre></code>");
           	}
        	%>
    	</div>
	</section>
	</body>
</html>


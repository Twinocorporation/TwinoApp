<%-- 
    Document   : mesAnnonces
    Created on : 6 juin 2016, 16:21:06
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="twinoserver.modele.Tache"%>
<%@page import="twinoserver.modele.TacheAtom"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<link rel="stylesheet" href="css/style-small.css">
<title>Mes annonces</title>
	</head>
	<body>
        	<%
        	String var= (String) session.getAttribute("utilisateur");

        	if (var != null) { %>
                	 
            	<%@ include file="/WEB-INF/header_connecte.jsp" %>
         	 
        	<%  }%>
       	 
 
</br>
 
        	<div class="container"> 
<section id="main" class="wrapper">
                  	<header class="major">
                          	<h2>Mes annonces</h2>
                          	<p>Cliquez pour gérer vos annonces !</p>
                  	</header>
<section>
                	<% LinkedList<Tache> tache = (LinkedList<Tache>) request.getAttribute("annonces");
                   	for (Tache t : tache){
                       	for(TacheAtom ta : t.getTacheAtom())
                       	out.print("<pre><code><a href=\"controleurTache?action=gestionAnnonce&numTache=" + ta.getNumTache() + "&adresseMailCom=" + t.getAdresseMail()  + "&numTacheAtom=" + ta.getNumTacheAtom()  + "\">" + ta.getTitre()  + "</a>"
                               	+ "        	Prix : " + ta.getRemuneration()
                               	+ "        	Date au plus tôt : " + ta.getDateTot()
                               	+ "        	Date au plus tard : " + ta.getDateTard()  + "</pre></code>");
                   	}
                	%>
            	</section>
          	</section>
        	</div>   
	</body>
</html>

<%-- 
    Document   : RechercheSearchSuite
    Created on : 6 juin 2016, 16:26:14
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="twinoserver.modele.TacheAtom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    	<% }
 %>
 
   
	<% String adresse = (String)request.getAttribute("adresse");%>
    	<div class="container">
<section id="main" class="wrapper">
                  	<header class="major">
                          	<h2>Détails de l'annonce !</h2>
                  	</header>
<section>
             	<pre><code>
            	<% TacheAtom ta = (TacheAtom) request.getAttribute("tacheAtom"); //On récupère la tache atomique
               	LinkedList<String> competences = (LinkedList<String>)request.getAttribute("competences"); //on récupère les compétences de l'utilisateur
               	LinkedList<String> autresCompetences = (LinkedList<String>)request.getAttribute("autresCompetences"); //on récupère les autres compétences possibles
            	%>
                	<h3> <b>Titre de l'annonce : </b> <%=ta.getTitre()%></h3>
                	<h3> <b>Description de l'annonce : </b><%=ta.getDescription()%></h3>
                	<h3> <b>Compétences : </b></h3>   
                	<% for(String compet : competences){
                    	out.print("<h3>"+ compet + "</h3>" + "  <img src=\"images/" +compet+ ".jpg\" > <br/> ");
                	}%>
               	 
                	<h3> <b>Dâte au plus tôt : </b><%=ta.getDateTot()%></h3>
                	<h3> <b>Dâte au plus tard : </b><%=ta.getDateTard()%></h3>
                	<h3> <b>Adresse : </b><%=adresse%></h3>
                	<h3> <b>Rémunération : </b><%=ta.getRemuneration()%></h3>
                	</br></br>
                	</pre></code>
               	 
                	<form method="GET" action="controleurMessagerie">
               	 
                    	<input type="hidden" name="action" value="demanderTache"/>
                    	<input type="hidden" name="numTache" value="<%=ta.getNumTache()%>"/>
                    	<input type="hidden" name="numTacheAtomique" value="<%=ta.getNumTacheAtom()%>"/>
                    	<% if (var!=null){%>
                    	<input type="submit" value="Executer la tâche">
                    	<%}%>
                	</form>
	</body>
</html>


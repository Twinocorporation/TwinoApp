<%-- 
    Document   : recherche
    Created on : 6 juin 2016, 16:23:58
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Résultat de la recherche</title>
	</head>
	<body>
   	 
    	<!-- Header -->
<%
    	String var= (String) session.getAttribute("utilisateur");
      	 
    	if (var != null) { %>
        	<%@ include file="/WEB-INF/header_connecte.jsp" %>
    	<%  }else{ %>  	 
        	<!-- Header -->
   		 <header id="header">
   			 <h1><a href="index.jsp">Help Service</a></h1>
   			 <nav id="nav">
   				 <ul>
                                        	<li><a href="controleurProfil?action=inscription" > Inscription  </a> </li>
                                        	<li><a href='controleurProfil?action=connexion' > Connexion </a> </li>
                                        	<li><a href='controleurTache?action=rechercher' > Rechercher </a> </li>
   				 </ul>
   			 </nav>
   		 </header>
   	<% }
 %>
 
        	<div class="container">
<section id="main" class="wrapper">
                  	<header class="major">
                          	<h2>Recherche</h2>
                  	</header>
<section>
 
 

    	<%LinkedList<String> competences = (LinkedList<String>) request.getAttribute("competences");%>
    	<form method="POST" action="controleurTache">
               	 
                	<input type="hidden" name="action" value="searchAnnonces"/>
                                   	 
                	<label> Compétences </label>
                	<select name="competences" multiple>
                    	<%if (competences != null){
                            	for(String compet : competences){
                                	out.print("<option value="+ compet+">" + compet + " </option>");
                            	}
                    	}%>
                	</select></br>
                	<label> Dâte au plus tôt </label> <input type="date" name="dateTot"/></br>
                	<label> Dâte au plus tard </label> <input type="date" name="dateTard"/></br>
                	<label> Rayon de recherche </label> <input type="text" name="distance" /></br>
                	<label> Prix </label> <input type="text" name="remuneration"/></br>
                	</br>  
                	<input type="submit" value="Rechercher"/>    
            	</form>  
    	</div>
	</body>
</html>


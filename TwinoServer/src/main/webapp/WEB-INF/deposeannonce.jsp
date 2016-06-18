<%-- 
    Document   : deposeannonce
    Created on : 6 juin 2016, 16:15:01
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
 <head>
    	<script>
        	function show(shown, hidden) {
            	document.getElementById(shown).style.display='block';
            	document.getElementById(hidden).style.display='none';
            	return false;
        	}
    	</script>
<script type="text/javaScript">
        	var i = 2 ;
        	var Ajout;
       	 
        	function fAddText() {
            	var Contenu = document.getElementById('Cible').innerHTML;
            	if (i==2){
                	Ajout=Contenu;
            	}
            	Contenu = Contenu + '<br/>' + '<h1> Tache n°' + i + '</h1></br>' + Ajout ;
            	i = i+1;
            	document.getElementById('Cible').innerHTML = Contenu;
        	}
    	</script>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<script type="text/javascript" src="afficher_cacher_div.js"></script>
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Déposer une annonce</title>
	</head>
	<body>
   	 
   	<%
      	String var= (String) session.getAttribute("utilisateur");
      	 
        	if (var != null) { %>
                	<header id="header">
   			 <h1><a href="index.jsp">Help Service</a></h1>
   			 <nav id="nav">
   				 <ul>
                                        	<li><a href="controleurProfil?action=menuProfil" >  <%  out.print(var); %>  </a> </li>
                                        	<li><a href='controleurProfil?action=menuProfil' > Mon Compte </a> </li>
                                        	<li><a href='controleurTache?action=rechercher' > Rechercher </a> </li>
                                        	<li><a href='controleurMessagerie?action=messagerie' > Messagerie </a> </li>
                                        	<li><a href="controleurProfil?action=logout" >  Deconnexion </a> </li>
   				 </ul>
   			 </nav>
   		 </header>

   	 
           	 
             	<%  }%>
     	<br>
    	 
	<%-- Section globale pour les deux pages --%>   	 
        	<div id="Page1">
            	<h1>Tache simple</h1></br>
            	<a href="#" onclick="return show('Page1','Page2');">Tâche simple</a>
            	<a href="#" onclick="return show('Page2','Page1');">Tâche multiple</a></br>
            	<form method="POST" action="controleurTache">
                	<input type="hidden" name="what" value="annonce"/>
                	<input type="hidden" name="action" value="rechercherparville"/>
                	<label> Titre de l'annonce : </label> <input type="text" name="titre"/>
                	<label> Description de l'annonce : </label><input type="text" class="style_input" name="description"/>
                	<label> Compétences </label>
                    	<select name="competences" multiple>
                        	<% LinkedList<String> competences = (LinkedList<String>)request.getAttribute("competences");
                        	if (competences != null){
                            	for(String compet : competences){
                                	out.print("<option value="+ compet+">" + compet + " </option>");
                            	}
                            	out.print("<input type=\"hidden\" name=\"competences\" value=\"parse\"");
                        	}
                        	%>
                    	</select>
                    	<label> Dâte au plus tôt </label> <input type="date" name="dateTot" placeholder="AAAA-MM-JJ"/>
                	<label> Dâte au plus tard </label> <input type="date" name="dateTard" placeholder="AAAA-MM-JJ"/>
                	<label> Adresse </label> <input type="text" name="ville"/>
                	<label> Rémunération </label> <input type="text" name="remuneration"/>
                	<input type="submit" value="Poster mon annonce"/>
            	</form>
        	</div>
               	 
        	<div id="Page2" style="display:none">
            	<h1>Tache multiple</h1></br>
            	<a href="#" onclick="return show('Page1','Page2');">Tâche simple</a>
            	<a href="#" onclick="return show('Page2','Page1');">Tâche multiple</a></br>
            	<form method="POST" action="controleurTache">
                	 
                	<input type="hidden" name="what" value="annonce"/>
                	<input type="hidden" name="action" value="rechercherparville"/>
                	<label> Description de l'annonce : </label><input type="text" class="style_input" name="descriptionGlobale"/>
                	<label> AdresseMail </label> <input type="text" name="adresseMail"/> <%-- A supprimer quand session faite--%>
               	 
                	<h1>Tache n°1</h1>
                    	<div id="Cible">
                        	<label> Titre de l'annonce : </label> <input type="text" name="titre"/>
                        	<label> Description de l'annonce : </label><input type="text" class="style_input" name="description"/>
                        	<label> Compétences </label>
                    	<select name="competences" multiple>
                        	<%if (competences != null){
                            	for(String compet : competences){
                                	out.print("<option value="+ compet+">" + compet + " </option>");
                            	}
                            	out.print("<input type=\"hidden\" name=\"competences\" value=\"parse\"");
                        	}
                        	%>
                    	</select>
                        	<label> Dâte au plus tôt </label> <input type="date" name="dateTot"/>
                        	<label> Dâte au plus tard </label> <input type="date" name="dateTard"/>
                        	<label> Adresse </label> <input type="text" name="ville"/>
                        	<label> Rémunération </label> <input type="text" name="remuneration"/>
                       	 
                    	</div>
                    	<br/>  <br/>   <br/>  <br/>
                    	<input type="button" value="Ajouter une tâche simple" onclick="fAddText()" /></br></br>
                    	<input type="submit" value="Poster mon annonce"/>    
            	</form>  	 
        	</div> 	 
	</body>
    
</html>




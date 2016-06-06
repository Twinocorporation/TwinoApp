<%-- 
    Document   : ModifierProfil
    Created on : 6 juin 2016, 16:23:22
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="twinoserver.modele.Profil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/WEB-INF/css.jsp" %>
    	<title>Modifier votre Profil</title>
	</head>
	<body>
   	 
<%
      	String var= (String) session.getAttribute("utilisateur");
      	 
        	if (var != null) { %>
                	<%@ include file="/WEB-INF/header_connecte.jsp" %>
        	<%  }
 %>
            	 
    	<section id="main" class="wrapper">
        	<div class="container">
<form method="POST" action="controleurTache">
   
        	<label> Email :</label> <input type="text" name="adresseMail" value="${profil.adresseMail}">
        	<label> Mot de Passe :</label> <input type="password" name="mdp" value="${profil.mdp}"/>
        	<div class="row uniform 50%">
   	
<label> Nom :</label> <input type="text" name="nom" value="${profil.nom}"/>
            	
   	
 <label> Prenom : </label> <input type="text" name="prenom" value="${profil.prenom}"/>
            	
        	</div>
                	<label> Date de Naissance : </label><input type="date" name="dateNaissance" value="${profil.dateNaissance}"/>
                	<label> Sexe : </label><select name="sexe"/>
        	<% Profil pro= (Profil) request.getAttribute("profil");
            	String sexe = pro.getSexe();
            	if (sexe.equals("0")){
                	out.print("<option value=\"0\" selected>Homme</option><option value=\"1\">Femme</option>");
            	}
            	else{
                	out.print("<option value=\"0\">Homme</option><option value=\"1\" selected>Femme</option>");
            	}
            	String adresse = (String) request.getAttribute("adresse");
        	%>
       	</select>
        	<label> Adresse : </label><input type="text" name="ville" value="<%=adresse%>"/>
 
        	<label> Compétences</label>
        	<select name="competences" multiple>
            	<%LinkedList<String> competencesUtil = (LinkedList<String>) request.getAttribute("competencesUtil");
              	LinkedList<String> competencesPossibles = (LinkedList<String>) request.getAttribute("competencesPossibles");
              	for (String compet : competencesUtil){
                    	out.print("<option value=" + compet + " selected>"+ compet + "</option>");
              	}
              	for (String compet : competencesPossibles){
                    	out.print("<option value=" + compet + ">"+ compet + "</option>");
              	}%>
        	</select>
       	 
        	<input type="hidden" name="action" value="rechercherparville" />
        	<input type="hidden" name="what" value="modifier" /></br>
        	<input type="submit" name="modif" value="Envoyer" />
    	</form>
    	</div>
    	</section>
   	 
	</body>
</html>

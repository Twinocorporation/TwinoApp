<%@page import="java.util.LinkedList"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="twinoserver.modele.Tache"%>
<%@page import="twinoserver.modele.TacheAtom"%>

<!DOCTYPE html>
<html>
	<head>
    	<script>
        	function show(shown, hidden, hidden2, hidden3) {
            	document.getElementById(shown).style.display = 'block';
            	document.getElementById(hidden).style.display = 'none';
            	document.getElementById(hidden2).style.display = 'none';
            	document.getElementById(hidden3).style.display = 'none';
            	return false;
        	}
    	</script>
<script type="text/javascript" src="afficher_cacher_div.js"></script>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<%@ include file="/WEB-INF/css.jsp" %>
    	<title>Gérer votre annonce</title>
    	<% String adresse = (String)request.getAttribute("adresse");%>
	</head>
	<body>
 	 
    	<!-- Header -->
    	<header id="header">
   			 <h1><a href="index.jsp">Help Service</a></h1>
   			 <nav id="nav">
   				 <ul>
                                         	<%
      	String var= (String) session.getAttribute("utilisateur"); %>
                                        	<li><a href="controleurProfil?action=menuProfil" >  <%  out.print(var); %>  </a> </li>    
                                        	<li><a href='controleurProfil?action=menuProfil' > Mon Compte </a> </li>
                                        	<li><a href='controleurTache?action=rechercher' > Rechercher </a> </li>
                                        	<li><a href='controleurMessagerie?action=messagerie' > Messagerie </a> </li>
                                        	<li><a href="controleurProfil?action=logout" >  Deconnexion </a> </li>
   				 </ul>
   			 </nav>
    	</header>

 </div>

    	<%-- Section globale pour les 4 pages --%>  
    	<div class="container"><div id="Page1">
       	 
        	</br>

        	<% TacheAtom ta = (TacheAtom) request.getAttribute("tacheAtom"); //On récupère la tache atomique
            	LinkedList<String> competences = (LinkedList<String>) request.getAttribute("competences"); //on récupère les compétences de l'utilisateur
            	LinkedList<String> autresCompetences = (LinkedList<String>) request.getAttribute("autresCompetences"); //on récupère les autres compétences possibles
%>
        	<h3><b> Titre de l'annonce :</b> <%=ta.getTitre()%></h3>
        	<h3> <b>Description de l'annonce :</b> <%=ta.getDescription()%></h3>
        	<h3> <b>Compétences :</b> </h3>   
        	<% for (String compet : competences) {
                	out.print("<h4>" + compet + "</h4>");
            	}%>

        	<h3> <b>Dâte au plus tôt :</b> <%=ta.getDateTot()%></h3>
        	<h3> <b>Dâte au plus tard :</b> <%=ta.getDateTard()%></h3>
        	<h3> <b>Adresse :</b> <%=adresse%></h3>
        	<h3> <b>Rémunération :</b> <%=ta.getRemuneration()%></h3>
        	<h3> <b>Etat :</b> </h3>
        	<% if (ta.getEstEffectue() == 1) {
                	out.print("<h4> Terminée</h4>");
            	} else if (ta.getAdresseMailExec() != null) {
                	out.print("<h4> En cours d'exécution</h4>");
            	} else {
                	out.print("<h4> Tâche en attente d'exécutant</h4>");
            	}
        	%>
    	</div>

    	<div id="Page2" style="display:none">
       	 
        	<form method="POST" action="controleurTache">

            	<input type="hidden" name="action" value="rechercherparville"/>
            	<input type="hidden" name="what" value="modifAnnonce"/>
            	<label> Titre de l'annonce : </label> <input type="text" name="titre" value="<%=ta.getTitre()%>"/>
            	<label> Description de l'annonce : </label><input type="text" class="style_input" name="description" value="<%=ta.getDescription()%>"/>
            	<label> Compétences : </label>
            	<select name="competences" multiple>
                	<%if (competences != null) {
                        	for (String compet : competences) {
                            	out.print("<option value=" + compet + " selected>" + compet + " </option>");
                        	}
                    	}
                    	if (autresCompetences != null) {
                        	for (String compet : autresCompetences) {
                            	out.print("<option value=" + compet + ">" + compet + " </option>");
                        	}
                    	}%>
            	</select>
            	<label> Dâte au plus tôt : </label> <input type="date" name="dateTot" value="${tacheAtom.dateTot}"/>
            	<label> Dâte au plus tard : </label> <input type="date" name="dateTard" value="${tacheAtom.dateTard}"/>
            	<label> Adresse : </label> <input type="text" name="ville" value="<%=adresse%>"/>
            	<label> Rémunération : </label> <input type="text" name="remuneration" value="<%=ta.getRemuneration()%>"/>
            	</br>  
            	<input type="hidden" name="numTache" value="<%=request.getParameter("numTache")%>"/>
            	<input type="hidden" name="numTacheAtom" value="<%=request.getParameter("numTacheAtom")%>"/>
            	<input type="submit" value="Modifier mon annonce"/>    
        	</form>  	 
    	</div>

    	<div id="Page3" style="display:none">
       	 
        	<h3>Voulez-vous vraiment supprimer cette annonce ?</h3>
        	<form method="POST" action="controleurTache">

            	<input type="hidden" name="action" value="supprimerTache"/>
            	<input type="hidden" name="numTache" value="<%=request.getParameter("numTache")%>"/>
            	<input type="hidden" name="numTacheAtomique" value="<%=request.getParameter("numTacheAtom")%>"/>
            	<input type="submit" value="Oui" name="confirm">
            	<input type="submit" value="Non" name="confirm">
        	</form>    
        	</br>

    	</div>   

    	<div id="Page4" style="display:none">
       	 
        	<% if (ta.getEstEffectue() != 1) {%>
        	<h3> Vous ne pouvez pas évaluer un utilisateur tant que la tâche n'est pas exécuté !</h3>
        	<input type="button" onclick="window.history.back()" value="Tâches postées" />
        	<%} else {%>

        	<form method="POST" action="controleurTache">

            	<input type="hidden" name="action" value="evaluer"/>
            	<input type="hidden" name="numTache" value="<%=request.getParameter("numTache")%>"/>
            	<input type="hidden" name="numTacheAtomique" value="<%=request.getParameter("numTacheAtom")%>"/>
            	<input type="hidden" name="adressemailExec" value="<%=ta.getAdresseMailExec()%>">
            	<label> Note :</label><input type="number" min="0" max="5" name="note"/>
            	<label> Commentaire :</label><input type="text" name="commentaire">
            	<input type="submit" name="confirm">
        	</form>    
        	</br>
        	<%}%>
    	</div>
    	</div>
	</section>
	</body>

</html>


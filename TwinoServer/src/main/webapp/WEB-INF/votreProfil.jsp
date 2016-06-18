

<%@page import="twinoserver.modele.TacheAtom"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
	<head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Template site title
   ================================================== -->

	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<!-- Bootstrap CSS
   ================================================== -->
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<!-- Animate CSS
   ================================================== -->
	<link rel="stylesheet" href="css/animate.min.css">

	<!-- Font Icons
   ================================================== -->
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/et-line-font.css">

	<!-- Nivo Lightbox CSS
   ================================================== -->
	<link rel="stylesheet" href="css/nivo-lightbox.css">
	<link rel="stylesheet" href="css/nivo_themes/default/default.css">

	<!-- Owl Carousel CSS
   ================================================== -->
   	<link rel="stylesheet" href="css/owl.theme.css">
	<link rel="stylesheet" href="css/owl.carousel.css">

	<!-- BxSlider CSS
   ================================================== -->
   	<link rel="stylesheet" href="css/bxslider.css">

   	<!-- Main CSS
   	================================================== -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Google web font
   ================================================== -->
	<link href='https://fonts.googleapis.com/css?family=Raleway:700' rel='stylesheet' type='text/css'>
	
    	<title>Votre Profil</title>
	</head>
	<body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">
   	 
   <%
    	String var= (String) session.getAttribute("utilisateur");
      	 
    	if (var != null) { %>
        	<%@ include file="/WEB-INF/headerconnecte.jsp" %>
    	<%}
	%>

</br>
    	<section class="navbar navbar-fixed-top custom-navbar" role="navigation">
	

		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
			<a href="controleurTache" class="smoothScroll navbar-brand">Twino</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
                	<h2>Votre Compte !</h2>
                	<p><a href="controleurProfil?action=modifierProfil">Modifier mon profil</a>
                   	<a href="controleurTache?action=mesAnnonces">Annonces postées</a>
                   	<a href="controleurTache?action=mesTaches">Tâches en cours</a>
                   	<a href="controleurTache?action=historique">Historique</a></p>
            	</ul>
		</div>

	
            
 <p> Des tâches qui vous conviennent ...</p>
<% LinkedList<TacheAtom> tacheAtomique = (LinkedList<TacheAtom>) request.getAttribute("tacheAtom");
                 	LinkedList<String> competences = (LinkedList<String>)request.getAttribute("competences");
                   	for (TacheAtom ta : tacheAtomique){


                       	out.print("<pre><code><a href=\"controleurTache?action=searchAnnonceSuite&numTache=" + ta.getNumTache()  + "&numTacheAtom=" + ta.getNumTacheAtom()  + "\">" + ta.getTitre()  + "</a>"
                               	+ "     	Prix : " + ta.getRemuneration()  + ""
                               	+ "     	Date au plus tôt : " + ta.getDateTot()  + ""
                               	+ "     	Date au plus tard : " + ta.getDateTard() +"  <img src=\"images/" + competences + ".jpg\" width=30 heigth=30> "+ "</pre></code>");

                   	}
                	%>            	
    	</div>
	</section>
	</body>
</html>



<%-- 
    Document   : recevoirservice
    Created on : 14 mai 2016, 16:17:58
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>&#25105;&#24819;&#25552;&#20379;&#26381;&#21153;</title>
        
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

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


</head>
    <body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">
        
<header>
            <section class="navbar navbar-fixed-top custom-navbar" role="navigation">
	<div class="container">

		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
                    <a href="controleurTache" class="smoothScroll navbar-brand" >Twino</a>
		</div>


	</div>
                
                <%
                        	String var= (String) request.getAttribute("user");        	 
                        	if (var == "null") {
                    	%>
                    	<p> Mauvais identifiant ou mot de passe ! </p>
                    	<% } %>

</section>
</header>
        
        <!-- connexion section
================================================== -->
<section id="contact" class="parallax-section" >
	<div class="container">
		<div class="row">

			<!-- Section title
			================================================== -->
			<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
				<div class="section-title">
					<h5 class="wow bounceIn">&#25105;&#21018;&#26469;&#27861;&#22269;&#65292;&#25105;&#24819;&#25214;&#26381;&#21153;!?</h5>
					<h1 class="heading">&#30331;&#24405;</h1>
					<hr>
				</div>
			</div>

			<!-- Contact form section
			================================================== -->
			<div class="col-md-offset-1 col-md-10 col-sm-12">
				<form method="post" action="controleurProfil?action=connectera">
                                    <input type="hidden" name="action" value="connectera" />
                                    
                                    
                                    <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
						<label> Email    </label> &nbsp;&nbsp;<input class="searchinput" type="text" value="Email" onclick="this.value='';" name="email" id="s" /> <br/><br/>

					</div>
					<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
						<label> Mot de Passe   </label> &nbsp;&nbsp;<input class="searchinput" type="password" value="Mot de passe" onclick="this.value='';" name="mdp" id="s" /><br/><br/>

					</div>
					
					
					<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
						<input type="submit" value="Connexion" /> <br/><br/>
					</div>
                                  
                                    
						<a href="controleurProfil?action=inscriptionrecevoirservice"> <label> Si vous êtes pas encore inscrit, inscrivez vous!  </label></a>

					
				</form>
			</div>

			<!-- Contact detail section
			================================================== -->
			<div class="contact-detail col-md-12 col-sm-12">
				<div class="col-md-6 col-sm-6">
					<h3><i class="icon-envelope medium-icon wow bounceIn" data-wow-delay="0.6s"></i> EMAIL</h3>
					<p>hello@company.com</p>
				</div>
				<div class="col-md-6 col-sm-6">
					<h3><i class="icon-phone medium-icon wow bounceIn" data-wow-delay="0.6s"></i> PHONES</h3>
					<p>010-010-0110 | 090-090-0990</p>
				</div>
			</div>

		</div>
	</div>
</section>


<!-- Footer section
================================================== -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">

				<h2 class="wow bounceIn">Twnio</h2>
				
				<p>2016 Twnio 
                
                | Design: <a rel="nofollow" href="http://www.tooplate.com" target="_parent">Twnio</a></p>

			</div>
		</div>
	</div>
</footer>


<!-- Javascript 
================================================== -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/smoothscroll.js"></script>
<script src="js/nivo-lightbox.min.js"></script>
<script src="js/jquery.easing-1.3.js"></script>
<script src="js/plugins.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.parallax.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/custom.js"></script>

</body>
</html>


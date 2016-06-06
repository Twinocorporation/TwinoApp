<%-- 
    Document   : headerconnecte
    Created on : 6 juin 2016, 11:28:11
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Navigation section================================================== -->
<section class="navbar navbar-fixed-top custom-navbar" role="navigation">
	<div class="container">

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
            
				<!-- <li><a href="#home" class="smoothScroll">HOME</a></li> -->
                
				<li><a href="#work" class="smoothScroll">&#20851;&#20110;&#25105;&#20204;</a></li>
				<li><a href="#team" class="smoothScroll">&#22242;&#38431;&#20171;&#32461;</a></li>	
				<li><a href="#contact" class="smoothScroll">&#32852;&#31995;&#25105;&#20204;</a></li>
                                <li><a href="controleurProfil?action=menuProfil" >  <%  out.print(var);%>  </a> </li>
                                <li><a href='controleurProfil?action=menuProfil' > Mon Compte </a> </li>
                                <li><a href='controleurMessagerie?action=messagerie' > Messagerie </a> </li>
                                <li><a href="controleurProfil?action=logout" >  Deconnexion </a> </li>
			</ul>
		</div>

	</div>
</section>
    </body>
</html>

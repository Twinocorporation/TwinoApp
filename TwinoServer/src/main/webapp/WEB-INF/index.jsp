<%-- 
    Document   : index
    Created on : 6 juin 2016, 11:25:07
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">

	<!-- Template site title
   ================================================== -->
	<title>Twnio-&#30041;&#27861;&#20102;&#21527;？</title>

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
	
</head>

<body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">


<!-- Preloader section
================================================== -->
<section  class="preloader">

	<div class="sk-rotating-plane"></div>

</section>

<%
      	String var= (String) session.getAttribute("utilisateur");
      	 
        	if (var != null) { %>
            	<%@ include file="/WEB-INF/headerconnecte.jsp" %>
        	<%  }else{ %>
            	<!-- Navigation section================================================== -->
<section class="navbar navbar-fixed-top custom-navbar" role="navigation">
	<div class="container">

		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
			<a href="#home" class="smoothScroll navbar-brand">Twino</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
            
				<!-- <li><a href="#home" class="smoothScroll">HOME</a></li> -->
                
				<li><a href="#work" class="smoothScroll">&#20851;&#20110;&#25105;&#20204;</a></li>
				<li><a href="#team" class="smoothScroll">&#22242;&#38431;&#20171;&#32461;</a></li>	
				<li><a href="#contact" class="smoothScroll">&#32852;&#31995;&#25105;&#20204;</a></li>
			</ul>
		</div>

	</div>
</section>
            	<% }
 %>



<!-- Homepage section
================================================== -->
<div id="home">
	<div class="site-slider">
        <ul class="bxslider" >
			<li>
                <img src="images/slider/slide1.jpg" alt="slider image 1">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="slider-caption">
                                <h2>&#30041;&#27861;&#20102;&#21527;？</h2>
                                <p class="color-white">&#30041;&#23398;&#27861;&#22269;&#65292;&#25105;&#20204;&#20026;&#20320;&#24819;&#24471;&#26356;&#22810;！</p>
									<div class="whitebutton_home">
					<a href="controleurProfil?action=connexionrecevoirservice" ><button class="btn btn-default">&#25105;&#24819;&#24471;&#21040;&#26381;&#21153;</button></a>
                                        <a href="controleurProfil?action=connexiondonnerservice" ><button class="btn btn-default">&#25105;&#24819;&#25552;&#20379;&#26381;&#21153;</button></a>
                                        <a href="controleurProfil?action=justeregarder" ><button class="btn btn-default">&#25105;&#24819;&#38543;&#20415;&#30475;&#30475;</button></a>
                                        
									</div>
                            </div>

                        </div>
                    </div>
                </div>

            </li>
        </ul> <!-- /.bxslider -->
        
    </div> <!-- /.site-slider -->
</div>


<!-- Work section
================================================== -->
<section id="work" class="parallax-section">
	<div class="container">
		<div class="row">

			<!-- Section title
			================================================== -->
			<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
				<div class="section-title">
					<h5 class="wow bounceIn">Twino Service</h5>
					<h1 class="heading">&#25105;&#20204;&#30340;&#26381;&#21153;</h1>
					<hr>
					<p>&#22312;&#27861;&#22269;&#20154;&#29983;&#22320;&#19981;&#29087;&#65292;&#35821;&#35328;&#21448;&#19981;&#36890;&#24590;&#20040;&#21150;? &#27809;&#20851;&#31995;&#65292;&#25105;&#20204;&#26469;&#24110;&#24744;&#35299;&#20915;&#38382;&#39064;!</p>
				</div>
			</div>


			<!-- Work Owl Carousel section
			================================================== -->
			<div id="owl-work" class="owl-carousel">

				<div class="item col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
					<i class="icon-tools medium-icon"></i>
						<h3>SOCIAL MEDIA</h3>
						<hr>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>

				<div class="item col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
					<i class="icon-tablet medium-icon"></i>
						<h3>TRIP PLANNING</h3>
						<hr>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>

				<div class="item col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
					<i class="icon-bike medium-icon"></i>
						<h3>WEB MARKETING</h3>
						<hr>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>

				<div class="item col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
					<i class="icon-flag medium-icon"></i>
						<h3>EXPLORING PLACES</h3>
						<hr>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>

				<div class="item col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
					<i class="icon-basket medium-icon"></i>
						<h3>RECREATIONS</h3>
						<hr>
						<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				</div>

			</div>

		</div>
	</div>
</section>



<!-- team section
================================================== -->
<section id="team" class="parallax-section">
	<div class="container">
		<div class="row">

			<!-- Section title
			================================================== -->
			<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
				<div class="section-title">
					<h5 class="wow bounceIn">Twino Team</h5>
					<h1 class="heading">&#25105;&#20204;&#30340;&#22242;&#38431;</h1>
					<hr>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteu sunt in culpa qui officia deserunt.</p>
				</div>
			</div>



            
			<div class="col-md-4 col-sm-6 col-md-offset-1  wow fadeInUp" data-wow-delay="0.5s">
				<div class="team-wrapper">
					<img src="images/team1.jpg" class="img-responsive" alt="team img">
						<div class="team-des">
							<h4>&#40644;&#22855;&#20255;</h4>
							<h3>Trip Manager</h3>
							<ul class="social-icon">
								<li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
								<li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.6"></a></li>
							</ul>
						</div>
				</div>
			</div>
            

            
            <div class="col-md-4 col-sm-6 wow col-md-offset-2 fadeInUp" data-wow-delay="0.8s">
				<div class="team-wrapper">
					<img src="images/team2.jpg" class="img-responsive" alt="team img">
						<div class="team-des">
							<h4>&#38889;&#20219;&#39134;</h4>
							<h3>Location Explorer</h3>
							<ul class="social-icon">
								<li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
								<li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.6"></a></li>
							</ul>
						</div>
				</div>
			</div>
            
            <div class="col-md-4 col-sm-6 wow col-md-offset-1 fadeInUp" data-wow-delay="1.1s">
				<div class="team-wrapper">
					<img src="images/team3.jpg" class="img-responsive" alt="team img">
						<div class="team-des">
							<h4>&#21016;&#37324;&#36965;</h4>
							<h3>Location Explorer</h3>
							<ul class="social-icon">
								<li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
								<li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.6"></a></li>
							</ul>
						</div>
				</div>
			</div>
      
            <div class="col-md-4 col-sm-6 col-md-offset-2 wow fadeInUp" data-wow-delay="1.4s">
				<div class="team-wrapper">
					<img src="images/team4.jpg" class="img-responsive" alt="team img">
						<div class="team-des">
							<h4>&#35874;&#38742;&#36828;</h4>
							<h3>Location Explorer</h3>
							<ul class="social-icon">
								<li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
								<li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.6s"></a></li>
								<li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="0.6"></a></li>
							</ul>
						</div>
				</div>
			</div>

		</div>
	</div>
</section>

<!-- Contact section
================================================== -->
<section id="contact" class="parallax-section">
	<div class="container">
		<div class="row">

			<!-- Section title
			================================================== -->
			<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
				<div class="section-title">
					<h5 class="wow bounceIn">Contact Us</h5>
					<h1 class="heading">&#32852;&#31995;&#25105;&#20204;</h1>
					<hr>
					<p>&#26377;&#20219;&#20309;&#20851;&#20110;&#30041;&#23398;&#27861;&#22269;&#30340;&#38382;&#39064;&#37117;&#21487;&#20197;&#32852;&#31995;&#25105;&#20204;！</p>
				</div>
			</div>

			<!-- Contact form section
			================================================== -->
			<div class="col-md-offset-1 col-md-10 col-sm-12">
				<form action="#" method="post" class="wow fadeInUp" data-wow-delay="0.6s">
					<div class="col-md-4 col-sm-6">
						<input type="text" class="form-control" placeholder="&#21517;&#23383;" name="name">
					</div>
					<div class="col-md-4 col-sm-6">
						<input type="email" class="form-control" placeholder="&#37038;&#31665;" name="email">
					</div>
					<div class="col-md-4 col-sm-12">
						<input type="text" class="form-control" placeholder="&#26631;&#39064;" name="subject">
					</div>
					<div class="col-md-12 col-sm-12">
						<textarea class="form-control" placeholder="&#20869;&#23481;" rows="7" name="message"></textarea>
					</div>
					<div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
						<input type="submit" class="form-control" value="&#21457;&#36865;">
					</div>
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

				<h2 class="wow bounceIn">Twino</h2>
				<ul class="social-icon">
					<li><a href="#" class="fa fa-facebook wow fadeIn" data-wow-delay="0.3s"></a></li>
					<li><a href="#" class="fa fa-twitter wow fadeIn" data-wow-delay="0.6s"></a></li>
					<li><a href="#" class="fa fa-dribbble wow fadeIn" data-wow-delay="0.9s"></a></li>
					<li><a href="#" class="fa fa-behance wow fadeIn" data-wow-delay="1s"></a></li>
					<li><a href="#" class="fa fa-github wow fadeIn" data-wow-delay="1.3s"></a></li>
					<li><a href="#" class="fa fa-tumblr wow fadeIn" data-wow-delay="1.6s"></a></li>
				</ul>
				<p>2016 Twino 
                
                | Design: <a rel="nofollow"  target="_parent">Twnio</a></p>

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

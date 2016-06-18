<%-- 
    Document   : inscriretigong
    Created on : 14 mai 2016, 16:16:55
    Author     : user
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <meta charset="utf-8">

    <!-- Template site title
================================================== -->
    <title>Twnio-注册</title>

    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!--
    
    
    -->

    <link rel="stylesheet" href="avaterselect/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="avaterselect/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="avaterselect/artdialog/css/ui-dialog.css">
    <script type="text/javascript" src="avaterselect/js/jquery-2.0.3.js"></script>
    <script src="avaterselect/bootstrap/js/bootstrap.min.js"></script>
    <script src="avaterselect/artdialog/js/dialog-min.js"></script>
    <script src="avaterselect/artdialog/js/dialog-plus-min.js"></script>
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
    <link rel="stylesheet" href="css/radiobtn.css">
    <!-- Google web font
================================================== -->
    <link href='https://fonts.googleapis.com/css?family=Raleway:700' rel='stylesheet' type='text/css'>

</head>
<body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">
    <header><div class="container"><h1><a href="index.html" style="text-decoration: none; font-family:Arial, Helvetica, sans-serif; font-weight: 600;font-size: 24px; padding: 11px 15px; border: 4px solid black; " ><font color=black >Twino</font></a></h1></div></header>

    <!-- Preloader section
    ================================================== -->
    <section  class="preloader">

        <div class="sk-rotating-plane"></div>

    </section>




</body>
<section id="contact" class="parallax-section" >
    <div class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
                <div class="section-title">
                    <h5 class="wow bounceIn">&#25105;&#26159;&#32769;&#21496;&#26426;&#65292;&#25105;&#35201;&#25552;&#20379;&#26381;&#21153;</h5>
                    <h1 class="heading">&#27880;&#20876;</h1>
                    <hr>
                </div>
            </div>
            <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">


                <form action="controleurProfil?action=creerUtilisateurtigong" method="POST" class="wow fadeInUp" data-wow-delay="0.6s">
                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        &#20197;&#19979;&#20026;&#24517;&#22635;&#20449;&#24687;
                    </div> 
                    <div class="col-md-2 col-sm-3" style="height:35px">


                        <input type="radio" id="radio01" name="sexe"  value="0">
                        <label for="radio01"><span></span>&#30007;&#29983;</label>
                    </div>

                    <div class="col-md-2 col-sm-3" style="height:35px">
                        <input type="radio" id="radio02" name="sexe" value="1">
                        <label for="radio02"><span></span>&#22899;&#29983;</label>
                    </div>
                    <div class="col-md-8 col-sm-0" style="height:35px">

                    </div>

                    <div class="col-md-4 col-sm-18">
                        <input type="text" class="form-control" placeholder="&#22995;&#27663;" name="nom" value="${param.nom}"  >
                    </div>
                    
                    <div class="col-md-4 col-sm-18">
                        <input type="text" class="form-control" placeholder="&#21517;&#23383;" name="prenom" value="${param.prenom}"  >
                    </div>
                    <div class="col-md-4 col-sm-18">
                        <input type="text" class="form-control" placeholder="&#29983;&#26085;:yyyy-mm-dd" name="dateNaissance" >
                    </div>

                    <div class="col-md-12 col-sm-18">
                        <input type="email" class="form-control" value="${param.adresseMail}"  placeholder="&#37038;&#31665;" name="adresseMail">
                    </div>
                    <div class="col-md-6 col-sm-18">
                        <input type="password" class="form-control" placeholder="&#23494;&#30721;" value="${param.mdp}" name="mdp">
                    </div>                       
                    <div class="col-md-6 col-sm-18" >
                        <input type="password" class="form-control" placeholder="&#30830;&#35748;&#23494;&#30721;" name="server_password_2" value="${param.server_password_2}" >
                    </div> 
                    
                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        &#35831;&#36873;&#25321;&#20320;&#21487;&#20197;&#25552;&#20379;&#30340;&#26381;&#21153;
                    </div>    
                    
                    <%LinkedList<String> competences = (LinkedList<String>) request.getAttribute("competences");
                    	if (competences != null) { %>
                                
  <div class="col-md-12 col-sm-18" style="height:54px; text-align: left;">

                        <input type="checkbox" id="checkbox1" name="competences" value="voiture"/>
                        <label for="checkbox1"><span></span>&#25509;&#26426;&#26381;&#21153;&#65306;&#29992;&#27773;&#36710;&#23558;&#23458;&#25143;&#20174;&#26426;&#22330;&#25509;&#21040;&#20854;&#20303;&#22320;。</label>
                    </div>
                    <div class="col-md-12 col-sm-18" style="height:54px; text-align: left;">

                        <input type="checkbox"  id="checkbox2"  name="competences" value="maison"/>
                        <label for="checkbox2"><span></span>&#25214;&#25151;&#26381;&#21153;&#65306;&#26681;&#25454;&#23458;&#25143;&#35201;&#27714;&#23547;&#25214;&#20986;&#31199;&#25151;&#24182;&#24110;&#21161;&#20854;&#32852;&#31995;&#25151;&#19996;。</label>
                    </div>
                    <div class="col-md-12 col-sm-18" style="height:54px; text-align: left;">

                        <input type="checkbox" id="checkbox3" name="competences" value="accueil"/>
                        <label for="checkbox3"><span></span>&#22659;&#22806;&#26381;&#21153;&#65306;&#24110;&#21161;&#23458;&#25143;&#22312;&#38134;&#34892;&#24320;&#25143;&#65292;&#20934;&#22791;&#30003;&#35831;&#23398;&#26657;&#30340;&#26448;&#26009;&#65292;&#20934;&#22791;&#23621;&#30041;&#26448;&#26009;&#20197;&#21450;&#31867;&#20284;&#30340;&#34892;&#25919;&#26381;&#21153;。</label>
                    </div>
                        
                         	<%}
                    	
                	%>

                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        &#20197;&#19979;&#20026;&#36873;&#22635;&#20449;&#24687;
                    </div> 

                    <div class="col-md-12 col-sm-18" style="height: 54px">
                        <a class="a-upload" id="cc">
    <input type="file" id="file"  multiple> &#28857;&#20987;&#36825;&#37324;&#19978;&#20256;&#29031;&#29255;
</a>
</div>


        <div id="prev"></div>


        <script>
            (function () {
                function createThumbnail(file) {
                    var reader = new FileReader();
                    reader.addEventListener('load', function () {
                        var imgElement = document.createElement('img');
                        imgElement.style.maxWidth = '150px';
                        imgElement.style.maxHeight = '150px';
                        imgElement.src = this.result;
                        prev.appendChild(imgElement);
                    });
                    reader.readAsDataURL(file);
                }

                var allowedTypes = ['png', 'jpg', 'jpeg', 'gif'],
                        fileInput = document.querySelector('#file'),
                        prev = document.querySelector('#prev');

                fileInput.addEventListener('change', function () {

                    var files = this.files,
                            filesLen = files.length,
                            imgType;

                    for (var i = 0; i < filesLen; i++) {
                        imgType = files[i].name.split('.');
                        imgType = imgType[imgType.length - 1];
                        if (allowedTypes.indexOf(imgType) != -1) {
                            createThumbnail(files[i]);
                            document.getElementById("cc").style.backgroundColor="#BCF5A9";
                            document.getElementById("cc").innerHTML=" <input type='file' id='file'  multiple>&#28857;&#20987;&#36825;&#37324;&#26356;&#25442;&#29031;&#29255;";
                        }else{
                            alert("&#35831;&#30830;&#35748;&#24744;&#36873;&#25321;&#30340;&#22270;&#29255;&#26684;&#24335;&#20026; png、jpg、jpeg 或 gif。");
                        }
                    }
                });
            })();
        </script>
                     <div class="col-md-12 col-sm-18">
                        <input type="text" class="form-control" placeholder="&#30005;&#35805;&#21495;&#30721;" name="telephone" value="${param.telephone}">
                    </div>

                    <div class="col-md-12 col-sm-18" style="height: 54px; border-bottom: 3px solid #eee">
                    </div>  




                    <div class="col-md-12 col-sm-18" style="height:54px">

                        <input type="checkbox" id="checkbox4"  name="client_right" />
                        <label for="checkbox4"><span></span>&#25105;&#24050;&#38405;&#35835;&#24182;&#21516;&#24847;&#30456;&#20851;&#26381;&#21153;&#26465;&#27454;&#21644;&#38544;&#31169;&#25919;&#31574;</label>
                    </div>
                    <div class="blackbutton_home" style="margin-top: 15px; margin-right: -32px;">
                        <a href="recevoirservice.jsp" ><button class="btn btn-default">&#25552;&#20132;&#27880;&#20876;</button></a>
                    </div>


                </form>

            </div>

        </div>
</section>
                                    <input id="file" value="&#35774;&#32622;&#22836;&#20687;" type="file" multiple />
        <div id="prev"></div>

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

</html>

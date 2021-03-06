<%-- 
    Document   : verificationdocs
    Created on : 2016-5-20, 16:09:24
    Author     : Jingyuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <meta charset="utf-8">

    <!-- Template site title
================================================== -->
    <title>Twnio-身份验证</title>

    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
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
                    <h5 class="wow bounceIn">我是老司机，我要提供服务(✿≖ ◡ ≖)✧</h5>
                    <h1 class="heading">资质验证</h1>
              <h5 class="wow bounceIn"> 我们需要您提供相关材料的扫描件或清晰照片以便验证您的资质</h5>
                    <hr>
                </div>
            </div>
            <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">


                <form action="#" method="post" class="wow fadeInUp" data-wow-delay="0.6s">
                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        
                    </div> 

                    <div class="col-md-12 col-sm-18" style="height: 54px">

    			
            
				<!-- <li><a href="#home" class="smoothScroll">HOME</a></li> -->
                
			<a class="a-upload col-md-12 col-sm-9" >                       
    <input type="file" id="file1"  multiple>点击这里上传个人证件照
</a>




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
                        fileInput = document.querySelector('#file1'),
                         fileInput = document.querySelector('#file2')，
                          fileInput = document.querySelector('#file3')，
                           fileInput = document.querySelector('#file4')
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
                        }else{
                            alert("请确认您选择的图片格式为 png、jpg、jpeg 或 gif。");
                        }
                    }
                });
            })();
        </script>
        


                      


                   

                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        请选择你可以提供的服务
                    </div>                      
                    
                    <div class="blackbutton_home col-md-12 col-sm-18" style="margin-top: 15px; margin-right: -32px;">
                        <a href="recevoirservice.jsp" ><button class="btn btn-default">提交注册</button></a>
                    </div>


                </form>

            </div>

        </div>
</section>


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


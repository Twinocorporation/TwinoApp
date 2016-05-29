
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
                    <h5 class="wow bounceIn">我刚来法国，我想找服务(ﾟДﾟ≡ﾟдﾟ)!?</h5>
                    <h1 class="heading">注册</h1>
                    <hr>
                </div>
            </div>
            <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">


                <form action="#" method="post" class="wow fadeInUp" data-wow-delay="0.6s">
                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        以下为必填信息
                    </div> 
                    <div class="col-md-2 col-sm-3" style="height:35px">


                        <input type="radio" id="radio01" name="radio" >
                        <label for="radio01"><span></span>男生</label>
                    </div>

                    <div class="col-md-2 col-sm-3" style="height:35px">
                        <input type="radio" id="radio02" name="radio" >
                        <label for="radio02"><span></span>女生</label>
                    </div>
                    <div class="col-md-8 col-sm-0" style="height:35px">

                    </div>

                    <div class="col-md-4 col-sm-18">
                        <input type="text" class="form-control" placeholder="姓氏" name="server_nom">
                    </div>
                    
                    <div class="col-md-4 col-sm-18">
                        <input type="text" class="form-control" placeholder="名字" name="server_prenom">
                    </div>
                    <div class="col-md-4 col-sm-18">
                        <input type="text" class="form-control" placeholder="生日:yyyy-mm-dd" name="server_birthday">
                    </div>

                    <div class="col-md-12 col-sm-18">
                        <input type="text" class="form-control" placeholder="邮箱" name="server_mail">
                    </div>
                    <div class="col-md-6 col-sm-18">
                        <input type="password" class="form-control" placeholder="密码" name="server_password">
                    </div>                       
                    <div class="col-md-6 col-sm-18" >
                        <input type="password" class="form-control" placeholder="确认密码" name="server_password_2">
                    </div> 

                    

                    <div class="col-md-12 col-sm-18" style="height: 35px; border-bottom: 3px solid #eee; font-size: 25px; text-align: center">
                        以下为选填信息
                    </div> 

                    <div class="col-md-12 col-sm-18" style="height: 54px">
<a class="a-upload">
    <input type="file" id="file"  multiple>点击这里上传照片
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
                            document.getElementById("cc").innerHTML=" <input type='file' id='file'  multiple>点击这里更换照片";
                        }else{
                            alert("请确认您选择的图片格式为 png、jpg、jpeg 或 gif。");
                        }
                    }
                });
            })();
        </script>
                    <div class="col-md-12 col-sm-18">
                        <input type="text" class="form-control" placeholder="电话号码" name="server_phone">
                    </div>

                    <div class="col-md-12 col-sm-18" style="height: 54px; border-bottom: 3px solid #eee">
                    </div>  




                    <div class="col-md-12 col-sm-18" style="height:54px">

                        <input type="checkbox" id="checkbox4"  name="client_right" />
                        <label for="checkbox4"><span></span>我已阅读并同意相关服务条款和隐私政策</label>
                    </div>
                    <div class="blackbutton_home" style="margin-top: 15px; margin-right: -32px;">
                        <a href="recevoirservice.jsp" ><button class="btn btn-default">提交注册</button></a>
                    </div>


                </form>

            </div>

        </div>
</section>
                                    <input id="file" value="设置头像" type="file" multiple />
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


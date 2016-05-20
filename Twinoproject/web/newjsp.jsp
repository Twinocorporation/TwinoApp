<%-- 
    Document   : newjsp
    Created on : 2016-5-16, 17:30:16
    Author     : Jingyuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <input id="file" type="file" multiple />


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
                        }
                    }
                });
            })();
        </script>
        
        <script>
            $(".a-upload").on("change","input[type='file']",function(){
    var filePath=$(this).val();
    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
        $(".fileerrorTip").html("").hide();
        var arr=filePath.split('\\');
        var fileName=arr[arr.length-1];
        $(".showFileName").html(fileName);
    }else{
        $(".showFileName").html("");
        $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
        return false 
    }
})
    </script>
    </body>
</html>

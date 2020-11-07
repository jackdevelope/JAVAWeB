<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap 实例 - 条纹的进度条</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="progress progress-striped">
    <div class="progress-bar progress-bar-success" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 100%;">
        <span class="sr-only">100% 完成（成功）</span>
    </div>
</div>
<script>
    function loaddata() {
       var search = location.search; //获取url中"?"符后的字串
        var result = decodeURI(search);

        window.location.href ="../oper/userlogin.jsp";
    }
    window.onload=loaddata;
</script>
</body>
</html>

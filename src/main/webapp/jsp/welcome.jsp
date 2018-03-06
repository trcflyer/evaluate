<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录成功！</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/welcome.css">
  </head>
  <body>
     <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">
		<form action="list" method="post">
          <div class="inner-cover">
            <!--用EL语句调用出存到session里的usename  -->
            <h1 class="cover-heading">欢迎您前来投票</h1>
            <p class="lead">手机号：<input class="btn btn-lg btn-default" type="text" style="width:150px;height:30px;"  name="phone" /></p>
			<p class = 'message'><font color="red">${message }</font></p>
            <p class="lead">
              <input class="btn btn-lg btn-primary" style="width:240px;" type="submit" value="开始投票" />
            </p>
          </div>
          </form>
          	<img class = 'logo' alt="" src="img/logo.png">
          <div class="mastfoot">
            <div class="inner">
              <p>中国移动通信</p>
            </div>
          </div>

        </div>

      </div>

    </div>

  </body>
</html>
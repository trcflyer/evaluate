<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>  
<html>
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
  	<h2>后台管理系统</h2>
    <div style="margin:20px 0;"></div>
    <div class="mycenter" title="登陆" style="width:100%;max-width:200px;padding:30px 60px;">
        <form id="ff" method="post" action="login">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="username" style="width:100%" data-options="label:'用户名:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" type="password" name="password" style="width:100%" data-options="label:'密码:',required:true">
            </div>
            <div ><span style='color:red;font-size:13px;'>${message }</span></div>
            
            <div> <input type="submit"   class="input-submit" value="登陆"/></div>
        </form>
    </div>
</body>
</html>

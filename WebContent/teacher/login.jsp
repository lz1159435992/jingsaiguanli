<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>学生竞赛管理-登录</title>
<meta name="description" content="学生竞赛管理">
<meta name="keywords" content="学生竞赛管理">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script> 
<script src="${pageContext.request.contextPath}/js/login.js">
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Bootstrap/css/style.css"/>
</head>

<body style="background:url(${pageContext.request.contextPath}/img/loginbg.jpg) no-repeat;width:100%">
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
  <div class="container-fluid" style="margin-top:10px;">
    <div class="navbar-header pull-left"> <a href="#" class="navbar-brand"><strong>学生竞赛管理</strong></a> </div>
    <a type="button" class="btn btn-default pull-right" href="${pageContext.request.contextPath}/teacher/register.jsp"> <span class="glyphicon glyphicon-lock"></span> 注册 </a> </div>
</nav>
<div class="container" style="margin-top:200px;">
  <div class="row">
    <div class="col-md-4 col-md-offset-1 col-xs-10 col-xs-offset-1" 
    style="background-color:rgba(255,255,255,0.35); border:1px solid #fff;
    border-radius:15px;box-shadow:6px 6px 6px #fff;">
      <div class="row" style="margin:0;padding:15px;">
        <div class="col-md-12 text-center"> <span style="font-size:24px;line-height:35px;"> <strong style="color:#fff;">欢迎登录</strong></span> </div>
      </div>
      <div class="row" style="margin-top:20px;">
        <div class="col-md-12">
        
          <form class="form-horizontal" method="post" action="/jingsaiguanli/teacher?method=login" onsubmit="return check()">
            <div class="form-group col-xs-12 col-sm-10 col-md-10" style="margin:10px auto;">
              <div class="input-group"> <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
                <input type="text" class="form-control" id="t_name" name="t_name" autofocus 
                     required="required" placeholder="请输入姓名"  style="border-left:0"/>
             
              </div>
               <span style="color:red;"> ${msg_shenhe}</span>
            </div>
            <div class="form-group col-xs-12 col-sm-10 col-md-10" style="margin:10px auto;">
              <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                <input type="password" class="form-control" id="t_password" name="t_password" autofocus 
                     required="required" placeholder="请输入密码" style="border-left:0;"/>
              </div>
              <span style="color:red;"> ${msg_mima}</span> </div>
           
            <div class="form-group col-xs-6 col-md-3" style="margin:10px auto;padding-right:0" >
              <input required="required"  id="yzm" type="text" name="checkcode"  class="form-control yzm" style="border-radius:0;float:left"  placeholder="验证码"  >
            </div>
            <div class="form-group col-xs-6 col-md-4" style="margin: 10px auto;padding-left: 0"; >
     
            <img id="img1" src="/jingsaiguanli/CheckImgServlet" onclick="changeImg()"  class="img-responsive" alt="验证码" title="点击更换">
       
            <span id="yzm_span"><font color="red">${msg_yzm}</font></span>
            
             </div>
            <div class="col-xs-12 text-center" style="margin-top:20px">
              <button type="submit" id="login_button" class="btn btn-primary col-xs-9 sub" style="font-size:15px">登 录</button>
            </div>
          </form>
        </div>
      </div>
    </div>

  </div>
</div>
<!--底部版权区-->
<footer id="footer">
  <div class="container">
    <div class="col-md-4 col-xs-4">
      <div class="pull-left"><img src="{$smarty.const.IMG_URL}/tel.jpg" width="28" height="28" class="img-responsive"/><span class="hidden-xs">联系我们：</span><span class="tel">15634130256</span></div>
    </div>
    <div class="col-md-4 col-xs-4">
      <div class="text-center">
        <p class="hidden-xs">在线考试||电子作业||学习资源||学习论坛 </p>
        <P> 学生竞赛管理 ©  <span class="hidden-xs">2019</span> By xiaotao </P>
      </div>
    </div>
   
  </div>
</footer>
</body>
</html>
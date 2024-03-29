<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<!--bootstrap不支持IE的兼容模式,为了在IE运行最新的渲染模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>学生竞赛管理-注册</title>
<meta name="description" content="学生竞赛管理">
<meta name="keywords" content="学生竞赛管理">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css"/>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script> 
<script src="${pageContext.request.contextPath}/js/register.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Bootstrap/css/style.css"/>

</head>

<body style="background:url(${pageContext.request.contextPath}/img/loginbg.jpg) no-repeat; width:100%;">
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
  <div class="container-fluid" style="margin-top:10px;">
    <div class="navbar-header pull-left"> <a href="#" class="navbar-brand"><strong>学生竞赛管理</strong></a></div>
    <a type="button" class="btn btn-default pull-right" href="${pageContext.request.contextPath}/teacher/login.jsp"> <span class="glyphicon glyphicon-lock"></span> 登录 </a> </div>
</nav>
<div class="container" style="margin-top:200px;">
  <div class="row">
    <div class="col-md-4 col-md-offset-1 col-xs-10 col-xs-offset-1" 
    style="background-color:rgba(255,255,255,0.35); border:1px solid #fff;
    border-radius:15px;box-shadow:6px 6px 6px #fff;">
      <div class="row" style="margin:0;padding:15px;">
        <div class="col-md-12 text-center"> <span style="font-size:24px;line-height:35px;"> <strong style="color:#fff;">欢迎注册</strong></span> </div>
      </div>
      <div class="row" style="margin-top:20px;">
        <div class="col-md-12">
        
          <form  class="form-horizontal" role="form" action="${pageContext.request.contextPath}/teacher?method=register" method="post" onsubmit="return check()">
        
            <div class="form-group" style="margin:10px auto;">
              <label for="username" class="col-md-3 control-label">姓名</label>
              <div class="col-md-9">
                <input type="text" class="form-control" id="t_name" name="t_name" autofocus 
                     required="required" placeholder="请输入姓名"/>
                     <span id="t_name_span"></span> 
              </div>
               
            </div>
            <div class="form-group" style="margin:10px auto;">
              <label for="pwd" class="col-md-3 control-label">密码</label>
              <div class="col-md-9">
                <input type="password" class="form-control" id="pwd" name="t_password" autofocus 
                     required="required" placeholder="请输入密码"/>
              </div>
            </div>
            <div class="form-group" style="margin:10px auto;">
              <label for="qrpwd" class="col-md-3 control-label">确认密码</label>
              <div class="col-md-9">
                <input type="password" class="form-control" id="qrpwd" name="t_password2" autofocus 
                     required="required" placeholder="请再次输入密码"/>
                     <span id="t_password_span"></span> 
              </div>
            </div>
            <div class="form-group" style="margin:10px auto;">
              <label for="email" class="col-md-3 control-label">邮箱</label>
              <div class="col-md-9">
                <input type="email" class="form-control" id="email" name="t_email" autofocus 
                     required="required" placeholder="请输入邮箱"/>
              </div>
            </div>
            
              <div class="form-group" style="margin:10px auto;">
              <label for="email" class="col-md-3 control-label">学院</label>
              <div class="col-md-9">
                <input type="text" class="form-control" id="email" name="t_xueyuan" autofocus 
                     required="required" placeholder="请输入学院"/>
              </div>
            </div>

           <!--  <div class="form-group col-xs-6 col-md-3" style="margin:10px auto;padding-right:0" >
              <input type="text" name="captcha"  class="form-control" style="border-radius:0;float:left" required  placeholder="验证码"  >
            </div>

            <div class="form-group col-xs-6 col-md-4" style="margin:10px auto;padding-left: 0"; >
            <a href=""> <img id="yzm" src="{$smarty.const.__CONTROLLER__}/verifyImg" onclick="this.src='{$smarty.const.__CONTROLLER__}/verifyImg/'+Math.random()"  class="img-responsive" alt="验证码" title="点击更换"></a>
            <span style="color:red;">{$error1}</span> 
            </div> -->
            
            <div class="col-xs-12 text-center" style="margin:20px 0;">
              <button type="submit" class="btn btn-primary col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">注册</button>
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
    <div class="col-md-2 col-xs-2">
      <div class="pull-right"> </div>
    </div>
    <div class="col-md-2 col-xs-2">
      <div class="pull-left">  </div>
    </div>
  </div>
</footer>
</body>
</html>
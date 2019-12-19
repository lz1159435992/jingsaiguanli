$(function(){
	
	$("#t_name").blur(function(){
		$("#t_name_span").html("");
		//获得用户名
		var t_namevalue = $("#t_name").val();
		if(t_namevalue==""){
			$("#t_name_span").html("<font color='red'>姓名不能为空</font>");
			
		}
		//向服务器发送请求
		var url = "/jingsaiguanli/teacher?method=chachong";
		$("#t_name_span").load(url,{'t_name':t_namevalue},function(){
			
		});
	});
});

//验证表单 提交的时候
function check(){
  var pwd=document.getElementById('pwd');
  if(pwd.value!=qrpwd.value){
	  $("#t_password_span").html("<font color='red'>两次密码不一致</font>");
    return false;
  }
}
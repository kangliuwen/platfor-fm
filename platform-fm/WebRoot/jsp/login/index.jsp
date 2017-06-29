<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆</title>
     <%@include file="/jsp/tag.jsp"%>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  	<link rel="stylesheet" href="<%=path%>/statics/css/bootstrap.min.css">
  	<link rel="stylesheet" href="<%=path%>/statics/css/font-awesome.min.css">
  	<link rel="stylesheet" href="<%=path%>/statics/css/AdminLTE.min.css">
  	<link rel="stylesheet" href="<%=path%>/statics/css/all-skins.min.css">
  	<link rel="stylesheet" href="<%=path%>/statics/css/main.css">
	<script type="text/javascript"  src="<%=path%>/statics/libs/jquery.min.js"></script>
	<script type="text/javascript"  src="<%=path%>/statics/libs/vue.min.js"></script>
	<script type="text/javascript"  src="<%=path%>/statics/libs/bootstrap.min.js"></script>
	<script type="text/javascript"  src="<%=path%>/statics/libs/jquery.slimscroll.min.js"></script>
	<script type="text/javascript"  src="<%=path%>/statics/libs/fastclick.min.js"></script>
	<script type="text/javascript"  src="<%=path%>/statics/libs/app.js"></script>

  </head>
  
<body class="hold-transition login-page">
<div class="login-box" id="rrapp" v-cloak>
  <div class="login-logo">
    <b>通用权限系统</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
      <p class="login-box-msg">管理员登录</p>
      <div v-if="error" class="alert alert-danger alert-dismissible">
        <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> {{errorMsg}}</h4>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" v-model="username" placeholder="账号">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" v-model="password" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" v-model="captcha" @keyup.enter="login" placeholder="验证码">
        <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
      </div>
      <!-- 
      <div class="form-group has-feedback">
        <img alt="如果看不清楚，请单击图片刷新！" class="pointer" :src="src" @click="refreshCode">
        &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" @click="refreshCode">点击刷新</a>
      </div>
       -->
      
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" class="btn btn-primary btn-block btn-flat" @click="login">登录</button>
        </div>
        <!-- /.col -->
      </div>
    <!-- /.social-auth-links -->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<script type="text/javascript">
var vm = new Vue({
	el:'#rrapp',
	data:{
		username: '',
		password: '',
		captcha: '',
		error: false,
		errorMsg: '',
		src: 'captcha.jpg'
	},
	beforeCreate: function(){
		if(self != top){
			top.location.href = self.location.href;
		}
	},
	methods: {
		refreshCode: function(){
			this.src = "captcha.jpg?t=" + $.now();
		},
		login: function (event) {
			var data = "userName="+vm.username+"&password="+vm.password+"&captcha="+vm.captcha;
			$.ajax({
				type: "POST",
			    url: "login.do",
			    data: data,
			    dataType: "json",
			    success: function(result){
					if(result.data.success == true){//登录成功
						parent.location.href ='welcome.do';
					}else{
						vm.error = true;
						vm.errorMsg = result.data.msg;
						vm.refreshCode();
					}
				},
				error:function(result){
					alert("登陆出错:"+result.data.msg);
				}
			});
		}
	}
});
</script>
</body>
</html>

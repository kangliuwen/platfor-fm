<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/tag.jsp"%>
<html>
<head>
<title>KLW权限管理平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK rel="stylesheet" type="text/css" href="<%=path%>js/easyui/styles/default.css">
<%@ include file="/jsp/common_css.jsp"%>
<%@ include file="/jsp/common_js.jsp"%>
<SCRIPT type="text/javascript">
    var tabOnSelect = function(title) {
		//根据标题获取tab对象
		var currTab = $('#tabs').tabs('getTab', title);
		var iframe = $(currTab.panel('options').content);//获取标签的内容
		
		var src = iframe.attr('src');//获取iframe的src
		//当重新选中tab时将ifram的内容重新加载一遍，目的是获取当前页面的最新内容
		if (src)
			$('#tabs').tabs('update', {
				tab : currTab,
				options : {
					content : createFrame(src)//ifram内容
				}
			});

	};
	var _menus;
	$(function() {//预加载方法
		//通过ajax请求菜单
		 $.ajax({
			url : '<%=path%>/menuManager/getMenus.do',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				_menus = data;
				initMenu(_menus);//解析json数据，将菜单生成
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		}); 

		//tabClose();
		//tabCloseEven();

		$('#tabs').tabs('add', {
			title : '欢迎使用',
			content : createFrame('<%=path%>/fist.do')
		}).tabs({
			//当重新选中tab时将ifram的内容重新加载一遍
			onSelect : tabOnSelect
		});
		
		//修改密码
		$('#modifypwd').click(menuclick);

	});

	//退出系统方法
	function logout() {
		_confirm('您确定要退出本系统吗?',null,
				function(){
					location.href = '<%=path%>/logout.do';
				}
		)
	}
	
	//将后台获取的json菜单数据，组织成html
	
	/**
	
	{"data":{"list":[{"URL":"/item/queryItem.action","childrenMenu":[],"menuId":11,"menuName":"业务管理"},
	                 {"childrenMenu":[],"menuId":21,"menuName":"权限管理"}]},"succeed":true}
	**/
	function initMenu(menus_var) {
		$("#nav").accordion({animate:false}); 
		//循环处理json的菜单数据，组织成html
	    $.each(menus_var.data.list, function(i, n) {//外层循环处理一级菜单
			var menulist ='';
			menulist +='<ul>';
			// menulist += '<li><div><a title="'+n.menuName+'" ref="'+n.menuId+'" href="#" rel="' + n.menuUrl + '" icon="' + n.icon + '"  ><span class="icon '+n.icon+'" >&nbsp;</span><span class="nav">' + n.menuName + '</span></a></div></li> ';
	        $.each(n.childrenMenu, function(j, o) {//二层处理二级菜单
	        	//这里自定义了一些属性存放菜单的内容：title存放菜单名称rel存放菜单地址，这些在属性在点击菜单 时要取出值使用
	        	menulist += '<li><div><a title="'+o.menuName+'" ref="'+o.menuId+'" href="#" rel="' + o.URL + '" icon="' + o.icon + '"  ><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuName + '</span></a></div></li> ';
	        });
			menulist += '</ul>';//生成了菜单的html
			//自动创建菜单
			$('#nav').accordion('add', {
	            title: n.menuName,
	            content: menulist,//二级菜单的内容
	            iconCls: 'icon ' + n.icon
	        });

	    });
	    
	    //鼠标移动效果
	    //指定a的点击事件是menuclick
		$('.easyui-accordion li a').click(menuclick).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});

	}
	

	//帮助
	function showhelp(){
	    window.open('<%=path%>/help/help.html','帮助文档'); 
	}
	
	
</SCRIPT>



<META name="GENERATOR" content="MSHTML 9.00.8112.16540">
</HEAD>

<BODY style="overflow-y: hidden;" class="easyui-layout" scroll="no" >
	<DIV
		style='background: url("images/layout-browser-hd-bg.gif") repeat-x center 50% rgb(127, 153, 190); height: 30px; color: rgb(255, 255, 255); line-height: 20px; overflow: hidden; font-family: Verdana, 微软雅黑, 黑体;'
		border="false" split="true" region="north">
		<SPAN style="padding-right: 20px; float: right;" class="head">
			欢迎当前用户：${user.userName}&nbsp;&nbsp;
			<A href=javascript:showhelp()>使用帮助</A>
			&nbsp;&nbsp;
			<A title='修改密码' ref='modifypwd' href="#" rel='<%=path%>/user/updatepwd.action' icon='icon-null' id="modifypwd" >修改密码</A>
			&nbsp;&nbsp;
			<A id="loginOut" href=javascript:logout()>退出系统</A>

		</SPAN> <SPAN style="padding-left: 10px; font-size: 16px;"><IMG
			align="absmiddle" src="images/blocks.gif" width="20" height="20">
			KLW权限系统</SPAN> <SPAN style="padding-left: 15px;" id="News"></SPAN>
	</DIV>

	<DIV style="background: rgb(210, 224, 242); height: 30px;" split="false"
		region="south">

		<DIV class="footer">
			<!--  -->系统版本号：${version_number}&nbsp;&nbsp;&nbsp;发布日期：${version_date}
		</DIV>
	</DIV>

	<DIV style="width: 180px;" id="west" title="导航菜单" split="true"
		region="west" hide="true">

		<DIV id="nav" class="easyui-accordion" border="false" fit="true">
		</DIV>
	</DIV>

	<DIV style="background: rgb(238, 238, 238); overflow-y: hidden;"
		id="mainPanle" region="center">
		<DIV id="tabs" class="easyui-tabs" border="false" fit="true"></DIV>
	</DIV>


</BODY>
</HTML>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/jsp/tag.jsp"%>
<html>
<head>
<title>通用权限管理平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK rel="stylesheet" type="text/css" href="<%=path%>/js/easyui/styles/default.css">
<%@ include file="/jsp/common_css.jsp"%>
<%@ include file="/jsp/common_js.jsp"%>
<script type="text/javascript">
jQuery(function(){
$('#dg').datagrid({
	isField:"id",  
	pagination:true,//显示分页  
    pageSize:5,//分页大小  
    pageList:[5,10,15,20],//每页的个数  
    pagePosition:'bottom',
    fitColumns:true,  
    singleSelect:true,
    rownumbers:true,
    url:'<%=path%>/user/queryJson.do',
    columns:[[
        {field:'userId',title:'用户id',width:80,hidden:true},
        {field:'userCode',title:'用户编号',width:80},
        {field:'userName',title:'用户名称',width:80},
        {field:'emailAddress',title:'用户邮箱',width:100,align:'center'}
    ]]
});

})
</script>
</head>
  <body>
   <table id="dg" style="height:500px">
   <c:forEach items="${menuList}" var="menu" varStatus="status">
      <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="add">${menu.menuName}</a>  
   </c:forEach>
   </table>
  </body>
</html>

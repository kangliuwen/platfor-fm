<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="shortcut icon" type="image/x-icon" href="<%=path%>/favicon.ico" />  

<!-- basic styles -->
<link rel="stylesheet" href="<%=path%>/js/bootstrap-3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=path%>/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="<%=path%>/css/datepicker.css" />
<link rel="stylesheet" href="<%=path%>/css/ui.jqgrid.css" />
		
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
<link rel="stylesheet" href="<%=path%>/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>/css/ace-rtl.min.css" />
<link rel="stylesheet" href="<%=path%>/css/ace-skins.min.css" />


<script src="<%=path%>/js/ace-extra.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=path%>/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>
<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='<%=path%>/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>
<script src="<%=path%>/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/typeahead-bs2.min.js"></script>
<script src="<%=path%>/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=path%>/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=path%>/js/jquery.slimscroll.min.js"></script>
<script src="<%=path%>/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=path%>/js/jquery.sparkline.min.js"></script>
<script src="<%=path%>/js/bootstrap-datepicker.min.js"></script>
<script src="<%=path%>/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="<%=path%>/js/jqGrid/i18n/grid.locale-en.js"></script>
<script src="<%=path%>/js/flot/jquery.flot.min.js"></script>
<script src="<%=path%>/js/flot/jquery.flot.pie.min.js"></script>
<script src="<%=path%>/js/flot/jquery.flot.resize.min.js"></script>
<script src="<%=path%>/js/ace-elements.min.js"></script>
<script src="<%=path%>/js/ace.min.js"></script>
<script src="<%=path%>/js/bootbox.min.js"></script>
<script src="<%=path%>/js/ace-extra.min.js"></script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" language="javascript">
function exit(){
	alert('这里实现退出操作！');
	top.location.href="login.jsp";
}
</script>
</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="BillServlet" target="mainFrame"><img src="images/btn_bill.gif" onclick="check()"/></a></li>
	<li><a href="ProviderServlet" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="UserServlet" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	<li><a href="#" onClick="exit()"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
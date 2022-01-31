<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}
function updxinxi(id){
	location.href="UpdateProvider.jsp?id="+id;
};
function delxinxi(id){
	
	location.href="DeleteProviderServlet?id="+id;
};
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="get" action="SelectProviderServlet">
<input name="flag" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>

    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
    <td width="100"><div class="STYLE1" align="center">修改操作</div></td>
	<td width="100"><div class="STYLE1" align="center">删除操作</div></td>
  </tr>
  <c:forEach items="${requestScope.pro_list}" var="tmp">
  <tr>
    <td height="23"><span class="STYLE1">${tmp.provider_no }</span></td>
    <td><span class="STYLE1">${tmp.provider_name }</span></td>
    <td><span class="STYLE1">${tmp.provider_describe }</span></td>
    <td><span class="STYLE1">${tmp.provider_contacts }</span></td>
    <td><span class="STYLE1">${tmp.provider_tel }</span></td>
    <td><span class="STYLE1">${tmp.provider_loc}</span></td>
    <td>
		<a href="javaScript:updxinxi(${tmp.provider_id });">修改</a>		
	</td>
	<td>
		<a href="javaScript:delxinxi(${tmp.provider_id });">删除</a>
	</td>
  </tr>
  </c:forEach>
  
</tbody></table>
	</div>
</div>
</body></html>
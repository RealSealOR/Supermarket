<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<script type="text/javascript">
	function updxinxi(id){
		location.href="UpdateBill.jsp?id="+id;
	};
	function delxinxi(id){
		
		location.href="DeleteBillServlet?id="+id;
	};
</script>
<body>
<div class="menu">
	<form method="get" action="SelectBillServlet">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td width="70" height="29"><div class="STYLE1" align="center">账单编号</div></td>
				<td width="80"><div class="STYLE1" align="center">商品名称</div></td>
				<td width="100"><div class="STYLE1" align="center">商品数量</div></td>
				<td width="100"><div class="STYLE1" align="center">交易金额</div></td>
				<td width="100"><div class="STYLE1" align="center">是否付款</div></td>
				<td width="100"><div class="STYLE1" align="center">商品描述</div></td>
				<td width="100"><div class="STYLE1" align="center">账单时间</div></td>
				<td width="100"><div class="STYLE1" align="center">供应商编号</div></td>
				<td width="100"><div class="STYLE1" align="center">修改操作</div></td>
			    <td width="100"><div class="STYLE1" align="center">删除操作</div></td>
				
			</tr>
			<c:forEach items="${requestScope.bill_list}" var="tmp">
  			<tr>
	   			<td height="23"><span class="STYLE1">${tmp.bill_no }</span></td>
	    		<td><span class="STYLE1">${tmp.bill_proname }</span></td>
			    <td><span class="STYLE1">${tmp.bill_pronum }</span></td>
			    <td><span class="STYLE1">${tmp.bill_price }</span></td>
			    <td><span class="STYLE1">${tmp.bill_payment }</span></td>
			    <td><span class="STYLE1">${tmp.bill_prodescribe }</span></td>
			    <td><span class="STYLE1">${tmp.bill_date }</span></td>
			    <td><span class="STYLE1">${tmp.provider_id }</span></td>
			    <td>
					<a href="javaScript:updxinxi(${tmp.bill_id });">修改</a>		
				</td>
				<td>
					<a href="javaScript:delxinxi(${tmp.bill_id });">删除</a>
				</td>
  			</tr>
  			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
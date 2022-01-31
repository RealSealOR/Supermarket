<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.po.Bill" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">修改账单信息&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="UpdateBillServlet" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
		<%String id=request.getParameter("id"); %>
		
		<input name="flag" value="doAdd" type="hidden">
			<%
				Bill b2=(Bill)session.getAttribute("bill");
			%>
			<table class="box">
			
			<tbody>
				<tr>
					<td class="field">账单编号：</td>
					<td><input name="bill_id" value="<%=id %>" id="textfield2" class="text" type="text"> <font color="red">*</font></td>

				</tr>
				<tr>
					<td class="field">商品名称：</td>
					<td><input name="bill_name"  id="textfield2" class="text" type="text"> <font color="red">*</font></td>

				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td><input name="bill_num" id="textfield2" class="text" type="text"><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>

					<td><input name="money"   id="textfield2" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>

					<td><select name="payStatus">
						<option value="">请选择</option>
						<option value="1">已付款</option>
						<option value="0">未付款</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>

					<td><input name="desc"   id="textfield2" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商编号：</td>

					<td><input name="proid"   id="textfield2" class="text" type="text"></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" value="修改" class="input-button" type="submit"> 
			<input name="button" id="button" onclick="window.location='DepartServlet';" value="返回" class="input-button" type="button"> 
		</div>
	</form>
</div>
</body>
</html>

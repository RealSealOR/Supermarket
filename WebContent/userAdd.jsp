<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function checkit()
{
	//判断是否是数字的正则表达式
	return true;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="AddUserServlet" onsubmit="return checkit();">
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box">
			<tr>
					<td class="field">用户编号：</td>
					<td><input type="text" name="userId" id="textfield" class="text"/> <font color="red">*</font></td>

				</tr>
			<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="username" class="text" id="textfield2" /> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户密码：</td>

					<td><input type="password" name="password" class="text" id="textfield2" /> <font color="red">*</font></td>
				</tr>
			<tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="password1" class="text"/> <font color="red">*</font></td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
					<td><select name="sex" id="select">
    					<option value="0">女</option>
    					<option value="1">男</option>
  						</select></td>
				</tr>

				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="age" class="text" id="textfield2"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="mobile" class="text" id="textfield2"/> <font color="red">*</font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="address" id="textarea" class="text" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="auth" id="auth" value="2" checked="checked"/>普通用户
					<input type="radio" name="auth" id="auth" value="1" />经理</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="数据提交" class="input-button"/>
			  <input type="button" name="button" id="button" onclick="window.location='UserServlet';" value="返回" class="input-button"/> 
		</div>

	</form>
</div>
</body>
</html>

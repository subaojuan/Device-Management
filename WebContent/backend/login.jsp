
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@  taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript"src="../js/js.js"></script>
<style>
body{
background:#279BB1;
background-image: url("../images/login.jpg");
}
.form{
margin-left:550px;
margin-top:150px;
border:10px solid #9C8383;
width:300px;
height:300px;
background:white;
}
.table{
font-size:20px;
}
.chknumber_input{
width:40px;
}
</style>
</head>
 <!-- 打印错误信息 -->
   
<body>


 <div  style="color:red">
		${Message}
	</div>
<div class="form">
<form action="/DeviceMangement/servlet/login"method="post">
<center><h1>登录</h1></center>
<table cellpadding="0px"width="300px"height="200px"class="table">
<tr colspan="2">
<td align="right">用户名：</td>
<td><input type="text"name="username"id="name"/></td>
</tr>
<tr colspan="2">
<td align="right">密&nbsp;&nbsp;&nbsp;码：</td>

<td><input type="password"name="password"id="passwd"/></td>

</tr>
<tr colspan="2">
<td align="right">
<input type="radio" name="check" value="user" />user
</td>
&nbsp;&nbsp;&nbsp;&nbsp;
<td><input type="radio" name="check" value="admin" />admin</td>
</tr>
<tr colspan="2">
<td align="right">验证码：</td>
<td><img src="/DeviceMangement/CheckCodeServlet?21312" id="safecode" onclick="reloadcode()"/>
<input name="chknumber" type="text" id="chknumber" maxlength="4" class="chknumber_input" /></td>
</tr>
<tr>
<td align="right"><input type="submit"name="button"value="登录"></td>
<td align="center"><a href="../backend/register.jsp"><input type="button"name="button"value="注册"></a>
</td>
</tr>
</table>
</form><br/>
 <div  style="color:red">
		${ERROR_MESSAGE}
	</div>
</div>
</body>
</html>


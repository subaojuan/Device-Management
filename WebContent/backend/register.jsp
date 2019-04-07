
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@  taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style>
body{
/* background:#279BB1; */
background-image: url("../images/beijing.jpg");
}
.form{
margin-left:40%;
margin-top:10%;
border:10px solid #9C8383;
width:350px;
height:500px;
background:white;
}
.table{
font-size:20px;
}
</style>
</head>
<body style="bg">
<div class="form">
<form action="/DeviceMangement/RegisterServlet"method="post">
<center><h1>注册</h1></center>
<table cellpadding="0px"width="300px"height="400px"class="table" >
<tr>
<td align="right">用户名：</td>
<td><input type="text"name="name"id="name"/></td>
</tr>
<tr >
<td align="right">密&nbsp;&nbsp;&nbsp;码</td>
<td><input type="password"name="password"/></td>
</tr>

<tr>
<td align="right">电话</td>
<td><input type="text"name="phone"/></td>
</tr>
<tr>
<td align="right">email</td>
<td><input type="text"name="email"/></td>
</tr>
<tr>
<td align="right">住址</td>
<td><input type="text"name="address"/></td>
</tr>
<tr colspan="2">
<td align="right"><a href=""><input type="submit"name="button"value="注册" ></a>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>
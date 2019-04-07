<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"href="../css/bootstrap.min.css"/>
<title>Insert title here</title>
<style>
.div{
height:500px;
width:1000px;
margin-left:30px;
}
.li{
width:1000px;
height:45px;
background:#E8F2FE;
font-size:20px;
margin-bottom:30px;
}
 input {
            background: #E8F2FE; 
            height:45px;
            border-left: 0; 
            border-right: 0;
             border-top: 0; 
             border-bottom: 0; 
            }
            .lii{
            margin-left:600px;
            font-size:20px;
            width:30px;
            }
       .select{
       border-left:0;
       border-right: 0;
       border-top: 0;
       border-bottom: 0;
       
       
       
       
       }  
</style>
</head>
<body>
<div class="container">
<ul class="breadcrumb">
<li><a href="../backend/luyou.jsp">添加设备</a></li>
<li class="active">添加</li>
</ul>
<div class="div">
<form action="/DeviceMangement/./addExchangeServlet" method="post">
<ul style="list-style-type:none">
<li class="li">设备编号：<input type="text"name="devicenumber"/><br/></li>
<li class="li">设备名称：<input type="text"name="name"/><br/></li>
<li class="li">设备类别：<input  type ="text" name="category"> <br/></li>
<!-- 
                <select  class = "select" name="type" style="background-color: #E8F2FE ">
                  <option>路由器</option>
                  <option>计算机</option>
                  <option>交换机</option>
                </select> -->
  
<li class="li">领用人：<input type="text"name="leader"/><br/></li>
<li class="li">实验室：<input type="text"name="lab"/><br/></li>
<li class="li">是否使用：<input type="text"name="isuse"/></li>
<li class="lii"><input type="submit"name=""value="提交"/></li>
</ul>
</form>
</div>
</div>
<script src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
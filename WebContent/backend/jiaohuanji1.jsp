<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@  taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"href="./css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<ul class="breadcrumb">
<li><a href="">首页</a></li>
<li class="active">交换机机管理</li>
</ul>
<table border="1px solid black"cellspacing="0"cellpadding="0"width="1000px"height="250px">
<tr>
<th>设备编号</th>
<th>名称</th>
<th>类别</th>
<th>领用人</th>
<th>实验室</th>
<th>是否领用</th>
<!-- <th colspan="3">设备操作</th> -->
</tr>
<c:if test="${empty requestScope.pageBean.list}">

  <tr>
  <td colspan="6">目前没有设备可以用</td>
     <td><a href="">修改设备</a></td>
  <td><a href="">删除设备</a></td>
  <td><a href="./backend/addExchange.jsp">增加设备</a></td>
 </tr> 
 </c:if>

<c:forEach items="${requestScope.pageBean.list}" var="a">
 <tr>
  <td>${a.number}</td>
  <td>${a.devicename}</td>
  <td>${a.type}</td>
  <td>${a.deviceUser}</td>
  <td>${a.laboratory}</td>
  <td>${a.isUse}</td>
  <%-- <td><a href="/DeviceMangement/queryExchangeDetailServlet?number=${a.number}">修改设备</a></td>
  <td><a href="/DeviceMangement/deleteExchangeServlet?number=${a.number}">删除设备</a></td>
  <td><a href="./backend/addExchange.jsp">增加设备</a></td> --%>
  </tr>
</c:forEach>

</table>


<%-- 构建分页导航 --%>
            共有${requestScope.pageBean.totalRecord}个计算机，共${requestScope.pageBean.totalPage}页，当前为${requestScope.pageBean.pageNumber}页
            <br/>
            <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=1">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNumber==1 && requestScope.pageBean.totalPage!=1}">
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNumber == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${requestScope.pageBean.pageNumber != i}">
                        <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${requestScope.pageBean.pageNumber+1}">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNumber > 1 && requestScope.pageBean.pageNumber < requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${requestScope.pageBean.pageNumber-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
                    <c:if test="${requestScope.pageBean.pageNumber == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${requestScope.pageBean.pageNumber != i}">
                        <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${requestScope.pageBean.pageNumber+1}">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${requestScope.pageBean.pageNumber == requestScope.pageBean.totalPage}">
            	<c:if test="${requestScope.pageBean.totalPage !=1 }">
                <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${requestScope.pageBean.pageNumber-1}">上一页</a>
                </c:if>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNumber == i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNumber != i}">
                        <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${i}">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="${pageContext.request.contextPath}/QueryServletExchange?pageNumber=${requestScope.pageBean.totalPage}">尾页</a>
</div>
<script src="./js/jquery-1.4.2.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备管理系统</title>
</head>
<frameset id="frame" framespacing="0" rows="150,500,*" border="2">
	<frame name="topFrame" scrolling="auto" marginheight="0"
		marginwidth="0" src="../backend/top.jsp" noresize="noresize"></frame>
	<frameset border="2" framespacing="0" cols="300,*">
		<frame name="leftFrame" scrolling="no" marginheight="0"
			marginwidth="0" src="../backend/left.jsp" noresize="noresize"></frame>
		<frame name="rightFrame" scrolling="auto"marginheight="0"
			marginwidth="0" src="../backend/main.jsp"></frame>
	</frameset>
	<frame name="bottomFrame" scrolling="no" marginheight="0"
		marginwidth="0" src="../backend/bottom.jsp" noresize="noresize"></frame>
</frameset>
</html>
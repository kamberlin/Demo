<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>站點列表</title>
<style>
table {
    border-collapse: collapse;
}
table, th, td {
    border: 1px solid black;
    align: center;
    text-align: center;
}
.up{
	width:30px;
	align:right;
	margin-left: 750px;
}
.buttom{
	margin-top: 10px;
}
</style>

</head>
<body>
	<form action="" method="post">
		<div class="up">
		<input type="button" value="返回" onclick="location.href='index.jsp'" />
		</div>
		<div class="buttom">
		<table width="800px">
			<tr>
				<th width="20%">站點</th>
				<th width="50%">修改時間</th>
				<th width="30%">動作</th>
			</tr>
			<c:forEach var="station" items="${stationList}">
				<tr>
					<td>${station.stationName}</td>
					<td>${station.updateTime}</td>
					<td><a href="">View</a> <a href="">Del</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</form>
</body>
</html>
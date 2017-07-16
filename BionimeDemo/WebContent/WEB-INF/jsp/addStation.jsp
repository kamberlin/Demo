<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增站點</title>
<c:if test="${result}">
	<script>
		alert("新增成功");
	</script>
</c:if>
</head>
<body>
	<form action="insertStation" method="post">
		<table>
			<tr>
				<td><input type="button" value="返回"
					onclick="location.href='index.jsp'" /></td>
				<td><input type="submit" value="新增" /></td>
			</tr>
			<tr>
				<td>站點名稱</td>
				<td><input type="text" name="stationName" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>站點明細</title>
<c:if test="${result}">
	<script>
		alert("編輯成功");
	</script>
</c:if>
<style>
.station{
    border: 1px solid black;
    align: center;
    text-align: center;
    border-collapse: collapse;
}
.station tr th{
    border: 1px solid black;
    align: center;
    text-align: center;
    border-collapse: collapse;
}
.station tr td{
    border: 1px solid black;
    align: center;
    text-align: center;
    border-collapse: collapse;
}

</style>
</head>
<body>
	<form action="modifyStation" method="post">
		<table>
			<tr>
				<td><input type="button" value="返回"
					onclick="location.href='index.jsp'" /></td>
				<td><input type="submit" value="儲存" /></td>
			</tr>
			<tr>
				<td>站點名稱</td>
				<td><input type="text" name="stationName" value="${station.stationName}"/>
				<input type="hidden" name="stationNo" value="${station.stationNo}"/></td>
			</tr>
		</table>
		<table class="station">
		<tr><th>員工編號</th><th>加入時間</th></tr>
		<c:forEach items="${stationDetailList}" var="stationDetail">
		<tr><td>${stationDetail.id.employeeNo}</td><td>${stationDetail.id.updateTime}</td></tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>
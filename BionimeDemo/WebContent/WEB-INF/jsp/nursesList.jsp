<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>護士列表</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
<script type="text/javascript">
		function deleteNurse(employeeNo) {
			//alert(employeeNo);
			$('#employeeNo').val(employeeNo);
			//alert("hello1");
			$('#mainForm').attr("action","deleteNurse");
			//alert("hello2");
			$('#mainForm').submit();
		}
		function viewNurse(employeeNo) {
			//alert(employeeNo);
			$('#employeeNo').val(employeeNo);
			//alert("hello1");
			$('#mainForm').attr("action","viewNurse");
			//alert("hello2");
			$('#mainForm').submit();
		}
	</script>
</head>
<body>
	<form action="" method="post" id="mainForm" name="mainForm">
		<div class="up">
		<input type="button" value="返回" onclick="location.href='index.jsp'" />
		</div>
		<div class="buttom">
		<table width="800px">
			<tr>
				<th width="20%">員編</th>
				<th width="50%">修改時間</th>
				<th width="30%">動作</th>
			</tr>
			<c:forEach var="nurses" items="${nursesList}">
				<tr>
					<td>${nurses.id.employeeNo}</td>
					<td>${nurses.id.updateTime}</td>
					<td><a href="#" onclick="viewNurse('${nurses.id.employeeNo}')">View</a> <a href="#" onclick="deleteNurse('${nurses.id.employeeNo}')">Del</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="employeeNo" id="employeeNo"/>
		</div>
	</form>
</body>
</html>
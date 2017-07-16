<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增護士</title>
<style>
.selectZone {
	width: 150px;
	height:200px;
}
</style>
<c:if test="${result}">
	<script>
		alert("新增成功");
	</script>
</c:if>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<form action="insertNurse" method="post" class="main">
			<table>
				<tr>
					<td><input type="button" value="返回"
						onclick="location.href='index.jsp'" /></td>
					<td><input type="submit" value="新增" /></td>
				</tr>
				<tr>
					<td>員工編號</td>
					<td><input type="text" name="employeeNo" /></td>
				</tr>
				<tr>
					<td>護士姓名</td>
					<td><input type="text" name="nurseName" /></td>
				</tr>
				</table>
				<table>
				<tr><td colspan="3">分配站點</td></tr>
				<tr>
					<td rowspan="2"><select multiple="multiple" size="10" id="stationList"
						name="stationList" class="selectZone">
							<c:forEach var="station" items="${stationList}">
								<option value="${station.stationName}">${station.stationName}</option>
							</c:forEach>
					</select></td>
					<td ><input type="button" value=">>" id="btnRight" /></td>
					<td rowspan="2"><select multiple="multiple" size="10"
						id="chooseStationList" name="chooseStationList" class="selectZone">

					</select></td>
				</tr>
				<tr><td><input type="button" value="&lt;&lt;" id="btnLeft" /></td></tr>
			</table>
	</form>
	<script type="text/javascript">
		$('#btnRight').click(
				function() {
					$('#stationList option:selected').each(
							function() {
								$("#chooseStationList").append(
										"<option value='" + $(this).val()
												+ "'>" + $(this).text()
												+ "</option");
								$("#chooseStationList option:last").attr(
										"selected", "selected");
								$(this).remove();
							});
				});

		$('#btnLeft').click(
				function() {
					$('#chooseStationList option:selected').each(
							function() {
								$("#stationList").append(
										"<option value='" + $(this).val()
												+ "'>" + $(this).text()
												+ "</option");
								$(this).remove();
								$("#stationList option:last").attr("selected",
										"selected");
							});
				});
	</script>
</body>
</html>
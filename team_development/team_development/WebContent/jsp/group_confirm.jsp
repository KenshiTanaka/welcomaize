<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>このグループでよろしいでしょうか。</title>
</head>
<body>
	<h1>グループ分け結果</h1>
	<table>
		<c:forEach begin="1" end="${gNum}" step="1" var="i">
			<tr>
				<th>${i}</th>
				<td><c:forEach var="ut" items="${utList}">
						<c:if test="${ut.team.id == i}">
							<span>${ut.users.name}</span>
						</c:if>
					</c:forEach>
				<td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
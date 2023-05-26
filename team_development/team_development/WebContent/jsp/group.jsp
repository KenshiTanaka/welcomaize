<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グループ分け</title>
</head>
<body>
	<h1>グループ作成</h1>
	<form action="<%=request.getContextPath()%>/group_create" method="post">
		<p>
			<label>分け方</label>
			<input type="radio" name="split" value="n">
			<label>名前順に分ける</label>
			<input type="radio" name="split" value="r">
			<label>ランダムに分ける</label>
		</p>
		<p>
			<label>用途</label>
			<input type="radio" name="use" value="s">
			<label>掃除</label>
			<input type="radio" name="use" value="o">
			<label>その他</label>
		</p>
		<p>
			<label>グループ数</label>
			<input type="text" name="gNumber">
			<label>グループ</label>
		</p>
		<input type="submit" value="作成">
		<input id="failure" type="hidden" value="${failure}">
		<a href="<%=request.getContextPath() %>/group_confirm.jsp">結果画面の表示</a>
	</form>
</body>
<script>
window.onload = () => {
	let failure = document.getElementById("failure").value;
	if(failure == "failure") {
		alert("失敗しました。");
	}
}
</script>
</html>
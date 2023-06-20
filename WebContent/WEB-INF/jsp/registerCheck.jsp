<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/registerCheck.css">
<title>新規登録確認</title>
</head>
<body>
	<div id="content"></div>
	<div class="wrap">
		<h1>新規登録</h1>
		<form action="RegisterCheckServlet" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td class="right">${user.id }</td>
			</tr>
			<tr>
				<td>姓</td>
				<td class="right">${user.l_name }</td>
			</tr>
			<tr>
				<td>名</td>
				<td class="right">${user.f_name }</td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td class="right">${user.pw }</td>
			</tr>
		</table>

		<input type="hidden" value="userID" name="${user.id }">
		<input type="hidden" value="userFamilyName" name="${user.l_name }">
		<input type="hidden" value="userName" name="${user.f_name }">
		<input type="hidden" value="userPW" name="${user.pw }">
		<div class="Btns">
			<input type="button" onclick="location.href='RegisterServlet'" value="修正する（戻る）">
			<input type="submit" value="完了する">
		</div>
		</form>
	</div>
</body>
<script src="/AllNightCalender/js/registerCheck.js"></script>
</html>
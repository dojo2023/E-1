<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/registerCheck.css">
<title>新規登録確認</title>
</head>
<body>
	<div id="content"></div>
	<div class="wrap">
		<h1>登録内容はこれでよろしいですか？</h1>

		<form action="RegisterCheckServlet" method="post">
		<table>
			<tr>
				<th>項目</th>
				<th>入力された内容</th>
			</tr>
			<tr>
				<td  class="left">ID</td>
				<td>${user.id }</td>
			</tr>
			<tr>
				<td class="left">姓</td>
				<td>${user.l_name }</td>
			</tr>
			<tr>
				<td class="left">名</td>
				<td>${user.f_name }</td>
			</tr>
			<tr>
				<td class="left">パスワード</td>
				<td>${user.pw }</td>
			</tr>
		</table>

		<input type="hidden" value="userID" name="${user.id }">
		<input type="hidden" value="userFamilyName" name="${user.l_name }">
		<input type="hidden" value="userName" name="${user.f_name }">
		<input type="hidden" value="userPW" name="${user.pw }">
		<div class="Btns">
			<input type="button" id="backBtn" onclick="location.href='RegisterServlet'" value="修正する（戻る）">
			<input type="submit" id="sendBtn" value="完了する">
		</div>
		</form>
	</div>
</body>
<script src="/AllNightCalender/js/registerCheck.js"></script>
</html>
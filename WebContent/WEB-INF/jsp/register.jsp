<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/register.css">
<title>新規登録</title>
</head>
<body>
	<div id="content"></div>
	<div class="wrap">
		<h1>新規登録</h1>
		<form name="myfrom" action="RegisterServlet" method="post">
		<div class="text">
			ログインID：<br>
			<input type="text" id="userID" name="userID" value="${user.id }" ><br>
			姓：<br>
			<input type="text" id="userFamilyName" name="userFamilyName" value="${user.l_name }"><br>
			名：<br>
			<input type="text" id="userName" name="userName" value="${user.f_name }"><br>
			パスワード：<br>
			<input type="text" id="userPW" name="userPW" value="${user.pw }"><br>
			</div>
			<div id="error">${result}</div>
			<input id="sendBtn" type="submit" value="新規登録">
		</form>
	</div>

</body>
<script src="/AllNightCalender/js/register.js"></script>
</html>
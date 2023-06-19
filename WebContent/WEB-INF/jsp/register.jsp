<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<p id="logo"> </p>
	<h1>新規登録</h1>
	<form name="myfrom" action="RegisterServlet" method="post">
		<p>ID<input type="text" id="userID" name="userID" value="${user.id }" ></p>
		<p>姓<input type="text" id="userFamilyName" name="userFamilyName" value="${user.l_name }"></p>
		<p>名<input type="text" id="userName" name="userName" value="${user.f_name }"></p>
		<p>パスワード<input type="text" id="userPW" name="userPW" value="${user.pw }"></p>
		<h6 id="error"></h6>
		<p><input id="sendBtn" type="submit" value="新規登録"></p>
	</form>
</body>
<script src="/AllNightCalender/js/register.js"></script>
</html>
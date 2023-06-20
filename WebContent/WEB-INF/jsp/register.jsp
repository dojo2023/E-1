<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/register.css">
<title>新規登録</title>
</head>
<body>
	<div id="content"></div>
	<div class="wrap">
		<h1>新規登録</h1>
		<form name="myfrom" action="RegisterServlet" method="post">
			<p><input type="text" placeholder="ID" id="userID" name="userID" value="${user.id }" ></p>
			<p><input type="text" placeholder="姓" id="userFamilyName" name="userFamilyName" value="${user.l_name }"></p>
			<p><input type="text" placeholder="名" id="userName" name="userName" value="${user.f_name }"></p>
			<p><input type="text" placeholder="パスワード" id="userPW" name="userPW" value="${user.pw }"></p>
			<p><input id="sendBtn" type="submit" value="新規登録"></p>
		</form>
	</div>

</body>
<script src="/AllNightCalender/js/register.js"></script>
</html>
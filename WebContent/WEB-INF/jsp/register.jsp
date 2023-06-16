<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<p id="logo"> </p>
	<h1>新規登録</h1>
	<form action="RegisterServlet" method="post">
		<p>ID<input type="text" name="userID" value="${user.id }" ></p>
		<p>姓<input type="text" name="userFamilyName" value="${user.l_name }"></p>
		<p>名<input type="text" name="userName" value="${user.f_name }"></p>
		<p>パスワード<input type="text" name="userPW" value="${user.pw }"></p>
		<p><input type="submit" value="新規登録"></p>
	</form>
</body>
</html>
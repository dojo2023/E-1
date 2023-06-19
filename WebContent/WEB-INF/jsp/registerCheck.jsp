<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<meta charset="UTF-8">
<title>新規登録確認</title>
</head>
<body>
	<p id="logo"></p>
	<h1>新規登録</h1>
	<form action="RegisterCheckServlet" method="post">
	<table>
		<tr>
			<th></th>
			<th>入力された内容</th>
		</tr>
		<tr>
			<td>ID</td>
			<td>${user.id }</td>
		</tr>
		<tr>
			<td>姓</td>
			<td>${user.l_name }</td>
		</tr>
		<tr>
			<td>名</td>
			<td>${user.f_name  }</td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td>${user.pw }</td>
		</tr>
	</table>

	<input type="hidden" value="userID" name="${user.id  }">
	<input type="hidden" value="userFamilyName" name="${user.l_name }">
	<input type="hidden" value="userName" name="${user.f_name }">
	<input type="hidden" value="userPW" name="${user.pw }">

	<input type="button" onclick="location.href='RegisterServlet'" value="修正する（戻る）">
	<input type="submit" value="完了する">
	</form>
</body>
</html>
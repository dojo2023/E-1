<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>ログイン</title>
</head>
<body>
	<div class="Content">
		<div class="header">
			<img src="/AllNightCalender/img/icon.png" class="logo">
			<img src="/AllNightCalender/img/login_font.png" class="logo">
		</div>
		<form name="myform" action="LoginServlet" method="post">
		    <div class="idpw">
				<p>ID　　　　　　<input id="userID" type="text" name="userID"></p>
				<p>パスワード　　<input id="userPW" type="password" name="userPW"></p>
			</div>
			<div class="ErrorAndNewLogin">
				<h6 id="error"></h6>
				<a  id="newlogin" href="/AllNightCalender/RegisterServlet">新規会員登録はこちら</a>
			</div>
			<input id="sendBtn" type="submit" value="ログイン">
			<input id="resetBtn" type="reset" value="リセット">
		</form>
	</div>
</body>
 	<script src="/AllNightCalender/js/login.js"></script>
</html>
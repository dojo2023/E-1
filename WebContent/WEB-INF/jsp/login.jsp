<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="css/login.css">
<title>ログイン</title>
</head>
<body>
	<div class="Content">
		<div class="header">
			<img src="/AllNightCalender/img/icon.png" id="tetu" class="logo">
			<img src="/AllNightCalender/img/login_font.png" id="login" class="logo">
		</div>
		<form name="myform" action="LoginServlet" method="post">
		    <div class="idpw">
				<input id="userID" placeholder="ID"  type="text" name="userID"><br>
				<input id="userPW" placeholder="PW"  type="password" name="userPW">
			</div>
			<div class="newLogin">
				<a  id="newlogin" href="/AllNightCalender/RegisterServlet">新規会員登録はこちら</a>
			</div>
			<div class="Btns">
				<input id="sendBtn" type="submit" value="ログイン">
				<input id="resetBtn" type="reset" onclick="resetContent()" value="リセット">
			</div>
		</form>
	</div>
</body>
 	<script src="/AllNightCalender/js/login.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="css/login.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>ログイン</title>
</head>
<body>
	<div id="content"></div>
	<div class="Content">
		<form name="myform" action="LoginServlet" method="post">
		    <div class="idpw">
		    ログインID：<br>
				<input id="userID" type="text" name="userID"><br>
			パスワード:
			</div>
				<div class="Pweyesolid">
					<input id="userPW" type="password" name="userPW">
					<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>
				</div>
			<div id="error">${result }</div>
			<div class="newLogin">
				<a  id="newlogin" href="/AllNightCalender/RegisterServlet">新規会員登録はこちら</a>
			</div>
			<div class="Btns">
				<input id="resetBtn" type="reset" onclick="resetContent()" value="リセット">
				<input id="sendBtn" type="submit" value="ログイン">
			</div>
		</form>
	</div>
</body>
 	<script src="/AllNightCalender/js/login.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ内容確認</title>
</head>
<body>
	<p id="logo"></p>
	<h1>以下の内容でよろしいでしょうか</h1>
	<form action="InquiryCheckServlet" method="post">

	<table>
		<tr>
			<th>項目</th>
			<th>入力された内容</th>
		</tr>
		<tr>
			<td>ジャンル</td>
			<td>${genre}</td>
		</tr>
		<tr>
			<td>お問い合わせ内容</td>
			<td>${text}</td>
		</tr>
	</table>

	<input type="hidden" value="userID" name="${user.id  }">
	<input type="hidden" value="userFamilyName" name="${user.l_name }">
	<input type="hidden" value="userName" name="${user.f_name }">
	<input type="hidden" value="userPW" name="${user.pw }">

	<input type="button" onclick="location.href='InquiryServlet'" value="修正する（戻る）">
	<input type="submit" value="送信">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ内容確認</title>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="/AllNightCalender/css/Inquiry.css">
</head>
<body>
<div class="container">
  <div class="time"></div>
  <div class="icon"><img src="/AllNightCalender/img\仮.png" width="50px"></div>
  <div class="inquiry_main">
    <!-- よくある質問の文字の左にアイコン設置 -->
  <div class="inline">
  <div class="mail_icon"><img src="/AllNightCalender/img\mailicon.png" width="50px"></div>
	<h1 class="inquiry-title">以下の内容でよろしいでしょうか</h1>
	  </div>

   <div class ="inquiry_check_form">
   <form action="InquiryCheckServlet" method="POST" >
	<table>
		<tr>
			<th>項目</th>
			<th>入力された内容</th>
		</tr>
		<tr>
			<td>ジャンル</td>
			<td>${inquiry.id}</td>
			<td>${inquiry.genre}</td>
		</tr>
		<tr>
			<td>お問い合わせ内容</td>
			<td>${inquiry.text}</td>
		</tr>
	</table>
	<div class="buttons">
	<input type="button"  class="fix"  onclick="location.href='InquiryServlet'" value="修正する（戻る）">
	<input type="submit"  class="send"  value="送信">
	</div>
	</form>
	</div>


	<input type="hidden" value="inquiryid" name="${id}">
	<input type="hidden" value="inquirygenre" name="${inquiry.genre}">
	<input type="hidden" value="inquirytext" name="${inquiry.text}">


</body>
</html>
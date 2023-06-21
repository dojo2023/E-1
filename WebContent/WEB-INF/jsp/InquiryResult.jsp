<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ完了</title>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="/AllNightCalender/css/Inquiry.css">
</head>
<body>
<div class="container">
 	<div class="time"></div>
  <div class="area-icon" id="main-icon"></div>
  <div class="inquiry_main">
    <!-- よくある質問の文字の左にアイコン設置 -->
  <div class="inline">
    <div class="mail_icon"><img src="/AllNightCalender/img\mailicon.png" width="50px"></div>
  <h1 class="inquiry-title">送信完了</h1>
    </div>


       <div class ="inquiry_result_form">
	<h3>お問い合わせが${result}しました</h3>
	</div>
  <div class="inquiry_hedder"></div>
  <div class="inquiry_footer"><a href="/AllNightCalender/CalendarServlet" class="homebutton">ホームに戻る</a></div>
  <div class="inquiry_left"></div>
  <div class="inquiry_right"></div>
    </div>
    </div>
</body>

<script src="/AllNightCalender/js/Inquiry.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ</title>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="/AllNightCalender/css/Inquiry.css">
</head>
<body>
<body>
<div class="container">
  <div class="time"></div>
  <div class="icon"><img src="/AllNightCalender/img\仮.png" width="50px"></div>
  <div class="inquiry_main">
    <!-- よくある質問の文字の左にアイコン設置 -->
  <div class="inline">
  <div class="mail_icon"><img src="/AllNightCalender/img\mailicon.png" width="50px"></div>
  <h1 class="yokuaru">お問い合わせ</h1>
  </div>

    <form action="/AllNightCalender/LoginServlet"  method="POST">
   <input type="hidden" name="id">

    ジャンル
    <select name="genre">
    <option value="point">ポイント</option>
     <option value="Schedule">スケジュール</option>
      <option value="timer">タイマー</option>
      <option value="others">その他</option>
    </select>

    お問い合わせ内容 <input type="text" name="text">
    <input type="submit" value="送信">
    </form>

  <div class="question_hedder"></div>
  <div class="question_footer"><a href="//AllNightCalender/CalendarServlet">ホームに戻る</a></div>
  <div class="question_left"></div>
  <div class="question_right"></div>
  </div>
    </div>
</body>
</body>
</html>
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

   <div class ="inquiry_form">
    <table>
    <form name="inquiry_forming" action="/AllNightCalender/LoginServlet"  method="POST">

<!-- id -->
   <input type="hidden" name="id">

<tr><th>ジャンル</th></tr>
    <tr><td> <select name="genre">
    <option value="point">ポイント</option>
     <option value="Schedule">スケジュール</option>
      <option value="timer">タイマー</option>
      <option value="others">その他</option>
    </select></td></tr>

 <tr><th>お問い合わせ内容 </th> </tr>
 <tr><td><input type="text" name="text"></td> </tr>
      </table>

    <td><input type="submit" value="送信" class="button"></td>
    </form>
</div>

  <div class="question_hedder"></div>
  <div class="question_footer"><a href="//AllNightCalender/CalendarServlet">ホームに戻る</a></div>
  <div class="question_left"></div>
  <div class="question_right"></div>
  </div>
    </div>
</body>
</body>
</html>
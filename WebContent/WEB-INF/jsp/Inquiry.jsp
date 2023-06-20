<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ</title>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="/AllNightCalender/css/Inquiry.css">
<script src="/AllNightCalender/js/Inquiry.js"></script>
</head>
<body>
<div class="container">
  <div class="time"></div>
  <div class="icon"><img src="/AllNightCalender/img\仮.png" width="50px"></div>
  <div class="inquiry_main">
    <!-- よくある質問の文字の左にアイコン設置 -->
  <div class="inline">
  <div class="mail_icon"><img src="/AllNightCalender/img\mailicon.png" width="50px"></div>
  <h1 class="inquiry-title">お問い合わせ</h1>
  </div>

   <div class ="inquiry_form">
   <form name="inquiry_forming" action="/AllNightCalender/InquiryServlet"  method="POST">
    <table>


<!-- id -->
   <input type="hidden" name="id">

	<tr><th>ジャンル</th></tr>
    <tr><td> <select name="genre" value="${inquiry.genre}">
    <option value="ポイント">ポイント</option>
     <option value="スケジュール">スケジュール</option>
      <option value="タイマー">タイマー</option>
      <option value="その他">その他</option>
    </select></td></tr>

 <tr><th>お問い合わせ内容 </th> </tr>
 <tr><td><textarea name="text"  cols="50"  rows="10"  style="width: 540px; height: 200px;" value="${inquiry.text}"></textarea></td> </tr>
      </table>

    <td><div class="align-right-angry">
    <input type="submit"  value="送信"  class="button"  onclick="return check()" ></div></td>
    </form>
</div>

  <div class="inquiry_hedder"></div>
  <div class="inquiry_footer"><a href="//AllNightCalender/CalendarServlet" class="homebutton">ホームに戻る</a></div>
  <div class="inquiry_left"></div>
  <div class="inquiry_right"></div>
  </div>
    </div>
</body>
</html>
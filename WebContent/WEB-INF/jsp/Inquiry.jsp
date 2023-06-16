<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ</title>
</head>
<body>
    <form action="//AllNightCalender/LoginServlet"  method="POST">
   <input type="hidden" name="id">
    ジャンル<select name="genre">
    <option value="point">ポイント</option>
     <option value="Schedule">スケジュール</option>
      <option value="timer">タイマー</option>
      <option value="others">その他</option>
    </select>
    お問い合わせ内容 <input type="text" name="text">
    <input type="submit" value="送信">
    </form>

   <a href="//AllNightCalender/CalendarServlet">ホームに戻る</a>
</body>
</html>
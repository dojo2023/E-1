<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="css/Calendar.css">
<title>カレンダー</title>
</head>
<body>



<div class="wrapper">
    <!-- xxxx年xx月を表示 -->
    <h1 id="header"></h1>

    <!-- ボタンクリックで月移動 -->
    <div id="next-prev-button">
        <button id="prev" onclick="prev()"></button>
        <button id="next" onclick="next()"></button>
    </div>

    <!-- カレンダー -->
    <div id="calendar"></div>
</div>




</body>
</html>
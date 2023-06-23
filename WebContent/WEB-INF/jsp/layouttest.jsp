<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/layouttest.css">
</head>



<body>
<div class="container">

<!--タイマー表示 -->
  <div class="time"></div>


<!--真ん中ゾーン区切り用のDIV、領域調整に使います -->
  <div class="calendarday">

  <!-- ここにカレンダー表示js飛ばしてください -->
    <div class="calendar-schedule">

    </div>

  </div>


  <!-- カレンダー詳細表示 -->
  <div class="calenderdetail">

  </div>


<!-- 週表示消えたのでただの飾りです -->
  <div class="monthweek-change"></div>

<!-- 今日も一日徹夜タイム！って出すとこ -->
  <div class="tetsuya">
    <div class="icon"></div>
  </div>
  <div class="leftmenu"></div>

  <!-- カレンダーの上部分 -->
  <div class="calender-up-menu">

    <!--前後月ボタン-->
    <div class="prev-text">
    	<button id="prev" onclick="prev()">←</button>
    	<button id="next" onclick="next()">→</button></div>

	<!-- 徹夜モード＆日表示 -->
    <div class="day-tetsuyamode-area">

	<!-- 徹夜モード表示 -->
   		<div class="tetsuya-mode">

   		</div>

	<!-- 日付表示 -->
   		<div class="dayview">

   		</div>


    </div>


  </div>
</div>
</body>


<script src="js/layouttest.js"></script>
</html>
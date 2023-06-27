<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/CalendarPrivate.css">
</head>
<body>
  	<div class="container">
	<div class="area-calendarleftmanu">
		<br>
		<div class="sigoto"><a href="http://localhost:8080/AllNightCalender/CalendarMonthModeChangeBusinessServlet"><img src="/AllNightCalender/img/カレンダー仕事モードoff.png"alt="仕事モード"></a><p>仕事モード</p>
    	<div class="sigoto"><img src="/AllNightCalender/img/カレンダープライベートモードon.png" alt="プライベートモード"><p>プライベートモード</p></div>
    	<div class="sigoto"><img src="/AllNightCalender/img/タイマーモードoff.png" onclick="showMenuTimer()" alt="タイマー"><p>タイマー</p></div>
		<div class="tekitoutetsuyatime"></div>
	</div>
</div>
    <div class="area-calendarupmanu"><!-- xxxx年xx月を表示 -->
    <div class="flex-want2">
    <h1 id="header"></h1>
<div class="area-mode">
			<img class="img-p" src="/AllNightCalender/img/プライベートモード上表示.png" >

  	</div>
  	</div>
      <!-- ボタンクリックで月移動 -->
        <div id="next-prev-button">
        <button id="prev" onclick="prev()">←</button>
        <button id="next" onclick="next()">→</button>
        </div>
    </div>
    <div class="area-calendarday">
    <div id="calendar"><a></a></div>
    </div>
    <div class="area-tetsuya">
	<div class="tekitoutetuya">
  		<input type="checkbox" id="tetsuyaCheckbox" class="tetsuyaArea">
  		<label class="tetsuya" for="tetsuyaCheckbox">
			<a href="http://localhost:8080/AllNightCalender/CalendarMonthTetsuyaChangeOnServlet"><img class="onImage" src="/AllNightCalender/img/徹夜モード.onpng" alt="offの画像" style="display: none;"></a>
    		<a href="http://localhost:8080/AllNightCalender/CalendarMonthTetsuyaChangeOnServlet"><img class="offImage" src="/AllNightCalender/img/徹夜モードoff.png" alt="onの画像"></a>
		</label>
	</div>
  	</div>

    <div class="area-icon" id="main-icon"></div>
    <div class="area-calendardetail">
      <a></a>
	<div id="timershow"></div>
<div class ="register-area">
		<label>用件</label>
      <input type="text" class="schedule-input" placeholder="用件">
      <label>開始時間</label>
      <input type="text" class="schedule-input" placeholder="開始時間"><label>～</label>
      <br>
      <label>終了時間</label>
      <input type="text" class="schedule-input" placeholder="終了時間">
      <br>
      <label>メモ</label>
      <input type="text" class="schedule-input" placeholder="メモ">
      <button type="button" onclick="registerSchedule()">登録</button>
 </div>
  </div>
    <div class="area-time"> <label>経過時間</label> <input type="text" id="i" value="00:00:00" class="a" required></div>
  </div>
</body>
<script src="js/CalendarPrivate.js"></script>
</html>
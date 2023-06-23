<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/Calendar.css">
</head>


<body>
  <div class="container">

<!--タイマー表示 -->
  <div class="time">
  	<div class="area-time">時間</div>
  </div>


  <div class="calendarday">
  <div class="area-calendarday">
  <!-- カレンダー -->
     <a> <div id="calendar"></div></a>
    </div>
  </div>

  <div class="calenderdetail">

  <div class ="register-area">
      <input type="text" class="schedule-input" placeholder="用件">
      <input type="text" class="schedule-input" placeholder="開始時間">
      <input type="text" class="schedule-input" placeholder="終了時間">
      <input type="text" class="schedule-input" placeholder="メモ">
      <button type="button" onclick="registerSchedule()">登録</button>
 </div>

  </div>

  <div class="menuicon-and-testuyaicon">
    <div class="tetsuya">
    <div class="area-icon" id="main-icon"></div>
    <div class="area-calendardetail"><a></a></div>
    <div class="icon"></div>
  </div>

<div class="calender-up-menu">
    <div class="prev-text">        <div id="next-prev-button">
        <button id="prev" onclick="prev()">←</button>
        <button id="next" onclick="next()">→</button>
        </div></div>

	<!-- 領域用クラス -->
    <div class="day-tetsuyamode-area">
    	<!-- 徹夜モード -->
    <div class="tetsuya-mode">
		<div class="area-mode">
		<div class="tekitoutetuya">
  		<input type="checkbox" id="tetsuyaCheckbox" class="tetsuyaArea">
  		<label class="tetsuya" for="tetsuyaCheckbox">
    		<img class="onImage" src="/AllNightCalender/img/徹夜モードon.png" alt="オンの画像" style="display: none;">
			<img class="offImage" src="/AllNightCalender/img/徹夜モードoff.png" alt="オフの画像">
		</label>
		</div>
		</div>
	</div>
    	<div class="dayview"><h1 id="header"></h1></div>
</div>

  <div class="leftmenu">
  	<div class="sigoto"></div><img src="/AllNightCalender/img/カレンダー仕事モードon.png"alt="仕事モード"><p>仕事モード</p> </div>
  	 	<div class="sigoto"><img src="/AllNightCalender/img/カレンダープライベートモードoff.png"alt="プライベートモード"><p>プライベートモード</p></div>
    	<div class="sigoto"><img src="/AllNightCalender/img/タイマーモードoff.png"alt="タイマー"><p>タイマー</p></div></div>
	</div>

</body>


<script src="js/CalendarSample.js"></script>
</html>

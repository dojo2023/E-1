<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/CalendarSample.css">
</head>


<body>

<div class="container">
  <div class="time"><div class="area-time">時間</div></div>

  <div class="calendarday">
    <a><!-- カレンダー --><div id="calendar"></div></a></div>

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
  <div id="main-icon">
    <div class="tetsuya"></div>
    <div class="icon"></div>
    </div>
  </div>


  <div class="leftmenu"><div class="sigoto"><img src="/AllNightCalender/img/カレンダー仕事モードon.png"alt="仕事モード"><p>仕事モード</p> </div>
  	 	<div class="sigoto"><img src="/AllNightCalender/img/カレンダープライベートモードoff.png"alt="プライベートモード"><p>プライベートモード</p></div>
    	<div class="sigoto"><img src="/AllNightCalender/img/タイマーモードoff.png"alt="タイマー"><p>タイマー</p></div></div>

  <div class="upmanu-3content">

    <div class="tetsuya-mode">	<div class="tekitoutetuya">
  		<input type="checkbox" id="tetsuyaCheckbox" class="tetsuyaArea">
  		<label class="tetsuya" for="tetsuyaCheckbox">
    		<img class="onImage" src="/AllNightCalender/img/徹夜モードon.png" alt="オンの画像" style="display: none;">
			<img class="offImage" src="/AllNightCalender/img/徹夜モードoff.png" alt="オフの画像">
		</label>
	</div>
	</div>
    <div class="prev-next"><div id="next-prev-button">
        <button id="prev" onclick="prev()">←</button>
        <button id="next" onclick="next()">→</button>
        </div></div>
    <div class="dayview"><h2 id="header"></h2></div>
  </div>




</div>

</body>


<script src="js/CalendarSample.js"></script>
</html>

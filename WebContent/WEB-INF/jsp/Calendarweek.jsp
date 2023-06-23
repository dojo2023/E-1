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

<div class="area-calendarleftmanu">
<div class="area-change">
	<div class="change">
  		<input type="checkbox" id="changeCheckbox" class="changeArea">
  		<label class="change" for="changeCheckbox">
    		<img class="weekmonthchange" src="/AllNightCalender/img/週.png" alt="仕事モードの画像" style="display: none;">
			<img class="weekmonthchange" src="/AllNightCalender/img/月.png" alt="オフの画像" >
		</label>
	</div>
  	</div>


<p >週/月</p>
    <div class="sigoto"><img src="/AllNightCalender/img/カレンダー仕事モードon.png"alt="仕事モード"><p>仕事モード</p> </div>
    <div class="sigoto"><img src="/AllNightCalender/img/カレンダープライベートモードoff.png"alt="プライベートモード"><p>プライベートモード</p></div>
    <div class="sigoto"><img src="/AllNightCalender/img/タイマーモードoff.png"alt="タイマー"><p>タイマー</p></div>
</div>

    <div class="area-calendarupmanu"><!-- xxxx年xx月を表示 -->
    <div class="flex-want2">
    <h1 id="header"></h1>

<div class="area-mode">
	<div class="mode">
  		<input type="checkbox" id="modeCheckbox" class="modeArea">
  		<label class="mode" for="modeCheckbox">
    		<img class="img-b" src="/AllNightCalender/img/プライベートモード上表示.png"  style="display: none";>
			<img class="img-p" src="/AllNightCalender/img/仕事モード上表示.png" >
		</label>
	</div>
  	</div>

  	</div>

      <!-- ボタンクリックで月移動 -->
        <div id="next-prev-button">
        <button id="prev" onclick="prev()">←</button>
        <button id="next" onclick="next()">→</button>
        </div>
    </div>



    <div class="area-calendarday">
     <a><!-- カレンダー --><div id="calendar"></div></a>


    </div>

    <div class="area-tetsuya">
	<div class="tekitoutetuya">
  		<input type="checkbox" id="tetsuyaCheckbox" class="tetsuyaArea">
  		<label class="tetsuya" for="tetsuyaCheckbox">
    		<img class="onImage" src="/AllNightCalender/img/徹夜モードon.png" alt="オンの画像" style="display: none;">
			<img class="offImage" src="/AllNightCalender/img/徹夜モードoff.png" alt="オフの画像">
		</label>
	</div>
  	</div>


    <div class="area-icon" id="main-icon"></div>
    <div class="area-calendardetail">
      <a></a>

<div class ="register-area">
      <input type="text" class="schedule-input" placeholder="用件">
      <input type="text" class="schedule-input" placeholder="開始時間">
      <input type="text" class="schedule-input" placeholder="終了時間">
      <input type="text" class="schedule-input" placeholder="メモ">
      <button type="button" onclick="registerSchedule()">登録</button>
 </div>

  </div>
    <div class="area-time">時間</div>
  </div>
</body>


<script src="js/Calendar.js"></script>
</html>
<!--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/Calendar.css">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
<div class="area-calendarday">
-->
<!--  <div class="container">-->
    <!-- xxxx年xx月を表示 -->
<!--      <h1 id="header"></h1>-->

    <!-- ボタンクリックで月移動 -->
 <!--   <div id="next-prev-button">
        <button id="prev" onclick="prev()">></button>
        <button id="next" onclick="next()">></button>
    </div>
  -->
    <!-- カレンダー
    <div id="calendar"></div>
   </div>
</div>   -->
  <!--  </div>  -->
<!--
<script src="js/Calendar.js"></script>
</body>
</html>
-->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/Calendar.css">
  <style>

  /*領域生成*/
.container {
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-columns: 0.6fr 4.4fr 0.7fr 1.3fr;
    grid-template-rows: 1fr 1.5fr 3fr 0.5fr;
    grid-template-areas: 'calendarleftmanu calendarupmanu tetsuya icon'
     'calendarleftmanu calendarday calendardetail calendardetail'
      'calendarleftmanu calendarday calendardetail calendardetail'
       'calendarleftmanu calendarday time time';
}

.area-calendarleftmanu {
    grid-area: calendarleftmanu;
}
.area-calendarupmanu {
    grid-area: calendarupmanu;
}

.area-tetsuya {
    grid-area: tetsuya;
}
.area-icon {
    grid-area: icon;
}
.area-calendarday {
    grid-area: calendarday;
}
.area-calendardetail {
    grid-area: calendardetail;
}
.area-time {
    grid-area: time;
}
/*領域を赤線で囲む*/
    .container * {
      border: 1px solid red;
      position: relative;
    }
  </style>
</head>
<body>
  <div class="container">

<div class="area-calendarleftmanu">
<p></p>
 <div class="switchArea">
  <input type="checkbox" id="switch1">
  <label for="switch1"><span></span></label>
  <div id="swImg"></div>




  </div>
  <p></p>
  <p></p>
  <p></p>
  <p></p>
<p >週/月</p>
    <div class="sigoto"><img src="/AllNightCalender/img/カレンダー仕事モードoff.png"alt="仕事モード"><p>仕事モード</p> </div>
    <div class="sigoto"><img src="/AllNightCalender/img/カレンダー仕事モードon.png"alt="プライベートモード"><p>プライベートモード</p></div>
    <div class="sigoto"><img src="/AllNightCalender/img/タイマーモードoff.png"alt="タイマー"><p>タイマー</p></div>
</div>

    <div class="area-calendarupmanu"><!-- xxxx年xx月を表示 -->
    <h1 id="header"></h1>
      <!-- ボタンクリックで月移動 -->
        <div id="next-prev-button">
        <button id="prev" onclick="prev()">←</button>
        <button id="next" onclick="next()">→</button>
        </div>
    </div>



    <div class="area-calendarday">
     <a href="https://saruwakakun.com/"><!-- カレンダー --><div id="calendar"></div></a>
<script src="js/Calendar.js"></script>

    </div>

    <div class="area-tetsuya">徹夜</div>
    <div class="area-icon" id="main-icon"></div>
    <div class="area-calendardetail">カレンダー詳細</div>
    <div class="area-time">時間</div>
  </div>
</body>
</html>

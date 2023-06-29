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

		<div class ="register-area">
		<div class ="himadesu">
		<div class ="today-himadesu">

		<form name="serch" action="CalendarMonthBusinessSerchServlet" method="post">
			<input type="text" name="Serch">
			<input type="submit" value="🔍">
		</form>

		<c:if test="${empty planList}">
			<p>今日は暇です、予定はありません。</p>
		</c:if>


	 	<form name="regist" action="CalendarMonthBusinessServlet" method="get">
	 		<input type="submit" value="新規登録">
	 	</form>

		<c:forEach var="e" items="${planList}" >
			<table class="list">
			<tr>
				<td>${e.s_day}</td>
				<td>${e.e_day}</td>
			</tr>
			<tr>
				<td>${e.s_time}</td>
				<td>${e.e_time}</td>
			</tr>
			<tr>
				<td>${e.what}</td>
			</tr>

			<tr>
				<form name="date" action="CalendarMonthBusinessServletUpdate" method="get">
					<td><input type="submit" name="SUBMIT" value=${e.number}></td>
				</form>
				<form name="date" action="CalendarMonthBusinessServletDelete" method="get">
				<td><input type="submit" name="DELETE" value=${e.number}></td>
				</form>
			</tr>
		</table>
		<br>
		<hr>
		<br>
	</c:forEach>
 </div>
 </div>

</div>
</div>
<div class="area-time"><input type="text" id="i" value="00:00:00" class="a" required></div>

</div>
</body>
<script src="js/CalendarPrivate.js"></script>
</html>
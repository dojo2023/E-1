<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/Calendar.css">
</head>

<body>

<input type="hidden" id="handan" value="">
<input type="checkbox" id="tetsuyatimeCheckbox" class="tetsuyatimeArea" style="display:none;">
  <div class="container">

<div class="area-calendarleftmanu">



<br>
	<div class="sigoto"><img src="/AllNightCalender/img/カレンダー仕事モードon.png"alt="仕事モード"><p>仕事モード</p> </div>
	<div class="sigoto"><a href="http://localhost:8080/AllNightCalender/CalendarMonthModeChangePrivateServlet"> <img src="/AllNightCalender/img/カレンダープライベートモードoff.png" alt="プライベートモード"></a><p>プライベートモード</p></div>

</div>

    <div class="area-calendarupmanu"><!-- xxxx年xx月を表示 -->
    <div class="flex-want2">
    <h1 id="header"></h1>

<div class="area-mode">

			<img class="img-p" src="/AllNightCalender/img/仕事モード上表示.png" >

  	</div>

  	</div>

      <!-- ボタンクリックで月移動 -->
        <div id="next-prev-button">
        <button id="prev" onclick="prev()">←</button>
        <button id="next" onclick="next()">→</button>
        </div>
    </div>



    <div class="area-calendarday">
     <!-- カレンダー --><div id="calendar"><a></a></div>


    </div>

    <div class="area-tetsuya">
	<div class="tekitoutetuya">
  		<input type="checkbox" id="tetsuyaCheckbox" class="tetsuyaArea">
  		<label class="tetsuya" for="tetsuyaCheckbox">
    		<a href="http://localhost:8080/AllNightCalender/CalendarMonthTetsuyaChangeOffServlet"><img class="onImage" src="/AllNightCalender/img/徹夜モードon.png" alt="オンの画像" style="display: none;"></a>
			<a href="http://localhost:8080/AllNightCalender/CalendarMonthTetsuyaChangeOnServlet"><img class="offImage" src="/AllNightCalender/img/徹夜モードoff.png" alt="オフの画像"></a>
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
 </div>
</body>
<script src="js/Calendar.js"></script>
</html>
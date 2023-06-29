
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
  <div class="container">

<div class="area-calendarleftmanu">



<br>
    <div class="sigoto"><img src="/AllNightCalender/img/カレンダー仕事モードon.png"alt="仕事モード"><p>仕事モード</p> </div>

   <!--  <div class="sigoto"><img src="/AllNightCalender/img/カレンダープライベートモードoff.png"alt="プライベートモード"><p>プライベートモード</p></div> -->
<div class="sigoto"><a href="http://localhost:8080/AllNightCalender/CalendarMonthPrivateServlet"> <img src="/AllNightCalender/img/カレンダープライベートモードoff.png" alt="プライベートモード"></a></div>
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
	<div id="timershow"></div>
<div class ="register-area">

	<form name="serch" action="CalendarMonthBusinessTetsuyaModeTimeOffSerchServlet" method="post">
		<input type="text" name="Serch">
		<input type="submit" value="検索">
	</form>

	 <form name="regist" action="CalendarMonthBusinessTetsuyaModeTimeOfServlet" method="get">
	 	<input type="submit" value="新規登録">
	 </form>

	<c:if test="${empty serchList}">
		<p>検索結果はありません。</p>
	</c:if>


	<c:forEach var="e" items="${serchList}" >
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
				<form name="date" action="CalendarMonthBusinessTetsuyaModeTimeOfServletUpdate" method="get">
					<td><input type="submit" name="SUBMIT" value=${e.number}></td>
				</form>
				<form name="date" action="CalendarMonthBusinessTetsuyaModeTimeOfServletDelete" method="get">
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
    <div class="area-time"><input type="text" id="i" value="00:00:00" class="a" required></div>
  </div>
</body>


<script src="js/Calendar.js"></script>
</html>

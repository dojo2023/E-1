
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/Calendar.css">
  	  <style>
	body {
		background-image: url("/AllNightCalender/img/${sessionScope.url}");
		background-size: cover;
	}
</style>
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
	<form method="POST" action="/AllNightCalender/CalendarMonthPrivateServletUpdate">
		<table>
		<tr>
		<td>用件</td>
		</tr>
		<tr>
		<td><input type="text" name="what" value="${e.what}"></td>
		</tr>
		<tr>
		<td>日時</td>
		</tr>
		<tr>
		<td><input type="text" name="s_day" value="${e.s_day}"></td>
		<td><input type="text" name="e_day" value="${e.e_day}"></td>
		</tr>
		<tr>
		<td><input type="text" name="s_time" value="${e.s_time}"></td>
		<td><input type="text" name="e_time" value="${e.e_time}"></td>
		</tr>
		<tr>
		<td>色</td>
		</tr>
		</table>
		<table value="${e.color}">
		<tr>
		<td><input type="radio" name="color" value="青" checked>青</td>
		<td><input type="radio" name="color" value="緑">緑</td>
		<td><input type="radio" name="color" value="赤">赤</td>
		<td><input type="radio" name="color" value="橙">橙</td>
		<td><input type="radio" name="color" value="黄">黄</td>
		<td><input type="radio" name="color" value="黒">黒</td>
		</tr>
		</table>
		<table>
		<tr>
		<td>メモ</td>
		</tr>
		<tr>
		<td><input type="text" name="memo" value="${e.memo}"></td>
		</tr>

		</table>
		<table>
			<tr>
				<td>
					<input type="submit" name="REGIST" value="更新">
					<input type="reset" name="reset" value="リセット">
				</td>
			</tr>
		</table>
	</form>


 </div>

  </div>
    <div class="area-time"><input type="text" id="i" value="00:00:00" class="a" required></div>
  </div>
</body>


<script src="js/Calendar.js"></script>
</html>

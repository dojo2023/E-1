
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
	<form method="POST" class="regist_form_area" action="/AllNightCalender/CalendarMonthBusinessServlet">
	<div class ="about_table">
		<table>
		<div class ="title_area">
		<h2>登録＋</h2>
		</div>

		<div class ="regist_task">
		<tr>
		<td>用件</td>
		</tr>
		<tr>
		<td><input type="text" name="what" value="${e.what}"></td>
		</tr>

		<div class ="regist_time">
		<tr>
		<td>日時</td>
		</tr>
		<tr>
		<td><input type="date" name="s_day" value="${e.s_day}" ></td>
		<div class ="namisen">
		<label name ="regist-namisen">~</label>
		</div>
		<td><input type="date" name="e_day" value="${e.e_day}" placeholder="19991214"></td>
		</tr>
		<tr>
		<td><input type="time" name="s_time" value="${e.s_time}" placeholder="23:00"></td>
		<td><input type="time" name="e_time" value="${e.e_time}" placeholder="08:00"></td>
		</tr>


		<div class ="set-plancolor">
		<tr>
		<td>色</td>
		</tr>
		</table>
		</div>
		<div class="color_table">
		<table value="${e.color}">
		<tr>
		<td><input type="radio" name="color" id="radioblue"  value="青" checked>
		<label for="radioblue"><img src="/AllNightCalender/img/青アイコン.png" width="20" height="20"></label></td>
		<td><input type="radio" name="color" id="radioGreen"  value="緑">
		<label for="radioGreen"><img src="/AllNightCalender/img/緑アイコン.png"  width="20" height="20"></label></td>
		<td><input type="radio" name="color" id="rediored"  value="赤">
		<label for="rediored"><img src="/AllNightCalender/img/赤アイコン.png"  width="20" height="20"></label></td>
		<td><input type="radio" name="color" id="redioOrange"  value="橙">
		<label for="redioOrange"><img src="/AllNightCalender/img/橙アイコン.png"  width="20" height="20"></label></td>
		<td><input type="radio" name="color" id="redioYellow"  value="黄">
		<label for="redioYellow"><img src="/AllNightCalender/img/黄アイコン.png"  width="20" height="20"></label></td>
		<td><input type="radio" name="color" id="redioBlack"  value="黒">
		<label for="redioBlack"><img src="/AllNightCalender/img/黒アイコン.png"  width="20" height="20"></label></td>
		</tr>
		</table>
		</div>
		</div>

		<div class="memo_table">
		<table>
		<tr>


		<td>メモ</td>
		</tr>
		<tr>
		<td><input type="text" name="memo" value="${e.memo}"></td>
		</tr>

		</table>
		</div>

		<div class="regist_submit">
		<table>
			<tr>
				<td>
					<input type="submit" name="REGIST" class="regist-submit" >
					<input type="reset" name="reset" class="regist-reset" >
				</td>
			</tr>
		</table>
		</div>
	</form>

 </div>
 <div class="area-time"><input type="text" id="i" value="00:10" class="a" style="display: none"; required></div>
 </div>


  </div>
</body>


<script src="js/Calendar.js"></script>
</html>

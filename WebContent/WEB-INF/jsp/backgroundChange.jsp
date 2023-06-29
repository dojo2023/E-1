<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
	<link rel="stylesheet" href="/AllNightCalender/css/backgroundChange.css">
	<title>カレンダー</title>
</head>

<div class="container">
  <div class="title"><h1>背景を変更できます</h1></div>
  <div class="box1">
			<div class ="youarerank">
				<p>あなたは今[ ${r} ]ランクです<br>
		   			白くなっている背景は<br>
		   			選択・設定出来ません</p><br>
			</div>
		<form method="post" name="contactForm" action="/AllNightCalender/BackgroundChangeServlet">
		<div class="btns">
			<input type="button" name="srank" src="/AllNightCalender/img/s6.jpg" id="button1" onclick="setUrl1() ; clickEven(event)" value="${j.sc_s}">
  			<input type="button" name="arank" src="/AllNightCalender/img/a6.jpg" id="button2" onclick="setUrl2() ; clickEven(event)" value="${j.sc_a}">
			<br>
				 	<div class="s"><p>Sランク</p></div>
				 	</div>
		<div class="a"><p>Aランク</p></div>
		<div class="inline">
			<input type ="button" class ="btn" value = "通常" id="button3"><br>
			<input type ="button" class ="btn" value = "選択解除" ><br>
			<input type="hidden" id="hidden" name="url" value="">
  			<input type="submit" value="確定(ホームに戻ると反映されます)">
		</div>
		</form>
		<div class="home">
		<a href="/AllNightCalender/CalendarServlet">ホームに戻る</a>
			</div>
		</div>

  <div class="box2">
		<div class="table2">
		<table border="1">
		    <tr>
		      <td>Sランク</td>
		      <td>１２５０ポイント以上</td>
		    </tr>

		    <tr>
		      <td>Aランク</td>
		      <td>１２５ポイント以上</td>
		    </tr>
		    <tr>
		      <td>Bランク</td>
		      <td>５０ポイント以上</td>
		    </tr>
		    <tr>
		      <td>Cランク</td>
		      <td>２５ポイント以上</td>
		    </tr>
		    <tr>
		      <td>Dランク</td>
		      <td>０ポイント以上</td>
		    </tr>
		</table>
		</div>
		<img src="/AllNightCalender/img/s6.jpg" alt="sランク背景">
		<img src="/AllNightCalender/img/a6.jpg" alt="aランク背景">
 </div>
</div>

<script>
	function setUrl1() {
		var hidden = document.getElementById("hidden");
		hidden.value = button.value;
	}
	function clickEven(event){
	      var button = event.target;
	      var buttons = document.getElementsByClassName('button');
	​
	      for (var i = 0; i < buttons.length; i++) {
	        buttons[i].classList.remove('selected');
	      }
	​
	      button.classList.add('selected');
	}
	function setUrl2() {
		var hidden = document.getElementById("hidden");
		var button = document.getElementById("button2");
	}
</script>
</html>
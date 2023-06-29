<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
	<link rel="stylesheet" href="/AllNightCalender/css/backgroundChange.css">
	<title>カレンダー</title>
	  <style>
	body {
		background-image: url("/AllNightCalender/img/${sessionScope.url}");
		background-size: cover;
	}
</style>
</head>

<body>

<header>
<h1>背景を変更できます</h1>
</header>

<main>
  <div class="wrapper">
	<div class="box2">
	 <div class="btns">
	<form method= "post" name="contactForm" action="/AllNightCalender/BackgroundChangeServlet">

  		<input type="button" name="srank" img src="/AllNightCalender/img/s6.jpg" id="button1" onclick="setUrl1()" value="${j.sc_s}">
  		<input type="button" name="arank" img src="/AllNightCalender/img/a6.jpg" id="button2" onclick="setUrl2()" value="${j.sc_a}"><br>

 		<input type ="button" class ="btn" value = "通常" id="button3"><br>

		<input type ="button" class ="btn" value = "選択解除" ><br>

		<input type="hidden" id="hidden" name="url" value="">
  		<input type="submit" value="確定">
	</form>

		<a href="/AllNightCalender/src/servlet/CalendarServlet.java">ホームに戻る</a>
	</div>
	</div>


	<div class="box">

		<p>あなたは今[ ${r} ]ランクです<br>
		   暗くなっている背景は<br>
		   選択・設定出来ません</p><br>

		<table align="center" border="1">
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
		<img src="/AllNightCalender/img/s6.jpg" alt="sランク背景">
		<img src="/AllNightCalender/img/a6.jpg" alt="aランク背景">
	</div>
  </div>

</main>
</body>
<script>
	function setUrl1() {
		var hidden = document.getElementById("hidden");
		var button = document.getElementById("button1");
		hidden.value = button.value;
	}

	function setUrl2() {
		var hidden = document.getElementById("hidden");
		var button = document.getElementById("button2");
		hidden.value = button.value;
	}

	if ("${r}" == "A"||"${r}" == "S"){
		}else{
		// disabled属性を設定
		let formElements = document.forms.contactForm;
		formElements.arank.disabled = true;
	}

	if ("${r}" == "S"){
		}else{
		// disabled属性を設定
		let formElements = document.forms.contactForm;
		formElements.srank.disabled = true;
	}






</script>




</html>
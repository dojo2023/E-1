<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
	<link rel="stylesheet" href="/AllNightCalender/css/backgroundChange.css">
	<title>カレンダー</title>
</head>

<body>

<header>
<h1>背景を変更できます</h1>
</header>

<main>
  <div class="wrapper">
	<div class="box btns">
		<input type ="submit" class ="btn" value = "Sランク" >
		<input type ="submit" class ="btn" value = "Aランク" ><br>
		<input type ="submit" class ="btn" value = "月限定Sランク" >
		<input type ="submit" class ="btn" value = "月限定Aランク" ><br>
		<input type ="submit" class ="btn" value = "通常" ><br>
		<input type ="submit" class ="btn" value = "確定" >
		<input type ="submit" class ="btn" value = "選択解除" ><br>
		<a href="/AllNightCalender/WebContent/css/backgroundChange.css">ホームに戻る</a>
	</div>


	<div class="box">

		<p>あなたは今[ ]ランクです<br>
		   暗くなっている背景は<br>
		   選択・設定出来ません</p><br>

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
  </div>


</main>
</body>



</html>
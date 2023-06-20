<%@page contentType="text/html; charset=UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>よくある質問</title>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<link rel="stylesheet" href="/AllNightCalender/css/FAQ.css">
<script src="/AllNightCalender/js/FAQ.js"></script>
<!-- <link rel="stylesheet" href="/AllNightCalender/css/AllNightCalendar.css"> -->
</head>
<body>
<div class="container">
  <div class="time"></div>
  <div class="icon"><img src="/AllNightCalender/img\仮.png" width="50px"></div>
  <div class="question_main">

  <!-- よくある質問の文字の左にアイコン設置 -->
  <div class="inline">
  <div class="hatena_icon"><img src="/AllNightCalender/img\yokuaru.png" width="50px"></div>
  <h1 class="yokuaru">よくある質問</h1>
  </div>


  <div class="question-collection">
 		  <div class="question-single">
 		  <table>
 		  <tr> <th>Q.このwebアプリは誰が作ったんですか？</th></tr>

   		  <tr> <td>システムエンジニア一年生の新入社員たちです</td></tr>
   		 </table>
   		  <hr>
		   </div>
 		  <div class="question-single">
 		  <table>
 		  <tr> <th>Q.不具合があるのですがどうすればいいでしょうか？</th></tr>

   		  <tr> <td>申し訳ございません。セッションのやり直し、キャッシュの削除などお試しください。
   		  それでもうまくいかない場合は「ホーム」→「お問い合わせ」からお困りの件にまつわるお問い合わせをお願いいたします。</td></tr>
   		 </table>
   		  <hr>
		   </div>

		   <!-- 隠しボタン -->
		   <div class="content">
  	<div class="inner">
  	<table>

   <tr>
   		<th><div class="wow"><a href="//AllNightCalender/CalendarServlet"> <button>ホームに戻る</button></a></th></div>
  		  <th> <div class="honmono"  onclick="poor(event)" ><button>ホームに戻る</button></th></div>
     		<th><div class="nisemono2" onclick="poor(event)"> <button>ホームに戻る</button></th></div>
     </tr>

      <tr>
       <td><div class="nisemono1" onclick="poor(event)"> <button>ホームに戻る</button></td></div>
     <td><button></button></td></div>
     <td><div class="nisemono2" onclick="poor(event)"> <button>ホームに戻る</button></td></div>
    </tr>

       <tr>
       <td><div class="nisemono1" onclick="poor(event)"> <button>ホームに戻る</button></td></div>
   <td> <div class="honmono" onclick="poor(event)"><button>ホームに戻る</button></td></div>
    <td><div class="nisemono2" onclick="poor(event)"> <button>ホームに戻る</button></td></div>
    </tr>

    </table>
  </div>
</div>




  <div class="question_hedder"></div>
  <div class="question_footer" >  <div class="home-return-button" onclick="poor(event)" ><a>ホームに戻る</a></div></div>
     </div>
  <div class="question_left"></div>
  <div class="question_right"></div>
</div>
</div>


</body>


 <!-- フッター（ここから） -->
<footer>

</footer>

</html>
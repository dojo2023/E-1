<%@page contentType="text/html; charset=UTF-8" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
<link rel="shortcut icon" href="/AllNightCalender/img\icon.png">
<meta charset="utf-8">
<script src='https://cdn.plot.ly/plotly-2.24.1.min.js'></script>
<title>ポイント詳細画面</title>
<link rel="stylesheet" href="css/pointDetial.css">
  <style>
	body {
		background-image: url("/AllNightCalender/img/${sessionScope.url}");
		background-size: cover;
	}
</style>
</head>

<body>
<header>


<div id="menu" class="site-menu">
    <ul>
     	<a href="/AllNightCalender/BackgroundChangeServlet"><li>背景変更</a></li>
        <a href="/AllNightCalender/FAQServlet"><li>よくある質問</li></a>
        <a href="/AllNightCalender/InquiryServlet"><li>お問い合わせ</li></a>
        <a href="/AllNightCalender/LogoutServlet"><li>ログアウト</li></a>
    </ul>
</div>

<button id="toggle-menu-button" onclick="showMenu()"><img src="/AllNightCalender/img/ハンバーガーメニュー.png"alt="" class="menu"></button>



<script>
const mainIcon = document.getElementById('main-icon');
fetch('js/icon_content.html')
  .then(response => response.text())
  .then(html => {
    mainIcon.innerHTML = html;
  });

var flag = 0;

function showMenu ()
{
if(flag == 0)
{
// クラスを追加している
document.getElementById("menu").classList.add("is-show");
flag = 1;
}
else
{
// クラスを削除している
document.getElementById("menu").classList.remove("is-show");
flag = 0;
}
}
</script>

</header>
<div id='myDiv'></div>
<c:forEach var="e" items="${g}" varStatus="s">
	<input type="hidden" id="${s.count }" value="${e.point_m}"></input>
</c:forEach>

<!-- どこからかJavascriptでデータを受け取りたい -->
<!-- 基準は今の年・月・日? -->
<!-- 年・月・日検索でポイントを引っ張って変数に入れたい -->
<!--  次の月へ移動するときはどうする？-->

<script>

//横軸
const month_x = [1,2,3,4,5,6,7,8,9,10,11,12];
const day_x = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31];

//縦軸
let day_y = [];
let total_y = [];
let total = 0;

for(let i = 1; i <= 31; i++){
	let e = document.getElementById(i);

	if(e !== null){
		day_y.push(e.value);
		total += parseInt(e.value);
	}else{
		day_y.push(0);
	}

	total_y.push(total);
}

//棒グラフ（１日の獲得量）
var trace1 = {
  x: day_x,
  y: day_y,
  name: '一日の獲得量',
  type: 'bar'
  };

//折れ線グラフ（今月のポイント獲得推移）
var trace2 = {
  x: day_x,
  y: total_y,
  name: 'ポイント獲得推移',
  yaxis: 'y2',
  type: 'scatter'
};

var data = [trace1, trace2];

var layout = {
  title: '獲得ポイント合計'+${point}+'pt',
  xaxis: {title: '一日の獲得量'},
  yaxis2: {
  title: 'ポイント獲得推移',
  titlefont: {color: 'rgb(148, 103, 189)'},
  tickfont: {color: 'rgb(148, 103, 189)'},
  overlaying: 'y',
  side: 'right'
  }
};

Plotly.newPlot('myDiv', data, layout);

</script>

<a href="/AllNightCalender/CalendarServlet" class="homebutton">ホームに戻る</a>

</body>

</html>
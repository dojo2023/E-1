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

</head>

<body>
<div id='myDiv'></div>

<!-- どこからかJavascriptでデータを受け取りたい -->
<!-- 基準は今の年・月・日 -->
<!-- 年・月・日検索でポイントを引っ張って変数に入れたい -->
<!--  次の月へ移動するときはどうする？-->

<script>
const nday = [1,2,3,4,5,6,7,8,9,10,11,12];
const month = [1, 0.5, 0.7, 1.2, 0.3, 0.4, 1, 0.5, 0.7, 1.2, 0.3, 0.4, ];
const total = [1,2,3,4,5,6,7,8,9,10,11,12];



var trace1 = {
  x: nday,
  y: month,
  name: '一日の獲得量',
  type: 'bar'
  };

var trace2 = {
  x: nday,
  y: total,
  name: 'ポイント獲得推移',
  yaxis: 'y2',
  type: 'scatter'
};

var data = [trace1, trace2];

var layout = {
  title: '獲得ポイント合計',
  yaxis: {title: '一日の獲得量'},
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

<a href="//AllNightCalender/CalendarServlet">ホームに戻る</a>
</body>

</html>
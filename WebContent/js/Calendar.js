
/**
 *
 */
const week = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
const today = new Date();
var showDate = new Date(today.getFullYear(), today.getMonth(), 1);

window.onload = function () {
    showProcess(today);
};

function prev() {
    showDate.setMonth(showDate.getMonth() - 1);
    showProcess(showDate);
}


/*次の月*/

function next() {
    showDate.setMonth(showDate.getMonth() + 1);
    showProcess(showDate);
}

function showProcess(date) {
    var year = date.getFullYear();
    var month = date.getMonth();
    document.querySelector('#header').innerHTML = (month + 1) + "/" + year;

    var calendar = createProcess(year, month);
    document.querySelector('#calendar').innerHTML = calendar;

    // 各日付セルにクリックイベントを追加
    var dateCells = document.querySelectorAll('.date-cell');
    for (var i = 0; i < dateCells.length; i++) {
        dateCells[i].addEventListener('click', function (event) {
            // 選択した日付のセルに赤い枠線を付ける
            var selectedDateCell = document.querySelector('.date-cell.selected');
            if (selectedDateCell) {
                selectedDateCell.classList.remove('selected');
            }
            this.classList.add('selected');
            showScheduleInput(this.dataset.date);
        });
    }
}

function createProcess(year, month) {
    var calendar = "<table><tr class='dayOfWeek'>";
    for (var i = 0; i < week.length; i++) {
        calendar += "<th>" + week[i] + "</th>";
    }
    calendar += "</tr>";

    var count = 0;
    var startDayOfWeek = new Date(year, month, 1).getDay();
    var endDate = new Date(year, month + 1, 0).getDate();
    var lastMonthEndDate = new Date(year, month, 0).getDate();
    var row = Math.ceil((startDayOfWeek + endDate) / week.length);

    for (var i = 0; i < row; i++) {
        calendar += "<tr>";
        for (var j = 0; j < week.length; j++) {
            if (i == 0 && j < startDayOfWeek) {
                calendar += "<td class='disabled'>" + (lastMonthEndDate - startDayOfWeek + j + 1) + "</td>";
            } else if (count >= endDate) {
                calendar += "<td class='disabled'>" + (count - endDate + 1) + "</td>";
                count++;
            } else {
                count++;
                if (year == today.getFullYear() && month == today.getMonth() && count == today.getDate()) {
                    calendar += "<td class='today date-cell' data-date='" + count + "'>" + count + "</td>";
                } else {
                    calendar += "<td class='date-cell' data-date='" + count + "'>" + count +"</td>";
                }
            }
        }
        calendar += "</tr>";
    }
    return calendar;
}

function showScheduleInput(date) {
    var scheduleInputArea = document.querySelector('.area-calendardetail');
    scheduleInputArea.innerHTML = "";

    var scheduleDate = document.createElement('h3');
    scheduleDate.textContent = date + "/" + (showDate.getMonth() + 1) + "/" + showDate.getFullYear();

    var schedulearea = document.createElement('a');

    var scheduleInput = document.createElement('input');
    scheduleInput.setAttribute('type', 'text');
    scheduleInput.setAttribute('class', 'schedule-input');
    scheduleInput.setAttribute('placeholder', '用件');

    var startTimeInput = document.createElement('input');
    startTimeInput.setAttribute('type', 'text');
    startTimeInput.setAttribute('class', 'schedule-input');
    startTimeInput.setAttribute('placeholder', '開始時間');

    var endTimeInput = document.createElement('input');
    endTimeInput.setAttribute('type', 'text');
    endTimeInput.setAttribute('class', 'schedule-input');
    endTimeInput.setAttribute('placeholder', '終了時間');

    var memoInput = document.createElement('input');
    memoInput.setAttribute('type', 'text');
    memoInput.setAttribute('class', 'schedule-input');
    memoInput.setAttribute('placeholder', 'メモ');

    var registerButton = document.createElement('button');
    registerButton.setAttribute('type', 'button');
    registerButton.textContent = '登録';
    registerButton.addEventListener('click', function () {
        var inputs = document.querySelectorAll('.schedule-input');
        var schedule = {};
        for (var i = 0; i < inputs.length; i++) {
            schedule[inputs[i].placeholder] = inputs[i].value;
            inputs[i].value = '';
        }

        var scheduleDetail = document.createElement('div');
        scheduleDetail.innerHTML =
            "<p>用件：" + schedule['用件'] + "</p>" +
            "<p>開始時間：" + schedule['開始時間'] + "</p>" +
            "<p>終了時間：" + schedule['終了時間'] + "</p>" +
            "<p>メモ：" + schedule['メモ'] + "</p>";

        document.querySelector('.area-calendardetail a').appendChild(scheduleDetail);
    });

    scheduleInputArea.appendChild(scheduleDate);
    scheduleInputArea.appendChild(schedulearea);
    scheduleInputArea.appendChild(scheduleInput);
    scheduleInputArea.appendChild(startTimeInput);
    scheduleInputArea.appendChild(endTimeInput);
    scheduleInputArea.appendChild(memoInput);
    scheduleInputArea.appendChild(registerButton);
}

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

    const tetsuyaCheckbox = document.getElementById('tetsuyaCheckbox');
    const onImage = document.querySelector('.onImage');
    const offImage = document.querySelector('.offImage');

    tetsuyaCheckbox.addEventListener('change', function() {
      if (this.checked) {
        onImage.style.display = 'inline-block';
        offImage.style.display = 'none';
      } else {
        onImage.style.display = 'none';
        offImage.style.display = 'inline-block';
      }
    });

  //timer js
    var youken = document.getElementById("youken");
    var start = document.getElementById("start");
    var end = document.getElementById("end");
    var Timerflag = 0;
    let mainTimer = document.getElementById('timershow');
    var datail = document.getElementById("register-area");
    function showMenuTimer ()
    {

      if(Timerflag == 0)
      {

        fetch('js/Timer.html')
	     	.then(response => response.text())
	    	.then(html => {
		    mainTimer.innerHTML = html;
	    });
	    datail.style.display = "none";


        Timerflag = 1;
      }
      else
      {
      	youken.value = "";
      	start.value = "";
      	end.value = "";

        mainTimer.innerHTML = "";
        datail.style.display = "block";
        Timerflag = 0;
      }
    }





 	//データを一時的に保存するオブジェクト
    var savedData = {};
    var timerInterval;
    var startTime;
    var elapsedTime;
    //ストップを押したかスタートを押したかを判定
    var flag = 1;
    //スタートを押したのが最初の一回目かを判定
    var saveStartTimeFlag = 1;
    //経過時間 時間、分、秒
    var elapsedHours = 0;
    var elapsedMinutes = 0;
    var elapsedSeconds = 0;

	 //経過時間のカウントアップ
    function timeCountUp() {

      elapsedSeconds++;

      if(elapsedSeconds > 59) {
        elapsedSeconds = 0;
        elapsedMinutes++;
      } else if(elapsedMinutesString > 59) {
        elapsedMinutes = 0;
        elapsedHours++;
      }

      var elapsedHoursString = padZero(elapsedHours);
      var elapsedMinutesString = padZero(elapsedMinutes);
      var elapsedSecondsString = padZero(elapsedSeconds);

      elapsedTime = elapsedHoursString + ':' + elapsedMinutesString + ':' + elapsedSecondsString;

      var a = document.getElementsByClassName('a');
      for(let i = 0; i < a.length ; i++ ){
        a[i].value = elapsedTime;
      }

      flag = 0;
    }



 	//時間に0をたしてくれる
    function padZero(number) {
      return number < 10 ? '0' + number : number;
    }

    //スタートボタンを押したときの処理
    function startTimer() {
      var timershow = document.getElementById('i');

      timershow.style.display = "inline-block";

      if(saveStartTimeFlag == 1){
        startTimeSava();
      }

      if (document.getElementById('requirementInput')) {
      savedData = {
        requirement: document.getElementById('requirementInput').value,
        startTime:  document.getElementById('startTimeInput').value
      }
    }


      if(flag == 1){
        timerInterval = setInterval(timeCountUp, 1000);
      }

      // var startButton = document.querySelector('input[value="スタート"]');
      // startButton.value = "ストップ";
      // startButton.onclick = stopTimer;

      var startButton = document.getElementById("startBtn");
      var stopButton = document.getElementById("stopBtn");
      // ボタンの切り替え
      startButton.style.display = "none";
      stopButton.style.display = "inline-block";
    }

    //ストップボタンを押したときの処理
    function stopTimer()
    {
      clearInterval(timerInterval);



      // var stopButton = document.querySelector('input[value="ストップ"]');
      // stopButton.value = "スタート";
      // stopButton.onclick = startTimer;

      var startButton = document.getElementById("startBtn");
      var stopButton = document.getElementById("stopBtn");
      // ボタンの切り替え
      startButton.style.display = "inline-block";
      stopButton.style.display = "none";

      flag = 1;
    }

    //保存ボタンを押したときの処理
    function saveTimer() {
      var requirement = document.getElementById('requirementInput').value;
      startTime = document.getElementById('startTimeInput').value;
      var endTime = calculateEndTime();
      var pausedTime = elapsedTime;

      mainTimer.innerHTML = "";
	  datail.style.display = "block";

      youken.value = requirement;
      start.value = startTime;
      end.value = endTime;

      cancelTimer();

	  Timerflag = 0;
      flag = 1;
      saveStartTimeFlag = 1;
    }


    //終了時間を返す
    function calculateEndTime() {
      var currentTime = new Date();
      var hours = currentTime.getHours();
      var minutes = currentTime.getMinutes();

      var endTime = padZero(hours) + ":" + padZero(minutes);

      return endTime;
    }


    //開始時間を保存
    function startTimeSava() {
      var currentTime = new Date();
      var hours = currentTime.getHours();
      var minutes = currentTime.getMinutes();

      var TimeString = padZero(hours) + ":" + padZero(minutes);

      document.getElementById("startTimeInput").value = TimeString;

      saveStartTimeFlag = 0;
    }

	 //経過時間をリセットし、一時的なデータもリセットする
    function cancelTimer() {
      clearInterval(timerInterval);
      elapsedSeconds = 0;
      elapsedMinutes = 0;
      elapsedHours = 0;

      savedData = {
        requirement: '',
        startTime: '',
        elapsedTime: ''
      }

      document.getElementById('i').style.display = "none";
    }






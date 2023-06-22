
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
                calendar += "<td class='disabled'>" + (count - endDate) + "</td>";
                count++;
            } else {
                count++;
                if (year == today.getFullYear() && month == today.getMonth() && count == today.getDate()) {
                    calendar += "<td class='today date-cell' data-date='" + count + "'>" + count + "</td>";
                } else {
                    calendar += "<td class='date-cell' data-date='" + count + "'>" + count + "</td>";
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

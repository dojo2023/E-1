	'use strict';

function check() {
	  if (document.inquiry_forming.text.value === "" ) {
	    alert("お問い合わせ内容を入力してください。");
	    return false;
	  }else{
	return true;
    }
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


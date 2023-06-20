/**
 *
 */
'use strict';
	document.getElementById('sendBtn').onclick = function (e) {
		e.preventDefault();
		const id = document.getElementById('userID');
		const pass = document.getElementById('userPW');
		const f_name = document.getElementById('userFamilyName');
		const l_name = document.getElementById('userName');

		if(!id.value ) {
			id.placeholder = "※IDを入力してください";
		}

		if(!pass.value ) {
			pass.placeholder = "※パスワードを入力してください";
		}

		if(!f_name.value) {
			f_name.placeholder = "※姓を入力してください";
		}

		if(!l_name.value) {
			l_name.placeholder = "※名を入力してください";
		}

		if(id.value && pass.value && f_name.value && l_name.value){
			document.myfrom.submit();
		}
	}
	 function setRandomLeft() {
        return Math.floor((Math.random() * document.documentElement.clientWidth + 1)) + "px";
    }

    function setRandomTop(imageHeight) {
        return Math.floor((Math.random() * document.documentElement.clientHeight + 1)) + "px";
    }

	window.onload = function imgs() {
    	for(let i=0; i<10;i++){
    		var wh = (Math.floor(Math.random() * 200 + 1)) + "px";
    	    var image = document.createElement("img");
	        image.src = "/AllNightCalender/img/icon.png";
	        image.style.position = "fixed";
	        image.style.top = setRandomTop();//画像の横の長さをsetRandomTopに。
	        image.style.left = setRandomLeft();//画像の縦の長さをsetRandomLeftに。
	        image.style.width = wh;
	        image.style.height = wh;
	        document.getElementById("content").appendChild(image);
	    }

    }
    /*

    document.getElementById('sendBtn').onclick = function () {
 		var id = document.getElementById("userID").value.length;
 		var f_name = document.getElementById("userFamilyName").value.length;
 		var l_name = document.getElementById("userName").value.length;
 		var pass = document.getElementById("userPW").value.length;

 		if(id > 20) {
 			id.placeholder = "※20文字以上の文字は入力しないでください";
 		}

 		if(f_name > 20) {
			f_name.placeholder = "※20文字以上の文字は入力しないでください";
 		}

 		if(l_name > 20) {
			l_name.placeholder = "※20文字以上の文字は入力しないでください";
 		}

 		if(pass > 20) {
			pass.placeholder = "※20文字以上の文字は入力しないでください";
 		}

 		if(id<21 && pass<21 && f_name<21 && l_name<21){
			document.myfrom.submit();
		}
 	}
 	*/

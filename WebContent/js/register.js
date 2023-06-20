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

		var id_len = id.value.length;
		var pass_len = pass.value.length;
		var f_name_len = f_name.value.length;
		var l_name_len = l_name.value.length;

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


		if(id_len > 20) {
 			id.placeholder = "※20文字以上の文字は入力しないでください";
 			id.value = "";
 		}

 		if(f_name_len > 20) {
			f_name.placeholder = "※20文字以上の文字は入力しないでください";
			f_name.value = "";
 		}

 		if(l_name_len > 20) {
			l_name.placeholder = "※20文字以上の文字は入力しないでください";
			l_name.value = "";
 		}

 		if(pass_len > 20) {
			pass.placeholder = "※20文字以上の文字は入力しないでください";
			pass.value = "";
 		}

 		if((0 < id_len && id_len < 21) && (0 < l_name_len && l_name_len < 21) && (0 < f_name_len && f_name_len < 21) && (0 < pass_len && pass_len < 21)){
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

 		 	}
 	*/

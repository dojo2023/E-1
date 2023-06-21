/**
 *
 */
	'use strict';

    function resetContent () {
    	const id = document.getElementById('userID');
		const pass = document.getElementById('userPW');

    	id.placeholder = "ID";
    	pass.placeholder = "PW";
    }

	document.getElementById("sendBtn").onclick = function (e) {
		e.preventDefault();
		const id = document.getElementById('userID');
		const pass = document.getElementById('userPW');

		if(!id.value){
			id.placeholder = "※IDを入力してください";
		}

		if(!pass.value){
			pass.placeholder = "※パスワードを入力してください";
		}

		if(id.value && pass.value) {
			document.myform.submit();
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
	    for(let i=0; i<10;i++){
    		var wh = (Math.floor(Math.random() * 200 + 1)) + "px";
    	    var image2 = document.createElement("img");
	        image2.src = "/AllNightCalender/img/login_font.png";
	        image2.style.position = "fixed";
	        image2.style.top = setRandomTop();//画像の横の長さをsetRandomTopに。
	        image2.style.left = setRandomLeft();//画像の縦の長さをsetRandomLeftに。
	        image2.style.width = wh;
	        image2.style.height = wh;
	        document.getElementById("content").appendChild(image2);
	    }
    }

   function pushHideButton() {
        var txtPass = document.getElementById("userPW");
        var btnEye = document.getElementById("buttonEye");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnEye.className = "fa fa-eye";
        } else {
          txtPass.type = "text";
          btnEye.className = "fa fa-eye-slash";
        }
   }











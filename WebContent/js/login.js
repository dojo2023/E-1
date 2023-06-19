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
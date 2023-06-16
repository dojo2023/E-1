/**
 *
 */
	'use strict';
	document.getElementById('sendBtn').onclick = function (e) {
		e.preventDefault();
		const id = document.getElementById('userID');
		const pass = document.getElementById('userPW');
		if(!id.value || !pass.value){
			document.getElementById('error').textContent = "※IDとパスワードを入力してください";
		} else {
			document.myform.submit();
		}
	}
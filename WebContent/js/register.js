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
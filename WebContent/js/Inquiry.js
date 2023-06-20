	'use strict';

function check() {
	  if (document.inquiry_forming.text.value === "" ) {
	    alert("お問い合わせ内容を入力してください。");
	    return false;
	  }else{
	return true;
    }
}

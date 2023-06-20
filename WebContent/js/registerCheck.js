/**
 *
 */



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



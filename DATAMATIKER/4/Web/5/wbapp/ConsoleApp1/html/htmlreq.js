
function callbackfunc(){
	let res = JSON.parse(this.responseText);
	console.log(res);
}

var req = new XMLHttpRequest();

req.addEventListener("load", callbackfunc);
req.open("GET", '');
req.send();
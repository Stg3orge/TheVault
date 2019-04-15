
function callbackfunc(){

	let res = JSON.parse(this.responseText);
	console.log(typeof(res));
	console.log(res);
    for (var i=0; i < res.length; i++) {

		console.log(res[i].name);
	}
}
var apirequest = new XMLHttpRequest();

apirequest.addEventListener("load", callbackfunc);
apirequest.open("GET", 'https://swapi.co/api/people');
//apirequest.setRequestHeader('centisoft_token', 'VerySecretToken1');
apirequest.send();

/*
function callbackfunc(){
	let res = JSON.parse(this.responseText);
	console.log(typeof(res));

    for (var i=0; i < res.length; i++) {

    	var person = res[i];
		console.log(person.name);
		console.log(person.height);
	}
}
var apirequest = new XMLHttpRequest();

apirequest.addEventListener("load", callbackfunc);
apirequest.open("GET", 'https://swapi.co/api/people');
//apirequest.setRequestHeader('centisoft_token', 'VerySecretToken1');
apirequest.send();

*/
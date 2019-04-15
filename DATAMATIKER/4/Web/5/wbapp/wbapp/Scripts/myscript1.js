
function callbackfunc() {
    let res = JSON.parse(this.responseText);
    console.log(res);
}

var req = new XMLHttpRequest();

req.addEventListener("load", callbackfunc);
req.open("GET", 'http://localhost:52747/api/values');
req.send();// JavaScript source code

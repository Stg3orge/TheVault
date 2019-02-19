// function reqListener () {
//   console.log(this.responseText);
// }

// function jsonToUi()
// {
//     var developerList = JSON.parse(this.responseText);
//     for(var i=0;i<developerList.length;i++){
//         console.log(developerList[i].Name);
//     }
// }


// var a = JSON.stringify({});
// var b = JSON.parse(a);


// var oReq = new XMLHttpRequest();
// //event listeners
// oReq.addEventListener("load", jsonToUi);
// //open and send
// oReq.open("GET", "http://centisoft.dk/api/developer");
// oReq.send();







function jsonToUi()
{
    var developerList = JSON.parse(this.responseText);
    for(var i=0;i<developerList.length;i++){
        console.log(developerList[i].Name);
    }
}

var oReq = new XMLHttpRequest();
//event listeners
oReq.addEventListener("load", jsonToUi);
//oReq.
//open and send
oReq.open("GET", "http://centisoft.dk/api/project/1/tasks");
//oReq.setRequestHeader("centisoft_token", "ABC1234");
oReq.send();



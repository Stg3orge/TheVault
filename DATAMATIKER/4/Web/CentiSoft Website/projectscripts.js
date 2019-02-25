function getData(){
$.ajax({
    'url' : 'http://localhost:57422/api/developers',
    'type' : 'GET',
    'headers' : {'centisoft_token' : 'VerySecretToken1'},
    'success' : function(data){
                    
                    var element = document.getElementById("listen");
                    let res = data;
                    res.forEach(function(elm){
                    console.log(data);
                    var li = document.createElement("li");
                    var a = document.createElement("a");
                    a.setAttribute("name", elm.Name);
                    a.setAttribute("href", "/inspect_developer.html?id=" + elm.Id);
                    a.innerText = elm.Name;
                    li.appendChild(a);

                    element.appendChild(li);

            });
        


    },
    'error' : function(){alert("WRONG!")},
    

});
}

function getDeveloper(id){
    $.ajax({
        'url' : 'http://localhost:57422/api/developers/' + id,
        'type' : 'GET',
        'headers' : {'centisoft_token' : 'VerySecretToken1'},
        'success' : function(data){
                        let res = data;
                        document.getElementById("headline").value = data.Name;
                        document.getElementById("developerName").value = data.Name;
                        document.getElementById("developerEmail").value = data.Email;
                        document.getElementById("id").value = data.Id;
                    },
        'error' : function(){alert("WRONG!")},
    });
    }

    function updateObject(res){
        
        //var res = getDeveloperObject()
        res.Name = document.getElementById("developerName").value;
        res.Email = document.getElementById("developerEmail").value;
        
        
        updateDeveloper(res);
    }

function updateDeveloper(res){
    //console.log(res);
    
    $.ajax({
        'url' : ('http://localhost:57422/api/developers/' + res.Id),
        'type' : 'PUT',
        'headers' : {'centisoft_token' : 'VerySecretToken1'},
        'data' : res,
        'success' : console.log(res),
        
    });
}

function getDeveloperObject(){
    function getId(){
        document.getElementById("id");
    }
    $.ajax({
        'url' : 'http://localhost:57422/api/developers/' + id,
        'type' : 'GET',
        'headers' : {'centisoft_token' : 'VerySecretToken1'},
        'success' : function(data){
                        //let res = data;
                        //console.log(data);
                        //let id = getId();
                        updateObject(data);
                                                
        },
        'error' : function(){alert("WRONG!")},
    });
    }


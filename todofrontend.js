alert("innfdasfn");
 
function updateTableEntry(key,value,id)
{

	var table = document.getElementById("table");
	var row = table.insertRow(0);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2)
	var cell4 = row.insertCell(3);
	cell1.innerHTML = key;
	cell2.innerHTML = value;	

	var buton = document.createElement('button');
	buton.style.color='black';
	buton.style.width='50px';
	buton.style.height='30px';
	buton.style.borderRadius='5px';
    buton.innerHTML="delete";
    
    buton.onclick = function(){
        table.deleteRow(row.rowIndex);
        var delObj = {
            "name": key,
            "city": value,
            "id": id
        }
        var deleteRequest = new XMLHttpRequest();
        deleteRequest.open("DELETE","http://localhost:8080/todo");
        deleteRequest.setRequestHeader("Content-type","application/json; charset=UTF-8");
        deleteRequest.send(JSON.stringify(delObj));
    }
	cell4.appendChild(buton);

	var editButton = document.createElement('button');
	editButton.style.width = '50px';
	editButton.style.height= '30px';
	editButton.style.borderRadius='5px';
	editButton.innerHTML	= 'edit';
	editButton.style.color='black';
	cell3.appendChild(editButton);
	editButton.onclick = function(){
									var editbox1=document.createElement('input');
									var editbox2=document.createElement('input');
									editbox1.setAttribute('type','text');
									editbox2.setAttribute('type','text');
									cell1.appendChild(editbox1);
									cell2.appendChild(editbox2);
									this.innerHTML='save';
									this.onclick=function(){
                                                            console.log(editbox1.value);
                                                            this.innerHTML='edit';
                                                            var editObj = {
                                                                "name": editbox1.value,
                                                                "city": editbox2.value,
                                                                "id": id
                                                            }
                                                            var putRequest = new XMLHttpRequest();
                                                            putRequest.open("PUT", "http://localhost:8080/todo");
                                                            putRequest.setRequestHeader("Content-type","application/json; charset=UTF-8");
                                                            putRequest.onload = renderTable;
                                                            putRequest.send(JSON.stringify(editObj));
															}
								}
}


function putInHtml(){
    var newtable = document.createElement('table');
    var table = document.getElementById('table');
    table.parentNode.replaceChild(newtable,table);
    newtable.setAttribute('id','table');
    newtable.setAttribute('margin-left','220px');
    newtable.setAttribute('position','relative');
    let data = JSON.parse(this.responseText);
    console.log(data);

        for(var key in data){
            console.log(key);
            updateTableEntry(data[key].name,data[key].city,data[key].id);
        }
    
}
function renderTable() {
var request = new XMLHttpRequest();
request.open('GET','http://localhost:8080/todo');
request.onload = putInHtml;
request.send();

}


 function postData(){
    
     var firstname = document.getElementById("key").value;
     var firstcity = document.getElementById("value").value;
     var id = 0;
        var obj = {
            "name": firstname,
            "city":firstcity,
            "id":"0"
        }
    var request = new XMLHttpRequest();
     request.open('POST', 'http://localhost:8080/todo');
     request.onload = renderTable;
     request.setRequestHeader("Content-type","application/json; charset=UTF-8");
     request.send(JSON.stringify(obj));
 }




function travel(){
    let bas=0;
    var ele = document.createElement('label');
    ele.setAttribute('color','black');
    document.body.appendChild(ele);
    for(let i=0;i<6;i++){
        setTimeout(function(){
            var newEle = document.createElement('label');
            newEle.setAttribute('margin-left',new String(bas));
            ele.parentNode.replaceChild(newEle,ele);
            ele = newEle;
            bas = bas+5;
            console.log(bas);
        },1000);
    }
}
var id =1;
var id_tel = 1;

var isEnterprise = true;


function addEnterprise(){
	if(isEnterprise){
		document.getElementById("siret").innerHTML+=
		"<input type=\"text\" id=\"numsiret\" placeholder=\"Num Siret\">";
		isEnterprise=false;
	}else{
		
		var toDele = document.getElementById("numsiret");
		var parent = toDele.parentNode;
		parent.removeChild(toDele);
		isEnterprise =true;
	}
}



//Ajoute un champs Telephone
function addTel(){
	document.getElementById("telContact").innerHTML +="<div class=\"control-group\">"+"<div id=\"t"+id_tel+"\">"+
	"<label class=\"control-label\" for=\"phoneNumber"+id_tel+"\">Phone"+
	"Number</label>"+
	"<div class=\"controls\">"+
	"<input type=\"text\" id=\"phoneNumber"+id_tel+"\" name=\"phoneNumber"+id_tel+"\""+
	"placeholder=\"Phone Number\">"+
	" <i class=\"icon-plus\""+
	"onclick=\"addTel()\"></i>"+
	" <i class=\"icon-minus\""+
	"onclick=\"deleteTel("+id_tel+")\"></i>"+
	"</div>"+
	"<select name=\"type"+id_tel+"\">"+
	"<option value\"Home\">Home</option>"+
	"<option value=\"Work\">Work</option>"+
	"<option value=\"Mobil\">Mobile Phone</option>"+
	"</select></div>";
	
	id_tel++;
	
	changeValueNbTel();
}

// Enleve un champs telephone
function deleteTel(id3){
	var toDele = document.getElementById("t"+id3);
	var parent = toDele.parentNode;
	parent.removeChild(toDele);
	id_tel--;
	changeValueNbTel();
}

function changeValueNbTel(){
	document.getElementById("nbTel").value=id_tel;
	
}




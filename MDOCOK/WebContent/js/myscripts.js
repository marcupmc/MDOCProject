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


//Ajoute un groupe
function addGroupe(){

	document.getElementById("groupContact").innerHTML+="<div id=\"g"+id+"\"><label class=\"control-label\" for=\"groupName"+id+"\">Group</label>"+
	"<div class=\"controls\">"+
	"<input type=\"text\" id=\"groupName"+id+"\" name=\"groupName"+id+"\"placeholder=\"Group\">"+
	" <i class=\"icon-plus\" onclick=\"addGroupe()\"></i>"+
	" <i class=\"icon-minus\" onclick=\"deleteGroup("+id+")\"></i>"+
	"</div></div>" ;

	id++;
}

//Supprime un champs groupe dans le formulaire
//d'ajout de contact
function deleteGroup(id2){

	var toDele = document.getElementById("g"+id2);
	var parent = toDele.parentNode;
	parent.removeChild(toDele);
	id--;


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
	"<select name=\"type\">"+
	"<option value\"home\">Home</option>"+
	"<option value=\"work\">Work</option>"+
	"<option value=\"mobile\">Mobile Phone</option>"+
	"</select></div>";
	
	id_tel++;
}

function deleteTel(id3){
	var toDele = document.getElementById("t"+id3);
	var parent = toDele.parentNode;
	parent.removeChild(toDele);
	id_tel--;
}




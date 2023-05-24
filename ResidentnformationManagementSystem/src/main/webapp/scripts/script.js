/**
 * 
 */

function todo(what){
	var obj= document.forms["menuForm"];
	obj.cmd.value=what+".resident";
	obj.submit();
}
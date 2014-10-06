/**
 * 
 */
function checkPasslen() {
	var pass = document.forms['loginform']['password'].value;
	if (pass.length < 6) {
		document.forms['loginform']['password'].value = "";
		document.forms['loginform']['password'].focus();
		return false;
	} else {
		return true;
	}
}
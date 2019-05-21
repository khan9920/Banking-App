function validateForm(){
	
	var amount = document.getElementById("amount").value;
	var accNo = document.getElementById("accNo").value;
	var reAccNo = document.getElementById("reAccNo").value;
	
	var accNoLen = accNo.length;
	var ReAccNoLen = reAccNo.length;
	
	if (amount == "" || accNo == "" || reAccNo == "" ) {
		document.getElementById("errorCommon").innerHTML = "Please fill all mendatory fields";
		return false;
	} else if ( accNo != reAccNo ) {
		document.getElementById("errorAccNo").innerHTML = "Please double check the account number";
		return false;
	} else if ( accNoLen > 9 || ReAccNoLen > 9 ) {
		document.getElementById("errorAccNo").innerHTML = "Please double check the account number";
		return false;

	} else {
		confirm("Are you sure you want to tranfers " + amount + " to the account holder " + accNo + "?");
	}
}
function formValidation(){
    var fullnameid = document.getElementById("fullnameid");
    var Initialsid = document.getElementById("Initialsid");
    var nicNOid = document.getElementById("nicNOid");
    var addressid = document.getElementById("addressid");
    var cityid = document.getElementById("cityid");
    var Birthdayid = document.getElementById("birthdayid");
    var contactid = document.getElementById("contactid");
    var pcodeid = document.getElementById("pcodeid");
    var emailid = document.getElementById("emailid");
    var passwordid = document.getElementById("passwordid");
    var cpasswordid = document.getElementById("cpasswordid");
    

    var pwd = passwordid.value;
    var cpwd = cpasswordid.value;

    
    if(fullnameid.value == 0 || emailid.value ==0 || passwordid.value ==0 || cpasswordid.value ==0 || Initialsid.value ==0 
    || addressid.value ==0 || nicNOid.value ==0 || cityid.value ==0 || Birthdayid.value ==0 || contactid.value ==0 || pcodeid.value ==0){
        alert("Every box must be filled out");
        return false;
    }

    if(cpwd != pwd ){
        alert("Your password and confirmation password do not match.Try again!");
        cpasswordid.focus();
        return false;
    }

   

    if (isNaN(contactid.value)){
        alert("Incorrect Contact Number.Try again!");
        contactid.focus();
      return false;
    }
     

    if (isNaN(pcodeid.value)){
        alert("Incorrec Postal Id.Try again!");
        pcodeid.focus();
      return false;
    }
    
}
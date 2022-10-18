function validateForm() { 
	console.log("hiii")
    //collect form data in JavaScript variables  
    var password = document.getElementById("password").value;  
    var confirmPassword = document.getElementById("confirmpassword").value;  
   console.log(password +" "+confirmPassword)
    //check empty password field  
   
    
    
    if(password == "") {  
      document.getElementById("PasswordMessage").innerHTML = "**Fill the password please!";  
      return false;  
    }  
      
     
    //minimum password length validation  
    if(password.length < 8) {  
      document.getElementById("PasswordMessage").innerHTML = "**Password length must be atleast 8 characters";  
      return false;  
    }  
    
    //maximum length of password validation  
    if(password.length > 18) {  
      document.getElementById("PasswordMessage").innerHTML = "**Password length must not exceed 15 characters";  
      return false;  
    }  
      
    if(password.length>=8 && password.length<=18) {  
    	document.getElementById("PasswordMessage").innerHTML = "";  
    var T4Tutorials = new Array();
    T4Tutorials.push("[$@$!%*#?&]"); // Special Charector
    T4Tutorials.push("[A-Z]");      // Uppercase Alpabates
    T4Tutorials.push("[0-9]");      // Numbers
    T4Tutorials.push("[a-z]");     // Lowercase Alphabates
    var ctr = 0;
    for (var i = 0; i < T4Tutorials.length; i++) {
        if (new RegExp(T4Tutorials[i]).test(password)) {
            ctr++;
        }
    }
    // Display it
    var color = "";
    var strength = "";
    switch (ctr) {
        case 0:
        case 1:
        case 2:
            strength = "Very Weak in length";
            color = "blue";
            break;
        case 3:
            strength = "Medium";
            color = "pink";
            break;
        case 4:
            strength = "Strong";
            color = "gray";
            break;
    }
    document.getElementById("UniqueID").innerHTML = strength;
    document.getElementById("UniqueID").style.color = color;
    }

   
}
function ConfirmPassword(){
	var password = document.getElementById("password").value;  
    var confirmPassword = document.getElementById("confirmpassword").value;
   if(confirmPassword.length>6){
    if(password != confirmPassword) {
        console.log("error")
         document.getElementById("ConfirmPasswordmessage").innerHTML = "**Passwords are not same";  
         
        }
    else{
    	
    	document.getElementById("ConfirmPasswordmessage").innerHTML = ""; 
    	
    }
   }
}
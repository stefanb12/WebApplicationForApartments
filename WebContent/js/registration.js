var app = new Vue({
	el: '#registration',
	  data: {
	    username: null,
	    password: null,
	    name: null,
	    lastname: null,
	    gender: null,
	    confirmpassword: null,
	    falseUsername : "",
	    falsePassword : "",
	    falseName : "",
	    falseLastname : "",
	    falseGender : "",
	    falseConfirmPassword : "",
	    notMatchingPasswords : "",
	    doesExist : ""
	  },
	  methods:{
	    registerNewUser: function(e) {
	    	this.falseUsername = "";
		    this.falsePassword = "";
		    this.falseName = "";
		    this.falseLastname = "";
		    this.falseGender = "";
		    this.falseConfirmPassword = "";
		    this.notMatchingPasswords = "";
		    
	    	if(this.username && this.password && this.name 
	    	   && this.lastname && this.confirmpassword && this.password === this.confirmpassword){
	    		
	    		var genderOfUser;
	    		if(this.gender == "Musko"){
	    			genderOfUser = true;
				}else if(this.gender == "Zensko"){
					genderOfUser = false;
				}
	    		
	    		axios
		  		.post('rest/users/doesUserExist', {"username": this.username, 
		  											 "password":this.password,
		  											 "name":this.name,
		  											 "surname":this.lastname,
		  											 "gender":genderOfUser,
		  											 "role":"GUEST"})
		  		.then(response => (this.doesExist = response.data));
	    		
		    	axios
		  		.post('rest/users/register', {"username": this.username, 
		  											 "password":this.password,
		  											 "name":this.name,
		  											 "surname":this.lastname,
		  											 "gender":genderOfUser,
		  											 "role":"GUEST"});
		    	
		    	
		    	
		    	this.username= null;
			    this.password= null;
			    this.name= null;
			    this.lastname= null;
			    this.gender= null;
			    this.confirmpassword= null;
		    	e.preventDefault();

		    	return;
	    	}
	    	if(!this.username){
	    		this.falseUsername = "Unesite vase korisnicko ime";
	    	}
	    	if(!this.password){
	    		this.falsePassword = "Unesite vasu lozinku";
	    	}
	    	if(!this.name){
	    		this.falseName = "Unesite vase ime";
	    	}
	    	if(!this.lastname){
	    		this.falseLastname = "Unesite vase prezime";
	    	}
	    	if(!this.gender){
	    		this.falseGender = "Unesite pol korisnika";
	    	}
	    	if(!this.confirmpassword){
	    		this.falseConfirmPassword = "Unesite potvrdu vase lozinke";
	    	}
	    	if(this.password !== this.confirmpassword){
	    		this.notMatchingPasswords = "Lozinka i potvrda lozinke se ne poklapaju"
	    	}
	    	
	    	e.preventDefault();
    		return;
	    	
	    }
	  }
})
var app = new Vue({
  el: '#login',
  data: {
    username: null,
    password: null,
    falseUsername: "",
    falsePassword: ""
  },
  methods:{
    checkForm: function(e) {     
    	if(this.password && this.username){
    		axios
    		.get('rest/users/login', {params:{"username": this.username, "password":this.password}});
    	}else if(!this.username && this.password){
    		this.falseUsername = "Popunite vase korisnicko ime";
    		this.falsePassword = "";
    		e.preventDefault();
    		return;    		
    	}else if(this.username && !this.password){
    		this.falsePassword = "Popunite vasu lozinku";
    		this.falseUsername = "";
    		e.preventDefault();
    		return;
    	}else if(!this.username && !this.password){
    		this.falseUsername = "Popunite vase korisnicko ime";
    		this.falsePassword = "Popunite vasu lozinku";
    		e.preventDefault();
    		return;
    	}
    }
  }
})

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
		    
	    	if(this.falseUsername && this.falsePassword && this.falseName 
	    	   && this.falseLastname && this.falseConfirmPassword && this.notMatchingPasswords){
		    	axios
		  		.post('rest/users/register', {"username": this.username, 
		  											 "password":this.password,
		  											 "name":this.name,
		  											 "surname":this.lastname,
		  											 "gender":true,
		  											 "role":"GUEST"});
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
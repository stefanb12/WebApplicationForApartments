var account = new Vue({
	  el: '#account',
	  data: {
	    loggedUser: {}
	  }, methods : {
		homePage : function() {
			location.href = "index.html";
		}  
	  },
	  mounted () {
		  axios
			.get('rest/users/currentUser')
			.then(response => (this.loggedUser = response.data));
	  }
	 
});

var updateAccount = new Vue({
	el: '#updateAccount',
	  data: {
		loggedUser: null,
	    name: null,
	    lastname: null,
	    password: null,
	    confirmpassword: null,
	    falseName : "",
	    falseLastname : "",
	    falsePassword : "",
	    falseConfirmPassword : "",
	    notMatchingPasswords : "",
	  },
	  methods:{
	    updateUserAccount: function(loggedUser) {
	    	
		    this.falseName = "";
		    this.falseLastname = "";
		    this.falsePassword = "";
		    this.falseConfirmPassword = "";
		    this.notMatchingPasswords = "";
		    
	    	if(this.falseName && this.falseLastname && this.falsePassword
	    		   && this.falseConfirmPassword && this.notMatchingPasswords){
		    	axios
		  		.post('rest/users/updateAccount', {"username": loggedUser.username, 
		  										"password": this.password,
		  										"name": this.name,
		  										"surname": this.lastname,
		  										"gender": loggedUser.gender,
		  										"role": loggedUser.role});
		    	return;
	    	}
	    	if(!this.password){
	    		this.falsePassword = "Unesite vašu lozinku";
	    	}
	    	if(!this.name){
	    		this.falseName = "Unesite vaše ime";
	    	}
	    	if(!this.lastname){
	    		this.falseLastname = "Unesite vaše prezime";
	    	}
	    	if(!this.confirmpassword){
	    		this.falseConfirmPassword = "Unesite potvrdu vaše lozinke";
	    	}
	    	if(this.password !== this.confirmpassword){
	    		this.notMatchingPasswords = "Lozinka i potvrda lozinke se ne poklapaju"
	    	}
	    	
	    	e.preventDefault();
    		return;
	    	
	    }
	  },
	  mounted () {
		  axios
			.get('rest/users/currentUser')
			.then(response => (this.loggedUser = response.data));
	  }
});
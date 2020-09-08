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
    		e.preventDefault();
    		return;    		
    	}else if(this.username && !this.password){
    		this.falsePassword = "Popunite vasu lozinku";
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
	    name: null,
	    lastname: null,
	    gender: null,
	    password: null,
	    confirmpassword: null,
	  },
	  methods:{
	    registerNewUser: function(e) {     
	    	axios
	  		.post('rest/users/register', {"username": this.username, 
	  									  "password":this.password,
	  									  "name":this.name,
	  									  "surname":this.lastname,
	  									  "gender":true,
	  									  "role":"GUEST"});
	    }
	  }
})
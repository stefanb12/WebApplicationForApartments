var app = new Vue({
  el: '#login',
  data: {
    username: null,
    password: null,
    falseUsername: "",
    falsePassword: "",
    loggedUser: false,
    userType: {},
  },
  methods:{
    checkForm: function(e) {     
    	if(this.password && this.username){
    		    		
    		axios
    		.get('rest/users/isLogged', {params:{"username": this.username, "password": this.password}})
    		.then(response => (this.loggedUser = response.data));
    		    		
    		axios
    		.get('rest/users/login', {params:{"username": this.username, "password": this.password}});	
    		    		
    	}else if(!this.username && this.password){
    		this.falseUsername = "Popuniiiite vase korisnicko ime";
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
    	
    	if(this.loggedUser == true){
    		return;
    	}else{
    		e.preventDefault();   	
    		return;
    	}
    	
    }
    
  }
})
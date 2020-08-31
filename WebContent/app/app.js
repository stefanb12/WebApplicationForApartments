var app = new Vue({
  el: '#login',
  data: {
    username: null,
    password: null,
  },
  methods:{
    checkForm: function(e) {     
    	axios
  		.get('rest/users/login', {params:{"username": this.username, "password":this.password}});
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
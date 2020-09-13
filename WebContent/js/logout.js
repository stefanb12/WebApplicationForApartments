var hostLogout = new Vue({
  el: '#hostLogout',
  methods:{
    logout: function() {     
    	axios
		.post('rest/users/logout');
    }
  }
})

var administratorLogout = new Vue({
	  el: '#administratorLogout',
	  methods:{
	    logout: function() {     
	    	axios
			.post('rest/users/logout');
	    }
	  }
	})

var guestLogout = new Vue({
	  el: '#guestLogout',
	  methods:{
	    logout: function() {     
	    	axios
			.post('rest/users/logout');
	    }
	  }
	})
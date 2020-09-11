var app = new Vue({
  el: '#main',
  data: {
    loggedUser: {}
  },
  mounted () {
	  axios
		.get('rest/users/currentUser')
		.then(response => (this.loggedUser = response.data));
  }
 
})
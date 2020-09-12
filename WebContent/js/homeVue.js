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

const HomeSearch = { template: '<home-search></home-search>' }
const AllUsers = { template: '<all-users></all-users>' }
const AllApartments = { template: '<all-apartments></all-apartments>' }
const AllReservations = { template: '<all-reservations></all-reservations>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { path: '/', component: HomeSearch},
	    { path: '/allUsers', component: AllUsers },
	    { path: '/allApartments', component: AllApartments },
	    { path: '/allReservations', component: AllReservations }
	  ]
});

var appp = new Vue({
	router,
	el: '#centar_main'
});

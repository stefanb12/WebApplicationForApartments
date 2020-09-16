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
const AllUsersByHost = { template: '<all-usersByHost></all-usersByHost>' }
const AllActiveApartments = { template: '<all-activeApartments></all-activeApartments>' }
const AllActiveApartmentsByHost = { template: '<all-activeApartmentsByHost></all-activeApartmentsByHost>' }
const AllNotActiveApartmentsByHost = { template: '<all-notActiveApartmentsByHost></all-notActiveApartmentsByHost>' }
const AddNewHost = { template: '<add-NewHost></add-NewHost>' }
const Amenities = { template: '<amenities></amenities>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { path: '/', component: HomeSearch},
	    { path: '/allUsers', component: AllUsers },
	    { path: '/allApartments', component: AllApartments },
	    { path: '/allReservations', component: AllReservations },
	    { path: '/allUsersByHost', component: AllUsersByHost },
	    { path: '/allActiveApartments', component: AllActiveApartments },
	    { path: '/allActiveApartmentsByHost', component: AllActiveApartmentsByHost },
	    { path: '/allNotActiveApartmentsByHost', component: AllNotActiveApartmentsByHost },
	    { path: '/addNewHost', component: AddNewHost },
	    { path: '/amenities', component: Amenities }
	  ]
});

var appp = new Vue({
	router,
	el: '#centar_main'
});

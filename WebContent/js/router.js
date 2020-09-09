const Home = { template: '<home></home>' }
const Guest = { template: '<guest></guest>' }
const Host = { template: '<host></host>' }
const Administrator = { template: '<administrator></administrator>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [
		{ path: '/', name : 'Home', component: Home},
	    { path: '/guest', name : 'Guest', component: Guest},
	    { path: '/host', name : 'Host', component: Host },
	    { path: '/administrator', name : 'Administrator', component: Administrator }
	  ]
});

var app = new Vue({
	router,
	el: '#main'
});

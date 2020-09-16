Vue.component("all-users", {
	data: function () {
	    return {
	      users: null
	    }
},
	template: ` 
<div style="position: absolute;
  left: 100px;
  top: 150px;">
  
		
		<button style="position: relative;
		  left: -60px;
		  top: 0px;
		  background-color: teal;
		  color: azure;
		">
		Svi korisnici</button>
  
		<button v-on:click="addHost" style="position: relative;
		  left: -80px;
		  top: 0px;
		">
		Dodaj novog domacina</button></br>

        <table border="1" style="background-color: grey;">
			<tr bgcolor="lightgrey">
				<th>Uloga</th>
				<th>Ime</th>
				<th>Prezime</th>
				<th>Pol</th>
				<th>Korisničko ime</th>
				<th>Lozinka</th>
			</tr>
		
			<tr v-for="user in users">
				<td v-if="user.role == 'GUEST'">Gost</td>
                <td v-if="user.role == 'HOST'" >Domaćin</td>
				<td v-if="user.role == 'ADMINISTRATOR'">Administrator</td>
				<td>{{user.name}}</td>
				<td>{{user.surname}}</td>
				<td v-if="user.gender == true">Muško</td>
                <td v-if="user.gender == false">Žensko</td>
				<td>{{user.username}}</td>
				<td>{{user.password}}</td>
			</tr>
		</table>
               	               

</div>	  
`
	,
	mounted () {
		axios
        .get('rest/users')
        .then(response => (this.users = response.data));
    },

	methods : {
		addHost : function() {
			this.$router.push('/addNewHost');  
    	}
	}
	
});
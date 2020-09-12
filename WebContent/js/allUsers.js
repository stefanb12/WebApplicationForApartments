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

        <table border="1">
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
		
	}
	
});
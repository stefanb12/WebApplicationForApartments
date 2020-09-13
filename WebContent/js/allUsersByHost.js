Vue.component("all-usersByHost", {
	data: function () {
	    return {
	      reservations: null
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
		
			<tr v-for="reservation in reservations">
				<td>Gost</td>
				<td>{{reservation.guest.name}}</td>
				<td>{{reservation.guest.surname}}</td>
				<td v-if="reservation.guest.gender == true">Muško</td>
                <td v-if="reservation.guest.gender == false">Žensko</td>
				<td>{{reservation.guest.username}}</td>
				<td>{{reservation.guest.password}}</td>
			</tr>
			
		</table>
               	               

</div>	  
`
	,
	mounted () {		
		axios
        .get('rest/reservations/reservationsByHost')	
        .then(response => (this.reservations = response.data));
    },

	methods : {
		
	}
	
});
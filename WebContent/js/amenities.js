Vue.component("amenities", {
	data: function () {
	    return {
	      amenities: {}
	    }
},
	template: ` 
<div>

        <div id="amenities">
	        <table border="1" bgcolor="lightgrey" style="position: absolute;
					left: 560px;
					top: 220px;">
				<tr>
					<th>Naziv sadržaja apartmana</th>
	                <th>&nbsp;</th>
	                <th>&nbsp;</th>
				</tr>
			
	            <tr v-for="a in amenities">
	                <td>{{a.name}}</td>
	                <td><a>Izmeni</a></td>
	                <td><a v-on:click="deleteAmenities(a)">Obriši</a></td>
	            </tr>
	        </table></br>
	        <td><button style="position: absolute;
							top: 20%;
							left: 35%;
							height: 50px;
							width: 250px;">Dodaj novi sadržaj</button></td>
		</div>
               	               

</div>	  
`
	,
	mounted () {		
		axios
        .get('rest/amenities')	
        .then(response => (this.amenities = response.data));
    },

	methods : {
		addAmenities : function(selectedAmenities) {
			axios
            .post('rest/amenities/addAmenities', selectedAmenities);  
    	}, 
    	updateAmenities : function(selectedAmenities) {    		
    		axios
            .post('rest/amenities/updateAmenities', selectedAmenities);
    	},
    	deleteAmenities : function(selectedAmenities) {
    		axios
            .post('rest/amenities/deleteAmenites', selectedAmenities);
    	}
    
	}
	
});
Vue.component("all-activeApartments", {
	data: function () {
	    return {
	      apartments: null
	    }
},
	template: ` 
<div style="position: absolute;
  left: 100px;
  top: 150px;">

        <div id="cards">

                <ul style="
                	list-style-type: none;
					margin-top: 25px;
                ">
                    <li v-for="apartment in apartments" style = "
                    	margin-top: 10px;
                    ">
                        <a href="https://www.w3schools.com" style = "
                        	text-decoration: none;
							font-family: Candara;
                        ">
                        <div id="card" style="
				        	width: 1000px;
						    height: 200px;
						    background-color: rgb(0, 0, 0, 0.85);
						    color: azure;
						    margin: auto;
						    text-align: left;
						    border-radius: 10px 10px 10px 10px;
				        ">
				        
				        	<img src="C:\Users\Hacer\Desktop\Web projekat temp\kartice\appartment.jpg" style = "
				        		position: relative;
							    float: left;
							    margin-top: 10px;
							    margin-left: 10px;
							    display: block;
							    height: 180;
							    width: 300;
							    border-radius: 10px;
				        	">
                            
                            <div id="text" style = "
                            position: relative;
						    top: 20px;
						    left: 50;
						    font-weight: bold;
						    font-size: 24;
                            ">
                            
                            <div v-if="apartment.typeOfApartment=='WHOLE'" id="type" style = " 
                            	font-weight: normal;
								font-size: 22;
                            ">Ceo apartman</div>
                            
                            <div v-else-if="apartment.typeOfApartment=='ROOM'" id="type" style = " 
                            	font-weight: normal;
								font-size: 22;
                            ">Soba</div>
                            
                            <div id="name" style = "
                            	font-weight: bold;
							    font-size: 30;
							    margin-top: 10px;
                            ">{{apartment.location.address.address}}</div>
                            
                            <div id="description" style = "
                            	font-weight: normal;
								font-size: 22;
                            ">Broj gostiju: {{apartment.numberOfGuests}}, broj soba:{{apartment.numberOfRooms}}</div>
                            
                            <div id="price" style = "
                            	position: relative;
							    bottom: -10%;
							    left: 30%;
							    font-weight: bold;
							    font-size: 26;
							    margin-top: 10px;
                            ">{{apartment.pricePerNight}}$ po nocenju</div>
                            </div>
                        </div>
                        </a>
                    </li>

                    

                </ul>

        </div>
               	               

</div>	  
`
	,

	methods : {
		
	},
	
	mounted () {
		axios
        .get('rest/apartments/activeApartments')
        .then(response => (this.apartments = response.data));
    },
	
});
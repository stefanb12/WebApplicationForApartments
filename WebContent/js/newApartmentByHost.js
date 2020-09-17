Vue.component("new-ApartmentByHost", {
	data: function () {
	    return {
	      typeOfApartment: "",
	      roomNum: null,
	      guestNum: null,
	      location: "",
	      dateFrom: null,
	      dateTo: null,
	      price: null,
	      checkInTime: null,
	      checkOutTime: null,
	      amenities: [],
	      falseTypeOfApartment: "",
	      falseRoomNum: "",
	      falseGuestNum: "",
	      falseLocation: "",
	      falseDateFrom: "",
	      falseDateTo: "",
	      falsePrice: "",
	      falseCheckInTime: "",
	      falseCheckOutTime: "",
	      falseAmenities: "",
	      deosExist: ""
	    }
},
	template: ` 
<div style="position: absolute;
  left: 100px;
  top: 150px;">

         <div style="
            font-family: Candara;
            margin-top: 80px;
            width: 500px;
            background-color: rgb(0, 0, 0, 0.6);
            color: azure;
            margin: auto;
            text-align: center;
            padding-top: 10px;
            padding-bottom: 10px;
            border-radius: 10px 10px 10px 10px;
        "><h1>Dodavanje novog apartmana</h1></div>

        <div style="  
            font-family: Candara;
            margin-top: 80px;    
            width: 500px;
            height: auto;
            background-color: rgb(0, 0, 0, 0.5);
            color: azure;
            margin: auto;
            text-align: left;
            border-radius: 10px 10px 10px 10px;">
            <form @submit="addNewApartment" style=" 
                padding: 10px;
                margin-left: 10px;
            ">
                <label style="color: red;">{{deosExist}}</label>
                <h2>Tip</h2>
                <label class="radio">
                    <input class="radio-whole" type="radio" name="type" value="Ceo apartman" checked="checked" v-model="typeOfApartment">
                    <span class="checkmark"></span>
                    Ceo apartman    
                </label>
                <label class="radio">
                    <input class="radio-room" name="type" type="radio" value = "Soba" v-model="typeOfApartment">
                    <span class="checkmark"></span>
                    Soba 
                </label>
                <div v-if="falseTypeOfApartment.length" style="color: red;">
				<label>{{falseTypeOfApartment}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -150px;
                ">Broj soba</h2>
                <input type="number" v-model="roomNum" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                    width: 150px;
                "><br>
                <div v-if="falseRoomNum.length" style="color: red;">
				<label>{{falseRoomNum}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -140px;
                ">Broj gostiju</h2>
                <input type="number" v-model="guestNum" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                    width: 150px;
                "><br>
                <div v-if="falseGuestNum.length" style="color: red;">
				<label>{{falseGuestNum}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -155px;
                ">Lokacija</h2>
                <input type="text" v-model="location" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                "><br>
                <div v-if="falseLocation.length" style="color: red;">
				<label>{{falseLocation}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -150px;
                ">Datum od</h2>
                <input type="date" v-model="dateFrom" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                "><br>
                <div v-if="falseDateFrom.length" style="color: red;">
				<label>{{falseDateFrom}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -150px;
                ">Datum do</h2>
                <input type="date" v-model="dateTo" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                "><br>
                <div v-if="falseDateTo.length" style="color: red;">
				<label>{{falseDateTo}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -138px;
                ">Cena po noci</h2>
                <input type="number" v-model="price" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                    width: 150px;
                "><br>
                <div v-if="falsePrice.length" style="color: red;">
				<label>{{falsePrice}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -120px;
                ">Vreme za prijavu</h2>
                <input type="time" value="14:00" v-model="checkInTime" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                "><br>
                <div v-if="falseCheckInTime.length" style="color: red;">
				<label>{{falseCheckInTime}}</label>
				</div>

                <h2 style="
                    position: relative;
                    top: 20px;
                    left: -120px;
                ">Vreme za odjavu</h2>
                <input type="time" value="10:00" v-model="checkOutTime" style="
                    position: relative;
                    top: -5px;
                    left: 100px;
                "><br>
                <div v-if="falseCheckOutTime.length" style="color: red;">
				<label>{{falseCheckOutTime}}</label>
				</div>

                <div style="
                        position: relative;
                        top: 20px;
                        left: 60px;
                        width: 340px;
                ">
                          
                        <fieldset>      
                            <legend>Lista sadrzaja apartmana</legend>      
                            <input type="checkbox" value="Klima" v-model="amenities">Klima<br>      
                            <input type="checkbox" value="Tv" v-model="amenities">Tv<br>      
                            <input type="checkbox" value="Internet" v-model="amenities">Internet<br>      
                            <br>           
                        </fieldset>      
                </div>
                
                                <label>{{ amenities | json }}</label>

                
                <button type="submit" style="
                    position: relative;
                    top: 40px;
                    left: -40px;
                    width: 340px;
                ">Dodaj</button></br>
                
                

            </form>
        </div>
               	               

</div>	  
`
		,
		
		mounted () {
	    },

		methods : {
			addNewApartment : function(e) {
				
				  this.falseTypeOfApartment = "",
			      this.falseRoomNum = "",
			      this.falseGuestNum = "",
			      this.falseLocation = "",
			      this.falseDateFrom = "",
			      this.falseDateTo = "",
			      this.falsePrice = "",
			      this.falseCheckInTime = "",
			      this.falseCheckOutTime = "",
			      this.falseAmenities = ""			    	  
			    	  
				
			    if(this.typeOfApartment!="",
				      this.roomNum,
				      this.guestNum,
				      this.location,
				      this.dateFrom,
				      this.dateTo,
				      this.price,
				      this.checkInTime,
				      this.checkOutTime){
					const location1 = {
						"latitude": 45.24,
						"longitude": 19.84,
						"address": {
										"address": this.location
								   }		
					}
					
					this.location = location1;
					
					var type = null;
					
					if(this.typeOfApartment == "Ceo apartman"){
						type = "WHOLE";
					}else if(this.typeOfApartment == "Soba"){
						type = "ROOM";
					}
										
						
									
					params = {
							"typeOfApartment": type, 
						 	"numberOfRooms":parseInt(this.roomNum),
						 	"numberOfGuests":parseInt(this.guestNum),
						 	"location":this.location,
						 	"availableFrom":Date.parse(this.dateFrom),
						 	"availableTo":Date.parse(this.dateTo),
							"availabilityByDate":null, 
							"host":null,
							"comments":null,
							"pricePerNight":this.price,
							"checkInTime":null,
							"checkOutTime":null,
							"status":true, 
							"amenities":null,
							"reservations":null
						 };
					
					axios
			  		.post('rest/apartments/doesApartmentExist', params).
			  		then(response => (this.deosExist = response.data));
					
					axios
			  		.post('rest/apartments/addApartment', params);					
					
					//this.$router.push('/');
					e.preventDefault();
					return;
			    }
			    if(!this.typeOfApartment){
			  		this.falseTypeOfApartment = "Izaberite tip apartmana";
				}
			    if(!this.roomNum){
			  		this.falseRoomNum = "Unesitee broj soba";
			   	}
				if(!this.guestNum){
		    		this.falseGuestNum = "Unesite broj gostiju";
		    	}
		    	if(!this.location){
		    		this.falseLocation = "Unesite lokaciju apartmana";
		    	}
		    	if(!this.dateFrom){
		    		this.falseDateFrom = "Unesite datum od";
		    	}
		    	if(!this.dateTo){
		    		this.falseDateTo = "Unesite datum do";
		    	}
		    	if(!this.price){
		    		this.falsePrice = "Unesite cenu";
		    	}
		    	if(!this.checkInTime){
		    		this.falseCheckInTime = "Unesite vreme prijave";
		    	}
		    	if(!this.checkOutTime){
		    		this.falseCheckOutTime = "Unesite vreme odjave";
		    	}
		    	
		    	e.preventDefault();
	    		return;
		    	
	    	}
	    	    
		},
			
	
});
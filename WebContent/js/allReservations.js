Vue.component("all-reservations", {
	data: function () {
	    return {
	      reservations: null
	    }
},
	template: ` 
<div style="position: absolute;
  left: 100px;
  top: 150px;">

        <div id="all_reservations">

                <ul style="
                    list-style-type: none;
                    margin-top: 25px;
                ">
                    <li v-for="reservation in reservations" style="
                        margin-top: 10px;
                    ">
                        <a href="https://www.w3schools.com" style="
                            text-decoration: none;
                            font-family: Candara;
                        ">

                        <div id="one_reservation" style="
                            width: 1000px;
                            height: 250px;
                            background-color: rgb(0, 0, 0, 0.85);
                            color: azure;
                            margin: auto;
                            text-align: left;
                            border-radius: 10px 10px 10px 10px;
                        ">

                        <img src="appartment.jpg" style="
                            position: relative;
                            float: left;
                            margin-top: 34px;
                            margin-left: 20px;
                            display: block;
                            height: 180;
                            width: 300;
                            border-radius: 10px;
                        ">


                        <div id="text" style="
                            position: relative;
                            top: 20px;
                            left: 50;
                            font-weight: bold;
                            font-size: 24;
                        ">
                            <div id="name">{{reservation.apartment.location.address.address}}</div>
                            <div id="date">Pocetni datum rezervacije: {{reservation.startDate}}</div>
                            <div id="staying_nights">Broj nocenja: {{reservation.numberOfNights}}</div>
                            <div id="total_price">Ukupna cena: {{reservation.totalPrice}}$</div>
                            <div id="reservation_message">Poruka pri rezervaciji: {{reservation.message}}</div>
                            <div id="reservation_guest">Gost: {{reservation.guest.name}} {{reservation.guest.surname}}</div>
                            <div id="reservation_status">Status: {{reservation.statusOfReservation}} 
                                <button style="
                                    position: relative;
                                    left: 220;
                                    height: 40px;
                                    width: 160px;
                                    background-color: teal;
                                    color: azure;
                                    font-family: Candara;
                                    font-weight: bold;
                                    font-size: 22;
                                    border: 1px transparent;
                                    border-radius: 35px;
                                ">Odustani</button>
                            </div>
                            </div>
                        </div>
                        </a>
                    </li>

                    

                </ul>

        </div>
               	               

</div>  
`
	,
	mounted () {
		axios
        .get('rest/reservations')
        .then(response => (this.reservations = response.data));
    },

	methods : {
		
	}
	
});
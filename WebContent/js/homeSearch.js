Vue.component("home-search", {
	data: function () {
		    
	},
	template: ` 
<div>

		<form>
			
			<div class="location">
                <label>Lokacija</label></br>
                <input type="text">
            </div>

            <div class="startdate">
                <label>Dolazak</label></br>
                <input type="date">
            </div>

            <div class="enddate">
                <label>Odlazak</label></br>
                <input type="date">
            </div>

            <div class="startprice">
                <label>Cena od</label></br>
                <input type="text">
            </div>

            <div class="endprice">
                <label>Cena do</label></br>
                <input type="text">
            </div>

			<div class="guests">
                <label>Broj gostiju</label></br>
                <input type="number">
            </div>
			
            <div class="rooms">
                <label>Broj soba</label></br>
                <input type="number">
            </div>

                <button type="submit">Pretraga</button>

        </form>            	               

</div>	  
`
	, 
	methods : {
		
	},
	mounted () {
       
    }
});
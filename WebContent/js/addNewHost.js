Vue.component("add-NewHost", {
	data: function () {
	    return {
	      users: null,
	      username: null,
		    password: null,
		    name: null,
		    lastname: null,
		    gender: null,
		    confirmpassword: null,
		    falseUsername : "",
		    falsePassword : "",
		    falseName : "",
		    falseLastname : "",
		    falseGender : "",
		    falseConfirmPassword : "",
		    notMatchingPasswords : "",
		    doesExist : ""
	    }
},
	template: ` 
<div style="position: absolute;
  left: 100px;
  top: 150px;">
  
		<button v-on:click="allUsers" style="position: relative;
		  left: -60px;
		  top: 0px;
		">
		Svi Korisnici</button>

		<button style="position: relative;
		  left: -80px;
		  top: 0px;
		  background-color: teal;
		  color: azure;
		">
		Dodaj novog domacina</button>
		
		<div class="reg_title" style="
			width: 400px;
		    background-color: rgb(0, 0, 0, 0.6);
		    color: azure;
		    margin: auto;
		    text-align: center;
		    padding-top: 10px;
		    padding-bottom: 10px;
		    border-radius: 10px 10px 10px 10px;
		"><h1>Registracija</h1></div>
		
        <div class="reg_mane" style="
        	width: 400px;
        	height: auto;
		    background-color: rgb(0, 0, 0, 0.5);
		    color: azure;
		    margin: auto;
		    text-align: left;
		    border-radius: 10px 10px 10px 10px;
        ">
            <form @submit="registerNewUser" style="
            	padding: 10px;
				margin-left: 10px;
            ">

                <h2 class="username" style="
                	position: relative;
				    left: -3px;
                ">Korisnicko ime</h2>
                <input class="usernameinput" type="text" v-model="username" style="
                	position: relative;
				    top: 0px;
				    left: 3px;
                "><br>
                <div v-if="falseUsername.length">
				<label style="color: red;">{{falseUsername}}</label>
				</div>

                <h2 class="name">Ime</h2>
                <input class="nameinput" type="text" id="name" v-model="name"><br>
                <div v-if="falseName.length">
				<label style="color: red;">{{falseName}}</label>
				</div>

                <h2 class="lastname">Prezime</h2>
                <input class="lastnameinput" type="text" id="lastname" v-model="lastname"><br>
                <div v-if="falseLastname.length">
				<label style="color: red;">{{falseLastname}}</label>
				</div>

                <h2 class="pol">Pol</h2>
                <label class="radio">
                    <input class="radio-male" type="radio" name="gender" value="Musko" v-model="gender">
                    <span class="checkmark"></span>
                    Muško    
                </label>
                <label class="radio">
                    <input class="radio-female" type="radio" name="gender" value="Zensko" v-model="gender">
                    <span class="checkmark"></span>
                    Žensko 
                </label>
                <div v-if="falseGender.length">
				<label style="color: red;">{{falseGender}}</label>
				</div>

                <h2 class="password">Lozinka</h2>
                <input class="passwordinput" type="password" id="password" v-model="password"><br>
                <div v-if="falsePassword.length">
				<label style="color: red;">{{falsePassword}}</label>
				</div>

                <h2 class="reppass">Potvrda lozinke</h2>
                <input class="reppassinput" type="password" id="confirmpassword" v-model="confirmpassword"><br>
                 <div v-if="falseConfirmPassword.length">
				<label style="color: red;">{{falseConfirmPassword}}</label>
				</div>
				<div v-if="notMatchingPasswords.length">
				<label style="color: red;">{{notMatchingPasswords}}</label>
				</div>


                <button type="submit" style="
                	position: relative; 
                	top: 10px;
                	left: -40px;
                ">Dodaj domacina</button><br><br>
                
                <label style="color: red;">{{doesExist}}</label>

            </form>
        </div>
		
        
               	               

</div>	  
`
	,
	mounted () {
		axios
        .get('rest/users')
        .then(response => (this.users = response.data));
    },

	methods : {
		allUsers : function() {
			this.$router.push('/allUsers');  
    	},
    	registerNewUser: function(e) {
	    	this.falseUsername = "";
		    this.falsePassword = "";
		    this.falseName = "";
		    this.falseLastname = "";
		    this.falseGender = "";
		    this.falseConfirmPassword = "";
		    this.notMatchingPasswords = "";
		    
	    	if(this.username && this.password && this.name 
	    	   && this.lastname && this.confirmpassword && this.password === this.confirmpassword){
	    		
	    		var genderOfUser;
	    		if(this.gender == "Musko"){
	    			genderOfUser = true;
				}else if(this.gender == "Zensko"){
					genderOfUser = false;
				}
	    		
	    		axios
		  		.post('rest/users/doesUserExist', {"username": this.username, 
		  											 "password":this.password,
		  											 "name":this.name,
		  											 "surname":this.lastname,
		  											 "gender":genderOfUser,
		  											 "role":"HOST"})
		  		.then(response => (this.doesExist = response.data));
	    		
		    	axios
		  		.post('rest/users/register', {"username": this.username, 
		  											 "password":this.password,
		  											 "name":this.name,
		  											 "surname":this.lastname,
		  											 "gender":genderOfUser,
		  											 "role":"HOST"});
		    	
		    	
		    	
		    	alert("Odgovor: " + this.doesExist);
		    	this.username= null;
			    this.password= null;
			    this.name= null;
			    this.lastname= null;
			    this.gender= null;
			    this.confirmpassword= null;
		    	e.preventDefault();

		    	return;
	    	}
	    	if(!this.username){
	    		this.falseUsername = "Unesite korisnicko ime";
	    	}
	    	if(!this.password){
	    		this.falsePassword = "Unesite lozinku";
	    	}
	    	if(!this.name){
	    		this.falseName = "Unesite ime";
	    	}
	    	if(!this.lastname){
	    		this.falseLastname = "Unesite prezime";
	    	}
	    	if(!this.gender){
	    		this.falseGender = "Unesite pol korisnika";
	    	}
	    	if(!this.confirmpassword){
	    		this.falseConfirmPassword = "Unesite potvrdu lozinke";
	    	}
	    	if(this.password !== this.confirmpassword){
	    		this.notMatchingPasswords = "Lozinka i potvrda lozinke se ne poklapaju"
	    	}
	    	
	    	e.preventDefault();
    		return;
	    	
	    }
	}
	
});
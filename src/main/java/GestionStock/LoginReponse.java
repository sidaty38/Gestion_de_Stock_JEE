package GestionStock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginReponse {
	@JsonProperty
	private String email;
	@JsonProperty
	private String password;
	
	public String getEmail() {
        return email;
    }
	
	 public String getPassword() {
	        return password;
	    }
}

package GestionStock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Utilisateur {

	    @JsonProperty
	    private int id;
	    @JsonProperty
	    private String email;
	    @JsonProperty
	    private String role;
	    @JsonProperty// "ADMIN", "GESTIONNAIRE", "CLIENT"
	    private String password;
	    
	    public Utilisateur(int id,String email,String role,String password) {
	    	this.id=id;
	    	this.email=email;
	    	this.role=role;
	    	this.password=password;
	    	}
	    public int getId() {
	        return id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getRole() {
	        return role;
	    }

	    public String getPassword() {
	        return password;
	    }

	    

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String toString() {
	        return "Utilisateur{id=" + id + ", Email=" + email + ", Role=" + role + ",Password="+ password +" }";
	    }
	}



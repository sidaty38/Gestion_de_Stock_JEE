package GestionStock;

public class Utilisateur {

	
	    private int id;
	    private String email;
	    private String role; // "ADMIN", "GESTIONNAIRE", "CLIENT"
	    private String password;

	    public Utilisateur(int id,String email,String role,String password) {
	    	this.id=id;
	    	this.email=email;
	    	this.role=role;
	    	this.password=password;
	    	}
	}



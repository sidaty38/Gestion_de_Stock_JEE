package GestionStock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client extends Utilisateur {
	@JsonProperty
    private String nom;
	@JsonProperty
    private String  prenom;
	@JsonProperty
    private String  adress;
    
    public Client (String nom,String prenom,String adress,int id,String email,String password) {
    	 super(id,email,"client",password); 
         this.nom = nom;
         this.prenom = prenom;
         this.adress = adress;
    } 
    
    public Client () {
    	
    }
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    public String getPrenom() {
        return prenom;
    }

  
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  
    public String getAdress() {
        return adress;
    }

   
    public void setAdress(String adress) {
        this.adress = adress;
    }

	
}


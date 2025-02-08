package GestionStock;

public class Client extends Utilisateur {
    private String nom;
    private String  prenom;
    private String  adress;
    
    public Client (String nom,String prenom,String adress,int id,String email,String password) {
    	 super(id,email,"client",password); 
         this.nom = nom;
         this.prenom = prenom;
         this.adress = adress;
    }  
}


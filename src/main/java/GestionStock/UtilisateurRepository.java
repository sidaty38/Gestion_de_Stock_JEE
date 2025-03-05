package GestionStock;

import java.util.HashMap;
import java.util.Map;

public class UtilisateurRepository {
	
	static Map<Integer,Utilisateur> users=new HashMap<>();
	
	static {
		users.put(1, new Utilisateur(1, "Admin", "Admin", "admin"));
		users.put(2, new Utilisateur(2,"Gestionnaire","gestionnaire","1234"));
	}
	
	public Map<Integer,Utilisateur> get() {
		return users;
	}
	public Utilisateur getbyid(int id){
		return users.get(id);
	}
	
	   public Utilisateur getByEmail(String email) {
	        for (Utilisateur user : users.values()) {
	            if (user.getEmail().equals(email)) {
	                return user; 
	            }
	        }
	        return null;  
	    }
	
	
	public void save(Utilisateur user) {
		int id=user.getId();
		users.put(id,user);
	}
	
	public void deletebyid(int id) {
		users.remove(id);
	}
	
	public Utilisateur update(int id,Utilisateur user) {
		users.replace(id, user);
		return user;
	}

}

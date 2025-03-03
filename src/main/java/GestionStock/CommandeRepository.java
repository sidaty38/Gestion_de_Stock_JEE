package GestionStock;

import java.util.HashMap;
import java.util.Map;

public class CommandeRepository {
	static Map<Integer,Commandes> commande=new HashMap<>();
	
	public Map<Integer,Commandes> get() {
		return commande;
	}
	public void save(Commandes c) {
		int id=c.getId();
		commande.put(id, c);
		
		

}
	public Commandes getbyid(int id){
		return commande.get(id);
	}
	public void deletebyid(int id) {
		commande.remove(id);
	}
	public Commandes update(int id,Commandes c) {
		commande.replace(id, c);
		return c;
	}
}

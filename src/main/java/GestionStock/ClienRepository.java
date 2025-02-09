package GestionStock;

import java.util.HashMap;
import java.util.Map;

public class ClienRepository {
     
	static Map<Integer,Client> clients=new HashMap<>();
	
	public Map<Integer,Client> get() {
		return clients;
	}
	public void save(Client client) {
		int id=client.getId();
		clients.put(id, client);
	}
	public Client getbyid(int id){
		return clients.get(id);
	}
	public void deletebyid(int id) {
		clients.remove(id);
	}
	public Client update(int id,Client client) {
		clients.replace(id, client);
		return client;
	}
	}

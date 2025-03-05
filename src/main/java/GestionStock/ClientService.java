package GestionStock;

import java.util.List;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("client")
public class ClientService {
     
	static ClienRepository repository = new ClienRepository();
	
	@GET
	@Path("allClient")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Integer,Client> get() {
		return repository.get();
	}
	@GET
	@Path("Client/historique/commandes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commandes> historique_commandes(@PathParam("id") int id){
		Client client= repository.getbyid(id);
		return client.getcommande();
	}
	
	@PUT
	@Path("insertClient")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Client User) {
		User.setRole("Client");
		repository.save(User);
	}
	
	@POST
	@Path("UpdateClient/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void upadate(@PathParam(value = "id") int id,Client client) {
		repository.update(id, client);
	}
	
	@DELETE
	@Path("deleteClient/{id}")
	public void delete(@PathParam("id") int id) {
		
	        repository.deletebyid(id);
	   
	}
	
}

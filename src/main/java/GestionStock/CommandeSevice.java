	package GestionStock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("commande")
@Produces(MediaType.APPLICATION_JSON)
public class CommandeSevice {
	static ClienRepository clientrepository = new ClienRepository();
	static CommandeRepository repository = new CommandeRepository();
	static ProduitRespository produit = new ProduitRespository();
	
	@PUT
	@Path("client/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(Commandes commande) {
		try {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		commande.setDateCommande(sdf.format(new Date()));
		commande.setStatus("En cours");
		commande.setPrix(produit.prix_totale(commande.getProduits()));
		
		produit.reduireStock(commande.getProduits());
		Client client = clientrepository.getbyid(commande.getIdclient());
		client.ajouterCommande(commande);
		repository.save(commande);
		return "";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
	
	@GET
	@Path("gestionnaire/All")
	public Map<Integer,Commandes> All(){
		return repository.get();
	}
	
	@POST
	@Path("gestionnaire/status")
	public void status(StatusResponse status) {
		Commandes c = repository.getbyid(status.id);
		c.setStatus(status.status);
		repository.update(status.id,c);
	}
}

package GestionStock;

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

@Path("/produits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitService {
private ProduitController produitResponse = new ProduitController();

@GET 
public Map<Integer, Produit> getAllProduits(){
	return produitResponse.getAll();
}
@GET 
@Path("/{id_produit}")
@Consumes(MediaType.APPLICATION_JSON)
public Produit getProduitById(@PathParam("id_produit") int id_produit) {
    return produitResponse.getbyid(id_produit);
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
public void addProduit(Produit produit) {
    produitResponse.addProduit(produit);
}
@PUT
@Path("/{id_produit}")
@Consumes(MediaType.APPLICATION_JSON)
public Produit updateProduit(@PathParam("id_produit") int id_produit, Produit produit) {
    return produitResponse.update(id_produit, produit);
}
@DELETE
@Path("/{id_produit}")
@Consumes(MediaType.APPLICATION_JSON)
public void deleteProduit(@PathParam("id_produit") int id_produit) {
    produitResponse.deletebyid(id_produit);
}

}

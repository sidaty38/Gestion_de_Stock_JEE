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


@Path("/allproducts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitService {
	 private static int id_produit = 3;
private ProduitRespository produitResponse = new ProduitRespository();

@GET
@Consumes(MediaType.APPLICATION_JSON)
public Map<Integer, Produit> getAllProduits(){
	return produitResponse.getAll();
}
@GET 
@Path("showproduct/{id_produit}")
@Consumes(MediaType.APPLICATION_JSON)
public Produit getProduitById(@PathParam("id_produit") int id_produit) {
    return produitResponse.getbyid(id_produit);
}
@PUT
@Consumes(MediaType.APPLICATION_JSON)
public String InsertProduit(Produit produit) {
	produit.setId_produit(id_produit++);
    produitResponse.addProduit(produit);
    return "{\"message \": \"Produit ajouté avec succee\"}";
}

@POST

@Path("updateproduct/{id_produit}")
@Consumes(MediaType.APPLICATION_JSON)
public Produit updateProduit(@PathParam("id_produit") int id_produit, Produit produit) {
    return produitResponse.update(id_produit, produit);
}
@DELETE
@Path("deleteproduct/{id_produit}")
@Consumes(MediaType.APPLICATION_JSON)
public String  deleteProduit(@PathParam("id_produit") int id_produit) {
    produitResponse.deletebyid(id_produit);
    return "{\"message \": \"Produit supprimé avec succee\"}";
}
@PUT
@Path("updatequantity/{id_produit}/quantite/{nouvelleQuantite}")
public Produit updateQuantiteProduit(@PathParam("id_produit") int id_produit, 
                                     @PathParam("nouvelleQuantite") int nouvelleQuantite) {
    return produitResponse.updateQuantite(id_produit, nouvelleQuantite);
}

}

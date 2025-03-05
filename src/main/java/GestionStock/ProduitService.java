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


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitService {
	 private static int id_produit = 3;
private ProduitRespository produitResponse = new ProduitRespository();

@GET
@Path("gestionnaire/all")
@Consumes(MediaType.APPLICATION_JSON)
public Map<Integer, Produit> getAllProduits(){
	return produitResponse.getAll();
}
@GET 
@Path("gestionnaire/showproduct/{id_produit}")
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
@POST
@Path("gestionnaire/updatequantity/{id_produit}/quantite/{nouvelleQuantite}")
public Produit updateQuantiteProduit(@PathParam("id_produit") int id_produit, 
                                     @PathParam("nouvelleQuantite") int nouvelleQuantite) {
    return produitResponse.updateQuantite(id_produit, nouvelleQuantite);
}

@PUT
@Path("gestionnaire/alert/produitfaible/{id}")
public String alert(@PathParam("id") int id) {
	Produit produit=produitResponse.getbyid(id);
	if(produit!=null) {
		produitResponse.addproduitfaible(id);
		return "";
	}else {
		return "le produit ne pas trouver";
	}
}

@GET
@Path("Stockfaible")
public Map<Integer,String> stockfaible(){
	return produitResponse.produitfaible();
}


}

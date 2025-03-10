package GestionStock;

import java.util.HashMap;
import java.util.Map;

public class ProduitRespository {

	static Map<Integer,Produit> produits=new HashMap<>();
	static Map<Integer,String> produitfaible= new HashMap<>();
	static {
		produits.put(1, new Produit(1,"Ordinateur","PC Portable Marque DEll",120000.0,20));
		produits.put(2, new Produit(2,"SmartPhone","Telephone Portable Marque Samsung",450000.0,30));
	}
	public Map<Integer,Produit>getAll(){
		return produits;
	}
	public Produit getbyid(int id_produit) {
		return produits.get(id_produit);
	}
	public void addProduit(Produit produit) {
		produits.put(produit.getId_produit(), produit);
	}
	public void deletebyid(int id_produit) {
		produits.remove(id_produit);
	}
	public Produit update(int id_produit,Produit produit) {
		produits.replace(id_produit, produit);
		return produit;
	}
	public  void reduireStock(Map<Integer, Integer> produit) throws Exception {
        for (Map.Entry<Integer, Integer> entry : produit.entrySet()) {
        	Integer produitId = entry.getKey();
            Produit p=produits.get(produitId);
           int quantite = p.getQuantite();
           int new_quantite= quantite - entry.getValue();
           if (p == null) {
               throw new Exception("Produit avec ID " + produitId + " introuvable !");
           }

           if (new_quantite < 0) {
               throw new Exception("Stock insuffisant pour le produit ID " + produitId);
           }
           
           p.setQuantite(new_quantite);
           produits.replace(produitId, p);
        }
    }
	public double prix_totale(Map<Integer, Integer> produit) {
		double total=0.0;
        for (Map.Entry<Integer, Integer> entry : produit.entrySet()) {
        	 int produitId = entry.getKey();
             int quantite = entry.getValue();
             Produit p=produits.get(produitId);
             double prix=p.getPrix();
             total +=prix*quantite;
        }
        return total;
    }
	
	
	
	public Produit updateQuantite(int id_produit, int nouvelleQuantite) {
        Produit produit = produits.get(id_produit);
        if (produit != null) {
            produit.setQuantite(nouvelleQuantite);
        }
        return produit;
    }
	
	public void addproduitfaible(int id) {
		String nom=produits.get(id).getNom();
		produitfaible.put(id, "le stock de "+nom+" est faible");
	}
	
	public Map<Integer,String> produitfaible(){
		return produitfaible;
	}
}

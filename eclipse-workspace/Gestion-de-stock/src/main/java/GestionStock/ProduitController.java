package GestionStock;

import java.util.HashMap;
import java.util.Map;

public class ProduitController {

	static Map<Integer,Produit> produits=new HashMap<>();
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
}

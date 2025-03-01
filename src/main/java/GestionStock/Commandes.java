package GestionStock;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commandes {
	@JsonProperty
	   private int id;
		@JsonProperty
		private String status;
		@JsonProperty
		private double prix;
		@JsonProperty
		private Map<Integer, Integer> produits;
		private String dateCommande;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		public Map<Integer, Integer> getProduits() {
			return produits;
		}
		public void setProduits(Map<Integer, Integer> produits) {
			this.produits = produits;
		}
		public String getDateCommande() {
			return dateCommande;
		}
		public void setDateCommande(String dateCommande) {
			this.dateCommande = dateCommande;
		}

}

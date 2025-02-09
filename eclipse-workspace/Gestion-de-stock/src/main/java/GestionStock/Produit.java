package GestionStock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produit {
	@JsonProperty
private int id_produit;
	@JsonProperty
private String nom;
	@JsonProperty
private String description;
	@JsonProperty
private double prix;
	@JsonProperty
private int quantite;
	public Produit() {
    }

	public Produit(int id_produit,String nom,String description,Double prix,int quantite) {
		this.id_produit=id_produit;
		this.nom=nom;
		this.description=description;
		this.prix=prix;
		this.quantite=quantite;
		
	}

	

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom=" + nom + ", description=" + description + ", prix=" + prix
				+ ", quantite=" + quantite + "]";
	}
}

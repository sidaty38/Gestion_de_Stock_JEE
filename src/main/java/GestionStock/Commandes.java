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

}

package GestionStock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusResponse {
	@JsonProperty
	int id;
	@JsonProperty
	String status;

}

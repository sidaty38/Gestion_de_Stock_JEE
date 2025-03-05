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

@Path("/Admin")
public class UtilisateurService {
	static UtilisateurRepository repository=new UtilisateurRepository();
	
	@GET
	@Path("allUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Integer,Utilisateur> get() {
		return repository.get();
	}
	
	@PUT
	@Path("insertUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Utilisateur User) {
		repository.save(User);
	}
	
	@POST
	@Path("UpdateUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void upadate(@PathParam(value = "id") int id,Utilisateur User) {
		repository.update(id, User);
	}
	
	@DELETE
	@Path("deleteUser/{id}")
	public void delete(@PathParam("id") int id) {
		
	        repository.deletebyid(id);
	    
	}
	@POST
    @Path("/{id}/updatepassword")
    public String updatePassword(@PathParam("id") int id, PasswordRequest passwordRequest) {
        UtilisateurRepository.updatePassword(id, passwordRequest.getNewPassword());
        return "{\"message\": \"Mot de passe modifié avec succès\"}";
    }

}

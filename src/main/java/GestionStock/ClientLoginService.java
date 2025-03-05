package GestionStock;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/client")
public class ClientLoginService {
	static ClienRepository repository=new ClienRepository();
    @PUT
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Login(LoginReponse rep,@Context HttpServletRequest req) {
    	Client client=repository.getByEmail(rep.getEmail());
   	 if(client!=null && client.getPassword().equals(rep.getPassword())) {
   		 HttpSession session = req.getSession(true);
   		 session.setAttribute("role", client.getRole());
   		 return Response.ok().build();
   	 }else {
   		 return Response.status(401).encoding("Echec de l'authentification ").build(); 
   	 }
   	 
    }

}

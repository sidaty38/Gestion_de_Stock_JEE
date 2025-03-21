package GestionStock;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class LoginService {
	static UtilisateurRepository repository=new UtilisateurRepository();
     @PUT
     @Path("/login")
     @Consumes(MediaType.APPLICATION_JSON)
     public Response Login(LoginReponse rep,@Context HttpServletRequest req) {
    	 Utilisateur user=repository.getByEmail(rep.getEmail());
    	 if(user!=null && user.getPassword().equals(rep.getPassword())) {
    		 HttpSession session = req.getSession(true);	
    		 session.setAttribute("role", user.getRole());
    		 return Response.ok().build();
    	 }else {
    		 return Response.status(401).encoding("Echec de l'authentification ").build(); 
    	 }
    	 
     }
     @GET
     @Path("/logout")
     public Response logout(@Context HttpServletRequest req) {
    	 HttpSession session = req.getSession(false);
    	 if(session!=null) {
    		 session.invalidate();
    	 }
    	 return Response.ok("Déconnexion réussie").build();
     }
}

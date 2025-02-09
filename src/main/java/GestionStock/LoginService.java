package GestionStock;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("Login")
public class LoginService {
	static UtilisateurRepository repository=new UtilisateurRepository();
     @PUT
     public Response Login(LoginReponse rep,@Context HttpServletRequest req) {
    	 Utilisateur user=repository.getByEmail(rep.getEmail());
    	 if(user!=null && user.getPassword().equals(rep.getPassword())) {
    		 HttpSession session = req.getSession(true);
    		 session.setAttribute("user", user);
    		 return Response.ok().build();
    	 }else {
    		 return Response.status(401).encoding("Echec de l'authentification ").build(); 
    	 }
    	 
     }
}

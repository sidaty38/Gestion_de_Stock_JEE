package GestionStock;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Controle_daccès implements Filter {
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

       
        String role = (session != null) ? (String) session.getAttribute("role") : null;
        String path = req.getRequestURI();

        boolean isLogin = path.endsWith("/login");
		boolean isSinginClient=path.endsWith("/insertClient");
		boolean logout=path.endsWith("/logout");
		
		if(isLogin || isSinginClient || logout) {
			chain.doFilter(request, response);
		}
		
		else if(role.equals("Admin")) {
			chain.doFilter(request, response);
		}
        
		else if (role.equals("Gestionnaire") && path.contains("/gestionnaire")) {
            chain.doFilter(request, response);
        } else if (role.equals("Client") && path.contains("/client")) {
            chain.doFilter(request, response);
        } else {
        	res.sendError(401, "erreur echec d'acces a cette ressouce");;
        }
    }
}

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

public class AuthentificationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse rep= (HttpServletResponse) response;
		String path = req.getRequestURI();
		boolean isLogin = path.endsWith("/login");
		HttpSession session = req.getSession(false);
		boolean loggedIn = (session!=null && session.getAttribute("user")!=null);
		
		if(isLogin || loggedIn) {
			chain.doFilter(request, response);
		}else {
			rep.sendError(401, "Accès refusé !");
		}
		
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author awarsyle
 */
public class AuthenticationFilter implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
            // this code will execute before HomeServlet and UsersServlet
            HttpServletRequest r = (HttpServletRequest)request;
            HttpSession session = r.getSession();
            
            if (session.getAttribute("username") != null) {
                // if they are authenticated, i.e. have a username in the session,
                // then allow them to continue on to the servlet
                chain.doFilter(request, response);
            } else {
                // they do not have a username in the sesion
                // so, send them to login page
                HttpServletResponse resp = (HttpServletResponse)response;
                resp.sendRedirect("login");
            }
            
            // this code will execute after HomeServlet and UsersServlet
            
            
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }

    
}

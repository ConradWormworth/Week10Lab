/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import database.NotesDBException;
import database.UserDB;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author 612944
 */
public class AdminFilter implements Filter {
    
     public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
         try {
             // this code will execute before HomeServlet and UsersServlet
             HttpServletRequest r = (HttpServletRequest)request;
             HttpSession session = r.getSession();
             UserDB userDB = new UserDB();
             String username = (String)session.getAttribute("username");
             User user = userDB.getUser(username);
             
             
             if (user.getRole().getRoleid() == 1) {
                 // the user has an admin account
                 // therefore, they are allowed into users.jsp
                 chain.doFilter(request, response);
                 
             } else {
                // they do not have an admin role
                // so, take them to the home page instead
                
                HttpServletResponse resp = (HttpServletResponse)response;
                resp.sendRedirect("home");
             }
             
             // this code will execute after HomeServlet and UsersServlet
         } catch (NotesDBException ex) {
             Logger.getLogger(AdminFilter.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
}

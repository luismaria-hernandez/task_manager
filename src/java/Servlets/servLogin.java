
package Servlets;

import Controller.Gestor;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "servLogin", urlPatterns = {"/servLogin"})
public class servLogin extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            if(request.getParameter("control").equals("a"))
            {
                HttpSession session = request.getSession();
                session.invalidate();
                
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1)) 
        {
            if(request.getParameter("control").equals("a"))
            {
                HttpSession session = request.getSession();
                session.invalidate();
                
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        Gestor g = new Gestor();
        HttpSession session = request.getSession();
        
        String mail = request.getParameter("txtMail");
        String clave = request.getParameter("txtClave");
        
        Usuarios u = g.validarUsuario(mail, clave);
        
        if(u != null) 
        {
            if(u.getIdTipoUsuario()== 1)
            {
                String iniciales = u.getIniciales();
                int permiso = u.getIdTipoUsuario();
                

                session.setAttribute("user", iniciales);
                session.setAttribute("permiso", permiso);
                
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
            else 
            {
                String iniciales = u.getIniciales();
                int permiso = u.getIdTipoUsuario();
                
                session.setAttribute("user", iniciales);
                session.setAttribute("permiso", permiso);
                
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }

        }
        else 
        {
            request.setAttribute("mensajeError","Invalid email address or password. Please, try again.");
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

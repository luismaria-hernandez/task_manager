
package Servlets;

import Controller.Gestor;
import Model.UsuariosDos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servAgregarUser", urlPatterns = {"/servAgregarUser"})
public class servAgregarUser extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            ArrayList listaProyectos = g.traerProyectos();
            request.setAttribute("listaProyectos", listaProyectos);
            
            ArrayList listaTU = g.traerTiposUsuario();
            request.setAttribute("listaTU", listaTU);
            
            RequestDispatcher rd = request.getRequestDispatcher("/agregarUser.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String mail = request.getParameter("txtMail");
            String clave = request.getParameter("txtPass");
            int idTipoUsuario = Integer.parseInt(request.getParameter("cboTipoUser"));
            String iniciales = request.getParameter("txtIniciales");
            int idProyecto = Integer.parseInt(request.getParameter("cboProyecto"));
            
            UsuariosDos u = new UsuariosDos(nombre,apellido,mail,clave,idTipoUsuario,iniciales,idProyecto);
            
            
            if(g.agregarUser(u))
            {
                String mensajeExito = "User has been created successfully!";
                request.setAttribute("mensajeExito", mensajeExito);
                
                RequestDispatcher rd = request.getRequestDispatcher("/mensajes.jsp");
                rd.forward(request, response);
            }
            else 
            {
                String mensajeError = "There's been an error while creating the user";
                request.setAttribute("mensajeError", mensajeError );
                
                RequestDispatcher rd = request.getRequestDispatcher("/mensajes.jsp");
                rd.forward(request, response);
            }
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

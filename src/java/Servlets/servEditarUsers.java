
package Servlets;

import Controller.Gestor;
import DTO.DTOUser;
import Model.UsuariosDos;
import Model.UsuariosTres;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servEditarUsers", urlPatterns = {"/servEditarUsers"})
public class servEditarUsers extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user")!= null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            int idUser = Integer.parseInt(request.getParameter("id"));
            
            DTOUser du = g.traerDatosUser(idUser);
            
            ArrayList listaProyectos = g.traerProyectos();
            request.setAttribute("listaProyectos", listaProyectos);
            
            ArrayList listaTU = g.traerTiposUsuario();
            request.setAttribute("listaTU", listaTU);
            
            int idUsuario = du.getIdUsuario();
            request.setAttribute("idUsuario", idUsuario);
            
            String nombre = du.getName();
            request.setAttribute("nombre", nombre);
            
            String apellido = du.getApellido();
            request.setAttribute("apellido",apellido);
            
            String mailGlobant = du.getMailGlobant();
            request.setAttribute("mailGlobant",mailGlobant);
            
            int idTipoUsuario = du.getIdTipoUsuario();
            request.setAttribute("idTipoUsuario", idTipoUsuario);
            
            String iniciales = du.getIniciales();
            request.setAttribute("iniciales",iniciales);
            
            int idProyecto = du.getIdProyecto();
            request.setAttribute("idProyecto", idProyecto);
            
            RequestDispatcher rd = request.getRequestDispatcher("/editarUsuario.jsp");
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
            
            int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String mail = request.getParameter("txtMail");
            int idTipoUsuario = Integer.parseInt(request.getParameter("cboTipoUser"));
            String iniciales = request.getParameter("txtIniciales");
            int idProyecto = Integer.parseInt(request.getParameter("cboProyecto"));
            
            UsuariosTres u = new UsuariosTres(nombre,apellido,mail,idTipoUsuario,iniciales,idProyecto);
            
            if(g.actualizarDatos(u, idUsuario))
            {
                String mensajeExito = "User's data has been updated successfully!";
                request.setAttribute("mensajeExito", mensajeExito);
                
                RequestDispatcher rd = request.getRequestDispatcher("/mensajes.jsp");
                rd.forward(request, response);
            }
            else 
            {
                String mensajeError = "There's been an error while updating the user's data";
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

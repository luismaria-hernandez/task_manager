
package Servlets;

import Controller.Gestor;
import DTO.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servUsers", urlPatterns = {"/servUsers"})
public class servUsers extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user")!= null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            String ini = request.getSession().getAttribute("user").toString();
            
            int idUser = g.traerIdUsuario(ini);
            
            ArrayList listaUsers = g.traerUsuarios(idUser);
            
            request.setAttribute("listaUsers", listaUsers);
            
            RequestDispatcher rd = request.getRequestDispatcher("/users.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

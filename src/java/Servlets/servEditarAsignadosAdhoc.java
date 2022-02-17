
package Servlets;

import Controller.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servEditarAsignadosAdhoc", urlPatterns = {"/servEditarAsignadosAdhoc"})
public class servEditarAsignadosAdhoc extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            int idAdhoc = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idAdhoc", idAdhoc);
            
            ArrayList listaAsignados = g.traerAsignadosAdhoc(idAdhoc);
            request.setAttribute("listaAsignados", listaAsignados);
            
            RequestDispatcher rd = request.getRequestDispatcher("/editarAsignadosAdhoc.jsp");
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


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


@WebServlet(name = "servEditProject", urlPatterns = {"/servEditProject"})
public class servEditProject extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            ArrayList listaProyectos = g.traerProyectos();
            request.setAttribute("listaProyectos",listaProyectos);
            
            String iniciales = request.getSession().getAttribute("user").toString();
            
            int idProyecto = g.traerIdproyecto(iniciales);
            request.setAttribute("idProyecto", idProyecto );
            
            RequestDispatcher rd = request.getRequestDispatcher("/editProject.jsp");
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
            
            int idProyecto = Integer.parseInt(request.getParameter("cboProyectos"));
            
            String iniciales = request.getSession().getAttribute("user").toString();
            
            g.cambiarProyecto(idProyecto,iniciales);
            
            response.sendRedirect(getServletContext().getContextPath() + "/servMyAccount");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

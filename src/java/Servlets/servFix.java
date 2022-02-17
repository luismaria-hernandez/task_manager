
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

@WebServlet(name = "servFix", urlPatterns = {"/servFix"})
public class servFix extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2)) 
        {
        
            String iniciales = request.getSession().getAttribute("user").toString();
            
            Gestor g = new Gestor();
            
            int idProyecto = g.traerIdproyecto(iniciales);
            
            ArrayList listaSprints = g.traerSprints(idProyecto);
            request.setAttribute("listaSprints",listaSprints);
            
            if (request.getParameter("cboSprints") != null)
            {
                int idSprint = Integer.parseInt(request.getParameter("cboSprints"));
                ArrayList listaFix = g.traerFixes(idSprint);
                
                request.setAttribute("selSprint", idSprint);
                request.setAttribute("listaFix", listaFix);
                
                RequestDispatcher rd = request.getRequestDispatcher("/fix.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("/fix.jsp");
                rd.forward(request, response);
            }
        
        }
        else if (request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            String iniciales = request.getSession().getAttribute("user").toString();
            
            Gestor g = new Gestor();
            
            int idProyecto = g.traerIdproyecto(iniciales);
            
            ArrayList listaSprints = g.traerSprints(idProyecto);
            request.setAttribute("listaSprints",listaSprints);
            
            if (request.getParameter("cboSprints") != null)
            {
                int idSprint = Integer.parseInt(request.getParameter("cboSprints"));
                ArrayList listaFix = g.traerFixes(idSprint);
                
                request.setAttribute("selSprint", idSprint);
                request.setAttribute("listaFix", listaFix);
                
                RequestDispatcher rd = request.getRequestDispatcher("/fix.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("/fix.jsp");
                rd.forward(request, response);
            }
        
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

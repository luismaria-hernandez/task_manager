
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


@WebServlet(name = "servSprints", urlPatterns = {"/servSprints"})
public class servSprints extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1)) 
        {
            Gestor g = new Gestor();
            
            ArrayList listaProyectos = g.traerProyectos();
            request.setAttribute("listaProyectos",listaProyectos);
            
            RequestDispatcher rd = request.getRequestDispatcher("/crearNuevoSprint.jsp");
            rd.forward(request, response);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1)) 
        {
            Gestor g = new Gestor();
            
            int idProyecto = Integer.parseInt(request.getParameter("cboProyectos"));
            float numeroSprint = Float.parseFloat(request.getParameter("txtNum"));
            String versionBuild = request.getParameter("txtVer");
            
            if(g.insertarNuevoSprint(idProyecto, numeroSprint, versionBuild)) 
            {

                String mensajeExito = "New sprint has been created";
                request.setAttribute("mensajeExito",mensajeExito);

                RequestDispatcher rd = request.getRequestDispatcher("/mensajesDos.jsp");
                rd.forward(request, response);
            }
            else 
            {
                String mensajeError = "There's been a problem while creating the new sprint";
                request.setAttribute("mensajeError",mensajeError);

                RequestDispatcher rd = request.getRequestDispatcher("/mensajesDos.jsp");
                rd.forward(request, response);
            }
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

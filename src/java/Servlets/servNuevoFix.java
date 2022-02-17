
package Servlets;

import Controller.Gestor;
import Model.FixesDos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servNuevoFix", urlPatterns = {"/servNuevoFix"})
public class servNuevoFix extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            ArrayList listaProyectos = g.traerProyectos();
            request.setAttribute("listaProyectos",listaProyectos);
            
            if(request.getParameter("cboProyectos") != null && !request.getParameter("cboProyectos").equals(""))
            {
                int idProyecto = Integer.parseInt(request.getParameter("cboProyectos"));
                request.setAttribute("idProyecto",idProyecto);
                
                ArrayList listaSprints = g.traerSprints(idProyecto);
                request.setAttribute("listaSprints",listaSprints);
                
                ArrayList listaPrioridad = g.traerPrioridadesFix();
                request.setAttribute("listaPrioridad",listaPrioridad);

                ArrayList listaEstados = g.traerEstados();
                request.setAttribute("listaEstados",listaEstados);
                
                
                RequestDispatcher rd = request.getRequestDispatcher("/crearNuevoFix.jsp");
                rd.forward(request, response);
            }
            else 
            {               
                RequestDispatcher rd = request.getRequestDispatcher("/crearNuevoFix.jsp");
                rd.forward(request, response);
            }         
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();

            String titulo = request.getParameter("txtTitulo");
            String ticket = request.getParameter("txtTicket");
            int prioridad = Integer.parseInt(request.getParameter("cboPrioridad"));
            int estado = Integer.parseInt(request.getParameter("cboEstado"));
            int sprint = Integer.parseInt(request.getParameter("cboSprints"));
            String fecha = request.getParameter("dtpFecha");
            String adminComment = request.getParameter("txtAdminComment");

            FixesDos f = new FixesDos(titulo,ticket,prioridad,fecha,adminComment,estado,sprint,true);
            
            boolean control = g.insertarFix(f);

            if(control)
            {

                String mensajeExito = "New Fix has been created";
                request.setAttribute("mensajeExito",mensajeExito);

                RequestDispatcher rd = request.getRequestDispatcher("/mensajesDos.jsp");
                rd.forward(request, response);
            }
            else 
            {
                String mensajeError = "There's been a problem while creating the new Fix";
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


package Servlets;

import Controller.Gestor;
import Model.RequestDos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servNuevoReq", urlPatterns = {"/servNuevoReq"})
public class servNuevoReq extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
         {
            Gestor g = new Gestor();
            
            /*TRAEMOS LAS LISTAS*/
            ArrayList listaEstados = g.traerEstados();
            request.setAttribute("listaEstados",listaEstados);
            
            ArrayList listaPrioridad = g.traerPrioridadesReq();
            request.setAttribute("listaPrioridad",listaPrioridad);
            
            RequestDispatcher rd = request.getRequestDispatcher("/nuevoReq.jsp");
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
            
            String tituloReq = request.getParameter("txtTitulo");
            String linkTicket = request.getParameter("txtTicket");
            int idEstado = Integer.parseInt(request.getParameter("cboEstado"));
            int idPrioridad = Integer.parseInt(request.getParameter("cboPrioridad"));
            String fecha = request.getParameter("dtpFecha");
            String hora = request.getParameter("hora");
            String req = request.getParameter("txtAdminComment");
            
            RequestDos r = new RequestDos(tituloReq,linkTicket,idEstado,idPrioridad,fecha,hora,req,true);
            
            boolean control = g.crearNuevoReq(r);
            
            if(control)
            {

                String mensajeExito = "New Request has been created";
                request.setAttribute("mensajeExito",mensajeExito);

                RequestDispatcher rd = request.getRequestDispatcher("/mensajesDos.jsp");
                rd.forward(request, response);
            }
            else 
            {
                String mensajeError = "There's been a problem while creating the new Request";
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

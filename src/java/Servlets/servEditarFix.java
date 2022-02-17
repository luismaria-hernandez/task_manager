
package Servlets;

import Controller.Gestor;
import DTO.DTOFixesDos;
import DTO.DTOFixesTres;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servEditarFix", urlPatterns = {"/servEditarFix"})
public class servEditarFix extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user")!= null && request.getSession().getAttribute("permiso").equals(1))
        {
            if (request.getParameter("id") != null && !request.getParameter("id").equals(""))
            {
                Gestor g = new Gestor();
                
                int idFix = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idFix",idFix);
                
                String iniciales = request.getSession().getAttribute("user").toString();
                int idProy = g.traerIdproyecto(iniciales);
                
                /*Cargamos las listas*/
                
                ArrayList listaProyectos = g.traerProyectos();
                request.setAttribute("listaProyectos",listaProyectos);
                
                ArrayList listaPF = g.traerPrioridadesFix();
                request.setAttribute("listaPF",listaPF);
                
                ArrayList listaEstados = g.traerEstados();
                request.setAttribute("listaEstados",listaEstados);
                
                ArrayList listaPrioridad = g.traerPrioridadesFix();
                request.setAttribute("listaPrioridad",listaPrioridad);
                
                ArrayList listaSprints = g.traerSprints(idProy);
                request.setAttribute("listaSprints",listaSprints);
                
                /*Traemos los datos del fix*/
                
                DTOFixesDos df = g.traerDatosFix(idFix);
                
                String tituloFix = df.getTituloFix();
                request.setAttribute("tituloFix",tituloFix);
                
                String linkTicket = df.getLinkTicket();
                request.setAttribute("linkTicket",linkTicket);
                
                int idPrioridad = df.getIdPrioridadFix();
                request.setAttribute("idPrioridad", idPrioridad);
                
                Date fecha = df.getFecha();
                request.setAttribute("fecha", fecha);
                
                int idEstado = df.getIdEstado();
                request.setAttribute("idEstado", idEstado);
                
                int idSprint = df.getIdSprint();
                request.setAttribute("idSprint", idSprint);
                
                String adminComment = df.getAdminComment();
                request.setAttribute("adminComment", adminComment);
                

                RequestDispatcher rd = request.getRequestDispatcher("/editarFix.jsp");
                rd.forward(request, response);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getSession().getAttribute("user")!= null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            int idFix = Integer.parseInt(request.getParameter("txtIdFix"));
            String tituloFix = request.getParameter("txtTitulo");
            String linkTicket = request.getParameter("txtTicket");
            int idPrioridadFix = Integer.parseInt(request.getParameter("cboPrioridad"));
            int idEstado = Integer.parseInt(request.getParameter("cboEstado"));
            int idSprint = Integer.parseInt(request.getParameter("cboSprints"));
            String fecha = request.getParameter("dtpFecha");
            String adminComment = request.getParameter("txtAdminComment");
           
            DTOFixesTres df = new DTOFixesTres(tituloFix,linkTicket,idPrioridadFix,fecha,adminComment,idEstado,idSprint);
            g.actualizarFix(df, idFix);
            
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirFix?id="+idFix);
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

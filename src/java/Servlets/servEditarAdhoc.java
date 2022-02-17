
package Servlets;

import Controller.Gestor;
import DTO.DTOAdhocDos;
import DTO.DTOAdhocTres;
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


@WebServlet(name = "servEditarAdhoc", urlPatterns = {"/servEditarAdhoc"})
public class servEditarAdhoc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            if(request.getParameter("id") != null && !request.getParameter("id").equals(""))
            {
                int idAdhoc = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idAdhoc",idAdhoc);
                
                String iniciales = request.getSession().getAttribute("user").toString();

                int idProyecto = g.traerIdproyecto(iniciales);

                /*cargamos las listas*/
                ArrayList listaSprints = g.traerSprints(idProyecto);
                request.setAttribute("listaSprints", listaSprints);

                ArrayList listaEstados = g.traerEstados();
                request.setAttribute("listaEstados", listaEstados);

                ArrayList listaEstadosAdhoc = g.traerEstadoAdhoc();
                request.setAttribute("listaEstadosAdhoc",listaEstadosAdhoc);

                /*Cargamos los datos del objeto*/
                
                DTOAdhocDos da = g.traerDatosAdhoc(idAdhoc);
                
                String tituloTicket = da.getTituloTicket();
                request.setAttribute("tituloTicket",tituloTicket);
                
                String linkTicket = da.getLinkTicket();
                request.setAttribute("linkTicket",linkTicket);
                
                int idEstado = da.getIdEstado();
                request.setAttribute("idEstado", idEstado);
                
                int idSprint = da.getIdSprint();
                request.setAttribute("idSprint", idSprint);
                
                int estadosAdhoc = da.getIdEstadoAdhoc();
                request.setAttribute("estadosAdhoc", estadosAdhoc);
                
                Date fecha = da.getFecha();
                request.setAttribute("fecha", fecha);
                
                RequestDispatcher rd = request.getRequestDispatcher("/editarAdhoc.jsp");
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
            
            int idAdhoc = Integer.parseInt(request.getParameter("txtIdAdhoc"));
            
            String tituloTicket = request.getParameter("txtTitulo");
            String linkTicket = request.getParameter("txtTicket");
            int idEstado = Integer.parseInt(request.getParameter("cboEstado"));
            int idEstadoAdhoc = Integer.parseInt(request.getParameter("cboEstadosAdhoc"));
            int idSprint = Integer.parseInt(request.getParameter("cboSprints"));
            String fecha = request.getParameter("dtpFecha");
            
            DTOAdhocTres da = new DTOAdhocTres(tituloTicket,linkTicket,idEstado,idEstadoAdhoc,idSprint,fecha);
            
            g.actualizarAdhoc(da, idAdhoc);
            
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirAdhoc?id="+idAdhoc);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

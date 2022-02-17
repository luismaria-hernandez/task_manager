
package Servlets;

import Controller.Gestor;
import DTO.DTOReqDos;
import Model.RequestTres;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servEditarReq", urlPatterns = {"/servEditarReq"})
public class servEditarReq extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            int idReq = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idReq", idReq);
            
            /*CARGAMOS LAS LISTAS*/
            
            ArrayList listaPrioridad = g.traerPrioridadesReq();
            request.setAttribute("listaPrioridad", listaPrioridad);
            
            ArrayList listaEstados = g.traerEstados();
            request.setAttribute("listaEstados", listaEstados);
            
            /*TRAEMOS LOS DATOS DEL REQUEST*/
            
            RequestTres r = g.traerDatosRequest(idReq);
            
            String tituloReq = r.getTituloRequest();
            request.setAttribute("tituloReq", tituloReq);
            
            String linkTicket = r.getLinkTicket();
            request.setAttribute("linkTicket", linkTicket);
            
            Date fecha = r.getFecha();
            request.setAttribute("fecha",fecha);
            
            Time hora = r.getHora();
            request.setAttribute("hora",hora);
            
            String req = r.getReq();
            request.setAttribute("req",req);
            
            int idPrioridad = r.getIdPrioridadRequest();
            request.setAttribute("idPrioridad",idPrioridad);
            
            int idEstado = r.getIdEstado();
            request.setAttribute("idEstado",idEstado );
            
            RequestDispatcher rd = request.getRequestDispatcher("/editarReq.jsp");
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
            
            int idReq = Integer.parseInt(request.getParameter("idReq"));
            String tituloReq = request.getParameter("txtTitulo");
            String linkTicket = request.getParameter("txtTicket");
            int idPrioridad = Integer.parseInt(request.getParameter("cboPrioridad"));
            int idEstado = Integer.parseInt(request.getParameter("cboEstado"));
            String fecha = request.getParameter("dtpFecha");
            String hora = request.getParameter("hora");
            String req = request.getParameter("txtAdminComment");
                    
            DTOReqDos r = new DTOReqDos(tituloReq,linkTicket,idPrioridad,idEstado,fecha,hora,req);
            
            g.actualizarDatosRequest(idReq, r);
            
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirRequest?id="+idReq);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


package Servlets;

import Controller.Gestor;
import DTO.DTOAdhoc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servAbrirAdhoc", urlPatterns = {"/servAbrirAdhoc"})
public class servAbrirAdhoc extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            int idAdhoc= Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idAdhoc",idAdhoc);
            
            String ini = request.getSession().getAttribute("user").toString();
            
            DTOAdhoc ad = g.traerAdhoc(idAdhoc);
            
            String tituloTicket = ad.getTituloTicket();
            request.setAttribute("tituloTicket",tituloTicket);
            
            String linkTicket = ad.getLinkTicket();
            request.setAttribute("linkTicket",linkTicket);
            
            String estado = ad.getEstado();
            request.setAttribute("estado",estado);
            
            String estadoAdhoc = ad.getEstadoAdhoc();
            request.setAttribute("estadoAdhoc", estadoAdhoc);
            
            ArrayList asignadosAdhoc = g.traerAsignadosAdhoc(idAdhoc);
            
            String valor = "";

            if(!asignadosAdhoc.isEmpty())
            {
                valor = "a";
            }
            else 
            {
                valor = "b";
            }
            
            request.setAttribute("valor", valor);
            
            String separadoPorComa = String.join(",",asignadosAdhoc.toString());
            request.setAttribute("separadoPorComa", separadoPorComa);
     
            ArrayList listaEA = g.traerEstadoAdhoc();
            request.setAttribute("listaEA", listaEA);
            
            ArrayList listaComment = g.traerCommentsAdhoc(idAdhoc);

            
            if(!listaComment.isEmpty())
            {
            
                request.setAttribute("listaComment", listaComment);
                RequestDispatcher rd = request.getRequestDispatcher("/abrirAdhoc.jsp");
                rd.forward(request, response);
            
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("/abrirAdhoc.jsp");
                rd.forward(request, response);
            }
            
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
           Gestor g = new Gestor();
            
            int idAdhoc= Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idAdhoc",idAdhoc);   
            
            DTOAdhoc ad = g.traerAdhoc(idAdhoc);
            
            String tituloTicket = ad.getTituloTicket();
            request.setAttribute("tituloTicket",tituloTicket);
            
            String linkTicket = ad.getLinkTicket();
            request.setAttribute("linkTicket",linkTicket);
            
            String estado = ad.getEstado();
            request.setAttribute("estado",estado);
            
            String estadoAdhoc = ad.getEstadoAdhoc();
            request.setAttribute("estadoAdhoc", estadoAdhoc);
            
            ArrayList asignadosAdhoc = g.traerAsignadosAdhoc(idAdhoc);

            String valor = "";

            if(!asignadosAdhoc.isEmpty())
            {
                valor = "a";
            }
            else 
            {
                valor = "b";
            }
            
            request.setAttribute("valor", valor);
            
            String iniciales = request.getSession().getAttribute("user").toString();
            int idUsuario = g.traerIdUsuario(iniciales);
            
            int idProyecto = g.traerIdproyecto(iniciales);

            ArrayList listaUsuarios = g.traerUsuariosProyecto(idUsuario, idProyecto);
            request.setAttribute("listaUsuarios",listaUsuarios);
            
            
            String separadoPorComa = String.join(",",asignadosAdhoc.toString());
            request.setAttribute("separadoPorComa", separadoPorComa);
     
            ArrayList listaEA = g.traerEstadoAdhoc();
            request.setAttribute("listaEA", listaEA);
            
            ArrayList listaComment = g.traerCommentsAdhoc(idAdhoc);
            
            if(!listaComment.isEmpty())
            {
            
                request.setAttribute("listaComment", listaComment);
                RequestDispatcher rd = request.getRequestDispatcher("/abrirAdhoc.jsp");
                rd.forward(request, response);
            
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("/abrirAdhoc.jsp");
                rd.forward(request, response);
            } 
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            int idAdhoc = Integer.parseInt(request.getParameter("txtIdAdhoc"));
            int idEstadoAdhoc = Integer.parseInt(request.getParameter("cboEstadoAdhoc"));
            String comment = request.getParameter("txtComment");
            
            g.actualizarAdhoc(idAdhoc, idEstadoAdhoc);
            
            g.insertarRespuestaAdhoc(idAdhoc, comment);
            
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirAdhoc?id="+idAdhoc);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

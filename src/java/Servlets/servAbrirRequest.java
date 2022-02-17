
package Servlets;

import Controller.Gestor;
import DTO.DTOReq;
import Model.Requests;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servAbrirRequest", urlPatterns = {"/servAbrirRequest"})
public class servAbrirRequest extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            int idReq = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idReq",idReq);
            
            int idEstado = g.traerIdEstado(idReq);
            
            if(idEstado <= 2)
            {
                g.cambiarEstado(idReq);
            }
            
            DTOReq req = g.traerRequest(idReq);
            
            String tituloRequest = req.getTituloRequest();
            request.setAttribute("tituloRequest",tituloRequest);
            
            String linkTicket = req.getLinkTicket();
            request.setAttribute("linkTicket",linkTicket);
            
            String fecha = req.getFecha().toString();
            request.setAttribute("fecha",fecha);
            
            String hora = req.getHora().toString();
            request.setAttribute("hora",hora);
            
            String requesta = req.getReq();
            request.setAttribute("requesta", requesta);
            
            String prioridad = req.getPrioridadReq();
            request.setAttribute("prioridad", prioridad);
            
            String estado = req.getEstado();
            request.setAttribute("estado", estado);
            
            ArrayList listaRespuestas = g.traerRespuestaRequest(idReq);
        
            if(!listaRespuestas.isEmpty()) 
            {
                request.setAttribute("listaRespuestas",listaRespuestas);

                RequestDispatcher rd = request.getRequestDispatcher("/abrirRequest.jsp");
                rd.forward(request, response);  
            }
            else 
            {
                RequestDispatcher rd = request.getRequestDispatcher("/abrirRequest.jsp");
                rd.forward(request, response);
            }
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            int idReq = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idReq",idReq);
            
            DTOReq req = g.traerRequest(idReq);
            
            String tituloRequest = req.getTituloRequest();
            request.setAttribute("tituloRequest",tituloRequest);
            
            String linkTicket = req.getLinkTicket();
            request.setAttribute("linkTicket",linkTicket);
            
            String fecha = req.getFecha().toString();
            request.setAttribute("fecha",fecha);
            
            String hora = req.getHora().toString();
            request.setAttribute("hora",hora);
            
            String requesta = req.getReq();
            request.setAttribute("requesta", requesta);
            
            String prioridad = req.getPrioridadReq();
            request.setAttribute("prioridad", prioridad);
            
            String estado = req.getEstado();
            request.setAttribute("estado", estado);
            
            /*TRAEMOS LOS USUARIOS*/
            String iniciales = request.getSession().getAttribute("user").toString();
            int idUsuario = g.traerIdUsuario(iniciales);

            ArrayList listaUsuarios = g.traerTodosLosUsuarios(idUsuario);
            request.setAttribute("listaUsuarios",listaUsuarios);
            
            /*TRAEMOS LOS ASIGNADOS*/
            
            ArrayList listaAsignados = g.traerAsignadosRequest(idReq);

            String valor = "";

            if(!listaAsignados.isEmpty())
            {
                valor = "a";
            }
            else 
            {
                valor = "b";
            }

            request.setAttribute("valor", valor);
            
            String separadoPorComa = String.join(",",listaAsignados.toString());
            request.setAttribute("separadoPorComa", separadoPorComa);
            
            ArrayList listaRespuestas = g.traerRespuestaRequest(idReq);
        
            if(!listaRespuestas.isEmpty()) 
            {
                request.setAttribute("listaRespuestas",listaRespuestas);

                RequestDispatcher rd = request.getRequestDispatcher("/abrirRequest.jsp");
                rd.forward(request, response);  
            }
            else 
            {
                RequestDispatcher rd = request.getRequestDispatcher("/abrirRequest.jsp");
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
            
            int idReq = Integer.parseInt(request.getParameter("txtIdReq"));
            String respuesta = request.getParameter("txtRespuesta");
            
            g.insertarResponseRequest(idReq,respuesta);
    
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirRequest?id="+idReq);
            
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            int idReq = Integer.parseInt(request.getParameter("txtIdReq"));
            String respuesta = request.getParameter("txtRespuesta");
            
            g.insertarResponseRequest(idReq, respuesta);
    
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirRequest?id="+idReq);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

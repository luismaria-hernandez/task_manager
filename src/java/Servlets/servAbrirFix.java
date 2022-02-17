
package Servlets;

import Controller.Gestor;
import DTO.DTOFixes;
import Model.Asignados;
import Model.Fixes;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servAbrirFix", urlPatterns = {"/servAbrirFix"})
public class servAbrirFix extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            String ini = request.getSession().getAttribute("user").toString();
            
            int idFix = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idFix",idFix);
            
            int idEstado = g.traerIdEstadoFix(idFix);
            
            if(idEstado <= 2) 
            {
                g.cambiarEstadoFix(idFix);
            }
            
            DTOFixes df = g.traerFix(idFix);
            
            String tituloFix = df.getTituloFix();
            request.setAttribute("tituloFix",tituloFix);
            
            String linkTicket = df.getLinkTicket();
            request.setAttribute("linkTicket",linkTicket);
            
            String prioridad = df.getPrioridadFix();
            request.setAttribute("prioridad",prioridad);
            
            String estado = df.getEstado();
            request.setAttribute("estado", estado);
            
            String adminComment = df.getAdminComment();
            request.setAttribute("adminComment", adminComment);
            

            ArrayList listaAsignados = g.traerAsignados(idFix);

            String valor = "";

            if(listaAsignados.toString().contains(ini))
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


            ArrayList listaRespuestas = g.traerListaResponseFixes(idFix);
        
            if(!listaRespuestas.isEmpty()) 
            {

                request.setAttribute("listaRespuestas",listaRespuestas);

                RequestDispatcher rd = request.getRequestDispatcher("/abrirFix.jsp");
                rd.forward(request, response);  
            }
            else 
            {
                RequestDispatcher rd = request.getRequestDispatcher("/abrirFix.jsp");
                rd.forward(request, response);
            }
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            String ini = request.getSession().getAttribute("user").toString();
            
            int idFix = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idFix",idFix);
            
            DTOFixes df = g.traerFix(idFix);
            
            String tituloFix = df.getTituloFix();
            request.setAttribute("tituloFix",tituloFix);
            
            String linkTicket = df.getLinkTicket();
            request.setAttribute("linkTicket",linkTicket);
            
            String prioridad = df.getPrioridadFix();
            request.setAttribute("prioridad",prioridad);
            
            String estado = df.getEstado();
            request.setAttribute("estado", estado);
            
            String adminComment = df.getAdminComment();
            request.setAttribute("adminComment", adminComment);
            
            String iniciales = request.getSession().getAttribute("user").toString();
            int idUsuario = g.traerIdUsuario(iniciales);
            
            int idProyecto = g.traerIdproyecto(iniciales);

            ArrayList listaUsuarios = g.traerUsuariosProyecto(idUsuario, idProyecto);
            request.setAttribute("listaUsuarios",listaUsuarios);

            ArrayList listaAsignados = g.traerAsignados(idFix);
            
            String valor = "";

            if(listaAsignados.isEmpty())
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


            ArrayList listaRespuestas = g.traerListaResponseFixes(idFix);
        
            if(!listaRespuestas.isEmpty()) 
            {

                request.setAttribute("listaRespuestas",listaRespuestas);

                RequestDispatcher rd = request.getRequestDispatcher("/abrirFix.jsp");
                rd.forward(request, response);  
            }
            else 
            {
                RequestDispatcher rd = request.getRequestDispatcher("/abrirFix.jsp");
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

            int idFix = Integer.parseInt(request.getParameter("txtIdFix"));
            String respuesta = request.getParameter("txtRespuesta");

            g.insertarResponseFix(idFix, respuesta);

            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirFix?id="+idFix);

        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

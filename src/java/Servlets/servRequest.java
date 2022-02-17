
package Servlets;

import Controller.Gestor;
import DTO.DTOReq;
import Model.Requests;
import Model.RespuestasFix;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servRequest", urlPatterns = {"/servRequest"})
public class servRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {       
        if (request.getSession().getAttribute("user")!= null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            String ini = request.getSession().getAttribute("user").toString();
            
            ArrayList <Requests> listaRequests = g.traerRequests(ini);
            request.setAttribute("listaRequests", listaRequests);
            
            RequestDispatcher rd = request.getRequestDispatcher("/request.jsp");
            rd.forward(request, response);
        }
        else if (request.getSession().getAttribute("user")!= null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();

            ArrayList listaRequests = g.traerRequestAdmin();
            request.setAttribute("listaRequests", listaRequests);
            
            RequestDispatcher rd = request.getRequestDispatcher("/request.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


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


@WebServlet(name = "servEditarAsignados", urlPatterns = {"/servEditarAsignados"})
public class servEditarAsignados extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {   
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            if (request.getParameter("id") != null && !request.getParameter("id").equals(""))
            {
                Gestor g = new Gestor();
                int idFix = Integer.parseInt(request.getParameter("id"));
                
                request.setAttribute("idFix",idFix);
                
                ArrayList listaAsignados = g.traerListaAsignados(idFix);
                request.setAttribute("listaAsignados", listaAsignados);
                
                RequestDispatcher rd = request.getRequestDispatcher("/editarAsignados.jsp");
                rd.forward(request, response);
                
            }
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


package Servlets;

import Controller.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servEliminarAsignadosAdhoc", urlPatterns = {"/servEliminarAsignadosAdhoc"})
public class servEliminarAsignadosAdhoc extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            if (request.getParameter("id") != null && !request.getParameter("id").equals(""))
            {
                Gestor g = new Gestor();
                
                int idAdhoc = Integer.parseInt(request.getParameter("id"));
                g.eliminarAsignadosAdhoc(idAdhoc);
                
                response.sendRedirect(getServletContext().getContextPath() + "/servAbrirAdhoc?id="+idAdhoc);
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

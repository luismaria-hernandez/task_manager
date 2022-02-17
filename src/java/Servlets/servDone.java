
package Servlets;

import Controller.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servDone", urlPatterns = {"/servDone"})
public class servDone extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            if (request.getParameter("idReq") != null && !request.getParameter("idReq").equals("")) 
            {
                Gestor g = new Gestor();
                
                int idReq = Integer.parseInt(request.getParameter("idReq"));
                
                g.cambiarEstadoDone(idReq);
                
                response.sendRedirect(getServletContext().getContextPath() + "/servRequest");
            }
            else if (request.getParameter("idFix") != null && !request.getParameter("idFix").equals("")) 
            {
                Gestor g = new Gestor();
                
                int idFix = Integer.parseInt(request.getParameter("idFix"));
                
                g.cambiarEstadoDoneFix(idFix);
                int idSprint = g.traerIdPrint(idFix);
                
                response.sendRedirect(getServletContext().getContextPath() + "/servFix?cboSprints="+idSprint);
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

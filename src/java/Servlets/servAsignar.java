
package Servlets;

import Controller.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servAsignar", urlPatterns = {"/servAsignar"})
public class servAsignar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            if(request.getParameter("control") != null && !request.getParameter("control").equals(""))
            {
                int idFix = Integer.parseInt(request.getParameter("control"));
                String ini = request.getSession().getAttribute("user").toString();
                
                int idUsuario = g.traerIdUsuario(ini);
                
                g.asignarUsuarios(idUsuario,idFix);
                
                response.sendRedirect(getServletContext().getContextPath() + "/servAbrirFix?id="+idFix);
            }
            else if (request.getParameter("con") != null && !request.getParameter("con").equals(""))
            {
                int idAdhoc = Integer.parseInt(request.getParameter("con"));
                String ini = request.getSession().getAttribute("user").toString();
                
                int idUsuario = g.traerIdUsuario(ini);
                
                g.asignarUsuariosAdhoc(idUsuario, idAdhoc);
                
                response.sendRedirect(getServletContext().getContextPath() + "/servAbrirAdhoc?id="+idAdhoc);
            } 
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();

            int idFix = Integer.parseInt(request.getParameter("idFix"));
            int idUsuario = Integer.parseInt(request.getParameter("cboUsuarios"));

            g.asignarUsuarios(idUsuario, idFix);

            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirFix?id="+idFix);

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

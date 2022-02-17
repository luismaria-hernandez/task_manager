
package Servlets;

import Controller.Gestor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servAsignarReq", urlPatterns = {"/servAsignarReq"})
public class servAsignarReq extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
            
            int idReq = Integer.parseInt(request.getParameter("idReq"));
            int idUsuario = Integer.parseInt(request.getParameter("cboUsuarios"));
            
            g.asignarUsuariosRequest(idReq, idUsuario);
            
            response.sendRedirect(getServletContext().getContextPath() + "/servAbrirRequest?id="+idReq);
            
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

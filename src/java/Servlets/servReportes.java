
package Servlets;

import Controller.Gestor;
import Model.Sprints;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servReportes", urlPatterns = {"/servReportes"})
public class servReportes extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
        {
            Gestor g = new Gestor();
 
            ArrayList<Sprints> sprintsWy = g.traerSprintsWy();
            request.setAttribute("sprintsWy", sprintsWy);
            
            ArrayList<Sprints> sprintsLegHD = g.traerSprintsLegHD();
            request.setAttribute("sprintsLegHD", sprintsLegHD);
            
            ArrayList<Sprints> sprintsLegSD = g.traerSprintsLegSD();
            request.setAttribute("sprintsLegSD", sprintsLegSD);
            
            if(request.getParameter("cboSprintsWy")!= null)
            {
                int idSprintWy = Integer.parseInt(request.getParameter("cboSprintsWy"));
                request.setAttribute("idSprintWy", idSprintWy);
                
                //TOTAL
                int cantidadTotalWy = g.cantidadTotalWyplay(idSprintWy);
                request.setAttribute("cantidadTotalWy", cantidadTotalWy);
                
                //NOT RUN
                int cantidadNotRunWy = g.cantidadNotRunWyplay(idSprintWy);
                request.setAttribute("cantidadNotRunWy", cantidadNotRunWy);
                
                //PASS
                int cantidadPassWy = g.cantidadPassWyplay(idSprintWy);
                request.setAttribute("cantidadPassWy", cantidadPassWy);
                
                //FAIL
                int cantidadFailWy = g.cantidadFailWyplay(idSprintWy);
                request.setAttribute("cantidadFailWy", cantidadFailWy);
            }
            else if(request.getParameter("cboSprintsLegHD")!= null)
            {
                int idSprintLegHD = Integer.parseInt(request.getParameter("cboSprintsLegHD"));
                request.setAttribute("idSprintLegHD", idSprintLegHD);
                
                int cantidadTotalLegHD = g.cantidadTotalLegacyHD(idSprintLegHD);
                request.setAttribute("cantidadTotalLegHD", cantidadTotalLegHD);
                
                int cantidadNotRunLegHD = g.cantidadNotRunLegacyHD(idSprintLegHD);
                request.setAttribute("cantidadNotRunLegHD", cantidadNotRunLegHD);
                
                int cantidadPassLegHD = g.cantidadPassLegacyHD(idSprintLegHD);
                request.setAttribute("cantidadPassLegHD", cantidadPassLegHD);
                
                int cantidadFailLegHD = g.cantidadFailLegacyHD(idSprintLegHD);
                request.setAttribute("cantidadFailLegHD", cantidadFailLegHD);
                
            }
            else if(request.getParameter("cboSprintsLegSD")!= null)
            {
                int idSprintLegSD = Integer.parseInt(request.getParameter("cboSprintsLegSD"));
                request.setAttribute("idSprintLegSD", idSprintLegSD);
                
                int cantidadTotalLegSD = g.cantidadTotalLegacySD(idSprintLegSD);
                request.setAttribute("cantidadTotalLegSD", cantidadTotalLegSD);
                
                int cantidadNotRunLegSD = g.cantidadNotRunLegacySD(idSprintLegSD);
                request.setAttribute("cantidadNotRunLegSD", cantidadNotRunLegSD);
                
                int cantidadPassLegSD = g.cantidadPassLegacySD(idSprintLegSD);
                request.setAttribute("cantidadPassLegSD", cantidadPassLegSD);
                
                int cantidadFailLegSD = g.cantidadFailLegacySD(idSprintLegSD);
                request.setAttribute("cantidadFailLegSD", cantidadFailLegSD);
                
            }
            else if(request.getParameter("cboSprintsWy1")!= null)
            {
                int idSprintWy1 = Integer.parseInt(request.getParameter("cboSprintsWy1"));
                request.setAttribute("idSprintWy1", idSprintWy1);
                
                int cantidadTotalFixWy = g.cantidadTotalFix(idSprintWy1);
                request.setAttribute("cantidadTotalFixWy", cantidadTotalFixWy);
                
                int cantidadToDoFixWy = g.cantidadToDoFix(idSprintWy1);
                request.setAttribute("cantidadToDoFixWy", cantidadToDoFixWy);
                
                int cantidadInProgressFixWy = g.cantidadInProgressFix(idSprintWy1);
                request.setAttribute("cantidadInProgressFixWy", cantidadInProgressFixWy);
                
                int cantidadDoneFixWy = g.cantidadDoneFix(idSprintWy1);
                request.setAttribute("cantidadDoneFixWy", cantidadDoneFixWy);
                
            }
            else if(request.getParameter("cboSprintsLegHD1")!= null)
            {
                int idSprintLegHD1 = Integer.parseInt(request.getParameter("cboSprintsLegHD1"));
                request.setAttribute("idSprintLegHD1", idSprintLegHD1);
                
                int cantidadTotalFixLegHD = g.cantidadTotalFix(idSprintLegHD1);
                request.setAttribute("cantidadTotalFixLegHD",cantidadTotalFixLegHD);
                
                int cantidadToDoFixLegHD = g.cantidadToDoFix(idSprintLegHD1);
                request.setAttribute("cantidadToDoFixLegHD", cantidadToDoFixLegHD);
                
                int cantidadInProgressFixLegHD = g.cantidadInProgressFix(idSprintLegHD1);
                request.setAttribute("cantidadInProgressFixLegHD", cantidadInProgressFixLegHD );
                
                int cantidadDoneFixLegHD = g.cantidadDoneFix(idSprintLegHD1);
                request.setAttribute("cantidadDoneFixLegHD", cantidadDoneFixLegHD);
            }
            
            else if(request.getParameter("cboSprintsLegSD1")!= null)
            {
                int idSprintLegSD1 = Integer.parseInt(request.getParameter("cboSprintsLegSD1"));
                request.setAttribute("idSprintLegSD1", idSprintLegSD1);
                
                int cantidadTotalFixLegSD = g.cantidadTotalFix(idSprintLegSD1);
                request.setAttribute("cantidadTotalFixLegSD",cantidadTotalFixLegSD);
                
                int cantidadToDoFixLegSD = g.cantidadToDoFix(idSprintLegSD1);
                request.setAttribute("cantidadToDoFixLegSD", cantidadToDoFixLegSD);
                
                int cantidadInProgressFixLegSD = g.cantidadInProgressFix(idSprintLegSD1);
                request.setAttribute("cantidadInProgressFixLegSD", cantidadInProgressFixLegSD );
                
                int cantidadDoneFixLegSD = g.cantidadDoneFix(idSprintLegSD1);
                request.setAttribute("cantidadDoneFixLegSD", cantidadDoneFixLegSD);
            }
            
            
            RequestDispatcher rd = request.getRequestDispatcher("reportes.jsp");
            rd.forward(request, response);
            
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

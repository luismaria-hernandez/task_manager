
package Servlets;

import Controller.Gestor;
import DTO.DTOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servMyAccount", urlPatterns = {"/servMyAccount"})
public class servMyAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            String iniciales = request.getSession().getAttribute("user").toString();
            
            DTOUsuario u = g.traerDatosUsuario(iniciales);
            
            String nombre = u.getNombre();
            request.setAttribute("nombre",nombre);
            
            String apellido = u.getApellido();
            request.setAttribute("apellido", apellido);
            
            String mailGlobant = u.getMailGlobant();
            request.setAttribute("mailGlobant", mailGlobant);
            
            String tipoUsuario = u.getTipoUsuario();
            request.setAttribute("tipoUsuario", tipoUsuario);
            
            String ini = u.getIni();
            request.setAttribute("ini", ini);
            
            String nombreProyecto = u.getNombreProyecto();
            request.setAttribute("nombreProyecto", nombreProyecto);
            
            RequestDispatcher rd = request.getRequestDispatcher("/myAccount.jsp");
            rd.forward(request, response);
            
        } 
        
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(1))
            
        {
            Gestor g = new Gestor();
            
            String iniciales = request.getSession().getAttribute("user").toString();
            
            DTOUsuario u = g.traerDatosUsuario(iniciales);
            
            String nombre = u.getNombre();
            request.setAttribute("nombre",nombre);
            
            String apellido = u.getApellido();
            request.setAttribute("apellido", apellido);
            
            String mailGlobant = u.getMailGlobant();
            request.setAttribute("mailGlobant", mailGlobant);
            
            String tipoUsuario = u.getTipoUsuario();
            request.setAttribute("tipoUsuario", tipoUsuario);
            
            String ini = u.getIni();
            request.setAttribute("ini", ini);
            
            String nombreProyecto = u.getNombreProyecto();
            request.setAttribute("nombreProyecto", nombreProyecto);
            
            RequestDispatcher rd = request.getRequestDispatcher("/myAccount.jsp");
            rd.forward(request, response);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            String actual = request.getParameter("txtActual");
            String nueva = request.getParameter("txtNew");
            String repitaNueva = request.getParameter("txtRepeatNew");
            
            String ini = request.getSession().getAttribute("user").toString();
            
            String clave = g.buscarClave(ini);
            
            if(actual.equalsIgnoreCase(clave)) 
            {
                if(nueva.equalsIgnoreCase(repitaNueva))
                {
                    g.actualizarClave(nueva, ini);
                    
                    if(g.actualizarClave(nueva, ini))
                    {
                        String mensajeExito = "Your password has been changed successfully!";
                        request.setAttribute("mensajeExito", mensajeExito);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                        rd.forward(request, response);
                    }
                    else 
                    {
                        String mensajeError = "There's been an error while updating your password!";
                        request.setAttribute("mensajeError", mensajeError);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                        rd.forward(request, response);
                    }
                }
                else if(nueva.equalsIgnoreCase(actual) || repitaNueva.equals(actual))
                {
                    String mensajeDiferente = "The new password must be different from the actual one";
                    request.setAttribute("mensajeDiferente", mensajeDiferente);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                    rd.forward(request, response);
                }
                else if(nueva.equalsIgnoreCase(actual) && repitaNueva.equals(actual))
                {
                    String mensajeDiferente = "The new password must be different from the actual one";
                    request.setAttribute("mensajeDiferente", mensajeDiferente);
                }
                else
                {
                    String mensajeNoCoinciden = "Passwords don't match!";
                    request.setAttribute("mensajeNoCoinciden", mensajeNoCoinciden);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                    rd.forward(request, response);
                }
            }
            else 
            {
                String mensajeInvalid = "Actual password is invalid";
                request.setAttribute("mensajeInvalid", mensajeInvalid);
                
                RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                rd.forward(request, response);
            }  
        }
        else if(request.getSession().getAttribute("user") != null && request.getSession().getAttribute("permiso").equals(2))
        {
            Gestor g = new Gestor();
            
            String actual = request.getParameter("txtActual");
            String nueva = request.getParameter("txtNew");
            String repitaNueva = request.getParameter("txtRepeatNew");
            
            String ini = request.getSession().getAttribute("user").toString();
            
            String clave = g.buscarClave(ini);
            
            if(actual.equalsIgnoreCase(clave)) 
            {
                if(nueva.equalsIgnoreCase(repitaNueva))
                {
                    g.actualizarClave(nueva, ini);
                    
                    if(g.actualizarClave(nueva, ini))
                    {
                        String mensajeExito = "Your password has been changed successfully!";
                        request.setAttribute("mensajeExito", mensajeExito);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                        rd.forward(request, response);
                    }
                    else 
                    {
                        String mensajeError = "There's been an error while updating your password!";
                        request.setAttribute("mensajeError", mensajeError);
                        
                        RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                        rd.forward(request, response);
                    }
                }
                else if(nueva.equalsIgnoreCase(actual) || repitaNueva.equals(actual))
                {
                    String mensajeDiferente = "The new password must be different from the actual one";
                    request.setAttribute("mensajeDiferente", mensajeDiferente);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                    rd.forward(request, response);
                }
                else if(nueva.equalsIgnoreCase(actual) && repitaNueva.equals(actual))
                {
                    String mensajeDiferente = "The new password must be different from the actual one";
                    request.setAttribute("mensajeDiferente", mensajeDiferente);
                }
                else
                {
                    String mensajeNoCoinciden = "Passwords don't match!";
                    request.setAttribute("mensajeNoCoinciden", mensajeNoCoinciden);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                    rd.forward(request, response);
                }
            }
            else 
            {
                String mensajeInvalid = "Actual password is invalid";
                request.setAttribute("mensajeInvalid", mensajeInvalid);
                
                RequestDispatcher rd = request.getRequestDispatcher("/changePass.jsp");
                rd.forward(request, response);
            }  
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

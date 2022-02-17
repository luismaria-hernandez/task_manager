
package Controller;

import DTO.DTOAdhoc;
import DTO.DTOAdhocDos;
import DTO.DTOAdhocTres;
import DTO.DTOAsignadosFix;
import DTO.DTOCommentAdhoc;
import DTO.DTOFixes;
import DTO.DTOFixesDos;
import DTO.DTOFixesTres;
import DTO.DTOReq;
import DTO.DTOReqDos;
import DTO.DTOUser;
import DTO.DTOUsuario;
import DTO.DTOUsuariosProyecto;
import Model.RespuestaRequest;
import Model.Adhoc;
import Model.AdhocDos;
import Model.Asignados;
import Model.Estados;
import Model.EstadosAdhoc;
import Model.Fixes;
import Model.FixesDos;
import Model.PrioridadesFix;
import Model.PrioridadesReq;
import Model.Proyectos;
import Model.RequestDos;
import Model.RequestTres;
import Model.Requests;
import Model.RespuestasFix;
import Model.Sprints;
import Model.TiposUsuario;
import Model.Users;
import Model.Usuarios;
import Model.UsuariosDos;
import Model.UsuariosTres;
import java.sql.*;
import java.util.ArrayList;


public class Gestor 
{
    private String cadena ="jdbc:sqlserver://DESKTOP-BIR37MQ;databaseName=TaskManager_v16";
    private String user = "luismariah";
    private String pass = "ps2022";
    
    public Usuarios validarUsuario(String mail, String clave)
    {
        Usuarios u = null;
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
           
            String consulta = "select * from Usuarios where mailGlobant=? and clave =?";
                
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, mail);
            ps.setNString(2, clave);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                int idUsuario = rs.getInt("idUsuario");
                int idTipoUsuario = rs.getInt("idTipoUsuario");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String mailGlobant = rs.getNString("mailGlobant");
                String iniciales = rs.getNString("iniciales");
                int idProyecto = rs.getInt("idProyecto");
                
                u = new Usuarios(idUsuario,idTipoUsuario,nombre,apellido,mailGlobant,iniciales,idProyecto);
            }
            
            rs.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if (con != null && !con.isClosed()) 
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        return u;
    }
    
    public ArrayList<Requests> traerRequests(String ini)
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select r.idRequest,r.tituloRequest,r.linkTicket,r.fecha,pr.prioridadRequest,e.estado\n" +
                                "from Requests r join Usuarios_requests ur on r.idRequest=ur.idRequest join Usuarios u on u.idUsuario=ur.idUsuario join Prioridades_request pr on r.idPrioridadRequest=pr.idPriorirdadRequest join Estados e on r.idEstado=e.idEstado\n" +
                                "where u.iniciales = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, ini);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                int idRequest = rs.getInt("idRequest");
                String tituloRequest = rs.getNString("tituloRequest");
                String linkTicket = rs.getNString("linkTicket");
                String prioridadRequest= rs.getNString("prioridadRequest");
                String estado= rs.getNString("estado");
                Date fecha = rs.getDate("fecha");
                
                Requests r = new Requests(idRequest,tituloRequest,linkTicket,prioridadRequest,estado,fecha);
                
                lista.add(r);
            }
            
            rs.close();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed()) 
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public int traerIdproyecto (String iniciales) 
    {
        Connection con = null;
        int idProyecto = 0;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena, user, pass);
            
            String consulta = "select idProyecto\n" +
                                "from Usuarios\n" +
                                "where iniciales= ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, iniciales);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                idProyecto = rs.getInt("idProyecto");
            }
            
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con!=null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return idProyecto;
    }
    
    public ArrayList<Sprints> traerSprints(int idProyecto)
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint,numeroSprint,versionBuild\n" +
                                "from Sprints s\n" +
                                "where idProyecto = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idProyecto);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int idSprint = rs.getInt("idSprint");
                float numeroSprint = rs.getFloat("numeroSprint");
                String versionBuild = rs.getNString("versionBuild");
                
                Sprints sp = new Sprints(idSprint,numeroSprint,versionBuild);
                
                lista.add(sp);
            }
            
            rs.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con!=null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<Adhoc> traerListaAdhoc(int idSprint)
    {
        Connection con = null;
        ArrayList<Adhoc> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select a.idAdhoc,a.tituloTicket,a.linkTicket,e.estado,ea.estadoAdhoc\n" +
                                "from Adhoc a join Estados e on a.idEstado = e.idEstado join Estados_adhoc ea on a.idEstadosAdhoc=ea.idEstadoAdhoc\n" +
                                "where idSprint = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int idAdhoc = rs.getInt("idAdhoc");
                String tituloTicket = rs.getNString("tituloTicket");
                String linkTicket = rs.getNString("linkTicket");
                String estado = rs.getNString("estado");
                String estadoAdhoc = rs.getNString ("estadoAdhoc");
                
                Adhoc a = new Adhoc(idAdhoc,tituloTicket,linkTicket,estado,estadoAdhoc);
                
                lista.add(a);
            }
            rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con != null && !con.isClosed()) 
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }    
        
        return lista;
        
    }
    
    public ArrayList<Fixes> traerFixes(int idSprint)
    {
        
        Connection con = null;
        ArrayList<Fixes> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idFix,tituloFix,linkTicket,pf.prioridadFix,e.estado,f.adminComment\n" +
                                "from Fixes f join Prioridades_fix pf on f.idPrioridadFix=pf.idPrioridadFix join Estados e on e.idEstado=f.idEstado\n" +
                                "where idSprint = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int idFix = rs.getInt("idFix");
                String tituloFix = rs.getNString("tituloFix");
                String linkTicket = rs.getNString("linkTicket");
                String prioridadFix = rs.getNString("prioridadFix");
                String estado = rs.getNString("estado");
                String adminComment = rs.getString("adminComment");
                        
                Fixes f = new Fixes (idFix,tituloFix,linkTicket,prioridadFix,estado,adminComment);
                
                lista.add(f);
            }
            rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con != null && !con.isClosed()) 
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }    
        
        return lista;
    }
    
    public DTOFixes traerFix(int idFix)
    {
        Connection con = null;
        DTOFixes df = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select tituloFix,linkTicket,pf.prioridadFix,e.estado,f.adminComment\n" +
                                "from Fixes f join Prioridades_fix pf on f.idPrioridadFix=pf.idPrioridadFix join Estados e on e.idEstado=f.idEstado\n" +
                                "where idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String tituloFix = rs.getNString("tituloFix");
                String linkTicket = rs.getNString("linkTicket");
                String prioridadFix = rs.getNString("prioridadFix");
                String estado = rs.getNString("estado");
                String adminComment = rs.getNString("adminComment");
                
                df = new DTOFixes(tituloFix,linkTicket,prioridadFix,estado,adminComment);
            }

            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return df;
    }
    
    public ArrayList<Asignados> traerAsignados(int idFix) 
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select u.iniciales\n" +
                                "from Usuarios u join Usuarios_fixes uf on u.idUsuario=uf.idUsuario\n" +
                                "where uf.idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String iniciales = rs.getNString("iniciales");
                
                Asignados a = new Asignados(iniciales);
                
                lista.add(a);
            }

            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public void insertarResponseFix(int idFix, String response)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Responses_fix (idFix,response)\n" +
                                "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            ps.setNString(2, response);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }   
    
    public ArrayList<RespuestasFix> traerListaResponseFixes(int idFix)
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idResponsesFix,response\n" +
                                "from Responses_fix\n" +
                                "where idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next())
            {
                int idRespFix = rs.getInt("idResponsesFix");
                String respFix = rs.getNString("response");
                
                RespuestasFix rf = new RespuestasFix(idRespFix,respFix);
                
                lista.add(rf);
            }
            
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
        
    }
    
    public DTOReq traerRequest(int idRequest)
    {
        DTOReq dr = null;
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select r.tituloRequest,r.linkTicket,r.fecha,r.hora,r.request,pr.prioridadRequest,e.estado\n" +
                                "from Requests r join Prioridades_request pr on r.idPrioridadRequest=pr.idPriorirdadRequest join Estados e on r.idEstado = e.idEstado\n" +
                                "where idRequest = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idRequest);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String tituloRequest = rs.getNString("tituloRequest");
                String linkTicket = rs.getNString("linkTicket");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                String request = rs.getNString("request");
                String prioridadRequest = rs.getNString("prioridadRequest");
                String estado = rs.getNString("estado");
                
                dr = new DTOReq(tituloRequest,linkTicket,fecha,hora,request,prioridadRequest,estado);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return dr;
        
    }
    
    public ArrayList<RespuestaRequest> traerRespuestaRequest(int idRquest)
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idResponseRequest,response\n" +
                                "from Responses_request\n" +
                                "where idRequest = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idRquest);
            
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next())
            {
                int idRespReq = rs.getInt("idResponseRequest");
                String respReq = rs.getNString("response");
                
                RespuestaRequest rr = new RespuestaRequest(idRespReq,respReq);
                
                lista.add(rr);
            }
            
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(SQLException ex)
            {
                
            }
        }
        
        return lista;
        
    }
    
    public void insertarResponseRequest(int idReq, String response)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Responses_request (idRequest,response)\n" +
                                "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idReq);
            ps.setNString(2, response);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public DTOAdhoc traerAdhoc(int idAdhoc)
    {
        DTOAdhoc da = null;
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select a.tituloTicket,linkTicket,e.estado,ea.estadoAdhoc\n" +
                                "from Adhoc a join Estados e on a.idEstado=e.idEstado join Estados_adhoc ea on a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "where idAdhoc = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idAdhoc);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String tituloTicket = rs.getNString("tituloTicket");
                String linkTicket = rs.getNString("linkTicket");
                String estado = rs.getNString("estado");
                String estadoAdhoc = rs.getNString("estadoAdhoc");
                
                da = new DTOAdhoc(tituloTicket,linkTicket,estado,estadoAdhoc);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return da;
        
    }
    
    public ArrayList<EstadosAdhoc> traerEstadoAdhoc()
    {
        Connection con = null;
        ArrayList<EstadosAdhoc> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta ="select *\n" +
                                "from Estados_adhoc";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while(rs.next())
            {
                int idEstadoAdhoc = rs.getInt("idEstadoAdhoc");
                String estadoAdhoc = rs.getNString("estadoAdhoc");
                
                EstadosAdhoc ea = new EstadosAdhoc(idEstadoAdhoc,estadoAdhoc);
                
                lista.add(ea);
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed()) 
                {
                    con.close();
                }
            }
            catch (Exception e) 
            {
            
            }
        }
        
        return lista;
    }
    
    public void actualizarAdhoc(int idAdhoc, int idEstadoAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Adhoc\n" +
                                "set idEstadosAdhoc=?\n" +
                                "where idAdhoc=?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idEstadoAdhoc);
            ps.setInt(2, idAdhoc);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarRespuestaAdhoc(int idAdhoc,String comment)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into RespuestasAdhoc(idAdhoc,respuestaAdhoc)\n" +
                                "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idAdhoc);
            ps.setString(2, comment);

            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<DTOCommentAdhoc> traerCommentsAdhoc(int idAdhoc) 
    {
        Connection con = null;
        ArrayList <DTOCommentAdhoc> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta ="select idRespuestaAdhoc,respuestaAdhoc\n" +
                                "from RespuestasAdhoc\n" +
                                "where idAdhoc=?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idAdhoc);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int idRespAdhoc = rs.getInt("idRespuestaAdhoc");
                String respuestaAdhoc = rs.getNString("respuestaAdhoc");
                
                DTOCommentAdhoc da = new DTOCommentAdhoc(idRespAdhoc,respuestaAdhoc);

                lista.add(da);
            }
            rs.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed()) 
                {
                    con.close();
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
        return lista; 
    }
    
    public DTOUsuario traerDatosUsuario(String iniciales)
    {
        Connection con = null;
        DTOUsuario du = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select u.nombre,u.apellido,u.mailGlobant,tu.tipoUsuario,u.iniciales,p.nombreProyecto\n" +
                                "from Usuarios u join Tipos_usuario tu on u.idTipoUsuario=tu.idTipoUsuario join  Proyectos p on p.idProyecto=u.idProyecto\n" +
                                "where iniciales=?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, iniciales);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String mailGlobant = rs.getNString("mailGlobant");
                String tipoUsuario = rs.getNString("tipoUsuario");
                String ini = rs.getNString("iniciales");
                String nombreProyecto = rs.getNString("nombreProyecto");
                
                du = new DTOUsuario(nombre,apellido,mailGlobant,tipoUsuario,ini,nombreProyecto);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return du; 
    }
    
    public String buscarClave(String ini)
    {
        Connection con = null;
        String clave = "";
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select clave\n" +
                                "from Usuarios\n" +
                                "where iniciales = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, ini);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                clave = rs.getNString("clave");
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return clave;
    }
    
    public boolean actualizarClave(String clave, String ini)
    {
     Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Usuarios\n" +
                                "set clave=?\n" +
                                "where iniciales = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, clave);
            ps.setNString(2, ini);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return true;
    }
    
    public void asignarUsuarios(int idUsuario, int idFix)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Usuarios_fixes(idUsuario,idFix)\n" +
                                "values (?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUsuario);
            ps.setInt(2, idFix);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public int traerIdUsuario (String iniciales)
    {
        Connection con = null;
        int idUsuario = 0;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena, user, pass);
            
            String consulta = "select idUsuario\n" +
                                "from Usuarios\n" +
                                "where iniciales = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, iniciales);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                idUsuario = rs.getInt("idUsuario");
            }
            
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con!=null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return idUsuario; 
    }
    
    public ArrayList traerAsignadosAdhoc(int idAdhoc)
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select u.iniciales\n" +
                                "from Usuarios u join  Adhoc a on u.idUsuario = a.idUsuario\n" +
                                "where a.idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idAdhoc);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String iniciales = rs.getNString("iniciales");
                
                Asignados a = new Asignados(iniciales);
                
                lista.add(a);
            }

            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public void asignarUsuariosAdhoc (int idUsuario, int idAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Adhoc\n" +
                                "set idUsuario = ?\n" +
                                "where idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUsuario);
            ps.setInt(2, idAdhoc);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<Users> traerUsuarios(int idUser)
    {
        Connection con = null;
        ArrayList<Users> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select u.idUsuario,u.nombre,u.apellido,u.mailGlobant,tu.tipoUsuario,u.iniciales,p.nombreProyecto\n" +
                                "from Usuarios u join Tipos_usuario tu on u.idTipoUsuario=tu.idTipoUsuario join  Proyectos p on p.idProyecto=u.idProyecto\n" +
                                "where idUsuario != ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUser);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String mailGlobant = rs.getNString("mailGlobant");
                String tipoUsuario = rs.getNString("tipoUsuario");
                String ini = rs.getNString("iniciales");
                String nombreProyecto = rs.getNString("nombreProyecto");
                
                Users us = new Users(idUsuario,nombre,apellido,mailGlobant,tipoUsuario,ini,nombreProyecto);
                
                lista.add(us);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return lista; 
    }
    
    public DTOUser traerDatosUser(int idUser)
    {
        Connection con = null;
        DTOUser du = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select u.idUsuario,u.nombre,u.apellido,u.mailGlobant,u.idTipoUsuario,u.iniciales,u.idProyecto\n" +
                                "from Usuarios u join Tipos_usuario tu on u.idTipoUsuario=tu.idTipoUsuario join  Proyectos p on p.idProyecto=u.idProyecto\n" +
                                "where idUsuario = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUser);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String mailGlobant = rs.getNString("mailGlobant");
                int idTipoUsuario = rs.getInt("idTipoUsuario");
                String ini = rs.getNString("iniciales");
                int idProyecto = rs.getInt("idProyecto");
                
                du = new DTOUser(idUsuario,nombre,apellido,mailGlobant,idTipoUsuario,ini,idProyecto);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return du;  
    }
    
    public ArrayList<Proyectos> traerProyectos()
    {
        Connection con = null;
        ArrayList<Proyectos> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select * from Proyectos";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next())
            {
                int idProyecto = rs.getInt("idProyecto");
                String nombreProyecto = rs.getNString("nombreProyecto");
                
                Proyectos p = new Proyectos(idProyecto,nombreProyecto);
                
                lista.add(p);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return lista; 
    }
    
    public ArrayList<TiposUsuario> traerTiposUsuario()
    {
        Connection con = null;
        ArrayList<TiposUsuario> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select * from Tipos_usuario";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next())
            {
                int idTipoUsuario = rs.getInt("idTipoUsuario");
                String tipoUsuario = rs.getNString("tipoUsuario");
                
                TiposUsuario tp = new TiposUsuario(idTipoUsuario,tipoUsuario);
                
                lista.add(tp);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return lista; 
    }
    
    public boolean agregarUser(UsuariosDos u)
    {
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Usuarios (nombre,apellido,mailGlobant,clave,idTipoUsuario,iniciales,idProyecto)\n" +
                                "values (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, u.getNombre());
            ps.setNString(2, u.getApellido());
            ps.setNString(3, u.getMailGlobant());
            ps.setNString(4, u.getClave());
            ps.setInt(5, u.getIdTipoUsuario());
            ps.setNString(6, u.getIniciales());
            ps.setInt(7, u.getIdProyecto());
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        } 
        
        return true;
    }
    
    public boolean actualizarDatos(UsuariosTres u, int idUsuario)
    {
         Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Usuarios\n" +
                                "set nombre=?,\n" +
                                "	apellido=?,\n" +
                                "	mailGlobant=?,\n" +
                                "	idTipoUsuario=?,\n" +
                                "	iniciales=?,\n" +
                                "	idProyecto=?\n" +
                                "where idUsuario=?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, u.getNombre());
            ps.setNString(2, u.getApellido());
            ps.setNString(3, u.getMailGlobant());
            ps.setInt(4, u.getIdTipoUsuario());
            ps.setNString(5, u.getIniciales());
            ps.setInt(6, u.getIdProyecto());
            ps.setInt(7, idUsuario);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        } 
        
        return true;
    }
    
    public void eliminarUsuario(int idUsuario) 
    {
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Usuarios\n" +
                                "where idUsuario = ?	";
            
            PreparedStatement ps = con.prepareStatement(consulta);
    
            ps.setInt(1, idUsuario);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<PrioridadesFix> traerPrioridadesFix() 
    {
        Connection con = null;
        ArrayList<PrioridadesFix> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select * from Prioridades_fix";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next())
            {
                int idPrioridadFix= rs.getInt("idPrioridadFix");
                String prioridadFix = rs.getNString("prioridadFix");
                
                PrioridadesFix pf = new PrioridadesFix(idPrioridadFix,prioridadFix);
                
                lista.add(pf);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return lista; 
    }
    
    public ArrayList<Estados> traerEstados() 
    {
        Connection con = null;
        ArrayList<Estados> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select * from Estados";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next())
            {
                int idEstado = rs.getInt("idEstado");
                String estado = rs.getNString("estado");
                
                Estados e = new Estados(idEstado,estado);
                
                lista.add(e);
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return lista; 
    }
    
    public boolean insertarFix(FixesDos f)
    {
        Connection con = null;
        boolean control = false;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Fixes (tituloFix,linkTicket,idPrioridadFix,fecha,adminComment,idEstado,idSprint,bandera)\n" +
                                "values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, f.getTituloFix());
            ps.setString(2, f.getLinkTicket());
            ps.setInt(3,f.getIdPrioridadFix());
            ps.setNString(4,f.getFecha());
            ps.setNString(5,f.getAdminComment());
            ps.setInt(6,f.getIdEstado());
            ps.setInt(7, f.getIdSprint());
            ps.setBoolean(8,f.isBandera());
            
            ps.executeUpdate();
            
            control = true;
            
            ps.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return control;
    }
    
    public boolean insertarAdhoc(AdhocDos a) 
    {
        Connection con = null;
        boolean control = false;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Adhoc (tituloTicket,linkTicket,idEstado,idSprint,idEstadosAdhoc,bandera,fecha)\n" +
                                "values (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1,a.getTituloTicket());
            ps.setNString(2, a.getLinkTicket());
            ps.setInt(3, a.getIdEstado());
            ps.setInt(4, a.getIdSprint());
            ps.setInt(5, a.getIdEstadosAdhoc());
            ps.setBoolean(6, a.isBandera());
            ps.setNString(7, a.getFecha());
            
            ps.executeUpdate();
            
            control = true;
            
            ps.close();
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return control;
    }
    
    public void cambiarProyecto(int idProyecto, String iniciales) 
    {
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Usuarios\n" +
                                "set idProyecto = ?\n" +
                                "where iniciales = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idProyecto);
            ps.setNString(2, iniciales);
            
            ps.executeUpdate();
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    } 
    
    public ArrayList<DTOUsuariosProyecto> traerUsuariosProyecto(int idUsuario,int idProyecto)
    {
        Connection con = null;
        ArrayList<DTOUsuariosProyecto> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idUsuario,nombre,apellido,iniciales \n" +
                                "from Usuarios\n" +
                                "where idUsuario != ? and idProyecto = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUsuario);
            ps.setInt(2,idProyecto);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String iniciales = rs.getNString("iniciales");
                
                DTOUsuariosProyecto du = new DTOUsuariosProyecto(id,nombre,apellido,iniciales);
                
                lista.add(du);
                
            }
            
            rs.close();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<DTOAsignadosFix> traerListaAsignados(int idFix)
    {
        Connection con = null;
        ArrayList<DTOAsignadosFix> lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select uf.idUsuarioFix,u.nombre,u.apellido,u.iniciales \n" +
                                "from Usuarios_fixes uf join Usuarios u on uf.idUsuario=u.idUsuario \n" +
                                "where idFix=?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int id = rs.getInt("idUsuarioFix");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String iniciales = rs.getNString("iniciales");
                
                DTOAsignadosFix af = new DTOAsignadosFix(id,nombre,apellido,iniciales);
                
                lista.add(af);
                
            }
            
            rs.close();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public void eliminarAsignadoFix(int idUsuarioFix)
    {
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Usuarios_fixes\n" +
                                "where idUsuarioFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUsuarioFix);
            
            ps.executeUpdate();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public int traerIdFix(int idUsuarioFix)
    {
        Connection con = null;
        int idFix = 0;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idFix\n" +
                                "from Usuarios_fixes\n" +
                                "where idUsuarioFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idUsuarioFix);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                idFix = rs.getInt("idFix");
            }
            
            ps.executeUpdate();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return idFix;
    }
    
    public ArrayList<Sprints> traerlistaSprints()
    {
        Connection con = null;
        ArrayList<Sprints> lista = new ArrayList<>();   
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint,numeroSprint,versionBuild\n" +
                                "from Sprints";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next())
            {
                int idSprint = rs.getInt("idSprint");
                float numeroSprint = rs.getFloat("numeroSprint");
                String versionBuild = rs.getNString("versionBuild");
                
                Sprints s = new Sprints(idSprint,numeroSprint,versionBuild);
                
                lista.add(s);
            }
            
            rs.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }

        return lista;
    }
    
    public DTOFixesDos traerDatosFix(int idFix) 
    {
        Connection con = null;
        DTOFixesDos df = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select f.tituloFix,f.linkTicket,f.idPrioridadFix,f.fecha,f.adminComment,f.idEstado,f.idSprint,s.idProyecto\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String tituloFix = rs.getNString("tituloFix");
                String linkTicket = rs.getNString("linkTicket");
                int idPrioridadFix = rs.getInt("idPrioridadFix");
                Date fecha = rs.getDate("fecha");
                String adminComment = rs.getNString("adminComment");
                int idEstado = rs.getInt("idEstado");
                int idSprint = rs.getInt("idSprint");
                
                df = new DTOFixesDos(tituloFix,linkTicket,idPrioridadFix,fecha,adminComment,idEstado,idSprint);
                
            }
            
            rs.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return df;
    }
    
    public void actualizarFix(DTOFixesTres df, int idFix) 
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta="update Fixes\n" +
                            "set tituloFix = ?,\n" +
                            "	linkTicket = ?,\n" +
                            "	idPrioridadFix = ?,\n" +
                            "	fecha = ?,\n" +
                            "	adminComment = ?,\n" +
                            "	idEstado = ?,\n" +
                            "	idSprint = ?\n" +
                            "where idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1,df.getTituloFix());
            ps.setNString(2, df.getLinkTicket());
            ps.setInt(3, df.getIdPrioridadFix());
            ps.setNString(4, df.getFecha());
            ps.setNString(5, df.getAdminComment());
            ps.setInt(6, df.getIdEstado());
            ps.setInt(7,df.getIdSprint());
            ps.setInt(8, idFix);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarFix(int idFix)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Fixes\n" +
                                "where idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idFix);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public int traerIdPrint(int idFix) 
    {
        Connection con = null;
        int idSprint = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint\n" +
                                "from Fixes\n" +
                                "where idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                idSprint = rs.getInt("idSprint");
            }
            
            rs.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return idSprint;
    }
    
    public void asignarAdminAdhoc(int idAdhoc, int idUsuario)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Adhoc\n" +
                                "set idUsuario= ?\n" +
                                "where idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idUsuario);
            ps.setInt(2,idAdhoc);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

    }
    
    public void eliminarAsignadosAdhoc(int idAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Adhoc\n" +
                                "set idUsuario= null\n" +
                                "where idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idAdhoc);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public DTOAdhocDos traerDatosAdhoc(int idAdhoc)
    {
        DTOAdhocDos da= null;
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select tituloTicket,linkTicket,idEstado,idSprint,idEstadosAdhoc,fecha\n" +
                                "from Adhoc\n" +
                                "where idAdhoc= ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idAdhoc);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String tituloTicket = rs.getNString("tituloTicket");
                String linkTicket = rs.getNString("linkTicket");
                int idEstado = rs.getInt("idEstado");
                int idSprint = rs.getInt("idSprint");
                int idEstadosAdhoc = rs.getInt("idEstadosAdhoc");
                Date fecha = rs.getDate("fecha");
                
                da = new DTOAdhocDos(tituloTicket,linkTicket,idEstado,idSprint,idEstadosAdhoc,fecha);
            }
            
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return da;
    }
    
    public void actualizarAdhoc(DTOAdhocTres da, int idAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Adhoc\n" +
                                "set tituloTicket=?,\n" +
                                "	linkTicket=?,\n" +
                                "	idEstado=?,\n" +
                                "	idSprint=?,\n" +
                                "	idEstadosAdhoc=?,\n" +
                                "	fecha=?\n" +
                                "where idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, da.getTituloTicket());
            ps.setNString(2, da.getLinkTicket());
            ps.setInt(3, da.getIdEstado());
            ps.setInt(4, da.getIdSprint());
            ps.setInt(5, da.getIdEstadoAdhoc());
            ps.setNString(6, da.getFecha());
            ps.setInt(7,idAdhoc);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarAdhoc(int idAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Adhoc\n" +
                                "where idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idAdhoc);
            
            ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public int traerIdSprintAdhoc(int idAdhoc)
    {
       Connection con = null;
       int idSprint = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint\n" +
                                "from Adhoc\n" +
                                "where idAdhoc = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idAdhoc);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                idSprint = rs.getInt("idSprint");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        } 
        return idSprint;
    }
    
    public ArrayList<DTOUsuariosProyecto> traerTodosLosUsuarios(int idUsuario)
    {
        Connection con = null;
        ArrayList<DTOUsuariosProyecto> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idUsuario,nombre,apellido,iniciales \n" +
                                "from Usuarios\n" +
                                "where idUsuario != ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idUsuario);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String iniciales = rs.getNString("iniciales");
                
                DTOUsuariosProyecto du = new DTOUsuariosProyecto(id,nombre,apellido,iniciales);
                
                lista.add(du);
            }
            
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return lista;
    }
    
    public ArrayList<Asignados> traerAsignadosRequest(int idReq) 
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select iniciales\n" +
                                "from Usuarios u join Usuarios_requests ur on u.idUsuario = ur.idUsuario\n" +
                                "where idRequest = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idReq);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String iniciales = rs.getNString("iniciales");
                
                Asignados a = new Asignados(iniciales);
                
                lista.add(a);
            }

            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<DTOUsuariosProyecto> traerAsignadosReq(int idReq) 
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select u.idUsuario,u.nombre,u.apellido,u.iniciales\n" +
                                "from Usuarios u join Usuarios_requests ur on u.idUsuario = ur.idUsuario\n" +
                                "where idRequest = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idReq);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getNString("apellido");
                String iniciales = rs.getNString("iniciales");

                DTOUsuariosProyecto du = new DTOUsuariosProyecto(id,nombre,apellido,iniciales);
                
                lista.add(du);
            }

            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<PrioridadesReq> traerPrioridadesReq()
    {
        
        Connection con = null;
        ArrayList<PrioridadesReq> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select * from Prioridades_request";
   
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next())
            {
                int idPrioridadReq = rs.getInt("idPriorirdadRequest");
                String prioridadReq = rs.getNString("prioridadRequest");

                PrioridadesReq pr = new PrioridadesReq(idPrioridadReq,prioridadReq);
                
                lista.add(pr);
            }

            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public boolean crearNuevoReq(RequestDos r)
    {
        boolean control = false;
        
        Connection con = null;

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Requests(tituloRequest,linkTicket,fecha,hora,request,idEstado,idPrioridadRequest,bandera)\n" +
                                "values(?,?,?,?,?,?,?,?)";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1, r.getTituloReq());
            ps.setNString(2, r.getLinkTicket());
            ps.setNString(3, r.getFecha());
            ps.setNString(4, r.getHora());
            ps.setNString(5, r.getReq());
            ps.setInt(6, r.getIdEstado());
            ps.setInt(7, r.getIdPrioridad());
            ps.setBoolean(8, r.isBandera());
            
            ps.executeUpdate();
            
            control = true;
            
            ps.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        return control;
    }
    
    public ArrayList<Requests> traerRequestAdmin()
    {
        Connection con = null;
        ArrayList<Requests> lista = new ArrayList<>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select r.idRequest,tituloRequest,linkTicket,fecha,hora,request,prioridadRequest,estado\n" +
                                "from Requests r join Estados e on r.idEstado=e.idEstado join Prioridades_request pr on pr.idPriorirdadRequest=r.idPrioridadRequest";
   
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next())
            {
                int idReq = rs.getInt("idRequest");
                String tituloReq = rs.getNString("tituloRequest");
                String linkTicket = rs.getNString("linkTicket");
                String prioridadReq= rs.getNString("prioridadRequest");
                String estado= rs.getNString("estado");
                Date fecha = rs.getDate("fecha");
                
                Requests r = new Requests (idReq,tituloReq,linkTicket,prioridadReq,estado,fecha);
                
                lista.add(r);
            }
            
            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
        return lista;
    }
    
    public RequestTres traerDatosRequest(int idReq)
    {
        Connection con = null;
        RequestTres r = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idRequest,tituloRequest,linkTicket,fecha,hora,request,idPrioridadRequest,idEstado\n" +
                                "from Requests\n" +
                                "where idRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idReq);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                String tituloReq = rs.getNString("tituloRequest");
                String linkTicket = rs.getNString("linkTicket");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                String req = rs.getNString("request");
                int idPrioridadRequest = rs.getInt("idPrioridadRequest");
                int idEstado = rs.getInt("idEstado");
                
                r = new RequestTres(tituloReq,linkTicket,fecha,hora,req,idPrioridadRequest,idEstado);
                
            }
            
            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
        return r;
    }
    
    public void actualizarDatosRequest(int idReq, DTOReqDos r)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Requests\n" +
                                "set tituloRequest=?,\n" +
                                "	linkTicket=?,\n" +
                                "	fecha=?,\n" +
                                "	hora=?,\n" +
                                "	request=?,\n" +
                                "	idPrioridadRequest=?,\n" +
                                "	idEstado=?\n" +
                                "where idRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setNString(1,r.getTituloReq());
            ps.setNString(2,r.getLinkTicket());
            ps.setNString(3,r.getFecha());
            ps.setNString(4,r.getHora());
            ps.setNString(5,r.getReq());
            ps.setInt(6,r.getIdPrioridad());
            ps.setInt(7,r.getIdEstado());
            ps.setInt(8,idReq);
            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public void eliminarReq(int idReq)
    {
       Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Requests\n" +
                                "where idRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idReq);
            
            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }  
    }
    
    public void asignarUsuariosRequest(int idReq, int idUsuario) 
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert into Usuarios_requests(idRequest,idUsuario)\n" +
                                "values(?,?)";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idReq);
            ps.setInt(2,idUsuario);
            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarAsigadosReq(int idReq,int idUser)
    {
       Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Usuarios_requests\n" +
                                "where idRequest=? and idUsuario = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idReq);
            ps.setInt(2,idUser);
            
            ps.executeUpdate();
            
            ps.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }  
    }
    
    public void eliminarRespuesta(int idRespReq) 
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Responses_request\n" +
                                "where idResponseRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idRespReq);

            
            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }  
    }
    
    public void cambiarEstado(int id)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Requests\n" +
                                "set idEstado = 2\n" +
                                "where idRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,id);

            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public void cambiarEstadoDone(int id)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Requests\n" +
                                "set idEstado = 3\n" +
                                "where idRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,id);

            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public void cambiarEstadoDoneFix(int id)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Fixes\n" +
                                "set idEstado = 3\n" +
                                "where idFix = ? ";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,id);

            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public int traerIdEstado (int id) 
    {
        Connection con = null;
        int idEstado = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idEstado\n" +
                                "from Requests\n" +
                                "where idRequest = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {
                idEstado = rs.getInt("idEstado");
            }
            
            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
        return idEstado;
    }
    
    public void eliminarRespuestaFix(int idRespFix)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete Responses_fix\n" +
                                "where idResponsesFix = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idRespFix);

            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void cambiarEstadoFix(int id)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Fixes\n" +
                                "set idEstado = 2\n" +
                                "where idFix = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,id);

            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public int traerIdEstadoFix (int id) 
    {
        Connection con = null;
        int idEstado = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idEstado\n" +
                                "from Fixes\n" +
                                "where idFix = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {
                idEstado = rs.getInt("idEstado");
            }
            
            rs.close();
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
        return idEstado;
    }
    
    public void eliminarRespuestaAdhoc(int idRespAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "delete RespuestasAdhoc\n" +
                                "where idRespuestaAdhoc = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idRespAdhoc);

            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarAsignadoAdhoc(int idAdhoc)
    {
        Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "update Adhoc\n" +
                                "set idUsuario = null\n" +
                                "where idAdhoc = ?";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1,idAdhoc);

            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean insertarNuevoSprint(int idProyecto,float numeroSprint, String versionBuild)
    {
         Connection con = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "insert Sprints(numeroSprint,versionBuild,idProyecto)\n" +
                                "values(?,?,?)";
   
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setFloat(1, numeroSprint);
            ps.setNString(2, versionBuild) ;
            ps.setInt(3, idProyecto);

            
            ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return true;
    }
    
    //Wyplay - Adhoc
    
    public int cantidadTotalWyplayAd()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where s.idProyecto=1";
   
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
        
    }
    
    public int cantidadNotRunWyplay()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 1 and s.idProyecto = 1";
   
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
        
    }
    
    public int cantidadPassWyplay()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 2 and s.idProyecto = 1";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    public int cantidadFailWyplay()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 3 and s.idProyecto = 1";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    //Legacy HD - Adhoc
    
    public int cantidadTotalLegHDAd()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where s.idProyecto=2";
   
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
        
    }
    
    public int cantidadNotRunLegHD()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 1 and s.idProyecto = 2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    public int cantidadPassLegHD()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 2 and s.idProyecto = 2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    public int cantidadFailLegHD()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 3 and s.idProyecto = 2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    //LegacySD - Adhoc
    public int cantidadTotalLegSDAd()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where s.idProyecto=3";
   
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
        
    }
    
    public int cantidadNotRunLegSD()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 1 and s.idProyecto = 3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    public int cantidadPassLegSD()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 2 and s.idProyecto = 3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    public int cantidadFailLegSD()
    {
        Connection con = null;
        int cantidadTotal = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Adhoc a join Sprints s on a.idSprint=s.idSprint\n" +
                                "where a.idEstadosAdhoc = 3 and s.idProyecto = 3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidadTotal = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidadTotal;
    }
    
    //Wyplay - Fix
    /*
    public int cantidadTotalWyplay()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=1";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadToDoWyplay()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=1 and idEstado = 1";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadInProgressWyplay()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=1 and idEstado = 2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadDoneWyplay()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=1 and idEstado = 3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    //Legacy HD - Fix
    
    public int cantidadTotalLegHD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
     
    public int cantidadToDoLegHD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=2 and idEstado = 1";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    } 
    
    public int cantidadInProgressLegHD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=3 and idEstado = 2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadDoneLegHD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=2 and idEstado = 3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    //Legacy SD - Fix
    
    public int cantidadTotalLegSD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) as cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadToDoLegSD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=3 and idEstado = 1";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    } 
    
    public int cantidadInProgressLegSD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=3 and idEstado = 2";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadDoneLegSD()
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select count(*) cantidad\n" +
                                "from Fixes f join Sprints s on f.idSprint=s.idSprint\n" +
                                "where s.idProyecto=3 and idEstado = 3";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            
            while (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    */
    //ELIMINAR REQUEST
    
    public ArrayList<Integer> buscarIdAsignadoReq(int idReq)
    {
        Connection con = null;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT idUsuario\n" +
                                "FROM Usuarios_requests\n" +
                                "WHERE idRequest = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idReq);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int idUsuario = rs.getInt("idUsuario");
                
                lista.add(idUsuario);
            }
            
            rs.close();
            ps.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<Integer> buscarIdRespuestaReq(int idReq)
    {
        Connection con = null;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT idResponseRequest\n" +
                                "FROM Responses_request\n" +
                                "WHERE idRequest = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idReq);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int idUsuario = rs.getInt("idResponseRequest");
                
                lista.add(idUsuario);
            }
            
            rs.close();
            ps.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    //ELIMINAR FIX
    
    public ArrayList<Integer> buscarIdAsignadoFix(int idFix)
    {
        Connection con = null;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT idUsuario\n" +
                                "FROM Usuarios_fixes\n" +
                                "WHERE idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int idUsuario = rs.getInt("idUsuario");
                
                lista.add(idUsuario);
            }
            
            rs.close();
            ps.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<Integer> buscarIdRespuestaFix(int idFix)
    {
        Connection con = null;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT idResponsesFix \n" +
                                "FROM Responses_fix\n" +
                                "WHERE idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int idUsuario = rs.getInt("idResponsesFix");
                
                lista.add(idUsuario);
            }
            
            rs.close();
            ps.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public void eliminarAsignadoFix2(int idFix)
    {
        Connection con = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "DELETE Usuarios_fixes\n" +
                                "WHERE idFix = ?";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idFix);
            
            ps.executeUpdate();
            
            ps.close();
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
    }
    
    public ArrayList<Sprints> traerSprintsWy()
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint,numeroSprint,versionBuild\n" +
                                "from Sprints\n" +
                                "where idProyecto = 1";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next())
            {
                int idSprint = rs.getInt("idSprint");
                float numeroSprint = rs.getFloat("numeroSprint");
                String versionBuild = rs.getNString("versionBuild");
                
                Sprints sp = new Sprints(idSprint,numeroSprint,versionBuild);
                
                lista.add(sp);
            }
            
            rs.close();
            st.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con!=null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<Sprints> traerSprintsLegHD()
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint,numeroSprint,versionBuild\n" +
                                "from Sprints\n" +
                                "where idProyecto = 2";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next())
            {
                int idSprint = rs.getInt("idSprint");
                float numeroSprint = rs.getFloat("numeroSprint");
                String versionBuild = rs.getNString("versionBuild");
                
                Sprints sp = new Sprints(idSprint,numeroSprint,versionBuild);
                
                lista.add(sp);
            }
            
            rs.close();
            st.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con!=null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    public ArrayList<Sprints> traerSprintsLegSD()
    {
        Connection con = null;
        ArrayList lista = new ArrayList<>();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "select idSprint,numeroSprint,versionBuild\n" +
                                "from Sprints\n" +
                                "where idProyecto = 3";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next())
            {
                int idSprint = rs.getInt("idSprint");
                float numeroSprint = rs.getFloat("numeroSprint");
                String versionBuild = rs.getNString("versionBuild");
                
                Sprints sp = new Sprints(idSprint,numeroSprint,versionBuild);
                
                lista.add(sp);
            }
            
            rs.close();
            st.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con!=null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }
    
    //ADHOC
    
    //WYPLAY
    
    public int cantidadTotalWyplay(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadNotRunWyplay(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint =?  and idEstadoAdhoc = 1";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadPassWyplay(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint =?  and idEstadoAdhoc = 2";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadFailWyplay(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint =?  and idEstadoAdhoc = 3";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    //LEGACY HD
    
    public int cantidadTotalLegacyHD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadNotRunLegacyHD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?  and idEstadoAdhoc = 1";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadPassLegacyHD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?  and idEstadoAdhoc = 2";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadFailLegacyHD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?  and idEstadoAdhoc = 3";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    //LEGACY SD
    
    public int cantidadTotalLegacySD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadNotRunLegacySD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?  and idEstadoAdhoc = 1";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadPassLegacySD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?  and idEstadoAdhoc = 2";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadFailLegacySD(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Adhoc a JOIN Estados_adhoc ea ON a.idEstadosAdhoc = ea.idEstadoAdhoc\n" +
                                "WHERE idSprint = ?  and idEstadoAdhoc = 3";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    //FIXES
    
    public int cantidadTotalFix(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Fixes\n" +
                                "WHERE idSprint = ?";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadToDoFix(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Fixes\n" +
                                "WHERE idSprint = ? and idEstado = 1";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadInProgressFix(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Fixes\n" +
                                "WHERE idSprint = ? and idEstado = 2";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
    
    public int cantidadDoneFix(int idSprint)
    {
        Connection con = null;
        int cantidad = 0;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(cadena,user,pass);
            
            String consulta = "SELECT COUNT(*) AS cantidad\n" +
                                "FROM Fixes\n" +
                                "WHERE idSprint = ? and idEstado = 3";

            PreparedStatement ps = con.prepareStatement(consulta);
            
            ps.setInt(1, idSprint);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next())
            {
                cantidad = rs.getInt("cantidad");
            }
            
            rs.close();
            ps.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if(con != null && !con.isClosed())
                {
                    con.close();
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
        return cantidad;
    }
}

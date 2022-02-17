<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

        <script src="https://kit.fontawesome.com/cccf91c3da.js" crossorigin="anonymous"></script>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <link rel="stylesheet" href="css/estilos.css"/>

        <title>DIRECTV'S TaskManager - Users</title>
    </head>
    <body>
        <%if(session.getAttribute("user") != null && session.getAttribute("permiso").equals(1)) {%>
        <nav class="header navbar navbar-expand-sm navbar-light bg-light">
            <div class="container ">
                <a class="navbar-brand" href="#"><img src="images/dtvTaskMan.png" alt="DIRECTV'S TaskManager" width="200"></a>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link mx-2 headlinks">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="servRequest" class="nav-link mx-2 headlinks">Requests</a>
                    </li>
                    <li class="nav-item">
                        <a href="servFix" class="nav-link mx-2 headlinks">Fix Verification</a>
                    </li>
                    <li class="nav-item">
                        <a href="servAdhoc" class="nav-link mx-2 headlinks">ADHOC</a>
                    </li>
                    <li class="nav-item">
                        <a href="servUsers" class="nav-link mx-2 headlinks">Users</a>
                    </li>
                    <li class="nav-item">
                        <a href="servSprints" class="nav-link mx-2 headlinks">Sprints</a>
                    </li>
                    <li class="nav-item">
                        <a href="servReportes" class="nav-link mx-2 headlinks">Reports</a>
                    </li>
                </ul>
                <form class="form-inline mt-3">
                    <input class="form-control-sm" type="text" placeholder="Buscar">
                    <button class="btn btn-outline-info btn-sm">Buscar</button>
                </form>
                <div class="float-lg-right mt-1 circulo dropdown">
                    <h4 class="align-middle mx-2 my-2">
                        <a href="#" class="sesion" data-toggle="dropdown">${user}</a>
                        <div class="dropdown-menu">
                            <a href="servMyAccount" class="dropdown-item">My account</a>
                            <a href="servLogin?control=a" class="dropdown-item">Log out</a>
                        </div>
                    </h4>
                </div>
            </div>
        </nav>
        
        <div class="container cuerpo">
            <div class="row">
               <div class="card col-lg-5 mt-5 mx-auto">
                   <h2 class="text-center mt-3">Create a new user</h2>
                   <form action="servAgregarUser" method="post" class="mb-3">
                       <div class="form-group">
                            <label>Name:</label>
                            <input  class="form-control" type="text" name="txtNombre" required>
                       </div>
                       <div class="form-group">
                            <label>Last name:</label>
                            <input  class="form-control" type="text" name="txtApellido" required>
                       </div>
                       <div class="form-group">
                            <label>E-mail:</label>
                            <input  class="form-control" type="email" name="txtMail" required>
                       </div>
                       <div class="form-group">
                            <label>Password:</label>
                            <input  class="form-control" type="password" name="txtPass" required>
                       </div>
                       <div class="form-group">
                            <label>User's privilege:</label>
                            <select class="form-control" name="cboTipoUser" required >
                                <c:forEach var="ltu" items="${listaTU}">
                                    <option value="${ltu.idTipoUsuario}">${ltu.tipoUsuario}</option>
                                </c:forEach>
                            </select>
                       </div>
                       <div class="form-group">
                            <label>Initials: </label>
                            <input  class="form-control" type="text" name="txtIniciales" required>
                       </div>
                       <div class="form-group">
                            <label>Asign a project:</label>
                            <select class="form-control" name="cboProyecto" required>
                                <c:forEach var="lp" items="${listaProyectos}">
                                    <option value="${lp.idProyecto}">${lp.nombreProyecto}</option>
                                </c:forEach>
                            </select>
                       </div>
                        <button type="submit" class="btn btn-primary form-control">Create</button>
                        <%if (request.getAttribute("mensajeExito") != null && !request.getAttribute("mensajeExito").equals(""))
                        {
                        %>
                        <p>${mensajeExito}</p>
                        
                        <% } else if(request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals(""))
                        
                        { 

                        %>
                        <p>${mensajeError}</p>
                        <% 
                            
                        }

                        %>  
                    </form>
               </div>
           </div>
        </div>
                <%
                    }
                %>

        <footer>
                <div class="row bg-dark justify-content-center">
                    <h2 class="text-white">Links of Interests</h2>
                </div>
            <div class="container">
                <div class="row">
                    <!--links UAT -->
                    <ul class="col-4 list-unstyled text-center mt-4">
                        <li class="font-weight-bold text-uppercase">UAT</li>
                        <li><a href="#" class="linkFoot">Enter daily worklog</a></li>
                        <li><a href="#" class="linkFoot">Worklog entries</a></li>
                        <li><a href="#" class="linkFoot">Mariano/José asignments</a></li>
                        <li><a href="#" class="linkFoot">Daily meetings</a></li>
                    </ul>
                    <!--links SPIRA -->
                    <ul class="col-4 list-unstyled text-center mt-4" >
                        <li class="font-weight-bold text-uppercase">SPIRA</li>
                        <li><a href="#" class="linkFoot">Sitio de Spira</a></li>
                    </ul>
                    <!--links JIRA -->
                    <ul class="col-4 list-unstyled text-center mt-4">
                        <li class="font-weight-bold text-uppercase" >JIRA</li>
                        <li><a href="#" class="linkFoot">Jira OTT</a></li>
                        <li><a href="#" class="linkFoot">Jira DTVLA</a></li>
                    </ul>
                </div>
            </div>
            <div class="row justify-content-center bg-dark">
                    <p class="lead text-white">
                        Created By Loomie Soft &COPY; - <i>All Rights reserved</i>
                    </p>
                </div>
        </footer>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
        <script src="js/main.js"></script>
    </body>
</html>
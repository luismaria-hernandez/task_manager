
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

        <link rel="stylesheet" href="css/estilos.css">
        <script src="https://kit.fontawesome.com/cccf91c3da.js" crossorigin="anonymous"></script>

        <title>DIRECTV'S TaskManager - ADHOC</title>
    </head>
    <body>
        <%if (session.getAttribute("user") != null && session.getAttribute("permiso").equals(2)) { %>
        <nav class=" header navbar navbar-expand-sm navbar-light bg-light">
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
                <div class="col-sm-3 col-md-11 col-lg-11 mx-auto card mt-3" >
                    <h2 class="card-title mt-3 border-bottom border-dark">${tituloTicket}</h2>
                    <ul>
                        <li class="mt-4"><b>Ticket: </b><a href="${linkTicket}">${linkTicket}</a></li>
                        <li class="mt-4"><b>Status:</b> <div class="tag bg-warning">${estado}</div></li>
                        <li class="mt-4"><b>Adhoc's Status:</b> <div class="tag bg-warning">${estadoAdhoc}</div></li>
                        <li class="mt-4"><b>Assignee: </b><%if (request.getAttribute("valor") != null && request.getAttribute("valor").equals("b")){%><a href="servAsignar?con=${idAdhoc}">Assign to me</a><% } else { %>${separadoPorComa} - <a href="servEditarAsignadosAdhoc?id=${idAdhoc}">Edit</a><%}%></li>
                    </ul>
                </div>
            </div>
                
            <div class="row ">
                <div class="col-sm-6 col-md-4 col-lg-4 card mt-3 mb-3 mx-auto ">
                    <h4 class="mt-3 card-title">Create a comment</h4>
                    
                    <form method="post">
                        <input type="hidden" value="${idAdhoc}" name="txtIdAdhoc">
                        <div class="form-group">
                            <label>Adhoc's Status:</label>
                            <select name="cboEstadoAdhoc" class="form-control" id="selOpcion">
                                <option value="">Select</option>
                                <c:forEach var="lea" items="${listaEA}">
                                    <option value="${lea.idEstadoAdhoc}">${lea.estadoAdhoc}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="mt-3">Comment:</label>
                            <br>
                            <textarea class="mt-3 form-control form-control-sm" id="txtRespuesta" rows="5" name="txtComment"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary form-control form-control-sm" onclick="return validarForm()">Send</button>
                    </form>
                </div>
                <div class="card col-sm-6 col-md-6 col-lg-6 mx-auto mt-3 mb-3">
                    
                    <h4 class="card-title mt-3">Comments</h4>
                    
                    <% if(request.getAttribute("listaComment") != null && !request.getAttribute("listaComment").equals("")) 
                        {    
                    %>
                        <c:forEach var="lc" items="${listaComment}">

                            <p>${lc.comment}  - <a href="servEliminarRespAdhoc?id=${lc.idRespAdhoc}&idAdhoc=${idAdhoc}" onclick="return eliminarComentario()"><i class="far fa-trash-alt"></i></a></p>

                        </c:forEach>    
                    <% 
                        } else { 
                        
                    %>

                         <h5 class="mx-auto mt-5 text-muted">No comments yet :(</h5>
                    
                    <%
                        }
                    %>     
                </div>
            </div>
        </div>
        <%} else if (session.getAttribute("user") != null && session.getAttribute("permiso").equals(1)){%>
        <nav class=" header navbar navbar-expand-sm navbar-light bg-light">
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
                <div class="col-sm-3 col-md-11 col-lg-11 mx-auto card mt-3" >
                    <h2 class="card-title mt-3 border-bottom border-dark">${tituloTicket}</h2>
                    <ul>
                        <li class="mt-4"><b>Ticket:</b> <a href="${linkTicket}">${linkTicket}</a></li>
                        <li class="mt-4"><b>Status:</b> <div class="tag bg-warning">${estado}</div></li>
                        <li class="mt-4"><b>Adhoc's Status:</b> <div class="tag bg-warning">${estadoAdhoc}</div></li>
                        <%if (request.getAttribute("valor") != null && request.getAttribute("valor").equals("b")) {%>
                        <li class="mt-4"><b>Assign to: </b>
                            <form class="form-inline" action="servAsignarAdhoc" method="get">
                                <div class="form-group">
                                    <input type="hidden" value="${idAdhoc}" name="idAdhoc">
                                    <select name="cboUsuarios" class="form-control-sm">
                                        <c:forEach  var="lu" items="${listaUsuarios}">
                                            <option value="${lu.idUsuario}">${lu.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary form-control-sm ml-3">Assign</button>
                            </form>
                        </li>
                        <% }else{%> <%}%>
                        <li class="mt-4"><b>Assignee:</b><%if (request.getAttribute("valor") != null && request.getAttribute("valor").equals("a")) {%> ${separadoPorComa} - <a href="servEliminarAsignadosAdhoc?id=${idAdhoc}" onclick="return confirmarDeleteAsignado()">Delete</a><%} else {%><p class="text text-muted">Not assigned</p><%}%></li>
                    </ul>
                </div>
            </div>
                
            <div class="row ">
                <div class="card col-sm-3 col-md-11 col-lg-11 mx-auto card mt-3">
                    
                    <h4 class="card-title mt-3">Comments</h4>
                    
                    <% if(request.getAttribute("listaComment") != null && !request.getAttribute("listaComment").equals("")) 
                        {    
                    %>
                        <c:forEach var="lc" items="${listaComment}">

                            <p>${lc.comment}</p>

                        </c:forEach>    
                    <% 
                        } else { 
                        
                    %>

                         <h5 class="mx-auto text-muted mt-5 mb-5">No comments yet :(</h5>
                    
                    <%
                        }
                    %>     
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

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

        <title>DIRECTV'S TaskManager - Fix Verification</title>
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
                    <h2 class="card-title mt-3 border-bottom border-dark">${tituloFix}</h2>
                    <ul>
                        <li class="mt-4"><b>Ticket: </b><a href="${linkTicket}">${linkTicket}</a></li>
                        <li class="mt-4"><b>Priority: </b> <div class="tag bg-warning">${prioridad}</div>
                        <li class="mt-4"><b>Status: </b><div class="tag bg-warning">${estado}</div></li>
                        <li class="mt-4"><b>Admin Comment: </b> ${adminComment}</li>
                        <li class="mt-4"><b>Assignee: </b>${separadoPorComa} <%if (request.getAttribute("valor") != null && request.getAttribute("valor").equals("b")){%><a href="servAsignar?control=${idFix}">Assign to me</a><% } else { %> <%}%></li>
                    </ul>
                </div>
            </div>
                
            <div class="row ">
                <div class="col-sm-6 col-md-4 col-lg-4 card mt-3 mb-3 mx-auto ">
                    <h4 class="mt-3 card-title">Response tool</h4>
                    <!--Aquí empieza el form-->   
                    <input type="hidden" value="${user}" id="userSession">
                        <div class="form-group">
                            <label class="mt-3">Reproducibility:</label>
                            <select id="cboRepro" class="form-control form-control-sm" onchange="activarOpciones()">
                                <option value="">Select</option>
                                <option value="Always">Always</option>
                                <option value="Intermittent">Intermittent</option>
                                <option value="Intermittent/Happened once">Intermittent/Happened once</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="mt-3">Resolution:</label>
                            <select id="cboResol" class="form-control form-control-sm">
                                <option value="">Select</option>
                                <option value="PASS" id="pass">PASS</option>
                                <option value="FAIL">FAIL</option>
                                <option value="Unable to reproduce" id="utr">Unable to reproduce</option>
                                <option value="BLOCKED">BLOCKED</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="mt-3">STBs</label>
                            <select id="cboStbs" class="form-control form-control-sm">
                                <option value="">Select</option>
                                <option value="2 LHR22 & 2 LHR26">2 LHR22 & 2 LHR26</option>
                                <option value="1 LHR22 & 1 LHR26">1 LHR22 & 1 LHR26</option>
                                <option value="1 LHR22">1 LHR22</option>
                                <option value="1 LHR26">1 LHR26</option>
                                <option value="2 LHR22">2 LHR22</option>
                                <option value="2 LHR26">2 LHR26</option>
                                <option value="2 LH26 & 2 LH27">2 LH26 & 2 LH27</option>
                                <option value="1 LH26 & 1 LH27">1 LH26 & 1 LH27</option>
                                <option value="1 LH26">1 LH26</option>
                                <option value="1 LH27">1 LH27</option>
                                <option value="2 LH26">2 LH26</option>
                                <option value="2 LH27">2 LH27</option>
                                <option value="2 LH10 & 2 LH01">2 LH10 & 2 LH01</option>
                                <option value="1 LH10 & 1 LH01">1 LH10 & 1 LH01</option>
                                <option value="1 LH10">1 LH10</option>
                                <option value="1 LH01">1 LH01</option>
                                <option value="2 LH10">2 LH10</option>
                                <option value="2 LH01">2 LH01</option>
                                <option value="2 LKR01">2 LKR01</option>
                                <option value="2 LHR01">2 LHR01</option>
                                <option value="1 LKR01">1 LKR01</option>
                                <option value="1 LHR01">1 LHR01</option>
                                <option value="2 LKR01 & 2 LHR01">2 LKR01 & 2 LHR01</option>
                                <option value="1 LKR01 & 1 LHR01">1 LKR01 & 1 LHR01</option>
                            </select>
                        </div> 
                        <div class="form-group">
                            <label class="mt-3">Version:</label>
                            <select id="cboVersion" class="form-control form-control-sm">
                                <option value="">Select</option>
                                <option value="v7823">v7823</option>
                                <option value="v7824">v7824</option>
                                <option value="v7825">v7824</option>
                                <option value="v7826">v7825</option>
                                <option value="v7828">v7825</option>
                                <option value="v7829">v7825</option>
                                <option value="v40EE">v40EE</option>
                                <option value="v40E2">v40E2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <p class="mt-3">Issue reproduced</p>
                            <select id="cboTimes" class="form-control form-control-sm">
                                <option value="">Select</option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                            <p class="mt-3">times out of</p>
                            <select id="cboTimesDos" class="form-control form-control-sm">
                                <option value="">Select</option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="mt-3">Aditional comment (Optional):</label>
                            <br>
                            <textarea class="mt-3 form-control form-control-sm" id="txtMsg" rows="5"></textarea>
                        </div>  
                        <button class="btn btn-info form-control form-control-sm" onclick="generateComment()">Generate comment</button>
                        <div class="border-bottom mt-3"></div>
                   
                    
                    <form method="post">
                        <input type="hidden" value="${idFix}" name="txtIdFix">
                        <div class="form-group">
                            <label class="mt-3">Generated comment:</label>
                            <br>
                            <textarea class="mt-3 form-control form-control-sm" id="txtRespuesta" rows="5" name="txtRespuesta" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary form-control form-control-sm" onclick="return sendAlert()">Send</button>
                    </form>
                </div>
                <div class="card col-sm-6 col-md-6 col-lg-6 mx-auto mt-3 mb-3">
                    
                    <h4 class="card-title mt-3">Responses</h4>
                    
                    <% if(request.getAttribute("listaRespuestas") != null && !request.getAttribute("listaRespuestas").equals("")) 
                        {    
                    %>
                        <c:forEach var="lr" items="${listaRespuestas}">

                            <p>${lr.respFix} - <a href="servEliminarRespFix?id=${lr.idRespFix}&idFix=${idFix}" onclick="return eliminarComentario()"><i class="far fa-trash-alt"></i></a></p>

                        </c:forEach>    
                    <% 
                        } else { 
                        
                    %>

                         <h5 class="mx-auto mt-5 text-muted">No responses yet :(</h5>
                    
                    <%
                        }
                    %>     
                </div>
            </div>
        </div>
        <% } else if (session.getAttribute("user") != null && session.getAttribute("permiso").equals(1)) { %>
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
                    <h2 class="card-title mt-3 border-bottom border-dark">${tituloFix}</h2>
                    <ul>
                        <li class="mt-4"><b>Ticket: </b><a href="${linkTicket}">${linkTicket}</a></li>
                        <li class="mt-4"><b>Priority: </b> <div class="tag bg-warning">${prioridad}</div></label>
                        <li class="mt-4"><b>Status: </b><div class="tag bg-warning">${estado}</div></li>
                        <li class="mt-4"><b>Admin Comment: </b> ${adminComment}</li>
                        <li class="mt-4"><b>Assign to: </b>
                            <form class="form-inline" action="servAsignar" method="get">
                                <div class="form-group">
                                    <input type="hidden" value="${idFix}" name="idFix">
                                    <select name="cboUsuarios" class="form-control-sm">
                                        <c:forEach  var="lu" items="${listaUsuarios}">
                                            <option value="${lu.idUsuario}">${lu.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary form-control-sm ml-3">Assign</button>
                            </form>
                        </li>
                        <li class="mt-4"><b>Assignee:</b><%if (request.getAttribute("valor") != null && request.getAttribute("valor").equals("b")) {%> ${separadoPorComa} - <a href="servEditarAsignados?id=${idFix}">Edit</a><%} else {%><p class="text text-muted">Not assigned</p><%}%></li>
                        <a href="servDone?idFix=${idFix}" class="btn btn-info float-right" onclick="return terminarTarea()"><b>DONE</b></a>
                    </ul>
                </div>
            </div>
                
            <div class="row ">
                <div class="col-sm-3 col-md-11 col-lg-11 mx-auto card mt-3 ">
                    
                    <h4 class="card-title mt-3">Responses</h4>
                    
                    <% if(request.getAttribute("listaRespuestas") != null && !request.getAttribute("listaRespuestas").equals("")) 
                        {    
                    %>
                        <c:forEach var="lr" items="${listaRespuestas}">

                            <p>${lr.respFix}</p>

                        </c:forEach>    
                    <% 
                        } else { 
                        
                    %>

                         <h5 class="mx-auto text-muted mt-5 mb-5">No responses yet :(</h5>
                    
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
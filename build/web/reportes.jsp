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

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        
        <link rel="stylesheet" href="css/estilos.css"/>
        <link rel="stylesheet" href="morris/morris.css">
        <script src="morris/morris.min.js"></script>

        <title>DIRECTV'S TaskManager - Reports</title>
    </head>
    <body>
        <% if(session.getAttribute("user") != null && session.getAttribute("permiso").equals(1)) {%>
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
                <div class="bg-dark text-white container-fluid"><h2 class="text-center p-3">ADHOC Reports</h2></div>
                <div class="col-lg-10 mx-auto my-5">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Wyplay</h2>
                            <form class="form-inline float-right">
                                <div class="form-group">
                                    <label>Sprints: </label>
                                    <select class="form-control mx-2" id="selOpcion1" name="cboSprintsWy">
                                        <option value="">Select</option>
                                        <c:forEach items="${sprintsWy}" var="sw">
                                            <option value="${sw.idSprint}"<c:if test="${sw.idSprint == idSprintWy}">selected</c:if>>${sw.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="return validarSprintsWy()">Buscar</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <ul>
                                <li><b>Total cases: </b>: ${cantidadTotalWy} </li>
                            </ul>
                            <div id="adhocwy" style="height: 250px;">
                                <!--Wyplay-->
                                <input type="hidden" value="${cantidadNotRunWy}" id="NotRunWy">
                                <input type="hidden" value="${cantidadPassWy}" id="PassWy">
                                <input type="hidden" value="${cantidadFailWy}" id="FailWy">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 mx-auto my-5">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Legacy HD</h2>
                            <form class="form-inline float-right">
                                <div class="form-group">
                                    <label>Sprints: </label>
                                    <select class="form-control mx-2" id="selOpcion2" name="cboSprintsLegHD">
                                        <option value="">Select</option>
                                        <c:forEach items="${sprintsLegHD}" var="slh">
                                            <option value="${slh.idSprint}"<c:if test="${slh.idSprint == idSprintLegHD}">selected</c:if>>${slh.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="return validarSprintsLegHD()">Buscar</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <ul>
                                <li><b>Total cases: </b>: ${cantidadTotalLegHD} </li>
                            </ul>
                            <div id="adhocleghd" style="height: 250px;">
                                <!--Wyplay-->
                                <input type="hidden" value="${cantidadNotRunLegHD}" id="NotRunLegHD">
                                <input type="hidden" value="${cantidadPassLegHD}" id="PassLegHD">
                                <input type="hidden" value="${cantidadFailLegHD}" id="FailLegHD">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 mx-auto my-5">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Legacy SD</h2>
                            <form class="form-inline float-right">
                                <div class="form-group">
                                    <label>Sprints: </label>
                                    <select class="form-control mx-2" id="selOpcion3" name="cboSprintsLegSD">
                                        <option value="">Select</option>
                                        <c:forEach items="${sprintsLegSD}" var="ssd">
                                            <option value="${ssd.idSprint}"<c:if test="${ssd.idSprint == idSprintLegSD}">selected</c:if>>${ssd.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="return validarSprintsLegSD()" >Buscar</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <ul>
                                <li><b>Total cases: </b>: ${cantidadTotalLegSD} </li>
                            </ul>
                            <div id="adhoclegsd" style="height: 250px;">
                                <!--Wyplay-->
                                <input type="hidden" value="${cantidadNotRunLegSD}" id="NotRunLegSD">
                                <input type="hidden" value="${cantidadPassLegSD}" id="PassLegSD">
                                <input type="hidden" value="${cantidadFailLegSD}" id="FailLegSD">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="bg-dark text-white container-fluid"><h2 class="text-center p-3">Fix verification Reports</h2></div>
                <div class="col-lg-10 mx-auto my-5">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Wyplay</h2>
                            <form class="form-inline float-right">
                                <div class="form-group">
                                    <label>Sprints: </label>
                                    <select class="form-control mx-2" id="selOpcion4" name="cboSprintsWy1">
                                        <option value="">Select</option>
                                        <c:forEach items="${sprintsWy}" var="sw">
                                            <option value="${sw.idSprint}"<c:if test="${sw.idSprint == idSprintWy1}">selected</c:if>>${sw.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="return validarSprintsWy1()">Buscar</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <ul>
                                <li><b>Total cases: </b>: ${cantidadTotalFixWy} </li>
                            </ul>
                            <div id="fixwy" style="height: 250px;">
                                <!--Wyplay-->
                                <input type="hidden" value="${cantidadToDoFixWy}" id="ToDoFixWy">
                                <input type="hidden" value="${cantidadInProgressFixWy}" id="InProgressWy">
                                <input type="hidden" value="${cantidadDoneFixWy}" id="DoneWy">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 mx-auto my-5">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Legacy HD</h2>
                            <form class="form-inline float-right">
                                <div class="form-group">
                                    <label>Sprints: </label>
                                    <select class="form-control mx-2" id="selOpcion5" name="cboSprintsLegHD1">
                                        <option value="">Select</option>
                                        <c:forEach items="${sprintsLegHD}" var="slh">
                                            <option value="${slh.idSprint}"<c:if test="${slh.idSprint == idSprintLegHD1}">selected</c:if>>${slh.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="return validarSprintsLegHD1()">Buscar</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <ul>
                                <li><b>Total cases: </b>: ${cantidadTotalFixLegHD} </li>
                            </ul>
                            <div id="fixleghd" style="height: 250px;">
                                <!--Wyplay-->
                                <input type="hidden" value="${cantidadToDoFixLegHD}" id="ToDoLegHD">
                                <input type="hidden" value="${cantidadInProgressFixLegHD}" id="InProgressLegHD">
                                <input type="hidden" value="${cantidadDoneFixLegHD}" id="DoneLegHD">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 mx-auto my-5">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">Legacy SD</h2>
                            <form class="form-inline float-right">
                                <div class="form-group">
                                    <label>Sprints: </label>
                                    <select class="form-control mx-2" id="selOpcion6" name="cboSprintsLegSD1">
                                        <option value="">Select</option>
                                        <c:forEach items="${sprintsLegSD}" var="ssd">
                                            <option value="${ssd.idSprint}"<c:if test="${ssd.idSprint == idSprintLegSD1}">selected</c:if>>${ssd.toString()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="return validarSprintsLegSD1()" >Buscar</button>
                            </form>
                        </div>
                        <div class="card-body">
                            <ul>
                                <li><b>Total cases: </b>: ${cantidadTotalFixLegSD} </li>
                            </ul>
                            <div id="fixlegsd" style="height: 250px;">
                                <!--Wyplay-->
                                <input type="hidden" value="${cantidadToDoFixLegSD}" id="ToDoLegSD">
                                <input type="hidden" value="${cantidadInProgressFixLegSD}" id="InProgressLegSD">
                                <input type="hidden" value="${cantidadDoneFixLegSD}" id="DoneLegSD">
                            </div>
                        </div>
                    </div>
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
        <script src="js/bars.js"></script>
    </body>
</html>
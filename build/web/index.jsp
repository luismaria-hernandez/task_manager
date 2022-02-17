<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

        <script src="https://kit.fontawesome.com/cccf91c3da.js" crossorigin="anonymous"></script>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <link rel="stylesheet" href="css/estilos.css"/>

        <title>DIRECTV'S TaskManager - Home</title>
    </head>
    <body>
        <%if (session.getAttribute("user") != null && session.getAttribute("permiso").equals(2)) { %>
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
                <div class="col-lg-10 card mx-auto mt-5"">
                    <h2 class="text-center">Welcome to DirecTv's TaskManager, the internal tracking system for the UAT House QA team</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 mt-4">
                    <div style="text-align:center;padding:1em 0;"> <h2><a style="text-decoration:none;" href="https://www.zeitverschiebung.net/es/city/3860259"><span style="color:gray;">Hora actual en</span><br />Córdoba, Argentina</a></h2> <iframe src="https://www.zeitverschiebung.net/clock-widget-iframe-v2?language=es&size=large&timezone=America%2FArgentina%2FCordoba" width="100%" height="140" frameborder="0" seamless></iframe> </div>
                </div>
                <div class="col-lg-6 mt-4">
                    <div style="text-align:center;padding:1em 0;"> <h2><a style="text-decoration:none;" href="https://www.zeitverschiebung.net/es/city/5806017"><span style="color:gray;">Hora actual en</span><br />Pacific, Estados Unidos (USA)</a></h2> <iframe src="https://www.zeitverschiebung.net/clock-widget-iframe-v2?language=es&size=large&timezone=America%2FLos_Angeles" width="100%" height="140" frameborder="0" seamless></iframe> </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 card mx-auto mt-5"">
                    <h3 class="text-center">Please, read our <a href="terminosYcondiciones.jsp">terms and conditions</a> before proceeding</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 card mx-auto mt-5"">
                    <h3 class="text-center">If you have any doubts please, check our <a href="preguntasFrecuentes.jsp">Q & A section</a>. Here you will find all the information you need.</h3>
                </div>
            </div>
        </div>

        <% } else if(session.getAttribute("user") != null && session.getAttribute("permiso").equals(1)) {%>
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
                <div class="col-lg-10 card mx-auto mt-5">
                    <h2 class="text-center">Welcome to DirecTv's TaskManager, the internal tracking system for the UAT House QA team</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 mt-4">
                    <div style="text-align:center;padding:1em 0;"> <h2><a style="text-decoration:none;" href="https://www.zeitverschiebung.net/es/city/3860259"><span style="color:gray;">Hora actual en</span><br />Córdoba, Argentina</a></h2> <iframe src="https://www.zeitverschiebung.net/clock-widget-iframe-v2?language=es&size=large&timezone=America%2FArgentina%2FCordoba" width="100%" height="140" frameborder="0" seamless></iframe> </div>
                </div>
                <div class="col-lg-6 mt-4">
                    <div style="text-align:center;padding:1em 0;"> <h2><a style="text-decoration:none;" href="https://www.zeitverschiebung.net/es/city/5806017"><span style="color:gray;">Hora actual en</span><br />Pacific, Estados Unidos (USA)</a></h2> <iframe src="https://www.zeitverschiebung.net/clock-widget-iframe-v2?language=es&size=large&timezone=America%2FLos_Angeles" width="100%" height="140" frameborder="0" seamless></iframe> </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 card mx-auto mt-5"">
                    <h3 class="text-center">Please, read our <a href="terminosYcondiciones.jsp">terms and conditions</a> before proceeding</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 card mx-auto mt-5"">
                    <h3 class="text-center">If you have any doubts please, check our <a href="preguntasFrecuentes.jsp">Q & A section</a>. Here you will find all the information you need.</h3>
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
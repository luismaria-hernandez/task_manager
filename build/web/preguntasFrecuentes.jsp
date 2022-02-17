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

        <title>DIRECTV'S TaskManager - Q & A</title>
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
                <div class="bg-secondary text-white container-fluid"><h2 class="text-center p-3">Preguntas frecuentes</h2></div>
                <div class="col-lg-10 card mx-auto mt-5 mb-5">
                    <h3>¿Cómo puedo cambiar mi clave?</h3>
                    <p>
                        En un principio, un usuario es creado con tu dirección de correo electrónico, tus iniciales
                        asignadas de Jira y una clave genérica que son enviadas de manera confidencial a tu casilla
                        de mail corporativo. Una vez que tienes acceso al sistema, puedes cambiar la clave haciendo
                        click en tus iniciales que se despliegan en el margen superior derecho de la pantalla y
                        seleccionando la opción "My account". Esta opción te redirije a una sección con los datos de
                        tu cuenta en donde, además, podrás encontrar un botón "Change password" que te permitirá
                        generar el cambio de la clave. Recuerda que tienes que introducir la clave anterior para poder
                        hacerlo?
                    </p>
                    <br>
                    <h4>Si tengo problemas con el sistema. ¿Con quién me puedo cominicar?</h4>
                    <p>
                        Por cualquier eventualidad con el sistema puedes comunicarte a la siguiente dirección de mail:
                        support@taskmanager.com.ar, o a través de HO (Hang Out) buscando el nombre Luis María Hernández.
                        Responderemos a la brevedad.
                    </p>
                    <h4>¿Cómo funciona la sección de request?</h4>
                    <p> 
                        Los request son pedidos personalizados que llegan a la cuenta de cada usuario cuando son asignados
                        por el administrador. Contienen informacion del ticket de Jira que debe de probarse y, en base a esto, generar un update.
                        Cuando un request llega a tu casilla, al momento de abrirlo, el estado cambia a 
                        "IN PROGRESS", lo cual notifica al administrador que la tarea está siendo revisada. Se desplegará una 
                        ventana con la información del ticket a probar y una herramienta que genera mensajes automáticos. 
                        La utilización de la herramienta es opcional, su uso depende de lo que se pida en el request. En la
                        parte derecha de la pantalla se puede encontrar un panel donde se mostrarán las respuestas a dicho
                        request que serán revisadas por el administrador quien determinará el "DONE" para la tarea o no. Así mismo,
                        el administrador puede generar comentarios de los updates generados por los usuarios y hacer nuevas peticiones
                        en un mismo request.
                    </p>
                    <h4>¿Cómo funciona la sección de Fix Verification?</h4>
                    <p>
                        El fix verification es un sección que tiene información de todos los bugs reportados en Jira y que han sido 
                        solucionados por el área de DEV. Estos tickets se encuentran separados por sprints y brindan la posibilidad
                        de que el usuario normal pueda autoasignarse un ticket. De la misma manera, el administrdor puede asignar a otros usuarios
                        pero nunca a sí mismo. El panel de los ticket consta de una sección con información del ticket, una herramienta que genera
                        comentarios automáticos (esencial para el fix verification), y un panel con las respuestas a dicho ticket. Cada vez que se
                        abre un ticket de fix verificarion, el estado cambia a "IN PROGRESS" lo que notifica al administrador que la tarea está siendo
                        revisado. Luego, el administrador revisa el progreso de la tarea y es quien fine el estado de "DONE" de la misma o no.
                    </p>
                    <h4>¿Cómo funciona Adhoc?</h4>
                    <p>
                       Esta sección tiene un comportamiento similar al fix verification pero con algunas diferencias. La tarea de adhoc consta de
                       una planilla con Historias de usuarios de Jira, separadas por sprints, con las funcionalidades del proyecto que se está testeando. Esta tarea es la menos
                       visible de todas y consta de mas libertad para encontrar bugs dentro del MW. Una vez que se ha abierto el ticket, el estado cambia
                       a "IN PROGRESS" lo que notifica al administrador que la tarea está siendo revisada. En la pantalla se podrá encontrar un apartado
                       con información de la historia de usuario, una herramienta que nos va a permitir generar comentarios en el ticket y un panel
                       donde se muestran dichos comentarios. A difierencia del fix, adhoc solo permite asignar a un usario por caso.
                    </p>
                    <h4>¿Cuáles son las funciones del administrador?</h4>
                    <p>
                        Entre las funciones del administrador se encuntra la potestad de poder crear, modificar, eliminar y controlar cada
                        tarea en cada una de las secciones. Así mismo, gestiona a cada uno de los usuarios del sistema, sus datos y asiganciones
                        así como también los reportes de las tareas que se desempeñan.
                    </p>
                    <h4>¿Como puede hacer el administrador para ver datos de acuerdo a los distintos proyectos?</h4>
                    <p>
                        El administrador, por defecto, está asignado a un proyecto en especifico. Para poder ver informacion de las tareas
                        que están siendo llevadas a cabo por los demas proyectos tiene que cambiar de asignacion. Para poder hacer esto, tiene que
                        dirigirse a las iniciales en el margen superior derecho de la pantalla, seleccionar la opcion "My account" y en la parte
                        de "Assigned Project" hacer click en el botón "Edit". Se desplegará una ventana donde el administrador podrá cambiar el
                        proyecto.
                    </p>
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
                <div class="bg-secondary text-white container-fluid"><h2 class="text-center p-3">Preguntas frecuentes</h2></div>
                <div class="col-lg-10 card mx-auto mt-5 mb-5">
                    <h3>¿Cómo puedo cambiar mi clave?</h3>
                    <p>
                        En un principio, un usuario es creado con tu dirección de correo electrónico, tus iniciales
                        asignadas de Jira y una clave genérica que son enviadas de manera confidencial a tu casilla
                        de mail corporativo. Una vez que tienes acceso al sistema, puedes cambiar la clave haciendo
                        click en tus iniciales que se despliegan en el margen superior derecho de la pantalla y
                        seleccionando la opción "My account". Esta opción te redirije a una sección con los datos de
                        tu cuenta en donde, además, podrás encontrar un botón "Change password" que te permitirá
                        generar el cambio de la clave. Recuerda que tienes que introducir la clave anterior para poder
                        hacerlo?
                    </p>
                    <br>
                    <h4>Si tengo problemas con el sistema. ¿Con quién me puedo cominicar?</h4>
                    <p>
                        Por cualquier eventualidad con el sistema puedes comunicarte a la siguiente dirección de mail:
                        support@taskmanager.com.ar, o a través de HO (Hang Out) buscando el nombre Luis María Hernández.
                        Responderemos a la brevedad.
                    </p>
                    <h4>¿Cómo funciona la sección de request?</h4>
                    <p> 
                        Los request son pedidos personalizados que llegan a la cuenta de cada usuario cuando son asignados
                        por el administrador. Contienen informacion del ticket de Jira que debe de probarse y, en base a esto, generar un update.
                        Cuando un request llega a tu casilla, al momento de abrirlo, el estado cambia a 
                        "IN PROGRESS", lo cual notifica al administrador que la tarea está siendo revisada. Se desplegará una 
                        ventana con la información del ticket a probar y una herramienta que genera mensajes automáticos. 
                        La utilización de la herramienta es opcional, su uso depende de lo que se pida en el request. En la
                        parte derecha de la pantalla se puede encontrar un panel donde se mostrarán las respuestas a dicho
                        request que serán revisadas por el administrador quien determinará el "DONE" para la tarea o no. Así mismo,
                        el administrador puede generar comentarios de los updates generados por los usuarios y hacer nuevas peticiones
                        en un mismo request.
                    </p>
                    <h4>¿Cómo funciona la sección de Fix Verification?</h4>
                    <p>
                        El fix verification es un sección que tiene información de todos los bugs reportados en Jira y que han sido 
                        solucionados por el área de DEV. Estos tickets se encuentran separados por sprints y brindan la posibilidad
                        de que el usuario normal pueda autoasignarse un ticket. De la misma manera, el administrdor puede asignar a otros usuarios
                        pero nunca a sí mismo. El panel de los ticket consta de una sección con información del ticket, una herramienta que genera
                        comentarios automáticos (esencial para el fix verification), y un panel con las respuestas a dicho ticket. Cada vez que se
                        abre un ticket de fix verificarion, el estado cambia a "IN PROGRESS" lo que notifica al administrador que la tarea está siendo
                        revisado. Luego, el administrador revisa el progreso de la tarea y es quien fine el estado de "DONE" de la misma o no.
                    </p>
                    <h4>¿Cómo funciona Adhoc?</h4>
                    <p>
                       Esta sección tiene un comportamiento similar al fix verification pero con algunas diferencias. La tarea de adhoc consta de
                       una planilla con Historias de usuarios de Jira, separadas por sprints, con las funcionalidades del proyecto que se está testeando. Esta tarea es la menos
                       visible de todas y consta de mas libertad para encontrar bugs dentro del MW. Una vez que se ha abierto el ticket, el estado cambia
                       a "IN PROGRESS" lo que notifica al administrador que la tarea está siendo revisada. En la pantalla se podrá encontrar un apartado
                       con información de la historia de usuario, una herramienta que nos va a permitir generar comentarios en el ticket y un panel
                       donde se muestran dichos comentarios. A difierencia del fix, adhoc solo permite asignar a un usario por caso.
                    </p>
                    <h4>¿Cuáles son las funciones del administrador?</h4>
                    <p>
                        Entre las funciones del administrador se encuntra la potestad de poder crear, modificar, eliminar y controlar cada
                        tarea en cada una de las secciones. Así mismo, gestiona a cada uno de los usuarios del sistema, sus datos y asiganciones
                        así como también los reportes de las tareas que se desempeñan.
                    </p>
                    <h4>¿Como puede hacer el administrador para ver datos de acuerdo a los distintos proyectos?</h4>
                    <p>
                        El administrador, por defecto, está asignado a un proyecto en especifico. Para poder ver informacion de las tareas
                        que están siendo llevadas a cabo por los demas proyectos tiene que cambiar de asignacion. Para poder hacer esto, tiene que
                        dirigirse a las iniciales en el margen superior derecho de la pantalla, seleccionar la opcion "My account" y en la parte
                        de "Assigned Project" hacer click en el botón "Edit". Se desplegará una ventana donde el administrador podrá cambiar el
                        proyecto.
                    </p>
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
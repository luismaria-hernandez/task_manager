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

        <title>DIRECTV'S TaskManager - Terms and conditions</title>
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
                <div class="bg-secondary text-white container-fluid"><h2 class="text-center p-3">Términos y condiciones</h2></div>
                <div class="col-lg-10 card mx-auto mt-5 mb-5">
                    <h3>¡Bienvenido!</h3>
                    <p>Bienvenido a "DirecTv's TaskManager" proporcionado por Loomie Soft. Nos complace ofrecerle acceso al Servicio (como se define más
                    abajo), sujeto a estos términos y condiciones (los "Términos de Servicio") y a la Política
                    de Privacidad correspondiente de XXXX. Al acceder y utilizar el Servicio, usted expresa
                    su consentimiento, acuerdo y entendimiento de los Términos de Servicio y la Política de
                    Privacidad. Si no está de acuerdo con los Términos de Servicio o la Política de
                    Privacidad, no utilice el Servicio.
                    Si utiliza el servicio está aceptando las modalidades operativas en vigencia descriptas
                    más adelante, las declara conocer y aceptar, las que se habiliten en el futuro y en los
                    términos y condiciones que a continuación se detallan: 
                    </p>
                    <br>
                    <h4>Operaciones habilitadas.</h4>
                    <p>Las operaciones habilitadas son aquellas que estarán disponibles para los clientes,
                    quienes deberán cumplir los requisitos que se encuentren vigentes en su momento para
                    operar el Servicio. Las mismas podrán ser ampliadas o restringidas por el proveedor,
                    comunicándolo previamente con una antelación no menor a 60 días, y comprenden
                    entre otras, sin que pueda entenderse taxativamente las que se indican a continuación:
                    …................................. 
                    </p>
                    <h4>Transacciones : …............................................ </h4>
                    <p> En ningún caso debe entenderse que la solicitud de un producto o servicio implica
                        obligación alguna para el Acceso y uso del Servicio.
                        Para operar el Servicio se requerirá siempre que se trate de clientes de .........., quienes
                        podrán acceder mediante cualquier dispositivo con conexión a la Red Internet. El cliente
                        deberá proporcionar el número de documento de identidad y la clave personal, que será
                        provista por la aplicación como requisito previo a la primera operación, en la forma que
                        le sea requerida. La clave personal y todo o cualquier otro mecanismo adicional de
                        autenticación personal provisto por el Banco tiene el carácter de secreto e intransferible,
                        y por lo tanto asumo las consecuencias de su divulgación a terceros, liberando a.........
                        de toda responsabilidad que de ello se derive. En ningún caso .......... requerirá que le
                        suministre la totalidad de los datos, ni enviara mail requiriendo información personal
                        alguna. 
                    </p>
                    <h4>Costo del Servicio</h4>
                    <p>
                        La empresa XXXX podrá cobrar comisiones por el mantenimiento y/o uso de este
                        Servicio o los que en el futuro implemente, entendiéndose facultado expresamente para
                        efectuar los correspondientes débitos en mis cuentas, aún en descubierto, por lo que
                        presto para ello mi expresa conformidad. En caso de cualquier modificación a la
                        presente previsión, lo comunicará con al menos 60 días de antelación. 
                    </p>
                    <h4>Vigencia</h4>
                    <p>
                       El Usuario podrá dejar sin efecto la relación que surja de la presente, en forma
                        inmediata, sin otra responsabilidad que la derivada de los gastos originados hasta ese
                        momento. Si el cliente incumpliera cualquiera de las obligaciones asumidas en su
                        relación contractual con empresa XXXX, o de los presentes Términos y Condiciones, el
                        Banco podrá decretar la caducidad del presente Servicio en forma inmediata, sin que
                        ello genere derecho a indemnización o compensación alguna. empresa XXX podrá dejar
                        sin efecto la relación que surja de la presente, con un preaviso mínimo de 60 días, sin
                        otra responsabilidad.  
                    </p>
                    <h4>Validez de operaciones y notificaciones</h4>
                    <p>
                        Los registros emitidos por la app serán prueba suficiente de las operaciones cursadas
                        por dicho canal. Renuncio expresamente a cuestionar la idoneidad o habilidad de ese
                        medio de prueba. A los efectos del cumplimiento de disposiciones legales o
                        contractuales, se otorga a las notificaciones por este medio el mismo alcance de las
                        notificaciones mediante documento escrito.
                    </p>
                    <h4>Propiedad intelectual</h4>
                    <p>
                        El software en Argentina está protegido por la ley 11.723, que regula la propiedad
                        intelectual y los derechos de autor de todos aquellos creadores de obras artísticas,
                        literarias y científicas.
                    </p>
                    <h4>Privacidad de la información</h4>
                    <p>
                        Para utilizar los Servicios ofrecidos por XXXX, los Usuarios deberán facilitar
                        determinados datos de carácter personal. Su información personal se procesa y
                        almacena en servidores o medios magnéticos que mantienen altos estándares de
                        seguridad y protección tanto física como tecnológica. Para mayor información sobre la
                        privacidad de los Datos Personales y casos en los que será revelada la información
                        personal, se pueden consultar nuestras políticas de privacidad
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
                <div class="bg-secondary text-white container-fluid"><h2 class="text-center p-3">Términos y condiciones</h2></div>
                <div class="col-lg-10 card mx-auto mt-5 mb-5">
                    <h3>¡Bienvenido!</h3>
                    Bienvenido a "DirecTv's TaskManager" proporcionado por Loomie Soft. Nos complace ofrecerle acceso al Servicio, 
                    sujeto a estos términos y condiciones (los "Términos de Servicio") y a la Política
                    de Privacidad correspondiente de Loomie Soft. Al acceder y utilizar el Servicio, usted expresa
                    su consentimiento, acuerdo y entendimiento de los Términos de Servicio y la Política de
                    Privacidad. Si no está de acuerdo con los Términos de Servicio o la Política de
                    Privacidad, no utilice el Servicio.
                    Si utiliza el servicio está aceptando las modalidades operativas en vigencia descriptas
                    más adelante, las declara conocer y aceptar, las que se habiliten en el futuro y en los
                    términos y condiciones que a continuación se detallan: 
                    <ol>
                        <li>El uso del servicio está limitado única y exclusivamente al grupo Quality Control "UAT House" que terciariza 
                            servicios de testing para DirecTv a través de Sistemas Globales S.A. - Globant.
                        </li>
                        <li>
                            La información del cliente que es utilizada dentro del sistema es de carácter <i>Confidencial</i>, por lo que su divulgación
                            no autorizada de la misma será penada por la ley.
                        </li>
                        <li>
                            El acceso al sistema requerirá una cuenta de e-mail corporativa con el dominio <i>@globant.com</i> y una clave
                            que será asignada previamente.
                        </li>
                    </ol>
                    
                    <br><br>
                    <h4>Operaciones habilitadas.</h4>
                    <p>Las operaciones habilitadas son aquellas que estarán disponibles para los usuarios,
                        quienes deberán cumplir los requisitos que se encuentren vigentes en su momento para
                        operar el Servicio. Las mismas podrán ser ampliadas o restringidas por el proveedor,
                        comunicándolo previamente con una antelación no menor a 60 días, y comprenden
                        entre otras, sin que pueda entenderse taxativamente las que se indican a continuación:
                    </p>
                    <br><br>
                    <h5>Operaciones del usuario normal</h5>
                        <ol>
                            <li>Correr tickets internos para cada una de las tareas: Adhoc, Fix Verification y request</li>
                            <li>Generar y eliminar comentarios en los tickets</li>
                            <li>Autoasignación de los tickets</li>
                            <li>Cambiar de la contraseña del propio usuario</li>
                        </ol>
                    <br><br>
                    <h5>Operaciones del usuario Administrador</h5>
                        <ol>
                            <li>Crear, abrir, editar y eliminar tickets nuevos para cada una de las tareas: Adhoc, Fix Verification y request</li>
                            <li>Generar comentarios en los ticket de las tareas de request y fix verification</li>
                            <li>Asignar los tickets a otros usuarios</li>
                            <li>Generar reportes correspondientes a las tareas</li>
                            <li>Gestionar usuarios así tambien como sus datos y privilegios de acceso al sistema</li>
                            <li>Generar la información correspondiente a los sprints que deben probarse</li>
                            <li>Cambiar la contraseña del propio usuario</li>
                        </ol>
                    <br><br>
                    <h4>Transacciones : Acerca del acceso al servicio </h4>
                    <p> En ningún caso debe entenderse que la solicitud de un producto o servicio implica
                        obligación alguna para el Acceso y uso del Servicio.
                        Para operar el Servicio se requerirá siempre que se trate de usuarios de DIRECTV'S Task Manager, quienes
                        podrán acceder mediante cualquier dispositivo con conexión a la Red Internet. El usuario
                        deberá proporcionar el email corporativo y la clave personal, que será
                        provista por la aplicación como requisito previo a la primera operación, en la forma que
                        le sea requerida. La clave personal y todo o cualquier otro mecanismo adicional de
                        autenticación personal provisto por el Banco tiene el carácter de secreto e intransferible,
                        y por lo tanto asumo las consecuencias de su divulgación a terceros, liberando a Loomie Soft
                        de toda responsabilidad que de ello se derive. En ningún caso LoomieSoft requerirá que le
                        suministre la totalidad de los datos, ni enviara mail requiriendo información personal
                        alguna. 
                    </p>
                    <br><br>
                    <h4>Costo del Servicio</h4>
                    
                        La empresa Loomie Soft no cobrará comisiones por el mantenimiento y/o uso de este
                        Servicio o los que en el futuro implemente.
                    <br><br>
                    <h4>Vigencia</h4>
                    <p>
                       El Usuario podrá dejar sin efecto la relación que surja de la presente, en forma
                        inmediata, sin otra responsabilidad. Si el cliente incumpliera cualquiera de las obligaciones asumidas en su
                        relación contractual con empresa Loomie Soft, o de los presentes Términos y Condiciones, el
                        Banco podrá decretar la caducidad del presente Servicio en forma inmediata, sin que
                        ello genere derecho a indemnización o compensación alguna. empresa XXX podrá dejar
                        sin efecto la relación que surja de la presente, con un preaviso mínimo de 60 días, sin
                        otra responsabilidad.  
                    </p>
                    <br><br>
                    <h4>Validez de operaciones y notificaciones</h4>
                    <p>
                        Los registros emitidos por la app serán prueba suficiente de las operaciones cursadas
                        por dicho canal. Renuncio expresamente a cuestionar la idoneidad o habilidad de ese
                        medio de prueba. A los efectos del cumplimiento de disposiciones legales o
                        contractuales, se otorga a las notificaciones por este medio el mismo alcance de las
                        notificaciones mediante documento escrito.
                    </p>
                    <br><br>
                    <h4>Propiedad intelectual</h4>
                    <p>
                        El software en Argentina está protegido por la ley 11.723, que regula la propiedad
                        intelectual y los derechos de autor de todos aquellos creadores de obras artísticas,
                        literarias y científicas.
                    </p>
                    <br><br>
                    <h4>Privacidad de la información</h4>
                    <p>
                        Para utilizar los Servicios ofrecidos por Loomie soft, los Usuarios deberán facilitar
                        determinados datos de carácter personal. Su información personal se procesa y
                        almacena en servidores o medios magnéticos que mantienen altos estándares de
                        seguridad y protección tanto física como tecnológica. Para mayor información sobre la
                        privacidad de los Datos Personales y casos en los que será revelada la información
                        personal, se pueden consultar nuestras políticas de privacidad
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
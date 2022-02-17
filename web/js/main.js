
function validarCampos() 
{
    var repro = document.getElementById("cboRepro").value;
    
    if(repro === null || repro === "")
    {
        alert("You must select an option for Reproducibility!");
        repro.focus();
        return false;
    }
    
    var resol = document.getElementById("cboResol").value;
    
    if(resol === null || resol === "") 
    {
        alert("You must select an option for Resolution!");
        resol.focus();
        return false;
    }
    
    var stbs = document.getElementById("cboStbs").value;
    
    if(stbs === null || stbs === "") 
    {
        alert("You must select an option for STBs!");
        resol.focus();
        return false;
    }
    
    var version = document.getElementById("cboVersion").value;
    
    if(version === null || version === "") 
    {
        alert("You must select a Version!");
        resol.focus();
        return false;
    }
    
    var times = document.getElementById("cboTimes").value;
    
    if(times === null || times === "") 
    {
        alert("How many times did it happened?");
        resol.focus();
        return false;
    }
    
    var timesDos = document.getElementById("cboTimesDos").value;
    
    if(timesDos === null || timesDos === "") 
    {
        alert("How many attempts?");
        resol.focus();
        return false;
    }
    
    return true;
    
}

function generateComment()
{
    
    if(validarCampos())
    {
        var userSession = document.getElementById("userSession").value;
        var repro = document.getElementById("cboRepro").value;
        var resol = document.getElementById("cboResol").value;
        var stbs = document.getElementById("cboStbs").value;
        var version = document.getElementById("cboVersion").value;
        var times = document.getElementById("cboTimes").value;
        var timesDos = document.getElementById("cboTimesDos").value;
        var msg = document.getElementById("txtMsg").value;

        var fecha = new Date();

        var soloFecha = fecha.toLocaleDateString();

        var comment = "";

        if(msg === "")
        {
            comment = soloFecha+" "+userSession+": Issue was reproted as occurring "+repro+". "+resol+" on "+stbs+" with "+version+". Issue reproduced "+times+" out of "+timesDos+" attempts.";
            alert(comment);

        }
        else 
        {
            comment = soloFecha+" "+userSession+": Issue was reproted as occurring "+repro+". "+resol+" on "+stbs+" with "+version+". Issue reproduced "+times+" out of "+timesDos+" attempts. "+msg;
            alert(comment);
        }

        document.getElementById("txtRespuesta").value=comment;
    }

}

function validarCamposDos()
{
    var estadoAdhoc = document.getElementById("cboEstadoAdhoc").value;
    
    if(estadoAdhoc === null || estadoAdhoc === "")
    {
        alert("You must select and option for Adhoc Status");
        return false;
    }
    
    var comment = document.getElementById("txtComment").value;
    
    if(comment  === null || comment  === "") 
    {
        alert("Don't leave the comment box empty!");
        return false;
    }
    return true;
}



function mensajeVacio()
{
    var mensaje = document.getElementById("txtRespuesta").value;
    
    if(mensaje === null || mensaje === "") 
    {
        alert("Generated comment must not be empty");
        return false;
    } 
    return true;
}

function sendAlert() 
{
    if (mensajeVacio())
    {

        var result = confirm("You are about to send your response. Do you wish to continue?");

        if(result === true) 
        {

            return true;
        }
        else
        {
            return false;
        }
    }
}

function confirmarDelete()
{
    var result = confirm("You are about to DELETE a user. Do you wish to continue?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }  
}

function activarOpciones() 
{
    var repro = document.getElementById("cboRepro").value;
    
    if (repro === "Always")
    {
        document.getElementById("utr").disabled=true;
    }
    else if (repro === "Intermittent")
    {
        document.getElementById("pass").disabled=true;
        document.getElementById("utr").disabled=false;
    }
    else if (repro === "Intermittent/Happened once")
    {
        document.getElementById("pass").disabled=true;
        document.getElementById("utr").disabled=false;
    } 
    else if (repro === null) 
    {
        document.getElementById("utr").disabled=false;
        document.getElementById("pass").disabled=false;
    }
}

function validarForm()
{
    var valor = document.getElementById("selOpcion").value;
    
    if (valor === null || valor === "") 
    { 
        alert("You must select Adhoc status before proceeding");
        return false;
    }
    
    var mensaje = document.getElementById("txtRespuesta").value;
    
    if(mensaje === null || mensaje === "") 
    {
        alert("Generated comment must not be empty");
        return false;
    } 
    return true;
}

/*
function habilitarCampos()
{
    if(validarCombos())
    {
        document.getElementById("titulo").disabled = false;
        document.getElementById("ticket").disabled = false;
        document.getElementById("prioridad").disabled = false;
        document.getElementById("cboEstado").disabled = false;
        document.getElementById("cboSprints").disabled = false;
        document.getElementById("dtpFecha").disabled = false;
        document.getElementById("txtAdminComment").disabled = false;
        
        return true;
    }
    else 
    {
        return false;
    }
}
 
 */
function confirmarDeleteAsignado()
{
    var result = confirm("You are about to DELETE an ASSIGNEE. Do you wish to continue?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }  
}

//UPDATE REQUEST

function validarUpdateRequest()
{
    var titulo = document.getElementById("titulo").value;
    var ticket = document.getElementById("ticket").value;
    var estado = document.getElementById("estado").value;
    var prioridad = document.getElementById("prioridad").value;
    var fecha = document.getElementById("fecha").value;  
    var hora = document.getElementById("hora").value;
    var adminComment = document.getElementById("txtAdminComment").value;
    
    //FECHA ACTUAL
    var fecha1 = new Date();
        
    var anio = fecha1.getFullYear();
    var mes = (fecha1.getMonth()+1).toString();

    if(mes.length<=1)
    {
        mes = "0" + mes;
    }

    var dia = fecha1.getDate().toString();

    if(dia.length<=1)
    {
        dia = "0" + dia;
    }

    var fecha_actual = anio+'-'+mes+'-'+dia;
    
    
    if(titulo === "")
    {
        alert("You have to asign a title to the new Request");
        return false;
    }
    else if(ticket === "")
    {
        alert("You have to put the link to its correponding Jira Ticket");
        return false;
    }
    else if(estado === "")
    {
        alert("Select the status");
        return false;
        
    }
    else if(prioridad === "" )
    {
        alert("You must select the priority");
        return false;
    }
    
    else if(fecha === "")
    {
        alert ("You must select a date");
        return false;
    }
    else if(fecha !== "" && fecha>fecha_actual)
    {
        
        alert("You must select a valid date");
        return false;

    }
    else if(hora === "")
    {
        alert("Please, select the time");
        return false;
    }
    else if(adminComment === "" )
    {
        alert("You must not leave the admin comment field empty");
        return false;
    }
    return true;
}

function enviarUpdateRequest()
{
    if(validarUpdateRequest())
    {
        var resultado = confirm("Do you want to save the changes?");
        
        if(resultado)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else 
    {
        return false;
    }
}

//UPDATE FIX
function validarUpdateFix()
{
    var titulo = document.getElementById('titulo').value;
    var ticket = document.getElementById('ticket').value;
    var prioridad = document.getElementById('prioridad').value;
    var estado = document.getElementById('estado').value;
    var sprint = document.getElementById('sprint').value;
    var fecha = document.getElementById('fecha').value;
    var comment = document.getElementById('txtAdminComment').value;
    
    
    //FECHA ACTUAL
    var fecha1 = new Date();
        
    var anio = fecha1.getFullYear();
    var mes = (fecha1.getMonth()+1).toString();

    if(mes.length<=1)
    {
        mes = "0" + mes;
    }

    var dia = fecha1.getDate().toString();

    if(dia.length<=1)
    {
        dia = "0" + dia;
    }

    var fecha_actual = anio+'-'+mes+'-'+dia;
    
    if(titulo === "")
    {
        alert('Enter the title for the fix');
        return false;
    }
    else if(ticket === "")
    {
        alert('Enter the link to its corresponding Jira ticket');
        return false;
    }
    else if(prioridad === "")
    {
        alert('Select the priority');
        return false;
    }
    else if(estado ==="")
    {
        alert('Select the Status');
        return false;
    }
    else if(sprint ==="")
    {
        alert('Select the Sprint');
        return false;
    }
    else if(fecha === "")
    {
        alert ("You must select a date");
        return false;
    }
    else if(fecha !== "" && fecha>fecha_actual)
    {
        
        alert("You must select a valid date");
        return false;

    }
    else if(comment === "")
    {
        alert("¡You must not leave the admin's comment empty!");
        return false;
    }
    return true;
}

function confirmarUpdateFix()

{
    if(validarUpdateFix())
    {
    
        var result = confirm("Do you want to save the changes?");

        if(result) 
        {
            return true;
        }
        else
        {
            return false;
        }  
    }
    else
    {
        return false;
    }
}

function eliminarFix()
{
    var result = confirm("You are about to DELETE a FIX. Do you want to proceed?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }   
}

function eliminarAdhoc()
{
    var result = confirm("You are about to DELETE an ADHOC. Do you want to proceed?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }   
}

function eliminarReq()
{
    var result = confirm("You are about to DELETE a REQUEST. Do you want to proceed?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }   
}

function validarSprints()
{
    var valor= document.getElementById("selOpcion").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}

function eliminarComentario()
{
    var result = confirm("You're about to delete this answere. Do you want to proceed?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }  
}

function terminarTarea()
{
    var result = confirm("You're about terminate this task. Do you want to proceed?");

    if(result === true) 
    {

        return true;
    }
    else
    {
        return false;
    }   
    
}

//VALIDACIONES REQUEST

function validarNuevoRequest()
{
    var titulo = document.getElementById("titulo").value;
    var ticket = document.getElementById("ticket").value;
    var estado = document.getElementById("status").value;
    var prioridad = document.getElementById("prioridad").value;
    var fecha = document.getElementById("dtpFecha").value;  
    var hora = document.getElementById("hora").value;
    var adminComment = document.getElementById("adminComment").value;
    
    //FECHA ACTUAL
    var fecha1 = new Date();
        
    var anio = fecha1.getFullYear();
    var mes = (fecha1.getMonth()+1).toString();

    if(mes.length<=1)
    {
        mes = "0" + mes;
    }

    var dia = fecha1.getDate().toString();

    if(dia.length<=1)
    {
        dia = "0" + dia;
    }

    var fecha_actual = anio+'-'+mes+'-'+dia;
    
    
    if(titulo === "")
    {
        alert("You have to asign a title to the new Request");
        return false;
    }
    else if(ticket === "")
    {
        alert("You have to put the link to its correponding Jira Ticket");
        return false;
    }
    else if(estado === "")
    {
        alert("Select the status");
        return false;
        
    }
    else if(prioridad === "" )
    {
        alert("You must select the priority");
        return false;
    }
    
    else if(fecha === "")
    {
        alert ("You must select a date");
        return false;
    }
    else if(fecha !== "" && fecha>fecha_actual)
    {
        
        alert("You must select a valid date");
        return false;

    }
    else if(hora === "")
    {
        alert("Please, select the time");
        return false;
    }
    else if(adminComment === "" )
    {
        alert("You must not leave the admin comment field empty");
        return false;
    }
    return true;
}

function enviarRequest()
{
    if(validarNuevoRequest())
    {
        var resultado = confirm("Proceed to create a new Request?");
        
        if(resultado)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else 
    {
        return false;
    }
}

//VALIDACIONES FIX

function validarNuevoFix()
{
    var proyecto = document.getElementById('proyecto').value;
    var titulo = document.getElementById('titulo').value;
    var ticket = document.getElementById('ticket').value;
    var prioridad = document.getElementById('prioridad').value;
    var estado = document.getElementById('estado').value;
    var sprint = document.getElementById('sprint').value;
    var fecha = document.getElementById('fecha').value;
    var comment = document.getElementById('txtAdminComment').value;
    
    
    //FECHA ACTUAL
    var fecha1 = new Date();
        
    var anio = fecha1.getFullYear();
    var mes = (fecha1.getMonth()+1).toString();

    if(mes.length<=1)
    {
        mes = "0" + mes;
    }

    var dia = fecha1.getDate().toString();

    if(dia.length<=1)
    {
        dia = "0" + dia;
    }

    var fecha_actual = anio+'-'+mes+'-'+dia;
    
    if(proyecto === "")
    {
        alert('Before proceeding you must select a project');
        return false;
    }
    else if(titulo === "")
    {
        alert('Enter the title for the fix');
        return false;
    }
    else if(ticket === "")
    {
        alert('Enter the link to its corresponding Jira ticket');
        return false;
    }
    else if(prioridad === "")
    {
        alert('Select the priority');
        return false;
    }
    else if(estado ==="")
    {
        alert('Select the Status');
        return false;
    }
    else if(sprint ==="")
    {
        alert('Select the Sprint');
        return false;
    }
    else if(fecha === "")
    {
        alert ("You must select a date");
        return false;
    }
    else if(fecha !== "" && fecha>fecha_actual)
    {
        
        alert("You must select a valid date");
        return false;

    }
    else if(comment === "")
    {
        alert("¡You must not leave the admin's comment empty!");
        return false;
    }
    return true;
}

function enviarNuevoFix()
{
    if(validarNuevoFix())
    {
        var resultado = confirm("Proceed to create a new Fix?");
        
        if(resultado)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else 
    {
        return false;
    }
}

//VALIDACIONES ADHOC

function validarNuevoAdhoc()
{
    var proyecto = document.getElementById('proyecto').value;
    var titulo = document.getElementById('titulo').value;
    var ticket = document.getElementById('ticket').value;
    var estado = document.getElementById('estado').value;
    var estadoAdhoc = document.getElementById('estadoAdhoc').value;
    var sprint = document.getElementById('sprint').value;
    var fecha = document.getElementById('fecha').value;
    
    
    //FECHA ACTUAL
    var fecha1 = new Date();
        
    var anio = fecha1.getFullYear();
    var mes = (fecha1.getMonth()+1).toString();

    if(mes.length<=1)
    {
        mes = "0" + mes;
    }

    var dia = fecha1.getDate().toString();

    if(dia.length<=1)
    {
        dia = "0" + dia;
    }

    var fecha_actual = anio+'-'+mes+'-'+dia;
    
    if(proyecto === "")
    {
        alert('Before proceeding you must select a project');
        return false;
    }
    else if(titulo === "")
    {
        alert('Enter the title for the fix');
        return false;
    }
    else if(ticket === "")
    {
        alert('Enter the link to its corresponding Jira ticket');
        return false;
    }
    else if(estado ==="")
    {
        alert('Select the Status');
        return false;
    }
    else if(estadoAdhoc  === "")
    {
        alert('Select the ADHOC status');
        return false;
    }
    else if(sprint ==="")
    {
        alert('Select the Sprint');
        return false;
    }
    else if(fecha === "")
    {
        alert ("You must select a date");
        return false;
    }
    else if(fecha !== "" && fecha>fecha_actual)
    {
        
        alert("You must select a valid date");
        return false;

    }
    return true;
}

function enviarNuevoAdhoc()
{
    if(validarNuevoAdhoc())
    {
        var resultado = confirm("Proceed to create a new Adhoc?");
        
        if(resultado)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else 
    {
        return false;
    }
}

//VALIDACIÓN UPDATE ADHOC

function validarUpdateAdhoc()
{
    var titulo = document.getElementById('titulo').value;
    var ticket = document.getElementById('ticket').value;
    var estado = document.getElementById('estado').value;
    var estadoAdhoc = document.getElementById('estadoAdhoc').value;
    var sprint = document.getElementById('sprint').value;
    var fecha = document.getElementById('fecha').value;
    
    
    //FECHA ACTUAL
    var fecha1 = new Date();
        
    var anio = fecha1.getFullYear();
    var mes = (fecha1.getMonth()+1).toString();

    if(mes.length<=1)
    {
        mes = "0" + mes;
    }

    var dia = fecha1.getDate().toString();

    if(dia.length<=1)
    {
        dia = "0" + dia;
    }

    var fecha_actual = anio+'-'+mes+'-'+dia;
    
    if(titulo === "")
    {
        alert('Enter the title for the fix');
        return false;
    }
    else if(ticket === "")
    {
        alert('Enter the link to its corresponding Jira ticket');
        return false;
    }
    else if(estado ==="")
    {
        alert('Select the Status');
        return false;
    }
    else if(estadoAdhoc  === "")
    {
        alert('Select the ADHOC status');
        return false;
    }
    else if(sprint ==="")
    {
        alert('Select the Sprint');
        return false;
    }
    else if(fecha === "")
    {
        alert ("You must select a date");
        return false;
    }
    else if(fecha !== "" && fecha>fecha_actual)
    {
        
        alert("You must select a valid date");
        return false;

    }
    return true;
}

function enviarUpdateAdhoc()
{
    if(validarUpdateAdhoc())
    {
        var resultado = confirm("Do you want to save the changes?");
        
        if(resultado)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else 
    {
        return false;
    }
}

function validarSprintsWy()
{
    var valor= document.getElementById("selOpcion1").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}

function validarSprintsLegHD()
{
    var valor= document.getElementById("selOpcion2").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}

function validarSprintsLegSD()
{
    var valor= document.getElementById("selOpcion3").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}

function validarSprintsWy1()
{
    var valor= document.getElementById("selOpcion4").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}

function validarSprintsLegHD1()
{
    var valor= document.getElementById("selOpcion5").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}

function validarSprintsLegSD1()
{
    var valor= document.getElementById("selOpcion6").value;
    
    if (valor === null || valor === "") 
    {
        alert("You must select a SPRINT before proceeding!");
        return false;
    }
    return true;
}
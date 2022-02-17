/*
 * Play with this code and it'll update in the panel opposite.
 *
 * Why not try some of the options above?
 */

//ADHOC - WYPLAY
var NotRunWy = document.getElementById("NotRunWy").value;
var PassWy = document.getElementById("PassWy").value;
var FailWy = document.getElementById("FailWy").value;


Morris.Bar({
  element: 'adhocwy',
  data: [
    { y: 'Wyplay - NextGen UI testing', a:FailWy , b:NotRunWy , c:PassWy }

  ],
  xkey: 'y',
  ykeys: ['a', 'b', 'c'],
  labels: ['FAIL', 'NOT RUN', 'PASS']
});

// ADHOC - LEGACY HD

var NotRunLegHD = document.getElementById("NotRunLegHD").value;
var PassLegHD = document.getElementById("PassLegHD").value;
var FailLegHD = document.getElementById("FailLegHD").value;


Morris.Bar({
  element: 'adhocleghd',
  data: [
    { y: 'Legacy HD - NextGen UI testing', a:FailLegHD , b:NotRunLegHD , c:PassLegHD }

  ],
  xkey: 'y',
  ykeys: ['a', 'b', 'c'],
  labels: ['FAIL', 'NOT RUN', 'PASS']
});

// ADHOC - LEGACY SD

var NotRunLegSD = document.getElementById("NotRunLegSD").value;
var PassLegSD = document.getElementById("PassLegSD").value;
var FailLegSD = document.getElementById("FailLegSD").value;


Morris.Bar({
  element: 'adhoclegsd',
  data: [
    { y: 'Legacy HD - NextGen UI testing', a:FailLegSD , b:NotRunLegSD , c:PassLegSD }

  ],
  xkey: 'y',
  ykeys: ['a', 'b', 'c'],
  labels: ['FAIL', 'NOT RUN', 'PASS']
});


//FIX

//Wyplay

var ToDoWyplay = document.getElementById("ToDoFixWy").value;
var InProgressWyplay = document.getElementById("InProgressWy").value;
var DoneWyplay = document.getElementById("DoneWy").value;

Morris.Bar({
  element: 'fixwy',
  data: [
    { y: 'Wyplay - NextGen UI testing', a:ToDoWyplay , b:InProgressWyplay , c: DoneWyplay}

  ],
  xkey: 'y',
  ykeys: ['a', 'b', 'c'],
  labels: ['TO DO', 'IN PROGRESS', 'DONE']
});

//LegacyHD

var ToDoLegHD = document.getElementById("ToDoLegHD").value;
var InProgressLegHD = document.getElementById("InProgressLegHD").value;
var DoneLegHD = document.getElementById("DoneLegHD").value;

Morris.Bar({
  element: 'fixleghd',
  data: [
    { y: 'Wyplay - NextGen UI testing', a:ToDoLegHD , b:InProgressLegHD , c: DoneLegHD}

  ],
  xkey: 'y',
  ykeys: ['a', 'b', 'c'],
  labels: ['TO DO', 'IN PROGRESS', 'DONE']
});


//LegacySD

var ToDoLegSD = document.getElementById("ToDoLegSD").value;
var InProgressLegSD = document.getElementById("InProgressLegSD").value;
var DoneLegSD = document.getElementById("DoneLegSD").value;

Morris.Bar({
  element: 'fixlegsd',
  data: [
    { y: 'Wyplay - NextGen UI testing', a:ToDoLegSD , b:InProgressLegSD , c: DoneLegSD}

  ],
  xkey: 'y',
  ykeys: ['a', 'b', 'c'],
  labels: ['TO DO', 'IN PROGRESS', 'DONE']
});
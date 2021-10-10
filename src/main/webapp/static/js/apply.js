async function apply(){
    // console.log("applied successfully");

    let empprof = JSON.parse(document.cookie);

    let url = "http://localhost:8080/project1/apply";

    let gradevalue = document.querySelector('input[name="graderequirement"]:checked').value;
    //console.log (document.querySelector('input[name="graderequirement"]:checked').value);
    //console.log("gradevalue is: " + gradevalue);

    let gradenumber;

    if (gradevalue == 'A'){
        gradenumber = 1;
        console.log("gradenumber is: " + gradenumber);
    } else if (gradevalue == 'B') {
        gradenumber = 2;
        console.log("gradenumber is: " + gradenumber);
    } else if (gradevalue == 'C'){
        gradenumber = 3;
        console.log("gradenumber is: " + gradenumber);
    } else {
        gradenumber = 4;
        console.log("gradenumber is: " + gradenumber);
    }

    let eventprice = document.getElementById('cost').value;

    let eventdes = document.querySelector('input[name="eventdescription"]:checked').value;
    console.log (document.querySelector('input[name="eventdescription"]:checked').value);

    let projectedremb;

    if (eventdes == "Certification"){
        projectedremb = eventprice;
        console.log("projectedremb is: " + projectedremb)
    } else if (eventdes == "Technical Training"){
        projectedremb = eventprice * .9;
        console.log("projectedremb is: " + projectedremb)
    } else if (eventdes == "University Course"){
        projectedremb = eventprice * .8;
        console.log("projectedremb is: " + projectedremb)
    } else if (eventdes == "Certification Prep Class"){
        projectedremb = eventprice * .75;
        console.log("projectedremb is: " + projectedremb)
    } else if (eventdes == "Seminar"){
        projectedremb = eventprice * .6;
        console.log("projectedremb is: " + projectedremb)
    } else {
        projectedremb = eventprice * .3;
        console.log("projectedremb is: " + projectedremb)
    }

    let currentDate = Date.now();
    console.log("Current Date: " + currentDate);
    let evdate = document.getElementById('eventdate').valueAsNumber;
    console.log("event date: " + evdate);
    let timeuntilevent = evdate - currentDate;
    console.log("Time until event: " + timeuntilevent);



    let application = {
        empId: empprof.id,
        empFirstName: empprof.firstName,
        empLastName: empprof.lastName,
        eventDate: document.getElementById('eventdate').value,
        location: document.getElementById('eventlocation').value,
        description: document.querySelector('input[name="eventdescription"]:checked').value,
        cost: document.getElementById('cost').value,
        gradeRequirement: gradenumber,
        workJustification: document.getElementById('justification').value,
        reimbursementProject: projectedremb,
        dsid: empprof.directSupervisorId
        }

    console.log(application);
    console.log(JSON.stringify(application));

    if (projectedremb > empprof.reimbursement){
        document.getElementById("apply").innerHTML = `Application Refused. Projected Reimbursement ${projectedremb} exceeds total reimbursement left: ${empprof.reimbursement}`; 
    } else if (timeuntilevent < 604800000) {
        document.getElementById("apply").innerHTML = `Application Refused. Event happening too soon. Need to apply no less than 1 week until the event`;
    } else {
        document.getElementById("apply").innerHTML = 'Application Processing';

        let res = await fetch(url, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(application)
    
        });

        empprof.reimbursement = empprof.reimbursement - projectedremb;
        document.cookie = JSON.stringify(empprof);
        document.cookie.assign;
    }
}
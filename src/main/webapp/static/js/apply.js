async function apply(){
    // console.log("applied successfully");

    let empprof = JSON.parse(document.cookie);

    let url = "http://localhost:8080/project1/apply";

    let application = {
        employeeid: empprof.id,
        employeefirstname: empprof.firstName,
        employeelastname: empprof.lastName,
        eventdate: document.getElementById('eventdate').value,
        eventlocation: document.getElementById('eventlocation').value,
        eventtype: document.getElementById('eventdescription').value,
        eventcost: document.getElementById('cost').value,
        graderequired: document.getElementById('graderequirement').value,
        justification: document.getElementById('justification').value
    }

    console.log(application);
    console.log(JSON.stringify(application));

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)

    });
}
async function bencoupdate(){

    console.log("hello from bencoupdate");

    let url = "http://localhost:8080/project1/bencoupdate";

    let accrej = document.querySelector('input[name="acceptreject"]:checked').value;
    let pasfail = document.querySelector('input[name="passedfailed"]:checked').value;

    let accept;
    let reject;
    let pass;
    let fail;
    let payed;

    if (document.querySelector('input[name="payed"]:checked')){
        payed = true;
    } else {
        payed = false;
    }

    if (accrej == "Accept"){
        accept = true;
        reject = false;
    } else {
        accept = false;
        reject = true;
    }

    if (pasfail == "Passed"){
        pass = true;
        fail = false;
    } else {
        pass = false;
        fail = true;
    }

    let update = {
        appid: document.getElementById('applicationid').value,
        empid: document.getElementById('employeeid').value,
        appaccept: accept,
        appreject: reject,
        comment: document.getElementById('comment').value,
        grapass: pass,
        grafail: fail,
        payed: payed
    }

    console.log(update);

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(update)

    });

}
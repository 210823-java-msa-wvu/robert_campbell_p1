async function deptheadupdate(){

    console.log("hello from deptheadupdate");

    let url = "http://localhost:8080/project1/deptheadupdate";

    let accrej = document.querySelector('input[name="acceptreject"]:checked').value;

    let accept;
    let reject;

    

    if (accrej == "Accept"){
        accept = true;
        reject = false;
    } else {
        accept = false;
        reject = true;
    }



    let update = {
        appid: document.getElementById('applicationid').value,
        empid: document.getElementById('employeeid').value,
        appaccept: accept,
        appreject: reject,
        comment: document.getElementById('comment').value,
    }

    console.log(update);

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(update)

    });

}
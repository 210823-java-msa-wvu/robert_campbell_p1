async function suplogin(){

    let url = "http://localhost:8080/project1/suplogin";

    let user = {
        username: document.getElementById('supervisor_username').value,
        password: document.getElementById('supervisor_password').value,
        position: "supervisor"
    }

    console.log(user);
    console.log(JSON.stringify(user))

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    });

    let resJson = await res.json()

    .then(userData => {
        console.log("mine turtle");
        console.log(userData);
        document.cookie = JSON.stringify(userData);
        let x = document.cookie;
        console.log("x= " + x);
        document.cookie.assign
        window.location.assign("/project1/static/SupervisorHomePage.html");
    })
    .catch(error => {
        console.log("hello from error")
        console.log(error);
    })
}
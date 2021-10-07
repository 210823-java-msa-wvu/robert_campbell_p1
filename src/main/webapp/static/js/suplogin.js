async function suplogin(){

    let url = "http://localhost:8080/Project1/suplogin";

    let user = {
        username: document.getElementById('supervisor_username').value,
        password: document.getElementById('supervisor_password').value
    }

    console.log(user);

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    });

    let resJson = await res.json()
    .then(res => {
        console.log(res);
    })
    .catch(error => {
        console.log(error);
    })
}
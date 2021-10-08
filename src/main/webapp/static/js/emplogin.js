async function emplogin(){

    console.log("hello");

    let url = "http://localhost:8080/project1/emplogin";

    let user = {
        username: document.getElementById('employee_username').value,
        password: document.getElementById('employee_password').value,
        position: "employee"
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
        console.log(x);
        document.cookie.assign
        window.location.assign("/project1/static/EmployeeHomePage.html");
    })
    .catch(error => {
        console.log("hello from error")
        console.log(error);
    })
}

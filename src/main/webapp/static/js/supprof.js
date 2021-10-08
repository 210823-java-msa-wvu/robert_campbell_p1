function supprof() {
    let supprof = JSON.parse(document.cookie);
    console.log(supprof);
    console.log(supprof.firstName);

    document.getElementById("firstname").innerHTML = `First name: ${supprof.firstName}`;
    document.getElementById("lastname").innerHTML = `Last name: ${supprof.lastName}`;
    document.getElementById("username").innerHTML = `Username: ${supprof.username}`;
    document.getElementById("position").innerHTML = `Position: ${supprof.position}`;
    document.getElementById("email").innerHTML = `Email: ${supprof.email}`;
}
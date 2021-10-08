function empprof() {
    let empprof = JSON.parse(document.cookie);
    console.log(empprof);
    console.log(empprof.firstName);

    document.getElementById("firstname").innerHTML = `First name: ${empprof.firstName}`;
    document.getElementById("lastname").innerHTML = `Last name: ${empprof.lastName}`;
    document.getElementById("username").innerHTML = `Username: ${empprof.username}`;
    document.getElementById("reimbursement").innerHTML = `Reimbursement remaining: ${empprof.reimbursement}`;
    document.getElementById("email").innerHTML = `Email: ${empprof.email}`;
}
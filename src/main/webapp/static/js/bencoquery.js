async function bencoquery(){

    console.log("hello from bencoquery");

    let supprof = JSON.parse(document.cookie);

    let url = "http://localhost:8080/project1/bencoquery";

    let position = {
        position: supprof.position
    }

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(position)

    });

    let resJson = await res.json()

    .then(userData => {
        console.log("mine turtle");
        console.log(userData);



        populateData(userData);
    })
    .catch(error => {
        console.log("hello from error")
        console.log(error);
    })

    function populateData(res){
        var col = [];
        for (var i = 0; i < res.length; i++){
            for (var key in res[i]) {
                if (col.indexOf(key)=== -1){
                    col.push(key);
                }
            }
        }

        var table = document.createElement("table");
        var tr = table.insertRow(-1);

        for (var i = 0; i < col.length; i++){
            var th = document.createElement("th");
            th.innerHTML = col[i];
            tr.appendChild(th);
        }

        for (var i = 0; i < res.length; i++){

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length; j++){
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML = res[i][col[j]];
            }
        }

        var divContainer = document.getElementById("apps");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    
    }
}
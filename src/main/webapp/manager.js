async function reimbList(){


	let res = await fetch("http://localhost:8080/ERS/manager",{ 
				method: "POST",
				headers:{
					"Content-Type": "application/json"
				}
	});

    const data = await res.json();
    console.log(data);

    for (key in data){
        let table = document.getElementById("reimbTable");
        let row = table.insertRow(1);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);

        let stat = "";

        if (data[key].reimb_status_id == 1) {
            stat = "Approved";
        } else if (data[key].reimb_status_id == 2) {
            stat = "Rejected";
        } else {
            stat = "Pending";
        }
        cell1.innerHTML = data[key].reimb_id;
        cell2.innerHTML = data[key].reimb_amount;
        cell3.innerHTML = data[key].reimb_description;
        cell4.innerHTML = stat;
    }
    

}

async function approve(){

    let reimb_id = document.getElementById("id-input").value;

    const data = {
        reimb_id
    };

    try{

        let res = await fetch("http://localhost:8080/ERS/approve",{
            method:"POST",
            body: JSON.stringify(data),
            headers:{
                "Content-Type" : "application/json"
            }
        });

        console.log(res);


        window.location.href = "./manager.html";

    } catch( e) {
        console.log(e);
    }
}

async function reject(){

    let reimb_id = document.getElementById("id-input").value;

    const data = {
        reimb_id
    };

    try{

        let res = await fetch("http://localhost:8080/ERS/reject",{
            method:"POST",
            body: JSON.stringify(data),
            headers:{
                "Content-Type" : "application/json"
            }
        });

        console.log(res);

        window.location.href = "./manager.html";

    } catch( e) {
        console.log(e);
    }
}

if(document.getElementById('approve-button').clicked == true)
{
  approve();
}

if(document.getElementById('reject-button').clicked == true)
{
  reject();
}

document.onload = reimbList();
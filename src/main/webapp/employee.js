async function reimbList(){


	let res = await fetch("http://localhost:8080/ERS/list",{ 
				method: "POST",
				headers:{
					"Content-Type": "application/json"
				}
	});

    const user = await res.json();

    for (key in user){
        let table = document.getElementById("reimbTable");
        let row = table.insertRow(1);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);

        let stat = "";

        if (user[key].reimb_status_id == 1) {
            stat = "Approved";
        } else if (user[key].reimb_status_id == 2) {
            stat = "Rejected";
        } else {
            stat = "Pending";
        }
        cell1.innerHTML = user[key].reimb_id;
        cell2.innerHTML = user[key].reimb_amount;
        cell3.innerHTML = user[key].reimb_description;
        cell4.innerHTML = stat;
    }
    

}

document.onload = reimbList();
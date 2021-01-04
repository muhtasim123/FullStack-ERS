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
        let cell5 = row.insertCell(4);
        let cell6 = row.insertCell(5);

        let stat = "";

        //let linkApp = document.createElement("a");
        //linkApp.setAttribute("href", "./manager")

        //let linkRej = document.createElement("a");
        //linkRej.setAttribute("href", "./manager")


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
        cell5.innerHTML = "Accept";
        cell6.innerHTML = "Reject";
    }
    

}

document.onload = reimbList();
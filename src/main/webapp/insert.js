async function reimbSubmit(e){
    e.preventDefault();

    let reimb_amount = document.getElementById("amount-input").value;
    let reimb_submitted = document.getElementById("date-input").value;
    let reimb_description = document.getElementById("description-input").value;
    let reimb_receipt = document.getElementById("receipt-input").value;
    let reimb_type_id = document.getElementById("type-input").value;

    const data = {
        reimb_amount,
        reimb_submitted,
        reimb_description,
        reimb_receipt,
        reimb_type_id
    };

    try{

        let res = await fetch("http://localhost:8080/ERS/insert",{
            method:"POST",
            body: JSON.stringify(data),
            headers:{
                "Content-Type" : "application/json"
            }
        });

        window.location.href = "./employee.html";

    } catch( e) {
        console.log(e);
    }
}


document.getElementsByTagName("form")[0].addEventListener('submit', reimbSubmit)
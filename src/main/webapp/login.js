async function loginSubmit(e){
    e.preventDefault();

    let username = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    const credentials = {
        username,
        password
    }

    try{

        let res = await fetch("http://localhost:8080/ERS/login",{
            method:"POST",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })

        let user = await res.json()
        
        if (user.user_role_id == 1) {
            window.location.href = "./employee.html";
        } else if (user.user_role_id == 2){
            window.location.href = "./manager.html";
        } else {
            window.location.href = "./login.html" 
        }

    } catch( e) {
        console.log(e);
    }
}


document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)
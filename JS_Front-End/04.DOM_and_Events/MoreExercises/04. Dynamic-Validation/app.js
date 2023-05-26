function validate() {
    let inputField = document.getElementById('email');

    inputField.addEventListener('change', validationEmail);

    function validationEmail(event){
        const regex = /^[a-z]+@[a-z]+\.[a-z]+$/g;
        const email = event.target;

     
        if(!regex.test(email.value)){
            email.classList.add('error');
        }else{
            email.classList.remove('error');
        }
        
    }
}
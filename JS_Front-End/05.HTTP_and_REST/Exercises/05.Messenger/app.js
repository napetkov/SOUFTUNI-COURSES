function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/messenger/'
    const inputAuthorField = document.querySelector("#controls > div:nth-child(1) > input[type=text]");
    const inputMassageField = document.querySelector("#controls > div:nth-child(2) > input[type=text]");
    const sendBtn = document.getElementById('submit');
    const refreshBtn = document.getElementById('refresh');
    const textAreaMassages = document.getElementById('messages');

    sendBtn.addEventListener('click', submitNewMassageHandler);
    refreshBtn.addEventListener('click', loadAllMassagesHandler);

    function loadAllMassagesHandler(){
        textAreaMassages.value = '';
        fetch(BASE_URL)
        .then((res) => res.json())
        .then((data) =>{
           const massages = Object.values(data);

           for (let i = 0; i < massages.length-1; i++) {
            textAreaMassages.value += `${massages[i].author}: ${massages[i].content}\n`;
           }
           textAreaMassages.value += `${massages[massages.length-1].author}: ${massages[massages.length-1].content}`
        })
        .catch((err) => console.error(err));
    }


    function submitNewMassageHandler(){
        htmlHeader = {
            method:'POST',
            body: JSON.stringify({
                author: inputAuthorField.value,
                content: inputMassageField.value,
            })
        }
    fetch(BASE_URL,htmlHeader)
        .then(() => console.log('SEND Massage'))
        .catch((err) => console.error(err));
    }
    inputAuthorField.value = '';
    inputMassageField.value = '';
    
}

attachEvents();
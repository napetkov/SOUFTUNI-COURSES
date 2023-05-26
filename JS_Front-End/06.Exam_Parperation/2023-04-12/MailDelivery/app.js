function solve() {

    const inputDOMSelectors = {
        recipientName: document.getElementById('recipientName'),
        title: document.getElementById('title'),
        message: document.getElementById('message'),
    }

    const otherDOMSelectors = {
        addBtn: document.getElementById('add'),
        listMails: document.getElementById("list"),
        resetBtn: document.getElementById('reset'),
        sendMailsList: document.querySelector("body > section > article > div.sent-mails > ul"),
        deleteMailList: document.querySelector("body > section > article > div.trash > ul"),
    }

    const mailInfoStatus = {
        recipientName: null,
        title: null,
        message: null,
    }

  
    otherDOMSelectors.addBtn.addEventListener("click", addToListHandler);
    otherDOMSelectors.resetBtn.addEventListener("click", resetInputFieldsHandler);


    function resetInputFieldsHandler(event){
        if(event){
            event.preventDefault();
            Object.values(inputDOMSelectors).map((input) => input.value = '');
        }
    }

    function addToListHandler(event){
        if(event){
            event.preventDefault();
    
        const noEmptyInputFields = Object.values(inputDOMSelectors)
                    .every((input) => input.value !== '');

        if(noEmptyInputFields){
            for (const key in inputDOMSelectors) {
               mailInfoStatus[key] = inputDOMSelectors[key].value;
            }
    
            const li = createElement('li', otherDOMSelectors.listMails);
            createElement('h4', li, `Title: ${inputDOMSelectors.title.value}`);
            createElement('h4', li, `Recipient Name: ${inputDOMSelectors.recipientName.value}`);
            createElement('span', li, inputDOMSelectors.message.value);
            const divButContainer = createElement('div', li, null, null,'list-action');
            const sendBtn = createElement('button', divButContainer, 'Send', null, 'send', {type:'submit'});
            const deleteBtn = createElement('button', divButContainer, 'Delete', null, 'delete', {type:'submit'});

            sendBtn.addEventListener("click", sendEmailHandler);
            deleteBtn.addEventListener("click", deleteEmailHandlerFromListMails);

            Object.values(inputDOMSelectors).map((input) => input.value = "");
        }else {
            console.log('PEASE FILL ALL INPUT FIELDS!!!');
        }
    }
    }

    function deleteEmailHandlerFromListMails(){
        const liParent = this.parentNode.parentNode;
    }

    function sendEmailHandler(){
        const liParent = this.parentNode.parentNode;
        const title = liParent.children[0].textContent;
        const recipientName = liParent.children[1].textContent;

        const li = createElement('li', otherDOMSelectors.sendMailsList);
        createElement('span', li, `To: ${mailInfoStatus.recipientName}`);
        createElement('span', li, `Title: ${mailInfoStatus.title}`);
        const divBtnContainer = createElement('div', li, null, ['btn']);
        const deleteBtn = createElement('button', divBtnContainer, 'Delete', ['delete'], null, {type: 'submit'});

        deleteBtn.addEventListener("click", deleteEmailHandlerFromListMails);
        liParent.remove();
    }

    function deleteEmailHandlerFromListMails(){
        const liParent = this.parentNode.parentNode;
        const li = createElement('li', otherDOMSelectors.deleteMailList);
        createElement('span', li, `To: ${mailInfoStatus.recipientName}`);
        createElement('span', li, `Title: ${mailInfoStatus.title}`);


        liParent.remove();
    }

    function createElement(
        type,
        parentNode,
        content,
        classes,
        id,
        attributes,
        useInnerHTML
      ) {
        const htmlElement = document.createElement(type);
      
        if (content && useInnerHTML) {
          htmlElement.innerHTML = content;
        }
      
        if (content && type === "input") {
          htmlElement.value = content;
        }
      
        if (content && type !== "input") {
          htmlElement.textContent = content;
        }
      
        if (classes && classes.length > 0) {
          htmlElement.classList.add(...classes);
        }
      
        if (id) {
          htmlElement.id = id;
        }
      
        if (attributes) {
          for (const key in attributes) {
            htmlElement.setAttribute(key, attributes[key]);
          }
        }
      
        if (parentNode) {
          parentNode.appendChild(htmlElement);
        }
      
        return htmlElement;
      }

}
solve()
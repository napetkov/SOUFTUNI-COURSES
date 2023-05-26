function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';

    const inputTitle = document.getElementById('title');

    const otherDOMSelectors = {
        addBtn: document.getElementById('add-button'),
        loadAllBtn: document.getElementById('load-button'),
        todoListContainer: document.getElementById('todo-list'),
}
    
    otherDOMSelectors.loadAllBtn.addEventListener('click', loadAllTasksHandler);
    otherDOMSelectors.addBtn.addEventListener('click', addTaskHandler);


    function addTaskHandler(event){
        if(event){
            event.preventDefault();
        }

        const httpHeader = {
            method: 'POST',
            body: JSON.stringify({
                name: inputTitle.value,
            })
        }

        fetch(BASE_URL,httpHeader)
            .then(() => {
                inputTitle.value = '';
                loadAllTasksHandler();
            })
            .catch((err) => console.error(err));
    }

    function loadAllTasksHandler(event){
        if(event){
            event.preventDefault();
        }

        otherDOMSelectors.todoListContainer.innerHTML = '';

        fetch(BASE_URL)
            .then((res) => res.json())
            .then((data) =>{
                Object.values(data).forEach((task) =>{
                    const li = createElement('li', otherDOMSelectors.todoListContainer, null, null, task._id)
                    createElement('span', li, `${task.name}`)
                    
                    const removeBtn = createElement('button', li, 'Remove');
                    removeBtn.addEventListener('click', removeTaskHandler)

                    const editBtn = createElement('button', li, 'Edit');
                    editBtn.addEventListener('click', editTaskHandler);
                })

            })
            .catch((err) => console.error(err));
    }

    function editTaskHandler(){
        const liParent = this.parentNode;
        const task = liParent.children[0];
        const inputForEditing = createElement('input',liParent, task.textContent);
        liParent.insertBefore(inputForEditing,this.previousSibling);
        this.remove();
        const submitBtn = createElement('button', liParent, 'Submit');
        submitBtn.addEventListener('click', submitEditedTaskHandler);

        task.remove();
    }

    function submitEditedTaskHandler(){
        const liParent = this.parentNode;
        const taskId = liParent.id;
        const httpHeader = {
            method: 'PATCH',
            body: JSON.stringify({
                name: liParent.children[0].value,
            })
        }
        fetch(`${BASE_URL}${taskId}`,httpHeader)
        .then(() => loadAllTasksHandler())
        .catch((err) => console.error(err));
    }

    function removeTaskHandler(){
        const liParent = this.parentNode;
        const taskId = liParent.id;
    
        fetch(`${BASE_URL}${taskId}`,{method: 'DELETE'})
        .then(() => loadAllTasksHandler())
        .catch((err) => console.error(err));
        
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

attachEvents();

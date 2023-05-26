// TODO:
function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  const inputDOMSelectors = {
    title: document.getElementById("title"),
    description: document.getElementById('description'),
  };

  const loadBtn = document.getElementById("load-board-btn");
  const addBtn = document.getElementById('create-task-btn');

  const taskContainers = {
    toDoContainer: document.querySelector("#todo-section > ul"),
    inProgressContainer: document.querySelector("#in-progress-section > ul"),
    codeReviewContainer: document.querySelector("#code-review-section > ul"),
    doneContainer: document.querySelector("#done-section > ul"),
  };

  loadBtn.addEventListener("click", loadTheBoardHandler);
  addBtn.addEventListener("click", addTaskHandler);

  function addTaskHandler(){
    httpHeader = {
        method: 'POST',
        body: JSON.stringify({
            title: inputDOMSelectors.title.value,
            description: inputDOMSelectors.description.value,
            status: 'ToDo',
        })
    }
    fetch(BASE_URL,httpHeader)
        .then(() => loadTheBoardHandler())
        .catch((err) => console.error(err));

    Object.values(inputDOMSelectors).map((input) => input.value ="");
  }

  function loadTheBoardHandler() {
    Object.values(taskContainers).map((container) => container.innerHTML = '');

    fetch(BASE_URL)
      .then((res) => res.json())
      .then((data) => {
        for (const task of Object.values(data)) {
          const { description, status, title, _id } = task;
          const li = createElement('li',null,null,['task'], _id);
          createElement('h3', li, title);
          createElement('p', li, description)
          

          switch (status) {
            case "ToDo":
            const todoBtn = createElement('button',li,'Move to In Progress');    
            taskContainers.toDoContainer.appendChild(li);
            todoBtn.addEventListener('click', moveTaskHandler);
            
              break;
            case "In Progress":
                const inProgressBtn = createElement('button',li,'Move to Code Review');    
                taskContainers.inProgressContainer.appendChild(li);
                inProgressBtn.addEventListener('click', moveTaskHandler);
                
              break;
            case "Code Review":
                const codeReviewBtn = createElement('button',li,'Move to Done');    
                taskContainers.codeReviewContainer.appendChild(li);
                codeReviewBtn.addEventListener('click', moveTaskHandler);
               
              break;
            case "Done":
                const doneBtn = createElement('button',li,'Close');    
                taskContainers.doneContainer.appendChild(li);
                doneBtn.addEventListener('click', moveTaskHandler);
              break;
          }
        }
      })
      .catch((err) => console.error(err));
  }

  function moveTaskHandler(){
    const liParent = this.parentNode;
    const id = liParent.id;
    const btnContent = this.textContent
    let status = '';

    if(btnContent === 'Move to In Progress'){
        taskContainers.inProgressContainer.appendChild(liParent);
        this.textContent = 'Move to Code Review';
        status = 'In Progress';
    }else if(btnContent === 'Move to Code Review'){
        taskContainers.codeReviewContainer.appendChild(liParent);
        this.textContent = 'Move to Done';
        status = 'Code Review';
    }else if(btnContent === 'Move to Done'){
        taskContainers.doneContainer.appendChild(liParent);
        this.textContent = 'Close';
        status = 'Done';
    }else if(btnContent === 'Close'){
        liParent.remove();
    }
    if(btnContent === 'Close'){
        httpHeader = {
            method: 'DELETE',
        }
    }else{
        httpHeader = {
            method: 'PATCH',
            body: JSON.stringify({status})
          };
    }

      fetch(`${BASE_URL}${id}`,httpHeader)
        .then(() => loadTheBoardHandler())
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

function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  const titleInput = document.getElementById("title");
  const addBtn = document.getElementById("add-button");
  const loadBtn = document.getElementById("load-button");
  const todoListContainer = document.getElementById("todo-list");

  addBtn.addEventListener("click", addTasksHandler);
  loadBtn.addEventListener("click", loadTasksHandler);

  function loadTasksHandler(event) {
    if(event){
    event.preventDefault();
    }
    todoListContainer.innerHTML = "";

    fetch(BASE_URL)
      .then((res) => res.json())
      .then((data) => {
        const tasks = Object.values(data);

        for (const { name, _id } of tasks) {
          const li = document.createElement("li");
          li.id = _id;
          const span = document.createElement("span");
          span.textContent = name;
          li.appendChild(span);
          
          const removeBtn = document.createElement("button");
          removeBtn.textContent = "Remove";
          removeBtn.addEventListener('click', removeTaskHandler);
          li.appendChild(removeBtn);
          
          const editBtn = document.createElement("button");
          editBtn.textContent = "Edit";
          editBtn.addEventListener("click", loadEditFormHandler);

          li.appendChild(editBtn);
          todoListContainer.appendChild(li);
        }
      })
      .catch((err) => console.error(err));
  }

  function removeTaskHandler(event){
    const liParent = event.currentTarget.parentNode;
    const id = liParent.id;
    
    const httpHeader = {
        method: 'DELETE',
    }

    fetch(`${BASE_URL}${id}`, httpHeader)
        .then(() => loadTasksHandler())
        .catch((err) =>{
            console.error(err);
        })

        liParent.remove();

  }

  function loadEditFormHandler(event) {
    const liParent = event.currentTarget.parentNode;
    [span, _removeBtn, editBtn] = Array.from(liParent.children);
    const editInput = document.createElement("input");
    editInput.value = span.textContent;
    liParent.prepend(editInput);
    span.remove();
    const submitBtn = document.createElement("button");
    submitBtn.textContent = "Submit";
    liParent.appendChild(submitBtn);
    editBtn.remove();

    submitBtn.addEventListener("click", submitTaskHandler);
  }

  function submitTaskHandler(event){
      const liParent = event.currentTarget.parentNode;
    const id = liParent.id;
    [ input, _removeBtn, submitBtn] = Array.from(liParent.children);

    const httpHeaders = {
        method: 'PATCH',
        body: JSON.stringify({name: input.value})
    }

    fetch(`${BASE_URL}${id}`,httpHeaders)
       .then(() => loadTasksHandler())
    .catch((err) =>{
        console.error(err);
    })
    

  }

  function addTasksHandler(event) {
    if(event){
        event.preventDefault();
    }

    const httpHeader = {
        method: 'POST',
        body: JSON.stringify({name:titleInput.value})
    }

    fetch(BASE_URL,httpHeader)
        .then(() => {
            loadTasksHandler()
        })
        .catch((err) =>{
            console.error(err);
        })
        titleInput.value = '';
  }
}

attachEvents();

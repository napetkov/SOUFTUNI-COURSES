window.addEventListener("load", solve);

function solve() {
    const inputDOMSelectors = {
        taskTitle: document.getElementById('task-title'),
        taskCategory: document.getElementById('task-category'),
        taskContent: document.getElementById('task-content')
    }

    const otherDOMSelectors = {
        publishBtn: document.getElementById('publish-btn'),
        taskReviewContainer: document.getElementById('review-list'),
        publishedListContainer: document.getElementById('published-list'),
    }

    const taskInfoStatus = {
        taskTitle: null,
        taskCategory: null,
        taskContent: null,
    }

    otherDOMSelectors.publishBtn.addEventListener('click', publishTaskHandler);

    function publishTaskHandler(){
        const noEmptyInputFields = Object.values(inputDOMSelectors).every((input) => input.value !== '');

        if(noEmptyInputFields){
            for (const key in inputDOMSelectors) {
               taskInfoStatus[key] = inputDOMSelectors[key].value;
            }

        const li = createElement('li', otherDOMSelectors.taskReviewContainer, null, ['rpost']);
        const article = createElement('article', li,);
        createElement('h4', article, inputDOMSelectors.taskTitle.value);
        createElement('p', article, `Category: ${inputDOMSelectors.taskCategory.value}`);
        createElement('p', article, `Content: ${inputDOMSelectors.taskContent.value}`);
        
        const editBtn = createElement('button', li, 'Edit', ['action-btn', 'edit']);
        editBtn.addEventListener('click', editTaskHandler);
        
        const postBtn = createElement('button', li, 'Post', ['action-btn', 'post']);
        postBtn.addEventListener('click', postTaskHandler);


        Object.values(inputDOMSelectors).map((input) => input.value = '');
        }else {
            console.log('PLEASE FILL ALL INPUT FIELDS');
        }

    }

    function postTaskHandler(){
        const liParent = this.parentNode;
        otherDOMSelectors.publishedListContainer.appendChild(liParent);
        this.previousSibling.remove();
        this.remove();


    }

    function editTaskHandler(){
        for (const key in taskInfoStatus) {
          inputDOMSelectors[key].value = taskInfoStatus[key];
        }

        this.parentNode.remove();
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
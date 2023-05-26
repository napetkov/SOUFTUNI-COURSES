window.addEventListener('load', solve);

function solve() {
    let taskIdCounter = 1;
    let totalPoints = 0;
        const inputDOMSelectors = {
        title: document.getElementById('title'),
        description: document.getElementById('description'),
        label: document.getElementById('label'),
        points: document.getElementById('points'),
        assignee: document.getElementById('assignee'),
    }
    
    let hiddenInput = document.getElementById("task-id");
    
    let taskInfoStatus = {
        title: null,
        description: null,
        label: null,
        points: null,
        assignee: null,
    }

    const otherDOMSelectors = {
        createTaskBtn: document.getElementById('create-task-btn'),
        taskSection: document.getElementById('tasks-section'),
        totalPointParagraph: document.getElementById('total-sprint-points'),
        deleteTaskBtn: document.getElementById('delete-task-btn'),
    }

    otherDOMSelectors.createTaskBtn.addEventListener("click", creteTaskHandler);
    otherDOMSelectors.deleteTaskBtn.addEventListener("click", deleteTaskFromDOMHandler);
    function creteTaskHandler(){
        const noInputEmpty = Object.values(inputDOMSelectors)
                .every((input) => input.value !== "");
                
        if(noInputEmpty){
                      
            let iconInnerHTML = "";
        let labelClassName = ";"
            switch(inputDOMSelectors.label.value){
            case 'Feature': 
                iconInnerHTML = ' &#8865';
                labelClassName = 'feature';
                break;
            case 'Low Priority Bug': 
                iconInnerHTML = ' &#9737';
                labelClassName = 'low-priority';
                break;
            case 'High Priority Bug':
                iconInnerHTML = ' &#9888'; 
                labelClassName = 'high-priority';   
                break;              
            }

            for (const key in inputDOMSelectors) {
               taskInfoStatus[key] = inputDOMSelectors[key].value;
            }

            const article = createElement('article',otherDOMSelectors.taskSection, null,['task-card'],`task-${taskIdCounter}`);
            const divLabel = createElement('div', article,inputDOMSelectors.label.value, ['task-card-label',labelClassName]);
            const spanIcon = createElement('span');
            spanIcon.innerHTML = iconInnerHTML;
            divLabel.appendChild(spanIcon);
            createElement('h3',article,inputDOMSelectors.title.value,['task-card-title']);
            createElement('p',article,inputDOMSelectors.description.value,['task-card-description']);
            createElement('div',article, `Estimated at ${inputDOMSelectors.points.value} pts`, ['task-card-points']);
            createElement('div', article, `Assigned to: ${inputDOMSelectors.assignee.value}`,['task-card-assignee']);
            const buttonContainer = createElement('div', article, null, ['task-card-actions']);
            totalPoints += Number(inputDOMSelectors.points.value);
            otherDOMSelectors.totalPointParagraph.textContent = `Total points ${totalPoints}pts`;

            const deleteBtn = createElement("button", buttonContainer, 'Delete');
            deleteBtn.addEventListener("click", deleteTaskHandler);

            taskIdCounter ++;
            Object.values(inputDOMSelectors).map((input) => input.value = "");

        }else {
            console.log('PLEASE FILL ALL INPUT FIELDS');
        }

    }

    function deleteTaskFromDOMHandler(){
        let idToDeleteTask = hiddenInput.id;
        const allTasks = otherDOMSelectors.taskSection.children;
        let taskToDelete = Object.values(allTasks).find((task) => task.id === idToDeleteTask);
        let pointsOfTaskToRemove = inputDOMSelectors.points.value; 
        taskToDelete.remove();
        Object.values(inputDOMSelectors).map((input) =>{
            input.value = "";
            input.removeAttribute('disabled');
        })
        totalPoints -= pointsOfTaskToRemove;
        otherDOMSelectors.totalPointParagraph.textContent = `Total points ${totalPoints}pts`;
        otherDOMSelectors.createTaskBtn.removeAttribute('disabled');
        otherDOMSelectors.deleteTaskBtn.setAttribute('disabled',true);
    }

    function deleteTaskHandler(){
        for (const key in taskInfoStatus) {
            inputDOMSelectors[key].value = taskInfoStatus[key];
        }
        otherDOMSelectors.deleteTaskBtn.removeAttribute('disabled');
        otherDOMSelectors.createTaskBtn.setAttribute('disabled',true);
        const taskId = this.parentNode.parentNode.id;
        Object.values(inputDOMSelectors).map((input) => input.setAttribute('disabled', true));
        
        hiddenInput.id = taskId;
       
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
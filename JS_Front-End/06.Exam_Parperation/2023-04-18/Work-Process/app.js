function solve() {
    let budgetSum = 0;

    const inputDOMSelectors = {
        firstName: document.getElementById('fname'),
        lastName: document.getElementById('lname'),
        email: document.getElementById('email'),
        dateOfBirth: document.getElementById('birth'),
        position: document.getElementById('position'),
        salary: document.getElementById('salary'),
    }

    const otherDOMSlectors = {
        hireBtn: document.getElementById('add-worker'),
        tbody: document.getElementById('tbody'),
        budgetSpan: document.getElementById('sum'),
    }

     otherDOMSlectors.hireBtn.addEventListener('click', addWorkerHandler);

    function addWorkerHandler(event){
        if(event){
            event.preventDefault();
        }
        const noEmptyInputFields = Object.values(inputDOMSelectors)
        .every((input) => input.value !== '');

        if(noEmptyInputFields){
            const tr = createElement('tr', otherDOMSlectors.tbody);
            createElement('td', tr, inputDOMSelectors.firstName.value);
            createElement('td', tr, inputDOMSelectors.lastName.value);
            createElement('td', tr, inputDOMSelectors.email.value);
            createElement('td', tr, inputDOMSelectors.dateOfBirth.value);
            createElement('td', tr, inputDOMSelectors.position.value);
            createElement('td', tr, inputDOMSelectors.salary.value);
            const firedBtn = createElement('button', tr, 'Fired', ['fired']);
            firedBtn.addEventListener('click', firedWorkerHandler);

            const editBtn = createElement('button', tr, 'Edit', ['edit']);
            editBtn.addEventListener('click', editWorkerInfoHandler);
            
            budgetSum += Number(inputDOMSelectors.salary.value);
            otherDOMSlectors.budgetSpan.textContent = budgetSum.toFixed(2);
            Object.values(inputDOMSelectors).map((input) => input.value = '');

        }else{
            console.log('PLEASE, FILL ALL INPUT FIELDS!!!');
        }
        



    }

    function firedWorkerHandler(){
        const currentSalary = Number(this.previousSibling.textContent);
        budgetSum -= currentSalary;
        otherDOMSlectors.budgetSpan.textContent = budgetSum.toFixed(2);

        this.parentNode.remove();
    }

    function editWorkerInfoHandler(){
        const workerInfoForEdit = this.parentNode.children;

        inputDOMSelectors.firstName.value = workerInfoForEdit[0].textContent;
        inputDOMSelectors.lastName.value = workerInfoForEdit[1].textContent;
        inputDOMSelectors.email.value = workerInfoForEdit[2].textContent;
        inputDOMSelectors.dateOfBirth.value = workerInfoForEdit[3].textContent;
        inputDOMSelectors.position.value = workerInfoForEdit[4].textContent;
        inputDOMSelectors.salary.value = Number(workerInfoForEdit[5].textContent);

        budgetSum -= Number(workerInfoForEdit[5].textContent);
        otherDOMSlectors.budgetSpan.textContent = budgetSum.toFixed(2);

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
solve()
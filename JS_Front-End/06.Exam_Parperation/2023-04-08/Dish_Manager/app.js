window.addEventListener("load", solve);

function solve() {

  const inputDOMSelectors = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById('last-name'),
    age: document.getElementById('age'),
    gender: document.getElementById('genderSelect'),
    task: document.getElementById('task'),
  }

  const otherDOMSelectors = {
    submitBtn: document.getElementById('form-btn'),
    ulInprogressContainer: document.getElementById("in-progress"),
    spanDishesInProgressCount: document.getElementById("progress-count"),
    ulFinishedContainer: document.getElementById('finished'),
    clearBtn: document.getElementById('clear-btn'),
  }

  let dishesInfoStatus = {
    firstName: null,
    lastName: null,
    age: null,
    gender: null,
    task: null,
  }

  let dishesInProgressCount = 0;
  

  otherDOMSelectors.submitBtn.addEventListener('click', submitDishManagerInfoHandler);
  otherDOMSelectors.clearBtn.addEventListener('click', clearAllDishesHandler);

  function clearAllDishesHandler(){
     otherDOMSelectors.ulFinishedContainer.innerHTML = '';
    otherDOMSelectors.spanDishesInProgressCount.textContent = 0;
  }

  function submitDishManagerInfoHandler(){
    const noInputFieldEmpty = Object.values(inputDOMSelectors)
            .every((input) => input.value !== '');

    if(noInputFieldEmpty){
      for (const key in inputDOMSelectors) {
       dishesInfoStatus[key] = inputDOMSelectors[key].value;
    }
    const li = createElement('li', otherDOMSelectors.ulInprogressContainer, null, ['each-line']);
    const article = createElement('article', li,);
    createElement('h4', article, `${inputDOMSelectors.firstName.value} ${inputDOMSelectors.lastName.value}`);
    createElement('p', article, `${inputDOMSelectors.gender.value}, ${inputDOMSelectors.age.value}`);
    createElement('p', article, `Dish description: ${inputDOMSelectors.task.value}`);
    const editBtn = createElement('button', article, 'Edit', ['edit-btn']);
    const completeBtn = createElement('button', article, 'Mark as complete', ['complete-btn']);

    editBtn.addEventListener('click', editDishManagerInfoHandler);
    completeBtn.addEventListener('click', completeDishHandler);



      dishesInProgressCount += 1;
      Object.values(inputDOMSelectors).map((input) => input.value = '');
      otherDOMSelectors.spanDishesInProgressCount.textContent = dishesInProgressCount;
    }else {
      console.log('PLEASE FILL ALL INPUT FIELDS!')
    }


  }

  function completeDishHandler(){
    const liParent = this.parentNode.parentNode;
    otherDOMSelectors.ulFinishedContainer.appendChild(liParent);
    this.previousSibling.remove();
    this.remove();
    decreaseDishStillInProgress();

  }

  function editDishManagerInfoHandler(){
    for (const key in dishesInfoStatus) {
      inputDOMSelectors[key].value = dishesInfoStatus[key];
    }
    this.parentNode.parentNode.remove();
    decreaseDishStillInProgress();
  }

  function decreaseDishStillInProgress(){
    dishesInProgressCount --;
    otherDOMSelectors.spanDishesInProgressCount.textContent = dishesInProgressCount;
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

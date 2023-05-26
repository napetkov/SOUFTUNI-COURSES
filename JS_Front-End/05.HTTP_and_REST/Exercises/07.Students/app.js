function attachEvents() {
  const BASE_URL = 'http://localhost:3030/jsonstore/collections/students/'
  const inputDOMSelectors = {
    firstName: document.querySelector("#form > div.inputs > input[type=text]:nth-child(1)"),
    lastName: document.querySelector("#form > div.inputs > input[type=text]:nth-child(2)"),
    facultyNumber: document.querySelector("#form > div.inputs > input[type=text]:nth-child(3)"),
    grade: document.querySelector("#form > div.inputs > input[type=text]:nth-child(4)"),
  }
  const tbody = document.querySelector("#results > tbody");
  const submitBtn = document.querySelector("#submit");

  submitBtn.addEventListener('click', createStudentHandler);

function loadAllStudents(){
  tbody.innerHTML = '';
  fetch(BASE_URL)
      .then((res) => res.json())
      .then((data) =>{
        const students = Object.values(data);

        for (const student of students) {
          const tr = createElement('tr', tbody);
          createElement('td', tr, student.firstName); 
          createElement('td', tr, student.lastName); 
          createElement('td', tr, student.facultyNumber); 
          createElement('td', tr, student.grade); 
        }
      })
      .catch((err) => console.error(err));
    }
    loadAllStudents();
  
  function createStudentHandler(){
    const htmlHeader = {
      method: 'POST',
      body: JSON.stringify({
        firstName: inputDOMSelectors.firstName.value,
        lastName: inputDOMSelectors.lastName.value,
        facultyNumber: inputDOMSelectors.facultyNumber.value,
        grade: inputDOMSelectors.grade.value,
      })
    }

    fetch(BASE_URL,htmlHeader)
      .then(() => loadAllStudents())
      .catch((err) => console.error(err));

      Object.values(inputDOMSelectors)
        .forEach((input) => input.value = '');
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
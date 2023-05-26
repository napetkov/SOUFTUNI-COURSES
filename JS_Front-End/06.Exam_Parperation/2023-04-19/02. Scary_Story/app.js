window.addEventListener("load", solve);

function solve() {
  
  const inputDOMSelectors = {
    firstName: document.getElementById('first-name'),
    lastName: document.getElementById('last-name'),
    age: document.getElementById('age'),
    storyTitle: document.getElementById('story-title'),
    genre: document.getElementById('genre'),
    yourStory: document.getElementById('story'),
  }

  const otherDOMSelectors = {
    publishBtn: document.getElementById('form-btn'),
    previewListContainer: document.getElementById("preview-list"),
    mainContainer: document.getElementById('main'),
  }

  const storyStatus = {
    firstName: null,
    lastName: null,
    age: null,
    storyTitle: null,
    genre: null,
    yourStory: null,
  }

  otherDOMSelectors.publishBtn.addEventListener('click', publishStoryHandler);

  function publishStoryHandler(){
    const noEmptyInputFields = Object.values(inputDOMSelectors).every((input) => input.value !== '');
    
    if(noEmptyInputFields){
      for (const key in inputDOMSelectors) {
        storyStatus[key] = inputDOMSelectors[key].value;
      }   
      
      const li = createElement('li', otherDOMSelectors.previewListContainer, null, ['story-info']);
      const article = createElement('article', li);
      createElement('h4', article, `Name: ${inputDOMSelectors.firstName.value} ${inputDOMSelectors.lastName.value}`);
      createElement('p', article, `Age: ${inputDOMSelectors.age.value}`);
      createElement('p', article, `Title: ${inputDOMSelectors.storyTitle.value}`);
      createElement('p', article, `Genre: ${inputDOMSelectors.genre.value}`);
      createElement('p', article, inputDOMSelectors.yourStory.value);

      const saveBtn = createElement('button', li, 'Save Story',['save-btn']);
      saveBtn.addEventListener('click', saveStoryHandler);

      const editBtn = createElement('button', li, 'Edit Story',['edit-btn']);
      editBtn.addEventListener('click', editStoryHandler);

      const deleteBtn = createElement('button', li, 'Delete Story',['delete-btn']);
      deleteBtn.addEventListener('click', deleteStoryHandler);

      otherDOMSelectors.publishBtn.setAttribute('disabled',true);
      Object.values(inputDOMSelectors).map((input) => input.value = '');

    }else {
      console.log('PLEASE FILL ALL INPUT FIELDS');
    }


  }

  function saveStoryHandler(){
    otherDOMSelectors.mainContainer.innerHTML = '';
    createElement('h1', otherDOMSelectors.mainContainer, 'Your scary story is saved!');
  }

  function deleteStoryHandler(){
    otherDOMSelectors.publishBtn.removeAttribute('disabled');
    this.parentNode.remove();
  }

  function editStoryHandler(){
    for (const key in storyStatus) {
      inputDOMSelectors[key].value = storyStatus[key];
    }
    otherDOMSelectors.publishBtn.removeAttribute('disabled');
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


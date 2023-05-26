window.addEventListener("load", solve);

function solve() {
  
const inputDOMSelectors = {
  title: document.getElementById('post-title'),
  category: document.getElementById('post-category'),
  content: document.getElementById('post-content'),
}

const otherDOMSelectors = {
  reviewListContainer: document.getElementById('review-list'),
  publishListContainer: document.getElementById('published-list'),
  publishBtn: document.getElementById('publish-btn'),
  clearBtn: document.getElementById('clear-btn'),
}

const postInfoStatus = {
  title: null,
  category: null,
  content: null,
}

otherDOMSelectors.publishBtn.addEventListener("click", publishPostHandler);
otherDOMSelectors.clearBtn.addEventListener("click", clearAllUploadedPostsHandler);

function clearAllUploadedPostsHandler(){
 this.previousElementSibling.innerHTML = "";
}


function publishPostHandler(){
const noEmptyInputFields = Object.values(inputDOMSelectors)
      .every((input) => input.value !== '');

if(noEmptyInputFields){
for (const key in inputDOMSelectors) {
  postInfoStatus[key] = inputDOMSelectors[key].value;
}

const li = createElement('li', otherDOMSelectors.reviewListContainer, null, ['rpost']);
const article = createElement('article', li);
createElement('h4',article, inputDOMSelectors.title.value);
createElement('p', article, `Category: ${inputDOMSelectors.category.value}`);
createElement('p',article,`Content: ${inputDOMSelectors.content.value}`);
const editBtn = createElement('button', li, 'Edit',['action-btn','edit']);
const approveBtn = createElement('button', li, 'Approve', ['action-btn', 'approve']);
Object.values(inputDOMSelectors).map((input) => input.value = '');

editBtn.addEventListener("click", editPostInformationHandler);
approveBtn.addEventListener("click", appendToUploadedPostsHandler)

}else {
  console.log('PLEASE FILL ALL INPUT FIELDS!!!')
}
}

function appendToUploadedPostsHandler(){
  otherDOMSelectors.publishListContainer.appendChild(this.parentNode);
  this.previousSibling.remove();
  this.remove();
}

function editPostInformationHandler(){
  for (const key in postInfoStatus) {
    inputDOMSelectors[key].value = postInfoStatus[key];
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

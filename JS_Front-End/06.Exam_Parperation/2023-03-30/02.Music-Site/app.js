window.addEventListener('load', solve);

function solve() {
   let likesCounter = 0; 

 const inputDOMSelectors = {
    genre: document.getElementById('genre'),
    name: document.getElementById('name'),
    author: document.getElementById('author'),
    creationDate: document.getElementById('date'),
 }   

 const otherDOMSelectors = {
    addBtn: document.getElementById('add-btn'),
    allHitsContainer: Array.from(document.getElementsByClassName('all-hits-container'))[0],
    savedHitContainer: Array.from(document.getElementsByClassName('saved-container'))[0],
    likesContainerParagraph: document.querySelector("#total-likes > div > p"),
    totalLikesContainer: document.getElementById('total-likes'),
 }

otherDOMSelectors.addBtn.addEventListener('click', addSongHandler);

console.log(otherDOMSelectors.likesContainerParagraph);


function addSongHandler(event){   
    if(event){
        event.preventDefault();
    }

    const allFieldsHaveInputs = Object.values(inputDOMSelectors)
            .every((input) => input.value !== '');

    if(allFieldsHaveInputs){
    const hitsInfoContainer = createElement('div', otherDOMSelectors.allHitsContainer, null, ['hits-info']);
    createElement('img', hitsInfoContainer, null, null, null, {src: './static/img/img.png'});
    createElement('h2', hitsInfoContainer, `Genre: ${inputDOMSelectors.genre.value}`);
    createElement('h2', hitsInfoContainer, `Name: ${inputDOMSelectors.name.value}`);
    createElement('h2', hitsInfoContainer, `Author: ${inputDOMSelectors.author.value}`);
    createElement('h3', hitsInfoContainer, `Date: ${inputDOMSelectors.creationDate.value}`);
    const saveBtn = createElement('button', hitsInfoContainer, 'Save song', ['save-btn']);
    const likeBtn = createElement('button', hitsInfoContainer, 'Like song', ['like-btn']);
    const deleteBtn = createElement('button', hitsInfoContainer, 'Delete', ['delete-btn']);
  
    likeBtn.addEventListener('click', likeSongHandler);
    saveBtn.addEventListener('click', saveSongsHandler);    
    deleteBtn.addEventListener('click', deleteSongHandler);
    

    }
}

function deleteSongHandler(event){
   const songContainer =  event.currentTarget.parentNode;
   const songContainerParentNode = songContainer.parentNode;
   songContainerParentNode.removeChild(songContainer);
}

function saveSongsHandler(event){
    const parentContainer = event.currentTarget.parentNode;
    const nextSiblingToSaveBtn = Array.from(parentContainer.getElementsByClassName('like-btn'))[0];
    console.log(parentContainer);
    parentContainer.removeChild(event.currentTarget);
    parentContainer.removeChild(nextSiblingToSaveBtn);

    otherDOMSelectors.savedHitContainer.appendChild(parentContainer);
}

function likeSongHandler(event){
    likesCounter ++;
    otherDOMSelectors.likesContainerParagraph.textContent = `Total Likes: ${likesCounter}`;
    event.currentTarget.setAttribute('disabled', true);
}










function createElement( type, parentNode, content, classes, id, attributes, useInnerHTML){
    const htmlElement = document.createElement(type);

    if(content && useInnerHTML){
        htmlElement.innerHTML = content;
    }

    if(content && type === 'input'){
        htmlElement.value = content;
    }

    if(content && type!== 'input'){
        htmlElement.textContent = content;
    }

    if(classes && classes.length > 0){
        htmlElement.classList.add(...classes);
    }

    if(id){
        htmlElement.id = id;
    }

    if(attributes){
        for (const key in attributes) {
            htmlElement.setAttribute(key, attributes[key]);
          }
    }

    if(parentNode){
        parentNode.appendChild(htmlElement);
    }

    return htmlElement;
}
}
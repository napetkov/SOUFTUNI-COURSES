function create(words) {
   const content = document.getElementById('content');

   words.forEach((word) => {
         const newDiv = document.createElement('div');
         const newParagraph = document.createElement('p');
         newParagraph.textContent = word;
         newParagraph.style.display = 'none';
         newDiv.appendChild(newParagraph);
         content.appendChild(newDiv);
         // newDiv.addEventListener('click', () =>{
         //    newParagraph.style.display = 'block';
         // });
   
         newDiv.addEventListener('click', clickHandler);

      });  
function clickHandler(event){
   event.currentTarget.children[0].style.display = 'block'; //.firstChild
}

}
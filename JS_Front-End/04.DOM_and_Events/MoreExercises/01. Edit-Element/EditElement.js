function editElement(htmlElement, strToReplace, text) {
       let textElement = htmlElement.textContent;
       
       while(textElement.includes(strToReplace)){
              textElement = textElement.replace(strToReplace,text);
       }
       htmlElement.textContent = textElement;
}
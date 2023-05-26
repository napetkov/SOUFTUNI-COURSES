function focused() {
    const elements = Array.from(document.querySelectorAll('div > div > input'));
    
    console.log(elements);

    elements.forEach((element) => {
        element.addEventListener('focus', focusHandler);
        element.addEventListener('blur',focusHandler);
    });

    function focusHandler(e){
     e.currentTarget.parentElement.classList.toggle('focused');
    }
}
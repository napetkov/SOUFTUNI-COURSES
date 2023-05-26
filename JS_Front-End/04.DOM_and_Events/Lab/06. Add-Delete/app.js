function addItem() {
    const ulContainer = document.getElementById('items');
    const input = document.getElementById('newItemText');
    let newLi = document.createElement('li');
    let newAnchor = document.createElement('a');
    newAnchor.textContent = '[Delete]';
    newAnchor.href = '#';
    newLi.textContent = input.value;
    newLi.appendChild(newAnchor);
    ulContainer.appendChild(newLi);
    input.value = '';

    newAnchor.addEventListener('click' , deleteHandler);

    function deleteHandler(e){
        e.currentTarget.parentElement.remove();
    }
}
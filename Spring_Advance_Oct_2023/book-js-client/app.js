let reloadBooksButton = document.getElementById('reloadBooks');

reloadBooksButton.addEventListener('click', reloadBooks)

function reloadBooks() {
    let booksContainer = document.getElementById('books-container');
    booksContainer.innerHTML = '';

    fetch('http://localhost:8080/api/books')
        .then(response => response.json())
        .then(json => json.forEach(book => {

            let bookRow = document.createElement('tr');



            let titleCol = document.createElement('td');
            let authorCol = document.createElement('td');
            let isbnCol = document.createElement('td');
            let actionCol = document.createElement('td');

            titleCol.textContent = book.title;
            authorCol.textContent = book.author.name;
            isbnCol.textContent = book.isbn;

            let deleteButton = document.createElement('button');
            deleteButton.textContent = 'DELETE';
            deleteButton.dataset.id = book.id;
            deleteButton.addEventListener('click',deleteBtnClicked)
            actionCol.appendChild(deleteButton);

            bookRow.appendChild(titleCol);
            bookRow.appendChild(authorCol);
            bookRow.appendChild(isbnCol);
            bookRow.appendChild(actionCol);

            booksContainer.append(bookRow);

        }))
}

function deleteBtnClicked(event){
    let bookId = event.target.dataset.id;
    let requestOption = {
        method: 'DELETE'
    }

    fetch(`http://localhost:8080/api/books/${bookId}`,requestOption)
        .then(_ => reloadBooks())
        .catch(error => console.log('error',error))
}
function attachEvents() {
  const bookContainer = document.querySelector("table > tbody");
  const BASE_URL = "http://localhost:3030/jsonstore/collections/books/";
  const loadBooks = document.getElementById("loadBooks");
  const createBook = document.querySelector("#form > button");
  const formTitle = document.querySelector("#form > h3");
  const submitBtn = document.querySelector("#form > button");
  const inputs = Array.from(document.querySelectorAll("#form > input"));
  let editBookId = "";

  loadBooks.addEventListener("click", loadAllBooksHandler);
  createBook.addEventListener("click", createBookHandler);

  async function loadAllBooksHandler() {
    bookContainer.innerHTML = "";

    const booksRes = await fetch(BASE_URL, { method: "GET" });
    const booksData = await booksRes.json();
    for (const bookId in booksData) {
      const { author, title } = booksData[bookId];
      const tableRow = document.createElement("tr");
      const titleColumn = document.createElement("td");
      const authorColumn = document.createElement("td");
      const buttonsColumn = document.createElement("td");
      const editBtn = document.createElement("button");
      editBtn.textContent = "Edit";
      editBtn.id = bookId;
      const deleteBtn = document.createElement("button");
      deleteBtn.textContent = "Delete";
      deleteBtn.id = bookId;
      buttonsColumn.appendChild(editBtn);
      buttonsColumn.appendChild(deleteBtn);
      deleteBtn.addEventListener("click", deleteBookHandler);
      editBtn.addEventListener("click", editBookHandler);

      function editBookHandler() {
        editBookId = this.id;
        formTitle.textContent = "Edit FORM";
        submitBtn.textContent = "Save";

        inputs[0].value = title;
        inputs[1].value = author;
      }

      titleColumn.textContent = title;
      authorColumn.textContent = author;
      tableRow.appendChild(titleColumn);
      tableRow.appendChild(authorColumn);
      tableRow.appendChild(buttonsColumn);
      bookContainer.appendChild(tableRow);
    }
  }

  function createBookHandler() {
    let url = BASE_URL;
    const title = inputs[0].value;
    const author = inputs[1].value;
    const headerHTML = {
      method: "POST",
      body: JSON.stringify({ author, title }),
    };

    if (formTitle.textContent === "Edit FORM") {
      headerHTML.method = "PUT";
      url = BASE_URL + editBookId;
    }

    fetch(url, headerHTML)
      .then((res) => res.json())
      .then(loadAllBooksHandler)
      .catch((err) => console.error(err));
      
    inputs.forEach((input) => (input.value = ""));

    if (formTitle.textContent === "Edit FORM") {
      formTitle.textContent = 'FORM';
      submitBtn.textContent = 'Submit';
      url = BASE_URL;
    }
    
  }

  function deleteBookHandler(event) {
    const bookId = event.target.id;

    fetch(`${BASE_URL}${bookId}`, { method: "DELETE" })
      .then((res) => res.json())
      .then(loadAllBooksHandler)
      .catch((err) => console.error(err));
  }
}

attachEvents();

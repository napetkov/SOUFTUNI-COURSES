function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/phonebook";
  const BASE_URL_TO_DELETE = 'http://localhost:3030/jsonstore/phonebook/';
  const phoneBookUl = document.getElementById("phonebook");
  const loadBtn = document.getElementById("btnLoad");
  const createBtn = document.getElementById("btnCreate");
  const inputName = document.getElementById("person");
  const inputPhone = document.getElementById("phone");

  loadBtn.addEventListener("click", loadHandler);

  async function loadHandler() {
    try {
      const phoneBookRes = await fetch(BASE_URL, { method: "GET" });
      let phoneBookData = await phoneBookRes.json();
      phoneBookData = Object.values(phoneBookData);
      phoneBookUl.innerHTML = "";
      for (const { phone, person, _id } of phoneBookData) {
        const li = document.createElement("li");
        li.textContent = `${person}: ${phone}`;
        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.id = _id;
        phoneBookUl.appendChild(li).appendChild(deleteBtn);
        deleteBtn.addEventListener('click', deletePhoneNumberHandler);
      
      }
    } catch (err) {
      console.error(err);
    }
  }

  createBtn.addEventListener("click", createHandler);

  function deletePhoneNumberHandler() {
    const id = this.id;
    fetch(`${BASE_URL_TO_DELETE}${id}`, {method: 'DELETE'})
    .then((res) => res.json)
    .then(loadHandler)
    .catch((err) => console.error(err));
  }

  function createHandler() {
    const person = inputName.value;
    const phone = inputPhone.value;
    const httpHeader = {
      method: "POST",
      body: JSON.stringify({ person, phone }),
    };

    fetch(BASE_URL, httpHeader)
      .then((res) => res.json)
      .then(() => {
        loadHandler();
        inputName.value = "";
        inputPhone.value = "";
      })
      .catch((err) => console.error(err));
  }
}

attachEvents();

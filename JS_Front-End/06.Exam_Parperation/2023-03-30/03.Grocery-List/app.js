function solve() {
  const BASE_URL = "http://localhost:3030/jsonstore/grocery/";
  const addBtn = document.getElementById("add-product");
  const updateBtn = document.getElementById("update-product");
  const loadBtn = document.getElementById("load-product");
  const tbody = document.getElementById("tbody");
  let allProducts = [];
  let productToEdit = {};
  const inputFields = {
    product: document.getElementById("product"),
    count: document.getElementById("count"),
    price: document.getElementById("price"),
   // _id: "",
  };

  loadBtn.addEventListener("click", loadAllProductsHandler);
  addBtn.addEventListener("click", addProductHandler);
  updateBtn.addEventListener("click", updateProductHandler);

  function updateProductHandler() {
       
    const httpHeader = {
            method: 'PATCH',
            body: JSON.stringify({
                product: inputFields.product.value,
                count: inputFields.count.value,
                price: inputFields.price.value,
            }),
        }

        fetch(`${BASE_URL}${productToEdit._id}`,httpHeader)
            .then(() => loadAllProductsHandler())
            .catch((err) => console.error(err));

       Object.values(inputFields).map((input) => input.value = '');
       updateBtn.setAttribute("disabled", true);
       addBtn.removeAttribute("disabled");
  }

  function loadAllProductsHandler(event) {
    if (event) {
      event.preventDefault();
    }

    tbody.innerHTML = "";

    fetch(BASE_URL)
      .then((res) => res.json())
      .then((data) => {
        allProducts = Object.values(data);

        for (const { product, count, price, _id } of allProducts) {
          const tr = createElement("tr", tbody, null, null, _id);
          createElement("td", tr, product, ["name"]);
          createElement("td", tr, count, ["count-product"]);
          createElement("td", tr, price, ["product-price"]);
          const btnColumn = createElement("td", tr, null, ["btn"]);
          const updateBtn = createElement("button", btnColumn, "Update", [
            "update",
          ]);
          const deleteBtn = createElement("button", btnColumn, "Delete", [
            "delete",
          ]);

          deleteBtn.addEventListener("click", deleteProductHandler);
          updateBtn.addEventListener("click", updateInputFieldsHandler);
        }
      });
  }

  function updateInputFieldsHandler(event) {
    const trParent = event.currentTarget.parentNode.parentNode;
    const id = trParent.id;
    productToEdit = allProducts.find((p) => p._id === id);
   for (const key in inputFields) {
    inputFields[key].value = productToEdit[key];
   }

   updateBtn.removeAttribute("disabled");
   addBtn.setAttribute("disabled", true);

  }

  function deleteProductHandler(event) {
    const trParent = event.currentTarget.parentNode.parentNode;
    fetch(`${BASE_URL}${trParent.id}`, { method: "DELETE" })
      .then(() => loadAllProductsHandler())
      .catch((err) => console.error(err));

    tbody.removeChild(trParent);
  }

  function addProductHandler(event) {
    if (event) {
      event.preventDefault();
    }

    const httpHeader = {
      method: "POST",
      body: JSON.stringify({
        product: inputFields.product.value,
        count: inputFields.count.value,
        price: inputFields.price.value,
      }),
    };

    fetch(BASE_URL, httpHeader)
      .then(() => loadAllProductsHandler())
      .catch((err) => console.error(err));

    Object.values(inputFields).map((input) => (input.value = ""));
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

solve();

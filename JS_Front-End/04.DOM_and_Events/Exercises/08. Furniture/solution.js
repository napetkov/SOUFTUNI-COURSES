function solve() {
  const [generateTextArea, buyTextArea] = Array.from(
    document.getElementsByTagName("textarea")
  );

  const [generateBtn, buyBtn] = Array.from(
    document.getElementsByTagName("button")
  );

  const tbody = document.querySelector(".table > tbody");

  generateBtn.addEventListener("click", generateHandler);
  buyBtn.addEventListener("click", buyHandler);

  function generateHandler() {
    const data = JSON.parse(generateTextArea.value);

    for (const { img, name, price, decFactor } of data) {
      const tableRow = createElement("tr", "", tbody);
      const tableFirstColumn = createElement("td", "", tableRow);
      createElement("img", "", tableFirstColumn, "", "", { src: img });
      const tableSecondColumn = createElement("td", "", tableRow);
      createElement("p", name, tableSecondColumn);
      const tableThirdColumn = createElement("td", "", tableRow);
      createElement("p", price, tableThirdColumn);
      const tableForthColumn = createElement("td", "", tableRow);
      createElement("p", decFactor, tableForthColumn);
      const tableFifthColumn = createElement("td", "", tableRow);
      createElement("input", "", tableFifthColumn, "", "", {
        type: "checkbox",
      });
    }
  }

  function buyHandler() {
    const allCheckedItems = document.querySelectorAll("tbody tr input:checked");

    buyBtn.addEventListener("click", buyHandler);
    let boughtItems = [];
    let totalPrice = 0;
    let totalDecFactor = 0;

    for (const input of allCheckedItems) {
      const row = input.parentNode.parentNode;
      [_firstColumn, secondColumn, thirdColumn, forthColumn] = Array.from(
        row.children
      );

      let name = secondColumn.children[0].textContent;
      boughtItems.push(name);
      let currentPrice = Number(thirdColumn.children[0].textContent);
      totalPrice += currentPrice;
      let currentDecFactor = Number(forthColumn.children[0].textContent);
      totalDecFactor += currentDecFactor;
    }

    buyTextArea.value += `Bought furniture: ${boughtItems.join(", ")}\n`;
    buyTextArea.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    buyTextArea.value += `Average decoration factor: ${
      totalDecFactor / allCheckedItems.length
    }`;
  }

  function createElement(type, content, parentNode, id, classes, attributes) {
    const htmlElement = document.createElement(type);

    if (content && type !== "input") {
      htmlElement.textContent = content;
    }

    if (content && type === "input") {
      htmlElement.value = content;
    }

    if (id) {
      htmlElement.id = id;
    }

    if (classes) {
      htmlElement.classList.add(...classes);
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

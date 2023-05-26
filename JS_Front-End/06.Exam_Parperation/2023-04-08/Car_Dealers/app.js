window.addEventListener("load", solve);

function solve() {
  const inputDOMSelectors = {
    make: document.getElementById('make'),
    model: document.getElementById('model'),
    productionYear: document.getElementById('year'),
    fuelType: document.getElementById('fuel'),
    originalCost: document.getElementById('original-cost'),
    sellingPrice: document.getElementById('selling-price'),
  }

  const otherDOMSelectors = {
    publishBtn: document.getElementById('publish'),
    tbody: document.getElementById('table-body'),
    ulCarList: document.getElementById('cars-list'),
    totalProfit: document.getElementById('profit'),
  }
  
  const carInfoStatus = {
    make: null,
    model: null,
    productionYear: null,
    fuelType: null,
    originalCost: null,
    sellingPrice: null,
  }

  let totalProfit = 0;
  otherDOMSelectors.publishBtn.addEventListener('click',publishCarInfoHandler);

  function publishCarInfoHandler(event){
    if(event){
      event.preventDefault();
    }
    const noInputFieldEmpty = Object.values(inputDOMSelectors).every((input) => input.value !== '');

    if(noInputFieldEmpty 
      && Number(inputDOMSelectors.originalCost.value) < Number(inputDOMSelectors.sellingPrice.value)){
        const tr = createElement('tr', otherDOMSelectors.tbody, null, ['row']);
        createElement('td', tr, inputDOMSelectors.make.value);
        createElement('td', tr, inputDOMSelectors.model.value);
        createElement('td', tr, inputDOMSelectors.productionYear.value);
        createElement('td', tr, inputDOMSelectors.fuelType.value);
        createElement('td', tr, inputDOMSelectors.originalCost.value);
        createElement('td', tr, inputDOMSelectors.sellingPrice.value);
        const btnContainer = ('td', tr);
        const editBtn = createElement('button', btnContainer, 'Edit', ['action-btn', 'edit']);
        const sellBtn = createElement('button', btnContainer, 'Sell', ['action-btn', 'sell']);

        editBtn.addEventListener('click', editCarInfoHandler);
        sellBtn.addEventListener('click', sellCarHandler);

        for (const key in inputDOMSelectors) {
         carInfoStatus[key] = inputDOMSelectors[key].value;
        }
        Object.values(inputDOMSelectors).map((input) => input.value = '');
    }else {
      console.log('PLEASE FILL ALL INPUT FIELDS');
    }
  }


  function editCarInfoHandler(){
    for (const key in carInfoStatus) {
      inputDOMSelectors[key].value = carInfoStatus[key];
    }
    this.parentNode.remove();
  }

  function sellCarHandler(){
    const tbody = this.parentNode;
    const make = tbody.children[0].textContent;
    const model = tbody.children[1].textContent;
    const year = tbody.children[2].textContent;
    const profit = Number(tbody.children[5].textContent) - Number(tbody.children[4].textContent);
    totalProfit += profit;
    const li = createElement('li', otherDOMSelectors.ulCarList, null, ['each-list']);
    createElement('span', li, `${make} ${model}`);
    createElement('span', li, `${year}`);
    createElement('span', li, `${profit}`);

    otherDOMSelectors.totalProfit.textContent = `${totalProfit.toFixed(2)}`;
    tbody.remove();
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

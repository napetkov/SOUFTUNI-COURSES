window.addEventListener("load", solve);

function solve() {
  const inputDOMSelectors = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById("last-name"),
    peopleCount: document.getElementById("people-count"),
    date: document.getElementById("from-date"),
    daysCount: document.getElementById("days-count"),
  };

  let statusTicketInfo = {
    firstName: null,
    lastName: null,
    peopleCount: null,
    date: null,
    daysCount: null,
  };

  const otherDomSelectors = {
    nextBtn: document.getElementById("next-btn"),
    inputForm: document.querySelector("#append-ticket > div > div > form"),
    ticketInfoContainer:document.querySelector(
        "#info-ticket > div > div > ul > li"
      ),
    ticketPreviewContainer: document.querySelector(
      "#info-ticket > div > div > ul"
    ),
    ticketConfirmContainer: document.querySelector("#confirm-ticket-section > div > div > ul"),
    mainContainer: document.getElementById('main'),
    documentBody: document.getElementById('body'),
  };

  otherDomSelectors.nextBtn.addEventListener("click", loadInfoTicket);

  function loadInfoTicket(event) {
    if (event) {
      event.preventDefault();
    }
    const allInputFieldIsNotEmpty = Object.values(inputDOMSelectors).every(
      (input) => input.value !== ""
    );

    if (allInputFieldIsNotEmpty) {
      const {
        firstName,
        lastName,
        peopleCount,
        date,
        daysCount,
      } = inputDOMSelectors;

      const liContainer = createElement(
        "li",
        otherDomSelectors.ticketPreviewContainer,
        null,
        ["ticket"]
      );
      const article = createElement("article", liContainer);
      createElement(
        "h3",
        article,
        `Name: ${firstName.value} ${lastName.value}`
      );
      createElement("p", article, `Fom date: ${date.value}`);
      createElement("p", article, `For ${daysCount.value} days`);
      createElement("p", article, `For ${peopleCount.value} people`);
      const editBtn = createElement("button", liContainer, "Edit", [
        "edit-btn",
      ]);
      const continueBtn = createElement("button", liContainer, "Continue", [
        "continue-btn",
      ]);

      continueBtn.addEventListener('click',continueTicketReservation);
      editBtn.addEventListener("click", editTicketInfoHandler);

      for (const key in inputDOMSelectors) {
        statusTicketInfo[key] = inputDOMSelectors[key].value;
      }

      otherDomSelectors.inputForm.reset();
      otherDomSelectors.nextBtn.setAttribute("disabled", true);
    } else {
      console.log("INVALID INPUT");
    }
  }

  function continueTicketReservation(event){
    
    const ticketInfoContainer = event.currentTarget.parentNode;
    otherDomSelectors.ticketConfirmContainer.appendChild(ticketInfoContainer);
    const liParent = this.parentNode;
    
    const confirmBtn = createElement('button', liParent, 'Confirm', ['confirm-btn']);
    const cancelBtn = createElement('button',liParent, 'Cancel', ['confirm-btn']);
    
    cancelBtn.addEventListener('click', cancelReservationHandler);
    confirmBtn.addEventListener('click', confirmReservationHandler);
    
    this.previousSibling.remove();
    this.remove();
  }

  function confirmReservationHandler(){
    otherDomSelectors.mainContainer.remove();
    createElement('h1', otherDomSelectors.documentBody, 'Thank you, have a nice day!', null, 'thank-you');
    const backBtn = createElement('button', otherDomSelectors.documentBody, 'Back', null, 'back-btn');

    backBtn.addEventListener('click', reloadPageHandler);
  }

  function reloadPageHandler(){
    location.reload();
  }

  function cancelReservationHandler(){
    const ticketInfoContainerForRemove = this.parentNode;
    ticketInfoContainerForRemove.remove();
    otherDomSelectors.nextBtn.removeAttribute('disabled');
  }

  function editTicketInfoHandler() {
    for (const key in statusTicketInfo) {
      inputDOMSelectors[key].value = statusTicketInfo[key];
    }
    otherDomSelectors.ticketPreviewContainer.innerHTML = "";
    otherDomSelectors.nextBtn.removeAttribute("disabled");
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

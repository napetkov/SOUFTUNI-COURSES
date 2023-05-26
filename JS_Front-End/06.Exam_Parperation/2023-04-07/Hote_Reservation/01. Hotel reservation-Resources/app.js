window.addEventListener('load', solve);

function solve() {

    const inputDOMSelectors = {
        firstName: document.getElementById('first-name'),
        lastName: document.getElementById('last-name'),
        dateIn: document.getElementById('date-in'),
        dateOut: document.getElementById('date-out'),
        peopleCount: document.getElementById('people-count'),
    }

    const otherDOMSelectors = {
        nextBtn: document.getElementById('next-btn'),
        ulInfoList: document.querySelector("#info-reservations > div > div > ul"),
        ulConfirmList: document.querySelector("#confirm-reservations > div > div > ul"),
        h1ConfirmReservation: document.querySelector("#verification"),
    }

    let reservationInfoStatus = {
        firstName: null,
        lastName: null,
        dateIn: null,
        dateOut: null,
        peopleCount: null,
    }

    otherDOMSelectors.nextBtn.addEventListener('click', loadReservationInfoHandler);

    function loadReservationInfoHandler(event){
        if(event){
            event.preventDefault();
        }

        const noInputFieldsEmpty = Object.values(inputDOMSelectors)
                .every((input) => input.value !== '');

       if(inputDOMSelectors.dateIn.value < inputDOMSelectors.dateOut.value && noInputFieldsEmpty){
            for (const key in inputDOMSelectors) {
              reservationInfoStatus[key] = inputDOMSelectors[key].value;
            }  

          const {firstName, lastName, dateIn, dateOut, peopleCount} = inputDOMSelectors;

          const li = createElement('li', otherDOMSelectors.ulInfoList, null, ['reservation-content']);
          const article = createElement('article', li);
          createElement('h3', article, `Name: ${firstName.value} ${lastName.value}`);
          createElement('p', article, `From date: ${dateIn.value}`);
          createElement('p', article, `To date: ${dateOut.value}`);
          createElement('p', article, `For ${peopleCount.value} people`);
          const editBtn = createElement('button', li, 'Edit', ['edit-btn']);
          const continueBtn = createElement('button', li, 'Continue', ['continue-btn']);        

          editBtn.addEventListener('click', editReservationDetailsHandler);
          continueBtn.addEventListener('click', continueReservationHandler);

          
        Object.values(inputDOMSelectors).map((input) => input.value = '');
        otherDOMSelectors.nextBtn.setAttribute('disabled', true);
        } else {
           console.log('FILL ALL FIELDS');
       }
    }

    function continueReservationHandler(){
        const liParent = this.parentNode;
        otherDOMSelectors.ulConfirmList.appendChild(liParent);
        this.remove();
        liParent.children[1].remove();

        const confirmBtn = createElement('button', liParent, 'Confirm', ['confirm-btn']);
        const cancelBtn = createElement('button', liParent, 'Cancel',['cancel-btn']);
        
        confirmBtn.addEventListener('click', confirmReservationHandler);
        cancelBtn.addEventListener('click', cancelReservationHandler);


    }

    function cancelReservationHandler(){
        otherDOMSelectors.h1ConfirmReservation.classList.add(['reservation-cancelled']);
        otherDOMSelectors.h1ConfirmReservation.textContent = 'Cancelled.';

        this.parentNode.remove();
        otherDOMSelectors.nextBtn.removeAttribute('disabled');
    }

    function confirmReservationHandler(){
        otherDOMSelectors.h1ConfirmReservation.classList.add(['reservation-confirmed']);
        otherDOMSelectors.h1ConfirmReservation.textContent = 'Confirmed.';

        this.parentNode.remove();
        otherDOMSelectors.nextBtn.removeAttribute('disabled');
    }

    function editReservationDetailsHandler(){
        for (const key in reservationInfoStatus) {
           inputDOMSelectors[key].value = reservationInfoStatus[key];
        }
        otherDOMSelectors.nextBtn.removeAttribute('disabled');
        otherDOMSelectors.ulInfoList.innerHTML = '';       
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



    
    

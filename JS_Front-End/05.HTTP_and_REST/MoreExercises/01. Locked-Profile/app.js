function lockedProfile() {
  const BASE_URL = "http://localhost:3030/jsonstore/advanced/profiles/";
  const main = document.getElementById("main");

  main.innerHTML = "";
  let usersCount = 1;
  fetch(BASE_URL)
    .then((res) => res.json())
    .then((data) => {
      const people = Object.values(data);

      for (const person of people) {
        const { username, email, age } = person;

        const cardContainer = createElement("div", main, null, ["profile"], usersCount);
        createElement("img", cardContainer, null, ["userIcon"], null, {
          src: "./iconProfile2.png",
        });
        createElement("label", cardContainer, "Lock");
        const radioLock = createElement(
          "input",
          cardContainer,
          null,
          null,
          null,
          {
            type: "radio",
            name: `user${usersCount}Locked`,
            checked: true,
          }
        );
        radioLock.value = "lock";
        createElement("label", cardContainer, "Unlock");
        const radioUnlock = createElement(
          "input",
          cardContainer,
          null,
          null,
          null,
          {
            type: "radio",
            name: `user${usersCount}Locked`,
          }
        );
        radioUnlock.value = "unlock";
        createElement("br", cardContainer);
        createElement("hr", cardContainer);

        createElement("label", cardContainer, "Username");
        createElement("input", cardContainer, null, null, null, {
          type: "text",
          name: `user${usersCount}Username`,
          value: username,
          disabled: "readonly",
        });
        const divHiddenFields = createElement(
          "div",
          cardContainer,
          null,
          null,
          `user${usersCount}HiddenFields`
        );
        createElement("hr", divHiddenFields);
        createElement("label", divHiddenFields, "Email:");
        createElement("input", divHiddenFields, null, null, null, {
          type: "email",
          name: `user${usersCount}Email`,
          value: email,
          disabled: "readonly",
        });
        createElement("label", divHiddenFields, "Age:");
        createElement("input", divHiddenFields, null, null, null, {
          type: "email",
          name: `user${usersCount}Age`,
          value: age,
          disabled: "readonly",
        });
        divHiddenFields.style.display = 'none';
        const showBtn = createElement('button', cardContainer, 'Show more');

        showBtn.addEventListener('click', showAndHideInfoHandler);

        usersCount++;
      }
    })
    .catch((err) => console.error(err));
}

function showAndHideInfoHandler(event){
        const divHidden = event.currentTarget.previousSibling;
        const eventBtn = event.currentTarget; 
        const children = eventBtn.parentNode.children;
            const inputUnlock = children[4];

            if(inputUnlock.checked){
         if(eventBtn.textContent === 'Hide it'){
            divHidden.style.display = 'none';
            event.currentTarget.textContent = 'Show more';
        }else{
            divHidden.style.display = 'block';
            event.currentTarget.textContent = 'Hide it';
        }
    }


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

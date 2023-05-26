function solution() {
  const main = document.getElementById("main");
  const BASE_URL_TITLE =
    "http://localhost:3030/jsonstore/advanced/articles/list/";
  const BASE_URL_INFO =
    "http://localhost:3030/jsonstore/advanced/articles/details/";

  fetch(BASE_URL_TITLE)
    .then((res) => res.json())
    .then((data) => {
      const articles = Object.values(data);

      for (const article of articles) {
        const { _id, title } = article;

        const divAccordion = createElement("div", main, null, ["accordion"]);
        const divHead = createElement("div", divAccordion, null, ["head"]);
        createElement("span", divHead, title);
        const showBtn = createElement(
          "button",
          divHead,
          "More",
          ["button"],
          _id
        );
        showBtn.addEventListener("click", showMoreLessDetailsHandler);

        fetch(`${BASE_URL_INFO}${_id}`)
          .then((res) => res.json())
          .then((data) => {
            const { _id, title, content } = data;
            const divExtra = createElement("div", divAccordion, null, [
              "extra",
            ]);
            createElement("p", divExtra, content);
          })
          .catch((err) => console.error(err));
      }
    })
    .catch((err) => console.error(err));

  function showMoreLessDetailsHandler(event) {
    const btn = event.currentTarget;
    const btnContent = btn.textContent;
    const divExtra = btn.parentNode.parentNode.children[1];

    if (btnContent === "More") {
      divExtra.style.display = "block";
      btn.textContent = "Less";
    } else {
      divExtra.style.display = "none";
      btn.textContent = "More";
    }
  }
}

solution();

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

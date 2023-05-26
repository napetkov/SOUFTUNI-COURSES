function attachEvents() {
  const BASE_URL_POSTS = "http://localhost:3030/jsonstore/blog/posts/";
  const BASE_URL_COMMENTS = "http://localhost:3030/jsonstore/blog/comments/";
  const loadBtn = document.getElementById("btnLoadPosts");
  const selectPostContainer = document.getElementById("posts");
  const viewBtn = document.getElementById('btnViewPost');
  let allPosts = [];
  const postTitle = document.getElementById('post-title');
  const postBody = document.getElementById('post-body');
  const postCommentsUl = document.getElementById('post-comments');

  loadBtn.addEventListener("click", loadAllPostHandler);
  viewBtn.addEventListener('click', viewPostHandler)

  function viewPostHandler(){
    postCommentsUl.innerHTML = "";
    
    const selectedPostId = selectPostContainer.options[selectPostContainer.selectedIndex].value;
    const selectedPost = allPosts.find((post) => post.id === selectedPostId);
    postTitle.textContent = selectedPost.title;
    postBody.textContent = selectedPost.body;
    

    fetch(BASE_URL_COMMENTS)
    .then((res) => res.json())
    .then((data) =>{
        for (const comment of Object.values(data)) {
            const { _id, postId, text} = comment;

            if(postId === selectedPostId){
                createElement('li', postCommentsUl, text);
            }
        }       
    })
    .catch((err) => console.error(err));


  }

  function loadAllPostHandler() {
    fetch(BASE_URL_POSTS)
      .then((res) => res.json())
      .then((data) => {
        for (const post of Object.values(data)) {
            allPosts.push(post);
          const { body, id, title } = post;
          let option = createElement("option", selectPostContainer, title);
          option.value = id;
        }
      })
      .catch((err) => console.error(err));
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

attachEvents();

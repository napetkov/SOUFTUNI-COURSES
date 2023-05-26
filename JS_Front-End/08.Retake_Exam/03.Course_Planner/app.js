function courses(){
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';

    const inputDOMSelectors = {
        title: document.getElementById('course-name'),
        type: document.getElementById('course-type'),
        description: document.getElementById('description'),
        teacher: document.getElementById('teacher-name'),

    }

    const otherDOMSelectors = {
        loadCoursesBtn: document.getElementById('load-course'),
        coursesListContainer: document.getElementById('list'),
        addCourseBtn: document.getElementById('add-course'),
        editCourseBtn: document.getElementById('edit-course'),
    }



    otherDOMSelectors.loadCoursesBtn.addEventListener('click', loadAllCoursesHandler);
    otherDOMSelectors.addCourseBtn.addEventListener('click', addCourseHandler);

    function addCourseHandler(event){
        if(event){
            event.preventDefault();
        }
        const noEmptyInputFields = Object.values(inputDOMSelectors).every((input) => input.value !== '');

        if(noEmptyInputFields){
            httpHeader = {
                method: 'POST',
                body: JSON.stringify({
                    title: inputDOMSelectors.title.value,
                    type: inputDOMSelectors.type.value,
                    description: inputDOMSelectors.description.value,
                    teacher: inputDOMSelectors.teacher.value,
                })
            }

            fetch(BASE_URL,httpHeader)
            .then((res) => res.json)
            .then(() => loadAllCoursesHandler())
            .catch((err) => console.error(err));

            Object.values(inputDOMSelectors).map((input) => input.value = '');
        }else {
            console.log('PLEASE FILL ALL INPUT FIELDS!!!')
        }


    }

    function loadAllCoursesHandler(event){
        if(event){
            event.preventDefault();
        }
        otherDOMSelectors.coursesListContainer.innerHTML = '';
        fetch(BASE_URL)
        .then((res) => res.json())
        .then((data) =>{
            Object.values(data).forEach((course) =>{
               const { description, teacher, title, type, _id} = course;
               const divContainer = createElement('div', otherDOMSelectors.coursesListContainer, null, ['container'], _id);
               createElement('h2', divContainer, title);
               createElement('h3', divContainer, teacher);
               createElement('h3', divContainer, type);
               createElement('h4', divContainer, description);

               const editBtn = createElement('button', divContainer, 'Edit Course', ['edit-btn']);
               editBtn.addEventListener('click', editCourseInfoHandler); 

               const finishBtn = createElement('button', divContainer, 'Finish Course', ['finish-btn']);
               finishBtn.addEventListener('click', finishCourseHandler);

            })
        })
        .catch((err) => console.error(err));


    }

    function finishCourseHandler(){
        const divParent = this.parentNode;
        const courseId = divParent.id;
        
        fetch(`${BASE_URL}${courseId}`,{
            method: 'DELETE',
        })
        .then((res) => res.json())
        .then(() => loadAllCoursesHandler())
        .catch((err) => console.error(err))

    }

    function editCourseInfoHandler(){
        const divParent = this.parentNode;
        const courseId = divParent.id;

        const divChildren = divParent.children;
        console.log(Object.values(divChildren));
        const courseForEdit = {
        title: divChildren[0].textContent,
        teacher: divChildren[1].textContent,
        type: divChildren[2].textContent,
        description: divChildren[3].textContent,
        }

        for (const key in courseForEdit) {
            inputDOMSelectors[key].value = courseForEdit[key];
        }

        otherDOMSelectors.editCourseBtn.disabled = false;
        otherDOMSelectors.addCourseBtn.disabled = true;
        
        otherDOMSelectors.editCourseBtn.addEventListener('click', putRequestWithEditedInfoHandler);

        divParent.remove();

        function putRequestWithEditedInfoHandler(event){
            if(event){
                event.preventDefault();
            }

                
            const httpHeader = {
                method: 'PUT',
                body: JSON.stringify({
                    title: inputDOMSelectors.title.value,
                    type: inputDOMSelectors.type.value,
                    description: inputDOMSelectors.description.value,
                    teacher: inputDOMSelectors.teacher.value,
                })
            }
    
            fetch(`${BASE_URL}${courseId}`,httpHeader)
            .then((res) => res.json())
            .then(() => {
                loadAllCoursesHandler();
                Object.values(inputDOMSelectors).map((input) => input.value = '');
                otherDOMSelectors.addCourseBtn.disabled = false;
                otherDOMSelectors.editCourseBtn.disabled = true;
            })
            .catch((err) => console.error(err));
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
}

courses();
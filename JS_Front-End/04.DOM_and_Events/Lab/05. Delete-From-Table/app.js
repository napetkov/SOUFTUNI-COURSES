function deleteByEmail() {
  const input = document.querySelector('input[name = email]');
  let inputValue = input.value;
let result = document.getElementById('result');
const emails =Array.from(document.querySelectorAll('tr td:nth-child(2)'));
let foundElement = emails.find((td) => td.textContent === inputValue);

    if(foundElement){
        foundElement.parentElement.remove();
        result.textContent = 'Deleted';
    }else{
        result.textContent = 'Not found.';
    }

}
function solve() {
  document.querySelector("#searchBtn").addEventListener("click", onClick);
  const searchInput = document.getElementById("searchField");


  function onClick() {
    const tableRows = Array.from(document.querySelectorAll("tbody > tr"));

    tableRows.forEach((tr) => {
      if(tr.classList.contains('select')){
         tr.classList.remove("select");
      }
      
      if (tr.textContent.includes(searchInput.value)) {
        tr.classList.add("select");
      }
    });

    searchInput.value = '';
  }
}

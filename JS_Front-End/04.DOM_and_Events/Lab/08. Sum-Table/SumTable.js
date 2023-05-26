function sumTable() {
    let sum = 0;
    const totalSum = document.getElementById('sum');
    totalSum.textContent = 0;
    const tdValues = Array.from(document.querySelectorAll('td:nth-child(even)'))
.map((td) => Number(td.textContent));
console.log(tdValues);
sum = tdValues.reduce((first,currentValue) => first +currentValue,0);
totalSum.textContent = sum;
}
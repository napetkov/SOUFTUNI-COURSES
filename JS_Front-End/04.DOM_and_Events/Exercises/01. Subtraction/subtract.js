function subtract() {
  const firstInputNumber = Number(document.getElementById("firstNumber").value);
  const secondInputNumber = Number(document.getElementById("secondNumber").value);
    const result = document.getElementById('result');
    const difference = firstInputNumber - secondInputNumber;
    result.textContent = difference;
}

function signCheck(...numbers) {
  //   let negativeNumbersArr = numbers.filter((num) => num < 0);

  //   if (negativeNumbersArr.length % 2 === 0) {
  //     return "Positive";
  //   } else {
  //     return "Negative";
  //   }
  return numbers
  .filter((num) => num < 0)
  .length % 2 === 0 ?'Positive' :'Negative';
}
console.log(signCheck(-1, -2, -3));

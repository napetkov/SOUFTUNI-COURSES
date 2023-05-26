function sumDigits(number) {
  let sumOfDigits = 0;

  while (number !== 0) {
    sumOfDigits += number % 10;
    number = Math.floor(number/10);
  }

  console.log(sumOfDigits);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);



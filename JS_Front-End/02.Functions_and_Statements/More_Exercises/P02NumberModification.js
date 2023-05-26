function numberModification(number){
let numberToArrOfDigits = number.toString().split('').map((num) => Number(num));
const calcAverageSumOfDigit = (num) => num.reduce((first,second) => first + second,0) / num.length;

let averageSumOfDigits = calcAverageSumOfDigit(numberToArrOfDigits);
   
while(averageSumOfDigits <= 5){
 numberToArrOfDigits.push(9);
 averageSumOfDigits = calcAverageSumOfDigit(numberToArrOfDigits);
}

console.log(numberToArrOfDigits.join(''));
}

numberModification(5835);
numberModification(101);
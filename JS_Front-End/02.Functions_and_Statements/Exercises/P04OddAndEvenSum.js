function oddAndEvenSum(number){

    // let funcToArrayFromDigits = num => Number(num);

    let arrayFromDigits = Array.from(String(number), Number);

    let oddSum = arrayFromDigits
    .filter((digit) => digit % 2 !== 0)
    .reduce((first, second) => first + second , 0);
    
    let evenSum = arrayFromDigits
    .filter((digit) => digit % 2 === 0)
    .reduce((first, second) => first + second , 0);

console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);

}

oddAndEvenSum (3495892137259234);

function perfectNumber(number){

    let divisors = [];

    for (let i = 0; i < number; i++) {
       if(number % i === 0){
        divisors.push(i);
       }
    }

    let sumOfDivisors = divisors.reduce((firstNum,secondNum) => firstNum + secondNum, 0);

    if(number === sumOfDivisors){
        console.log('We have a perfect number!');
    }else {
        console.log('It\'s not so perfect.');
    }

}

perfectNumber(6);
perfectNumber(28);
perfectNumber(1236498);
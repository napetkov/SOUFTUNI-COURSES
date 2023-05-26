function factorialDivision(firstNum,secondNum){

    function factorial(number){
    if(number === 1){
        return 1;
    }
        return number * factorial(number - 1);
    }

    console.log((factorial(firstNum) / factorial(secondNum)).toFixed(2));
}
factorialDivision(6,2);
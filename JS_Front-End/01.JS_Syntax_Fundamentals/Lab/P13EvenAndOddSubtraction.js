function solve(input){

    let sumEven = 0;
    let sumOdd = 0;

    for (let i = 0; i < input.length; i++) {
       let currentNumber = input[i];
       
        if(currentNumber % 2 === 0){
            sumEven += currentNumber;
        }else{
            sumOdd = sumOdd + currentNumber;
        }        
    }

    console.log(sumEven-sumOdd)
}

solve([2,4,6,8,10])
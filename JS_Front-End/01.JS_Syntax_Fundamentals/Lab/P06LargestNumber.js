function solve(num1, num2, num3){
    let arr = [num1, num2, num3];
    let maxNum = Number.MIN_SAFE_INTEGER;

    for (let i = 0; i < arr.length; i++) {
        if(arr[i]>=maxNum){
            maxNum = arr[i];
        }
    }

    console.log(`The largest number is ${maxNum}.`);

}

solve(102, -2, 33);
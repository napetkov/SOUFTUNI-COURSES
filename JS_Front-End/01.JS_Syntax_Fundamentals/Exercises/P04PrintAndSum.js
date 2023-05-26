function solve(startNum, endNum){
let sumNumbers=0;
let arrNumbers = [];

    for (let i = startNum; i <= endNum; i++) {
        arrNumbers.push(i);
        sumNumbers += i;
    }

    console.log(arrNumbers.join(" "));
    console.log("Sum: "+sumNumbers);
}

solve(5, 10);
function sortingNumbers(numbers){

    let sortedNumbers = [...numbers].sort((f,s) => f - s);
     let resultArr = [];
     let index = 0;

    while(sortedNumbers.length > 0){
        if(index % 2 === 0){
            resultArr.push(sortedNumbers.shift());
        }else{
            resultArr.push(sortedNumbers.pop());
        }
        index++;
    }

    return resultArr;
}

console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));